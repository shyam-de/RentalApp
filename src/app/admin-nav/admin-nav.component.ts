import { Component } from '@angular/core';
import { AdminService } from '../admin.service';
import { Booking } from '../booking';
import { Property } from '../property';
import { Observable } from 'rxjs';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-admin-nav',
  templateUrl: './admin-nav.component.html',
  styleUrls: ['./admin-nav.component.css']
})
export class AdminNavComponent {


  bookObj: Booking = new Booking();
  bookinglist!:Observable<Booking[]>
  bookingdata!:Booking[];

  propObj: Property = new Property();
  propertylist!:Observable<Property[]>
  propertydata!:Property[];


  constructor(private adminService:AdminService,private router:Router){
  }

  confirmBooking(id:number){
    console.log("confirm booking"+id);
    this.adminService.confirmUserBooking(id,this.bookObj).subscribe(data=>console.log(data));
    this.getAllBooking();

  }

  getAllBooking(){
    this.bookinglist=this.adminService.getAllBooking();
    this.bookinglist.subscribe(data=>(this.bookingdata=data),error=>console.log(error));

  }
  propVIewById(id:number){

    this.router.navigate(['/propDetail',id]);
  }
  getAllProp(){
    this.propertylist=this.adminService.getAllProperty();
    this.propertylist.subscribe(data=>(this.propertydata=data),error=>console.log(error));
  }

  propUpdate(id:number){
    this.router.navigate(['/propUpdate',id]);

  }

  propDelete(id:number){
    console.log("Id to delete "+id)
    this.adminService.deleteProperty(id,this.propObj).subscribe(data=>console.log(data));
    this.getAllProp();
  }

}


