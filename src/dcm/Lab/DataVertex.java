package dcm.Lab;

public class DataVertex {
    private Integer Id;
    private Integer Weight;

    public DataVertex(Integer id, Integer weight) {
        Id = id;
        Weight = weight;
    }

    public DataVertex() {
        super();
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getWeight() {
        return Weight;
    }

    public void setWeight(Integer weight) {
        Weight = weight;
    }
}
