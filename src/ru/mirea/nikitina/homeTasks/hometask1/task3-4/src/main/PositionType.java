import lombok.NoArgsConstructor;

@NoArgsConstructor
public enum PositionType {
    WORKER(1.0),
    MANAGER(2.0),
    SALER(1.5),
    HEAD(3.0);

    private double multiplier;

    PositionType(double multiplier) {
        this.multiplier = multiplier;
    }

    public double getMultiplier() {
        return multiplier;
    }
}
