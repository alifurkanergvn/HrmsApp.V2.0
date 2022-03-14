package kodlamaio.hrmsApp.entities.dtos;

import java.sql.Date;
import java.time.LocalDateTime;

import javax.validation.constraints.Null;

import antlr.collections.impl.IntRange;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAnnouncementDto {

	private int id;
	private int cityId;
	private int employerId;
	private int jobPositionId;
	private String jobExplanation;
	private String description;
	private String cityName;
	private int minSalary;
	private int maxSalary;
	private String companyName;
	private Date applicationDeadline;
	private int openPositions;
	private boolean isActive;
	
	@Null(message = "must be null")
    private LocalDateTime releaseDateTime = LocalDateTime.now();
	
}
