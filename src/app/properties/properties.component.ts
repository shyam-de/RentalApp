import { Component, OnInit } from '@angular/core';
import { Property } from '../property';
import { UserService } from '../user.service';
import { Observable } from 'rxjs';
@Component({
  selector: 'app-properties',
  templateUrl: './properties.component.html',
  styleUrls: ['./properties.component.css']
})
export class PropertiesComponent implements OnInit {
  propObj: Property = new Property();
  propertylist!:Observable<Property[]>
  propertydata!:Property[];


  constructor(private userService:UserService){
  }
  ngOnInit()
  {
    this.getAllProp();
  }
  getAllProp(){
    console.log("User name  : " +this.propObj.propertyType)
    console.log("User age is : " +this.propObj.propertyPrice)
    this.propertylist=this.userService.getAllProperty();

    this.propertylist.subscribe(data=>(this.propertydata=data),error=>console.log(error));

    for(let i=0;i<this.propertydata.length;i++){
      console.log(this.propertydata[i].propertyCategory)

    }
  }

}
