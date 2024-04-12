import { Component } from '@angular/core';
import { RouterLink, RouterLinkActive, RouterModule, RouterOutlet } from '@angular/router';
import { ContactManagerService } from '../../services/contact-manager.service';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [RouterOutlet,RouterLink, RouterLinkActive,RouterModule],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {

  constructor(private managerServices:ContactManagerService){}

  ngOnInit(){
    // console.log("app is running")
    // this.managerServices.getUsers().subscribe(data=>{
    //   console.log(data);
    // });
  }

}
