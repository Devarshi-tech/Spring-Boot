import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { DataStoreService } from '../../services/data-store.service';

@Component({
  selector: 'app-message-alerts',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './message-alerts.component.html',
  styleUrl: './message-alerts.component.css'
})
export class MessageAlertsComponent {

  isSuccessAlert:boolean = false;

  constructor(private dataStore:DataStoreService){
    console.log("hello")
    console.log(this.dataStore.alertContent)
    if(this.dataStore.alertContent == 'Saved successfuly') this.isSuccessAlert = this.dataStore.isAlert;
  }


}
