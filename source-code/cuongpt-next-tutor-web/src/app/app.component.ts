import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';

/**
 * Root component for the Next Tutor application.
 * Serves as the main container for all routed components.
 * 
 * @author Next Tutor Team
 * @since 1.0.0
 */
@Component({
    selector: 'app-root',
    standalone: true,
    imports: [RouterOutlet],
    template: '<router-outlet></router-outlet>',
    styles: []
})
export class AppComponent {
    title = 'Next Tutor';
}
