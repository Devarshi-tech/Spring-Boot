import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ContactManagerService {

  url:string = "http://localhost:8080";

  constructor(private http:HttpClient) { }

  registerUser(user:any){
    return this.http.post(this.url + "/home/registerUser",user);
  }

 
}
