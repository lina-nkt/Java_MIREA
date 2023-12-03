import java.util.List;

public interface CSVService {
    void import_(String fileName);
    void export_(List<Division> divisions, String fileName);
}
