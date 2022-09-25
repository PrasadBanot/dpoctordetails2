package com.DoctorDetails.DoctorDetails.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.DoctorDetails.DoctorDetails.Entity.Doctor;
import com.DoctorDetails.DoctorDetails.Repository.DoctorRepository;

@Service
public class DoctorService {
	@Autowired
	private DoctorRepository repository;
	
	public boolean addDoctor (Doctor dr) {
		if(already(dr.getId()))
			return true;
		repository.save(dr);
		    return false;
	}
    private boolean already(int id) {
				
				 repository.existsById(id);
				 return true;
	}
	public List<Doctor> saveDoctor(List<Doctor> doctors){
		return repository.saveAll(doctors);
	}
	public List<Doctor> getDoctors(){
		return repository.findAll();
	}
	public Doctor getDoctorById(int id) {
		return repository.findById(id).orElse(null);
	}
	public Doctor getDoctorByName(String name) {
		return repository.findByName(name);
	}
	public Doctor getDoctorBysalary(int salary) {
		return repository.findBySalary(salary);
	}
	public String deleteDoctor(int id) {
		repository.deleteById(id);
		return "doctor removed sucessfully" + id;
	}
	public Doctor updateDoctor(Doctor doctor) {
		Doctor existingDoctor= repository.findById(doctor.getId()).orElse(null);
		existingDoctor.setName(doctor.getName());
		existingDoctor.setSalary(doctor.getSalary());
		existingDoctor.setSpecialist(doctor.getSpecialist());
		return repository.save(existingDoctor);
	}
	public List<Doctor> findDoctorWithSorting(String field){
		return repository.findAll(Sort.by(Sort.Direction.DESC, field));
	}
	 
	   
}
