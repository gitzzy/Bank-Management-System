package Project;

import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

import java.sql.ResultSet;

public class PrintStatement {

    public static void main(String[] args) {
        PrintStatement obj = new PrintStatement();
        obj.Print();
    }
    public void Print(){
        DataBase con = new DataBase();
        DefaultTableModel model = new DefaultTableModel(new String[]{
            "Action","Amount","source","date"
                        },0);
        
        try{

            String q1 = "select * from history";
            Statement pt0 = con.con.prepareStatement(q1);
            ResultSet rs = pt0.executeQuery(q1);
            
            while (rs.next()) {
                System.out.println(rs.getString("user1")+" , "
                +rs.getString("user2")+" , "+rs.getLong("amount")
                
                );

                String Action = rs.getString("action");
                long Amount = rs.getLong("amount");
                String source = rs.getString("user2");
                String date = rs.getString("date_added");
                model.addRow(new Object[]{
                    Action,
                    Amount,source,
                    date
                });
            }
            
            

        }catch(Exception ex){
            ex.printStackTrace();
        }

    }
}
