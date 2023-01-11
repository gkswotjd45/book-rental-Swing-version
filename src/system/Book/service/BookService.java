package system.Book.service;

import java.awt.print.Book;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


import system.Book.DAO.BookDAO;
import system.Book.DAO.BookRentalDAO;
import system.Book.DAO.DBCPConnectionPool;
import system.Book.mybatis.MyBatiesConnectionFactory;
import system.Book.vo.BookRentalVO;
import system.Book.vo.BookVO;


public class BookService {
	
	
	public ArrayList<BookVO> selectBooksByKeyword(String btitle) {

		
		
		SqlSessionFactory factory = MyBatiesConnectionFactory.getSqlSessionFactory();


		BookDAO dao = new BookDAO(factory);
		
		ArrayList<BookVO> arraylist = dao.select(btitle);

		return arraylist;
		
	}
	


	public ArrayList<BookRentalVO> getRentalResult(String rtitle) {
		
		
		SqlSessionFactory factory = MyBatiesConnectionFactory.getSqlSessionFactory();


		BookRentalDAO dao = new BookRentalDAO(factory);
		
		ArrayList<BookRentalVO> arraylist = dao.find(rtitle);

		return arraylist;

	}
	
	public BookVO selectBookOneKeyword(String string) {
		
		Connection con = null;
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BookDAO dao = new BookDAO(con);
		
		BookVO Book = dao.oneSelect(string);
		
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return Book;
	}
	
	public int getupdateResult(String risbn) {
		
		SqlSessionFactory factory = MyBatiesConnectionFactory.getSqlSessionFactory();
		BookRentalDAO dao = new BookRentalDAO(factory);

		int count = dao.Update(risbn);
		return count;
	}
	

/*
	public int getupdateResult(String risbn) {
		
		Connection con = null;
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection();
			con.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BookRentalDAO dao = new BookRentalDAO(con);
		int count = dao.Update(risbn);
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
	public ObservableList<BookRentalVO> getAllResult() {
		Connection con = null;
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BookRentalDAO dao = new BookRentalDAO(con);
		ObservableList<BookRentalVO> list = dao.All();
		
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return list;
	}


	public ObservableList<BookRentalVO> getRetalSet() {
		Connection con = null;
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection();
			con.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BookRentalDAO dao = new BookRentalDAO(con);
		
		int count = dao.getRetanlUpdate();
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


	public BookRentalVO getOneSet(String rtitle) {
		Connection con = null;
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BookRentalDAO dao = new BookRentalDAO(con);
		
		BookRentalVO rBook = dao.oneSelect(rtitle);
		
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return rBook;
	}


	public int getReturnResult(String risbn) {
		
		
		Connection con = null;
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection();
			con.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BookRentalDAO dao = new BookRentalDAO(con);
		int count = dao.getReturnUpdate(risbn);
		//ObservableList<BookRentalVO> list = dao.find(rTitle);
		
		
		if(count == 1) {  // 정상적으로 반납되면 1값을 반환함.
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
			return count;
	}


	
	
	
	
	
	
	
	/*
	public ObservableList<BookRentalVO> getupdateResult(String risbn) {
		Connection con = null;
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection();
			con.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BookRentalDAO dao = new BookRentalDAO(con);
		int count = dao.Update(risbn);
		//ObservableList<BookRentalVO> list = dao.find(rTitle);
		
		
		
		if(count == 1 && list != null) {  // 정상적으로 대여되면 1값을 반환함.
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
			return list;
		
	}
	
	*/
	/*
	public ObservableList<BookVO> selectallFound() {

		Connection con = null;
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BookDAO dao = new BookDAO(con);
		ObservableList<BookVO> list = dao.allsearch();
		
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return list;
	}
	*/
}
