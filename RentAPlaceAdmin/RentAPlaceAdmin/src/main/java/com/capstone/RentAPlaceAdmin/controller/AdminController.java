package com.capstone.RentAPlaceAdmin.controller;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CountDownLatch;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.RentAPlaceAdmin.dao.Admin;
import com.capstone.RentAPlaceAdmin.dao.Booking;
import com.capstone.RentAPlaceAdmin.dao.LoginAdmin;
import com.capstone.RentAPlaceAdmin.dao.Property;
import com.capstone.RentAPlaceAdmin.exception.DataNotFoundException;
import com.capstone.RentAPlaceAdmin.exception.InvalidCredentialException;
import com.capstone.RentAPlaceAdmin.repos.BookingRepo;
import com.capstone.RentAPlaceAdmin.service.AdminService;
import com.capstone.RentAPlaceAdmin.service.PropertyService;
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@Autowired
	PropertyService propertyService;
	
	@Autowired
	BookingRepo bookRepo;
	
	private CountDownLatch latch = new CountDownLatch(1);
	
	 public CountDownLatch getLatch() {
		    return latch;
		}
	
	@PostMapping("/newadmin")
	public ResponseEntity<String> createAdmin(@RequestBody Admin admin){
		adminService.createAdmin(admin);
		return ResponseEntity.ok("New Admin Created ");
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> loginAdmin(@RequestBody LoginAdmin admin){
		System.out.println("username is "+admin.getName());
		System.out.println("password is "+admin.getPassword());
		adminService.loginAdmin(admin);
		return ResponseEntity.ok("Valid Admin");
	}
	
	@PostMapping("/newproperty")
	public ResponseEntity<String> addNewProperty(@RequestBody Property property){
		propertyService.addNewProperty(property);
		return ResponseEntity.ok("New Property Added ");
	}
	
	@GetMapping("/property/findprop/{id}")
	public ResponseEntity<Property> propertyById(@PathVariable("id") int pid) throws DataNotFoundException{
		Property properties = propertyService.propertyById(pid);
		System.out.print(properties.getPropertyCity());
		return ResponseEntity.ok(properties);
	}
	@GetMapping("/property/allproperty")
	public ResponseEntity<List<Property>> allProperty(){
		List<Property> properties = propertyService.allProperty();
		return ResponseEntity.ok(properties);
	}
	
	@GetMapping("/property/propertytype/{type}")
	public ResponseEntity<Optional<List<Property>>> findByPropertyType(@PathVariable(value="type") String type) throws DataNotFoundException{
		Optional<List<Property>> properties = propertyService.findByPropertyType(type);
		return ResponseEntity.ok(properties);
	}
	
	
	@GetMapping("/property/feature/{feature}")
	public ResponseEntity<Optional<List<Property>>> findByPropertyFeature(@PathVariable(value="feature") String feature) throws DataNotFoundException{
		Optional<List<Property>> properties = propertyService.findPropertyByFeature(feature);
		return ResponseEntity.ok(properties);
	}
	
	@GetMapping("/property/topcategory/{category}")
	public ResponseEntity<Optional<List<Property>>> findPropertyByTopRated(@PathVariable(value="category") String category) throws DataNotFoundException{
		Optional<List<Property>> properties = propertyService.findByPropertyCategoryTopRated(category);
		return ResponseEntity.ok(properties);
	}
	
	@GetMapping("/property/city/{city}")
	public ResponseEntity<Optional<List<Property>>> findByPropertyCity(@PathVariable(value="city") String city) throws DataNotFoundException{
		Optional<List<Property>> properties = propertyService.findByPropertyCity(city);
		return ResponseEntity.ok(properties);
	}
	
	
	@PatchMapping("/property/updateproperty/{id}")
	public ResponseEntity<String> updateProperty(@PathVariable("id") int pid ,@RequestBody Property property) throws InvalidCredentialException{
		System.out.println("Angular req " + property.getPropertyCity());
		propertyService.updateProperty(pid,property);
		
		return ResponseEntity.ok("Property Updated  at id "+property.getPropertyId());
	}
	
	
	@GetMapping("/property/allbooking")
	public ResponseEntity<List<Booking>> allBooking(){
		List<Booking> bookings= propertyService.allBooking();
		return ResponseEntity.ok(bookings);
	
	}
	@PatchMapping("/property/booking/{id}")
	public ResponseEntity<String> confirmBooking(@PathVariable("id" ) int uid) throws  DataNotFoundException{
		propertyService.confirmBooking(uid);
		latch.countDown();
		System.out.print("angular id Is : "+uid);
		return ResponseEntity.ok("booking confirmed ");
	}
	@GetMapping("/property/bookingstatus/{id}")
	public List<Booking> bookingStatus(@PathVariable("id" ) int uid) throws  DataNotFoundException{
		List<Booking> status = propertyService.bookingStatus(uid);
		System.out.print("angular id Is : "+uid);
		return status;
	}
	
	@DeleteMapping("/property/remove/{id}")
	public ResponseEntity<String> deleteProp(@PathVariable("id") int pid) throws DataNotFoundException{
		propertyService.deleteProperty(pid);
		return ResponseEntity.ok("Property Deleted Successfully");
	}

}
