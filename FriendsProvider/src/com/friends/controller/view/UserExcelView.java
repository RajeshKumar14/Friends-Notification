package com.friends.controller.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.friends.model.User;

public class UserExcelView extends AbstractExcelView {
	@SuppressWarnings("unchecked")
	@Override
	protected void buildExcelDocument(Map<String, Object> map,
			HSSFWorkbook book, 
			HttpServletRequest req, 
			HttpServletResponse res)throws Exception {
		
		//create sheet and add to book
		//1.reading data from map
		List<User> userList=(List<User>)map.get("userListObj");
		
		//2.create sheet from book
		HSSFSheet sheet=book.createSheet("User");
		
		//3.set header
		setHeader(sheet);
		//4.set body
		setBody(sheet,userList);
		
	              }
	private void setHeader(HSSFSheet sheet){
		HSSFRow row=sheet.createRow(0);
		row.createCell(0).setCellValue("Id");
		row.createCell(1).setCellValue("Name");
		row.createCell(3).setCellValue("EmailId");
		row.createCell(4).setCellValue("MobileNo");
		row.createCell(4).setCellValue("Birthday");
		        }
	
	private void setBody(HSSFSheet sheet,List<User> userList) {
		int rowNum=1;
		for(User user:userList){
			HSSFRow row=sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(user.getUserId());
			row.createCell(1).setCellValue(user.getUserName());
			row.createCell(2).setCellValue(user.getUserEmail());
			row.createCell(3).setCellValue(user.getUserMobile());
			row.createCell(4).setCellValue(user.getBirthDay());
		        }
	        }
}
