package com.saeyan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.MemberDAO;
import com.saeyan.dto.MemberVO;

/**
 * Servlet implementation class MemberModifyServlet
 */
@WebServlet("/membermodify.do")
public class MemberModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String custno = request.getParameter("custno");
		
		MemberDAO mDao = MemberDAO.getInstance();
		MemberVO mVo = mDao.selectCustno(custno);
		
		request.setAttribute("member", mVo);
		RequestDispatcher dispatcher = request.getRequestDispatcher("member/modify.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		ServletContext context = getServletContext();
		
		String custno = request.getParameter("custno");
		String custname = request.getParameter("custname");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String joindate = request.getParameter("joindate");
		String grade = request.getParameter("grade");
		String city = request.getParameter("city");
		
		MemberVO mVo = new MemberVO();
		mVo.setCustno(Integer.parseInt(custno));
		mVo.setCustname(custname);
		mVo.setPhone(phone);
		mVo.setAddress(address);
		mVo.setJoindate(joindate);
		mVo.setGrade(grade);
		mVo.setCity(city);
		
		MemberDAO mDao = MemberDAO.getInstance();
		mDao.modifyMember(mVo);
		
		response.sendRedirect("memberlist.do");
	}

}
