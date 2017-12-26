package com.csmkong.ModiNailService.Command;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.csmkong.ModiNailService.DAO.ItemDAO;
import com.csmkong.ModiNailService.DTO.ItemDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.ModiFileRenamePolicy;

public class ItemInsertCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
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
			dao.insertItem(dto);
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
