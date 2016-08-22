package com.rockstudios.domain;
// Generated Aug 19, 2016 1:16:32 PM by Hibernate Tools 4.0.0.Final

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * CourseProgramBatchStudent generated by hbm2java
 */
@Entity
@Table(name = "course_program_batch_student", catalog = "rockstudios")
public class CourseProgramBatchStudent implements java.io.Serializable {

	private String id;
	private Users users;
	private CourseProgram courseProgram;
	private CourseBatch courseBatch;
	private BigDecimal registeredFee;
	private BigDecimal payableFee;
	private BigDecimal paidFee;
	private String dueAmount;
	private Date startDate;
	private Date endDate;
	private int dueDays;
	private String status;
	private String dueDate;
	private String description;
	private Set<Payment> payments = new HashSet<Payment>(0);

	public CourseProgramBatchStudent() {
	}

	public CourseProgramBatchStudent(String id, Users users, CourseProgram courseProgram, CourseBatch courseBatch,
			BigDecimal registeredFee, BigDecimal payableFee, BigDecimal paidFee, String dueAmount, Date startDate,
			Date endDate, int dueDays, String status, String dueDate) {
		this.id = id;
		this.users = users;
		this.courseProgram = courseProgram;
		this.courseBatch = courseBatch;
		this.registeredFee = registeredFee;
		this.payableFee = payableFee;
		this.paidFee = paidFee;
		this.dueAmount = dueAmount;
		this.startDate = startDate;
		this.endDate = endDate;
		this.dueDays = dueDays;
		this.status = status;
		this.dueDate = dueDate;
	}

	public CourseProgramBatchStudent(String id, Users users, CourseProgram courseProgram, CourseBatch courseBatch,
			BigDecimal registeredFee, BigDecimal payableFee, BigDecimal paidFee, String dueAmount, Date startDate,
			Date endDate, int dueDays, String status, String dueDate, String description, Set<Payment> payments) {
		this.id = id;
		this.users = users;
		this.courseProgram = courseProgram;
		this.courseBatch = courseBatch;
		this.registeredFee = registeredFee;
		this.payableFee = payableFee;
		this.paidFee = paidFee;
		this.dueAmount = dueAmount;
		this.startDate = startDate;
		this.endDate = endDate;
		this.dueDays = dueDays;
		this.status = status;
		this.dueDate = dueDate;
		this.description = description;
		this.payments = payments;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false, length = 100)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "users_id", nullable = false)
	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "course_program_id", nullable = false)
	public CourseProgram getCourseProgram() {
		return this.courseProgram;
	}

	public void setCourseProgram(CourseProgram courseProgram) {
		this.courseProgram = courseProgram;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "course_batch_id", nullable = false)
	public CourseBatch getCourseBatch() {
		return this.courseBatch;
	}

	public void setCourseBatch(CourseBatch courseBatch) {
		this.courseBatch = courseBatch;
	}

	@Column(name = "registered_fee", nullable = false, precision = 7)
	public BigDecimal getRegisteredFee() {
		return this.registeredFee;
	}

	public void setRegisteredFee(BigDecimal registeredFee) {
		this.registeredFee = registeredFee;
	}

	@Column(name = "payable_fee", nullable = false, precision = 7)
	public BigDecimal getPayableFee() {
		return this.payableFee;
	}

	public void setPayableFee(BigDecimal payableFee) {
		this.payableFee = payableFee;
	}

	@Column(name = "paid_fee", nullable = false, precision = 7)
	public BigDecimal getPaidFee() {
		return this.paidFee;
	}

	public void setPaidFee(BigDecimal paidFee) {
		this.paidFee = paidFee;
	}

	@Column(name = "due_amount", nullable = false, length = 45)
	public String getDueAmount() {
		return this.dueAmount;
	}

	public void setDueAmount(String dueAmount) {
		this.dueAmount = dueAmount;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "start_date", nullable = false, length = 19)
	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "end_date", nullable = false, length = 19)
	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Column(name = "due_days", nullable = false)
	public int getDueDays() {
		return this.dueDays;
	}

	public void setDueDays(int dueDays) {
		this.dueDays = dueDays;
	}

	@Column(name = "status", nullable = false)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "due_date", nullable = false, length = 45)
	public String getDueDate() {
		return this.dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	@Column(name = "description", length = 500)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "courseProgramBatchStudent")
	public Set<Payment> getPayments() {
		return this.payments;
	}

	public void setPayments(Set<Payment> payments) {
		this.payments = payments;
	}

}
