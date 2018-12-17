package com.itext.demo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.GrayColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;
import com.test.dto.Employee;

public class GeneratePDFUitl {
   
	
	public static void generatePdf(String dest,List<Employee> empList) throws IOException, DocumentException {
	        
		    Document document = new Document(PageSize.A4.rotate());
	        PdfWriter.getInstance(document, new FileOutputStream(dest));
	        document.open();
	       
	        float[] columnWidths = {1, 5, 5};
	        
	        PdfPTable table = new PdfPTable(columnWidths);
	        table.setWidthPercentage(100);
	        table.getDefaultCell().setUseAscender(true);
	        table.getDefaultCell().setUseDescender(true);
	       
	        Font f = new Font(FontFamily.HELVETICA, 13, Font.NORMAL, GrayColor.GRAYWHITE);
	       
	        PdfPCell cell = new PdfPCell(new Phrase("Employee Details", f));
	        cell.setBackgroundColor(GrayColor.GREEN);
	        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell.setColspan(3);
	       
	        table.addCell(cell);
	        table.getDefaultCell().setBackgroundColor(new GrayColor(0.75f));
	        
	        table.addCell("empId");// addCell is equal to new PdfPCell object creation
	        table.addCell("empName");
	        table.addCell("mobileNo");
	        
	        table.setHeaderRows(3);
	        table.getDefaultCell().setBackgroundColor(GrayColor.GRAYWHITE);
	        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
	       
			for (Employee employee : empList) {
				
				PdfPCell empIdCell = new PdfPCell(new Phrase(employee.getEmployeeId().toString()));
				empIdCell.setBackgroundColor(BaseColor.DARK_GRAY);
				empIdCell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(empIdCell);
				
				table.addCell(String.valueOf(employee.getEmpName()));
				
				PdfPCell empNoCell = new PdfPCell(new Phrase(employee.getMobileNo().toString()));
				empNoCell.setHorizontalAlignment(Element.ALIGN_CENTER);
				empNoCell.setBackgroundColor(BaseColor.DARK_GRAY);
				
				table.addCell(empNoCell);
			}
	        document.add(table);
	        document.close();
	        System.out.println("Pdf Generated successfull..");
	}
	public static void extractDataFromPdf(String path) throws IOException {
		 PdfReader pdfReader = new PdfReader(path);
         String textFromPage = PdfTextExtractor.getTextFromPage(pdfReader, 1);
         System.out.println(textFromPage);
	}
	 public static void parseAndWriteIntoFile(String pdf, String txt) throws IOException {
	        PdfReader reader = new PdfReader(pdf);
	        PdfReaderContentParser parser = new PdfReaderContentParser(reader);
	        PrintWriter out = new PrintWriter(new FileOutputStream(txt));
	        TextExtractionStrategy strategy;
	        for (int i = 1; i <= reader.getNumberOfPages(); i++) {
	            strategy = parser.processContent(i, new SimpleTextExtractionStrategy());
	            out.println(strategy.getResultantText());
	        }
	        reader.close();
	        out.flush();
	        out.close();
	    }
}
