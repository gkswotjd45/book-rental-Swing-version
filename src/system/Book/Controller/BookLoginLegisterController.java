package system.Book.Controller;

import system.Book.service.MemberSerivce;
import system.Book.vo.MemberVO;

public class BookLoginLegisterController {
	public int getSet(MemberVO member) {
		MemberSerivce service = new MemberSerivce();
		int result = service.getSet(member);
		
		return result;
	}

}
