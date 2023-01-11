package system.Book.DAO;

import java.awt.print.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import system.Book.vo.BookRentalVO;
import system.Book.vo.BookVO;


public class BookDAO {
	
	private SqlSessionFactory factory;
	
	Connection con; 
	

	public BookDAO() {
		// TODO Auto-generated constructor stub
	}

	public BookDAO(Connection con) {
		super();
		this.con = con;
	}

	
	
	public BookDAO(SqlSessionFactory factory) {
		super();
		this.factory = factory;
	}

	// 검색 버튼 클릭시, 책제목을 통해서 검색
	public ArrayList<BookVO> select(String btitle) {
		List<BookVO> list = null;
		SqlSession session = factory.openSession();
		
		try {
			 list = session.selectList("example.mybook.selectBookTitle",btitle);
			 
		}finally {
			
		}
		
		ArrayList<BookVO> Alist = new ArrayList<BookVO>(list);
		return Alist;
	}
	
	
	/*
	@SuppressWarnings("null")
	public ObservableList<BookVO> select(String text) {
		
		ObservableList<BookVO> list = null;
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT bisbn, btitle, bauthor, bprice, bdate ");
		sql.append("FROM book ");
		sql.append("WHERE btitle like ? ");
		sql.append("ORDER BY bisbn DESC");
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, "%" + text + "%");
			ResultSet rs = pstmt.executeQuery();
			list = FXCollections.observableArrayList();

			while(rs.next()) {
				BookVO book = new BookVO(rs.getString("bisbn"),
						rs.getString("btitle"),
						rs.getString("bauthor"),
						rs.getInt("bprice"),
						rs.getString("bdate"));
					list.add(book);
			}	

				rs.close();
				pstmt.close();
				
		}catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

*/
	// 책의 청구번호를 통해 전체 도서 목록 출력.
	public BookVO oneSelect(String bisbn) {

		BookVO book = null;
		
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT bisbn ");
		sql.append("FROM book ");
		sql.append("WHERE bisbn = ?");
	
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, bisbn);
			ResultSet rs = pstmt.executeQuery();

			if(rs.next()) {
				book = new BookVO(rs.getString("bisbn"));
				
			}	

				rs.close();
				pstmt.close();
				
		}catch (Exception e) {
			// TODO: handle exception
		}
		return book;
	}


}
