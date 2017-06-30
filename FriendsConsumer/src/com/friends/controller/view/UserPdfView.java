package com.friends.controller.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.friends.model.User;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class UserPdfView extends AbstractPdfView{
	@SuppressWarnings("unchecked")
	@Override
	protected void buildPdfDocument(Map<String, Object> map, Document document,
			PdfWriter arg2, 
			HttpServletRequest arg3, 
			HttpServletResponse arg4)throws Exception {
		
		//1.read data from map
		List<User> userList=(List<User>)map.get("userListObj");
		
		//2.construct data as table
		PdfPTable table=new PdfPTable(5);
		
		//3.add header
		table.addCell("Id");
		table.addCell("Name");
		table.addCell("EmailId");
		table.addCell("MobileNo");
		table.addCell("Birthday");
		//4.add data
		for(User user:userList){
			table.addCell(Integer.toString(user.getUserId()));
			table.addCell(user.getUserName());
			table.addCell(user.getUserEmail());
			table.addCell(user.getUserMobile());
			table.addCell(user.getBirthDay());
			
		}
		
		//5.add elements to Document
		Paragraph p=new Paragraph("User List");
		document.add(p);
		document.add(table);
		
	}  
	
}
