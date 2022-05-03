public class DataSampling {

    public static void DataSamplingFile() {
        try {
            if ( //(Solution.arrayOfCSVFile[0].equals("")) &                                   //курсы по выбору
                    (Solution.arrayOfCSVFile[1].equals("True")) &                              //бакалавр
                            (Solution.arrayOfCSVFile[2].equals("1")) &                         //курс
                            //(Solution.arrayOfCSVFile[3].equals("")) &                        //предмет
                            (Solution.arrayOfCSVFile[4].equals("False")) &                     //к/в?
                            //(Solution.arrayOfCSVFile[5].equals("")) &                        //группа
                            //(Solution.arrayOfCSVFile[7].equals("")) &                        //бюджет
                            //(Solution.arrayOfCSVFile[8].equals("")) &                        //студент
                            (Solution.arrayOfCSVFile[9].equals("17-18-summer")))               //год сезон
            {

                String[] parts = Solution.arrayOfCSVFile[6].split("/");
                Solution.arrayOfCSVFile[6] = parts[0];                                        //делим по /, берем 1-ый элемент

                if (!Solution.arrayOfCSVFile[6].equals("2") &                                 //если не 2 3 4 5
                        !Solution.arrayOfCSVFile[6].equals("3") &
                        !Solution.arrayOfCSVFile[6].equals("4") &
                        !Solution.arrayOfCSVFile[6].equals("5")) {

                    if (Solution.arrayOfCSVFile[6].equals("зач") ||                          //считаем зачеты
                            Solution.arrayOfCSVFile[6].equals("зач ") ||
                            Solution.arrayOfCSVFile[6].equals("зач*")) {
                        Solution.counterOffsets++;
                        Solution.counterStudentsOffsets++;
                    }

                    if (Solution.arrayOfCSVFile[6].equals("незач") ||                          //считаем зачеты
                            Solution.arrayOfCSVFile[6].equals("нез") ||
                            Solution.arrayOfCSVFile[6].equals("нзч") ||
                            Solution.arrayOfCSVFile[6].equals("не") ||
                            Solution.arrayOfCSVFile[6].equals("нз")) {
                        Solution.counterStudentsOffsets++;


                    } else if (Solution.arrayOfCSVFile[6].equals("ня") ||                           //неявка = 2
                            Solution.arrayOfCSVFile[6].equals("ня ") ||
                            Solution.arrayOfCSVFile[6].equals("неяв")) {
                        Solution.arrayOfCSVFile[6] = "2";

                    } else switch (Solution.arrayOfCSVFile[6]) {                                    //убираем *
                        case "3*" -> Solution.arrayOfCSVFile[6] = "3";
                        case "4*" -> Solution.arrayOfCSVFile[6] = "4";
                        case "5*" -> Solution.arrayOfCSVFile[6] = "5";
                    }
                }

                if (!Solution.arrayOfCSVFile[6].equals("2") &
                        !Solution.arrayOfCSVFile[6].equals("3") &
                        !Solution.arrayOfCSVFile[6].equals("4") &
                        !Solution.arrayOfCSVFile[6].equals("5")) {
                    Solution.arrayOfCSVFile[6] = null;

                } else {
                    Solution.counterStudentsGrades++;                                                   //считаем кол-во студентов
                    Solution.sumOfGrades += Integer.parseInt(Solution.arrayOfCSVFile[6]);         //считаем сумму оценок
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
