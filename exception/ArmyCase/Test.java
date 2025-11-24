package exception.ArmyCase;

public class Test {
    public static void main(String[] args) {
        // 构建一个军队
        Army army = new Army(4); // 军队只有4个武器。
        // 创建武器对象
        Fighter fighter = new Fighter();
        Fighter fighter2 = new Fighter();
        Tank tank = new Tank();
        CargoAircraft cargoAircraft = new CargoAircraft();
        AntiAircraftGun antiAircraftGun = new AntiAircraftGun();

        // 添加武器
        try{
        army.addWeapon(fighter);
        army.addWeapon(tank);
        army.addWeapon(cargoAircraft);
        army.addWeapon(antiAircraftGun);
        army.addWeapon(fighter2);
        }catch(AddWeaponException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        // 让所有可移动的移动
        army.moveAll();

        // 让所有可攻击的攻击
        army.attackAll();
    }
}
