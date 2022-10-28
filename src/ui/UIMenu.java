package ui;

import java.util.ArrayList;
import java.util.Scanner;

import model.Doctor;
import model.Patient;

public class UIMenu {

    public static final String MONTHS[] = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }; 
    public static Doctor doctorLogged;
    public static Patient patientLogged;

    public static void showMenu(){
        System.out.println("Welcome to My Appointments");
        System.out.println("Selecciona la opción deseada");

        int response = 0;
        do {
            System.out.println("1. Doctor");
            System.out.println("2. Patient");
            System.out.println("0. Salir");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    response = 0;
                    authUser(1);
                    break;
                case 2:
                    response = 0;
                    authUser(2);

                    break;
                case 0:
                    System.out.println("Thank you for you visit");
                    break;
                default:
                    System.out.println("Please select a correct answer");
            }
        }while (response != 0);
    }

    public static void showPatientMenu(){
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("Patient");
            System.out.println("1. Book an appointment");
            System.out.println("2. My appointments");
            System.out.println("0. Return");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    System.out.println("::Book an appointment");
                    
                    for (int i = 1; i < 4; i++) {
                        System.out.println(i + ". " + MONTHS[i-1]);
                    }

                    break;
                case 2:
                    System.out.println("::My appointments");
                    break;
                case 0:
                    showMenu();
                    break;
            }
        }while (response != 0);
    }

    public static void authUser(int userType) {  //Simulación de autenticación de usuarios
        //userType = 1 Doctor
        //UserType = 2 Patient
        
        ArrayList<Doctor> doctors = new ArrayList<>();
        doctors.add(new Doctor("Alejandro", "Martinez", "alejandro@mail.com"));
        doctors.add(new Doctor("Karen", "Sosa", "karen@mail.com"));
        doctors.add(new Doctor("Rocío", "Gómez", "rocio@mail.com"));

        ArrayList<Patient> patients = new ArrayList<>();
        patients.add(new Patient("Guadalupe", "Lopez", "lupita@mail.com"));
        patients.add(new Patient("Anahí", "Salgado", "anahi@mail.com"));
        patients.add(new Patient("Roberto", "Rodríguez", "roberto@mail.com"));

        boolean emailCorrect = false;
        do {
            System.out.println("Insert your email: [user@mail.com]");
            Scanner sc = new Scanner(System.in);
            String email = sc.nextLine();
            if (userType == 1) {
                for (Doctor doc : doctors) {
                    if (doc.getEmail().equals(email)) {
                        emailCorrect = true;
                        //Obtener los datos del usuario legeado.
                        doctorLogged = doc;
                        //Mostrar el menú del doctor
                    }
                }
            } 
            if (userType == 2) {
                for (Patient pat : patients) {
                    if (pat.getEmail().equals(email)) { //Verificar si el email ingresado coincide con los regsitrados en BD
                        emailCorrect = true;
                        //Obtener los datos del usuario loggeado.
                        patientLogged = pat;
                        //Mostrar el menú del paciente.
                        showPatientMenu();

                    }
                }
            }
        
        } while (!emailCorrect); //Solicitar el correo mientras que emailCorrect sea falso

    }
}