package ui;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import model.Doctor;

public class UIPatientMenu {
    
    public static void showPatientMenu() {
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("Patient");
            System.out.println("Welcome " + UIMenu.patientLogged.getFirstName());
            System.out.println("1. Book an appointment");
            System.out.println("2. My appointments");
            System.out.println("0. Logout");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    showBookAppointmentMenu();
                    break;
                case 2:
                    showPatientMyAppointments();
                    break;
                case 0:
                    UIMenu.showMenu();
                    break;
            }
        }while (response != 0);
    }

    private static void showBookAppointmentMenu() {
        int response = 0;

        do {
            System.out.println("::Book an appointment");
            System.out.println("::Select date: ");
            System.out.println("0. Return");

            //Numeración de la lista de fechas que estan disponibles para agendar
            Map<Integer,Map<Integer,Doctor>> doctorsMap = new TreeMap<>();
            int k = 0;
            for (int i = 0; i < UIDoctorMenu.doctorsAvailableAppointments.size(); i++) {
                /**
                 * Coleccion de objetos de tipo AvailableAppointments (Clase interna de Doctor)
                 * Los datos los toma de la coleccion de doctores que tienen citas disponibles.(El arreglo que se está recorrendo)
                 */
                ArrayList<Doctor.AvailableAppointment> availableAppointments = 
                UIDoctorMenu.doctorsAvailableAppointments.get(i).getAvailableAppointments();

                System.out.println("-> Dr. " + UIDoctorMenu.doctorsAvailableAppointments.get(i).getFirstName());
                Map<Integer, Doctor> doctorsAppointments = new TreeMap<>();

                for (int j = 0; j < availableAppointments.size(); j++) {
                    k++;
                    System.out.println(" --->"+ k + ". "+availableAppointments.get(j).getDate());
                    doctorsAppointments.put(Integer.valueOf(j), UIDoctorMenu.doctorsAvailableAppointments.get(i));
                    doctorsMap.put(Integer.valueOf(k), doctorsAppointments);
                }
            }

            Scanner sc = new Scanner(System.in);
            int responseDateSelected = Integer.valueOf(sc.nextLine());
            //Despues que el usuario seleccione la fecha para su cita. Vamos a mostrar información resumida de la cita para confirmar.
            Map<Integer, Doctor> doctorAvailableSelected = doctorsMap.get(responseDateSelected); //Mapa donde guardamos la respuesta seleccionada.
            //Variables para guardar el indice y el doctor seleccionado, se obtiene de doctorAvailableSelected 
            Integer indexDate = 0;
            Doctor doctorSelected = new Doctor("null", "null", "null");
            
            for (Map.Entry<Integer,Doctor> docEntry : doctorAvailableSelected.entrySet()) {
                indexDate = docEntry.getKey();
                doctorSelected = docEntry.getValue();
            }

            System.out.println(" Appointment summary: \n Doctor: " + doctorSelected.getFirstName()+ " " + doctorSelected.getLastName() + 
                        " .Date: "+ doctorSelected.getAvailableAppointments().get(indexDate).getDate() + ". Time: " + 
                        doctorSelected.getAvailableAppointments().get(indexDate).getTime());

            System.out.println("Confirm your appointment: \n 1. Yes \n 2. Change Data");
            response = Integer.valueOf(sc.nextLine());

            if (response == 1) {
                UIMenu.patientLogged.AddAppointmentDoctor(doctorSelected,
                        doctorSelected.getAvailableAppointments().get(indexDate).getDate(null), //Date es null ya que ese metodo nos devuelve el objeto de tipo Date
                        doctorSelected.getAvailableAppointments().get(indexDate).getTime());
                System.out.println("Your appointment is confirmed!");
                showPatientMenu();

            } else if (response == 2) continue;

        } while (response != 0);
        
    }
    
    private static void showPatientMyAppointments() {
        int response = 0;
        do {
            System.out.println(":: My Appointments");
            if (UIMenu.patientLogged.getAppointmentDoctor().size() == 0) {
                System.out.println("you don't have scheduled appointments yet");
                break;
            }
            for (int i = 0; i < UIMenu.patientLogged.getAppointmentDoctor().size(); i++) {
                int j = i +1;
                System.out.println(j + ". " +
                    " Date: "+UIMenu.patientLogged.getAppointmentDoctor().get(i).getDate() +
                    " Time: "+ UIMenu.patientLogged.getAppointmentDoctor().get(i).getTime()+
                    " Doctor: "+UIMenu.patientLogged.getAppointmentDoctor().get(i).getDoctor().getFirstName());
            }
        } while (response != 0);
    }
}
