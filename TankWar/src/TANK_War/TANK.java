package TANK_War;

public class TANK {
    private int x;
    private int y;
    private int direct;
    private int speed;
    boolean islive = true;


    public TANK(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //实现tank上右下左移动
    public void W(){
        if(y >0){ this.y -= speed ;}
    }
    public void D(){
        if(x+60<1000){ this.x += speed;}
    }
    public void S(){
        if(y+60<750){this.y += speed;}
    }
    public void A(){
        if(x > 0){this.x -= speed;}
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDirect() { return direct; }

    public void setDirect(int direct) { this.direct = direct; }
    public int getSpeed() { return speed; }

    public void setSpeed(int speed) { this.speed = speed; }
}
