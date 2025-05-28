package com.tcs.doctormicroservice.controller;



import org.springframework.http.MediaType;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.doctormicroservice.dto.DoctorDto;
import com.tcs.doctormicroservice.service.DoctorService;








@RestController
@RequestMapping("/api/doctors")
public class DoctorController {
	
	@Autowired
	private DoctorService doctorService;
	
	@PostMapping
	public ResponseEntity<DoctorDto> createDoctor(@RequestBody DoctorDto doctorDto) {
		
		 DoctorDto savedDoctor = doctorService.createDoctor(doctorDto);
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(savedDoctor);
	}
	
	@GetMapping
	public List<DoctorDto> getAllDoctors() {
		return doctorService.getAllDoctors();
	}
	
	@GetMapping("/{id}")
	public Optional<DoctorDto> getDoctorById(@PathVariable int id) {
		return doctorService.getDoctorById(id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteById(@PathVariable int id) {
	    doctorService.deleteById(id);
	    String message = "Doctor with ID " + id + " has been deleted successfully!!";
	    System.out.println(message);  // ✅ This prints in the server console
	    return ResponseEntity.ok(message);  // ✅ This sends a response back to the client
	}

	
	@PutMapping("/id/{id}")
    public ResponseEntity<DoctorDto> updateById(@PathVariable int id, @RequestBody DoctorDto doctorDto) {
        DoctorDto updatedDoctor = doctorService.updateById(id, doctorDto);
        return ResponseEntity.ok(updatedDoctor);
    }
}
