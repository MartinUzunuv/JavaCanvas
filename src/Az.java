import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

public class Az extends JPanel {
    private double b = 1;
    private double c = 1;

    private double speed = 0.0005;

    private boolean going = true;

    public Az() {
        setPreferredSize(new Dimension(600, 600));

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if(going){
                    b += speed;
                    c -= speed;
                }
                repaint();
            }
        }, 0, 10);

        // Create a button
        JButton button = new JButton("⏸");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle the button click event here
//                JOptionPane.showMessageDialog(null, "Button Clicked!");
                going = !going;
                button.setText(going ? "⏸" : "▶");
            }
        });

        // Add the button to the panel
        add(button);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        //Here you draw and place your main logic

        Color customColor = new Color(255, 0, 0, 40);
        Color customColor2 = new Color(0, 0, 255, 40);
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