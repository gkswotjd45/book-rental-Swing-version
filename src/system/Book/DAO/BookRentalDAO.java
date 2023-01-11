package system.Book.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import system.Book.vo.BookRentalVO;
import system.Book.vo.BookVO;
import system.Book.vo.MemberVO;

public class BookRentalDAO {
	
	Connection con;
	private SqlSessionFactory factory;
	
	public BookRentalDAO(SqlSessionFactory factory) {
		this.factory = factory;
	}

	public BookRentalDAO(Connection con) {
		super();
		this.con = con;
	}
	
	
	public ArrayList<BookRentalVO> find(String rtitle) { // 도서 테이블에 도서명을 토대로 도서 검색.

		List<BookRentalVO> Rlist = null;
		SqlSession session = factory.openSession();
		
		try {
			 Rlist = session.selectList("example.myRent.selectRentalBookTitle",rtitle);
			 
		}finally {
			
		}
		
		ArrayList<BookRentalVO> Alist = new ArrayList<BookRentalVO>(Rlist);
		return Alist;
	}
	
	
		public int Update(String risbn) { //일부 항목만 업데이트, 대여 테이블에서 책 대여 버튼 클릭시 대여처리.
		
			int result = 0; // 업데이트 받은 영향 받은 개순
			SqlSession session = factory.openSession(); 
			
			try {
				result = session.update("example.myRent.updaterisbn",risbn);
			}
			catch (Exception e) {
				// TODO: handle exception
			}finally {
				session.commit(); // update, delete 문은 커밋을 반드시 수행.
				session.close();
			}
			//세션이 갖고 있는 update 시킴.
			
			return result;	
	
	}

	
	/*
	public BookRentalVO oneSelect(String bisbn) {

		BookRentalVO bookRental = null;
		
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * ");
		sql.append("FROM book ");
		sql.append("WHERE bisbn = ?");
	
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, bisbn);
			ResultSet rs = pstmt.executeQuery();

			if(rs.next()) {
				bookRental = new BookRentalVO(rs.getString("risbn"),
						rs.getString("rtitle"),
						rs.getString("rchack"),
						rs.getNString("rdate"));
				
			}	

				rs.close();
				pstmt.close();
				
		}catch (Exception e) {
			// TODO: handle exception
		}
		return bookRental;
	}
*//*
	public int Update(String text) { //일부 항목만 업데이트, 대여 테이블에서 책 대여 버튼 클릭시 대여처리.
		
		StringBuffer sql = new StringBuffer();
		sql.append("update rental R ");
		sql.append("set R.rchack = '대여중', R.rdate = current_date() ");
		sql.append("where R.risbn = (select B.bisbn from Book B where b.bisbn = ?) and R.rchack != '대여중';");

		int count = 0;
		
		try {
			
			PreparedStatement pstmt = con.prepareStatement(sql.toString());
			// 실행하기 전에.. ? 를 채워야 해요!
			pstmt.setString(1, text);
			
			count = pstmt.executeUpdate();
			
			// 6. 사용한 자원 반납
			pstmt.close();
			
		} catch (Exception e1) {
			// TODO: handle exception
		}
		
		return count;
	}

	*/
	public ObservableList<BookRentalVO> oneRentalSelect(String risbn) {  //대여 청구기호 토대로 전체 대여테이블 출력.
		ObservableList<BookRentalVO> bookRental = null;  //대
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * ");
		sql.append("FROM rental ");
		sql.append("WHERE risbn = ?");
	
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, risbn);
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
				BookRentalVO Rent = new BookRentalVO(
						rs.getString("risbn"),
						rs.getString("rtitle"),
						rs.getString("rchack"),
						rs.getNString("rdate")
					);
				bookRental.add(Rent);
			}	


				rs.close();
				pstmt.close();
				
		}catch (Exception e) {
			// TODO: handle exception
		}
		return bookRental;
	}

	public ObservableList<BookRentalVO> All() { //대여중인 목록 출력.
		ObservableList<BookRentalVO> bookReturn = null;
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * ");
		sql.append("FROM rental ");
		sql.append("where rchack = '대여중' ");
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();
			bookReturn = FXCollections.observableArrayList();
			
			while(rs.next()) {
				BookRentalVO Rent = new BookRentalVO(
						rs.getString("risbn"),
						rs.getString("rtitle"),
						rs.getString("rchack"),
						rs.getNString("rdate")
					);
				 bookReturn.add(Rent);
			}	

				rs.close();
				pstmt.close();
				
		}catch (Exception e) {
			// TODO: handle exception
		}
		return bookReturn;
	}

	public int getRetanlUpdate() {

		StringBuffer sql = new StringBuffer();
		sql.append("update rental R ");
		sql.append("set R.rchack = '대여 가능', R.rdate = null ");
		sql.append("where R.rchack = '대여중'");

		int count = 0;
		
		try {
			
			PreparedStatement pstmt = con.prepareStatement(sql.toString());
			
			count = pstmt.executeUpdate();
			
			pstmt.close();
			
		} catch (Exception e1) {
			// TODO: handle exception
		}
		
		return count;
	}



	public BookRentalVO oneSelect(String rtitle) {

		BookRentalVO Rent = null;
		
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * ");
		sql.append("FROM rental ");
		sql.append("WHERE rtitle = ?");
	
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, rtitle);
			//System.out.println(rtitle);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				Rent = new BookRentalVO(
						rs.getString("risbn"),
						rs.getString("rtitle"),
						rs.getString("rchack"),
						rs.getNString("rdate")
					);
			}	

				rs.close();
				pstmt.close();
				
		}catch (Exception e) {
			// TODO: handle exception
		}
		return Rent;
	}

	public int getReturnUpdate(String risbn) {

		StringBuffer sql = new StringBuffer();
		sql.append("update rental R ");
		sql.append("set R.rchack = '대여 가능', R.rdate = null ");
		sql.append("where R.risbn = (select B.bisbn from Book B where B.bisbn = ?) and R.rchack = '대여중' ");

		int count = 0;

		try {
			
			PreparedStatement pst = con.prepareStatement(sql.toString());

			pst.setString(1, risbn);
			
			count = pst.executeUpdate();
			
			// 6. 사용한 자원 반납
			pst.close();
			
		} catch (Exception e1) {
			// TODO: handle exception
		}
		
		return count;
		
	}

	
	
}
