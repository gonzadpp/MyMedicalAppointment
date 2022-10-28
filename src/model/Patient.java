package model;


public class Patient extends User{
    
    private String birthday;
    private double weight;
    private double height;
    private String blood;

    public Patient(String firstName, String lastName,String email){
        super(firstName, lastName, email);
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getWeight() {
        return this.weight + " Kg.";
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return height + " Mts.";
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString() + "\n Birthday: " +birthday+", Weight: "+getWeight()+", Height: "+getHeight()+", Blood: "+blood;
    }

    @Override
    public void showDataUser() {
        // TODO Auto-generated method stub
        System.out.println("Paciente");
        System.out.println("Historial completo:");
    }
    
}
