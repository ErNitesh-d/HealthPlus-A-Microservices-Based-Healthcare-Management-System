package com.tcs.billingmicroservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.billingmicroservice.entity.Billing;

public interface BillingRepo extends JpaRepository<Billing, Integer>{

}
