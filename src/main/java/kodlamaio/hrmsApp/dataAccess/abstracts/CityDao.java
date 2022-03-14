package kodlamaio.hrmsApp.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrmsApp.entities.concretes.City;

public interface CityDao extends JpaRepository<City, Integer>{

	City findByCityId(int id);
	City findByCityName(String cityName);
}
