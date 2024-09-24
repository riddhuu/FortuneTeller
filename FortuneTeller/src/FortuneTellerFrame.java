import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {

    private JTextArea fortuneDisplay;
    private ArrayList<String> fortunes;
    private int lastFortuneIndex = -1;
    private Random random = new Random();

    public FortuneTellerFrame() {
        setTitle("Fortune Teller");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Top panel
        JPanel topPanel = new JPanel();
        JLabel titleLabel = new JLabel("Fortune Teller", new ImageIcon("FortuneTeller.jpeg"), JLabel.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 36));
        titleLabel.setVerticalTextPosition(JLabel.BOTTOM);
        titleLabel.setHorizontalTextPosition(JLabel.CENTER);
        topPanel.add(titleLabel);
        add(topPanel, BorderLayout.NORTH);

        // Middle panel
        fortuneDisplay = new JTextArea(10, 30);
        fortuneDisplay.setFont(new Font("SansSerif", Font.PLAIN, 14));
        fortuneDisplay.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(fortuneDisplay);
        add(scrollPane, BorderLayout.CENTER);

        // Bottom panel
        JPanel bottomPanel = new JPanel();
        JButton fortuneButton = new JButton("Read My Fortune!");
        JButton quitButton = new JButton("Quit");
        Font buttonFont = new Font("SansSerif", Font.BOLD, 14);
        fortuneButton.setFont(buttonFont);
        quitButton.setFont(buttonFont);
        bottomPanel.add(fortuneButton);
        bottomPanel.add(quitButton);
        add(bottomPanel, BorderLayout.SOUTH);

        // Initialize fortunes
        fortunes = new ArrayList<>();
        fortunes.add("You will find unexpected joy today.");
        fortunes.add("A pleasant surprise is waiting for you.");
        fortunes.add("Your creativity will lead to great success.");
        fortunes.add("An old friend will bring exciting news.");
        fortunes.add("Your hard work will soon pay off.");
        fortunes.add("A journey of a thousand miles begins with a single step.");
        fortunes.add("Your kindness will be rewarded tenfold.");
        fortunes.add("Good fortune will be yours.");
        fortunes.add("A smile is your passport into the hearts of others.");
        fortunes.add("Your talents will be recognized and suitably rewarded.");
        fortunes.add("A thrilling time is in your near future.");
        fortunes.add("Your life will be happy and peaceful.");

        // Button actions
        fortuneButton.addActionListener(e -> displayFortune());
        quitButton.addActionListener(e -> System.exit(0));

        // Set frame size and position
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int width = (int) (screenSize.width * 0.75);
        int height = (int) (screenSize.height * 0.75);
        setBounds((screenSize.width - width) / 2, (screenSize.height - height) / 2, width, height);
    }

    private void displayFortune() {
        int index;
        do {
            index = random.nextInt(fortunes.size());
        } while (index == lastFortuneIndex);

        lastFortuneIndex = index;
        String fortune = fortunes.get(index);
        fortuneDisplay.append(fortune + "\n");
    }
}

