package system.Book.View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import javafx.collections.ObservableList;
import system.Book.Controller.BookSerachController;
import system.Book.vo.BookVO;

import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JLayeredPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class BookManageMent extends JFrame {

	private JPanel contentPane;
	private JTable BookTable;
	Object record[] = new Object[5];
	String contents[][] = {{"978-89-98756-95-6","it 도서","홍길동","3000","2020-10-01"}};
	private static String colNames [] = {"도서 청구기호","도서명","저자","도서가격","출판일"};
	public static DefaultTableModel model;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookManageMent frame = new BookManageMent();
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
	public BookManageMent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtBoolManageMent = new JTextPane();
		txtBoolManageMent.setText("도서 관리");
		txtBoolManageMent.setFont(new Font("나눔고딕", Font.BOLD, 20));
		txtBoolManageMent.setBounds(25, 10, 171, 30);
		contentPane.add(txtBoolManageMent);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(25, 60, 227, 237);
		contentPane.add(layeredPane);
		
		JTextPane txtBookAdd = new JTextPane();
		txtBookAdd.setText("도서 추가");
		txtBookAdd.setFont(new Font("나눔고딕", Font.PLAIN, 16));
		txtBookAdd.setBounds(0, 10, 107, 30);
		layeredPane.add(txtBookAdd);
		
		JTextPane txtBname = new JTextPane();
		txtBname.setText("도서명");
		txtBname.setBounds(0, 79, 107, 21);
		layeredPane.add(txtBname);
		
		JTextArea inputBName = new JTextArea();
		inputBName.setBounds(119, 79, 98, 21);
		layeredPane.add(inputBName);
		
		JButton btnBookAdd = new JButton("추가");
		btnBookAdd.setBounds(126, 204, 91, 23);
		layeredPane.add(btnBookAdd);
		
		
		JTextArea intputBisbn = new JTextArea();
		intputBisbn.setBounds(119, 48, 98, 21);
		layeredPane.add(intputBisbn);
		
		JTextPane txtBisbn = new JTextPane();
		txtBisbn.setText("도서 청구기호");
		txtBisbn.setBounds(0, 48, 107, 21);
		layeredPane.add(txtBisbn);
		
		JTextArea inputBauthor = new JTextArea();
		inputBauthor.setBounds(119, 110, 98, 21);
		layeredPane.add(inputBauthor);
		
		JTextPane txtBauthor = new JTextPane();
		txtBauthor.setText("도서 저자");
		txtBauthor.setBounds(0, 110, 107, 21);
		layeredPane.add(txtBauthor);
		
		JTextArea inputBprice = new JTextArea();
		inputBprice.setBounds(119, 141, 98, 21);
		layeredPane.add(inputBprice);
		
		JTextPane txtBprice = new JTextPane();
		txtBprice.setText("도서 가격");
		txtBprice.setBounds(0, 141, 107, 21);
		layeredPane.add(txtBprice);
		
		JButton btnAllfound = new JButton("전체 도서");
		btnAllfound.addActionListener(e -> {

	
			
		});
		btnAllfound.setBounds(4, 204, 103, 23);
		layeredPane.add(btnAllfound);
		
		
		
		JLayeredPane layeredReturnBook = new JLayeredPane();
		layeredReturnBook.setBounds(25, 307, 227, 146);
		contentPane.add(layeredReturnBook);
		
		JTextArea txtDeleteName = new JTextArea();
		txtDeleteName.setBounds(125, 58, 98, 21);
		layeredReturnBook.add(txtDeleteName);
		
		JTextPane txtReturn = new JTextPane();
		txtReturn.setText("도서 삭제");
		txtReturn.setFont(new Font("나눔고딕", Font.PLAIN, 16));
		txtReturn.setBounds(12, 10, 107, 30);
		layeredReturnBook.add(txtReturn);
		
		JLayeredPane layeredBooklist = new JLayeredPane();
		layeredBooklist.setLayout(null);
		layeredBooklist.setBounds(264, 60, 610, 393);
		contentPane.add(layeredBooklist);
		
		JScrollPane BookScroll = new JScrollPane();
		BookScroll.setBounds(11, 49, 587, 334);
		layeredBooklist.add(BookScroll);
		TableModel tableModel = new DefaultTableModel(contents,colNames);
		BookTable = new JTable(tableModel);
		BookTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		BookScroll.setViewportView(BookTable);
		
		
		JButton btnRentalList = new JButton("도서 찾기");
		btnRentalList.addActionListener(e -> {
	
		});
		
		btnRentalList.setBounds(12, 89, 103, 23);
		layeredReturnBook.add(btnRentalList);
		
		JButton btnReturn = new JButton("삭제");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnReturn.setBounds(135, 89, 79, 23);
		layeredReturnBook.add(btnReturn);
		
		JTextPane txtBname_1 = new JTextPane();
		txtBname_1.setText("도서명");
		txtBname_1.setBounds(12, 58, 107, 21);
		layeredReturnBook.add(txtBname_1);
		
	
		

		JTextPane txtpnList = new JTextPane();
		txtpnList.setText("도서 LIST");
		txtpnList.setFont(new Font("나눔고딕", Font.PLAIN, 17));
		txtpnList.setBounds(12, 10, 218, 30);
		layeredBooklist.add(txtpnList);
	}
}
