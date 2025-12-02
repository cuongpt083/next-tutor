--liquibase formatted sql

--changeset nexttutor:001-create-users-table
CREATE TABLE IF NOT EXISTS users (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    oauth_provider VARCHAR(50) NOT NULL,
    oauth_id VARCHAR(255) NOT NULL,
    display_name VARCHAR(255),
    avatar_url TEXT,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    last_login TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    UNIQUE(oauth_provider, oauth_id)
);

--changeset nexttutor:002-create-tutors-table
CREATE TABLE IF NOT EXISTS tutors (
    id VARCHAR(50) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    system_prompt TEXT NOT NULL,
    avatar_url TEXT
);

--changeset nexttutor:003-create-topics-table
CREATE TABLE IF NOT EXISTS topics (
    id VARCHAR(50) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    category VARCHAR(50),
    min_level VARCHAR(20)
);

--changeset nexttutor:004-create-learning-sessions-table
CREATE TABLE IF NOT EXISTS learning_sessions (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    user_id UUID REFERENCES users(id),
    tutor_id VARCHAR(50) REFERENCES tutors(id),
    topic_id VARCHAR(50) REFERENCES topics(id),
    mode VARCHAR(20) NOT NULL,
    status VARCHAR(20) DEFAULT 'ACTIVE',
    start_time TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    end_time TIMESTAMP WITH TIME ZONE
);

--changeset nexttutor:005-create-session-messages-table
CREATE TABLE IF NOT EXISTS session_messages (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    session_id UUID REFERENCES learning_sessions(id),
    sender_role VARCHAR(20) NOT NULL,
    content TEXT NOT NULL,
    audio_url TEXT,
    feedback_data JSONB,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

--changeset nexttutor:006-create-user-progress-table
CREATE TABLE IF NOT EXISTS user_progress (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    user_id UUID REFERENCES users(id),
    skill_type VARCHAR(20) NOT NULL,
    total_minutes INTEGER DEFAULT 0,
    total_sessions INTEGER DEFAULT 0,
    average_score FLOAT DEFAULT 0.0,
    last_updated TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    UNIQUE(user_id, skill_type)
);

--changeset nexttutor:007-insert-sample-tutors
INSERT INTO tutors (id, name, description, system_prompt, avatar_url) VALUES
('tutor_bear', 'Mr. Bear', 'Thân thiện, giọng trầm ấm, thích kể chuyện.', 
 'You are Mr. Bear, a friendly and patient English tutor for children aged 5-16. You speak in a warm, encouraging tone and love to tell stories. Always be supportive and make learning fun.', 
 '/assets/tutors/bear.png'),
('tutor_rabbit', 'Miss Rabbit', 'Vui vẻ, năng động, thích khám phá.', 
 'You are Miss Rabbit, an energetic and cheerful English tutor for children. You love exploring new topics and encouraging students to speak up. Keep the conversation lively and engaging.', 
 '/assets/tutors/rabbit.png'),
('tutor_robot', 'Robo Teacher', 'Thông minh, chính xác, giúp sửa lỗi nhẹ nhàng.', 
 'You are Robo Teacher, a smart and precise English tutor. You help students improve their pronunciation and grammar gently. Provide clear corrections with positive reinforcement.', 
 '/assets/tutors/robot.png')
ON CONFLICT (id) DO NOTHING;

--changeset nexttutor:008-insert-sample-topics
INSERT INTO topics (id, name, category, min_level) VALUES
('topic_travel', 'Travel & Tourism', 'TRAVEL', 'A2'),
('topic_food', 'Food & Dining', 'DAILY_LIFE', 'A1'),
('topic_school', 'School Life', 'EDUCATION', 'A1'),
('topic_hobbies', 'Hobbies & Interests', 'LEISURE', 'A2'),
('topic_weather', 'Weather & Seasons', 'NATURE', 'A1')
ON CONFLICT (id) DO NOTHING;
