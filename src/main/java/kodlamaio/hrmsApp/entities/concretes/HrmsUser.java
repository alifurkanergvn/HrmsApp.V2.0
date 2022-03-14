package kodlamaio.hrmsApp.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="hrms_users")
@Data
public class HrmsUser {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name="user_id")
	private int userId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="surname")
	private String surname;
	
	

}
