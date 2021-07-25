package cn.itcast.day11.demo07;

public class DemoGame {

    public static void main(String[] args) {
        // 创建一个英雄
        Hero hero = new Hero();
        // 设置名字
        hero.setName("艾希");

//        // 创建一个接口实现类的技能对象
//        SkillImpl skill = new SkillImpl();  // 使用单独定义的实现类
//
//        // 给英雄配置技能
//        hero.setSkill(skill);

        // 使用匿名内部类
//        Skill skill = new Skill() {
//
//            @Override
//            public void use() {
//                System.out.println("biu~pia~biu~pia~");
//            }
//
//        };
//
//        hero.setSkill(skill);

        // 进一步优化，同时使用匿名内部类，匿名对象
        hero.setSkill(new Skill() {
            @Override
            public void use() {
                System.out.println("biu~biu~pia~");
            }
        });

        // 使用技能
        hero.attack();


    }

}
