package com.Capstone.RentAPlace.userController;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.Capstone.RentAPlace.customeException.InvalidCredentialException;
import com.Capstone.RentAPlace.dao.Booking;
import com.Capstone.RentAPlace.dao.User;
import com.Capstone.RentAPlace.dao.UserLogin;
import com.Capstone.RentAPlace.service.UserService;
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;
	
	@Autowired
	RestTemplate restTemplate;
	
	private String adminUrl="http://localhost:8081/admin/property/";
	
	@PostMapping("/newuser")
	public ResponseEntity<String> createUser(@RequestBody User user)throws InvalidCredentialException{
		userService.createuser(user);
		return ResponseEntity.ok("New User created Successfully..");
		
	}

	@PostMapping("/userlogin")
	public ResponseEntity<ResponseEntity<User>> loginUser(@RequestBody UserLogin user) throws InvalidCredentialException{
		
		return ResponseEntity.ok().body(userService.loginUser(user));
	}
	
	@PostMapping("/property/booking")
	public ResponseEntity<String> booking(@RequestBody Booking booking){
		userService.booking(booking);
		return ResponseEntity.ok("Booking Request sent ...");
	}
	
	@GetMapping("/property/allproperty")
	public List<Object> getAllProperty() {
		Object[] objects = restTemplate.getForObject( adminUrl+"/allproperty", Object[].class);
		return Arrays.asList(objects);
	}
	
	
	@GetMapping("/property/propertytype/{value}")
	public List<Object> getByPropertyType(@PathVariable("value") String type) {
		Object[] objects = restTemplate.getForObject( adminUrl+"/propertytype/"+type, Object[].class);
		return Arrays.asList(objects);
	}
	
	@GetMapping("/property/feature/{feature}")
	public List<Object> getByFeature(@PathVariable("feature") String feature) {
		Object[] objects = restTemplate.getForObject( adminUrl +"/feature/"+feature, Object[].class);
		return Arrays.asList(objects);
	}
	
	@GetMapping("/property/topcategory/{category}")
	public List<Object> getPropertyByCategoryTopRated(@PathVariable("category") String category) {
		Object[] objects = restTemplate.getForObject(adminUrl+"/topcategory/"+category, Object[].class);
		return Arrays.asList(objects);
	}
	
	@GetMapping("/property/city/{city}")
	public List<Object> getPropertyByCity(@PathVariable("city") String city) {
		Object[] objects = restTemplate.getForObject(adminUrl+"/city/"+city, Object[].class);
		return Arrays.asList(objects);
	}
	
	@GetMapping("/property/bookingstatus/{uid}")
	public List<Object> bookingStatus(@PathVariable("uid") String uid) {
		Object[] objects = restTemplate.getForObject(adminUrl+"/bookingstatus/"+uid, Object[].class);
		return Arrays.asList(objects);
	}
	
	
	
}
