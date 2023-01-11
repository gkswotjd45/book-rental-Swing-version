package system.Book.Controller;

import java.util.ArrayList;

import system.Book.service.BookService;
import system.Book.vo.BookVO;

public class BookSelectKeywordController {
	public ArrayList<BookVO> getResult(String btitle) {
		BookService service = new BookService();
		ArrayList<BookVO> list= service.selectBooksByKeyword(btitle);
		return list;
	}
}
