public class Solution {

    public static String src = "D:\\CourseWork\\Java\\marks.csv";
    public static String[] arrayOfCSVFile = new String[10];

    public static int counterStudentsGrades = 0;
    public static int sumOfGrades = 0;

    public static int counterStudentsOffsets = 0;
    public static int counterOffsets = 0;

    public static int counterNULL = 0;
    public static int counterNULLOffsets = 0;
    public static int counterNULLGrades = 0;

    public static int allPeople = 0;
    public static int NULLPeople = 0;

    public static void main(String[] args) {

        try {
            //метод чтения файла
            ReaderFile.ReadingFile();

            //метод вывода всех результатов
            Allsouts.AllsoutFile();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
