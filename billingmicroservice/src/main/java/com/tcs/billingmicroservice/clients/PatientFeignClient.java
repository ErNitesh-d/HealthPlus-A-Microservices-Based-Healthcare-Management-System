package com.tcs.billingmicroservice.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.tcs.billingmicroservice.dto.PatientDto;

@FeignClient(name = "PATIENT-SERVICE")
public interface PatientFeignClient {
	
	@GetMapping("/api/patients/{id}")  
    PatientDto getPatientById(@PathVariable int id);
}
