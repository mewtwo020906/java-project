package array;

import java.util.Scanner;

/*
为某个酒店编写程序：酒店管理系统，模拟订房、退房、打印所有房间状态等功能。
        1. 该系统的用户是：酒店前台。
        2. 酒店使用一个二维数组来模拟。"Room[][] rooms;"
        3. 酒店中的每一个房间应该是一个java对象:Room
        4. 每一个房间Room应该有：房间编号、房间类型、房间是否空闲
        5. 系统应该对外提供的功能：
            可以预定房间：用户输入房间编号，订房。
            可以退房：用户输入房间编号，退房。
            可以查看所有房间的状态：用户输入某个指令应该可以查看所有房间状态
 */
public class HotelManagement {

    public static void main(String[] args) {
        // 创建酒店对象
        Hotel hotel = new Hotel();
        // 打印房间状态
        //hotel.print();

        while(true){
            // 首先输出一个欢迎页面
            System.out.println("欢迎使用酒店管理系统，请认真阅读以下使用说明：");
            System.out.println("功能编号对应的功能：[1]表示查看房间列表。[2]表示订房。[3]表示退房。[0]表示退出系统");
            Scanner s = new Scanner(System.in);
            int i = s.nextInt();
            if (i == 1) {
                // 查看房间列表
                hotel.print();
            }else if (i == 2) {
                // 订房
                System.out.print("请输入订房编号：");
                int roomNo = s.nextInt();
                hotel.order(roomNo);
            }else if(i == 3) {
                // 退房
                System.out.print("请输入退房编号：");
                int roomNo = s.nextInt();
                hotel.exit(roomNo);
            }else if (i == 0) {
                // 退出系统
                System.out.println("再见，欢迎下次再来！");
                return;
            }else{
                // 出错了！
                System.out.println("输入功能编号有误，请重新输入！");
            }

        }

    }
}

class Room{
    private int roomNo;
    private String roomType;
    private boolean available;

    public Room() {
    }

    public Room(int roomNo, String roomType, boolean available) {
        this.roomNo = roomNo;
        this.roomType = roomType;
        this.available = available;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public boolean getAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String toString(){
        // 动态(把一个变量塞到一个字符串当中，口诀：加一个双引号，双引号中间加两个加号，两个加号中间加变量名。)
        return "["+roomNo+","+roomType+","+(available ? "空闲":"占用")+"]";

    }

    public boolean equals(Object obj){
        if(obj == null || !(obj instanceof Room))return false;
        if(this == obj) return true;
        Room room = (Room)obj;
        // 当前房间编号 等于 传过来的房间对象的房间编号。认为是同一个房间。
        return this.getRoomNo() == room.getRoomNo();
    }
}

// 酒店对象，酒店中有二维数组，二维数组模拟大厦。
class Hotel{
    // 二维数组，模拟大厦所有的房间
    private Room[][] rooms;

    // 盖楼通过构造方法来盖楼。
    public Hotel() {
        // 一共有几层，每层的房间类型是什么，每个房间的编号是什么。
        rooms = new Room[3][10]; // 3行10列。3层楼，每层10个房间。

        // 创建30个Room对象，放到数组当中。
        for(int i = 0; i < rooms.length; i++){
            for(int j = 0;j < rooms[i].length;j++){
                if(i == 0){
                    // 一层
                    rooms[i][j] = new Room((i+1)*100+j+1,"单人间",true);
                }else if(i == 1){
                    // 二层
                    rooms[i][j] = new Room((i+1)*100+j+1,"标准间",true);
                }else if(i == 2){
                    // 三层
                    rooms[i][j] = new Room((i+1)*100+j+1,"总统间",true);
                }
            }
        }
    }

    // 在酒店对象上提供一个打印房间列表的方法
    public void print(){
        for(int i = 0; i < rooms.length; i++){
            for(int j = 0; j < rooms[i].length; j++){
                Room room = rooms[i][j];
                System.out.print(room + " ");
            }
            System.out.println();
        }
    }

    // 订房
    public void order(int roomNo){
        // Room对象的available修改为false。
        Room room = rooms[roomNo / 100 - 1][roomNo % 100 - 1];
        // 修改为占用。
        room.setAvailable(false);
        System.out.println(roomNo + "已订房！");
    }

    // 退房
    public void exit(int roomNo){
        Room room = rooms[roomNo / 100 - 1][roomNo % 100 - 1];
        // 修改为空闲。
        room.setAvailable(true);
        System.out.println(roomNo + "已退房！");
    }


}
