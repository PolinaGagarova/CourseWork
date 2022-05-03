public class Solution {

    public static String src = "D:\\CourseWork\\Java\\marks.csv";
    public static String[] arrayOfCSVFile = new String[10];
    public static int counterStudents = 0;
    public static int sumOfGrades = 0;
    public static int counterOffsets = 0;

    public static void main(String[] args) throws Exception {

        ReaderFile.ReadingFile();                                        //метод чтения файла
        Allsouts.AllsoutFile();
    }
}
