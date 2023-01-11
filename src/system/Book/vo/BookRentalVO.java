package system.Book.vo;

// 도서 대여 확인하는 테이블 (

public class BookRentalVO {
	private String risbn;  // 대여한 책 청구 기호, 기본키, Book Vo에 bisbn 외래키
	private String rtitle; // 대여한 책의 도서명 
	private String rchack; // 대여 확인 여부
	private String rdate;  // 대여한 일자 
	
	public BookRentalVO() {
		// TODO Auto-generated constructor stub
	}


	public BookRentalVO(String risbn, String rName, String rchack, String rdate) {
		super();
		this.risbn = risbn;
		this.rtitle = rName;
		this.rchack = rchack;
		this.rdate = rdate;
	}


	public String getRisbn() {
		return risbn;
	}


	public void setRisbn(String risbn) {
		this.risbn = risbn;
	}


	public String getrName() {
		return rtitle;
	}


	public void setrName(String rName) {
		this.rtitle = rName;
	}


	public String getRchack() {
		return rchack;
	}


	public void setRchack(String rchack) {
		this.rchack = rchack;
	}


	public String getRdate() {
		return rdate;
	}


	public void setRdate(String rdate) {
		this.rdate = rdate;
	}


	
	
}
