package TANK_War04;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;


//为了监听键盘事件，实现KeyListener接口，让MyPanel成为事件监听类

//为了让panit不停的重绘子弹，需要将 MyPanel设置成线程子类Runnable
public class MyPanel extends JPanel implements KeyListener,Runnable {
    MyTANK mt = null;


//创建敌方坦克，用集合存
    Vector<Enemytank> et = new Vector<>();
    int es = 3;
    public MyPanel(){
        //初始化我方坦克
        //在构造器中创建我方坦克并设置speed
        mt = new MyTANK(100,100);
        mt.setSpeed(20);

        //初始化敌方坦克
        //1、在集合中先初始化创建三个敌方坦克
        //2、在paint中画出来三个敌方坦克
        for(int i = 0 ; i < es ; i++){
            Enemytank et1 = new Enemytank((100*(i+1)),0);
            et1.setDirect(2);
            et.add(et1);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0,0,1000,750);//坦克活动区域

        drawtank(mt.getX(),mt.getY(),g,mt.getDirect(),0);//绘制我方tank
//        drawOval(mt.FiringBullets(),mt.getY(),g,mt.getDirect());

        //我方坦克子弹
        if(mt.bullet1 != null  && mt.bullet1.islive) {

            g.fillOval(mt.bullet1.x,mt.bullet1.y,10,10);


        }

        //在paint画敌方坦克
        for(int i = 0 ;i < et.size(); i++){
            Enemytank e = et.get(i);
            drawtank(e.getX(),e.getY(),g,e.getDirect(),1);
        }

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

        //输入J，进入shot，根据坦克方向，确定子弹坐标，启动线程，进入run方法，根据子弹方向，确定坐标变化（也就是X,Y）
        //在paint中画子弹，现在通过mt.bullet1.x,mt.bullet1.y，可以在MyPanel中获取坐标，
        //在用g.fillOval(mt.bullet1.x,mt.bullet1.y,10,10) 画子弹
        //因为只能自动绘制一次
        //所以把MyPanel设置成线程，通过run方法，无限制重绘面板
        if(e.getKeyCode() == KeyEvent.VK_J){
            mt.shot();

        }

        this.repaint();

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    //把Mypane设置成一个线程用于无限重绘便面板
    //为什么不在子弹中加入呢，是因为在做游戏中，不只有画子弹这一种还有无数种，所以重画面板成为最高效的方式
    @Override
    public void run() {
        while (true){
        try{
            Thread.sleep(10);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        this.repaint();
        }
    }



}
