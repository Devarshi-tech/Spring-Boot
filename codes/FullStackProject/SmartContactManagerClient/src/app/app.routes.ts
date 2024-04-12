import { Routes } from '@angular/router';
import { HomeComponent } from './common/home/home.component';
import { SignupComponent } from './common/signup/signup.component';
import { LoginComponent } from './common/login/login.component';


export const routes: Routes = [
    {path:'home' , component: HomeComponent},
    {path:'signup' , component:SignupComponent},
    {path:'login',component:LoginComponent},
    { path: '',   redirectTo: '/home', pathMatch: 'full' }, // redirect to `first-component`
    // { path: '**', component: PageNotFoundComponent }
];
