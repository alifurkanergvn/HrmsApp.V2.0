package kodlamaio.hrmsApp.entities.concretes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="job_positions")
@Data
@AllArgsConstructor //constructure ve getter setter oluşturuyor
@NoArgsConstructor
public class JobPositions  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="job_explanation",unique = true)
	private String jobExplanation;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobPositions",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<JobAnnouncement>jobAnnouncements;
		
	
	
	
	
	
	
}
	
	
	
	


