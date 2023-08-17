package TANK_War02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


//为了监听键盘事件，实现KeyListener接口，让MyPanel成为事件监听类
public class MyPanel extends JPanel implements KeyListener {
    MyTANK mt = null;

    public MyPanel(){
        mt = new MyTANK(100,100);
        mt.setSpeed(20);
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

        drawtank(mt.getX(),mt.getY(),g,mt.getDirect(),0);//绘制我方tank

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
            case 1 ://表示向右
                g.fill3DRect(x,y,60,10,false);
                g.fill3DRect(x+10,y+10,40,20,false);
                g.fill3DRect(x,y+30,60,10,false);
                g.fillOval(x+20,y+10,20,20);
                g.drawLine(x+20,y+20,x+60,y+20);
                break;
            case 2 ://表示向下
                g.fill3DRect(x,y,10,60,false);
                g.fill3DRect(x+10,y+10,20,40,false);
                g.fill3DRect(x+30,y,10,60,false);
                g.fillOval(x+10,y+20,20,20);
                g.drawLine(x+20,y+30,x+20,y+60);
                break;
            case 3 ://表示向左
                g.fill3DRect(x,y,60,10,false);
                g.fill3DRect(x+10,y+10,40,20,false);
                g.fill3DRect(x,y+30,60,10,false);
                g.fillOval(x+20,y+10,20,20);
                g.drawLine(x+20,y+20,x,y+20);
                break;
            default:
                System.out.println("暂时没有处理");
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_W){
           //改变坦克方向
            mt.setDirect(0);  //
            mt.W();
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            mt.setDirect(1);
            mt.D();
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            mt.setDirect(2);
            mt.S();
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            mt.setDirect(3);
            mt.A();
        }
        this.repaint();

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
