
package dao;
import dto.CustomerLoginDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import util.DBUtil;

public class CustomerLoginDAO {

    private static final String SELECT_CUSTOMER_LOGIN_INFO_BY_ID = "select * from customerlogin where id= ?";
    private static final String SELECT_CUSTOMER_LOGIN_INFO_BY_ALL = "select * from customer where email=? and password=?";
    private static final String DELETE_CUSTOMER_LOGIN_INFO_BY_ID = "delete from customerlogin where id = ?";

    public static CustomerLoginDTO selectUserloginByALL(String email,String password) throws Exception
    {
    Connection conn=null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    conn = DBUtil.getConnection();
    pstmt = conn.prepareStatement(SELECT_CUSTOMER_LOGIN_INFO_BY_ALL);
   
    pstmt.setString(1, email);
    pstmt.setString(2, password);
    rs=pstmt.executeQuery();
    CustomerLoginDTO customerloginDTO=null;
    if(rs.next())
    {
    customerloginDTO=new CustomerLoginDTO();
    customerloginDTO.setId(rs.getInt("id"));
    }
    DBUtil.close(conn, pstmt, rs);
    return customerloginDTO;
    }
}