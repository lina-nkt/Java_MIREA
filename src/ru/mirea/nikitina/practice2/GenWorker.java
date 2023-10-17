package ru.mirea.nikitina.practice2;

import java.util.Random;

public class GenWorker {

    private static final String[] FIRST_NAME = {"Авелина", "Саша", "Семен", "Рома", "Арина", "Даня", "Даша", "Егор", "Артур", "Андрей" };

    private static final String[] LAST_NAME = {"Королев", "Никитина", "Сидоров", "Табаченков", "Колесников", "Золотерва", "Чернов", "Оганесов", "Воробьева"};

    private static final String[] GENDER = {"Женский", "Мужской"};

    private static final String[] CAT_NAME = {"Барсик", "Клепа", "Чешир", "Авка", "Буся", "Пиздрик", "Зевс", "Корсик"};

    private static final String[] DIVISION = {"Бухгалтерия", "IT", "Маркетинг", "HR", "Кадры", "Разработка"};

    private static final String[] POSITION = {"Менеджер", "Разработчик", "Бухгалтер"};

    private static final Random random = new Random();

    public static Worker genWork(){
        String firstName = FIRST_NAME[random.nextInt(FIRST_NAME.length)];
        String lastName = LAST_NAME[random.nextInt(LAST_NAME.length)];
        String gender = GENDER[random.nextInt(GENDER.length)];
        String catName = random.nextBoolean() ? CAT_NAME[random.nextInt(CAT_NAME.length)] : null;
        String division = DIVISION[random.nextInt(DIVISION.length)];
        String position = POSITION[random.nextInt(POSITION.length)];
        int age = random.nextInt(14,100);
        int salary = random.nextInt(1000,200000);
        int bonus = random.nextInt(50000);
        int lengthOfEmployment = random.nextInt(20);


        return new Worker(firstName, lastName, age, gender, catName, division, position, salary, bonus, lengthOfEmployment);
    }
}
