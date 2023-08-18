package TANK_War06;

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
    Vector<Enemytank> et = new Vector<>(); // 敌方坦克集合
    Vector<Bomb>  VB = new Vector<>();//敌方坦克爆炸集合
    //爆炸图片对象三个
    Image image1 = null;
    Image image2 = null;
    Image image3 = null;
    int es = 3;//坦克数量
    public MyPanel(){
        //初始化我方坦克
        //在构造器中创建我方坦克并设置speed
        mt = new MyTANK(100,100);
        mt.setSpeed(10);

        //初始化敌方坦克
        //1、在集合中先初始化创建三个敌方坦克
        //2、在paint中画出来三个敌方坦克
        for(int i = 0 ; i < es ; i++){
            Enemytank et1 = new Enemytank((200*(i+1)),0);
            et1.setDirect(2);
            new Thread(et1).start();
            //每个坦克添加子弹 并启动线程
            bullet bullet = new bullet(et1.getX()+20,et1.getY()+60,et1.getDirect());

            //为了画出子弹，把子弹存入集合中  并启动
            et1.vb.add(bullet);
            new Thread(bullet).start();
           //加入
            et.add(et1);
        }
        //初始化爆炸图片对象
        image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_1.png"));
        image2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_2.png"));
        image3 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_3.png"));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);//坦克活动区域

        //我方坦克 和  子弹
       if(mt.islive) {
           drawtank(mt.getX(), mt.getY(), g, mt.getDirect(), 0);//绘制我方tank
           //绘制我方坦克子弹，遍历集合中的子弹
           for (int i = 0; i < mt.bullet.size(); i++) {
               bullet shot = mt.bullet.get(i);
               if (shot != null && shot.islive) {
                   g.fillOval(mt.bullet.get(i).x, mt.bullet.get(i).y, 10, 10);
               } else {
                   mt.bullet.remove(shot);
               }
           }
       }

        //敌方坦克 和  子弹
        for (int i = 0; i < et.size(); i++) {
            //取出坦克
            Enemytank e = et.get(i);
            if (e.islive) {
                drawtank(e.getX(), e.getY(), g, e.getDirect(), 1);
                for (int j = 0; j < e.vb.size(); j++) {
                    //取出子弹
                    bullet b = e.vb.get(j);
                    //绘制子弹
                    if (b.islive) {
                        g.setColor(Color.yellow);
                        g.fillOval(b.x, b.y, 10, 10);
                    } else {
                        //从Vector中删除
                        e.vb.remove(b);
                    }
                }
            }
        }

        //坦克被击毁后，产生爆炸
        for (int i = 0; i < VB.size(); i++) {
            Bomb bo = VB.get(i);
            if (bo.life > 6) {
                g.drawImage(image1, bo.x, bo.y, 60, 60, this);
            } else if (bo.life > 3) {
                g.drawImage(image2, bo.x, bo.y, 60, 60, this);
            } else {
                g.drawImage(image3, bo.x, bo.y, 60, 60, this);
            }
            bo.lifeDown();
            //当life为0 时，则在bo集合中删除
            if (bo.life == 0) {
                VB.remove(bo);
            }
        }
    }


    //判断我方子弹是否击中敌方坦克
    public  void hitTank(bullet b, TANK e){
        switch (e.getDirect()){
            case 0 ://0和2合并
            case 2 :
                if( b.x > e.getX() && b.x < e.getX()+ 40 && b.y > e.getY() &&b.y < e.getY()+60){
                    b.islive = false;
                    e.islive = false;
                    //当子弹击中坦克，产生爆炸效果
                    Bomb bomb = new Bomb (e.getX(), e.getY());
                    VB.add(bomb);
                    //当子弹击中坦克,集合删除坦克
                    et.remove(e);
                }
                break;
            case 1 :
            case 3 :
                if(b.x > e.getX() && b.x < e.getX()+ 60 && b.y > e.getY() &&b.y < e.getY()+40){
                    b.islive = false;
                    e.islive = false;
                    //当子弹击中坦克，产生爆炸效果
                    Bomb bomb = new Bomb (e.getX(), e.getY());
                    VB.add(bomb);
                    //当子弹击中坦克,集合删除坦克
                    et.remove(e);

                }
                break;

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

    //在run方法中判断是否被击中
    @Override
    public void run() {
        while (true){
        try{
            Thread.sleep(10);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        //先遍历我方坦克发出的子弹并判断是否存活
        //若存活，在遍历敌方坦克 ，并调用hittank看是否击中
        for(int i = 0 ; i< mt.bullet.size();i++){
            bullet shot = mt.bullet.get(i);
            if( shot != null && shot.islive){

                for(int j = 0; j < et.size();j++){
                    Enemytank e = et.get(j);
                    hitTank(shot, e);
                }
            }else {
                mt.bullet.remove(shot);
            }
        }
        //遍历敌方子弹是否击中我方坦克

            for(int i = 0; i < et.size();i++){
                Enemytank e = et.get(i);
                for(int j = 0 ; j<e.vb.size();j++){
                    bullet b = e.vb.get(j);
                    if(b != null && b.islive ){
                        hitTank(b,mt);
                    }
                }
            }

        this.repaint();
        }
    }



}
