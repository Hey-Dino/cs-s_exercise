package cn.dino.demo.Demo0806.Demo03_1;

public class Desk {
    /*
     * 此是对Demo03的优化
     * */
    private boolean flag;
    private int count;
    private final Object lock = new Object();

    public Desk() {
        this(false, 10);
    }

    public Desk(boolean flag, int count) {
        this.flag = flag;
        this.count = count;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Object getLock() {
        return lock;
    }
}
