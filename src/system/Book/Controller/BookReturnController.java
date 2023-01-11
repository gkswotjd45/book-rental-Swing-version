package system.Book.Controller;

import javafx.collections.ObservableList;
import system.Book.service.BookService;
import system.Book.vo.BookRentalVO;

public class BookReturnController {


	public BookRentalVO getOneset(String rtitle) {
		BookService service = new BookService();
		BookRentalVO Rbook = service.getOneSet(rtitle);
		return Rbook;
	}

/*
	public BookRentalVO setOneset(String risbn) {
		BookService service = new BookService();
		BookRentalVO Rbook = service.getOneSet(risbn);
		return Rbook;
	}
	*/
}
