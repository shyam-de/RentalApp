package com.capstone.RentAPlaceAdmin.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstone.RentAPlaceAdmin.dao.Property;

public interface PropertyRepo extends JpaRepository<Property, Integer> {

	List<Property> findByPropertyType(String type);

	List<Property> findByFeature(String feature);

	List<Property> findByPropertyCategoryAndRating(String category,int rating);

	List<Property> findByPropertyCity(String city);

}
