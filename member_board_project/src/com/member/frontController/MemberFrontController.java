package com.member.frontController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.member.command.MemberCommand;
import com.member.command.MemberDeleteCommand;
import com.member.command.MemberJoinCommand;
import com.member.command.MemberListCommand;
import com.member.command.MemberLoginCommand;
import com.member.command.MemberLogoutCommand;
import com.member.command.MemberViewCommand;


/**
 * Servlet implementation class MemberFrontController
 */
public class MemberFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String viewPage = null;
		MemberCommand memberCommand = null;
		
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		
		
		if(command.equals("/MemberLogin.me")){
			viewPage="/member/loginForm.jsp";
		}else if(command.equals("/MemberJoin.me")){
			viewPage="/member/joinForm.jsp";
		}else if(command.equals("/MemberLoginCommand.me")){
			memberCommand = new MemberLoginCommand();
			memberCommand.execute(request, response);
			viewPage="/BoardList.bo";
		}else if(command.equals("/MemberJoinCommand.me")){
			memberCommand = new MemberJoinCommand();
			memberCommand.execute(request, response);
			viewPage="/MemberLogin.me";
		}else if(command.equals("/MemberListCommand.me")){
			memberCommand = new MemberListCommand();
			memberCommand.execute(request, response);
			viewPage="/member/member_list.jsp";
		}else if(command.equals("/MemberViewCommand.me")){
			memberCommand = new MemberViewCommand();
			memberCommand.execute(request, response);
			viewPage="/member/member_info.jsp";
		}else if(command.equals("/MemberDeleteCommand.me")){
			memberCommand = new MemberDeleteCommand();
			memberCommand.execute(request, response);
			viewPage="/MemberListCommand.me";
		}else if(command.equals("/MemberLogoutCommand.me")){
			memberCommand = new MemberLogoutCommand();
			memberCommand.execute(request, response);
			viewPage="/BoardList.bo";
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);

	}
}

