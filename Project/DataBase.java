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
            String url = "jdbc:mysql://localhost:3306/ProDB";
            String usr = "root";
            String pass = "root";
            con = DriverManager.getConnection(url,usr , pass);

        }catch(Exception e){
            e.printStackTrace();
        }
        

    }
}
