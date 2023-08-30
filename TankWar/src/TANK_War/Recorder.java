package TANK_War;

import java.io.*;
import java.util.Vector;

//该类用于记录相关信息，和文件交互
public class Recorder {
    //定义变量，记录我方击毁敌人坦克数
    private static int allEnemyTankNum = 0;
    private static BufferedReader br = null;
    //定义IO对象,准备写数据到文件中
    private static BufferedWriter bw = null;
    private static final String fileName = "E:\\note.txt";
    //定义一个Node 的Vector ，用于保存敌人坦克信息
    private static final Vector<Node> nodes = new Vector<>();
    //从Mypanel中获取敌方坦克集合
    private static Vector<Enemytank> enemytanks = null;

    public static void setEnemytanks(Vector<Enemytank> enemytanks) {
        Recorder.enemytanks = enemytanks;
    }

    //增加方法，用于恢复信息
    public static Vector<Node> getNodesAndNum(){
        try {
            br = new BufferedReader(new FileReader(fileName));
            allEnemyTankNum = Integer.parseInt(br.readLine());
            String line = "";
            while((line = br.readLine()) != null){
                String[] xyd = line.split(" ");
                Node node= new Node(Integer.parseInt(xyd[0]),Integer.parseInt(xyd[1]),Integer.parseInt(xyd[2]));
                nodes.add(node);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return nodes;
    }
    public static int getAllEnemyTankNum() {
        return allEnemyTankNum;
    }

    public static void setAllEnemyTankNum(int allEnemyTankNum) {
        Recorder.allEnemyTankNum = allEnemyTankNum;
    }

    //当我方坦克击毁一个敌人坦克，就应当allEnemyTankNum+1
    public static void addallEnemyTankNum(){
        Recorder.allEnemyTankNum ++;
    }

    //增加一个方法，当游戏退出时，我们将allEnemyTankNum 保存到 RecordFile中
    //升级，保存敌人坦克坐标和方向
    public static void keepallEnemyTankNum(){
        try {
            bw = new BufferedWriter(new FileWriter(fileName));
            bw.write(allEnemyTankNum + "\r\n");
            //遍历敌人坦克的Vector
            for(int i = 0 ; i < enemytanks.size() ; i++){
                Enemytank e = enemytanks.get(i);
                if(e.islive){
                    //保存该enemytank的信息
                    String record = e.getX() + " " + e.getY() + " " + e.getDirect();
                    bw.write(record + "\r\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
