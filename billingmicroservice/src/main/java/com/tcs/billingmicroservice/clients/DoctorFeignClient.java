package com.tcs.billingmicroservice.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.tcs.billingmicroservice.dto.DoctorDto;

@FeignClient(name = "DOCTOR-SERVICE")
public interface DoctorFeignClient {
	
	@GetMapping("/api/doctors/{id}")
	DoctorDto getDoctorById(@PathVariable int id);
}
