import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class youareanidiot extends JFrame implements ActionListener {

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public int screenWidth = screenSize.width;
    public int screenHeight = screenSize.height;
    public int moveX = 5;
    public int moveY = 5;
    public int windowWidth = 500;
    public int windowHeight = 500;
    public Timer timer;
    public int colorTimer = 0;
    public int soundTimer = 0;
    public JLabel idiot;
    public int x = 0;
    public int y = 0;

    public youareanidiot() {
        // Initialize the frame.
        super("you are an idiot");
        x = (int) (Math.random() * (screenWidth - windowWidth));
        y = (int) (Math.random() * (screenHeight - windowHeight));
        setLocation(x, y);
        setSize(windowWidth, windowHeight);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        idiot = new JLabel("you are an idiot");
        idiot.setBounds(0, 0, screenWidth, windowWidth);
        idiot.setFont(new Font("Times New Roman", Font.PLAIN, 52));
        idiot.setHorizontalAlignment(JLabel.CENTER);
        add(idiot);

        timer = new Timer(5, this);
        timer.start();

        // System.out.println(screenHeight);
    }

    public void actionPerformed(ActionEvent e) {

        x += moveX;
        y += moveY;
        colorTimer++;

        if (y < 0) {
            y = 0;
            moveY = -moveY;
        } else if (y > (screenHeight - windowHeight)) {
            y = screenHeight - windowHeight;
            moveY = -moveY;
        }

        if (x < 0) {
            x = 0;
            moveX = -moveX;
        } else if (x > (screenWidth - windowWidth)) {
            x = screenWidth - windowWidth;
            moveX = -moveX;
        }

        if (colorTimer == 50) {
            getContentPane().setBackground(Color.BLACK);
            idiot.setForeground(Color.WHITE);
        }

        if (colorTimer == 100) {
            getContentPane().setBackground(Color.WHITE);
            idiot.setForeground(Color.BLACK);
            colorTimer = 0;
        }

        if (soundTimer == 0) {
            try {
                // Open an audio input stream.
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("sound.wav"));

                // Get a clip object.
                Clip clip = AudioSystem.getClip();

                // Open audio clip and load samples from the audio input stream.
                clip.open(audioInputStream);

                // Start playing the sound.
                clip.start();

            } catch (Exception a) {
                a.printStackTrace();
            }
            soundTimer = 310;
        }
        soundTimer--;

        setLocation(x, y);
        // System.out.println(colorTimer);

    }
}
