import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { Property } from '../property';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-property-detail',
  templateUrl: './property-detail.component.html',
  styleUrls: ['./property-detail.component.css']
})
export class PropertyDetailComponent {
  private sub:any;
  property!:Observable<Property>
  p!:Property;
  idparam!:number;
  constructor(private adminService:AdminService ,private route:ActivatedRoute)
  {

  }
  ngOnInit()
  {

    this.sub=this.route.params.subscribe(params=>
      {
        this.idparam=params['id'];
        console.log("parameter value is "+params['id'])
        console.log(" id is "+this.idparam)

      })
      console.log("id param is "+this.idparam)
      this.propVIewById(this.idparam);
  }
  propVIewById(id:number){
    this.property=this.adminService.getPropertyById(id);
   this.property.subscribe(data=>(this.p=data),error=>console.log(error));
  }

}
