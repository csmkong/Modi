package com.csmkong.ModiNailService.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.csmkong.ModiNailService.Command.Command;
import com.csmkong.ModiNailService.Command.ItemInsertCommand;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doAction(request,response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
//		String uri = request.getRequestURI();
//		String contextPath = request.getContextPath();
//		String command = uri.substring(contextPath.length());
//		
//		if(command.equals("/itemInsert.do")) {
//			response.getWriter().append("Served at: item").append(request.getContextPath());
//		}
		doAction(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
//		String uri = request.getRequestURI();
//		String contextPath = request.getContextPath();
//		String command = uri.substring(contextPath.length());
//		
//		if(command.equals("/itemInsert.do")) {
//			//response.getWriter().append("Served at: item").append(request.getContextPath());
//			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/InsertItemCheck");
//			requestDispatcher.forward(request, response);
//		}
		doAction(request,response);
	}
	
	public void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//InventoryDAO dao = new InventoryDAO();
		//dao.getItem();
		String viewPage = null;
		Command command = null;
		
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String com = uri.substring(contextPath.length());
		System.out.println(com);
		if(com.equals("/itemInsert.do")) {
			System.out.println("itemInsert.do");
			viewPage="Item/ItemInsert.jsp";
		}else if(com.equals("/itemList.do")) {
			System.out.println("itemList.do");
			viewPage="Item/Itemlist.jsp";
		}else if(com.equals("/insertItemCheck.do")) {
			System.out.println("insertItemCheck.do");
			command = new ItemInsertCommand();
			command.execute(request, response);
			viewPage = "itemList.do";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
		
	}

}
