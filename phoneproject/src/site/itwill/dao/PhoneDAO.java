package site.itwill.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import site.itwill.dto.PhoneDTO;



public class PhoneDAO extends JdbcDAO {
		private static PhoneDAO _dao;
		
	public PhoneDAO() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_dao = new PhoneDAO();
		
	}
	
	public static PhoneDAO getDAO() {
		
		
		return _dao;
		
	}
	
	public int insertPhone(PhoneDTO phone) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int rows = 0;
		try {
		con = getConnection();
		
		String sql = "insert into phone values(?,?,?,?,?)";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, phone.getMdnm());
		pstmt.setString(2, phone.getPhname());
		pstmt.setString(3, phone.getColor());
		pstmt.setInt(4, phone.getMemory());
		pstmt.setInt(5, phone.getStock());
		
		rows = pstmt.executeUpdate();
		
		}catch (SQLException e) {
			System.out.println("[에러]insertStudent() 메소드의 SQL 오류 : " + e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}
	
	public int updatePhone(PhoneDTO phone) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int rows = 0;
		try {
			
			con = getConnection();
			
			String sql = "update phone set phname =?,memory =?,color =?,stock =? where mdnm =?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, phone.getPhname());
			pstmt.setInt(2, phone.getMemory());
			pstmt.setString(3, phone.getColor());
			pstmt.setInt(4, phone.getStock());
			pstmt.setString(5, phone.getMdnm());
			
			rows = pstmt.executeUpdate();
			
			
			
			rows = pstmt.executeUpdate();
		
		}catch (SQLException e) {
			// TODO: handle exception
		}finally {
			close(con, pstmt);
			
		}
		
		return rows;
	}
	
	
	public int deletePhone(String mdnm) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int rows = 0;
		try {
			con = getConnection();
			
			String sql = "delete from phone where mdnm =?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mdnm);
			
			rows = pstmt.executeUpdate();

		}catch (SQLException e) {
			
			
		}finally {
			close(con, pstmt);
		}
		return rows;
		
	}
	
	public PhoneDTO selectMdnmPhone(String mdnm) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PhoneDTO phone = null;
		
		try {
			con = getConnection();
			String sql = "select * from phone where mdnm =?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mdnm);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				phone = new PhoneDTO();
				phone.setMdnm(rs.getString("mdnm"));
				phone.setPhname(rs.getString("phname"));
				phone.setColor(rs.getString("color"));
				phone.setMemory(rs.getInt("memory"));
				phone.setStock(rs.getInt("stock"));
				
			}
			
		}catch (SQLException e) {

		}finally {
			close(con, pstmt, rs);
		}
		
		return phone;
	
	}
	
	public List<PhoneDTO> selectPhnamePhoneList(String phname) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<PhoneDTO> phoneList =  new ArrayList<PhoneDTO>();
		
		try {
		
			con = getConnection();
			String sql = "select * from phone where phname like ? order by substr(mdnm,3,2),length(phname),substr(phname,6,1),memory";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, phname);
		
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				PhoneDTO phone = new PhoneDTO();
				phone.setMdnm(rs.getString("mdnm"));
				phone.setPhname(rs.getString("phname"));
				phone.setColor(rs.getString("color"));
				phone.setMemory(rs.getInt("memory"));
				phone.setStock(rs.getInt("stock"));
				phoneList.add(phone);
				
			}
		
		
		} catch (SQLException e) {
			
			
		}finally {
			close(con, pstmt, rs);
		}
		return phoneList;
		
}
	public List<PhoneDTO> selectAllPhoneList() {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	List<PhoneDTO> phoneList = new ArrayList<PhoneDTO>(); 	
	try {
		con = getConnection();
		
		String sql = "select * from phone order by substr(mdnm,3,2),length(phname),substr(phname,6,1),memory";
		pstmt= con.prepareStatement(sql);
		
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			PhoneDTO phone = new PhoneDTO();
			
			phone.setMdnm(rs.getString("mdnm"));
			phone.setPhname(rs.getString("phname"));
			phone.setColor(rs.getString("color"));
			phone.setMemory(rs.getInt("memory"));
			phone.setStock(rs.getInt("stock"));
			phoneList.add(phone);

		}
		
		
	}catch (SQLException e) {

	} finally {
		close(con, pstmt, rs);
	}
	
	return phoneList;
	}
	public List<PhoneDTO> selectPhnameList() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<PhoneDTO> phoneList = new ArrayList<PhoneDTO>(); 	
		try {
			con = getConnection();
			
			String sql = "select phname from phone group by phname order by avg(stock)";
			pstmt= con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				PhoneDTO phone = new PhoneDTO();
				phone.setPhname(rs.getString("phname"));
				
				phoneList.add(phone);

			}
		}catch (SQLException e) {

		} finally {
			close(con, pstmt, rs);
		}
		return phoneList;
		}
}
