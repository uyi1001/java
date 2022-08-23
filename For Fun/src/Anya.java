import java.awt.*;
import javax.swing.*;

public class Anya extends JFrame {

    Image daughter = Toolkit.getDefaultToolkit().getImage("images/Anya.png");
    Image background = Toolkit.getDefaultToolkit().getImage("images/SpyFamily.png");

    double x = 0;
    double y = 0;

    double degree = 3.14/4; //弧度

    //绘制窗口
    public  void  paint(Graphics g) {
        g.drawImage(background,0,30,null);
        g.drawImage(daughter,(int)x,(int)y,null);

        x = x + 10*Math.cos(degree);
        y = y + 10*Math.sin(degree);

        //碰到上下边界
        if(y>(670-108)||y<0) {
            degree = -degree;
        }

        //碰到左右边界
        if(x>(800-150)||x<0) {
            degree = 3.14-degree;
        }

    }


    //创建窗口
    void  launchFrame(){
        setSize(800,670);
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

        Anya  flyer = new Anya();
        flyer.launchFrame();

    }

}
