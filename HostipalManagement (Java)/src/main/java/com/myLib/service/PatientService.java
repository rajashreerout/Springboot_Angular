package com.myLib.service;

import com.myLib.repo.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myLib.model.Patient;
@Service
public class PatientService {
	private final PatientRepo pRepo;
	public DoctorRepo dRepo;
	@Autowired
	public PatientService(PatientRepo pRepo, DoctorRepo drepo) {
		this.pRepo = pRepo;
		this.dRepo= drepo;
	}
	
	public Patient addPatient(Patient p)
	{
		Integer c= (int)(Math.random()*(89999999)+10000000);
		p.setPatientId(c.toString());
		return pRepo.save(p);
	}

	public List<Patient> findallPatient()
	{
		return pRepo.findAll();
		
	}
	
	public Patient updatePatient(Patient d)
	{
		return pRepo.save(d);
	}
	
	public Patient findPatient(String id)
	{
		return pRepo.findById(id).orElse(null);
	}
	
	public void deletePatient(String id)
	{
		pRepo.deleteById(id);
	}

	
	
}
