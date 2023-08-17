package TANK_War06;

public class MyTANK extends TANK {
    bullet bullet1 = null;

    public MyTANK(int x, int y) {

        super(x, y);
    }

    public void shot(){

        switch (getDirect()) {
            case 0:
                bullet1 = new bullet(getX() + 20, getY(), 0);

                break;
            case 1:
                bullet1 = new bullet(getX() + 60, getY() + 20, 1);

                break;
            case 2:
                bullet1 = new bullet(getX() + 20, getY() + 60, 2);

                break;
            case 3:
                bullet1 = new bullet(getX(), getY() + 20, 3);

                break;
        }
        //启动线程
          new Thread(bullet1).start();

    }

}
