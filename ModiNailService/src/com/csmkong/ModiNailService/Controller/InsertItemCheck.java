package com.csmkong.ModiNailService.Controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.csmkong.ModiNailService.DAO.ItemDAO;
import com.csmkong.ModiNailService.DTO.ItemDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.ModiFileRenamePolicy;

/**
 * Servlet implementation class InsertItemCheck
 */
@WebServlet("/InsertItemCheck")
public class InsertItemCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertItemCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doAction(request, response);
	}
	
	private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println(request.getParameter("item_name").toString());
		@SuppressWarnings("deprecation")
		String path = request.getRealPath("Resources");
		int size = 1024*1024*10; // 10MB
		String file = "";
		String oriFile = "";
		try{
			MultipartRequest multi = new MultipartRequest(request,path,size,"EUC-KR",new ModiFileRenamePolicy());
			Enumeration files = multi.getFileNames();
			String str = (String)files.nextElement();
			
			file = multi.getFilesystemName(str);
			oriFile = multi.getOriginalFileName(str);
			System.out.println("file : "+file+", oriFile : "+oriFile);
			
			String brand = multi.getParameter("brand").toString();
			String item_type = multi.getParameter("item_type").toString();
			String item_code = multi.getParameter("item_code").toString();
			String item_name = multi.getParameter("item_name").toString();
			
			ItemDTO dto = new ItemDTO(brand,item_type,Integer.parseInt(item_code),item_name,file);
			ItemDAO dao = new ItemDAO();
			if(dao.insertItem(dto) == ItemDAO.QUERY_FAILED) {
				response.sendRedirect("");
			}else{
				response.sendRedirect("ItemList");
			};
			
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
}
