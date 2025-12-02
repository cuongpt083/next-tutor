import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {
    Tutor,
    StartSessionRequest,
    LearningSession,
    SessionInteractionRequest,
    AIResponse
} from '../models/session.model';
import { environment } from '../../../environments/environment';

/**
 * Learning service for Next Tutor.
 * Handles all learning-related API calls including sessions, tutors, and interactions.
 * 
 * @author Next Tutor Team
 * @since 1.0.0
 */
@Injectable({
    providedIn: 'root'
})
export class LearningService {
    private readonly API_URL = `${environment.apiUrl}/api/v1`;

    constructor(private http: HttpClient) { }

    /**
     * Retrieves the list of available AI tutors.
     * 
     * @returns Observable of tutor array
     */
    getTutors(): Observable<Tutor[]> {
        return this.http.get<Tutor[]>(`${this.API_URL}/tutors`);
    }

    /**
     * Starts a new learning session with specified parameters.
     * 
     * @param request Session start request containing tutor, mode, topic, and level
     * @returns Observable of learning session with initial message
     */
    startSession(request: StartSessionRequest): Observable<LearningSession> {
        return this.http.post<LearningSession>(`${this.API_URL}/sessions/start`, request);
    }

    /**
     * Sends user input to the AI and receives a response.
     * 
     * @param sessionId The ID of the current learning session
     * @param request Interaction request containing input type and content
     * @returns Observable of AI response with feedback
     */
    interact(sessionId: string, request: SessionInteractionRequest): Observable<AIResponse> {
        return this.http.post<AIResponse>(`${this.API_URL}/sessions/${sessionId}/interact`, request);
    }

    /**
     * Gets quiz questions based on level, skill, and topic.
     * 
     * @param level User's proficiency level
     * @param skill Skill type (READING, LISTENING)
     * @param topic Topic category
     * @returns Observable of quiz data
     */
    getQuiz(level: string, skill: string, topic: string): Observable<any> {
        return this.http.get(`${this.API_URL}/quizzes`, {
            params: { level, skill, topic }
        });
    }

    /**
     * Submits quiz answers for evaluation.
     * 
     * @param quizId The ID of the quiz
     * @param answers Array of answers
     * @returns Observable of quiz results
     */
    submitQuiz(quizId: string, answers: any[]): Observable<any> {
        return this.http.post(`${this.API_URL}/quizzes/${quizId}/submit`, { answers });
    }
}
