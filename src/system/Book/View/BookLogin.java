package system.Book.View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.ButtonBar.ButtonData;
import system.Book.Controller.BookLoginController;
import system.Book.vo.MemberVO;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.lang.reflect.Member;
import java.awt.event.ActionEvent;

public class BookLogin extends JFrame {

	private JPanel contentPane;
	private JTextField inputPassWord;
	private JTextField textField_2;
	private JTextField textld;
	private static MemberVO User;
	
	
	public static MemberVO getUser() {
		return User;
	}

	public void setUser(MemberVO user) {
		User = user;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookLogin frame = new BookLogin();
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
	public BookLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 608, 444);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		
		Dimension frameSize = getSize();
		 
        Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((windowSize.width - frameSize.width) / 2,
                (windowSize.height - frameSize.height) / 2); //화면 중앙에 띄우기
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(75, 96, 423, 231);
		contentPane.add(panel);
		panel.setLayout(null);
		
		inputPassWord = new JTextField();
		inputPassWord.setColumns(10);
		inputPassWord.setBounds(226, 141, 134, 44);
		panel.add(inputPassWord);
		
		JTextPane txtID = new JTextPane();
		txtID.setForeground(Color.BLACK);
		txtID.setFont(new Font("나눔고딕", Font.BOLD, 36));
		txtID.setText("ID :");
		txtID.setBounds(98, 81, 96, 44);
		panel.add(txtID);
		
		JTextPane txtpnPw = new JTextPane();
		txtpnPw.setText("PW :");
		txtpnPw.setForeground(Color.BLACK);
		txtpnPw.setFont(new Font("나눔고딕", Font.BOLD, 36));
		txtpnPw.setBounds(98, 141, 96, 44);
		panel.add(txtpnPw);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("나눔고딕", Font.PLAIN, 36));
		textField_2.setText("도서정보시스템");
		textField_2.setBounds(88, 22, 258, 49);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnlogin = new JButton("로그인");
		btnlogin.addActionListener(e ->{
			BookLoginController controller = new BookLoginController();
			MemberVO member = controller.getResult(textld.getText().toString(),inputPassWord.getText().toString());
			User = member;
			
			if(member != null) {
				if(member.getmID().equals("admin") 
						&& member.getmPassword().equals("admin1234")) {
					
					System.out.println("관리자 로그인");
				
					JOptionPane.showConfirmDialog(null, member.getmID().toString()+"이 로그인하였습니다.","로그인",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null);
					
					 new BookMain_Swing();
		                setVisible(false);
				}else {
				System.out.println("회원 로그인");
				
				JOptionPane.showMessageDialog(null, member.getmID().toString()+"이 로그인하였습니다.");
				
				new BookMain_Swing();
	            setVisible(false);
				}
			}else {
				JOptionPane.showMessageDialog(null, "입력한 ID와 비밀번호를 확인해주세요.");
			}

		});
		btnlogin.setBounds(308, 198, 91, 23);
		panel.add(btnlogin);
		
		JButton btnregister = new JButton("회원가입");
		btnregister.addActionListener(e->{ //회원 가입 창
			 new BookRegister();
             setVisible(false);
		});
		btnregister.setBounds(186, 198, 91, 23);
		panel.add(btnregister);
		
		textld = new JTextField();
		textld.setBounds(212, 81, 199, 41);
		panel.add(textld);
		textld.setColumns(10);
	}
}
