import java.awt.*;

import javax.sound.sampled.SourceDataLine;
import javax.swing.*;

public class BallGame extends JFrame {

    Image ball = Toolkit.getDefaultToolkit().getImage("images/ball.png");
    Image desk = Toolkit.getDefaultToolkit().getImage("images/desk.png");

    double x = 200;
    double y = 200;

    double degree = 3.14/3; //弧度

    boolean right = true; //控制小球的水平位移方向

    //绘制窗口
    public  void  paint(Graphics g) {
        System.out.println("Window painted once");
        g.drawImage(desk,0,0,null);
        g.drawImage(ball,(int)x,(int)y,null);

        System.out.println("角度："+degree);
        /* if(right){
            x += 10;
        }else{
            x -= 10;

        }

        if(x>786){
            right = false;
        }

        if(x<40){
            right = true;
        } */

        x = x + 10*Math.cos(degree);
        y = y + 10*Math.sin(degree);

        //碰到上下边界
        if(y>(501-30-40)||y<75) {
            degree = -degree;
        }

        //碰到左右边界
        if(x>(856-30-40)||x<40) {
            degree = 3.14-degree;
        }

    }


    //创建窗口
    void  launchFrame(){
        setSize(856,501);
        setLocation(100,100);
        setVisible(true);

        //实现动画，每秒绘制窗口25次
        while(true) {
            repaint();

            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        

    }

    public static void main(String[] args){
        System.out.println("Game Start");

        BallGame  game = new BallGame();
        game.launchFrame();

    }

}
