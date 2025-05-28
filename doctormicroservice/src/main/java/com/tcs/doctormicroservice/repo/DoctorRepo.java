package com.tcs.doctormicroservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.doctormicroservice.entity.Doctor;

public interface DoctorRepo extends JpaRepository<Doctor, Integer>{
	
}
