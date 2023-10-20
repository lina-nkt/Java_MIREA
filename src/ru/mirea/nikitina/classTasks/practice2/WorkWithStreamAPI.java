package ru.mirea.nikitina.classTasks.practice2;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class WorkWithStreamAPI {

    private static List<Worker> workers;

    public WorkWithStreamAPI(List<Worker> workers){WorkWithStreamAPI.workers = workers;}

    public static Worker getMaxSal(){
        return workers.stream()
                .max(Comparator.comparingInt(Worker :: getSalary))
                .orElse(null);

    }

    public static Worker getMinSal(){
        return workers.stream()
                .min(Comparator.comparingInt(Worker::getSalary))
                .orElse(null);
    }

    public static List<Worker> less50AndCat(){
        return workers.stream()
                .filter(x -> x.getAge() < 50)
                .filter(x -> x.getCatName() != null)
                .sorted(Comparator.comparingInt(Worker::getAge))
                .toList();
    }

    public static List<Worker> more50AndCat(){
        return workers.stream()
                .filter(x -> x.getAge() > 50)
                .filter(x -> x.getCatName() != null)
                .sorted(Comparator.comparingInt(Worker::getAge))
                .toList();
    }

    public static List<Worker> doubleBonus(String depart){
        return workers.stream()
                .filter(x -> x.getDivision().equals(depart))
                .peek(worker -> {int bonus = worker.getBonus();
                if (bonus > 0) worker.setBonus(bonus * 2);})
                .toList();
    }

    public  static Optional<Worker> salary100k(){
        return workers.stream()
                .filter(x -> (x.getBonus() + x.getSalary()) >= 100000)
                .findFirst();
    }

    public static void printCountWorkers(){
        workers.stream()
                .collect(Collectors.groupingBy(Worker::getDivision, Collectors.counting()))
                .forEach((department, count) -> System.out.println(department + ": " + count));
    }
}
