package dcm.Lab;

public class DataBeans {
    private Integer source;
    private Integer target;
    private double weight;

    public DataBeans() {
        super();
    }

    public DataBeans(Integer source, Integer target, double weight) {
        this.source = source;
        this.target = target;
        this.weight = weight;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public Integer getTarget() {
        return target;
    }

    public void setTarget(Integer target) {
        this.target = target;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
