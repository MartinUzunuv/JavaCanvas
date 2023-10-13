import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class Az extends JPanel {

    int windowWidth = 600;
    int windowHeight = 600;
    int periodMS = 10;

    //Here you declare variables that you want to use in the repeating function

    //-------------------------------------------------------------------------------->
    //📃 DECLARE VARIABLES HERE------------------------------------------------------->

    double x = 10;
    double y = 200;
    double xSpeed = 1.5;
    double ySpeed = 1.5;
    Color color = new Color(100,20,150,200);

    //END DECLARE VARIABLES HERE------------------------------------------------------>
    //-------------------------------------------------------------------------------->

    public Az() {
        // Set preferred size for the custom component
        setPreferredSize(new Dimension(windowWidth, windowHeight));

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                //This function will be executed periodically

                //----------------------------------------------------------------------------->
                //🔁 REPEATING FUNCTION-------------------------------------------------------->

                if(x < 0){
                    xSpeed = 1.5;
                    color = Color.BLUE;
                }
                if(y < 0){
                    ySpeed = 1.5;
                    color = Color.RED;
                }
                if(x+50 > 600){
                    xSpeed = -1.5;
                    color = Color.GREEN;
                }
                if(y+50 > 600){
                    ySpeed = -1.5;
                    color = Color.BLACK;
                }

                x+=xSpeed;
                y+=ySpeed;

                //END REPEATING FUNCTION------------------------------------------------------->
                //----------------------------------------------------------------------------->

                repaint();
            }
        }, 0, periodMS); //1000 milliseconds = 1 second
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        //Here you draw and place your main logic

        //-------------------------------------------------------------------------------->
        //🧠🎨 DRAW AND WRITE MAIN LOGIC HERE--------------------------------------------->

        g.setColor(color);
        int xToInt = (int) x;
        int yToInt = (int) y;
        g.fillRect(xToInt,yToInt,50,50);

        //END DRAW AND WRITE MAIN LOGIC HERE---------------------------------------------->
        //-------------------------------------------------------------------------------->

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Az");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new Az()); // Add the custom component
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
