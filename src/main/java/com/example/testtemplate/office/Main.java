package com.example.testtemplate.office;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Table;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.IOException;

/**
 * @author: congcong
 * @email: congccoder@gmail.com
 * @date: 2023/3/7 20:08
 */
public class Main {
    public static void main(String[] args) throws IOException {

        Workbook workbook = WorkbookFactory.create(new File("/Users/chencong/Desktop/test.xlsx"));
        Sheet sheet = workbook.getSheetAt(0);
        PdfDocument pdfDoc = new PdfDocument(new PdfWriter(new File("/Users/chencong/Desktop/test.pdf")));

        Document document = new Document(pdfDoc);

        Table table = new Table(sheet.getRow(0).getLastCellNum());

        for (Row row : sheet) {
            // Loop through each cell in the row
            for (Cell cell : row) {
                // Add the cell value to the PDF table
                table.addCell(cell.toString());
            }
        }
        document.add(table);
        document.close();
    }
}
