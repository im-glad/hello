package com.saeyan.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

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
 * Servlet implementation class MemberRegisterServlet
 */
@WebServlet("/memberregister.do")
public class MemberRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		MemberDAO mDao = MemberDAO.getInstance();
		request.setAttribute("custno", mDao.getSeq());
		
		RequestDispatcher dispatcher =request.getRequestDispatcher("member/register.jsp");
		dispatcher.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String custname = request.getParameter("custname");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String joindate = request.getParameter("joindate");
		String grade = request.getParameter("grade");
		String city = request.getParameter("city");
		
		
		
		MemberVO mVo = new MemberVO();
		mVo.setCustname(custname);
		mVo.setPhone(phone);
		mVo.setAddress(address);
		mVo.setJoindate(joindate);
		mVo.setGrade(grade);
		mVo.setCity(city);
		
		MemberDAO mDao = MemberDAO.getInstance();
		mDao.insertMember(mVo);
		
		response.sendRedirect("memberlist.do");

	}

}
