package system.Book.View;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javafx.scene.effect.Reflection;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;
import javax.swing.JMenuBar;
import javax.swing.JTextArea;
import javax.swing.JLabel;

public class BookMain_Swing extends JFrame {
	private JFrame BookMain; 
	private JFrame BookRental;
	private JPanel Mainpanel;
	
	//BookLogin login = (BookLogin)

	
	/**1
	 * L1aunch the application.
	 */
	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookMain_Swing frame = new BookMain_Swing();
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
	public BookMain_Swing() {
		
		String a = BookLogin.getUser().getmID();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 729, 446);
		JPanel ReturnPane = new JPanel();
		ReturnPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(ReturnPane);
		ReturnPane.setLayout(null);
		

        Dimension frameSize = getSize();
 
        Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((windowSize.width - frameSize.width) / 2,
                (windowSize.height - frameSize.height) / 2); //화면 중앙에 띄우기
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
		
		Mainpanel = new JPanel();
		Mainpanel.setBounds(12, 32, 703, 363);
		ReturnPane.add(Mainpanel);
		Mainpanel.setLayout(null);
		
		JLayeredPane TextPane = new JLayeredPane();
		TextPane.setBounds(235, 46, 425, 283);
		Mainpanel.add(TextPane);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(151, 94, 124, 26);
		TextPane.add(textPane);
		textPane.setText("도서 대여 정보시스템");
		
		JTextPane textThankyou = new JTextPane();
		textThankyou.setText("이용해 주셔서 감사합니다.");
		textThankyou.setBounds(161, 193, 150, 26);
		textPane.add(textThankyou);
		
		JTextPane textMemberTitie = new JTextPane();
		textMemberTitie.setText("현재 회원정보");
		textMemberTitie.setBounds(38, 201, 89, 23);
		Mainpanel.add(textMemberTitie);
		
		JTextPane txtpnId = new JTextPane();
		txtpnId.setText("회원 ID :");
		txtpnId.setBounds(29, 242, 48, 23);
		Mainpanel.add(txtpnId);
		
		JTextPane txtpnPoint = new JTextPane();
		txtpnPoint.setText("Point :");
		txtpnPoint.setBounds(29, 275, 48, 21);
		Mainpanel.add(txtpnPoint);
		
		JTextArea txtCurID = new JTextArea();
		
		txtCurID.setBounds(89, 242, 47, 23);
		txtCurID.setText(a);
		Mainpanel.add(txtCurID);
		
		JTextArea txtIDPoint = new JTextArea();
		txtIDPoint.setBounds(89, 273, 47, 23);
		Mainpanel.add(txtIDPoint);
		
		JPanel MangePane = new JPanel();
		MangePane.setBounds(15, 4, 344, 29);
		ReturnPane.add(MangePane);
		MangePane.setLayout(null);
		
		
		JButton btnMange = new JButton("도서 관리");
		btnMange.setBounds(0, 0, 169, 23);
		MangePane.add(btnMange);
		
		JButton btnMemberlist = new JButton("전체이용자 목록");
		btnMemberlist.setBounds(174, 0, 169, 23);
		MangePane.add(btnMemberlist);
		
		JPanel userPanel = new JPanel();
		userPanel.setBounds(371, 3, 344, 30);
		ReturnPane.add(userPanel);
		userPanel.setLayout(null);
		
		JButton btnMemberModify = new JButton("회원정보 수정");
		btnMemberModify.setBounds(18, 0, 145, 23);
		userPanel.add(btnMemberModify);
		
		JButton btnBookRentalReturn = new JButton("도서 대여 및 반납");
		btnBookRentalReturn.setBounds(175, 0, 137, 23);
		userPanel.add(btnBookRentalReturn);
		btnBookRentalReturn.addActionListener(e -> {
			 new BookRentalReturn_Swing();
             setVisible(false); // 창 안보이게 하기 
			
		});
		btnMange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}
}
