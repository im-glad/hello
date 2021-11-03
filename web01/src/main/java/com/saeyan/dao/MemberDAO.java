package com.saeyan.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.saeyan.dto.MemberVO;



public class MemberDAO {
	
	//db매니저 없이 db커넥션
	 public static Connection getConnection() throws Exception{ 
	 Class.forName("oracle.jdbc.driver.OracleDriver"); 
	 Connection con = DriverManager.getConnection
			 ("jdbc:oracle:thin:@//localhost:1522/xe","SYSTEM","oracle"); 
	 return con; }
	 

	private MemberDAO() {
	}

	private static MemberDAO instance = new MemberDAO();

	public static MemberDAO getInstance() {
		return instance;
	}
	
	//slelect all 회원목록 조회 
	public List<MemberVO> selectAllMembers() {
		String sql = "SELECT CUSTNO,CUSTNAME,PHONE,ADDRESS,TO_CHAR(JOINDATE,'YYYY-MM-DD') AS JOINDATE,GRADE,CITY FROM MEMBER_TBL_02 ORDER BY CUSTNO";
		List<MemberVO> list = new ArrayList<MemberVO>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MemberVO mVo = new MemberVO();
				mVo.setCustno(rs.getInt("custno"));
				mVo.setCustname(rs.getString("custname"));
				mVo.setPhone(rs.getString("phone"));
				mVo.setAddress(rs.getString("address"));
				mVo.setJoindate(rs.getString("joindate"));
				mVo.setGrade(rs.getString("grade"));
				mVo.setCity(rs.getString("city"));
				list.add(mVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt !=null) pstmt.close();
				if(conn !=null) conn.close(); 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	//회원번호는 자동생성, 새로운 회원정보 추가하기
	public void insertMember(MemberVO mVo) {
		String sql = "insert into member_tbl_02 values(mem_seq.nextval,?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mVo.getCustname());
			pstmt.setString(2, mVo.getPhone());
			pstmt.setString(3, mVo.getAddress());
			pstmt.setString(4, mVo.getJoindate());
			pstmt.setString(5, mVo.getGrade());
			pstmt.setString(6, mVo.getCity());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt !=null) pstmt.close();
				if(conn !=null) conn.close(); 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	//회원번호에 등록된 회원정보 불러오기
	public MemberVO selectCustno(String custno) {
		String sql = "select CUSTNO,CUSTNAME,PHONE,ADDRESS,TO_CHAR(JOINDATE,'YYYY-MM-DD') AS JOINDATE,GRADE,CITY from member_tbl_02 where custno=?";
		MemberVO mVo = null;
		try {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, custno);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					mVo = new MemberVO();
					mVo.setCustno(rs.getInt("custno"));
					mVo.setCustname(rs.getString("custname"));
					mVo.setPhone(rs.getString("phone"));
					mVo.setAddress(rs.getString("address"));
					mVo.setJoindate(rs.getString("joindate"));
					mVo.setGrade(rs.getString("grade"));
					mVo.setCity(rs.getString("city"));
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if(rs!=null) rs.close();
					if(pstmt !=null) pstmt.close();
					if(conn !=null) conn.close(); 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mVo;
	}
	//수정된 회원정보 업데이트 하기
	public void modifyMember(MemberVO mVo) {
		String sql = "update member_tbl_02 set custname=?, phone=?, address=?, joindate=?,grade=?,city=? where custno=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mVo.getCustname());
			pstmt.setString(2, mVo.getPhone());
			pstmt.setString(3, mVo.getAddress());
			pstmt.setString(4, mVo.getJoindate());
			pstmt.setString(5, mVo.getGrade());
			pstmt.setString(6, mVo.getCity());
			pstmt.setInt(7, mVo.getCustno());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt !=null) pstmt.close();
				if(conn !=null) conn.close(); 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	//판매정보 불러오기
	public List<MemberVO> selectSellList() {
		String sql = "select a.custno, a.custname, a.grade, b.price from(select custno,custname,decode(grade,'A','VIP','B','일반','C','직원')as grade from member_tbl_02)a,\r\n"
				+ "(select custno, sum(price) as price from money_tbl_02 group by custno)b where a.custno=b.custno order by b.price desc";
		List<MemberVO> list = new ArrayList<MemberVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MemberVO mVo = new MemberVO();
				mVo.setCustno(rs.getInt("custno"));
				mVo.setCustname(rs.getString("custname"));
				mVo.setGrade(rs.getString("grade"));
				mVo.setPrice(rs.getInt("price"));
				list.add(mVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt !=null) pstmt.close();
				if(conn !=null) conn.close(); 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	//시퀀스번호 화면자동생성하기
	public int getSeq() {
		String sql="SELECT custno FROM (SELECT * FROM member_tbl_02 ORDER BY ROWNUM DESC) WHERE ROWNUM = 1";
		Connection conn=null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int custno =0;
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				custno=rs.getInt("custno")+1;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt !=null) pstmt.close();
				if(conn !=null) conn.close(); 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return custno;
	}
}
