package Project;
import java.sql.Connection;
import java.sql.DriverManager;

public class DataBase {
    Connection con ;
    public DataBase(){

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Windows Port is 3306
            //Mac port is 3308
            String url = "jdbc:mysql://localhost:3306/prodb";
            String usr = "root";
            String pass = "";
            con = DriverManager.getConnection(url,usr , pass);
            System.out.println("Connection Established");

        }catch(Exception e){
            e.printStackTrace();
        }
        

    }
}
