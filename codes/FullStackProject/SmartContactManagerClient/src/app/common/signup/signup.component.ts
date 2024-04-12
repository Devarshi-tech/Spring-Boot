import { Component, Input } from '@angular/core';
import { ContactManagerService } from '../../services/contact-manager.service';
import { FormsModule } from '@angular/forms';
import { DataStoreService } from '../../services/data-store.service';
import { MessageAlertsComponent } from '../message-alerts/message-alerts.component';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-signup',
  standalone: true,
  imports: [FormsModule,MessageAlertsComponent,CommonModule],
  templateUrl: './signup.component.html',
  styleUrl: './signup.component.css'
})
export class SignupComponent {
  
 
  UserObject:any ={};
  isSuccessAlert:boolean = false;
  isFailedAlert:boolean = false;
  alertMessage:string = '';

  constructor(private manageService:ContactManagerService,private dataStore:DataStoreService){}

  registerUser(){
    this.manageService.registerUser(this.UserObject).subscribe(data=>{
      let userTempObject:any = {};
      userTempObject = data;
      console.log(data);
      
      if(userTempObject.message.content =='Saved successfuly'){
        this.isSuccessAlert =  true;
      }
      else{
        this.isFailedAlert = true;
      }
      this.alertMessage = userTempObject.message.content;
      setTimeout(() => {
        this.isSuccessAlert = this.isSuccessAlert?false:false;
        this.isFailedAlert = this.isFailedAlert ? false:false;
      }, 5000);
    })
  }


}
