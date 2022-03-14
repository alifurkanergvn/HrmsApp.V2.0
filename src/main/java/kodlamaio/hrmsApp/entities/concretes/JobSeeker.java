package kodlamaio.hrmsApp.entities.concretes;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name="job_seeker")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@PrimaryKeyJoinColumn(name="id", referencedColumnName = "user_id")

public class JobSeeker extends Users {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "id")
//	private int id;
	
	//@Column(name="user_id")
	//private int userId;
	@NotNull
	@NotBlank
	@Column(name="names")
	private String name;
	
	@NotNull
	@NotBlank
	@Column(name="surnames")
	private String surname;
	
	@NotNull
	@NotBlank
	@Size(min = 11,max = 11)
	@Column(name="identity_no")
	private long identityNo;
	
	@NotNull
	@NotBlank
	@Size(min = 4,max = 4)
	@Column(name="year_of_birth")
	private int yearOfBirth;
	
//	//CascadeType users larda silinme veya eklenmede otomatik düzenleme yapar
//	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//	@JoinColumn(name= "user_id", referencedColumnName = "user_id")
//	private Users users;
	
}
