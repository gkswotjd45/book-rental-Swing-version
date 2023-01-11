package system.Book.View;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import system.Book.Controller.BookLoginController;
import system.Book.Controller.BookLoginLegisterController;
import system.Book.vo.MemberVO;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;

import java.awt.Font;
import java.awt.Toolkit;

import javax.naming.CompoundName;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BookRegister extends JFrame {

	private JPanel contentPane;
	private JTextField inputID;
	private JTextField inputPassword;
	private JTextField inputEmail;
	private JTextField inputPhone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookRegister frame = new BookRegister();
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
	public BookRegister() {
		
		 Dimension frameSize = getSize();
	        Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
	        setLocation((windowSize.width - frameSize.width) / 2,
	                (windowSize.height - frameSize.height) / 2); //화면 중앙에 띄우기
	        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	        setVisible(true);
	        
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 727, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(105, 89, 519, 296);
		contentPane.add(panel);
		panel.setLayout(null);
		
		inputID = new JTextField();
		inputID.setBounds(286, 83, 109, 33);
		panel.add(inputID);
		inputID.setColumns(10);
		
		inputPassword = new JTextField();
		inputPassword.setColumns(10);
		inputPassword.setBounds(286, 131, 109, 33);
		panel.add(inputPassword);
		
		inputEmail = new JTextField();
		inputEmail.setColumns(10);
		inputEmail.setBounds(286, 174, 109, 33);
		panel.add(inputEmail);
		
		inputPhone = new JTextField();
		inputPhone.setColumns(10);
		inputPhone.setBounds(286, 217, 109, 33);
		panel.add(inputPhone);
		
		JTextPane txtpnId = new JTextPane();
		txtpnId.setText("ID 입력 :");
		txtpnId.setBounds(98, 83, 136, 21);
		panel.add(txtpnId);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setText("패스워드 입력");
		textPane_1.setBounds(98, 130, 136, 21);
		panel.add(textPane_1);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setText("이메일 입력:");
		textPane_2.setBounds(98, 174, 136, 21);
		panel.add(textPane_2);
		
		JTextPane textPane_3 = new JTextPane();
		textPane_3.setText("휴대폰 번호 입력:");
		textPane_3.setBounds(98, 227, 136, 21);
		panel.add(textPane_3);
		
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		textPane.setText("회원정보 등록");
		textPane.setBounds(98, 31, 314, 33);
		panel.add(textPane);
		
		JButton btnNewButton = new JButton("회원 등록");
		btnNewButton.addActionListener(e ->{
			BookLoginLegisterController  controller = new BookLoginLegisterController ();
			MemberVO member = new MemberVO(
					inputID.getText().toString(),
					inputPassword.getText().toString(),
					inputEmail.getText().toString(),
					inputPhone.getText().toString());
			
			int result = controller.getSet(member);
			System.out.println(result);
			
			System.out.println("완료");
			 new BookLogin();
             setVisible(false);
		});
		
		btnNewButton.setBounds(416, 263, 91, 23);
		panel.add(btnNewButton);
	}
}
