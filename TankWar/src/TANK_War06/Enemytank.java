package TANK_War06;

import java.util.Vector;

public class Enemytank extends TANK implements Runnable{
    Vector<bullet>  vb = new Vector<>();
    public  boolean islive = true;
    public Enemytank(int x, int y) {
        super(x, y);
    }

    @Override
    public void run() {
         setSpeed(2);
        while (true) {
            switch (getDirect()){
                case 0 : //表示向上
                    for (int i = 0 ; i <30 ; i++) {
                        W();
                        try {   //每走一步有50毫秒的延迟
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case 1 ://表示向右转
                    for (int i = 0 ; i <30 ; i++) {
                        D();
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case 2 ://表示向下转
                    for (int i = 0 ; i <30 ; i++) {
                        S();
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case 3 ://表示向左转
                    for (int i = 0 ; i <30 ; i++) {
                        A();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

            }
            setDirect((int) (Math.random() * 4));
            if(!islive){
                break;
            }
        }
    }
}
