package com.rockstudios.domain;
// Generated Aug 19, 2016 1:16:32 PM by Hibernate Tools 4.0.0.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Users generated by hbm2java
 */
@Entity
@Table(name = "users", catalog = "rockstudios")
public class Users implements java.io.Serializable {

	private String id;
	private String userName;
	private String emailId;
	private String phoneNo;
	private String status;
	private String userCode;
	private int userCount;
	private String createdDate;
	private String userType;
	private String password;
	private String emailStatus;
	private String gender;
	private Set<Payment> payments = new HashSet<Payment>(0);
	private Set<CourseProgramBatchStudent> courseProgramBatchStudents = new HashSet<CourseProgramBatchStudent>(0);
	private Set<Roles> roleses = new HashSet<Roles>(0);

	public Users() {
	}

	public Users(String id, String userName, String phoneNo, String status, String userCode, int userCount,
			String createdDate, String userType, String password, String emailStatus, String gender) {
		this.id = id;
		this.userName = userName;
		this.phoneNo = phoneNo;
		this.status = status;
		this.userCode = userCode;
		this.userCount = userCount;
		this.createdDate = createdDate;
		this.userType = userType;
		this.password = password;
		this.emailStatus = emailStatus;
		this.gender = gender;
	}

	public Users(String id, String userName, String emailId, String phoneNo, String status, String userCode,
			int userCount, String createdDate, String userType, String password, String emailStatus, String gender,
			Set<Payment> payments, Set<CourseProgramBatchStudent> courseProgramBatchStudents, Set<Roles> roleses) {
		this.id = id;
		this.userName = userName;
		this.emailId = emailId;
		this.phoneNo = phoneNo;
		this.status = status;
		this.userCode = userCode;
		this.userCount = userCount;
		this.createdDate = createdDate;
		this.userType = userType;
		this.password = password;
		this.emailStatus = emailStatus;
		this.gender = gender;
		this.payments = payments;
		this.courseProgramBatchStudents = courseProgramBatchStudents;
		this.roleses = roleses;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false, length = 100)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "user_name", nullable = false, length = 100)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "email_id", length = 45)
	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Column(name = "phone_no", nullable = false, length = 45)
	public String getPhoneNo() {
		return this.phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Column(name = "status", nullable = false, length = 45)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "user_code", nullable = false, length = 45)
	public String getUserCode() {
		return this.userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	@Column(name = "user_count", nullable = false)
	public int getUserCount() {
		return this.userCount;
	}

	public void setUserCount(int userCount) {
		this.userCount = userCount;
	}

	@Column(name = "created_date", nullable = false, length = 45)
	public String getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "user_type", nullable = false, length = 45)
	public String getUserType() {
		return this.userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Column(name = "password", nullable = false, length = 100)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "email_status", nullable = false, length = 45)
	public String getEmailStatus() {
		return this.emailStatus;
	}

	public void setEmailStatus(String emailStatus) {
		this.emailStatus = emailStatus;
	}

	@Column(name = "gender", nullable = false, length = 45)
	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
	public Set<Payment> getPayments() {
		return this.payments;
	}

	public void setPayments(Set<Payment> payments) {
		this.payments = payments;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
	public Set<CourseProgramBatchStudent> getCourseProgramBatchStudents() {
		return this.courseProgramBatchStudents;
	}

	public void setCourseProgramBatchStudents(Set<CourseProgramBatchStudent> courseProgramBatchStudents) {
		this.courseProgramBatchStudents = courseProgramBatchStudents;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
	public Set<Roles> getRoleses() {
		return this.roleses;
	}

	public void setRoleses(Set<Roles> roleses) {
		this.roleses = roleses;
	}

}
