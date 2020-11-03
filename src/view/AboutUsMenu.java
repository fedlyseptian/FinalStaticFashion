package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import static view.MainMenus.mindfullyFont;

public class AboutUsMenu {

    JFrame frame = new JFrame("About Us : Final Static Fashion");
    JTabbedPane tabPanel = new JTabbedPane();
    JPanel storyPanel = new JPanel();
    JPanel contributorPanel = new JPanel(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();

    public AboutUsMenu() {
        // Set Title Icon
        Image icon = Toolkit.getDefaultToolkit().getImage("media/logoFSF.png");
        frame.setIconImage(icon);

        // Grid Bag Layout
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        // Story Panel
        JLabel storyTitle = new JLabel("Who Are We");
        storyTitle.setFont(mindfullyFont);
        storyTitle.setFont(storyTitle.getFont().deriveFont(200f));
        storyTitle.setForeground(new Color(255, 145, 0));
        storyTitle.setBorder(new EmptyBorder(100, 0, 0, 0));
        storyPanel.add(storyTitle);
        storyPanel.setBackground(Color.BLACK);

        JLabel storyArticle = new JLabel("<html><div WIDTH=1100>" + "Final Static Fashion\n" + "had always loved beautiful Earth with its courageous, chilly cities. It was a place where he felt calm.\n" + "He was a gracious, modest, whiskey drinker with fluffy fingers and pink eyelashes. His friends saw him as an abundant, adorable angel. Once, he had even brought a difficult baby back from the brink of death. That's the sort of man he was.\n" + "Final Static Fashion walked over to the window and reflected on his grand surroundings. The sun shone like partying foxes.\n" + "Then he saw something in the distance, or rather someone. It was the figure of World . World was a wild god with tall fingers and red eyelashes.\n" + "Final Static Fashion gulped. He was not prepared for World.\n" + "As Final Static Fashion stepped outside and World came closer, he could see the slippery glint in her eye.\n" + "\"Look Final Static Fashion,\" growled World, with a considerate glare that reminded Final Static Fashion of wild kittens. \"It's not that I don't love you, but I want provide fashion. You owe me 5130 dollars.\"\n" + "Final Static Fashion looked back, even more confident and still fingering the magic shoes. \"World, I am ready to this,\" he replied.\n" + "They looked at each other with ecstatic feelings, like two homeless, high hamsters loving at a very incredible rave, which had jazz music playing in the background and two thoughtful uncles thinking to the beat.\n" + "Final Static Fashion regarded World's tall fingers and red eyelashes. \"I don't have the funds ...\" he lied.\n" + "World glared. \"Do you want me to shove that magic shoes where the sun don't shine?\"\n" + "Final Static Fashion promptly remembered his gracious and modest values. \"Actually, I do have the funds,\" he admitted. He reached into his pockets. \"Here's what I owe you.\"\n" + "World looked delighted, her wallet blushing like a scattered, slippery shirt.\n" + "Then World came inside for a nice glass of whiskey.</div></html>");
        storyArticle.setFont(storyArticle.getFont().deriveFont(14f));
        storyArticle.setForeground(Color.WHITE);
        storyPanel.add(storyArticle);

        // Contributor Panel
        JPanel panelContibutorTitle = new JPanel();
        JLabel contributorTitle = new JLabel("Our Lovely Contributors");
        contributorTitle.setFont(mindfullyFont);
        contributorTitle.setFont(contributorTitle.getFont().deriveFont(80f));
        contributorTitle.setForeground(new Color(255, 145, 0));
        panelContibutorTitle.add(contributorTitle);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        contributorPanel.add(panelContibutorTitle, gbc);
        panelContibutorTitle.setBackground(Color.BLACK);

        JPanel panelContributors = new JPanel(new GridLayout(1, 3));
        JPanel panelFedly = new JPanel(new GridLayout(2,1));
        JLabel labelFedly = new JLabel("Fedly Septian");
        JLabel fotoFedly = new JLabel();
        fotoFedly.setIcon(new ImageIcon(new ImageIcon("media/fedlyS.jpg").getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT)));
        labelFedly.setFont(new Font("Consolas", Font.BOLD, 20));
        labelFedly.setHorizontalAlignment(JLabel.CENTER);
        fotoFedly.setHorizontalAlignment(JLabel.CENTER);
        panelFedly.add(fotoFedly);
        panelFedly.add(labelFedly);
        labelFedly.setForeground(Color.WHITE);
        panelFedly.setBackground(Color.BLACK);

        JPanel panelJeddi = new JPanel(new GridLayout(2,1));
        JLabel labelJeddi = new JLabel("Jedediah Fanuel");
        JLabel fotoJeddi = new JLabel();
        fotoJeddi.setIcon(new ImageIcon(new ImageIcon("media/jeddiF.jpg").getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT)));
        labelJeddi.setFont(new Font("Consolas", Font.BOLD, 20));
        labelJeddi.setHorizontalAlignment(JLabel.CENTER);
        fotoJeddi.setHorizontalAlignment(JLabel.CENTER);
        panelJeddi.add(fotoJeddi);
        panelJeddi.add(labelJeddi);
        labelJeddi.setForeground(Color.WHITE);
        panelJeddi.setBackground(Color.BLACK);

        JPanel panelTimothy = new JPanel(new GridLayout(2,1));
        JLabel labelTimothy = new JLabel("Timothy Ray");
        JLabel fotoTimothy = new JLabel();
        fotoTimothy.setIcon(new ImageIcon(new ImageIcon("media/timothyR.jpg").getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT)));
        labelTimothy.setFont(new Font("Consolas", Font.BOLD, 20));
        labelTimothy.setHorizontalAlignment(JLabel.CENTER);
        fotoTimothy.setHorizontalAlignment(JLabel.CENTER);
        panelTimothy.add(fotoTimothy);
        panelTimothy.add(labelTimothy);
        labelTimothy.setForeground(Color.WHITE);
        panelTimothy.setBackground(Color.BLACK);

        panelContributors.add(panelFedly);
        panelContributors.add(panelJeddi);
        panelContributors.add(panelTimothy);
        panelContributors.setBorder(new EmptyBorder(20,0,0,0));
        panelContributors.setBackground(Color.BLACK);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        contributorPanel.add(panelContributors, gbc);

        // Add panels to tabbed panel
        tabPanel.setBounds(200,200,400,400);
        tabPanel.add("A Little Story", storyPanel);
        tabPanel.add("Contributors", contributorPanel);

        frame.getContentPane().setBackground(Color.BLACK);
        frame.add(tabPanel);
        frame.setSize(1280, 720);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

}
