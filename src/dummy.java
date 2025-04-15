import java.io.File;
import java.io.FileWriter;

public class dummy {
    public static void main(String[] args) {
        try {
            System.out.println(new File("input.txt").getAbsolutePath());
            FileWriter fwriter = new FileWriter("input.txt");
            fwriter.write("Ab");
            fwriter.write("CD");
            fwriter.close();
            
        }catch(Exception exc){
            exc.printStackTrace();
        }
    }
}