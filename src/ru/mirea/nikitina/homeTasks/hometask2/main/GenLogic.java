import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class GenLogic {

    public void saveToJson(HashMap<LocalDate, Integer> books, String dataFile) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        // Преобразование LocalDate в строку для ключей
        HashMap<String, Integer> stringDateMap = new HashMap<>();
        books.forEach((key, value) -> stringDateMap.put(key.toString(), value));

        // Запись данных в файл JSON
        objectMapper.writeValue(new File(dataFile), stringDateMap);

        System.out.println("Данные записаны в Json файл: " + dataFile);
    }

    public HashMap<LocalDate, Integer> loadFromJson(String dataFile){
        ObjectMapper objectMapper = new ObjectMapper();
        HashMap<LocalDate, Integer> books = new HashMap<>();

        try{
            HashMap<String, Integer> map = objectMapper.readValue(new File(dataFile), HashMap.class);

            // Преобразование ключей в тип LocalDate
            map.forEach((key, value) -> books.put(LocalDate.parse(key), value));


        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Данные выгружены из Json файла: " + dataFile);
        return books;

    }

    public boolean dataFileExists(String dataFile){
        File file = new File(dataFile);
        return file.exists();
    }

    public HashMap<LocalDate, Integer> generateData(){
        HashMap<LocalDate, Integer> books = new HashMap<>();

        for(int i = 1; i < LocalDate.of(2023, 9, 1).lengthOfMonth(); i++){
            books.put(LocalDate.of(2023, 9, i), new Random().nextInt(20));
        }

        return books;
    }

    public int sumPerMonth(HashMap<LocalDate,Integer> books){
        return books.values()
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public double averageDay(HashMap<LocalDate, Integer> books){
        return books.values()
                .stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }


    public void saveResToJson(String summa,String average, String dataFile){
        ObjectMapper objectMapper = new ObjectMapper();
        HashMap<String, String> resMap = new HashMap<>();

        resMap.put("summ", summa);
        resMap.put("average", average);

        try {
            objectMapper.writeValue(new File(dataFile), resMap);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Результат выгружен в файл " + dataFile);
    }
}
