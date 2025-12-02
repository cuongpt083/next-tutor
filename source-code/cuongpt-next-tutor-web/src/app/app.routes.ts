import { Routes } from '@angular/router';
import { authGuard } from './core/guards/auth.guard';

/**
 * Application routes for Next Tutor.
 * Implements lazy loading for feature modules.
 */
export const routes: Routes = [
    {
        path: '',
        redirectTo: '/home',
        pathMatch: 'full'
    },
    {
        path: 'login',
        loadComponent: () => import('./features/auth/login/login.component').then(m => m.LoginComponent)
    },
    {
        path: 'home',
        loadComponent: () => import('./features/home/home.component').then(m => m.HomeComponent),
        canActivate: [authGuard]
    },
    {
        path: 'tutor-selection',
        loadComponent: () => import('./features/tutor-selection/tutor-selection.component').then(m => m.TutorSelectionComponent),
        canActivate: [authGuard]
    },
    {
        path: 'voice-chat',
        loadComponent: () => import('./features/learning/voice-chat/voice-chat.component').then(m => m.VoiceChatComponent),
        canActivate: [authGuard]
    },
    {
        path: 'quiz',
        loadComponent: () => import('./features/learning/quiz/quiz.component').then(m => m.QuizComponent),
        canActivate: [authGuard]
    },
    {
        path: 'writing',
        loadComponent: () => import('./features/learning/writing/writing.component').then(m => m.WritingComponent),
        canActivate: [authGuard]
    },
    {
        path: 'role-play',
        loadComponent: () => import('./features/learning/role-play/role-play.component').then(m => m.RolePlayComponent),
        canActivate: [authGuard]
    },
    {
        path: 'dashboard',
        loadComponent: () => import('./features/dashboard/dashboard.component').then(m => m.DashboardComponent),
        canActivate: [authGuard]
    },
    {
        path: 'settings',
        loadComponent: () => import('./features/settings/settings.component').then(m => m.SettingsComponent),
        canActivate: [authGuard]
    },
    {
        path: '**',
        redirectTo: '/home'
    }
];
