package com.rockstudios.domain;
// Generated Aug 19, 2016 1:16:32 PM by Hibernate Tools 4.0.0.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * CourseProgram generated by hbm2java
 */
@Entity
@Table(name = "course_program", catalog = "rockstudios")
public class CourseProgram extends AbstractDomain implements java.io.Serializable {

	private Course course;
	private Program program;
	private String courseProgramName;
	private String status;
	private Date createdDate;
	private String duration;
	private String description;
	private Set<CourseProgramBatchStudent> courseProgramBatchStudents = new HashSet<CourseProgramBatchStudent>(0);

	public CourseProgram() {
	}

	public CourseProgram(String id, Course course, Program program, String courseProgramName, String status,
			Date createdDate, String duration) {
		this.id = id;
		this.course = course;
		this.program = program;
		this.courseProgramName = courseProgramName;
		this.status = status;
		this.createdDate = createdDate;
		this.duration = duration;
	}

	public CourseProgram(String id, Course course, Program program, String courseProgramName, String status,
			Date createdDate, String duration, String description,
			Set<CourseProgramBatchStudent> courseProgramBatchStudents) {
		this.id = id;
		this.course = course;
		this.program = program;
		this.courseProgramName = courseProgramName;
		this.status = status;
		this.createdDate = createdDate;
		this.duration = duration;
		this.description = description;
		this.courseProgramBatchStudents = courseProgramBatchStudents;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "course_id", nullable = false)
	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "program_id", nullable = false)
	public Program getProgram() {
		return this.program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}

	@Column(name = "course_program_name", nullable = false, length = 100)
	public String getCourseProgramName() {
		return this.courseProgramName;
	}

	public void setCourseProgramName(String courseProgramName) {
		this.courseProgramName = courseProgramName;
	}

	@Column(name = "status", nullable = false, length = 45)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", nullable = false, length = 19)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "duration", nullable = false, length = 45)
	public String getDuration() {
		return this.duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	@Column(name = "description", length = 500)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "courseProgram", cascade = CascadeType.ALL)
	public Set<CourseProgramBatchStudent> getCourseProgramBatchStudents() {
		return this.courseProgramBatchStudents;
	}

	public void setCourseProgramBatchStudents(Set<CourseProgramBatchStudent> courseProgramBatchStudents) {
		this.courseProgramBatchStudents = courseProgramBatchStudents;
	}

}
