package cn.dino.demo.Demo0728.pojo;

public class Teacher {
    public void checkScore(int score) throws ScoreException {
        if (score < 0 || score > 100) {
            throw new ScoreException("分数有误，分数范围应在0~100!");
        } else {
            System.out.println("成绩正常！");
        }
    }
}
