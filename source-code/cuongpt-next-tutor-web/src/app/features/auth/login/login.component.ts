import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { AuthService } from '../../../core/services/auth.service';
import { LoginRequest } from '../../../core/models/user.model';

/**
 * Login component for OAuth2 authentication.
 * Provides Facebook and Zalo login options as per FR-01.
 * 
 * @author Next Tutor Team
 * @since 1.0.0
 */
@Component({
    selector: 'app-login',
    standalone: true,
    imports: [CommonModule],
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css']
})
export class LoginComponent {
    isLoading = false;
    errorMessage = '';

    constructor(
        private authService: AuthService,
        private router: Router
    ) { }

    /**
     * Handles Facebook login.
     * In production, this would integrate with Facebook SDK.
     */
    loginWithFacebook(): void {
        // TODO: Integrate with Facebook SDK to get access token
        // For now, using mock implementation
        this.performLogin('FACEBOOK', 'mock_facebook_token');
    }

    /**
     * Handles Zalo login.
     * In production, this would integrate with Zalo SDK.
     */
    loginWithZalo(): void {
        // TODO: Integrate with Zalo SDK to get access token
        // For now, using mock implementation
        this.performLogin('ZALO', 'mock_zalo_token');
    }

    /**
     * Performs the login operation with the backend.
     * 
     * @param provider OAuth provider name
     * @param accessToken Access token from provider
     */
    private performLogin(provider: 'FACEBOOK' | 'ZALO', accessToken: string): void {
        this.isLoading = true;
        this.errorMessage = '';

        const request: LoginRequest = { provider, accessToken };

        this.authService.login(request).subscribe({
            next: () => {
                this.router.navigate(['/home']);
            },
            error: (error) => {
                this.errorMessage = 'Đăng nhập thất bại. Vui lòng thử lại.';
                this.isLoading = false;
                console.error('Login error:', error);
            },
            complete: () => {
                this.isLoading = false;
            }
        });
    }
}
