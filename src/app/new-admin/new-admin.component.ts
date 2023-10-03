import { Component } from '@angular/core';
import { NewAdmin } from '../new-admin';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-new-admin',
  templateUrl: './new-admin.component.html',
  styleUrls: ['./new-admin.component.css']
})
export class NewAdminComponent {
  adminObj: NewAdmin = new NewAdmin();

  constructor(private adminService:AdminService){

  }
  save(){
    console.log("User name  : " +this.adminObj.name)
    console.log("User age is : " +this.adminObj.contact)
    this.adminService.createAdmin(this.adminObj).subscribe(data=>console.log(data),error=>console.log(error));

  }

}
