package dcm.Lab;

import java.io.*;
import java.util.*;

public class ResolveCsv {

    public static void main(String[]args) throws IOException {
        String geturl;
        Integer source,target;
        double weight;
        ArrayList<DataBeans> file1 ;
        List<DataVertex> V1;
        ArrayList<DataBeans> file2 ;
        List<DataVertex> V2;
        ArrayList<DataBeans> file3 = new ArrayList<DataBeans>();//存储最终结果
        Scanner scanner=new Scanner(System.in);

        System.out.println("请输入边Edge1文件的路径:");
        geturl=scanner.nextLine();
        ReadEdgeCsv readEdgeCsv1 =new ReadEdgeCsv();
        //读取数据并生成对象
        readEdgeCsv1.readFile(geturl);
        //返回数据对象的集合ArrayList
        file1= readEdgeCsv1.getDb();

        System.out.println("请输入顶点Vertex1文件的路径：");
        geturl=scanner.nextLine();
        ReadVertexCsv readVertexCsv1=new ReadVertexCsv();
        //读取数据生成对象
        readVertexCsv1.readFile(geturl);
        V1=readVertexCsv1.getVertexList();


        //对file1的weight进行权重处理
        for(DataBeans db:file1)
        {
            double w=db.getWeight();
            weight=Math.pow(Math.E,w)/(1+Math.pow(Math.E,w));
            db.setWeight(weight);
        }


        System.out.println("请输入文件2的路径:");
        geturl=scanner.nextLine();
        ReadEdgeCsv readEdgeCsv2 =new ReadEdgeCsv();
        //读取数据并生成对象
        readEdgeCsv2.readFile(geturl);
        //返回数据对象的集合ArrayList
        file2= readEdgeCsv2.getDb();

        System.out.println("请输入顶点Vertex1文件的路径：");
        geturl=scanner.nextLine();
        ReadVertexCsv readVertexCsv2=new ReadVertexCsv();
        //读取数据生成对象
        readVertexCsv2.readFile(geturl);
        V2=readVertexCsv2.getVertexList();


        //对file2的weight进行权重处理
        for(DataBeans db:file2)
        {
            double w=db.getWeight();
            weight=Math.pow(Math.E,w)/(1+Math.pow(Math.E,w));
            db.setWeight(weight);
        }

        //指定α的值或者通过计算可以确定
        double a=0.3;
        //flag标志是否在另一个文件中找到
        boolean flag;

        //对file1文件处理
        for (DataBeans db1:file1)
        {
            flag=false;
            source=db1.getSource();
            target=db1.getTarget();
            weight=db1.getWeight();

            for(DataBeans db2:file2)
            {
                if(source.equals(db2.getSource())&&target.equals(db2.getTarget()))
                {
                    flag=true;
                    weight=weight*a+(1-a)*db2.getWeight();
                    break;
                }

            }
            if(!flag)
            {
                weight=weight*a;
            }
            file3.add(new DataBeans(source,target,weight));
        }

        //对file2文件处理
        for (DataBeans db2:file2)
        {
            flag=false;
            source=db2.getSource();
            target=db2.getTarget();
            weight=db2.getWeight();

            for(DataBeans db1:file1)
            {
                if(source.equals(db1.getSource())&&target.equals(db1.getTarget()))
                {
                    flag=true;
                    break;
                }
            }
            if(!flag)
            {
                weight=(1-a)*weight;
                file3.add(new DataBeans(source,target,weight));
            }
        }


        //输出到文件中保存
        //文件保存路径
        System.out.println("文件保存路径为:");
        geturl=scanner.nextLine();
        File file=new File(geturl);
        try
        {
            BufferedWriter bw=new BufferedWriter(new FileWriter(file,true));
            bw.write("Source"+","+"Target"+","+"Weight");
            bw.newLine();
            for(DataBeans db:file3)
            {
                source=db.getSource();
                target=db.getTarget();
                weight=db.getWeight();
                bw.write(source+","+target+","+weight);
                bw.newLine();
            }
            bw.close();
        }catch(IOException e)
        {
            System.out.println("文件写入异常，请尝试！");
            e.printStackTrace();
        }

        //关闭输入流
        scanner.close();
    }

}

