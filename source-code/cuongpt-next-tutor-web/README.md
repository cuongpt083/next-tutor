# Next Tutor - Frontend Application

AI-powered English learning platform for children (5-16 years old) - Angular 17 Frontend.

## Technology Stack

- **Angular**: 17
- **TypeScript**: 5.2
- **CSS**: Vanilla CSS (Kid-friendly design system)
- **Build Tool**: Angular CLI

## Project Structure

```
src/
├── app/
│   ├── core/                    # Core module (singleton services, guards, interceptors)
│   │   ├── guards/              # Route guards (auth.guard.ts)
│   │   ├── interceptors/        # HTTP interceptors (auth.interceptor.ts)
│   │   ├── models/              # TypeScript interfaces
│   │   └── services/            # Core services (auth, learning, audio)
│   ├── shared/                  # Shared components, pipes, directives
│   │   ├── components/          # Reusable UI components
│   │   └── ui/                  # Design system components
│   ├── features/                # Feature modules (lazy-loaded)
│   │   ├── auth/                # Login component
│   │   ├── home/                # Home dashboard
│   │   ├── tutor-selection/     # Tutor selection
│   │   ├── learning/            # Learning modules
│   │   │   ├── voice-chat/      # Speaking & Listening
│   │   │   ├── quiz/            # Reading & Listening quiz
│   │   │   ├── writing/         # Writing practice
│   │   │   └── role-play/       # Role-play game
│   │   ├── dashboard/           # Progress dashboard
│   │   └── settings/            # Settings page
│   ├── app.component.ts         # Root component
│   ├── app.config.ts            # App configuration
│   └── app.routes.ts            # Route definitions
├── environments/                # Environment configurations
├── assets/                      # Static assets
└── styles.css                   # Global styles
```

## Getting Started

### Prerequisites

- Node.js 18+
- npm 9+

### Installation

```bash
# Install dependencies
npm install

# Run development server
npm start
```

The application will start on `http://localhost:4200`.

### Build

```bash
# Build for production
npm run build

# Output will be in dist/cuongpt-next-tutor-web
```

## Features

### Implemented

- ✅ OAuth2 Login (Facebook/Zalo) - FR-01
- ✅ Home Dashboard
- ✅ Route Guards & JWT Interceptor
- ✅ Kid-friendly UI Design System
- ✅ Responsive Layout (Mobile + Desktop)

### To Be Implemented

- 🔲 Tutor Selection - FR-02
- 🔲 Voice Chat (Speaking & Listening) - FR-03
- 🔲 Quiz (Reading & Listening) - FR-04
- 🔲 Writing Practice - FR-05
- 🔲 Role-play Game - FR-06
- 🔲 Pronunciation Scoring - FR-07
- 🔲 Progress Dashboard - FR-09

## Design System

The application follows a kid-friendly design system with:

- **Colors**: Bright, candy/pastel palette (Blue, Yellow, Orange, Green, Pink)
- **Typography**: Rounded sans-serif fonts (Nunito, Quicksand)
- **Spacing**: Large touch targets (56px minimum)
- **Animations**: Playful micro-animations for engagement
- **Layout**: Responsive (Desktop sidebar, Mobile bottom nav)

## API Integration

The frontend connects to the Spring Boot backend at:

- **Development**: `http://localhost:8080`
- **Production**: `https://api.nexttutor.com`

All API calls are automatically authenticated with JWT tokens via the `authInterceptor`.

## Environment Variables

Configure in `src/environments/`:

- `environment.ts` - Production settings
- `environment.development.ts` - Development settings

## Code Conventions

- **Standalone Components**: Using Angular 17 standalone architecture
- **Lazy Loading**: All feature modules are lazy-loaded
- **TypeScript Strict Mode**: Enabled for type safety
- **Comprehensive Documentation**: All classes and methods have JSDoc comments

## Testing

```bash
# Run unit tests
npm test

# Run linting
npm run lint
```

## License

Proprietary - Next Tutor Team
