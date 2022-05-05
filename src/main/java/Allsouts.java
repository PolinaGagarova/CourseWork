public class Allsouts {
    public static void AllsoutFile() {

        try {

            System.out.println("всего человек найдено " + Solution.allPeople);

            System.out.println("Студентов на ЭКЗ" + '\t' + Solution.counterStudentsGrades);
            System.out.println("Сумма оценок" + '\t' + '\t' + Solution.sumOfGrades);
            float conclusion = (float) Solution.sumOfGrades / (float) Solution.counterStudentsGrades;     //результат = сумма оценок/кол-во студентов с оц
            System.out.printf("Средний балл" + '\t' + '\t' + "%.3f", conclusion);                  //округление до 3 знаков после запятой

            System.out.println();
            System.out.println();

            System.out.println("Студентов на ЗАЧ" + '\t' + Solution.counterStudentsOffsets);
            System.out.println("Кол-во сдавших зач" + '\t' + Solution.counterOffsets);
            float percentOffsets = (float) Solution.counterOffsets / (float) Solution.counterStudentsOffsets;
            System.out.printf("Процент зачетов" + '\t' + '\t' + "%.2f", percentOffsets);   //% зачетов = кол-во "зачетов"/кол-во студентов зачетных

            System.out.println();
            System.out.println();

            System.out.println("Чистые неявки" + '\t' + '\t' + Solution.counterNULL);
            float percentNULL = (1 - ((float) Solution.counterNULL /
                    (Solution.counterStudentsOffsets + Solution.counterStudentsGrades + Solution.counterNULL)));
            System.out.printf("Процент неявок" + '\t' + '\t' + "%.2f", percentNULL);

            System.out.println();
            System.out.println();

            float result = (Solution.counterOffsets == 0) ? conclusion : conclusion * percentOffsets;
            result = (percentNULL != 0f) ? result * percentNULL : result;

            System.out.printf("Итоговое число" + '\t' + '\t' + "%.3f", result);

            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
