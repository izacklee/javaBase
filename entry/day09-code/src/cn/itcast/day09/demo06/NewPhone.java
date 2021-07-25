package cn.itcast.day09.demo06;

// 新款手机
public class NewPhone extends Phone {

    @Override
    public void show() {
        // 把父类的show方法拿过来重复利用
        super.show();
        // 自己的类再添加更多的内容
        System.out.println("显示姓名");
        System.out.println("显示头像");
    }
}
