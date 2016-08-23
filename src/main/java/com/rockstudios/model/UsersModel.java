package com.rockstudios.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("usersModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class UsersModel extends AbstractModel {

	private String userName;
	private String emailId;
	private String phoneNo;
	private String status;
	private String userCode;
	private String userCount;
	private String createdDate;
	private String userType;
	private String password;
	private String confirmPassword;
	private String emailStatus;
	private String gender;
	private List<PaymentModel> paymentModels = new ArrayList<PaymentModel>(0);
	private List<CourseProgramBatchStudentModel> courseProgramBatchStudentModels = new ArrayList<CourseProgramBatchStudentModel>(
			0);
	private List<RolesModel> rolesModels = new ArrayList<RolesModel>(0);

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserCount() {
		return userCount;
	}

	public void setUserCount(String userCount) {
		this.userCount = userCount;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailStatus() {
		return emailStatus;
	}

	public void setEmailStatus(String emailStatus) {
		this.emailStatus = emailStatus;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<PaymentModel> getPaymentModels() {
		return paymentModels;
	}

	public void setPaymentModels(List<PaymentModel> paymentModels) {
		this.paymentModels = paymentModels;
	}

	public List<CourseProgramBatchStudentModel> getCourseProgramBatchStudentModels() {
		return courseProgramBatchStudentModels;
	}

	public void setCourseProgramBatchStudentModels(
			List<CourseProgramBatchStudentModel> courseProgramBatchStudentModels) {
		this.courseProgramBatchStudentModels = courseProgramBatchStudentModels;
	}

	public List<RolesModel> getRolesModels() {
		return rolesModels;
	}

	public void setRolesModels(List<RolesModel> rolesModels) {
		this.rolesModels = rolesModels;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

}
