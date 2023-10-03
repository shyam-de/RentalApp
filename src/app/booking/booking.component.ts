import { Component } from '@angular/core';
import { Booking } from '../booking';
import { UserService } from '../user.service';

@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css']
})
export class BookingComponent {
  bookObj: Booking = new Booking();

  constructor(private userService:UserService){

  }
  book(){

    this.userService.sendBooking(this.bookObj).subscribe(data=>console.log(data),error=>console.log(error));

  }

}
