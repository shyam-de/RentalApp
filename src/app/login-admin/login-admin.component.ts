import { Component } from '@angular/core';
import { AdminService } from '../admin.service';
import { NewAdmin } from '../new-admin';
import { Login } from '../login';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login-admin',
  templateUrl: './login-admin.component.html',
  styleUrls: ['./login-admin.component.css']
})
export class LoginAdminComponent {
  adminObj:Login = new Login();

  constructor(private adminService:AdminService,private router:Router){

  }
  adminLogin(){
    console.log("User name  : " +this.adminObj.name)
    this.adminService.adminLogin(this.adminObj).subscribe(data=>console.log(data),error=>console.log(error));
    this.router.navigate(['/adminNav']);
  }
}
