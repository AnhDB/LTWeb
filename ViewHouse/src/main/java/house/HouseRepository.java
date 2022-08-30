package house;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface HouseRepository extends JpaRepository<House, String>, CrudRepository<House, String>{
	@Query(value = "select * from house where approved=0", nativeQuery = true)
	public List<House> search();
	@Query(value = "select * from house where id like %?1%", nativeQuery = true)
	public House searchById(String id);
}
