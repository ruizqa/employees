package employees.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import employees.models.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
	
	List<Employee> findAll();
	Optional<Employee> findById(Integer id);

}
