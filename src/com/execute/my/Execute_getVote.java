package com.execute.my;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.VoteInfoDAO;
import VO.VoteInfoVO;


public class Execute_getVote implements Execute_Impl{////////
	
	@Override     
	public void Execute(HttpServletRequest request,
			             HttpServletResponse response) throws Exception {///
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		VoteInfoDAO tidao1 = new VoteInfoDAO();
		ArrayList<VoteInfoVO> vtlist1 = null;
		vtlist1 = tidao1.getVote();
		request.setAttribute("vtlist1", vtlist1);
	}
	
}