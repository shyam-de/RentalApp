import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { NewUser } from './new-user';
import { Property } from './property';
import { Booking } from './booking';
import { Router } from '@angular/router';
@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http:HttpClient , private router:Router) { }
  createUser(user:NewUser):Observable<Object>{
    return this.http.post(`http://localhost:8082/user/newuser`,user)
  }

  sendBooking(booking:Booking):Observable<Object>{
    return this.http.post(`http://localhost:8082/user/property/booking`,booking)
  }

  userLogin(user:Object){
    console.log("calling admin microservice spring app")

    this.http.post(`http://localhost:8081/user/login`,user,{ observe: 'response' }).subscribe(
      response => {
          // Only called for success.


            this.router.navigate(['/usernav']);




      },
      errorResponse => {
          // Called when there's an error (e.g. parsing failure).
          if (errorResponse.status === 200) {
              alert('Hello (for real this time)!');
              this.router.navigate(['/newuser']);

          }
          else{

          }
      });
      this.router.navigate(['/usernav']);

  }

  getAllProperty():Observable<Property[]>{
    console.log("calling spring app")
    return this.http.get<Property[]>(`http://localhost:8082/user/property/allproperty`)

  }

  getAllPropertyType(type:string){
    return this.http.get<Property[]>(`http://localhost:8082/user/property/propertytype/${type}`)

  }
  getAllPropertyFeature(feature:string){
    return this.http.get<Property[]>(`http://localhost:8082/user/property/feature/${feature}`)
  }

  getAllPropertyCategoryTopRated(category:string){
    return this.http.get<Property[]>(`http://localhost:8082/user/property/topcategory/${category}`)
  }
  getAllPropertyCity(city:string){
    return this.http.get<Property[]>(`http://localhost:8082/user/property/city/${city}`)
  }

  getBookingStatus(){
    return this.http.get<Booking[]>(`http://localhost:8082/user/property/bookingstatus${1}`)
  }

}
