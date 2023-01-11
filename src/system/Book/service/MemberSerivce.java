package system.Book.service;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.ibatis.session.SqlSessionFactory;

import system.Book.DAO.BookRentalDAO;
import system.Book.DAO.DBCPConnectionPool;
import system.Book.DAO.MemberDAO;
import system.Book.mybatis.MyBatiesConnectionFactory;
import system.Book.vo.MemberVO;

public class MemberSerivce {

	
	public MemberVO getLogin(String inputID, String inputPW) {
		SqlSessionFactory factory = MyBatiesConnectionFactory.getSqlSessionFactory();
		
		MemberDAO dao = new MemberDAO(factory);

		MemberVO member= dao.Login(inputID, inputPW);
		
		return member;
	}
	
	/*
	public MemberVO getSet(String inputID, String inputPW,String inputEmail, String inputPhone) {
		SqlSessionFactory factory = MyBatiesConnectionFactory.getSqlSessionFactory();
		
		MemberDAO dao = new MemberDAO(factory);

		int count = dao.Register(inputID,inputPW,inputEmail,inputPhone);
		
		return null;
	}
	 */
	public int getSet(MemberVO member) {
		SqlSessionFactory factory = MyBatiesConnectionFactory.getSqlSessionFactory();
		
		MemberDAO dao = new MemberDAO(factory);

		int count = dao.Register(member);
		
		return count;
	}
	
	
	/*
	public MemberVO getLogin(String inputID, String inputPW) {
		Connection con = null;
		
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		MemberDAO dao = new MemberDAO(con);
		MemberVO member = dao.Login(inputID,inputPW);
		
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return member;
	}
	
	*/

	/*
	public MemberVO getLogin(String inputID, String inputPW) {
		Connection con = null;
		
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		MemberDAO dao = new MemberDAO(con);
		MemberVO member = dao.Login(inputID,inputPW);
		
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return member;
	}

	*/
	
	
	/*
	public MemberVO getSet(String inputID, String inputPW, String inputEmail, String inputPhone) {
		
		Connection con = null;
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection();
			con.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MemberDAO dao = new MemberDAO(con);
		int count = dao.Register(inputID,inputPW,inputEmail,inputPhone);
		//ObservableList<BookRentalVO> list = dao.find(rTitle);
		
		
		if(count == 1) {  // 정상적으로 대여되면 1값을 반환함.
			try {
				con.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				con.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return null;
	}
	*/
	
}
