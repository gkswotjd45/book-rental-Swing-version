package system.Book.Controller;

import java.util.ArrayList;

import javafx.collections.ObservableList;
import system.Book.service.BookService;
import system.Book.vo.BookRentalVO;

public class BookRentalController {

	public int getUpdateResult(String risbn) {
	
	BookService service = new BookService();
	int rlist= service.getupdateResult(risbn);
	return rlist;
		
	}
	/*
	public ObservableList<BookRentalVO> getRetalSet() {
		BookService service = new BookService();
		ObservableList<BookRentalVO> list = service.getRetalSet();
		return list;
	}
	*/
}
