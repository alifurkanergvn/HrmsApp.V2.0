package kodlamaio.hrmsApp.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrmsApp.entities.concretes.JobAnnouncement;

public interface JobAnnouncementDao extends JpaRepository<JobAnnouncement, Integer>{
	
	List<JobAnnouncement> findAllByIsActiveTrue();
	//	@Query("From JobAnnouncement where isActive=true")   //Tüm aktif iş ilanları gösterilir.
	//List<JobAnnouncement> getByIsActiveTrue();  //getBy tanımlaması yaparken JobAdvertisement clasında "active" nasıl tanımlamışsak öyle yazmalıyız

	
	@Query("From JobAnnouncement where isActive=true Order By applicationDeadline Desc")
	List<JobAnnouncement>getByIsActiveTrueOrderByApplicationDeadlineDesc(Sort sort); // Aktif iş ilanları tarihe göre listelenir.
	//List<JobAnnouncement> findAllByOrderByApplicationDeadlineAsc(); 
	
	
	List<JobAnnouncement> findAllByEmployer_CompanyNameAndIsActiveTrue(String companyName);
	
	
	//List<JobAnnouncement> findAllByEmployer_CompanyNameAndIsActiveTrue(@Param("companyName") String companyName);
	
	
	
}
