package employees.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import employees.models.Employee;
import employees.services.EmployeeService;

@RestController
public class EmployeesController {
	EmployeeService serv;
	
	public EmployeesController(EmployeeService serv) {
		this.serv = serv;
	}
	
	@GetMapping("/create")
	public void Create(@RequestParam("first_name") String first_name,
			@RequestParam("last_name") String last_name) {
		if(!first_name.equals("") & !last_name.equals("")) {
		Employee emp = new Employee(first_name, last_name);
		this.serv.saveEmp(emp);}
	}
	
	@GetMapping("/findById")
	public Employee GetEmp(@RequestParam("id") Integer id) {
		
		Optional<Employee> emp = serv.getEmp(id);
		if(emp.isPresent()) {
		return emp.get();}
		else {
			return null;
		}
		
	}
	
	@GetMapping("/AssignById")
	public void AssignManager(@RequestParam("emp_id") Integer emp_id, 
			@RequestParam("man_id") Integer man_id) {
		
		Optional<Employee> emp = serv.getEmp(emp_id);
		Optional<Employee> man = serv.getEmp(man_id);
		
		if(emp.isPresent() & man.isPresent() ) {
			emp.get().setManager(man.get());
			serv.saveEmp(emp.get());
		}
		
		
	}
	
	@GetMapping("/getemps")
	public List<Employee> GetEmps(@RequestParam("man_id") Integer man_id) {
		
		Optional<Employee> man = serv.getEmp(man_id);
		
		if( man.isPresent() ) {
			return man.get().getEmployees();}
		
		return null;
		
	}
	
	@GetMapping("/getman")
	public Employee AssignManager(@RequestParam("emp_id") Integer emp_id) {
		
		Optional<Employee> emp = serv.getEmp(emp_id);
		
		if(emp.isPresent()) {
			return emp.get().getManager();}
		
		return null;
	}
	
	
	
	
	
	

}
