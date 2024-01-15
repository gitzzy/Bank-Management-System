package Project;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DataBase {
    Connection con ;
   Statement st;
    public DataBase(){

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3308/ProDB";
            String usr ="root";
            String pass = "";

            con = DriverManager.getConnection(url, usr, pass);
            System.out.println("Connection Established");
            
            st = con.createStatement();

        }catch(Exception e){
            e.printStackTrace();
        }
        

    }
}
