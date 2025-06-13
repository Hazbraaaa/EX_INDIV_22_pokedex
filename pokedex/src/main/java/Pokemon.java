import java.util.List;

public class Pokemon {
    private String num;
    private String name;
    private double weight;
    private double height;
    private List<String> nextEvolution;
//    private List<Type> type;

    public Pokemon(String num, String name, double weight, double height, List<String> nextEvolution) {
        this.num = num;
        this.name = name;
        this.weight = weight;
        this.height = height;
        this.nextEvolution = nextEvolution;
    }

    public String getNum() {
        return num;
    }
    public String getName() {
        return name;
    }
    public double getWeight() {
        return weight;
    }
    public double getHeight() {
        return height;
    }
    public List<String> getNextEvolution() {
        return nextEvolution;
    }
}
