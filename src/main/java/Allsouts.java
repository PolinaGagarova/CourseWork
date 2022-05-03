public class Allsouts {
    public static void AllsoutFile() {

        try {

            System.out.println("кол-во студентов с оц" + '\t' + '\t' + '\t' + Solution.counterStudentsGrades);
            System.out.println("сумма оценок" + '\t' + '\t' + '\t' + '\t' + '\t' + Solution.sumOfGrades);
            float conclusion = (float) Solution.sumOfGrades / (float) Solution.counterStudentsGrades;     //результат = сумма оценок/кол-во студентов с оц
            System.out.printf("средний балл" + '\t' + '\t' + '\t' + '\t' + '\t' + "%.3f", conclusion);                  //округление до 3 знаков после запятой

            System.out.println();
            System.out.println();

            System.out.println("кол-во студентов на зачетах" + '\t' + '\t' + Solution.counterOffsets);
            System.out.println("кол-во студентов с \"зачетом\"" + '\t' + Solution.counterStudentsOffsets);
            float percentOffsets = (float) Solution.counterOffsets / (float) Solution.counterStudentsOffsets;
            System.out.printf("процент зачетов" + '\t' + '\t' + '\t' + '\t' + '\t' + "%.2f", percentOffsets);   //% зачетов = кол-во "зачетов"/кол-во студентов зачетных

            System.out.println();
            System.out.println();

            float result = conclusion * percentOffsets;                                                      //результат = ср балл * на зачеты
            System.out.printf("итоговое число" + '\t' + '\t' + '\t' + '\t' + '\t' + "%.3f", result);

            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
