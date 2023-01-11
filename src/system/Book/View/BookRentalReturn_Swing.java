package system.Book.View;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import javafx.collections.ObservableList;
import system.Book.Controller.BookRentalController;
import system.Book.Controller.BookRentalListController;
import system.Book.Controller.BookReturnController;
import system.Book.Controller.BookReturnListController;
import system.Book.Controller.BookReturnSelectrowController;
import system.Book.Controller.BookSelectKeywordController;
import system.Book.Controller.BookSerachController;
import system.Book.vo.BookRentalVO;
import system.Book.vo.BookVO;

public class BookRentalReturn_Swing extends JFrame {

	private JPanel RentalPane;
	private JTable BookTable;
	private JTable RentalTable;
	private JTable ReturnTable;
	private JTextPane txtpnList;
	private BookVO BSelect;
	private BookRentalVO rSelect;
	
	private static String colNames [] = {"도서 청구기호","도서명","저자","도서가격","출판일"};
	private static String RentNames [] = {"청구기호","도서명","도서 대출 여부", "도서 대출 기간"};
	private String selectBookISBN; //대여할 도서 청구기호 
	private String returnBookISBN;; //반납할 도서 청구기호
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookRentalReturn_Swing frame = new BookRentalReturn_Swing();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	
	
	public BookRentalReturn_Swing() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		RentalPane = new JPanel();
		RentalPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		//화면(뷰) 전환시 필요한 요소.
     	Dimension frameSize = getSize();
        Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((windowSize.width - frameSize.width) / 2,
                (windowSize.height - frameSize.height) / 2); //화면 중앙에 띄우기
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
		
		
		setContentPane(RentalPane);
		RentalPane.setLayout(null);
		
		// 일반 화면을 나타내기 위한 텍스트 필드
		JTextPane txtTitle = new JTextPane();
		txtTitle.setFont(new Font("나눔고딕", Font.BOLD, 20));
		txtTitle.setText("도서 대여 및 반납");
		txtTitle.setBounds(12, 10, 171, 30);
		RentalPane.add(txtTitle);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(12, 60, 274, 139);
		RentalPane.add(layeredPane);
		
		JTextPane txtRental = new JTextPane();
		txtRental.setText("대여 도서");
		txtRental.setFont(new Font("나눔고딕", Font.PLAIN, 16));
		txtRental.setBounds(12, 10, 107, 30);
		layeredPane.add(txtRental);
		
		JTextPane txtName = new JTextPane();
		txtName.setText("도서 제목");
		txtName.setBounds(12, 49, 107, 21);
		layeredPane.add(txtName);
		

		// 도서 제곡 키워드를 입력하는 공간.
		JTextArea txtBookTitle = new JTextArea();
		txtBookTitle.setBounds(131, 49, 98, 21);
		layeredPane.add(txtBookTitle);
		
		// 좌측 하단의 반납여부를 확인할 수 있는 테이블을 구성.
		JLayeredPane layeredReturnBook = new JLayeredPane();
		layeredReturnBook.setBounds(12, 209, 274, 244);
		RentalPane.add(layeredReturnBook);
		
		// 일반 화면을 나타내기 위한 텍스트 필드
		JTextPane txtReturn = new JTextPane();
		txtReturn.setText("반납 도서");
		txtReturn.setFont(new Font("나눔고딕", Font.PLAIN, 16));
		txtReturn.setBounds(11, 10, 107, 30);
		layeredReturnBook.add(txtReturn);
		
		
		// 대여 버튼 클릭 후 수행하는 동작 및 구성요소
		JButton btnRentalList = new JButton("대여한 도서목록 보기");
		btnRentalList.addActionListener( e-> {
			//ReturnTable.getModel();
			//ReturnTable.revalidate();
			
			BookReturnListController controller = new BookReturnListController();
			ObservableList<BookRentalVO> list = controller.getALlResult();
			ArrayList<BookRentalVO> rarry = new ArrayList<BookRentalVO>(list);
			
			Runnable myRunnable4 = new Runnable() {
			
				@Override
				public void run() {
					DefaultTableModel dt = (DefaultTableModel)ReturnTable.getModel();
					dt.setRowCount(0);
					
					for(BookRentalVO vo : rarry) {
						Object recod[] = new Object[4];
						recod[0] = vo.getRisbn();
						recod[1] = vo.getrName();
						recod[2] = vo.getRchack();
						recod[3] = vo.getRdate();
						dt.addRow(recod);
					}
					dt.fireTableDataChanged();
				}
				
			};
			SwingUtilities.invokeLater(myRunnable4);
			
			/*
			ReturnTable.setModel(Rde);
			ReturnTable.revalidate();
			
			*/
			Runnable myRunnable5 = new Runnable() {
				
				BookRentalListController con = new BookRentalListController();
				ArrayList<BookRentalVO> ararry = con.getRentalResult(txtBookTitle.getText());
				@Override
				public void run() {
					DefaultTableModel dtmodel = (DefaultTableModel)RentalTable.getModel();
					dtmodel.setRowCount(0);
					
					for(BookRentalVO vo : ararry) {
						Object recod[] = new Object[4];
						recod[0] = vo.getRisbn();
						recod[1] = vo.getrName();
						recod[2] = vo.getRchack();
						recod[3] = vo.getRdate();
						dtmodel.addRow(recod);			
					}
					
					dtmodel.fireTableDataChanged();
					
				}
			
			};
			SwingUtilities.invokeLater(myRunnable5);
			

			/*
			ObservableList<BookRentalVO> Rlist = con.getRentalResult(txtBookTitle.getText());
			ArrayList<BookRentalVO> rarry = new ArrayList<BookRentalVO>(Rlist);
			*/
			
		
			/*
			RentalTable.setModel(Rded);
			RentalTable.revalidate();
			*/
			
			
		});
		
