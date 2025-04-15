
public class User extends Person{
    User() throws NameException{

    }

    User(String emailId) {
        super(emailId);
    }
    User(String name, String emailId) {
        super(name, emailId);
    }
    String getName() {
        return super.getName();
    }

    String getEmailId() {
        return super.getEmailId();
    }
}



