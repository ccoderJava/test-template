package com.example.testtemplate.office;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfAConformanceLevel;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfOutputIntent;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.pdfa.PdfADocument;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author: congcong
 * @email: congccoder@gmail.com
 * @date: 2023/3/7 20:08
 */
public class Main {
    public static void main(String[] args) throws IOException {

       wordToPdf();
    }

    //excel转pdf
    public static void excelToPdf() throws IOException {
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

    //word转pdf
    public static void wordToPdf() throws IOException {
        XWPFDocument doc = new XWPFDocument(new FileInputStream("/Users/chencong/Desktop/test.docx"));
        PdfDocument pdfDoc = new PdfDocument(new PdfWriter(new File("/Users/chencong/Desktop/test.pdf")));
        Document document = new Document(pdfDoc);
        for (XWPFParagraph p : doc.getParagraphs()) {
            document.add(new Paragraph(p.getText()));
        }
        document.close();
    }
}
