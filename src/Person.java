
public class Person {
    private String emailId; //email id of the person 
    private String name; // Name of the person
    Person() throws NameException{
        throw new NameException("Cannot instantiate user without credentials");
    }

    Person(String emailId) {
        this.emailId = emailId;
    }

    Person(String name, String emailId) {
        this.name = name;
        this.emailId = emailId;
    }

    //Setters 
    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNo(String phoneNumber) {
        // this.phoneNumber = phoneNumber;
    }

    //Getters 
    String getName() {
        return name;
    }

    String getEmailId() {
        return emailId;
    }

}

//Exception for not entering proper credentials
class NameException extends Exception {
    NameException(String message) {
        super(message);
    }
}