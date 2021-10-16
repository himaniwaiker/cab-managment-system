
package dao;
import dto.AdminLoginDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import util.DBUtil;

public class AdminLoginDAO {

   
    private static final String SELECT_USER_ADMIN_LOGIN_INFO_BY_ALL = "select * from admin_login where username=? and password=?";

    public static AdminLoginDTO selectUseradminloginByALL(String username,String password) throws Exception
    {
    Connection conn=null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    conn = DBUtil.getConnection();
    pstmt = conn.prepareStatement(SELECT_USER_ADMIN_LOGIN_INFO_BY_ALL);
    pstmt.setString(1, username);
    pstmt.setString(2, password);
    rs=pstmt.executeQuery();
    AdminLoginDTO adminloginDTO=null;
    if(rs.next())
    {
    adminloginDTO=new AdminLoginDTO();
    adminloginDTO.setId(rs.getInt("id"));
    }
    DBUtil.close(conn, pstmt, rs);
    return adminloginDTO;
    }
    
    
}