import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.net.URL;

public class Game extends JFrame implements ActionListener {
    private JButton button1, button2, button3;
    private JLabel label1;

    public static void main(String[] asd) {
        new Game();
    }

    public Game() {
        this.setSize(800, 500);
        this.setTitle("Word Scramble Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        // Set the background image
        URL backgroundUrl = getClass().getResource("background.gif");
        ImageIcon backgroundIcon = new ImageIcon(backgroundUrl);
        JLabel backgroundLabel = new JLabel(backgroundIcon);
        this.setContentPane(backgroundLabel);
        this.setLayout(new BorderLayout());

        // Load Menubackground image
        URL menuBackgroundUrl = getClass().getResource("Menubackground.png");
        ImageIcon menuBackgroundIcon = new ImageIcon(menuBackgroundUrl);
        JLabel menuBackgroundLabel = new JLabel(menuBackgroundIcon);

        // Set layout manager to null to manually position components
        menuBackgroundLabel.setLayout(null);

        // Load Play button image for button1
        URL playButtonUrl = getClass().getResource("Playbutton.png");
        ImageIcon playIcon = new ImageIcon(playButtonUrl);
        button1 = new JButton(playIcon);
        button1.setBounds(180, 120, playIcon.getIconWidth(), playIcon.getIconHeight());
        button1.setBorderPainted(false);
        button1.setContentAreaFilled(false);
        button1.setFocusPainted(false);
        button1.setOpaque(false);

        // Load Credit button image for button2
        URL creditButtonUrl = getClass().getResource("Creditbutton.png");
        ImageIcon creditIcon = new ImageIcon(creditButtonUrl);
        button2 = new JButton(creditIcon);
        button2.setBounds(180, 280, creditIcon.getIconWidth(), creditIcon.getIconHeight());
        button2.setBorderPainted(false);
        button2.setContentAreaFilled(false);
        button2.setFocusPainted(false);
        button2.setOpaque(false);

        // Load Quit button image for button3
        URL quitButtonUrl = getClass().getResource("Quitbutton.png");
        ImageIcon quitIcon = new ImageIcon(quitButtonUrl);
        button3 = new JButton(quitIcon);
        button3.setBounds(180, 200, quitIcon.getIconWidth(), quitIcon.getIconHeight());
        button3.setBorderPainted(false);
        button3.setContentAreaFilled(false);
        button3.setFocusPainted(false);
        button3.setOpaque(false);

        menuBackgroundLabel.add(button1);
        menuBackgroundLabel.add(button2);
        menuBackgroundLabel.add(button3);

        // Load Title.png and add it to the left side
        URL titleUrl = getClass().getResource("Title.png");
        ImageIcon titleIcon = new ImageIcon(titleUrl);
        JLabel titleLabel = new JLabel(titleIcon);
        // Adjusted position of the title
        titleLabel.setBounds(100, 50, titleIcon.getIconWidth(), titleIcon.getIconHeight());
        this.add(titleLabel, BorderLayout.WEST);
        this.add(menuBackgroundLabel, BorderLayout.CENTER);

        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);

        this.setResizable(false);
        this.setVisible(true);
    }
	
    public void actionPerformed(ActionEvent event)
    {
        if(event.getSource() == button3)
        {
            System.exit(0);
        }
        else if(event.getSource() == button2)
        {
            Help ob = new Help();
            this.setVisible(false);
        }
        else if(event.getSource() == button1)
        {
            Level ob1 = new Level();
            this.setVisible(false);
        }
    }
}

class Help extends JFrame implements ActionListener
{
    public static void main(String[] asd) throws Exception
    {
        new Help();
    }
    private JButton button;
    
    public Help()
    {
        this.setSize(500,300);
        this.setTitle("Help");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel panel = new JPanel();
        button = new JButton("   OK   ");
        panel.add(new JLabel("                                       Help                                       "));
        panel.add(new JLabel("You will get a word, present in the Oxford Dictionary, whose letters are dearranged."));
        panel.add(new JLabel("You have to arrange those letters to form a word which is in the Oxford Dictionary."));
        panel.add(new JLabel("You can guess the word three times before the answer is displayed."));
        panel.add(new JLabel("The first alphabet of the word is given in Capital."));
        panel.add(new JLabel(" There are two levels in the game - novice and genius."));
        panel.add(new JLabel(" Novice  :  In this level you will get small words."));
        panel.add(new JLabel("                                    Genius  :  In this level you will get long words.                    "));
        panel.add(button);
        this.add(panel);
        button.addActionListener(this);
        this.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent event)
    {
        if(event.getSource() == button)
        {
            this.setVisible(false);
            Game ob = new Game();
        }
    }
}