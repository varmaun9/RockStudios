package com.rockstudios.model;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("paymentModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PaymentModel extends AbstractModel {

	private String usersId;
	private String courseProgramBatchStudentId;
	private String payableAmount;
	private String paidAmount;
	private String dueAmount;
	private String paymentDate;
	private String createdDate;
	private String status;
	private String comments;

	public String getUsersId() {
		return usersId;
	}

	public void setUsersId(String usersId) {
		this.usersId = usersId;
	}

	public String getCourseProgramBatchStudentId() {
		return courseProgramBatchStudentId;
	}

	public void setCourseProgramBatchStudentId(String courseProgramBatchStudentId) {
		this.courseProgramBatchStudentId = courseProgramBatchStudentId;
	}

	public String getPayableAmount() {
		return payableAmount;
	}

	public void setPayableAmount(String payableAmount) {
		this.payableAmount = payableAmount;
	}

	public String getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(String paidAmount) {
		this.paidAmount = paidAmount;
	}

	public String getDueAmount() {
		return dueAmount;
	}

	public void setDueAmount(String dueAmount) {
		this.dueAmount = dueAmount;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}
