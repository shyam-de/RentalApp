import { Component, OnInit } from '@angular/core';
import { Property } from '../property';
import { Observable } from 'rxjs';
import { UserService } from '../user.service';
import { Router } from '@angular/router';
import { Booking } from '../booking';


@Component({
  selector: 'app-user-nav',
  templateUrl: './user-nav.component.html',
  styleUrls: ['./user-nav.component.css']
})
export class UserNavComponent {
  netImage:any = "../assets/homeImages/capstomehome1.png";
  netImage2:any = "../assets/homeImages/capstoneHome2.png";
  netImage3:any = "../assets/homeImages/capstoneHome3.png";

  bookinglist!:Observable<Booking[]>
  bookingdata!:Booking[];

  // propObj: Property = new Property();
  propertylist!:Observable<Property[]>
  propertydata!:Property[];

  constructor(private userService:UserService ,private router:Router){
  }
  propVIewById(id:number){

    this.router.navigate(['/propDetail',id]);
  }
  getAllProp(){
    this.propertylist=this.userService.getAllProperty();
    this.propertylist.subscribe(data=>(this.propertydata=data),error=>console.log(error));
    for(let i=0;i<this.propertydata.length;i++){
      console.log(this.propertydata[i].propertyCategory)
    }
  }


  getPropType(type:string){
    console.log("type : "+type)
    // let type="flat";
    this.propertylist=this.userService.getAllPropertyType(type);
    this.propertylist.subscribe(data=>(this.propertydata=data),error=>console.log(error));

    console.log("data is" +this.propertydata)

  }
  getPropFeature(feature:string){

    this.propertylist=this.userService.getAllPropertyFeature(feature);
    this.propertylist.subscribe(data=>(this.propertydata=data),error=>console.log(error));

  }
  getPropCategoryTopRated(category:string){
    this.propertylist=this.userService.getAllPropertyCategoryTopRated(category);
    this.propertylist.subscribe(data=>(this.propertydata=data),error=>console.log(error));

  }

  getPropCity(city:string){
    this.propertylist=this.userService.getAllPropertyCity(city);
    this.propertylist.subscribe(data=>(this.propertydata=data),error=>console.log(error));

  }
  getBookingStatus(){
    this.bookinglist=this.userService.getBookingStatus();
    this.bookinglist.subscribe(data=>(this.bookingdata=data),error=>console.log(error));

  }
}
