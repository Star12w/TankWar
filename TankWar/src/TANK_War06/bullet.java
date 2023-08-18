package TANK_War06;

public class bullet implements Runnable{
    int x;
    int y;//记录子弹y坐标
    int direct;
    int speed = 10 ;
   boolean islive = true;

    public bullet(int x, int y, int direct ) {
        this.x = x;
        this.y = y;
        this.direct = direct;

    }

    @Override
    public void run() {
       while(true){

           try {
              Thread.sleep(50);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }

           switch (direct){
               case 0 ://上
                   y -= speed;
                   break;
               case 1 :
                   x += speed;
                   break;
               case 2 :
                   y += speed;
                   break;
               case 3 :
                   x -= speed;
                   break;
           }
           //当销毁和跑出界了，子弹就消失
           //当碰到敌方坦克时也应该结束线程
           if(!((x >= 0 && x<= 1000 && y>=0 && y<= 750) && islive)){
               islive = false;
               break;
           }
       }

    }
}
