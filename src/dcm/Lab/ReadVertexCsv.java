package dcm.Lab;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadVertexCsv {
    private Integer Id;
    private Integer Weight;
    private Integer sum;
    private List<DataVertex> vertexList=new ArrayList<>();

    public ReadVertexCsv(Integer sum, List<DataVertex> vertexList) {
        this.sum = sum;
        this.vertexList = vertexList;
    }

    public ReadVertexCsv() {
        super();
    }

    public List<DataVertex> getVertexList() {
        return vertexList;
    }

    public void setVertexList(List<DataVertex> vertexList) {
        this.vertexList = vertexList;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public void readFile(String filename)
    {
        //读取文件数据
        try {
            FileReader fw=new FileReader(filename);
            BufferedReader read=new BufferedReader(fw);
            read.readLine();
            String line=null;
            while((line=read.readLine())!=null)
            {
                //将读取的数据提取，生成对象
                String item[]=line.split(",");
                Id=Integer.parseInt(item[0]);
                Weight=Integer.parseInt(item[1]);
                vertexList.add(new DataVertex(Id,Weight));
                sum++;
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("读取文件失败，请尝试！");
            e.printStackTrace();
        }
    }
}
