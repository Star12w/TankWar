package TANK_War;

import java.util.Vector;

public class MyTANK extends TANK {
    Vector<bullet> bullet = new Vector<>();
    public MyTANK(int x, int y) {

        super(x, y);
    }

    public void shot(){
        //思路：根据输入J的数据来决定创建几个子弹（线程）
        //用集合来存多个子弹
        if(bullet.size() == 5){ return;}
            switch (getDirect()) {
                case 0:
                    bullet.add(new bullet(getX() + 20, getY(), 0));

                    break;
                case 1:
                    bullet.add(new bullet(getX() + 60, getY() + 20, 1));

                    break;
                case 2:
                    bullet.add(new bullet(getX() + 20, getY() + 60, 2));

                    break;
                case 3:
                    bullet.add(new bullet(getX(), getY() + 20, 3));

                    break;
            }

        //用Vector中的对象来启动线程，一个对象（子弹）代表一个线程
        for (TANK_War.bullet bullet1 : bullet) {
            new Thread(bullet1).start();
        }



    }

}
