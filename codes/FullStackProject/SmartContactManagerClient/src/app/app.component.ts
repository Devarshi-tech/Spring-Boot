import { Component } from '@angular/core';
import { RouterLink, RouterLinkActive, RouterOutlet } from '@angular/router';
import { HeaderComponent } from './common/header/header.component';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { MessageAlertsComponent } from './common/message-alerts/message-alerts.component';



@Component({
  selector: 'app-root',
  standalone: true,
  imports: [HeaderComponent,CommonModule,RouterOutlet ,RouterLink,RouterLinkActive,RouterModule,FormsModule,MessageAlertsComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'SmartContactManagerClient';

}
