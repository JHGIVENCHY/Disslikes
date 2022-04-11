package com.execute.my;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.VoteInfoDAO;
import VO.LastVoteInfoVO;

	public class Execute_getLastVote implements Execute_Impl{
	
		public void Execute(HttpServletRequest request,
	            HttpServletResponse response) throws Exception {
			
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		VoteInfoDAO tidao1 = null;
		tidao1 = new VoteInfoDAO();
		ArrayList<LastVoteInfoVO> vtlist2 = null;
		vtlist2 = tidao1.getlastVote();
		request.setAttribute("vtlist2", vtlist2);
		}
	}

