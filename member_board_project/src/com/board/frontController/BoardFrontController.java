package com.board.frontController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.command.BoardCommand;
import com.board.command.BoardDeleteCommand;
import com.board.command.BoardDetailCommand;
import com.board.command.BoardInsertCommand;
import com.board.command.BoardListCommand;
import com.board.command.BoardModifyCommand;
import com.board.command.BoardModifyView;
import com.board.command.BoardReplyCommand;
import com.board.command.BoardReplyView;


/**
 * Servlet implementation class BoardFrontController
 */
public class BoardFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardFrontController() {
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
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String viewPage = null;
		BoardCommand boardCommand =null;
		
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command= requestURI.substring(contextPath.length());
		
		if(command.equals("/BoardWrite.bo")){
			viewPage="/board/board_write.jsp";
		}else if(command.equals("/BoardInsertCommand.bo")){
			boardCommand = new BoardInsertCommand();
			boardCommand.execute(request, response);
			viewPage="/BoardList.bo";
		}else if(command.equals("/BoardList.bo")){ 
			boardCommand = new BoardListCommand();
			boardCommand.execute(request, response);
			viewPage="/board/board_list.jsp";
		}else if(command.equals("/BoardDetailCommand.bo")){
			boardCommand = new BoardDetailCommand();
			boardCommand.execute(request, response);
			viewPage="/board/board_view.jsp";
		}else if(command.equals("/BoardDelete.bo")){
			viewPage="/board/board_delete.jsp";
		}else if(command.equals("/BoardDeleteCommand.bo")){
			boardCommand = new BoardDeleteCommand();
			boardCommand.execute(request, response);
			viewPage="/BoardList.bo";
		}else if(command.equals("/BoardModify.bo")){
			boardCommand = new BoardModifyView();
			boardCommand.execute(request, response);
			viewPage="/board/board_modify.jsp";
		}else if(command.equals("/BoardModifyCommand.bo")){
			boardCommand = new BoardModifyCommand();
			boardCommand.execute(request, response);
			viewPage="/BoardList.bo";
		}else if(command.equals("/BoardReply.bo")){
			boardCommand = new BoardReplyView();
			boardCommand.execute(request, response);
			viewPage="/board/board_reply.jsp";
		}else if(command.equals("/BoardReplyCommand.bo")){
			boardCommand = new BoardReplyCommand();
			boardCommand.execute(request, response);
			viewPage="/BoardList.bo";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}
