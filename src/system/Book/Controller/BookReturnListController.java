package system.Book.Controller;

import javafx.collections.ObservableList;
import system.Book.service.BookService;
import system.Book.vo.BookRentalVO;

public class BookReturnListController {
	public ObservableList<BookRentalVO> getALlResult() {
		BookService service = new BookService();
		ObservableList<BookRentalVO> list = service.getAllResult();
		return list;
	}
}
