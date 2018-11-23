package dcm.Lab;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadEdgeCsv {
    private Integer source, target;
    double weight;
    private ArrayList<DataBeans> db = new ArrayList<DataBeans>();


    public ReadEdgeCsv() {
        super();
    }

    public ReadEdgeCsv(int source, int weight, int target, ArrayList<DataBeans> db) {
        this.source = source;
        this.weight = weight;
        this.target = target;
        this.db = db;
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
                //double w;
                //将读取的数据提取，生成对象
                String item[]=line.split(",");
                source=Integer.parseInt(item[0]);
                target=Integer.parseInt(item[1]);
                weight=Double.valueOf(item[2]);
                //w=Double.valueOf(item[2]);
                //sigmoid函数处理
                //weight=Math.pow(Math.E,w)/(1+Math.pow(Math.E,w));
                //System.out.println(source+"\t"+target+"\t"+weight);
                DataBeans dataBeans=new DataBeans(source,target,weight);
                db.add(dataBeans);
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("读取文件失败，请尝试！");
            e.printStackTrace();
        }
    }

    public ArrayList<DataBeans> getDb() {
        return db;
    }

    public void setDb(ArrayList<DataBeans> db) {
        this.db = db;
    }
}
