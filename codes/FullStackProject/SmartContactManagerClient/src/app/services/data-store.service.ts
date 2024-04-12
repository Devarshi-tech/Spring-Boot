import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DataStoreService {

  isAlert:boolean = false;
  alertContent:string='';

  alertMessageHandler(isAlert:boolean,alertContent:string,):any{
    
    this.isAlert = isAlert;
    this.alertContent = alertContent;
    
    setTimeout(() => {
      this.alertMessageReset(isAlert,alertContent);
    }, 2000);

  }

  alertMessageReset(isAlert:boolean,alertContent:string){
    if(isAlert){
        this.isAlert = false;
        this.alertContent = '';
    }
  }

  constructor() { }


}
