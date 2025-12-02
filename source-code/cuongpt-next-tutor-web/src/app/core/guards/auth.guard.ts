import { inject } from '@angular/core';
import { Router, CanActivateFn } from '@angular/router';
import { AuthService } from '../services/auth.service';

/**
 * Route guard that protects routes requiring authentication.
 * Redirects to login page if user is not authenticated.
 * 
 * @param route The activated route snapshot
 * @param state The router state snapshot
 * @returns True if user is authenticated, otherwise redirects to login
 */
export const authGuard: CanActivateFn = (route, state) => {
    const authService = inject(AuthService);
    const router = inject(Router);

    if (authService.isAuthenticated()) {
        return true;
    }

    router.navigate(['/login']);
    return false;
};
