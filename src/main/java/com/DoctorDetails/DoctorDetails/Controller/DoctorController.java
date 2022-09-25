package com.DoctorDetails.DoctorDetails.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DoctorDetails.DoctorDetails.Entity.Doctor;
import com.DoctorDetails.DoctorDetails.Service.DoctorService;
import com.DoctorDetails.DoctorException.DoctorException;

@RestController
@RequestMapping("/Dr")
public class DoctorController {
	
	@Autowired
	private DoctorService service;
	
	@GetMapping("/exception")
	public ResponseEntity addDoctor( @RequestBody Doctor doctor) {
		if (service.addDoctor(doctor))
			return new ResponseEntity<>(new DoctorException().getMessage(),HttpStatus.CONFLICT);
		return ResponseEntity.ok(doctor);
	}
	
	@PostMapping("/addDoctors")
	public List<Doctor> addDoctors(@RequestBody List<Doctor> doctors){
		return service.saveDoctor(doctors);
	}
	@GetMapping("/doctors")
	public List<Doctor> findAllDoctors(){
		return service.getDoctors();
	}
	@GetMapping("/Doctors/{id}")
	public Doctor findDoctorById(int id) {
		return service.getDoctorById(id);
	}
	@GetMapping("/doctorsname/{name}")
	public Doctor findDoctorByName(@PathVariable String name) {
		return service.getDoctorByName(name);
	}
	@GetMapping("/doctors/{salary}")
	public Doctor findDoctorBySalary(@PathVariable int salary) {
		return service.getDoctorBysalary(salary);
	}
	@PutMapping("/update")
	public Doctor updateDoctor(@RequestBody Doctor doctor) {
		return service.updateDoctor(doctor);
	}
	@DeleteMapping("/delete/{id}")
	public String deleteDoctor(@PathVariable int id) {
		return service.deleteDoctor(id);
	}
	@GetMapping("/{field}")
	public List<Doctor> getDoctorWithSort(@PathVariable String field){
		List<Doctor>allDoctors = service.findDoctorWithSorting (field);
		return allDoctors;
	}

}
