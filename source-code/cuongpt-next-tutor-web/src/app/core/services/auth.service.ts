import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, BehaviorSubject, tap } from 'rxjs';
import { LoginRequest, LoginResponse, User } from '../models/user.model';
import { environment } from '../../../environments/environment';

/**
 * Authentication service for Next Tutor.
 * Handles OAuth2 login, JWT token management, and user state.
 * 
 * @author Next Tutor Team
 * @since 1.0.0
 */
@Injectable({
    providedIn: 'root'
})
export class AuthService {
    private readonly API_URL = `${environment.apiUrl}/api/v1/auth`;
    private readonly TOKEN_KEY = 'next_tutor_token';
    private readonly USER_KEY = 'next_tutor_user';

    private currentUserSubject = new BehaviorSubject<User | null>(this.getUserFromStorage());
    public currentUser$ = this.currentUserSubject.asObservable();

    constructor(private http: HttpClient) { }

    /**
     * Performs OAuth2 login with the specified provider.
     * Stores JWT token and user information on success.
     * 
     * @param request Login request containing provider and access token
     * @returns Observable of login response
     */
    login(request: LoginRequest): Observable<LoginResponse> {
        return this.http.post<LoginResponse>(`${this.API_URL}/login`, request).pipe(
            tap(response => {
                this.setToken(response.token);
                this.setUser(response.user);
                this.currentUserSubject.next(response.user);
            })
        );
    }

    /**
     * Logs out the current user.
     * Clears token and user information from storage.
     */
    logout(): void {
        localStorage.removeItem(this.TOKEN_KEY);
        localStorage.removeItem(this.USER_KEY);
        this.currentUserSubject.next(null);
    }

    /**
     * Gets the current JWT token.
     * 
     * @returns JWT token or null if not authenticated
     */
    getToken(): string | null {
        return localStorage.getItem(this.TOKEN_KEY);
    }

    /**
     * Checks if user is currently authenticated.
     * 
     * @returns True if user has a valid token
     */
    isAuthenticated(): boolean {
        return !!this.getToken();
    }

    /**
     * Gets the current user.
     * 
     * @returns Current user or null if not authenticated
     */
    getCurrentUser(): User | null {
        return this.currentUserSubject.value;
    }

    private setToken(token: string): void {
        localStorage.setItem(this.TOKEN_KEY, token);
    }

    private setUser(user: User): void {
        localStorage.setItem(this.USER_KEY, JSON.stringify(user));
    }

    private getUserFromStorage(): User | null {
        const userJson = localStorage.getItem(this.USER_KEY);
        return userJson ? JSON.parse(userJson) : null;
    }
}
