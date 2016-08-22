package com.rockstudios.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("courseProgramBatchStudentModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CourseProgramBatchStudentModel extends AbstractModel {

	private String usersId;
	private String courseProgramId;
	private String courseBatchId;
	private String registeredFee;
	private String payableFee;
	private String paidFee;
	private String dueAmount;
	private String startDate;
	private String endDate;
	private String dueDays;
	private String status;
	private String dueDate;
	private String description;
	private List<PaymentModel> paymentModels = new ArrayList<PaymentModel>(0);

	public String getUsersId() {
		return usersId;
	}

	public void setUsersId(String usersId) {
		this.usersId = usersId;
	}

	public String getCourseProgramId() {
		return courseProgramId;
	}

	public void setCourseProgramId(String courseProgramId) {
		this.courseProgramId = courseProgramId;
	}

	public String getCourseBatchId() {
		return courseBatchId;
	}

	public void setCourseBatchId(String courseBatchId) {
		this.courseBatchId = courseBatchId;
	}

	public String getRegisteredFee() {
		return registeredFee;
	}

	public void setRegisteredFee(String registeredFee) {
		this.registeredFee = registeredFee;
	}

	public String getPayableFee() {
		return payableFee;
	}

	public void setPayableFee(String payableFee) {
		this.payableFee = payableFee;
	}

	public String getPaidFee() {
		return paidFee;
	}

	public void setPaidFee(String paidFee) {
		this.paidFee = paidFee;
	}

	public String getDueAmount() {
		return dueAmount;
	}

	public void setDueAmount(String dueAmount) {
		this.dueAmount = dueAmount;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getDueDays() {
		return dueDays;
	}

	public void setDueDays(String dueDays) {
		this.dueDays = dueDays;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<PaymentModel> getPaymentModels() {
		return paymentModels;
	}

	public void setPaymentModels(List<PaymentModel> paymentModels) {
		this.paymentModels = paymentModels;
	}

}
