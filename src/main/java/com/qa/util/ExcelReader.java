package com.qa.util;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReader {


    public static Object[][] readExcelData(String filePath, String sheetName) throws IOException {
        FileInputStream file = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheet(sheetName);

        // Count rows and columns
        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();  // Assuming the first row is the header

        Object[][] data = new Object[rowCount - 1][colCount]; // Create the data array (excluding the header row)

        // Loop through rows and columns to get the data
        for (int i = 1; i < rowCount; i++) { // Start from 1 to skip the header row
            Row row = sheet.getRow(i);

            for (int j = 0; j < colCount; j++) {
                // Get the cell value
                Cell cell = row.getCell(j);

                // Check if the cell is null or empty
                if (cell == null || cell.getCellType() == CellType.BLANK) {
                    data[i - 1][j] = "";  // Assign a default value (you can change this to whatever you want)
                } else {
                    // Otherwise, get the cell value based on its type (String, Numeric, etc.)
                    switch (cell.getCellType()) {
                        case STRING:
                            data[i - 1][j] = cell.getStringCellValue().trim();  // For String cells
                            break;
                        case NUMERIC:
                            data[i - 1][j] = String.valueOf(cell.getNumericCellValue());  // For Numeric cells
                            break;
                        case BOOLEAN:
                            data[i - 1][j] = String.valueOf(cell.getBooleanCellValue());  // For Boolean cells
                            break;
                        default:
                            data[i - 1][j] = "N/A";  // For other cell types (e.g., formulas or errors)
                            break;
                    }
                }
            }
        }

        return data;
    }
}

