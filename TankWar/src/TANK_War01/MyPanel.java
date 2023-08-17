package TANK_War01;

import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {
    MyTANK mt = null;

    public MyPanel(){
        mt = new MyTANK(100,100);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0,0,1000,750);//坦克活动区域

        //画出tank
//        g.setColor(Color.blue);
//        g.fill3DRect(100,100,10,60,true);
//        g.fill3DRect(110,110,20,40,true);
//        g.fill3DRect(130,100,10,60,true);
//        g.fillOval(110,120,20,20);
//        g.drawLine(120,130,120,100);

        drawtank(mt.getX(),mt.getY(),g,0,0);//绘制tank

    }
    public void drawtank(int x,int y, Graphics g, int direct,int type){
        switch (type){
            //画我方坦克
            case 0 :
                g.setColor(Color.cyan);
                break;
            //画敌方坦克
            case 1 :
                g.setColor(Color.yellow);
                break;
        }
        switch (direct){
            case 0 : //表示向上
                g.fill3DRect(x,y,10,60,false);
                g.fill3DRect(x+10,y+10,20,40,false);
                g.fill3DRect(x+30,y,10,60,false);
                g.fillOval(x+10,y+20,20,20);
                g.drawLine(x+20,y+30,x+20,y);
                break;
            case 1 :

            case 2 :
            case 3 :
            default:
                System.out.println("暂时没有处理");
        }
    }
}
