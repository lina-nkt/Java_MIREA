package ru.mirea.nikitina.practice2;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<Worker> workers = new ArrayList<>();

    static WorkWithStreamAPI workersStream = new WorkWithStreamAPI(workers);

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            workers.add(GenWorker.genWork());
        }

        System.out.println("Сотрудник с максимальной зарплатой:" + '\n' + '\n' + WorkWithStreamAPI.getMaxSal() + '\n');
        System.out.println("\n------------------------------------\n");
        System.out.println("Сотрудник с минимальной зарплатой:" + '\n' + '\n' + WorkWithStreamAPI.getMinSal() + '\n');
        System.out.println("\n------------------------------------\n");
        System.out.println("Отсортированные сотрудники с возрастом меньше 50-ти и с котом:" + '\n');
        for (Worker worker: WorkWithStreamAPI.less50AndCat()) {
            System.out.println(worker);
        }
        System.out.println("\n------------------------------------\n");
        System.out.println("Отсортированные сотрудники с возрастом больше 50-ти и с котом:" + '\n');
        for (Worker worker: WorkWithStreamAPI.more50AndCat()) {
            System.out.println(worker);
        }
        System.out.println("\n------------------------------------\n");
        System.out.println("Сотрудники с удвоенным бонусом в отделе IT:" + '\n');
        for (Worker worker: WorkWithStreamAPI.doubleBonus("IT")) {
            System.out.println(worker);
        }
        System.out.println("\n------------------------------------\n");
        if (WorkWithStreamAPI.salary100k().isPresent()){
            System.out.println("Сотрудник с зарплатой + бонус >= 100к:" + '\n' + '\n' + WorkWithStreamAPI.salary100k().get());
            System.out.println("Зарпалата + премия: " + (WorkWithStreamAPI.salary100k().get().getSalary() + WorkWithStreamAPI.salary100k().get().getBonus()) + " наносек");
        }
        else System.out.println("\nКомпания нищебродов\n");
        System.out.println("\n------------------------------------\n");
        System.out.println("Количество сотрудников в отделах:\n");
        WorkWithStreamAPI.printCountWorkers();

    }
}
