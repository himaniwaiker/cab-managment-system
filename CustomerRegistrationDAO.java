package dao;

import dto.CustomerRegistrationDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.DBUtil;

public class CustomerRegistrationDAO {

	private static final String INSERT_CUSTOMER_INFO = "insert into customer(first_name, last_name,gender,house_number,street_number,pincode,mobile_number,email,password) value(?,?,?,?,?,?,?,?,?)";  
	private static final String UPDATE_REGISTRATION_INFO = "update registration set first_name=?, last_name=?,gender=?,house_number=?,street_number=?,pincode=?,mobile_number=?,email=?,password=?";
    private static final String SELECT_REGISTRATION_INFO_BY_ID = "select * from customer where id= ?";
    private static final String SELECT_CUSTOMER_INFO_BY_ALL = "select * from customer";
    private static final String DELETE_REGISTRATION_INFO_BY_ID = "delete from customer where id = ?";

    public static int insertRegistrationInfo(CustomerRegistrationDTO registrationDTO) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        conn = DBUtil.getConnection();
        pstmt = conn.prepareStatement(INSERT_CUSTOMER_INFO);
        pstmt.setString(1, registrationDTO.getFirstname());
        pstmt.setString(2, registrationDTO.getLastname());
        pstmt.setString(3, registrationDTO.getGender());
        pstmt.setString(4, registrationDTO.getHousenumber());
        pstmt.setString(5, registrationDTO.getStreetnumber());
        pstmt.setString(6, registrationDTO.getPincode());
        pstmt.setString(7, registrationDTO.getMobilenumber());
        pstmt.setString(8, registrationDTO.getEmail());
        pstmt.setString(9, registrationDTO.getPassword());
        int count = pstmt.executeUpdate();
        DBUtil.close(conn, pstmt, rs);

        return count;
    }


    public static CustomerRegistrationDTO selectRegistrationById(int id) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        conn = DBUtil.getConnection();
        pstmt = conn.prepareStatement(SELECT_REGISTRATION_INFO_BY_ID);

        pstmt.setInt(1, id);
        rs = pstmt.executeQuery();
        CustomerRegistrationDTO registrationDTO = null;
        if (rs.next()) {
        	registrationDTO = new CustomerRegistrationDTO();
        	registrationDTO.setId(rs.getInt("id"));
            registrationDTO.setFirstname(rs.getString("first_name"));
            registrationDTO.setLastname(rs.getString("last_name"));
            registrationDTO.setGender(rs.getString("gender"));
            registrationDTO.setHousenumber(rs.getString("house_number"));
            registrationDTO.setStreetnumber(rs.getString("street_number"));
            registrationDTO.setPincode(rs.getString("pincode"));
            registrationDTO.setMobilenumber(rs.getString("mobile_number"));
            registrationDTO.setEmail(rs.getString("email"));
            registrationDTO.setPassword(rs.getString("password"));


        }
        return registrationDTO;
    }

    public static List<CustomerRegistrationDTO> selectRegistrationByALL() throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        conn = DBUtil.getConnection();
        pstmt = conn.prepareStatement(SELECT_CUSTOMER_INFO_BY_ALL);
        rs = pstmt.executeQuery();
        List<CustomerRegistrationDTO> list = new ArrayList<>();

        while (rs.next()) {
        	CustomerRegistrationDTO registrationDTO = new CustomerRegistrationDTO();
            registrationDTO = new CustomerRegistrationDTO();
            registrationDTO.setId(rs.getInt("id"));
            registrationDTO.setFirstname(rs.getString("first_name"));
            registrationDTO.setLastname(rs.getString("last_name"));
            registrationDTO.setGender(rs.getString("gender"));
            registrationDTO.setHousenumber(rs.getString("house_number"));
            registrationDTO.setStreetnumber(rs.getString("street_number"));
            registrationDTO.setPincode(rs.getString("pincode"));
            registrationDTO.setMobilenumber(rs.getString("mobile_number"));
            registrationDTO.setEmail(rs.getString("email"));
            registrationDTO.setPassword(rs.getString("password"));

            list.add(registrationDTO);

        }
        return list;
    }

  

    public static int deleteRegistrationInfo(int id) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        conn = DBUtil.getConnection();
        pstmt = conn.prepareStatement(DELETE_REGISTRATION_INFO_BY_ID);
        pstmt.setInt(1, id);
        int count = pstmt.executeUpdate();
        DBUtil.close(conn, pstmt, rs);

        return count;
    }

    public static int updateRegistrationInfo(CustomerRegistrationDTO registrationDTO) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        conn = DBUtil.getConnection();
        pstmt = conn.prepareStatement(UPDATE_REGISTRATION_INFO);
        pstmt.setString(1, registrationDTO.getFirstname());
        pstmt.setString(2, registrationDTO.getLastname());
        pstmt.setString(3, registrationDTO.getGender());
        pstmt.setString(4, registrationDTO.getHousenumber());
        pstmt.setString(5, registrationDTO.getStreetnumber());
        pstmt.setString(6, registrationDTO.getPincode());
        pstmt.setString(7, registrationDTO.getMobilenumber());
        pstmt.setString(8, registrationDTO.getEmail());
        pstmt.setString(9, registrationDTO.getPassword());
        int count = pstmt.executeUpdate();
        DBUtil.close(conn, pstmt, rs);

        return count;}

}
