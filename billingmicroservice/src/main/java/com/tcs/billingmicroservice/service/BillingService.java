package com.tcs.billingmicroservice.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.billingmicroservice.clients.DoctorFeignClient;
import com.tcs.billingmicroservice.clients.PatientFeignClient;
import com.tcs.billingmicroservice.dto.BillingDto;
import com.tcs.billingmicroservice.dto.DoctorDto;
import com.tcs.billingmicroservice.dto.PatientDto;
import com.tcs.billingmicroservice.entity.Billing;
import com.tcs.billingmicroservice.repo.BillingRepo;

import jakarta.transaction.Transactional;

@Service
public class BillingService {
	
	@Autowired
	private BillingRepo billingRepo;
	
	@Autowired
	private DoctorFeignClient doctorFeignClient;
	
	@Autowired
	private PatientFeignClient patientFeignClient;
	
	public DoctorDto fetchDoctorDetails(int doctorId) {
        return doctorFeignClient.getDoctorById(doctorId);
    }

	public PatientDto fetchPatientDetails(int patientId) {
        return patientFeignClient.getPatientById(patientId);
    }
	
	public String generateBillingMessage(Integer doctorId, Integer patientId, Double amount) {
	    DoctorDto doctor = doctorFeignClient.getDoctorById(doctorId);
	    PatientDto patient = patientFeignClient.getPatientById(patientId);
	    
	    return "The patient " + patient.getPatientName() + " (ID: " + patientId + 
	           ") who has undergone treatment with Dr. " + doctor.getFirstName() + " " + doctor.getLastName() + 
	           " (ID: " + doctorId + ") paid a bill of " + amount + " successfully.";
	}

	public BillingDto createBill(BillingDto billingDto) {
		
		
		Billing bill = new Billing();
		BeanUtils.copyProperties(billingDto, bill);
		billingRepo.save(bill);
		return convertToDto(bill);
	}

	public List<BillingDto> getAllBills() {

		return billingRepo.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
	}

	public Optional<BillingDto> getBillById(int id) {

		return billingRepo.findById(id).map(this::convertToDto);
	}
    
	@Transactional
	public void deleteBillById(int id) {
		if(billingRepo.existsById(id)) {
			billingRepo.deleteById(id);
		}
		else {
			throw(new RuntimeException("Bill with id "+id+" does not exists!!"));
		}
	}

	@Transactional
	public BillingDto updateById(int id, BillingDto billingDto) {

		Optional<Billing> existingBillOpt = billingRepo.findById(id);

        if (existingBillOpt.isPresent()) {
            Billing existingBill = existingBillOpt.get();

            // Update only non-null values
            existingBill.setBillId(billingDto.getBillId());
            existingBill.setPatientId(billingDto.getPatientId());
            existingBill.setTotalAmount(billingDto.getTotalAmount());
            existingBill.setPaymentStatus(billingDto.getPaymentStatus());

            // Save updated entity
            Billing updatedBill = billingRepo.save(existingBill);
            
            return convertToDto(updatedBill);  // Convert entity to DTO
        } else {
            throw new RuntimeException("Doctor with ID " + id + " not found.");
        }
	}
	
	private BillingDto convertToDto(Billing bill) {
		
		
		BillingDto billingDto = new BillingDto();
		BeanUtils.copyProperties(bill, billingDto);
		return billingDto;
	}

	
}
