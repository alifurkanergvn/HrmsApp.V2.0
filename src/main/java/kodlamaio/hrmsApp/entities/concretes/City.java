package kodlamaio.hrmsApp.entities.concretes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "cities")
//@JsonIgnoreProperties({"hibernateLazyInitializer","handler","employers","cities","job","job_advertisments","jobAdvertisments"})
public class City {

	@Id
	@Column(name = "city_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cityId;
	
	@Column(name = "city_name")
	private String cityName;
	
	
	//@JsonIgnore(value=true)
	@OneToMany(mappedBy = "city", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<JobAnnouncement> jobAnnouncements;
	
	
}