		btnRentalList.setBounds(11, 62, 157, 23);
		layeredReturnBook.add(btnRentalList);
		
		// 반납 버튼 클릭 후 실행 컨트롤러 및 화면 구성.
		JButton btnReturn = new JButton("반납");
		
		btnReturn.addActionListener(e->{
		
		if(returnBookISBN != null) {
			
			// 좌측 하단 반납여부를 확인하도록 테이블 출력.
			BookReturnSelectrowController controller = new BookReturnSelectrowController();
			
			Runnable myRunnable3 = new Runnable() {

				@Override
				public void run() {
					int result = controller.getReturnSet(returnBookISBN);
					if(result == 1) {
						JOptionPane.showMessageDialog(null, result +"권 반납되었습니다.");
						}else {
							JOptionPane.showMessageDialog(null, "다시 선택해 주세요.");
						}
					
					System.out.println(result +"반납되었습니다.");
				}
				
			};
			SwingUtilities.invokeLater(myRunnable3);
			
			/*
			RentalTable.repaint();
			RentalTable.getModel();
			RentalTable.revalidate();
			
			ReturnTable.getModel();
			ReturnTable.revalidate();
			*/
		}else {
			System.out.println("반납할 도서를 선택하지 않았습니다.");
		}
		
		});
		btnReturn.setBounds(169, 62, 79, 23);
		layeredReturnBook.add(btnReturn);
		
		//반납 테이블의 스크롤러를 추가.
		JScrollPane AllRetrunScroll = new JScrollPane();
		AllRetrunScroll.setBounds(12, 95, 225, 139);
		layeredReturnBook.add(AllRetrunScroll);
		TableModel ReturnModel = new DefaultTableModel(RentNames,0);
		ReturnTable = new JTable(ReturnModel);
		ReturnTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		AllRetrunScroll.setViewportView(ReturnTable);
	
	
		JLayeredPane layeredBooklist = new JLayeredPane();
		layeredBooklist.setBounds(333, 60, 553, 393);
		RentalPane.add(layeredBooklist);
		layeredBooklist.setLayout(null);
		
		
		// 도서 목록 테이블 구성 및 스크롤러 추가.
		JScrollPane BookScroll = new JScrollPane();
		
		BookScroll.setBounds(11, 49, 279, 318);
		layeredBooklist.add(BookScroll);
		TableModel tableModel = new DefaultTableModel(colNames,0);
		BookTable = new JTable(tableModel);
		BookTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		BookScroll.setViewportView(BookTable);
		
		TableModel Returnfirst = new DefaultTableModel(RentNames,0);
		
