package exception.ArmyCase;

/**
 * 战斗机，是武器，可以移动，可攻击
 */
public class Fighter extends Weapon implements Moveable,Shootable{
    @Override
    public void move() {
        System.out.println("Fighter move");
    }

    @Override
    public void shoot() {
        System.out.println("Fighter shoot");
    }
}
