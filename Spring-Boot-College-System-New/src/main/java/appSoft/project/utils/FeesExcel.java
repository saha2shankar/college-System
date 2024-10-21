package appSoft.project.utils;


import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import appSoft.project.model.Fees;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FeesExcel extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(
			Map<String, Object> model, 
			Workbook workbook, 
			HttpServletRequest request,
			HttpServletResponse response) 
					throws Exception {

		//1. define your own excel file name
		response.addHeader("Content-Disposition", "attachment;filename=Fees List.xlsx");
		
		//2. read data given by Controller
		@SuppressWarnings("unchecked")
		List<Fees> list = (List<Fees>) model.get("feesList");
		
		//3. create one sheet
		Sheet sheet = workbook.createSheet("FEES LIST");
		
		//4. create row#0 as header
		setHead(sheet);
		
		//5. create row#1 onwards from List<T> 
		setBody(sheet,list);
	}

	private void setHead(Sheet sheet) {
		Row row = sheet.createRow(0);
		row.createCell(0).setCellValue("ID");

		row.createCell(1).setCellValue("ROLL NO");
		row.createCell(2).setCellValue("NAME");
		row.createCell(3).setCellValue("FEES TYPE");
		row.createCell(4).setCellValue("AMOUNT");
		row.createCell(5).setCellValue("AMOUNT PAID");
		row.createCell(6).setCellValue("INVOICE DATE");
		row.createCell(7).setCellValue("DUE DATE");
	}
	
	private void setBody(Sheet sheet, List<Fees> list) {
		int rowNum = 1;
		for(Fees spec : list) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(spec.getId());

			row.createCell(1).setCellValue(spec.getRollNo());
			row.createCell(2).setCellValue(spec.getStudentName());
			row.createCell(3).setCellValue(spec.getFeesType());
			row.createCell(4).setCellValue(spec.getAmount());
			row.createCell(5).setCellValue(spec.getAmountPaid());
			row.createCell(6).setCellValue(spec.getInvoiceDate().toString());
			row.createCell(7).setCellValue(spec.getDueDate().toString());

		}
	}

}
