package employees.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import employees.models.Employee;
import employees.repositories.EmployeeRepository;


@Service
public class EmployeeService {
	
	private EmployeeRepository repo;
	
	public EmployeeService(EmployeeRepository repo) {
		this.repo = repo;
	}
	
	public Employee saveEmp(Employee emp) {
		return repo.save(emp);
	}
	
	public Optional<Employee> getEmp(Integer id){
		return repo.findById(id);
	}

}
