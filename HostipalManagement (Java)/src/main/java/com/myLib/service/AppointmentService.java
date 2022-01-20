package com.myLib.service;

import com.myLib.repo.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.myLib.model.Appointment;
import com.myLib.model.Doctor;
@Service
public class AppointmentService {
	private final AppointmentRepo aRepo;
	public DoctorService dService;
	@Autowired
	public AppointmentService(AppointmentRepo aRepo, DoctorService d) {
		this.aRepo =aRepo;
		this.dService= d;
	}
	
	public Appointment addAppointment(Appointment a)
	{
		Integer c= (int)(Math.random()*(89999999)+10000000);
		a.setAppointmentId(c.toString());
		
		a.setPrescription("No Prescription yet");
		
		dService.updatePatientAttended(a.getDoctorName());
		
		Doctor d= dService.findDoctor(a.getDoctorName());
		a.setDoctorName(d.getDoctorName());
		
		return aRepo.save(a);
	}
	
	public List<Appointment> getAppointments()
	{
		return aRepo.findAll();
	}
	
	public void updatePrescription(String id, String p)
	{
		Appointment a= aRepo.getById(id);
		a.setPrescription(p);
		aRepo.save(a);
	}

}
