package system.Book.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import system.Book.vo.BookVO;
import system.Book.vo.MemberVO;

public class MemberDAO {

	
	private SqlSessionFactory factory;
	Connection con;
	
	public MemberDAO() {
		
	}
	
	public MemberDAO(SqlSessionFactory factory) {
		super();
		this.factory = factory;
	}
	
	public MemberDAO(Connection con) {
		super();
		this.con = con;
	}
	
	
	public MemberVO Login(String ID, String pasword) {
		MemberVO member = null;
		MemberVO para = new MemberVO(ID, pasword);
		SqlSession session = factory.openSession();
		
		try {
			 member = session.selectOne("example.myRent.selectMemberlogin", para);
		}finally {
			
		}
		
		return member;
	}
	

	public int Register(MemberVO member) {
		int count = 0;
		
		MemberVO para = new MemberVO(member.getmID(),
				member.getmPassword(),
				member.getmEMail(),
				member.getmPhone());
		SqlSession session = factory.openSession();

		try {
			count = session.insert("example.myRent.InsertMemberlagister", para);
		
		
		}finally {
			session.commit(); // update, delete 문은 커밋을 반드시 수행.
			session.close();
		}
		//세션이 갖고 있는 update 시킴.
		
		return count;
	}
	
}
