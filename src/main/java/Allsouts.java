public class Allsouts {
    public static void AllsoutFile() {

        try {

            //Считали всех, кто попал под условия
            System.out.println("Всего человек найдено" + '\t' + Solution.allPeople);
            //Считали всех, кроме студентов с оценкой
            System.out.println("Кроме студентов на ЭКЗ" + '\t' + Solution.NULLPeople);
            //Сумма людей = непосчитанные + с оценкой
            int sumPeople = Solution.NULLPeople + Solution.counterStudentsGrades;
            System.out.println("Сумма людей" + '\t' + '\t' + '\t' + '\t' + sumPeople);
            //Здесь "Всего человек найдено" должно совпасть с "Сумма людей"

            System.out.println();

            System.out.println("Студентов на ЭКЗ" + '\t' + Solution.counterStudentsGrades);
            System.out.println("Сумма оценок" + '\t' + '\t' + Solution.sumOfGrades);
            //результат = сумма оценок/кол-во студентов на экзамене
            float conclusion = (float) Solution.sumOfGrades / (float) Solution.counterStudentsGrades;
            //округление до 3 знаков после запятой
            System.out.printf("Средний балл" + '\t' + '\t' + "%.3f", conclusion);

            System.out.println();
            System.out.println();

            System.out.println("Студентов на ЗАЧ" + '\t' + Solution.counterStudentsOffsets);
            System.out.println("Кол-во сдавших зач" + '\t' + Solution.counterOffsets);
            //% зачетов = кол-во "зачетов"/кол-во студентов на зачете
            float percentOffsets = (float) Solution.counterOffsets / (float) Solution.counterStudentsOffsets;
            //округление до 2 знаков после запятой
            System.out.printf("Процент зачетов" + '\t' + '\t' + "%.2f", percentOffsets);

            System.out.println();
            System.out.println();

            //Чистые неявки = неявки, после которых нет никаких данных об экзамене или зачете
            System.out.println("Чистые неявки" + '\t' + '\t' + Solution.counterNULL);
            System.out.println("Неявок на зачет" + '\t' + '\t' + Solution.counterNULLOffsets);
            System.out.println("Неявок на экзамен" + '\t' + Solution.counterNULLGrades);
            //Процент явок = 1 - (все неявки) / (кол-во студентов на зачете + на экзамене + все неявки)
            float percentNULL = (1 - ((float) (Solution.counterNULL + Solution.counterNULLOffsets + Solution.counterNULLGrades) /
                    (Solution.counterStudentsOffsets + Solution.counterStudentsGrades +
                            Solution.counterNULL + Solution.counterNULLOffsets + Solution.counterNULLGrades)));
            //округление до 2 знаков после запятой
            System.out.printf("Процент явок" + '\t' + '\t' + "%.2f", percentNULL);

            System.out.println();
            System.out.println();

            //Результат = средний балл за экзамены * Процент зачетов (при условии, что зачеты есть)
            float result = (Solution.counterOffsets == 0) ? conclusion : conclusion * percentOffsets;
            //Результат = Предыдущее значение * Процент явок (при условии, что процент явок != 0)
            result = (percentNULL != 0f) ? result * percentNULL : result;

            //округление до 3 знаков после запятой, это число идет в таблицу
            System.out.printf("Итоговое число" + '\t' + '\t' + "%.3f", result);

            System.out.println();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
