package student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<Student, String>{
	@Query(value = "select * from student where id like %?1%", nativeQuery = true)
	public Student searchById(String id);
}
