import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVServiceImpl implements CSVService{
    public List<Division> divisions;

    @Override
    public void import_(String fileName) {

        List<Division> divisions = new ArrayList<>();
        List<String> index_divisions = new ArrayList<>();

        try (CSVReader csvReader = new CSVReaderBuilder(new FileReader(fileName)).withSkipLines(1).build()) {
            List<String[]> allData = csvReader.readAll();

            for (String[] row : allData) {
                String name = row[0];
                PositionType position = PositionType.valueOf(row[1]);
                Integer salary = Integer.parseInt(row[2]);
                String nameDivision = row[3];
                if(!index_divisions.contains(nameDivision)){
                    Division division = new Division(nameDivision);
                    index_divisions.add(nameDivision);
                    divisions.add(division);
                }
                Division division = divisions.get(index_divisions.indexOf(nameDivision));
                Employer employer = new Employer(name, salary, position, division);
                division.addEmployer(employer);


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Данные выгружены из файла\n");
        this.divisions = divisions;
    }


    @Override
    public void export_(List<Division> divisions, String fileName) {
        try (PrintWriter writer = new PrintWriter(fileName)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Name, Position, Salary, Division\n");
            for (Division division : divisions) {
                List<Employer> employers = division.getEmployerList();
                for (Employer employer : employers) {
                    sb.append(employer.getName()).append(",");
                    sb.append(employer.getPosition()).append(",");
                    sb.append(employer.getSalary()).append(",");
                    sb.append(employer.getDivision().getName()).append("\n");
                }
            }
            writer.write(sb.toString());
            System.out.println("Данные экспортированы в файл " + fileName + '\n');
        }
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
