package view;

import controller.ControllerDatabase;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static view.MainMenus.mindfullyFont;

public class AboutUsMenu implements ActionListener {

    JFrame frame = new JFrame("About Us : Final Static Fashion");
    JTabbedPane tabPanel = new JTabbedPane();
    JPanel storyPanel = new JPanel();
    JPanel contributorPanel = new JPanel(new BorderLayout());
    JButton backButton = new JButton("<<<");

    public static String aboutUsText = ControllerDatabase.getAboutUsText();

    public AboutUsMenu() {
        // Set Title Icon
        Image icon = Toolkit.getDefaultToolkit().getImage("media/logoFSF.png");
        frame.setIconImage(icon);

        backButton.setBounds(5, 25, 75, 30);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.setBorder(null);
        backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backButton.setForeground(new Color(255, 145, 0));
                backButton.setBackground(new Color(15, 15, 10));
                backButton.setBorder(new BevelBorder(0, Color.BLACK, new Color(20, 20, 20)));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                backButton.setForeground(Color.WHITE);
                backButton.setBackground(Color.BLACK);
                backButton.setBorder(null);
            }
        });

        backButton.setActionCommand("Back");
        backButton.addActionListener(this);

        // Story Panel
        JLabel storyTitle = new JLabel("Who Are We");
        storyTitle.setFont(mindfullyFont);
        storyTitle.setFont(storyTitle.getFont().deriveFont(200f));
        storyTitle.setForeground(new Color(255, 145, 0));
        storyTitle.setBorder(new EmptyBorder(100, 0, 0, 0));
        storyPanel.add(storyTitle);
        storyPanel.setBackground(Color.BLACK);

        aboutUsText = ControllerDatabase.getAboutUsText();
        JLabel storyArticle = new JLabel("<html><div WIDTH=1100>" + aboutUsText + "</div></html>");
        storyArticle.setFont(storyArticle.getFont().deriveFont(14f));
        storyArticle.setForeground(Color.WHITE);
        storyPanel.add(storyArticle);

        // Contributor Panel
        contributorPanel.setBorder(new LineBorder(Color.BLACK, 20));

        JPanel panelContibutorTitle = new JPanel();
        JLabel contributorTitle = new JLabel("Our Lovely Contributors");
        contributorTitle.setFont(mindfullyFont);
        contributorTitle.setFont(contributorTitle.getFont().deriveFont(80f));
        contributorTitle.setForeground(new Color(255, 145, 0));
        panelContibutorTitle.add(contributorTitle);

        contributorPanel.add(panelContibutorTitle, BorderLayout.NORTH);
        panelContibutorTitle.setBackground(Color.BLACK);

        // Fedly
        JPanel panelContributors = new JPanel(new GridLayout(1, 3));
        JPanel panelContributorsName = new JPanel(new GridLayout(1, 3));

        JPanel panelFedly = new JPanel(new GridLayout(1,1));
        JPanel panelFedlyTitle = new JPanel(new GridLayout(1,1));
        JLabel labelFedly = new JLabel("Fedly Septian");
        JLabel fotoFedly = new JLabel();
        fotoFedly.setIcon(new ImageIcon(new ImageIcon("media/fedlyS.jpg").getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT)));
        labelFedly.setFont(new Font("Consolas", Font.BOLD, 20));
        labelFedly.setHorizontalAlignment(JLabel.CENTER);
        fotoFedly.setHorizontalAlignment(JLabel.CENTER);
        panelFedly.add(fotoFedly);
        panelFedlyTitle.add(labelFedly);
        labelFedly.setForeground(Color.WHITE);
        panelFedly.setBackground(Color.BLACK);
        panelFedlyTitle.setBackground(Color.BLACK);

        // Jeddi
        JPanel panelJeddi = new JPanel(new GridLayout(1,1));
        JPanel panelJeddiTitle = new JPanel(new GridLayout(1,1));
        JLabel labelJeddi = new JLabel("Jedediah Fanuel");
        JLabel fotoJeddi = new JLabel();
        fotoJeddi.setIcon(new ImageIcon(new ImageIcon("media/jeddiF.jpg").getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT)));
        labelJeddi.setFont(new Font("Consolas", Font.BOLD, 20));
        labelJeddi.setHorizontalAlignment(JLabel.CENTER);
        fotoJeddi.setHorizontalAlignment(JLabel.CENTER);
        panelJeddi.add(fotoJeddi);
        panelJeddiTitle.add(labelJeddi);
        labelJeddi.setForeground(Color.WHITE);
        panelJeddi.setBackground(Color.BLACK);
        panelJeddiTitle.setBackground(Color.BLACK);

        // Timothy
        JPanel panelTimothy = new JPanel(new GridLayout(1,1));
        JPanel panelTimothyTitle = new JPanel(new GridLayout(1,1));
        JLabel labelTimothy = new JLabel("Timothy Ray");
        JLabel fotoTimothy = new JLabel();
        fotoTimothy.setIcon(new ImageIcon(new ImageIcon("media/timothyR.jpg").getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT)));
        labelTimothy.setFont(new Font("Consolas", Font.BOLD, 20));
        labelTimothy.setHorizontalAlignment(JLabel.CENTER);
        fotoTimothy.setHorizontalAlignment(JLabel.CENTER);
        panelTimothy.add(fotoTimothy);
        panelTimothyTitle.add(labelTimothy);
        labelTimothy.setForeground(Color.WHITE);
        panelTimothy.setBackground(Color.BLACK);
        panelTimothyTitle.setBackground(Color.BLACK);

        panelContributors.add(panelFedly);
        panelContributors.add(panelJeddi);
        panelContributors.add(panelTimothy);
        panelContributors.setBackground(Color.BLACK);

        panelContributorsName.add(panelFedlyTitle);
        panelContributorsName.add(panelJeddiTitle);
        panelContributorsName.add(panelTimothyTitle);
        panelContributorsName.setBackground(Color.BLACK);

        contributorPanel.add(panelContributors, BorderLayout.CENTER);
        contributorPanel.add(panelContributorsName, BorderLayout.SOUTH);

        // Add panels to tabbed panel
        tabPanel.add("A Little Story", storyPanel);
        tabPanel.add("Contributors", contributorPanel);

        frame.add(backButton);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.add(tabPanel);
        frame.setSize(1280, 720);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "Back":
                new MainMenus();
                frame.dispose();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + command);
        }
    }
}
