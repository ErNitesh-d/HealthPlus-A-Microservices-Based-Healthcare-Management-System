package com.tcs.billingmicroservice.dto;

public class BillingDto {
	private int billId;
	private int patientId;
	private double totalAmount;
	private String paymentStatus;
	public int getBillId() {
		return billId;
	}
	public void setBillId(int billId) {
		this.billId = billId;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public BillingDto(int billId, int patientId, double totalAmount, String paymentStatus) {
		super();
		this.billId = billId;
		this.patientId = patientId;
		this.totalAmount = totalAmount;
		this.paymentStatus = paymentStatus;
	}
	public BillingDto() {
		super();
		// TODO Auto-generated constructor stub
	}
}
