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

            //use the following query to create table
            //create table protb1 (fname varchar(255), name varchar(255), birth varchar(20), phone varchar(10), income varchar(20), mail varchar(255), assests varchar(20), occ varchar(20), acc varchar(30), pin varchar(30));

            //Second table
            //create table protb2 (fullname varchar(255), acc varchar(30), pin varchar(30), balance bigint);
            String url = "jdbc:mysql://localhost:3306/ProDB";
            String usr = "root";
            String pass = "root1234";
            con = DriverManager.getConnection(url,usr , pass);

        }catch(Exception e){
            e.printStackTrace();
        }
        

    }
}
