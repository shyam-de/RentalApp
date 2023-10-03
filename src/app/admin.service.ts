import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Booking } from './booking';
import { Property } from './property';

@Injectable({
  providedIn: 'root'
})
export class AdminService {


  constructor(private http:HttpClient) { }
  createAdmin(admin:Object):Observable<Object>{
    console.log("calling admin microservice spring app")

    return this.http.post(`http://localhost:8081/admin/newadmin`,admin)

  }
  createProperty(property:Object):Observable<Object>{
    console.log("calling admin microservice spring app")

    return this.http.post(`http://localhost:8081/admin/newproperty`,property)
  }
  adminLogin(admin:Object):Observable<Object>{
    console.log("calling admin microservice spring app")

    return this.http.post(`http://localhost:8081/admin/login`,admin)
  }

  confirmUserBooking(id:number,booking:any){
    console.log("confirming booking service"+id)
    return this.http.patch(`http://localhost:8081/admin/property/booking/${id}`,booking);

  }
  getAllBooking(){
    return this.http.get<Booking[]>(`http://localhost:8081/admin/property/allbooking`);
  }
  getPropertyById(id:number ):Observable<Property>{
    console.log("id in service layer is "+id);
    return this.http.get<Property>(`http://localhost:8081/admin/property/findprop/${id}`)
  }
  getAllProperty(){
    return this.http.get<Property[]>(`http://localhost:8081/admin/property/allproperty`)
  }

  updateProperty(id:number,property:any){
    console.log("id in service is "+id);
    return this.http.patch(`http://localhost:8081/admin/property/updateproperty/${id}`,property);
  }
  deleteProperty(id:number,property:any){
    console.log("Deleteing from serive "+id)
    return this.http.delete(`http://localhost:8081/admin/property/remove/${id}`,property);
  }
}

