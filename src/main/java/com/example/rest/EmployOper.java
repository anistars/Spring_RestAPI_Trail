package com.example.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployOper {
	private static Map<Integer,Employee> employrepo=new HashMap<>();
	static {
		Employee e1=new Employee();
		e1.setEmpid(1);
		e1.setEmpname("Aniket");
		e1.setEmail("an@gmail.com");
		e1.setLocation("Nashik");
		employrepo.put(e1.getEmpid(), e1);
		
		Employee e2=new Employee();
		e2.setEmpid(2);
		e2.setEmpname("vivek");
		e2.setEmail("viv@gmail.com");
		e2.setLocation("Pune");
		employrepo.put(e2.getEmpid(), e2);
		
		Employee e3=new Employee();
		e3.setEmpid(3);
		e3.setEmpname("Tushar");
		e3.setEmail("t@gmail.com");
		e3.setLocation("Mumbai");
		employrepo.put(e3.getEmpid(), e3);
	}
	@RequestMapping(value="/employees",method=RequestMethod.POST)
	public ResponseEntity<Object> createEmployees(@RequestBody Employee employee){
		employrepo.put(employee.getEmpid(), employee);
		return new ResponseEntity<>("Product created succesfully",HttpStatus.CREATED);
	}
	@RequestMapping("/employees")
	public ResponseEntity<Object> getEmployees(){
		return new ResponseEntity<>(employrepo.values(),HttpStatus.OK);
	}
	@RequestMapping(value="/employees/{id}",method=RequestMethod.GET)
	public ResponseEntity<Object> deleteEmployees(@PathVariable("id") int id){
		employrepo.remove(id);
		return new ResponseEntity<>("Product deleted succesfully",HttpStatus.CREATED);
	}
	@RequestMapping(value = "/employees/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateProduct(@PathVariable("id") int id, @RequestBody Employee employee) { 
		employrepo.remove(id);
		employee.setEmpid(id);
		employrepo.put(id, employee);
	      return new ResponseEntity<>("Product is updated successsfully", HttpStatus.OK);
	}
}
