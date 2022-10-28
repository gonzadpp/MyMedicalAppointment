package model;

public class Nurse extends User{

    private String speciality;

    public Nurse(String firstName, String lastName, String email) {
        super(firstName, lastName, email);
        //TODO Auto-generated constructor stub
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    @Override
    public void showDataUser() {
        // TODO Auto-generated method stub
        System.out.println("Hospital: Cruz Roja Mexicana");
        System.out.println("Área: Urgencias");
        
    }
    
}
