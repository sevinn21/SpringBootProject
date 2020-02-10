package com.example.finartz.controller;

import java.util.List;

import javax.validation.Valid;
import com.example.finartz.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.finartz.model.Airport;
import com.example.finartz.repository.AirportRepository;


@RestController
@RequestMapping("/api")

public class AirportController {

	@Autowired
	AirportRepository airportRepository;
	
	
	@GetMapping("/airports")
	//@RequestMapping(value="/airports",method=RequestMethod.GET)
	public List<Airport> getAllAirports(){
		return airportRepository.findAll();
		
	}
	
	@PostMapping("/airports")
	//@RequestMapping(value="/airports",method=RequestMethod.POST)
	public Airport createAirport(@Valid @RequestBody Airport airport) {
	    return airportRepository.save(airport);
	}

	
	@GetMapping("/airports/{id}")
	public Airport getAirportById(@PathVariable(value = "id") Long airportId) {
		return airportRepository.findById(airportId)
				.orElseThrow(() -> new ResourceNotFoundException("Airport","id",airportId));
		
	}
	@PutMapping("/airports/{id}")
	public Airport updateAirport(@PathVariable(value = "id") Long airportId,@Valid @RequestBody Airport airportDetails) {
		
		Airport airport = airportRepository.findById(airportId).orElseThrow(() -> new ResourceNotFoundException("Airport","id",airportId));
		airport.setTitle(airportDetails.getTitle());
		airport.setContent(airportDetails.getContent());
		
		Airport updatedAirport = airportRepository.save(airport);
		return updatedAirport;
	}
	
	@DeleteMapping("/airport/{id}")
	public ResponseEntity<?> deleteAirport(@PathVariable(value = "id") Long airportId) {
	
		Airport airport = airportRepository.findById(airportId).orElseThrow(() -> new ResourceNotFoundException("Airport","id",airportId));
		airportRepository.delete(airport);
		return ResponseEntity.ok().build();
	}
}