		// 도서 키워드 검색 버튼 클릭 시 수행.
		JButton btnSearch = new JButton("검색");
		btnSearch.addActionListener(e -> {
//			    BookTable.getModel(); // 미리 앞에서 설정된 테이블 모델을 가져옴.
//			    BookTable.revalidate(); // 레이아웃 재설정.
				// 도서 목록 테이블 출력.
				BookSelectKeywordController controller = new BookSelectKeywordController();
				
				ArrayList<BookVO> foo = controller.getResult((txtBookTitle.getText()));
				
//				DefaultTableModel de = new DefaultTableModel(colNames,0);
//				TableModel Mode = de; // 행,열을 접근하기 위한 모델.
				
				Runnable myRunnable = new Runnable() {
					
					@Override
					public void run() {
//						DefaultTableModel de = new DefaultTableModel(colNames,0);
						DefaultTableModel de = (DefaultTableModel) BookTable.getModel();
						de.setRowCount(0);

						for(BookVO vo: foo) {
							Object record[] = new Object[5];
							record[0] = vo.getBisbn();
							record[1] = vo.getBtitle();
							record[2] = vo.getBauthor();
							record[3] = vo.getBprice();
							record[4] = vo.getBdate();
							de.addRow(record);										
						}
						
//						BookTable.setModel(de);		
						de.fireTableDataChanged();
						
					}
				};
				SwingUtilities.invokeLater(myRunnable);
				
//				for(BookVO vo: foo) {
//					Object record[] = new Object[5];
//					record[0] = vo.getBisbn();
//					record[1] = vo.getBtitle();
//					record[2] = vo.getBauthor();
//					record[3] = vo.getBprice();
//					record[4] = vo.getBdate();
//					de.addRow(record);										
//				}
//				
//			
//				de.fireTableDataChanged();
//				BookTable.setModel(de);
//				BookTable.revalidate();
				
				
//				ReturnTable.getModel();
//				ReturnTable.revalidate();
				
				//해당 도서 테이블에 관한 대여 확인 테이블 목록 출력.
				BookRentalListController con = new BookRentalListController();
				ArrayList<BookRentalVO> rarry = con.getRentalResult(txtBookTitle.getText());
//				TableModel md = Rde;

				Runnable myRunnable1 = new Runnable() {
					
					@Override
					public void run() {
						DefaultTableModel Rde = (DefaultTableModel) RentalTable.getModel();
						Rde.setRowCount(0);
						
						for(BookRentalVO vo : rarry) {
							Object recod[] = new Object[4];
							recod[0] = vo.getRisbn();
							recod[1] = vo.getrName();
							recod[2] = vo.getRchack();
							recod[3] = vo.getRdate();
							Rde.addRow(recod);
							
						}
						
						Rde.fireTableDataChanged();					
					}
				};
				SwingUtilities.invokeLater(myRunnable1);

				
//				DefaultTableModel Rde = (DefaultTableModel) RentalTable.getModel();
//				Rde.setRowCount(0);
//				
//				for(BookRentalVO vo : rarry) {
//					Object recod[] = new Object[3];
//					recod[0] = vo.getrName();
//					recod[1] = vo.getRchack();
//					recod[2] = vo.getRdate();
//					Rde.addRow(recod);
//					
//				}
			
//				md = Rde;
				
//				RentalTable.setModel(Rde);
//				Rde.fireTableDataChanged();
//				RentalTable.revalidate();
				
//				RentalTable.getModel();
//				RentalTable.revalidate();
				
				
		});
		
