import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) throws Exception {
        String src = "D:\\CourseWork\\Java\\marks.csv";
        String[] arrayOfCSVFile = new String[10];
        int counterStudents = 0;
        int sumOfGrades = 0;
        int counterOffsets = 0;


        try (FileReader in = new FileReader(src); BufferedReader bufferReader = new BufferedReader(in)) {
            while (bufferReader.ready())                                            //Читаем из файла по 1 строке
            {
                String line = bufferReader.readLine();
                if (line.startsWith("alter")) {
                    continue;
                }                                                                   //Пропустили первую строчку с заголовками

                String[] result = line.split("\t");                           //Разделили по табу, записали в массив
                System.arraycopy(result, 0, arrayOfCSVFile, 0, arrayOfCSVFile.length);


                //----------------------------------------------------------------------------------------------------------------
                //---------------------------- ВВЕРХУ МЕТОД ЧТЕНИЯ ФАЙЛА ---------------------------------------------------------
                //----------------------------------------------------------------------------------------------------------------


                if ( //(arrayOfCSVFile[0].equals("")) &                                   //курсы по выбору
                        (arrayOfCSVFile[1].equals("True")) &                              //бакалавр
                                (arrayOfCSVFile[2].equals("1")) &                         //курс
                                //(arrayOfCSVFile[3].equals("")) &                        //предмет
                                (arrayOfCSVFile[4].equals("False")) &                     //к/в?
                                //(arrayOfCSVFile[5].equals("")) &                        //группа
                                //(arrayOfCSVFile[7].equals("")) &                        //бюджет
                                //(arrayOfCSVFile[8].equals("")) &                        //студент
                                (arrayOfCSVFile[9].equals("20-21-winter")))               //год сезон
                {


                    //----------------------------------------------------------------------------------------------------------------
                    //---------------------------- ВВЕРХУ МЕТОД ВЫБОРКИ ДАННЫХ ---------------------------------------------------------
                    //----------------------------------------------------------------------------------------------------------------


                    if ((!arrayOfCSVFile[6].equals("3")) &
                            (!arrayOfCSVFile[6].equals("4")) &
                            (!arrayOfCSVFile[6].equals("5"))) {                       //если оценка не 3 4 5

                        String[] parts = arrayOfCSVFile[6].split("/");
                        arrayOfCSVFile[6] = parts[0];                                 //делим по /, берем 1-ый элемент


                        //----------------------------------------------------------------------------------------------------------------
                        //---------------------------- ВНИЗУ МЕТОД ОБРАБОТКИ ИСКЛЮЧЕНИЙ ---------------------------------------------------------
                        //----------------------------------------------------------------------------------------------------------------


                        if (arrayOfCSVFile[6].equals("зач") ||
                                arrayOfCSVFile[6].equals("зач ") ||
                                arrayOfCSVFile[6].equals("зач*")) {
                            counterOffsets++;
                        }

                        if (arrayOfCSVFile[6].equals("незач") ||
                                arrayOfCSVFile[6].equals("зач") ||
                                arrayOfCSVFile[6].equals("нез") ||
                                arrayOfCSVFile[6].equals("нзч") ||
                                arrayOfCSVFile[6].equals("не") ||
                                arrayOfCSVFile[6].equals("зач ") ||
                                arrayOfCSVFile[6].equals("зач*") ||
                                arrayOfCSVFile[6].equals("нз") ||
                                arrayOfCSVFile[6].equals("отчислен") ||
                                arrayOfCSVFile[6].equals("отчислен с 25.08.2020") ||
                                arrayOfCSVFile[6].equals("отчислен с 01.07.2020") ||
                                arrayOfCSVFile[6].equals("отчислен с 20.01.2020") ||
                                arrayOfCSVFile[6].equals("отчислен с 03.07.2020") ||
                                arrayOfCSVFile[6].equals("отчислен с 31.01.2020") ||
                                arrayOfCSVFile[6].equals("отчислена с 06.11.2020") ||
                                arrayOfCSVFile[6].equals("отчислен с 01.04.2021") ||
                                arrayOfCSVFile[6].equals("отчислен с 01.03.2021") ||
                                arrayOfCSVFile[6].equals("отчислен с 16.01.2021") ||
                                arrayOfCSVFile[6].equals("Отчислен") ||
                                arrayOfCSVFile[6].equals("* Разработка сайта различными средствами ") ||
                                arrayOfCSVFile[6].equals("Реализация решения задачи об обедающих философах на языке Python") ||
                                arrayOfCSVFile[6].equals("отчисление по с") ||
                                arrayOfCSVFile[6].equals("а") ||
                                arrayOfCSVFile[6].equals("перевод") ||
                                arrayOfCSVFile[6].equals("пер. на экон. ф-т с 17.09.2020") ||
                                arrayOfCSVFile[6].equals("пер. в ПИЭ-11БО с 14.09.2020") ||
                                arrayOfCSVFile[6].equals("пер. в ИВТ-12БО с 29.03.2021; в а") ||
                                arrayOfCSVFile[6].equals("пер. в ИВТ-11БО с 13.04.2021") ||
                                arrayOfCSVFile[6].equals("болел с 14.09.20187 по 24.09.2018") ||
                                arrayOfCSVFile[6].equals("болел с 20 по 24.02") ||
                                arrayOfCSVFile[6].equals("болел с 19.09 по 28.09") ||
                                arrayOfCSVFile[6].equals("переведена в ЯГТУ") ||
                                arrayOfCSVFile[6].equals("43133") ||
                                arrayOfCSVFile[6].equals("в а")) {
                            arrayOfCSVFile[6] = null;
                        }                                                                    //убираем зач незач + всякую фигню


                        //----------------------------------------------------------------------------------------------------------------
                        //---------------------------- ВВЕРХУ МЕТОД ОБРАБОТКИ ИСКЛЮЧЕНИЙ -------------------------------------------------
                        //----------------------------------------------------------------------------------------------------------------
                        //----------------------- его лучше в самый конец обработки оценок; например: ------------------------------------


                        /*
                        if ((arrayOfCSVFile[6] != "2") ||
                                (arrayOfCSVFile[6] != "3") ||
                                (arrayOfCSVFile[6] != "4") ||
                                (arrayOfCSVFile[6] != "5")) {
                            arrayOfCSVFile[6] = null;
                        }
                         */


                        if (arrayOfCSVFile[6] != null) {

                            if (arrayOfCSVFile[6].equals("ня") ||
                                    arrayOfCSVFile[6].equals("ня ") ||
                                    arrayOfCSVFile[6].equals("неяв")) {
                                arrayOfCSVFile[6] = "2";
                            }                                                               //неявка = 2

                            switch (arrayOfCSVFile[6]) {
                                case "3*" -> arrayOfCSVFile[6] = "3";                        //убираем *
                                case "4*" -> arrayOfCSVFile[6] = "4";
                                case "5*" -> arrayOfCSVFile[6] = "5";
                            }
                        }
                    }

                    if (arrayOfCSVFile[6] != null) {
                        counterStudents++;                                          //считаем кол-во студентов
                        sumOfGrades += Integer.parseInt(arrayOfCSVFile[6]);         //считаем сумму оценок


                        //-------------------------------------------------------------------------------------------------------
                        //--------- ВЕСЬ ПОЛНОЦЕННЫЙ МЕТОД ОБРАБОТКИ ОЦЕНОК (ИСКЛЮЧЕНИЯ ВНУТРИ НЕГО) ----------------------------
                        //-------------------------------------------------------------------------------------------------------


                    }
                }
            }
        }


        System.out.println("кол-во студентов" + '\t' + counterStudents);
        System.out.println("сумма оценок" + '\t' + '\t' + sumOfGrades);
        System.out.println("кол-во зачетов" + '\t' + '\t' + counterOffsets);

        float percentOffsets = (float) counterOffsets / (float) counterStudents;             //% зачетов = кол-во зачетов / кол-во студентов
        System.out.printf("процент зачетов" + '\t' + '\t' + "%.2f", percentOffsets);
        System.out.println();

        float conclusion = (float) sumOfGrades / (float) counterStudents;              //результат = сумма оценок/кол-во студентов
        System.out.printf("средний балл" + '\t' + '\t' + "%.3f", conclusion);                            //округление до 3 знаков после запятой
        System.out.println();

        float itog = conclusion * percentOffsets;                                         //итог с * на зачеты

        System.out.printf("итоговое число" + '\t' + '\t' + "%.3f", itog);


        //-------------------------------------------------------------------------------------------------------
        //------------------------- ой, ну, ты просто великолепна!! ---------------------------------------------
        //-------------------------------------------------------------------------------------------------------

    }
}
