//import static ui.UIMenu.*;

import java.util.*;
import model.Doctor;

public class App {
    public static void main(String[] args) throws Exception {
        
        Doctor doctorNat = new Doctor("Dania Nataly", "Mingo Lopez", "dania.mingo@mail.com");

        doctorNat.addAvailableAppointment(new Date(), "10 am");
        doctorNat.addAvailableAppointment(new Date(), "12 pm");
        doctorNat.addAvailableAppointment(new Date(), "02 pm");

        System.out.println("Citas disponibles de " + doctorNat);
       //Doctor doctorMari = new Doctor("Maritza", "Herndez", "Nurse");

       // showMenu();
    }
}
