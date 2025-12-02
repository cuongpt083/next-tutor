import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { AuthService } from '../../core/services/auth.service';
import { User } from '../../core/models/user.model';

/**
 * Home component - main dashboard after login.
 * Displays quick access to learning features and tutor selection.
 * 
 * @author Next Tutor Team
 * @since 1.0.0
 */
@Component({
    selector: 'app-home',
    standalone: true,
    imports: [CommonModule],
    templateUrl: './home.component.html',
    styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
    currentUser: User | null = null;

    constructor(
        private authService: AuthService,
        private router: Router
    ) { }

    ngOnInit(): void {
        this.currentUser = this.authService.getCurrentUser();
    }

    /**
     * Navigates to tutor selection page.
     */
    selectTutor(): void {
        this.router.navigate(['/tutor-selection']);
    }

    /**
     * Starts a speaking session.
     */
    startSpeaking(): void {
        this.router.navigate(['/voice-chat']);
    }

    /**
     * Starts a quiz session.
     */
    startQuiz(): void {
        this.router.navigate(['/quiz']);
    }

    /**
     * Starts a role-play game.
     */
    startRolePlay(): void {
        this.router.navigate(['/role-play']);
    }

    /**
     * Logs out the current user.
     */
    logout(): void {
        this.authService.logout();
        this.router.navigate(['/login']);
    }
}
