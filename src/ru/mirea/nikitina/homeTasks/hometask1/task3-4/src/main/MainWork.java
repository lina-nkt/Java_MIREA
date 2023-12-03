import java.util.ArrayList;
import java.util.List;


public class MainWork {
    public List<Division> genDivision(){
        List<Division> divisions = new ArrayList<>();

        // Создание трех отделов
        divisions.add(new Division("HR"));
        divisions.add(new Division("Tech"));
        divisions.add(new Division("Sales"));

        // Добавление сотрудников с разными должностями и зарплатами
        Employer employer1 = new Employer("John", 1000, PositionType.HEAD, new Division("HR"));
        Employer employer2 = new Employer("Alice", 1000, PositionType.MANAGER, new Division("HR"));
        Employer employer3 = new Employer("Bob", 1000, PositionType.SALER, new Division("HR"));

        divisions.get(0).addEmployer(employer1);
        divisions.get(0).addEmployer(employer2);
        divisions.get(0).addEmployer(employer3);

        Employer employer4 = new Employer("Charlie", 1000, PositionType.MANAGER, new Division("Tech"));
        Employer employer5 = new Employer("David", 1000, PositionType.WORKER, new Division("Tech"));

        divisions.get(1).addEmployer(employer4);
        divisions.get(1).addEmployer(employer5);

        Employer employer6 = new Employer("Eva", 1000, PositionType.HEAD, new Division("Sales"));
        Employer employer7 = new Employer("Frank", 1000, PositionType.MANAGER, new Division("Sales"));
        Employer employer8 = new Employer("Grace", 1000, PositionType.WORKER, new Division("Sales"));

        divisions.get(2).addEmployer(employer6);
        divisions.get(2).addEmployer(employer7);
        divisions.get(2).addEmployer(employer8);

        return divisions;
    }
    public void info(List<Division> divisions){
        for (Division division : divisions){
            System.out.println("Название отдела: " + division.getName());
            if (division.getHeadOfDivision() != null){
                System.out.println("Глава отдела: " + division.getHeadOfDivision().getName());
                System.out.println("Зарплата главы: " + division.getHeadOfDivision().getSalary());
            }
            else System.out.println("Отдел работает без руководителя");
            System.out.println("Количество сотрудников в отделе: " + division.getEmployerList().size());
            int sal = 0;
            for (Employer employer : division.getEmployerList()){
                sal += employer.getSalary();
            }
            System.out.println("Средняя зарплата сотрудников: " + (sal / division.getEmployerList().size()) + '\n');
        }
    }
}
