import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Создание списка сотрудников
        MainWork work = new MainWork();
        List<Division> divisions = work.genDivision();

        // Сохранение списка сотрудников в CSV файл
        CSVServiceImpl impl = new CSVServiceImpl();
        impl.export_(divisions,"divisions.csv");

        // Информация о каждом отделе
        work.info(divisions);

        // Импорт списка сотрудников из CSV файла
        impl.import_("divisions1.csv");

        // Информация о каждом отделе
        work.info(impl.divisions);
    }
}
