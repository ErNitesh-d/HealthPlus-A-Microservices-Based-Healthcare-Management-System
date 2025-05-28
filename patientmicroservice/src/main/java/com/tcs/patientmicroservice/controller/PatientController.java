package com.tcs.patientmicroservice.controller;

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

import com.tcs.patientmicroservice.dto.PatientDto;
import com.tcs.patientmicroservice.service.PatientService;

@RestController
@RequestMapping("/api/patients")
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
	@PostMapping
	public PatientDto createPatient(@RequestBody PatientDto patientDto) {
		return patientService.createPatient(patientDto);
	}
	
	@GetMapping
	public List<PatientDto> getAllPatients() {
		return patientService.getAllPatients();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PatientDto> getPatientById(@PathVariable int id) {
		
		Optional<PatientDto> patientDto = patientService.getPatientById(id);
        return patientDto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable int id) {
		
		patientService.deleteById(id);
	}
	
	@GetMapping("/gender/{gender}")
	public  ResponseEntity<List<PatientDto>> getPatientsByGender(@PathVariable String gender) {
		
		List<PatientDto> patients = patientService.getPatientsByGender(gender);
        return ResponseEntity.ok(patients);
	}
}
