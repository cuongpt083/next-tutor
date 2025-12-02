/**
 * AI Tutor model interface.
 */
export interface Tutor {
    id: string;
    name: string;
    description: string;
    avatarUrl: string;
    personalityPrompt: string;
}

/**
 * Learning session model interface.
 */
export interface LearningSession {
    sessionId: string;
    initialMessage?: {
        text: string;
        audioUrl: string;
    };
}

/**
 * Start session request interface.
 */
export interface StartSessionRequest {
    tutorId: string;
    mode: 'SPEAKING' | 'ROLE_PLAY' | 'QUIZ';
    topicId: string;
    level: string;
}

/**
 * Session interaction request interface.
 */
export interface SessionInteractionRequest {
    inputType: 'TEXT' | 'AUDIO';
    content: string;
}

/**
 * AI response interface.
 */
export interface AIResponse {
    aiResponse: {
        text: string;
        audioUrl: string;
    };
    feedback?: {
        score: number;
        correction: string;
        pronunciationErrors: string[];
    };
}
