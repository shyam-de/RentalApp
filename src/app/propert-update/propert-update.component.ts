import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { Property } from '../property';
import { AdminService } from '../admin.service';
@Component({
  selector: 'app-propert-update',
  templateUrl: './propert-update.component.html',
  styleUrls: ['./propert-update.component.css']
})
export class PropertUpdateComponent {
  private sub:any;
  property!:Observable<Property>
  propObj!:Property;
  // propObj: Property = new Property;
  idparam!:number;
  constructor(private adminService:AdminService ,private route:ActivatedRoute)
  {

  }
  ngOnInit()
  {
    this.propObj = new Property();
    // this.sub=this.route.params.subscribe(params=>
    this.idparam=this.route.snapshot.params['id'];
      console.log("id is "+this.idparam);

      this.property=this.adminService.getPropertyById(this.idparam);
      this.property.subscribe(data=>(this.propObj=data),error=>console.log(error));
      console.log("id is "+this.propObj.propertyCity)
}
update(){
  this.adminService.updateProperty(this.propObj.propertyId,this.propObj).subscribe(data=>console.log(data),error=>console.log(error));
}
}
