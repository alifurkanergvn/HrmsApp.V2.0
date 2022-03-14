package kodlamaio.hrmsApp.entities.concretes;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	@NotNull
	@NotBlank
	private int user_id;
	
	@Email(message = "Please enter your email format sample abc@xyz.com")
	@Pattern(regexp = "[a-zA-Z0-9_\\-\\.]+[@][a-z]+[\\.]{2,3}")
	@Column(name="email")
	@NotBlank
	private String email;
	
	@Column(name="password")
	private String password;
	
//	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "users")	
//	private JobSeeker jobSeeker;

}
