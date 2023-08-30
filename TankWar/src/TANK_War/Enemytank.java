package TANK_War;

import java.util.Vector;

public class Enemytank extends TANK implements Runnable{
    Vector<bullet>  vb = new Vector<>();
    Vector<Enemytank> ve = new Vector<>();

    public Enemytank(int x, int y) {
        super(x, y);
    }

    //将Mypanel中的敌方坦克集合复制一份放到这里
    public void setVe(Vector<Enemytank> enemytank){
        this.ve = enemytank;
    }

    //判断当前坦克和其他坦克是否发生碰撞
    public boolean isTouchEnemytank() {
        switch (this.getDirect()) {
            case 0://上
                //取出坦克
                for (int i = 0; i < ve.size(); i++) {
                    Enemytank e = ve.get(i);
                    if (e != this) {
                        //如果敌人坦克是上/下
                        if (e.getDirect() == 0 || e.getDirect() == 2) {
                            //这是坦克的左上角
                            if (this.getX() >= e.getX()
                                    && this.getX() <= e.getX() + 40
                                    && this.getY() >= e.getY()
                                    && this.getY() <= e.getY() + 60) {
                                return true;
                            }
                            //这是坦克的右上角
                            if (this.getX() + 40 >= e.getX()
                                    && this.getX() + 40 <= e.getX() + 40
                                    && this.getY() >= e.getY()
                                    && this.getY() <= e.getY() + 60) {
                                return true;
                            }
                        }
                        //如果敌人坦克是左/右
                        if (e.getDirect() == 1 || e.getDirect() == 3) {
                            //这是坦克的左上角
                            if (this.getX() >= e.getX()
                                    && this.getX() <= e.getX() + 60
                                    && this.getY() >= e.getY()
                                    && this.getY() <= e.getY() + 40) {
                                return true;
                            }
                            //这是坦克的右上角
                            if (this.getX() + 40 >= e.getX()
                                    && this.getX() + 40 <= e.getX() + 60
                                    && this.getY() >= e.getY()
                                    && this.getY() <= e.getY() + 40) {
                                return true;
                            }
                        }
                    }
                }
                break;
            case 1://右
                //取出坦克
                for (int i = 0; i < ve.size(); i++) {
                    Enemytank e = ve.get(i);
                    if (e != this) {
                        //如果敌人坦克是上/下
                        if (e.getDirect() == 0 || e.getDirect() == 2) {
                            //这是坦克的右上角
                            if (this.getX() + 60 >= e.getX()
                                    && this.getX() + 60 <= e.getX() + 40
                                    && this.getY() >= e.getY()
                                    && this.getY() <= e.getY() + 60) {
                                return true;
                            }
                            //这是坦克的右下角
                            if (this.getX() + 60 >= e.getX()
                                    && this.getX() + 60 <= e.getX() + 40
                                    && this.getY() + 40 >= e.getY()
                                    && this.getY() + 40 <= e.getY() + 60) {
                                return true;
                            }
                        }
                        //如果敌人坦克是左/右
                        if (e.getDirect() == 1 || e.getDirect() == 3) {
                            //这是坦克的右上角
                            if (this.getX() + 60 >= e.getX()
                                    && this.getX() + 60 <= e.getX() + 60
                                    && this.getY()>= e.getY()
                                    && this.getY()<= e.getY() + 40) {
                                return true;
                            }
                            //这是坦克的右下角
                            if (this.getX() + 60 >= e.getX()
                                    && this.getX() + 60 <= e.getX() + 60
                                    && this.getY() + 40 >= e.getY()
                                    && this.getY() + 40 <= e.getY() + 40) {
                                return true;
                            }
                        }
                    }
                }
                break;
            case 2://下
                //取出坦克
                for (int i = 0; i < ve.size(); i++) {
                    Enemytank e = ve.get(i);
                    if (e != this) {
                        //如果敌人坦克是上/下
                        if (e.getDirect() == 0 || e.getDirect() == 2) {
                            //这是坦克的左下角
                            if (this.getX() >= e.getX()
                                    && this.getX() <= e.getX() + 40
                                    && this.getY() + 60 >= e.getY()
                                    && this.getY() + 60 <= e.getY() + 60) {
                                return true;
                            }
                            //这是坦克的右下角
                            if (this.getX() + 40 >= e.getX()
                                    && this.getX() + 40 <= e.getX() + 40
                                    && this.getY() + 60 >= e.getY()
                                    && this.getY() + 60 <= e.getY() + 60) {
                                return true;
                            }
                        }
                        //如果敌人坦克是左/右
                        if (e.getDirect() == 1 || e.getDirect() == 3) {
                            //这是坦克的左下角
                            if (this.getX() >= e.getX()
                                    && this.getX() <= e.getX() + 60
                                    && this.getY() + 60 >= e.getY()
                                    && this.getY() + 60 <= e.getY() + 40) {
                                return true;
                            }
                            //这是坦克的右下角
                            if (this.getX() + 40 >= e.getX()
                                    && this.getX() + 40 <= e.getX() + 60
                                    && this.getY() + 60 >= e.getY()
                                    && this.getY() + 60 <= e.getY() + 40) {
                                return true;
                            }
                        }
                    }
                }
                break;
            case 3://左 //取出坦克
                for (int i = 0; i < ve.size(); i++) {
                    Enemytank e = ve.get(i);
                    if (e != this) {
                        //如果敌人坦克是上/下
                        if (e.getDirect() == 0 || e.getDirect() == 2) {
                            //这是坦克的左上角
                            if (this.getX() >= e.getX()
                                    && this.getX() <= e.getX() + 40
                                    && this.getY() >= e.getY()
                                    && this.getY() <= e.getY() + 60) {
                                return true;
                            }
                            //这是坦克的左下角
                            if (this.getX()  >= e.getX()
                                    && this.getX()  <= e.getX() + 40
                                    && this.getY() + 40 >= e.getY()
                                    && this.getY() + 40 <= e.getY() + 60) {
                                return true;
                            }
                        }
                        //如果敌人坦克是左/右
                        if (e.getDirect() == 1 || e.getDirect() == 3) {
                            //这是坦克的左上角
                            if (this.getX() >= e.getX()
                                    && this.getX() <= e.getX() + 60
                                    && this.getY() >= e.getY()
                                    && this.getY() <= e.getY() + 40) {
                                return true;
                            }
                            //这是坦克的右上角
                            if (this.getX()  >= e.getX()
                                    && this.getX() <= e.getX() + 60
                                    && this.getY() + 40 >= e.getY()
                                    && this.getY() +  40 <= e.getY() + 40) {
                                return true;
                            }
                        }
                    }
                }
                break;
        }
        return false;
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
                        if (getY() > 0 && !isTouchEnemytank()){
                            W();
                        }
                        try {   //每走一步有50毫秒的延迟
                            Thread.sleep(20);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case 1 ://表示向右转
                    for (int i = 0 ; i <30 ; i++) {
                        if (getX() + 60 < 1000 && !isTouchEnemytank()){
                            D();
                        }
                        try {
                            Thread.sleep(20);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case 2 ://表示向下转
                    for (int i = 0 ; i <30 ; i++) {
                        if(getY() + 60 < 750 && !isTouchEnemytank() ){
                            S();
                        }
                        try {
                            Thread.sleep(20);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case 3 ://表示向左转
                    for (int i = 0 ; i <30 ; i++) {
                        if(getX() > 0 && !isTouchEnemytank()){
                            A();
                        }
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
