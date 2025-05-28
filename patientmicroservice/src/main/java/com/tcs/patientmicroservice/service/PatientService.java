package com.tcs.patientmicroservice.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.patientmicroservice.dto.PatientDto;
import com.tcs.patientmicroservice.entity.Patient;
import com.tcs.patientmicroservice.repo.PatientRepo;

@Service
public class PatientService {

	@Autowired
	private PatientRepo patientRepo;

	public PatientDto createPatient(PatientDto patientDto) {

		Patient patient = new Patient();
		BeanUtils.copyProperties(patientDto, patient);
		patientRepo.save(patient);

		return convertToDto(patient);
	}
	
	public List<PatientDto> getAllPatients() {
		
		return patientRepo.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
		
	}
	
	public Optional<PatientDto> getPatientById(int id) {
		return patientRepo.findById(id).map(this::convertToDto);
	}
	

	public void deleteById(int id) {
		// TODO Auto-generated method stub
		patientRepo.deleteById(id);
	}

	public List<PatientDto> getPatientsByGender(String gender) {
		// TODO Auto-generated method stub
		return patientRepo.findByGender(gender).stream().map(this::convertToDto).collect(Collectors.toList());
	}
	
	private PatientDto convertToDto(Patient patient) {
        PatientDto patientDTO = new PatientDto();
        BeanUtils.copyProperties(patient, patientDTO);
        return patientDTO;
    }
	
}
