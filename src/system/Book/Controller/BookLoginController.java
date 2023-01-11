package system.Book.Controller;

import java.security.Provider.Service;

import system.Book.service.MemberSerivce;
import system.Book.vo.MemberVO;

public class BookLoginController {

	public MemberVO getResult(String inputID, String inputPW) {
		
		MemberSerivce service = new MemberSerivce();
		MemberVO member = service.getLogin(inputID,inputPW);
		
		return member;
	}


	
}
