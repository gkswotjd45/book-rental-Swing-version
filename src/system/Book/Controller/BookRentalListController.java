package system.Book.Controller;

import java.util.ArrayList;

import system.Book.service.BookService;
import system.Book.vo.BookRentalVO;

public class BookRentalListController {
public ArrayList<BookRentalVO> getRentalResult(String rtitle) {
		
		BookService service = new BookService();
		ArrayList<BookRentalVO> rlist= service.getRentalResult(rtitle);
		return rlist;
		
	}
}
