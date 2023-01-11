package system.Book.vo;


// mysql Book 테이블의 항목 담은 VO
public class BookVO {

	private String bisbn; // 책의 청구기호 
	private String btitle; // 책 제목
	private String bauthor; // 책 저자
	private int bprice; // 책 가격
	private String bdate; // 책 출판일
	
	public BookVO() {
		// TODO Auto-generated constructor stub
	}
	
	public BookVO(String bisbn) {
		this.bisbn = bisbn;
	}
	
	
	public BookVO(String bisbn, String btitle, String bauthor, int bprice, String bdate) {
		super();
		this.bisbn = bisbn;
		this.btitle = btitle;
		this.bauthor = bauthor;
		this.bprice = bprice;
		this.bdate = bdate;
	}

	public String getBisbn() {
		return bisbn;
	}

	public void setBisbn(String bisbn) {
		this.bisbn = bisbn;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public String getBauthor() {
		return bauthor;
	}

	public void setBauthor(String bauthor) {
		this.bauthor = bauthor;
	}

	public int getBprice() {
		return bprice;
	}

	public void setBprice(int bprice) {
		this.bprice = bprice;
	}

	public String getBdate() {
		return bdate;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
	}

}
