import { HttpInterceptorFn } from '@angular/common/http';
import { inject } from '@angular/core';
import { AuthService } from '../services/auth.service';

/**
 * HTTP interceptor that adds JWT token to outgoing requests.
 * Automatically attaches Authorization header for authenticated requests.
 * 
 * @param req The outgoing HTTP request
 * @param next The next handler in the chain
 * @returns Observable of the HTTP event
 */
export const authInterceptor: HttpInterceptorFn = (req, next) => {
    const authService = inject(AuthService);
    const token = authService.getToken();

    if (token && !req.url.includes('/auth/')) {
        const clonedReq = req.clone({
            setHeaders: {
                Authorization: `Bearer ${token}`
            }
        });
        return next(clonedReq);
    }

    return next(req);
};
