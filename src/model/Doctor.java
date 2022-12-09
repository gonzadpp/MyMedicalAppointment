package model;

import java.text.SimpleDateFormat;
import java.util.*;

public class Doctor extends User {
    
    private String speciality;
    private String license;
    private ArrayList<AvailableAppointment> availableAppointments = new ArrayList<>(); //Colección de citas disponibles.

    public Doctor(String firstName, String lastName, String email) {
        super(firstName, lastName, email);
        
    }
    
    public void showDoctor() {
        System.out.println("Doctor: " + super.getFirstName() + " " + super.getLastName() );
    }
    //GETTERS AND SETTERS
    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    
    //Metodo a nivel de la clase Doctro que añade una cita(Objeto AvailableAppointment) al array list
    public void addAvailableAppointment(String date, String time) {   
        availableAppointments.add(new Doctor.AvailableAppointment(date, time)); 
    }

    public ArrayList<AvailableAppointment> getAvailableAppointments() { //Devuelve la lista completa de las citas agendadas.
        return availableAppointments;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString() + " Speciality: " + speciality + ", License: "+license+ "Avaliable: "+availableAppointments.toString();
    }
        /**
         * Clase anidada a la clase Doctor.java
         * La clase AvailableAppointment se usa para las citas disponibles que tenga el doctor.
         */
        public static class AvailableAppointment {
            private int id_availableAppointment; //ID de la cita para identificar   
            private Date date; //Fecha de la cita 
            private String time; //Hora de la cita
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy");

            //Constructor
            private AvailableAppointment(String date, String time) {
                try {
                    this.date = format.parse(date);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.time = time;
            }

                //GETTERS AND SETTERS
            public int getId_availableAppointment() {
                return id_availableAppointment;
            }
            public void setId_availableAppointment(int id_availableAppointment) {
                this.id_availableAppointment = id_availableAppointment;
            }
            public Date getDate(String DATE) {
                return date;
            }
            public String getDate() { //Sobrecargamos el metodo getDate() para que devuelva date en String
                return format.format(date);
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
            public String toString() {
                // TODO Auto-generated method stub
                return "\nDate: " + date + ", Time: "+ time;
            }
            
        }
        @Override
        public void showDataUser() {
            // TODO Auto-generated method stub
            System.out.println("Hospital: HR N° 24");
            System.out.println("Área: Pediatria");
        }
}
