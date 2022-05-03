public class Allsouts {
    public static void AllsoutFile() {

        System.out.println("кол-во студентов" + '\t' + Solution.counterStudents);
        System.out.println("сумма оценок" + '\t' + '\t' + Solution.sumOfGrades);
        System.out.println("кол-во зачетов" + '\t' + '\t' + Solution.counterOffsets);

        float percentOffsets = (float) Solution.counterOffsets / (float) Solution.counterStudents;
        System.out.printf("процент зачетов" + '\t' + '\t' + "%.2f", percentOffsets);                   //% зачетов = кол-во зачетов/кол-во студентов
        System.out.println();

        float conclusion = (float) Solution.sumOfGrades / (float) Solution.counterStudents;            //результат = сумма оценок/кол-во студентов
        System.out.printf("средний балл" + '\t' + '\t' + "%.3f", conclusion);                          //округление до 3 знаков после запятой
        System.out.println();

        float itog = conclusion * percentOffsets;                                                      //итог с * на зачеты

        System.out.printf("итоговое число" + '\t' + '\t' + "%.3f", itog);
    }
}
