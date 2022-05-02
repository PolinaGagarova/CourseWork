import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) throws Exception {
        String src = "D:\\CourseWork\\Java\\marks.csv";
        String[] arrayOfCSVFile = new String[10];
        int counterStudents = 0;
        int sumOfGrades = 0;


        try (FileReader in = new FileReader(src); BufferedReader bufferReader = new BufferedReader(in)) {
            while (bufferReader.ready())                                      //Читаем из файла по 1 строке
            {
                String line = bufferReader.readLine();
                if (line.startsWith("alter")) {
                    continue;
                }                   //Пропустили первую строчку с заголовками

                String[] result = line.split("\t");                     //Разделили по табу, записали в массив
                for (int i = 0; i < arrayOfCSVFile.length; i++) {
                    arrayOfCSVFile[i] = result[i];
                }

                if ( /*(arrayOfCSVFile[0].equals("")) & */                                      //курсы по выбору
                        (arrayOfCSVFile[1].equals("True")) &                                    //бакалавр
                                (arrayOfCSVFile[2].equals("3")) &                                       //курс
                                /*(arrayOfCSVFile[3].equals("")) & */                                   //предмет
                                (arrayOfCSVFile[4].equals("False")) &                                   //к/в?
                                //(arrayOfCSVFile[5].equals("")) &                                      //группа
                                /*(arrayOfCSVFile[7].equals("")) & */                                   //бюджет
                                /*(arrayOfCSVFile[8].equals("")) & */                                   //студент
                                (arrayOfCSVFile[9].equals("17-18-summer")))                             //год сезон
                {

                    if ((!arrayOfCSVFile[6].equals("3")) &
                            (!arrayOfCSVFile[6].equals("4")) &
                            (!arrayOfCSVFile[6].equals("5"))) {                        //если оценка не 3 4 5
                        String[] parts = arrayOfCSVFile[6].split("/");
                        arrayOfCSVFile[6] = parts[0];                                 //делим по /, берем 1-ый элемент

                        if (arrayOfCSVFile[6].equals("незач") ||
                                arrayOfCSVFile[6].equals("зач") ||
                                arrayOfCSVFile[6].equals("нз") ||
                                arrayOfCSVFile[6].equals("* Разработка сайта различными средствами ") ||
                                arrayOfCSVFile[6].equals("Реализация решения задачи об обедающих философах на языке Python")) {
                            arrayOfCSVFile[6] = null;
                        }                                                                               //убираем зач незач + всякую фигню
                        if (arrayOfCSVFile[6].equals("ня") ||
                                arrayOfCSVFile[6].equals("ня ") ||
                                arrayOfCSVFile[6].equals("неяв")) {
                            arrayOfCSVFile[6] = "2";
                        }                                  //неявка = 2

                        switch (arrayOfCSVFile[6]) {
                            case "3*" -> arrayOfCSVFile[6] = "3";                        //убираем *
                            case "4*" -> arrayOfCSVFile[6] = "4";
                            case "5*" -> arrayOfCSVFile[6] = "5";
                        }

                        if (arrayOfCSVFile[6] != null)                                  //если оценка есть
                        {
                            counterStudents++;                                          //считаем кол-во студентов
                            sumOfGrades += Integer.parseInt(arrayOfCSVFile[6]);         //считаем сумму оценок

                        }
                    }
                }
            }

            System.out.println("кол-во студ " + counterStudents);
            System.out.println("сумма оценок " + sumOfGrades);

            float conclusion = (float) sumOfGrades / (float) counterStudents;              //результат = сумма оценок/кол-во студентов
            System.out.printf("ср балл " + "%.3f", conclusion);                               //округление до 3 знаков после запятой

        }
    }
}
