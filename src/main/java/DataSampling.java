public class DataSampling {

    public static void DataSamplingFile() {
        try {
            if (//(Solution.arrayOfCSVFile[0].equals("")) &                                    //курсы по выбору
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

                if (!Solution.arrayOfCSVFile[6].equals("2") &                                 //если НЕ 2 3 4 5
                        !Solution.arrayOfCSVFile[6].equals("3") &
                        !Solution.arrayOfCSVFile[6].equals("4") &
                        !Solution.arrayOfCSVFile[6].equals("5")) {

                    switch (Solution.arrayOfCSVFile[6]) {
                        case "зач", "зач ", "зач*" -> {
                            Solution.counterOffsets++;                                       //считаем кол-во студентов, сдавших зачет
                            Solution.counterStudentsOffsets++;                               //считаем кол-во студентов на зачете
                        }
                    }

                    switch (Solution.arrayOfCSVFile[6]) {                                    //считаем кол-во студентов на зачете
                        case "незач", "нез", "нзч", "не", "нз":
                            Solution.counterStudentsOffsets++;
                            break;

                        case "ня", "ня ", "неяв", "н":                                        //неявка = 2
                            Solution.arrayOfCSVFile[6] = "2";
                            break;

                        default:
                            switch (Solution.arrayOfCSVFile[6]) {                             //убираем *
                                case "3*" -> Solution.arrayOfCSVFile[6] = "3";
                                case "4*" -> Solution.arrayOfCSVFile[6] = "4";
                                case "5*" -> Solution.arrayOfCSVFile[6] = "5";
                            }
                            break;
                    }
                }

                if (!Solution.arrayOfCSVFile[6].equals("2") &                                 //обнуляем ненужные данные об отчислениях и тд
                        !Solution.arrayOfCSVFile[6].equals("3") &
                        !Solution.arrayOfCSVFile[6].equals("4") &
                        !Solution.arrayOfCSVFile[6].equals("5")) {
                    Solution.arrayOfCSVFile[6] = null;

                } else {
                    Solution.counterStudentsGrades++;                                             //считаем кол-во студентов с оценками
                    Solution.sumOfGrades += Integer.parseInt(Solution.arrayOfCSVFile[6]);         //считаем сумму оценок
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
