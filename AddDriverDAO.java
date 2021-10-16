
package dao;

import dto.AddDriverDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;

public class AddDriverDAO {
  

	private static final String INSERT_ADD_DRIVER_INFO = "insert into add_driver(drivername,gender,mobilenumber,vehiclename,costperkm) value(?,?,?,?,?)";
	private static final String SELECT_COMPLAINT_REGISTER_INFO_BY_ID = "select * from add_driver where id= ?";
	private static final String SELECT_COMPLAINT_REGISTER_INFO_BY_ALL = "select * from add_driver";
	private static final String SELECT_COMPLAINT_REGISTER_INFO_BY_STATUS = "select * from add_driver where status = ?";
	private static final String DELETE_COMPLAINT_REGISTER_INFO_BY_ID = "delete from add_driver where id = ?";
	private static final String UPDATE_COMPLAINT_CLOSED = "update add_driver set status=1 where id = ?";
	private static final String SELECT_COMPLAINT_REGISTER_INFO_BY_LAST = "select * from add_driver order by id desc limit 1";

	
	public static int insertcomplaintRegister(AddDriverDTO complaintDTO) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		conn = DBUtil.getConnection();
		pstmt = conn.prepareStatement(INSERT_ADD_DRIVER_INFO);
		pstmt.setString(1, complaintDTO.getDrivername());
		pstmt.setString(2, complaintDTO.getGender());
		pstmt.setString(3, complaintDTO.getMobilenumber());
		pstmt.setString(4, complaintDTO.getvehiclename());
		pstmt.setString(5, complaintDTO.getCostperkm());
		
		
		int count = pstmt.executeUpdate();
		DBUtil.close(conn, pstmt, rs);

		return count;
	}

	public static AddDriverDTO selectComplaintRegisterById(int id) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		conn = DBUtil.getConnection();
		pstmt = conn.prepareStatement(SELECT_COMPLAINT_REGISTER_INFO_BY_ID);
		pstmt.setInt(1, id);

		rs = pstmt.executeQuery();
		AddDriverDTO userloginDTO = null;
		if (rs.next()) {
			userloginDTO = new AddDriverDTO();
			userloginDTO.setId(rs.getInt("id"));
			userloginDTO.setDrivername(rs.getString("drivername"));
			userloginDTO.setGender(rs.getString("gender"));
			userloginDTO.setMobilenumber(rs.getString("mobilenumber"));
			userloginDTO.setVehiclename(rs.getString("vehiclename"));
			userloginDTO.setCostperkm(rs.getString("costperkm"));
		}
		DBUtil.close(conn, pstmt, rs);
		return userloginDTO;
	}
	
	public static AddDriverDTO selectLastComplaintRegisterId() throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		conn = DBUtil.getConnection();
		pstmt = conn.prepareStatement(SELECT_COMPLAINT_REGISTER_INFO_BY_LAST);
		

		rs = pstmt.executeQuery();
		AddDriverDTO userloginDTO = null;
		if (rs.next()) {
			userloginDTO = new AddDriverDTO();
			userloginDTO.setId(rs.getInt("id"));
		}
		DBUtil.close(conn, pstmt, rs);
		return userloginDTO;
	}
	  public static List<AddDriverDTO> selectComplaintByALL() throws Exception {
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;

	        conn = DBUtil.getConnection();
	        pstmt = conn.prepareStatement(SELECT_COMPLAINT_REGISTER_INFO_BY_ALL);
	        rs = pstmt.executeQuery();
	        List<AddDriverDTO> list = new ArrayList<>();

	        while (rs.next()) {
	            AddDriverDTO complaintDTO = new AddDriverDTO();
	            complaintDTO = new AddDriverDTO();
	            complaintDTO.setId(rs.getInt("id"));
	            complaintDTO.setDrivername(rs.getString("drivername"));
	            complaintDTO.setGender(rs.getString("gender"));
	            complaintDTO.setMobilenumber(rs.getString("mobilenumber"));
	            complaintDTO.setVehiclename(rs.getString("vehiclename"));
	            complaintDTO.setCostperkm(rs.getString("costperkm"));

	            list.add(complaintDTO);

	        }
	        return list;
	    }

	  
	  public static List<AddDriverDTO> selectComplaintByStatus(int status) throws Exception {
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;

	        conn = DBUtil.getConnection();
	        pstmt = conn.prepareStatement(SELECT_COMPLAINT_REGISTER_INFO_BY_STATUS);
	        pstmt.setInt(1, status);
	        rs = pstmt.executeQuery();
	        List<AddDriverDTO> list = new ArrayList<>();

	        while (rs.next()) {
	            AddDriverDTO complaintDTO = new AddDriverDTO();
	            complaintDTO.setId(rs.getInt("id"));
	            complaintDTO.setDrivername(rs.getString("drivername"));
	            complaintDTO.setGender(rs.getString("gender"));
	            complaintDTO.setMobilenumber(rs.getString("mobilenumber"));
	            complaintDTO.setVehiclename(rs.getString("vehiclename"));
	            complaintDTO.setCostperkm(rs.getString("costperkm"));


	            list.add(complaintDTO);

	        }
	        return list;
	    }

	  public static int updatecomplaintInfo(int id) throws Exception {
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;

	        conn = DBUtil.getConnection();
	        pstmt = conn.prepareStatement(UPDATE_COMPLAINT_CLOSED);
	        pstmt.setInt(1, id);
	        int count = pstmt.executeUpdate();
	        DBUtil.close(conn, pstmt, rs);

	        return count;
	    }
	 
}