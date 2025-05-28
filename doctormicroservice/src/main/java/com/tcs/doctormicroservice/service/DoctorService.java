package com.tcs.doctormicroservice.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.doctormicroservice.dto.DoctorDto;
import com.tcs.doctormicroservice.entity.Doctor;
import com.tcs.doctormicroservice.repo.DoctorRepo;

import jakarta.transaction.Transactional;

@Service
public class DoctorService {
	
	@Autowired
	private DoctorRepo doctorRepo;

	public DoctorDto createDoctor(DoctorDto doctorDto) {
		
		Doctor doctor = new Doctor();
		BeanUtils.copyProperties(doctorDto, doctor);
	    doctorRepo.save(doctor);
	    return convertToDto(doctor);
	}

	
	public List<DoctorDto> getAllDoctors() {
		return doctorRepo.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
	}

	public Optional<DoctorDto> getDoctorById(int id) {
		
		return doctorRepo.findById(id).map(this::convertToDto);
	}

	@Transactional
	public void deleteById(int id) {
	    if (doctorRepo.existsById(id)) {
	        doctorRepo.deleteById(id);
	    } else {
	        throw new RuntimeException("Doctor with ID " + id + " not found.");
	    }
	}


	@Transactional
    public DoctorDto updateById(int id, DoctorDto doctorDto) {
        Optional<Doctor> existingDoctorOpt = doctorRepo.findById(id);

        if (existingDoctorOpt.isPresent()) {
            Doctor existingDoctor = existingDoctorOpt.get();

            // Update only non-null values
            existingDoctor.setFirstName(doctorDto.getFirstName());
            existingDoctor.setLastName(doctorDto.getLastName());
            existingDoctor.setExperience(doctorDto.getExperience());

            // Save updated entity
            Doctor updatedDoctor = doctorRepo.save(existingDoctor);
            
            return convertToDto(updatedDoctor);  // Convert entity to DTO
        } else {
            throw new RuntimeException("Doctor with ID " + id + " not found.");
        }
    }
	
	private DoctorDto convertToDto(Doctor doctor) {
		DoctorDto doctorDTO = new DoctorDto();
        BeanUtils.copyProperties(doctor, doctorDTO);
        return doctorDTO;
	}

}
