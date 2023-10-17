package ru.mirea.nikitina.hometask1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Proga{
    public static void main(String[] args) {
        Map<String, String> file = readFile();

        Scanner scan = new Scanner(System.in);
        String stopWord = "стоп";
        System.out.println("Русский -> Морзе (1)" + '\n' + "Морзе -> Русский (2)");
        String revers = scan.nextLine();
        System.out.println("Введите сообщение (для завершения введите \"" + stopWord + "\"):" + '\n' + "Каждое слово с новой строки" + '\n' + "Каждая буква через пробел");
        List<String> encode = new ArrayList<>();
        while (true) {
            String input = scan.nextLine();

            if (input.equals(stopWord)) break;

            encode.add(input);
        }
        Map<String, String> dictionary = makeDict(file, revers);
        StringBuilder decode = decodeMessage(dictionary, encode);
        System.out.println(decode.toString().trim());
    }


    public static Map<String, String> readFile(){
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
            String key_ = line.split(" = ")[0];
            String value_ = line.split(" = ")[1];

            dictionary.put(key_, value_);
        }
        return dictionary;
    }

    public static Map<String, String> makeDict(Map<String, String> dictionary, String revers) {
        Map<String, String> newDict = new HashMap<>();
        if (revers.equals("1")) {
            return dictionary;
        } else if (revers.equals("2")) {
            for (Map.Entry<String, String> entry : dictionary.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                newDict.put(value, key);
            }
        }
        return newDict;
    }

    public static StringBuilder decodeMessage(Map<String, String> dictionary, List<String> encode){
        StringBuilder decode = new StringBuilder();

        for (String line : encode) {
            String[] letters = line.split(" ");

            for (String letter : letters) {
                String decLetter = dictionary.get(letter);
                decode.append(decLetter);
            }
            decode.append(" ");
        }
        return decode;
    }


}