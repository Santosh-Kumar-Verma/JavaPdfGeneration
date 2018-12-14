package com.itext.demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.itextpdf.text.DocumentException;
import com.itgrids.dto.Employee;

public class GeneratePdf {
    
     
	 private static final String FILE_NAME = "D://app//static_content//activity_documents//test.pdf";
     public static void main(String[] args) throws IOException, DocumentException {
   	  List<Employee> empList = getEmployeeDList();
   	  
   	  GeneratePDFUitl.generatePdf(FILE_NAME,empList);
   	  
   	  GeneratePDFUitl.extractDataFromPdf(FILE_NAME);
   	    
   	  GeneratePDFUitl.parseAndWriteIntoFile(FILE_NAME, "D://app//static_content//activity_documents//TestFile.txt");
     
     }
     
     public static List<Employee> getEmployeeDList() {
    	 List<Employee> empList = new ArrayList<>();
    	 empList.add(new Employee(101l, 7416308674l, "Santosh Kumar Verma"));
    	 empList.add(new Employee(102l, 7416308624l, "Sumit Kumar Verma"));
    	 empList.add(new Employee(103l, 7416308664l, "Ganesh Kumar Verma"));
    	 empList.add(new Employee(104l, 7416308694l, "Sunil Kumar Verma"));
    	 empList.add(new Employee(105l, 7416308654l, "Ranjeet Kumar"));
    	 empList.add(new Employee(106l, 7416308678l, "Bhim Kumar Verma"));
    	 empList.add(new Employee(107l, 7416308675l, "OP Verma"));
    	 empList.add(new Employee(108l, 7416308679l, "Sanoj Kumar"));
    	 empList.add(new Employee(109l, 7416308671l, "Lalan Kumar Verma"));
    	 empList.add(new Employee(1010l, 7416318674l, "Rajiv Kumar Verma"));
    	 empList.add(new Employee(108l, 7416308679l, "Sanoj Kumar"));
    	 empList.add(new Employee(109l, 7416308671l, "Lalan Kumar Verma"));
    	 empList.add(new Employee(1010l, 7416318674l, "Rajiv Kumar Verma"));
    	 return empList;
     }
}
