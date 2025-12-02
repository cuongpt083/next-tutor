/**
 * User model interface.
 * Represents a user in the Next Tutor system.
 */
export interface User {
    id: string;
    displayName: string;
    avatarUrl: string;
    role: string;
}

/**
 * Login request interface.
 * Used for OAuth2 authentication.
 */
export interface LoginRequest {
    provider: 'FACEBOOK' | 'ZALO';
    accessToken: string;
}

/**
 * Login response interface.
 * Contains JWT token and user information.
 */
export interface LoginResponse {
    token: string;
    user: User;
}
