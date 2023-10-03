package com.capstone.RentAPlaceAdmin.service;

import java.util.List;
import java.util.Optional;
import java.util.Properties;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.RentAPlaceAdmin.dao.Booking;
import com.capstone.RentAPlaceAdmin.dao.Property;
import com.capstone.RentAPlaceAdmin.exception.DataNotFoundException;
import com.capstone.RentAPlaceAdmin.exception.InvalidCredentialException;
import com.capstone.RentAPlaceAdmin.repos.BookingRepo;
import com.capstone.RentAPlaceAdmin.repos.PropertyRepo;

@Service
public class PropertyService {
	
	@Autowired
	PropertyRepo propertyRepo;
	
	@Autowired
	BookingRepo bookRepo;

	public void addNewProperty(Property property) {
		propertyRepo.save(property);
	}

	public void updateProperty(int pid,Property property) throws InvalidCredentialException {
		Optional.of(propertyRepo.findById(pid).orElseThrow(()-> new InvalidCredentialException("Invalid Id , property does not Exist")));
		propertyRepo.save(property);	
	}

	public List<Property> allProperty() {
		List<Property> properties = propertyRepo.findAll();
		return properties;
	}

	public Optional<List<Property>> findByPropertyType(String type) throws DataNotFoundException {
		Optional<List<Property>> properties = Optional.of(Optional.of(propertyRepo.findByPropertyType(type)).orElseThrow(()->new DataNotFoundException("This Property is not present")));
		return properties;
	}

	public Optional<List<Property>> findPropertyByFeature(String feature) throws DataNotFoundException {
		Optional<List<Property>> properties = Optional.of(Optional.of(propertyRepo.findByFeature(feature)).orElseThrow(()->new DataNotFoundException("This Property is not present")));
		
		return properties;
	}

	public Optional<List<Property>> findByPropertyCategoryTopRated(String category) throws DataNotFoundException {
		int rating=4;
		Optional<List<Property>> properties = Optional.of(Optional.of(propertyRepo.findByPropertyCategoryAndRating(category,rating)).orElseThrow(()->new DataNotFoundException("This Property is not present")));
		return properties;
	}

	public Optional<List<Property>> findByPropertyCity(String city) throws DataNotFoundException {
	
		Optional<List<Property>> properties = Optional.of(Optional.of(propertyRepo.findByPropertyCity(city)).orElseThrow(()->new DataNotFoundException("This Property is not present")));
		return properties ;
	}

	public List<Booking> allBooking() {
		
		return bookRepo.findAll();
	}
	
	 @RabbitListener(queues = {"${rabbitmq.queue.booking.name}"})
	    public void userBookingData(Booking book){
		 Booking books = new Booking();
		 books.setUserId(book.getUserId());
		 books.setCheckInDate(book.getCheckInDate());
		 books.setCheckOutDate(book.getCheckOutDate());
		 books.setPropertyId(book.getPropertyId());
		 books.setBookingStatus(false);
		 bookRepo.save(books);
		 
	        System.out.printf("Received message -> %s",book.toString());
	    }
	 
	 public void confirmBooking(int id) throws DataNotFoundException {
		 Booking books=bookRepo.findById(id).orElseThrow(()-> new DataNotFoundException("Bookind id not present"));
		 books.setBookingStatus(true);
		 bookRepo.save(books);
	 }

	public void deleteProperty(int pid) throws DataNotFoundException {
		Property prop = propertyRepo.findById(pid).orElseThrow(()-> new DataNotFoundException("Propertty Not Exist"));
		propertyRepo.deleteById(pid);
		
		
	}

	public Property propertyById(int pid) throws DataNotFoundException {
	Property prop = propertyRepo.findById(pid).orElseThrow(()->  new DataNotFoundException("Property Not Available"));
	System.out.println("property is "+prop);
		return prop;
	}

	public List<Booking> bookingStatus(int uid) {
		// TODO Auto-generated method stub
		List<Booking> bookingStatus = bookRepo.findByUserId(uid);
				return bookingStatus;		
	}

}
