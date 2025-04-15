import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Connector {
    Connection connection;
    Statement st;
    public Connector(){
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/HotelSystem", "root","Arnabdutta2005!" );
            st = connection.createStatement();
        }catch(Exception exc){
            exc.printStackTrace();
        }
    } 
}
