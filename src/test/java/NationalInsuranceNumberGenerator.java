import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class NationalInsuranceNumberGenerator {

    public static void main(String[] args) {
        String excelFilePath = "D:\\SeleniumProjects\\NIArtifact\\DataSet.xlsx";

        try (FileInputStream fileInputStream = new FileInputStream(new File(excelFilePath));
             Workbook workbook = WorkbookFactory.create(fileInputStream)) {

            Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet

            Iterator<Row> rowIterator = sheet.iterator();

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                // Assuming the data is in columns A to E (0-indexed)
                String firstName = getStringValue(row.getCell(0));
                String lastName = getStringValue(row.getCell(1));
                int yearOfBirth = (int) row.getCell(2).getNumericCellValue();
                String randomCode = getStringValue(row.getCell(3));
                String countryOfBirth = getStringValue(row.getCell(4));

                String niNumber = generateNationalInsuranceNumber(firstName, lastName, yearOfBirth, randomCode, countryOfBirth);
                System.out.println("Generated National Insurance Number: " + niNumber);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getStringValue(Cell cell) {
        if (cell.getCellType() == CellType.STRING) {
            return cell.getStringCellValue();
        } else if (cell.getCellType() == CellType.NUMERIC) {
            return String.valueOf((int) cell.getNumericCellValue());
        }
        return "";
    }

    // Generate the National Insurance Number
    private static String generateNationalInsuranceNumber(String firstName, String lastName, int yearOfBirth, String randomCode, String countryOfBirth) {
        return String.format("%s%s%02d%s%s", firstName.charAt(0), lastName.charAt(0), yearOfBirth % 100, randomCode, countryOfBirth);
    }
}
