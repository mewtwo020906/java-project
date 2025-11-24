package exception.ArmyCase;

/**
 * 军队
 */
public class Army {
    /**
     * 武器数组
     */
    private Weapon[] weapons;

    /**
     * 创建军队的构造方法。
     * @param count 武器数量
     */
    public Army(int count){
        // 动态初始化数组中每一个元素默认值是null。
        // 武器数组是有了，但是武器数组中没有放武器。
        weapons = new Weapon[count];
    }

    /**
     * 将武器加入数组
     * @param weapon
     */
    public void addWeapon(Weapon weapon) throws AddWeaponException {
        for(int i=0;i<weapons.length;i++){
            if( weapons[i] == null){
                // 把武器添加到空的位置上。
                weapons[i] = weapon;
                System.out.println(weapon.toString() + "： 武器添加成功");
                return;
            }
        }
        // 程序如果执行到此处说明，武器没有添加成功
        throw new AddWeaponException("武器数量已达到上限！");
    }

    /**
     * 所有可攻击的武器攻击。
     */
    public void attackAll(){
        // 遍历数组
        for(int i=0;i<weapons.length;i++){
            if(weapons[i] instanceof Shootable){
                // 调用子类中特有的方法，向下转型。
                Shootable shootable = (Shootable) weapons[i];
                shootable.shoot();
            }
        }
    }

    /**
     * 所有可移动的武器移动
     */
    public void moveAll(){
         // 遍历数组
            for(int i=0;i<weapons.length;i++){
                if(weapons[i] instanceof Moveable){
                    // 调用子类中特有的方法，向下转型。
                    Moveable moveable = (Moveable) weapons[i];
                    moveable.move();
                }
            }
    }

}