		btnSearch.setBounds(25, 91, 91, 23);
		layeredPane.add(btnSearch);
		// 도서 테이블에서 행(VO) 클릭시 해당 정보(isbn) 출력.
		
	
		BookTable.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = BookTable.getSelectedRow();
				selectBookISBN= (String)BookTable.getValueAt(row,0); // 도서 테이블에서 선택항 행의 열(isbn)을 클래스 변수로 지정하여 수행.
				System.out.println(selectBookISBN);
			}
		});
		
		
		ReturnTable.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e1) {
				int row = ReturnTable.getSelectedRow();
				
				returnBookISBN = (String)ReturnTable.getValueAt(row,0); // 도서 테이블에서 선택항 행의 열(isbn)을 클래스 변수로 지정하여 수행.
				System.out.println(returnBookISBN);
			}
		});
		
		
		
		/*
		BookTable.getSelectionModel().addListSelectionListener(e -> {  //도서 테이블에서 행클릭 작업 
			
			// Book table 접근하여 테이블 목록 출력.
			
			if(!e.getValueIsAdjusting()) {
				int index = BookTable.getSelectedRow();
				TableModel model = BookTable.getModel();
				
				BookSerachController controller = new BookSerachController();
				
				BookVO book = controller.getOneResult(model.getValueAt(index, 0).toString());
				
				StringBuffer sb = new StringBuffer();
				 	sb.append(book.getBisbn() + "\n");
				
				System.out.println(sb);
				
				System.out.println("행클릭");
				BSelect = book;	
				
			}
		});
		
		*/
		
		txtpnList = new JTextPane();
		txtpnList.setBounds(12, 10, 218, 30);
		layeredBooklist.add(txtpnList);
		txtpnList.setFont(new Font("나눔고딕", Font.PLAIN, 17));
		txtpnList.setText("도서 LIST");
		
		JScrollPane RentalScroll = new JScrollPane();
		RentalScroll.setBounds(306, 49, 223, 318);
		layeredBooklist.add(RentalScroll);
		
		RentalTable = new JTable(Returnfirst);
		RentalTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		RentalScroll.setViewportView(RentalTable);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(306, 10, 149, 21);
		layeredBooklist.add(textPane_1);
		textPane_1.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		textPane_1.setText("대출한 도서");
		
		// 대여 버튼 클릭시 view 구성요소
		JButton btnBookRental = new JButton("대여");
		
		btnBookRental.addActionListener(e -> {
			
			if(selectBookISBN != null) {
				
				BookRentalController con = new BookRentalController();
				int Rlist_Update = con.getUpdateResult(selectBookISBN);
				
				if(Rlist_Update == 1) {
					JOptionPane.showMessageDialog(null, Rlist_Update +"권 대여되었습니다.");
					}else {
						JOptionPane.showMessageDialog(null, "다시 선택해 주세요.");
					}
				
				System.out.println(Rlist_Update +"개가 대여 되었습니다");
				
				BookRentalListController cona = new BookRentalListController();
				
				ArrayList<BookRentalVO> rarry = cona.getRentalResult(txtBookTitle.getText());
			
				DefaultTableModel Rde = new DefaultTableModel(RentNames,0);
				
				for(BookRentalVO vo : rarry) {
					Object recod[] = new Object[4];
					recod[0] = vo.getRisbn();
					recod[1] = vo.getrName();
					recod[2] = vo.getRchack();
					recod[3] = vo.getRdate();
					Rde.addRow(recod);					
				}
				
				RentalTable.setModel(Rde);

			}else {
				
				System.out.println("책을 선택하지 않았습니다.");
			}	
			
			
		});
		/*
		btnBookRental.addActionListener(e -> {
				
			if(BSelect.getBisbn() != null) {
				
				BookRentalController con = new BookRentalController();
				int Rlist_Update = con.getUpdateResult(BSelect.getBisbn().toString());
				System.out.println(Rlist_Update +"개가 반영되었습니다");
				
				BookRentalController cona = new BookRentalController();
				
				ArrayList<BookRentalVO> rarry = cona.getRentalResult(txtBookTitle.getText());
			
				DefaultTableModel Rde = new DefaultTableModel(RentNames,0);
//				TableModel md = Rde;
				
				for(BookRentalVO vo : rarry) {
					Object recod[] = new Object[3];
					recod[0] = vo.getrName();
					recod[1] = vo.getRchack();
					recod[2] = vo.getRdate();
					Rde.addRow(recod);					
				}
				
				RentalTable.setModel(Rde);
//				RentalTable.revalidate();
//				RentalTable.repaint();

				//RentalTable.repaint();
				//RentalTable.revalidate();
				
				//((AbstractTableModel) md).fireTableDataChanged();
				//RentalTable.setModel(md);
				//RentalTable.revalidate();

			}else {
				System.out.println("불가");
			}	
			
			
		});
		*/
		btnBookRental.setBounds(142, 91, 91, 23);
		layeredPane.add(btnBookRental);
		
	
		
		
		
		/*
		//반납을 확인 할 수 있는 테이블에서 행(vo)를 클릭 후 해당 VO정보를 확인 할 수 있도록 하.ㅁ 
		ReturnTable.getSelectionModel().addListSelectionListener(e -> {  //대여한 테이블에서 행클릭 작업 

			// Rental table 접근
			int index = ReturnTable.getSelectedRow();
			
			TableModel Rmodel = ReturnTable.getModel();
			//bookReturnPlayController controller = new bookReturnPlayController();
			BookReturnController controller = new BookReturnController();
			BookRentalVO rbook = controller.getOneset(Rmodel.getValueAt(index, 0).toString());
			
			StringBuffer sb = new StringBuffer();
			 	sb.append(rbook.getRisbn() + "\n");
			
			System.out.println(sb);
			 
			System.out.println("행클릭");
			rSelect = rbook;
		});
		
		*/
		
		
		/*
		// 도서 테이블만 갱신
		JButton btnSearch = new JButton("검색");
		btnSearch.addActionListener(e -> {
			BookSerachController controller = new BookSerachController();
			ObservableList<BookVO> list = controller.getResult(txtBookTitle.getText());
			
			ArrayList<BookVO> foo = new ArrayList<BookVO>(list);
			
			DefaultTableModel de = new DefaultTableModel(colNames,0);
			TableModel Mode = de;
			for(int i = 0; i<foo.size(); i++) {
				BookVO vo = foo.get(i);
				record[0] = vo.getBisbn();
				record[1] = vo.getBtitle();
				record[2] = vo.getBauthor();
				record[3] = vo.getBprice();
				record[4] = vo.getBdate();
				de.addRow(record);
				Mode = de;
			}
			BookTable.setModel(Mode);
			BookTable.revalidate();
		});
		*/
		
	}
}
