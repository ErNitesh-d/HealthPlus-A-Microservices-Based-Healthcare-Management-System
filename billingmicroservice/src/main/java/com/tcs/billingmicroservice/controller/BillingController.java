package com.tcs.billingmicroservice.controller;

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

import com.tcs.billingmicroservice.dto.BillingDto;
import com.tcs.billingmicroservice.service.BillingService;

@RestController
@RequestMapping("/api/billing")
public class BillingController {
	
	@Autowired
	private BillingService billingService;
	
	@PostMapping
	public ResponseEntity<BillingDto> createBill(@RequestBody BillingDto billingDto) {
		
		BillingDto bill = billingService.createBill(billingDto);
		return ResponseEntity.ok(bill);
	}
	
	@GetMapping
	public List<BillingDto> getAllBills() {
		
		return billingService.getAllBills();
	}
	
	@GetMapping("/{id}")
	public Optional<BillingDto> getBillById(@PathVariable int id) {
		
		return billingService.getBillById(id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteBillById(@PathVariable int id) {
		
		billingService.deleteBillById(id);
		return ResponseEntity.ok("deleted the bill successfully!!!");
	}
	
	@PutMapping("/id/{id}")
	public ResponseEntity<BillingDto> updateById(@PathVariable int id,@RequestBody BillingDto billingDto) {
		
		BillingDto updatedBill = billingService.updateById(id,billingDto);
		return ResponseEntity.ok(updatedBill);
	}
	
	@GetMapping("/print/{doctorId}/{patientId}/{amount}")
	public String generateBillingMessage(@PathVariable Integer doctorId,@PathVariable Integer patientId,@PathVariable Double amount) {
		return billingService.generateBillingMessage(doctorId, patientId, amount); 
	}
}
