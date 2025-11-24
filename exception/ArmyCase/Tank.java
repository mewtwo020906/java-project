package exception.ArmyCase;

/**
 * 坦克是一个武器，可移动，可攻击
 */
public class Tank extends Weapon implements Moveable ,Shootable{

    @Override
    public void move() {
        System.out.println("Tank move");
    }

    @Override
    public void shoot(){
        System.out.println("Tank shoot");
    }
}
