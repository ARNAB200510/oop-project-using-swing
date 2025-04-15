
public class Admin extends Person{
    Admin() throws NameException {

    }

    Admin(String emailId) {
        super(emailId);
    }
    Admin(String name, String emailId) {
        super(name, emailId);
    }
    //Getters
    String getName() {
        return super.getName();
    }

    String getEmailId() {
        return super.getEmailId();
    }
}