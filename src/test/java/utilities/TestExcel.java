package utilities;

public class TestExcel {

    public static void main(String[] args) throws Exception {

        String path = System.getProperty("user.dir") + "/TestData/LoginData.xlsx";

        ExcelUtils xl = new ExcelUtils(path);

        int rows = xl.getRowCount("Login");

        int cols = xl.getCellCount("Login", 0);

        System.out.println("Rows = " + rows);

        System.out.println("Columns = " + cols);

        for(int i = 1; i <= rows; i++) {

            for(int j = 0; j < cols; j++) {

                System.out.print(xl.getCellData("Login", i, j) + "    ");
            }

            System.out.println();
        }

        xl.closeWorkbook();
    }
}