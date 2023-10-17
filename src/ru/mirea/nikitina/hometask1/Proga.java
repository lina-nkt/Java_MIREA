package ru.mirea.nikitina.hometask1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Proga{
    public static void main(String[] args) {

        /* Считывание файла  и создание словаря*/

        File file = new File("morze.txt");
        Map<String, String> dictionary = new HashMap<>();

        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("Error!" + e.getMessage());
        }

        while (scanner != null && scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String key_ = line.split(" ")[0];
            String value_ = line.split(" ")[1];

            dictionary.put(key_, value_);
        }

        /* Запрос ввода сообщения */

        Scanner scan = new Scanner(System.in);
        String stopWord = "стоп";

        System.out.println("Введите сообщение (для завершения введите \"" + stopWord + "\"):");
        List<String> encode = new ArrayList<>();

        while (true) {
            String input = scan.nextLine();

            if (input.equals(stopWord)) break;

            encode.add(input);
        }

        /* Обработка сообщения и декодинг */

        StringBuilder decode = new StringBuilder();

        for (String line : encode) {
            String[] letters = line.split(" ");

            for (String letter : letters) {
                boolean found = false;
                for (Map.Entry<String, String> entry : dictionary.entrySet()) {
                    if (entry.getValue().equals(letter)) {
                        decode.append(entry.getKey()).append(" ");
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    decode.append(letter).append(" ");
                }
            }

            decode.append(" ");
        }

        System.out.println(decode.toString());
    }
}