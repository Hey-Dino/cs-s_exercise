package cn.dino.demo.Demo0727.Demo01;

import cn.dino.demo.Demo0727.Demo01.pojo.Cat;
import cn.dino.demo.Demo0727.Demo01.pojo.Jumping;

/*
 * 接口为参数和返回值
 * */
public class JumpingOperator {
    public void useJumping(Jumping jumping) {
        jumping.jump();
    }

    public Jumping getJumping() {
        Jumping jumping = new Cat();
        return jumping;
    }

}
