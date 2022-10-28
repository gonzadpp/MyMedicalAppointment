package ui;

import java.util.Scanner;

public class UIDoctorMenu {
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
                int j = i++;
                System.out.println(j + ". " +UIMenu.MONTHS[i]);
            }
            System.out.println("0. Return");
            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            if (response > 0 && response<4) { //Solo si la respuesta es 1,2 o 3 (Alguno de los meses mostrados)
                
                int monthSelected = response;
                System.out.println(monthSelected+ " . " + UIMenu.MONTHS[monthSelected]);
                System.out.println("Instert the date availanle: [dd/mm/yyyy]");
                String date = sc.nextLine();
                System.out.println("Your date is: "+ date+"\n1. Correct \2. Change date");

            } else if(response==0){
                showDoctorMenu();
            }

        } while (response != 0);
    }
}
