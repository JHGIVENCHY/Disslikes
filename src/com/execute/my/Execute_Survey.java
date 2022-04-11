package com.execute.my;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.InprogressDAO;
import VO.InprogressVO;

public class Execute_Survey implements Execute_Impl {

	@Override
	public void Execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		InprogressVO sVo = null;
		InprogressDAO sDao = new InprogressDAO();
		String vt_img_name = request.getParameter("img");
		sVo = sDao.getinfoVotes(vt_img_name);
		request.setAttribute("sVo", sVo);
	}

}
