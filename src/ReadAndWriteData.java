import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadAndWriteData{

	public static void main(String[] args) {
		try {
            List<Student> studentList = readDataFromExcel("D://file.xlsx");
            displayData(studentList);
        } catch (IOException e) {
            e.printStackTrace();
        }

	}
	private static List<Student> readDataFromExcel(String filePath) throws IOException {
        List<Student> studentList = new ArrayList<>();

        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fileInputStream)) {

            Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet

            for (Row row : sheet) {
                if (row.getRowNum() == 0) {
                    // Skip header row
                    continue;
                }

                Cell nameCell = row.getCell(0);
                Cell courseCell = row.getCell(1);
                Cell feeCell = row.getCell(2);

                String name = nameCell.getStringCellValue();
                String course = courseCell.getStringCellValue();
                String fee = feeCell.getStringCellValue();

                Student student = new Student(name, course, fee);
                studentList.add(student);
            }
        }

        return studentList;
    }

    private static void displayData(List<Student> studentList) {
        System.out.println("Name\tCourses\tFee");
        for (Student student : studentList) {
            System.out.println(student.getName() + "\t" + student.getCourses() + "\t$" + student.getFee());
        }
    }

    private static class Student {
        private String name;
        private String courses;
        private String fee;

        public Student(String name, String courses, String fee) {
            this.name = name;
            this.courses = courses;
            this.fee = fee;
        }

        public String getName() {
            return name;
        }

        public String getCourses() {
            return courses;
        }

        public String getFee() {
            return fee;
        }
    }

}
