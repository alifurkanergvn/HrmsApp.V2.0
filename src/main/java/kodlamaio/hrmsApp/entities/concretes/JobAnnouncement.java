package kodlamaio.hrmsApp.entities.concretes;

import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name ="job_announcements")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class JobAnnouncement {
	
	@Id
	@Column(name = "job_announcement_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "description")
	private String description;
	
	@Column(name = "open_positions")
	private int openPositions;
	
	@Column(name = "application_deadline")
	private Date applicationDeadline;
	
	@Null(message = "must be null")
	@Column(name = "release_date_time")
	private LocalDateTime releaseDateTime = LocalDateTime.now();
	
	@Column(name = "is_active")
	private boolean isActive;
	
	@Column(name = "min_salary")
	private int minSalary;
	
	@Column(name = "max_salary")
	private int maxSalary;
	
	
	@NotNull
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "city_id")
	private City city;
	
	@NotNull
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employer_id",referencedColumnName = "id")
	private Employer employer;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "job_positions_id", referencedColumnName = "id")
	private JobPositions jobPositions;
	

}
