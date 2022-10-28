package model;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class User {
    private static int id = 0; //Autoincrement - Cada que se cree una instancia el id debe ser diferente por eso se incrementa
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String phoneNumber;

    public User(String firstName, String lastName, String email ){
        this.firstName = firstName;
        this.lastName = lastName;
        setEmail(email); //Lamamos el metodo setEmail para validar si el email ingresado es valido
    }

    public void showId() {
        System.out.println("Id Doctor: " + id);
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        User.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        //Patrón para validar un email.
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcher = pattern.matcher(email);
        if (matcher.find() == true) {
            this.email = email;
        } else {
            System.out.println("El email ingresado es inválido");
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber.length() == 10) { // Validar el número de telefono
            this.phoneNumber = phoneNumber;
        } else{
            System.out.println("El número debe ser de 10 digitos");
        }
    }

    @Override
    public String toString() {
        return "User: " + firstName + " " + lastName + ", Email: " + email +
                "\n Phone Number: " + phoneNumber + ", Address: "+ address;
    }

    public abstract void showDataUser();

}
