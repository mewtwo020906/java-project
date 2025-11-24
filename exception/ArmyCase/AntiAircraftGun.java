package exception.ArmyCase;

public class AntiAircraftGun extends Weapon implements Shootable{
    @Override
    public void shoot() {
        System.out.println("anti-aircraft gun fire");
    }
}
