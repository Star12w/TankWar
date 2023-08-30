package TANK_War;

public class Bomb {
    int x;
    int y;
    int life = 9 ;
    boolean islive = true;

    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void lifeDown(){
        if(life > 0){
            life--;
        }else { islive = false; }
    }
}
