package model;

import java.util.Date;

public class AppointmentNourse implements ISchedulable{
    private int id_appointment = 0;
    private Patient patient;
    private Nurse nurse;
    private Date date;
    private String time;
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
    public Nurse getNurse() {
        return nurse;
    }
    public void setNurse(Nurse nurse) {
        this.nurse = nurse;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    @Override
    public void schedule(Date date, String time) {
        // TODO Auto-generated method stub
        
    }


    
}
