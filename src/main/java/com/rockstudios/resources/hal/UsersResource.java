package com.rockstudios.resources.hal;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.core.Relation;

@Relation(value = "users", collectionRelation = "users")
public class UsersResource extends ResourceWithEmdedded {

	private String usersId;
	private String userName;
	private String emailId;
	private String phoneNo;
	private String status;
	private String userCode;
	private String userCount;
	private String createdDate;
	private String userType;
	private String password;
	private String emailStatus;
	private String gender;
	private List<PaymentResource> paymentResources = new ArrayList<PaymentResource>(0);
	private List<CourseProgramBatchStudentResource> courseProgramBatchStudentResources = new ArrayList<CourseProgramBatchStudentResource>(
			0);
	private List<RolesResource> rolesResources = new ArrayList<RolesResource>(0);

	public String getUsersId() {
		return usersId;
	}

	public void setUsersId(String usersId) {
		this.usersId = usersId;
	}

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

	public List<PaymentResource> getPaymentResources() {
		return paymentResources;
	}

	public void setPaymentResources(List<PaymentResource> paymentResources) {
		this.paymentResources = paymentResources;
	}

	public List<CourseProgramBatchStudentResource> getCourseProgramBatchStudentResources() {
		return courseProgramBatchStudentResources;
	}

	public void setCourseProgramBatchStudentResources(
			List<CourseProgramBatchStudentResource> courseProgramBatchStudentResources) {
		this.courseProgramBatchStudentResources = courseProgramBatchStudentResources;
	}

	public List<RolesResource> getRolesResources() {
		return rolesResources;
	}

	public void setRolesResources(List<RolesResource> rolesResources) {
		this.rolesResources = rolesResources;
	}

}
