import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class Az extends JPanel {
    //Here you declare variables that you want to use in the repeating function
    private double b = 1;

    private double c = 1;

    public Az() {
        // Set preferred size for the custom component
        setPreferredSize(new Dimension(600, 600));

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                //This function will be executed periodically
                b += 0.0005;
                c -= 0.0005;
                repaint();
            }
        }, 0, 10); //1000 milliseconds = 1 second
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        //Here you draw and place your main logic

//        for(double i = 0; i < Math.PI*4; i+= Math.PI/2) {
//            g.setColor(Color.RED);
//            for (double a = 0; a < Math.PI * 4; a += Math.PI / 20) {
//                double doubleX = 300 + Math.cos(a + b + i) * a * 25;
//                int x = (int) doubleX;
//                double doubleY = 300 + Math.sin(a + b + i) * a * 25;
//                int y = (int) doubleY;
//                g.fillRect(x, y, 2, 2);
//                g.setColor(Color.BLACK);
//                for (double a2 = 0; a2 < Math.PI * 2; a2 += Math.PI / 40) {
//                    double doubleX2 = doubleX + Math.cos(a2)* 10;
//                    int x2 = (int) doubleX2;
//                    double doubleY2 = doubleY + Math.sin(a2) * 10;
//                    int y2 = (int) doubleY2;
//                    g.fillRect(x2, y2, 1, 1);
//
//                }
//            }
//        }

        Color customColor = new Color(255, 0, 0, 40);
        Color customColor2 = new Color(0, 0, 255, 40);
        Color customColor3 = new Color(0, 255, 0, 40);
        Color customColor4 = new Color(255, 255, 255, 40);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 600, 600);
        for(double a2 = 0; a2 < Math.PI*2; a2+=Math.PI*2/4) {
            g.setColor(customColor);
            for (double a = 0; a < Math.PI * 2; a += Math.PI / 100) {
                double doubleX = 300 + Math.cos(a + Math.PI * 1.5 + a2) * 200;
                int x = (int) doubleX;
                double doubleY = 300 + Math.sin(a + Math.PI * 1.5+a2) * 200;
                int y = (int) doubleY;
                double doubleX2 = 300 + Math.cos(a * b + Math.PI * 1.5 + a2) * 200;
                int x2 = (int) doubleX2;
                double doubleY2 = 300 + Math.sin(a * b + Math.PI * 1.5 + a2) * 200;
                int y2 = (int) doubleY2;
                g.drawLine(x, y, x2, y2);
            }

            g.setColor(customColor2);
            for (double a = 0; a < Math.PI * 2; a += Math.PI / 100) {
                double doubleX = 300 + Math.cos(a + Math.PI * 1.5 + a2) * 200;
                int x = (int) doubleX;
                double doubleY = 300 + Math.sin(a + Math.PI * 1.5 + a2) * 200;
                int y = (int) doubleY;
                double doubleX2 = 300 + Math.cos(a * c + Math.PI * 1.5 + a2) * 200;
                int x2 = (int) doubleX2;
                double doubleY2 = 300 + Math.sin(a * c + Math.PI * 1.5 + a2) * 200;
                int y2 = (int) doubleY2;
                g.drawLine(x, y, x2, y2);
            }

//            g.setColor(customColor3);
//            for (double a = 0; a < Math.PI * 2; a += Math.PI / 50) {
//                double doubleX = 300 + Math.cos(a + Math.PI * 1.2 + a2) * 200;
//                int x = (int) doubleX;
//                double doubleY = 300 + Math.sin(a + Math.PI * 1.2 + a2) * 200;
//                int y = (int) doubleY;
//                double doubleX2 = 300 + Math.cos(a * c + Math.PI * 1.2 + a2) * 200;
//                int x2 = (int) doubleX2;
//                double doubleY2 = 300 + Math.sin(a * c + Math.PI * 1.2 + a2) * 200;
//                int y2 = (int) doubleY2;
//                g.drawLine(x, y, x2, y2);
//            }
        }
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
