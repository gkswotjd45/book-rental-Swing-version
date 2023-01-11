package system.Book.Controller;

import system.Book.service.BookService;

public class BookReturnSelectrowController {
	
	public int getReturnSet(String risbn) { //반납시 컨트롤러 수행.
		BookService service = new BookService();
		int result = service.getReturnResult(risbn);
		return result;
	}
	
}
