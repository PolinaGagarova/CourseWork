public class DataSampling {

    public static void DataSamplingFile() {
        if ( //(Solution.arrayOfCSVFile[0].equals("")) &                                   //курсы по выбору
                (Solution.arrayOfCSVFile[1].equals("True")) &                              //бакалавр
                        (Solution.arrayOfCSVFile[2].equals("1")) &                         //курс
                        //(Solution.arrayOfCSVFile[3].equals("")) &                        //предмет
                        (Solution.arrayOfCSVFile[4].equals("False")) &                     //к/в?
                        //(Solution.arrayOfCSVFile[5].equals("")) &                        //группа
                        //(Solution.arrayOfCSVFile[7].equals("")) &                        //бюджет
                        //(Solution.arrayOfCSVFile[8].equals("")) &                        //студент
                        (Solution.arrayOfCSVFile[9].equals("20-21-winter")))               //год сезон
        {


            //----------------------------------------------------------------------------------------------------------------
            //---------------------------- ВВЕРХУ МЕТОД ВЫБОРКИ ДАННЫХ ---------------------------------------------------------
            //----------------------------------------------------------------------------------------------------------------


            if ((!Solution.arrayOfCSVFile[6].equals("3")) &
                    (!Solution.arrayOfCSVFile[6].equals("4")) &
                    (!Solution.arrayOfCSVFile[6].equals("5"))) {                       //если оценка не 3 4 5

                String[] parts = Solution.arrayOfCSVFile[6].split("/");
                Solution.arrayOfCSVFile[6] = parts[0];                                 //делим по /, берем 1-ый элемент


                //----------------------------------------------------------------------------------------------------------------
                //---------------------------- ВНИЗУ МЕТОД ОБРАБОТКИ ИСКЛЮЧЕНИЙ ---------------------------------------------------------
                //----------------------------------------------------------------------------------------------------------------


                if (Solution.arrayOfCSVFile[6].equals("зач") ||
                        Solution.arrayOfCSVFile[6].equals("зач ") ||
                        Solution.arrayOfCSVFile[6].equals("зач*")) {
                    Solution.counterOffsets++;
                }

                if (Solution.arrayOfCSVFile[6].equals("незач") ||
                        Solution.arrayOfCSVFile[6].equals("зач") ||
                        Solution.arrayOfCSVFile[6].equals("нез") ||
                        Solution.arrayOfCSVFile[6].equals("нзч") ||
                        Solution.arrayOfCSVFile[6].equals("не") ||
                        Solution.arrayOfCSVFile[6].equals("зач ") ||
                        Solution.arrayOfCSVFile[6].equals("зач*") ||
                        Solution.arrayOfCSVFile[6].equals("нз") ||
                        Solution.arrayOfCSVFile[6].equals("отчислен") ||
                        Solution.arrayOfCSVFile[6].equals("отчислен с 25.08.2020") ||
                        Solution.arrayOfCSVFile[6].equals("отчислен с 01.07.2020") ||
                        Solution.arrayOfCSVFile[6].equals("отчислен с 20.01.2020") ||
                        Solution.arrayOfCSVFile[6].equals("отчислен с 03.07.2020") ||
                        Solution.arrayOfCSVFile[6].equals("отчислен с 31.01.2020") ||
                        Solution.arrayOfCSVFile[6].equals("отчислена с 06.11.2020") ||
                        Solution.arrayOfCSVFile[6].equals("отчислен с 01.04.2021") ||
                        Solution.arrayOfCSVFile[6].equals("отчислен с 01.03.2021") ||
                        Solution.arrayOfCSVFile[6].equals("отчислен с 16.01.2021") ||
                        Solution.arrayOfCSVFile[6].equals("Отчислен") ||
                        Solution.arrayOfCSVFile[6].equals("* Разработка сайта различными средствами ") ||
                        Solution.arrayOfCSVFile[6].equals("Реализация решения задачи об обедающих философах на языке Python") ||
                        Solution.arrayOfCSVFile[6].equals("отчисление по с") ||
                        Solution.arrayOfCSVFile[6].equals("а") ||
                        Solution.arrayOfCSVFile[6].equals("перевод") ||
                        Solution.arrayOfCSVFile[6].equals("пер. на экон. ф-т с 17.09.2020") ||
                        Solution.arrayOfCSVFile[6].equals("пер. в ПИЭ-11БО с 14.09.2020") ||
                        Solution.arrayOfCSVFile[6].equals("пер. в ИВТ-12БО с 29.03.2021; в а") ||
                        Solution.arrayOfCSVFile[6].equals("пер. в ИВТ-11БО с 13.04.2021") ||
                        Solution.arrayOfCSVFile[6].equals("болел с 14.09.20187 по 24.09.2018") ||
                        Solution.arrayOfCSVFile[6].equals("болел с 20 по 24.02") ||
                        Solution.arrayOfCSVFile[6].equals("болел с 19.09 по 28.09") ||
                        Solution.arrayOfCSVFile[6].equals("переведена в ЯГТУ") ||
                        Solution.arrayOfCSVFile[6].equals("43133") ||
                        Solution.arrayOfCSVFile[6].equals("в а")) {
                    Solution.arrayOfCSVFile[6] = null;
                }                                                                             //убираем зач незач + всякую фигню


                //----------------------------------------------------------------------------------------------------------------
                //---------------------------- ВВЕРХУ МЕТОД ОБРАБОТКИ ОЦЕНОК -----------------------------------------------------
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

                if (Solution.arrayOfCSVFile[6] != null) {

                    if (Solution.arrayOfCSVFile[6].equals("ня") ||
                            Solution.arrayOfCSVFile[6].equals("ня ") ||
                            Solution.arrayOfCSVFile[6].equals("неяв")) {
                        Solution.arrayOfCSVFile[6] = "2";
                    }                                                                        //неявка = 2

                    switch (Solution.arrayOfCSVFile[6]) {
                        case "3*" -> Solution.arrayOfCSVFile[6] = "3";                       //убираем *
                        case "4*" -> Solution.arrayOfCSVFile[6] = "4";
                        case "5*" -> Solution.arrayOfCSVFile[6] = "5";
                    }
                }
            }

            if (Solution.arrayOfCSVFile[6] != null) {
                Solution.counterStudents++;                                                   //считаем кол-во студентов
                Solution.sumOfGrades += Integer.parseInt(Solution.arrayOfCSVFile[6]);         //считаем сумму оценок

            }
        }
    }
}
