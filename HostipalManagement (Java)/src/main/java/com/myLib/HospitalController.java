package com.myLib;

import com.myLib.model.*;
import com.myLib.service.*;
import java.util.List;
/*
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
*/
import org.springframework.web.bind.annotation.*;

@RestController
public class HospitalController {
	
	public final DoctorService docService;
	public final PatientService patService;
	public final AppointmentService aService;
	
	public HospitalController(DoctorService d, PatientService p, AppointmentService a)
	{
		this.docService=d;
		this.patService=p;
		this.aService=a;
	}
	
	@RequestMapping("/")
	public String home()
	{
		return "Hello";
	}
	
	//Doctors
	@CrossOrigin("http://localhost:4200")
	@GetMapping("/getDoctor/")
	@ResponseBody
	public Doctor getDoctor(@RequestParam String id)
	{
		return docService.findDoctor(id);
	}
	@CrossOrigin("http://localhost:4200")
	@PostMapping("/addDoctor")
	public Doctor addDoctor(@RequestBody Doctor d)
	{
	return docService.addDoctor(d);
		
	}
	
	@GetMapping("/getDoctors")
	public List<Doctor> getAllDoctors()
	{
		List<Doctor> doctors=docService.findallDoctors();
		return doctors;
	}
	
	@DeleteMapping(value = "/deleteDoctor")
	public void deleteDoctor(@RequestParam String id)
	{
		docService.deleteDoctor(id);
	}
	
	//Patient
	@CrossOrigin("http://localhost:4200")
	@GetMapping("/getPatient/")
	public Patient getPatient(@RequestParam String id)
	{
		return patService.findPatient(id);
	}
	@CrossOrigin("http://localhost:4200")
	@PostMapping("/addPatient")
	public void addpatient(@RequestBody Patient p)
	{
		patService.addPatient(p);
	}
	@GetMapping("/getPatients")
	public List<Patient> getPatients()
	{
		return patService.findallPatient();
	}
	@CrossOrigin("http://localhost:4200")
	@DeleteMapping(value = "/deletePatient")
	public void deletePatient(@RequestParam String id)
	{
		patService.deletePatient(id);
	}
	
	
	//Appointment
	@GetMapping("/getAppointments")
	public List<Appointment> getAppointments()
	{
		return aService.getAppointments();
	}
	
	@CrossOrigin("http://localhost:4200")
	@PostMapping("/addAppointment/")
	public void addAppointment(@RequestBody Appointment a)
	{
		aService.addAppointment(a);
	}
	@CrossOrigin("http://localhost:4200")
	@GetMapping("/updateAppointment/")
	public String updateAppoinment(@RequestParam String id, @RequestParam String s)
	{
		aService.updatePrescription(id, s);
		return "Prescription Updated";
	}
}
