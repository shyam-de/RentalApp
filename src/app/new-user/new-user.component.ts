import { Component } from '@angular/core';
import { NewUser } from '../new-user';
import { UserService } from '../user.service';

@Component({
  selector: 'app-new-user',
  templateUrl: './new-user.component.html',
  styleUrls: ['./new-user.component.css']
})
export class NewUserComponent {
  userObj: NewUser = new NewUser();

  constructor(private userService:UserService){

  }
  save(){
    console.log("User name  : " +this.userObj.name)
    console.log("User age is : " +this.userObj.age)
    console.log("User Postal : " +this.userObj.postal)
    this.userService.createUser(this.userObj).subscribe(data=>console.log(data),error=>console.log(error));

  }
}
