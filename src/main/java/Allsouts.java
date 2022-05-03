public class Allsouts {
    public static void AllsoutFile() {

        try {

            System.out.println("кол-во студентов с оц" + '\t' + Solution.counterStudentsGrades);
            System.out.println("сумма оценок" + '\t' + '\t' + '\t' + Solution.sumOfGrades);
            System.out.println("кол-во зачетов" + '\t' + '\t' + '\t' + Solution.counterOffsets);
            System.out.println("кол-во студентов с зач" + '\t' + '\t' + Solution.counterStudentsOffsets);

            System.out.println();

            float percentOffsets = (float) Solution.counterOffsets / (float) Solution.counterStudentsOffsets;
            System.out.printf("процент зачетов" + '\t' + '\t' + '\t' + "%.2f", percentOffsets);        //% зачетов = кол-во зачетов/кол-во студентов зачетных
            System.out.println();

            System.out.println();

            float conclusion = (float) Solution.sumOfGrades / (float) Solution.counterStudentsGrades;            //результат = сумма оценок/кол-во студентов
            System.out.printf("средний балл" + '\t' + '\t' + '\t' + "%.3f", conclusion);                          //округление до 3 знаков после запятой
            System.out.println();

            float itog = conclusion * percentOffsets;                                                      //итог с * на зачеты

            System.out.printf("итоговое число" + '\t' + '\t' + '\t' + "%.3f", itog);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
