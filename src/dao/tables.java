package dao;

import java.sql.*;
import javax.swing.JOptionPane;

public class tables {
    
    public static void main(String[] args){
        Connection con = null;
        Statement st = null;
        
        try{
            con = ConnectionProvider.getCon();
            st = con.createStatement();
            if(!tableExists(st, "userattendance")){
                st.executeUpdate("CREATE TABLE userattendance (userid VARCHAR(100), date DATE NOT NULL, checkin DATETIME, checkout DATETIME);");
            }
            JOptionPane.showMessageDialog(null, "Tables Checked/Created Successfully.");
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        } finally{
            try{
                if(con != null) con.close();
                if(st != null) st.close();
            } catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }
    
    private static boolean tableExists(Statement st, String tableName) throws Exception{
        ResultSet resultSet = st.executeQuery("SHOW TABLES LIKE '"+ tableName + "'");
        return resultSet.next();
    }
}
