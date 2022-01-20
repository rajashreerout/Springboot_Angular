package com.myLib.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myLib.model.Appointment;

public interface AppointmentRepo extends JpaRepository<Appointment, String>{

}
