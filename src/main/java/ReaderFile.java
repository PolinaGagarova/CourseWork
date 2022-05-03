import java.io.BufferedReader;
import java.io.FileReader;

public class ReaderFile {
    public static void ReadingFile() {
        try (FileReader in = new FileReader(Solution.src); BufferedReader bufferReader = new BufferedReader(in)) {
            while (bufferReader.ready())                                            //Читаем из файла по 1 строке
            {
                String line = bufferReader.readLine();
                if (line.startsWith("alter")) {
                    continue;
                }                                                                   //Пропустили первую строчку с заголовками

                String[] result = line.split("\t");                           //Разделили по табу, записали в массив
                System.arraycopy(result, 0, Solution.arrayOfCSVFile, 0, Solution.arrayOfCSVFile.length);

                DataSampling.DataSamplingFile();                                   //обработка массива
            }
        } catch (Exception e) {
            System.out.println("Возникла ошибка чтения файла");
        }
    }
}
