/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentlist;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

import java.util.*;

/**
 *
 * @author Asus
 */
class List {
    
     int count = 0;
    String name, matricno;
    ArrayList<List> list = new ArrayList<List>( );

    List(String matricno, String name) throws IOException {
        this.matricno = matricno;
        this.name = name;

    }

   List(int count, String matricno, String name) throws IOException {
        this.count = count;
        this.matricno = matricno;
        this.name = name;
    }

    List() throws IOException {
    }

    public String getName() {
        return name;

    }

    public void setName(String newName) {
        this.name = newName;
    }

    public String getMatricNo() {
        return matricno;
    }

    public void setMatricno(String matricno) {
        this.matricno = matricno;
    }

    public int getCount() {
        count += 1;
        return count;
    }

    public void createAccount(String matricno, String name) throws IOException {
        List s = new List(matricno, name);
        int c =1;
        list.add(s);
        try {
            XSSFWorkbook workbook = new XSSFWorkbook( );
            XSSFSheet sheet = workbook.createSheet("List of Students");// creating a blank sheet

            Row row = sheet.createRow(0);
            Cell cell = row.createCell(0);
            Cell cell1 = row.createCell(1);
            Cell cell2 = row.createCell(2);

            cell.setCellValue("No");
            cell1.setCellValue("Matric No.");
            cell2.setCellValue("Name");
            int rownum = 1;
            for (List listf : list) {
                Row row1 = sheet.createRow(rownum++);
                createList(c,listf, row1);
                c++;
            }
            FileOutputStream out = new FileOutputStream(new File("C:\\Users\\Asus\\Documents\\NetBeansProjects\\mavenproject5.DisplayExcel\\STUDENTLIST\\StudentList.xlsx")); // file name with path
            for(int j =0; j<3;j++){
                sheet.autoSizeColumn(j);
            }
            workbook.write(out);
            out.close( );

        } catch (Exception e) {
            e.printStackTrace( );
        }
    }


    public static void createList(int c, List f, Row row) // creating cells for each row

    {
        Cell cell = row.createCell(0);
        Cell cell1 = row.createCell(1);
        Cell cell2 = row.createCell(2);

        cell.setCellValue(c);
        cell1.setCellValue(f.getMatricNo( ));
        cell2.setCellValue(f.getName( ));
    }

    public void List() {
        for (List std : list) {
            System.out.println(std.getMatricNo( ) + " " + std.getName( ));
        }
    }
    
}
