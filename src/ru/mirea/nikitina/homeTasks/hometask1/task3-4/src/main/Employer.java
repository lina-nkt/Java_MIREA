import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Employer {
    private String name;
    private Integer salary;
    private PositionType position;
    private Division division;

    public Employer(String name, Integer salary, PositionType position, Division division) {
        this.name = name;
        this.position = position;
        this.salary = (int) (position.getMultiplier() * salary);
        this.division = division;
    }
}
