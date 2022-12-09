package ui;

import java.util.ArrayList;
import java.util.Scanner;

import model.Doctor;

public class UIDoctorMenu {
    /**En este arreglo se van a guardar todos los doctores que tienen fecha para citas disponibles */
    public static ArrayList<Doctor> doctorsAvailableAppointments = new ArrayList<>();

    public static void showDoctorMenu() {
        int response = 0;
        do {
            System.out.println("\n Doctor \n");
            System.out.println("Welcome "+UIMenu.doctorLogged.getFirstName());
            System.out.println("1. Add Available Appointment");
            System.out.println("2. My Schedule Appointments");
            System.out.println("0. Logout");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response) {
                case 1:
                    showAddAvailableAppointmentsMenu();     
                    break;
                case 2: 
                    break;
                case 0:
                    UIMenu.showMenu();
                    break;
            
                default:
                    break;
            }


        } while (response != 0);
    }

    private static void showAddAvailableAppointmentsMenu() {
        int response = 0;
        do {
            System.out.println();
            System.out.println(":: Add Available Appointment");
            System.out.println(":: Select a mont: ");

            for (int i = 0; i < 3; i++) {
                int j = i+1;                //Debe mostrar los 3 siguientes meses.                
                System.out.println(j + ". " +UIMenu.MONTHS[i]);
            }
            System.out.println("0. Return");
            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            if (response > 0 && response<4) { //Solo si la respuesta es 1,2 o 3 (Alguno de los meses mostrados)
                
                int monthSelected = response;
                System.out.println(monthSelected+ " . " + UIMenu.MONTHS[monthSelected-1]); //Imprime el mes seleccionado.
                System.out.println("Instert the date available: [dd/mm/yyyy]");
                String date = sc.nextLine();
                System.out.println("Your date is: "+ date+"\n1. Correct \2. Change date"); //Confirmación de la fecha o cambiar la fecha
                int responseDate = Integer.valueOf(sc.nextLine()); //1 confirma la fecha y 2 cambia la fecha
                if (responseDate == 2) continue; //Ignora el resto del codigo de este bloque, y vuelve al inicio del [if]

                int responseTime = 0;
                String time = "";
                do {
                    System.out.println("Insert the time available appointment for "+ date + " [00:00]");
                    time = sc.nextLine();
                    System.out.println("Your time is: "+ time+"\n1. Correct \n2. Change date");

                    responseTime = Integer.valueOf(sc.nextLine());
                } while (responseTime ==2);

                UIMenu.doctorLogged.addAvailableAppointment(date, time);
                checkDoctorAvailableAppointment(UIMenu.doctorLogged);

            } else if(response==0){
                showDoctorMenu();
            }

        } while (response != 0);
    }
    /*Metodo que verifica si el objeto doctor del argumento tiene fechas para citas disponibles */
    private static void checkDoctorAvailableAppointment(Doctor doctor) {
        if (doctor.getAvailableAppointments().size() > 0 && !doctorsAvailableAppointments.contains(doctor)) {
            doctorsAvailableAppointments.add(doctor);
        }
    }

}
