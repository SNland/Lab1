package dcm.Lab;

import java.util.List;

public class CalculateArgs {
    private Integer n0;
    private double u1;
    private double a1;


    public double Resolve(ReadVertexCsv v0,ReadVertexCsv v1,List<DataBeans> e0)
    {
        //no
        n0=v0.getSum();
        //W1的总权重
        Integer weight=0;

        //V1的数据
        List<DataVertex> l1=v1.getVertexList();
        for(DataVertex v:l1)
        {
            weight=v.getWeight();
        }
        u1=weight/n0;
        for(DataVertex v:l1)
        {
            a1=Math.pow((v.getWeight()-weight),2.0);
        }
        a1=a1/n0;

    }

    public CalculateArgs(Integer n0, double u1, double a1) {
        this.n0 = n0;
        this.u1 = u1;
        this.a1 = a1;
    }

    public CalculateArgs() {
        super();
    }

    public Integer getN0() {
        return n0;
    }

    public void setN0(Integer n0) {
        this.n0 = n0;
    }

    public double getU1() {
        return u1;
    }

    public void setU1(double u1) {
        this.u1 = u1;
    }

    public double getA1() {
        return a1;
    }

    public void setA1(double a1) {
        this.a1 = a1;
    }
}
