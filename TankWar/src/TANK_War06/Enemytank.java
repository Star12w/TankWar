package TANK_War06;

import java.util.Vector;

public class Enemytank extends TANK implements Runnable{
    Vector<bullet>  vb = new Vector<>();

    public Enemytank(int x, int y) {
        super(x, y);
    }

    @Override
    public void run() {
         setSpeed(2);
        while (true) {
            //思路：判断子弹集合vb.size如果 < 10，证明没子弹了，在启动一个子弹就OK
            if(islive && vb.size() < 10){
                bullet b = null;
                switch(getDirect()){
                    case 0 :
                        b = new bullet(getX()+20,getY(),0);
                        break;
                    case 1 :
                        b = new bullet(getX()+60,getY()+20,1);
                        break;
                    case 2 :
                        b = new bullet(getX()+20,getY()+60,2);
                        break;
                    case 3 :
                        b = new bullet(getX(),getY()+20,3);
                        break;
                }
                vb.add(b);
                new Thread(b).start();
            }

            //敌方坦克自由移动
            //首先让坦克在原本方向上走一段路，然后随机取方向
            switch (getDirect()){
                case 0 : //表示向上
                    for (int i = 0 ; i <30 ; i++) {
                        W();
                        try {   //每走一步有50毫秒的延迟
                            Thread.sleep(20);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case 1 ://表示向右转
                    for (int i = 0 ; i <30 ; i++) {
                        D();
                        try {
                            Thread.sleep(20);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case 2 ://表示向下转
                    for (int i = 0 ; i <30 ; i++) {
                        S();
                        try {
                            Thread.sleep(20);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case 3 ://表示向左转
                    for (int i = 0 ; i <30 ; i++) {
                        A();
                        try {
                            Thread.sleep(20);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

            }
            setDirect((int) (Math.random() * 4));//随机取方向，换方向，然后继续循环
            if(!islive){  //判断坦克死了就退出
                break;
            }
        }
    }
}
