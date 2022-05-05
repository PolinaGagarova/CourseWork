public class DataSampling {

    public static void DataSamplingFile() {
        try {
            if (//Solution.arrayOfCSVFile[0].equals("False")) &                        //курсы по выбору
                //(Solution.arrayOfCSVFile[1].equals("True")) &                      //бакалавр
                    (Solution.arrayOfCSVFile[2].equals("1")) &                         //курс
                            //(Solution.arrayOfCSVFile[3].equals("")) &                        //предмет
                            //(Solution.arrayOfCSVFile[4].equals("False")) &                   //к/в?
                            //(Solution.arrayOfCSVFile[5].equals("")) &                        //группа
                            //(Solution.arrayOfCSVFile[7].equals("")) &                        //бюджет
                            //(Solution.arrayOfCSVFile[8].equals("")) &                        //студент
                            (Solution.arrayOfCSVFile[9].equals("20-21-winter")))               //год сезон
            {

                Solution.allPeople++;


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

                    if ("незач".equals(Solution.arrayOfCSVFile[6]) ||                        //если незачет, то КСЗ +1
                            "нез".equals(Solution.arrayOfCSVFile[6]) ||
                            "нзч".equals(Solution.arrayOfCSVFile[6]) ||
                            "не".equals(Solution.arrayOfCSVFile[6]) ||
                            "нз".equals(Solution.arrayOfCSVFile[6])) {
                        Solution.counterStudentsOffsets++;


                    } else if ("ня".equals(Solution.arrayOfCSVFile[6]) ||                  //если неявка, то
                            "ня ".equals(Solution.arrayOfCSVFile[6]) ||
                            "неяв".equals(Solution.arrayOfCSVFile[6]) ||
                            "н".equals(Solution.arrayOfCSVFile[6]) ||
                            "н ".equals(Solution.arrayOfCSVFile[6])) {

                        if (parts[parts.length - 1].equals("зач") ||
                                parts[parts.length - 1].equals("зач ") ||
                                parts[parts.length - 1].equals("зач*") ||
                                parts[parts.length - 1].equals("незач") ||
                                parts[parts.length - 1].equals("нез") ||
                                parts[parts.length - 1].equals("нзч") ||
                                parts[parts.length - 1].equals("не") ||
                                parts[parts.length - 1].equals("нз")) {
                            Solution.counterStudentsOffsets++;

                        } else if (parts[parts.length - 1].equals("2") ||
                                parts[parts.length - 1].equals("3") ||
                                parts[parts.length - 1].equals("4") ||
                                parts[parts.length - 1].equals("5") ||
                                parts[parts.length - 1].equals("3*") ||
                                parts[parts.length - 1].equals("4*") ||
                                parts[parts.length - 1].equals("5*")) {
                            Solution.arrayOfCSVFile[6] = "2";
                            Solution.counterStudentsGrades++;

                        } else if (parts[parts.length - 1].equals("ня") ||
                                parts[parts.length - 1].equals("ня ") ||
                                parts[parts.length - 1].equals("неяв") ||
                                parts[parts.length - 1].equals("н") ||
                                parts[parts.length - 1].equals("н ")) {
                            Solution.counterNULL++;
                        }

                    } else {
                        switch (Solution.arrayOfCSVFile[6]) {                             //убираем *
                            case "3*" -> Solution.arrayOfCSVFile[6] = "3";
                            case "4*" -> Solution.arrayOfCSVFile[6] = "4";
                            case "5*" -> Solution.arrayOfCSVFile[6] = "5";
                        }
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
