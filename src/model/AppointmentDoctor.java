package model;

import java.util.Date;

public class AppointmentDoctor implements ISchedulable{
    private int id_appointment = 0;
    private Patient patient;
    private Doctor doctor;
    private Date date;
    private String time;

    public AppointmentDoctor(Patient patient, Doctor doctor) {
        this.patient = patient;
        this.doctor = doctor;
    }
    public int getId_appointment() {
        return id_appointment;
    }
    public void setId_appointment(int id_appointment) {
        this.id_appointment = id_appointment;
    }
    public Patient getPatient() {
        return patient;
    }
    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    public Doctor getDoctor() {
        return doctor;
    }
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public String getTime() {
        return time + " hrs.";
    }
    public void setTime(String time) {
        this.time = time;
    }
    @Override
    public void schedule(Date date, String time) {
        // TODO Auto-generated method stub
        this.date = date;
        this.time = time;
    }

    
}
