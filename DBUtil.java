
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DBUtil {
    
    private static final String URL = "jdbc:mysql://localhost:3306/Cab_Management_System?useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    
    public static Connection getConnection() throws Exception 
    {
        Class.forName(DRIVER);
        Connection conn=DriverManager.getConnection(URL,USERNAME,PASSWORD);
        System.out.println("Connection Successfully");
        return conn;
        }
       
    public static void close(Connection conn,PreparedStatement pstmt,ResultSet rs) throws SQLException
    {
        if(conn!=null)
        {
            conn.close();
        }
        if(pstmt!=null)
        {
            pstmt.close();
        }
        if(rs!=null)
        {
            rs.close();
        }
    }
    
        public static void main(String args[])
        {
            try
            {
                getConnection();
            }
            catch(Exception ex)
            {
                Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE,null,ex);
            }
                        
        }}
    
    
   

