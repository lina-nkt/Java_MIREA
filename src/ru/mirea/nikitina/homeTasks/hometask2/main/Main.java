import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        GenLogic work = new GenLogic();
        HashMap<LocalDate, Integer> books;
        String dataFile = "books.json";

        if (work.dataFileExists(dataFile)){
            books = work.loadFromJson(dataFile);
        } else {
            books = work.generateData();
            work.saveToJson(books, dataFile);
        }

        //Количество взятых книг из библиотеки читателями за месяц
        int sum = work.sumPerMonth(books);
        System.out.println("Количество взятых книг из библиотеки читателями за месяц: " + sum);

        //Cреднее в день
        double average = work.averageDay(books);
        DecimalFormat df = new DecimalFormat("#.##");
        String averRes = df.format(average);
        System.out.println("Среднее количество взятых книг в день: " + averRes);

        //Сохранение результата в файл
        work.saveResToJson(String.valueOf(sum), averRes, "Results.json");
    }
}
