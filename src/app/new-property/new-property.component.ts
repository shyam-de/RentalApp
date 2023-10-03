import { Component } from '@angular/core';
import { Property } from '../property';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-new-property',
  templateUrl: './new-property.component.html',
  styleUrls: ['./new-property.component.css']
})
export class NewPropertyComponent {

  propObj: Property = new Property();

  constructor(private adminService:AdminService){

  }
  save(){
    this.adminService.createProperty(this.propObj).subscribe(data=>console.log(data),error=>console.log(error));

  }
}
