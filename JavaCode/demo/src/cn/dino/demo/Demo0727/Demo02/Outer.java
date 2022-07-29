package cn.dino.demo.Demo0727.Demo02;

public class Outer {
    private int num = 20;

    /*
    * 内部类的访问特点：
    *   内部类可以直接方位外部类的成员，包括私有的
    *   外部类要方位内部类的成员，必须创建对象
    * */
    private class InnerMember {
        private int name;

        public void show() {
            // 可以访问外部类的 私有成员变量
            System.out.println("我是[成员内部类]的方法\n我可以访问外部类的私有属性：" + num);
        }
    }

    public void useInnerMember() {
        InnerMember innerMember = new InnerMember();
        innerMember.show();
    }


    public void method() {
        class LocalInner {
            private int num2 = 10;

            public void show() {
                System.out.println("我是[局部内部类]的方法\n我可以访问外部类的私有属性：" + num);
            }
        }

        // 实例化局部内部类
        LocalInner localInner = new LocalInner();
        localInner.show();
    }
}
