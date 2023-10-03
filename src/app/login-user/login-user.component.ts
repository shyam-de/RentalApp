import { Component } from '@angular/core';
import { Login } from '../login';
import { UserService } from '../user.service';
import { Router } from '@angular/router';
import { NewUser } from '../new-user';
@Component({
  selector: 'app-login-user',
  templateUrl: './login-user.component.html',
  styleUrls: ['./login-user.component.css']
})
export class LoginUserComponent {
  userObj:Login = new Login();
  authObj:NewUser = new NewUser

  constructor(private userService:UserService,private router:Router){

  }
  userLogin(){
    console.log("User name  : " +this.userObj.name)
    this.userService.userLogin(this.userObj);
    // .subscribe(data=>console.log(data),error=>console.log(error));
    // this.router.navigate(['/usernav']);
  }
}
