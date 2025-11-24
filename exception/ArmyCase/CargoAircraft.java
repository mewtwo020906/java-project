package exception.ArmyCase;

/**
 * 物资运输飞机，是武器，但是只能移动，不能攻击
 */
public class CargoAircraft extends Weapon implements Moveable{
    @Override
    public void move() {
        System.out.println("Cargo aircraft move");
    }
}
