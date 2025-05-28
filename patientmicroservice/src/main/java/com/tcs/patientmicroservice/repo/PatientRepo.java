package com.tcs.patientmicroservice.repo;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.patientmicroservice.entity.Patient;

public interface PatientRepo extends JpaRepository<Patient, Integer>{
	List<Patient> findByGender(String gender);
}
