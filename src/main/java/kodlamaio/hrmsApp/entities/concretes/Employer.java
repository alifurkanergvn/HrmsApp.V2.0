package kodlamaio.hrmsApp.entities.concretes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="employers")
@Data
@EqualsAndHashCode(callSuper = false)
@PrimaryKeyJoinColumn(name = "id",referencedColumnName = "user_id")
@JsonIgnoreProperties({"hibernateLazyInitializer","employers"})
public class Employer extends Users {
	
//	@Id
//	@GeneratedValue
//	@Column(name = "id")
//	private int id;
//	
//	@Column(name="user_id")
//	private int userId;
	
	@NotBlank
	@NotEmpty(message = "Please enter your company name")
	@Column(name="company_name")
	private String companyName;
	
	@NotBlank
	@NotEmpty(message = "Please enter your company website")
	@Column(name="company_website")
	private String companyWebsite;
	
	@NotBlank
	@NotEmpty(message = "Please enter your telephone no")
	@Column(name="telephone_no")
	private String telephoneNo;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "employer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<JobAnnouncement> jobAnnouncement;

	
	
	

}
