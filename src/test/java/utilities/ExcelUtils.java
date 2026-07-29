package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    String path;
    FileInputStream fis;
    XSSFWorkbook workbook;
    XSSFSheet sheet;

    public ExcelUtils(String excelPath) throws IOException {

        path = excelPath;
        fis = new FileInputStream(path);
        workbook = new XSSFWorkbook(fis);
    }

    // Get total number of rows
    public int getRowCount(String sheetName) {

        sheet = workbook.getSheet(sheetName);

        return sheet.getLastRowNum();
    }

    // Get total number of columns
    public int getCellCount(String sheetName, int rownum) {

        sheet = workbook.getSheet(sheetName);

        Row row = sheet.getRow(rownum);

        return row.getLastCellNum();
    }

    // Read data from Excel
    public String getCellData(String sheetName, int rownum, int colnum) {

        sheet = workbook.getSheet(sheetName);

        Row row = sheet.getRow(rownum);

        Cell cell = row.getCell(colnum);

        DataFormatter formatter = new DataFormatter();

        return formatter.formatCellValue(cell);
    }

    // Close workbook
    public void closeWorkbook() throws IOException {

        workbook.close();
        fis.close();
    }
}