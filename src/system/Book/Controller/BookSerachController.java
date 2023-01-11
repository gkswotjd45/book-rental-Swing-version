package system.Book.Controller;

import java.util.ArrayList;

import javafx.collections.ObservableList;
import system.Book.service.BookService;
import system.Book.vo.BookRentalVO;
import system.Book.vo.BookVO;

public class BookSerachController {

	public BookVO getOneResult(String string) {
		
		BookService service = new BookService();
		BookVO  list = service.selectBookOneKeyword(string);
		return list;
		
	}
}
