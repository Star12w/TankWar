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
        while (true) {
            int direct = (int) (Math.random() * 4);
            switch (direct){
                case 0 : //表示向上
                    setY(getY());
                    setDirect(0);
                case 1 ://表示向右转
                    setX(getX()+1);
                    setDirect(1);
                case 2 ://表示向下转
                    setY(getY()+1);
                    setDirect(2);
                case 3 ://表示向左转
                    setX(getX()-1);
                    setDirect(3);
        }

    }
    }
}
