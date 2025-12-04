package com.cuongpt.nexttutor.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Component
public class RC4Utils {

    @Value("${app.security.rc4-key:default-key}")
    private String key;

    public String encrypt(String data) {
        return Base64.getEncoder()
                .encodeToString(rc4(data.getBytes(StandardCharsets.UTF_8), key.getBytes(StandardCharsets.UTF_8)));
    }

    public String decrypt(String data) {
        return new String(rc4(Base64.getDecoder().decode(data), key.getBytes(StandardCharsets.UTF_8)),
                StandardCharsets.UTF_8);
    }

    private byte[] rc4(byte[] data, byte[] key) {
        int[] s = new int[256];
        for (int i = 0; i < 256; i++) {
            s[i] = i;
        }
        int j = 0;
        for (int i = 0; i < 256; i++) {
            j = (j + s[i] + (key[i % key.length] & 0xFF)) & 0xFF;
            int temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }

        byte[] result = new byte[data.length];
        int i = 0;
        j = 0;
        for (int k = 0; k < data.length; k++) {
            i = (i + 1) & 0xFF;
            j = (j + s[i]) & 0xFF;
            int temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            result[k] = (byte) (data[k] ^ s[(s[i] + s[j]) & 0xFF]);
        }
        return result;
    }
}
