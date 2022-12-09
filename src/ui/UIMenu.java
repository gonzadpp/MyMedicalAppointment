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
        System.out.println("select the desired option");

        int response = 0;
        do {
            System.out.println("1. Doctor");
            System.out.println("2. Patient");
            System.out.println("0. Exit");

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


    public static void authUser(int userType) {  //Simulación de autenticación de usuarios
        //userType = 1 Doctor
        //UserType = 2 Patient
        
        ArrayList<Doctor> doctors = new ArrayList<>();
        doctors.add(new Doctor("Alejandro", "Martinez", "alejandro@mail.com"));
        doctors.add(new Doctor("Karen", "Sosa", "karen@mail.com"));
        doctors.add(new Doctor("Nataly", "Mingo", "nataly@mail.com"));

        //Coleccion de citas disponibles para cada doctor
        

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
                        UIDoctorMenu.showDoctorMenu(); //Mostramos el menu del doctor logeadio
                    }
                }
                if (emailCorrect == false) {
                    System.out.println("The e-mail address and/or password you specified are not correct.");
                }
            } 
            if (userType == 2) {
                for (Patient pat : patients) {
                    if (pat.getEmail().equals(email)) { //Verificar si el email ingresado coincide con los regsitrados en BD
                        emailCorrect = true;
                        //Obtener los datos del usuario loggeado.
                        patientLogged = pat;
                        //Mostrar el menú del paciente.
                        UIPatientMenu.showPatientMenu();

                    }
                }
            }
        
        } while (!emailCorrect); //Solicitar el correo mientras que emailCorrect sea falso

    }
}