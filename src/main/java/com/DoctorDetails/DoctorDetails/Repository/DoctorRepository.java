package com.DoctorDetails.DoctorDetails.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.DoctorDetails.DoctorDetails.Entity.Doctor;
public interface DoctorRepository extends JpaRepository<Doctor,Integer>{

	Doctor findByName(String name);

	Doctor findBySalary(int salary);
	 @Query("FROM Doctor ORDER BY salary ASC")
	    List<Doctor> findAllOrderBysalaryAsc();

}
