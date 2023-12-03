import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
class Division {
    private String name;
    private List<Employer> employers;
    private Employer headOfDivision;

    public Division(String s) {
        this.name = s;
        this.employers = new ArrayList<>();
    }

    public void addEmployer(Employer employer){
        employers.add(employer);
        if (employer.getPosition() == PositionType.HEAD) {
            headOfDivision = employer;
        }
    }

    public List<Employer> getEmployerList(){
        return employers;
    }

}
