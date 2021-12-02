/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frontistirio0608Grafika.mvcCardGame.view;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import frontistirio0608Grafika.mvcCardGame.model.Card;

/**
 *
 * @author Michalis
 */
public class View extends JFrame {

    private JButton[] playerCards = new JButton[4];
    private JButton playerLastCard = new JButton();
    private JLabel[] positions;
    private JLayeredPaneExtension basic_panel;
    private JLayeredPane player1;
    private ClassLoader cldr;
    boolean enabled = true;
    JLabel pawn;
    JTextArea infobox;

    public void updateCard(Card c, int position) {
        URL imageURL2 = cldr.getResource(c.getImage()); //image
        Image image2 = new ImageIcon(imageURL2).getImage();
        image2 = image2.getScaledInstance(60, 70, java.awt.Image.SCALE_SMOOTH);
        playerCards[position].setIcon(new ImageIcon(image2));
        basic_panel.repaint();
    }

    public JButton[] getPlayerCards() {
        return playerCards;
    }

    public void setLastCard(Card c) {
        URL imageURL2 = cldr.getResource(c.getImage()); //image
        Image image2 = new ImageIcon(imageURL2).getImage();
        image2 = image2.getScaledInstance(60, 70, java.awt.Image.SCALE_SMOOTH);
        playerLastCard.setIcon(new ImageIcon(image2));
    }

    public void initCards(ArrayList<Card> cards) {
        for (int i = 0; i <= 3; i++) {
            playerCards[i] = new JButton();
            playerCards[i].setName(Integer.toString(i));
            playerCards[i].setBounds(10 + i * 70, 10, 60, 70);
            URL imageURL2 = cldr.getResource(cards.get(i).getImage()); //image
            Image image2 = new ImageIcon(imageURL2).getImage();
            image2 = image2.getScaledInstance(60, 70, java.awt.Image.SCALE_SMOOTH);
            playerCards[i].setIcon(new ImageIcon(image2));
            //playerCards[i].setBackground(Color.white);
            player1.add(playerCards[i], 0);
        }
        playerLastCard.setBounds(350, 10, 60, 70);
        player1.add(playerLastCard);

        JLabel label = new JLabel("Last Card Played");
        label.setBounds(330, 85, 100, 10);
        player1.add(label);
    }

    public View() {
        cldr = this.getClass().getClassLoader();
        this.setResizable(false);
        this.setTitle("Demo");
        this.setPreferredSize(new Dimension(520, 500));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void updatePawn(int position) {
        pawn.setBounds(5, 5,50, 60);
        positions[position].add(pawn, 0);
        basic_panel.repaint();
    }

    public void updateInfobox(String message) {
        infobox.setText(message);
        basic_panel.repaint();
    }

    public void initComponents(ArrayList<Card> cards) {
        positions = new JLabel[10];
        URL imageURL = cldr.getResource("resources/images/bg_green.png"); //image
        System.out.println("URL to read:"+ imageURL);
        ///CS252playground/src/frontistirio0608Grafika/mvcCardGame/view/bg_green.png
        //URL imageURL = cldr.getResource("view\\bg_green.png"); //image
        Image image = new ImageIcon(imageURL).getImage();
        basic_panel = new JLayeredPaneExtension(image);

        player1 = new JLayeredPane();
        player1.setBounds(10, 10, 500, 100);
        player1.setBackground(Color.CYAN);
        player1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.GREEN));
        player1.setOpaque(true);
        this.initCards(cards);
        // button 

        infobox = new JTextArea();
        infobox.setBounds(10, 370, 500, 50);
        infobox.setBackground(Color.WHITE);
        infobox.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
        infobox.setOpaque(true);
        infobox.setText("Choose any Card!");
        for (int i = 0; i <= 9; i++) {
            if(i==0){
                positions[i] = new JLabel("" + (i + 1)+ " Start");
                positions[i].setBackground(Color.red);
            }
            else if(i==9){
                positions[i] = new JLabel("" + (i + 1)+ " End");
                positions[i].setBackground(Color.green);
            }
            else{
                positions[i] = new JLabel("" + (i + 1));
                positions[i].setBackground(Color.white);
            }
 
            
            if (i<=4)
                positions[i].setBounds(70 + i * 80, 150, 70,70);
            else
                positions[i].setBounds(70 + (i-5) * 80, 250, 70, 70);

            
            positions[i].setOpaque(true);
            basic_panel.add(positions[i], 0);
        }

        basic_panel.add(player1, 0);
        basic_panel.add(infobox, 0);
        pawn = new JLabel();

        URL imageURL2 = cldr.getResource("resources/images/pawn_blue.png"); //image
        Image image2 = new ImageIcon(imageURL2).getImage();
        image2 = image2.getScaledInstance(50,60, java.awt.Image.SCALE_SMOOTH);
        pawn.setIcon(new ImageIcon(image2));
        pawn.setBounds(20,150,50, 60);
        basic_panel.add(pawn, 0);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(basic_panel, GroupLayout.PREFERRED_SIZE, 910, GroupLayout.PREFERRED_SIZE));
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(basic_panel, GroupLayout.PREFERRED_SIZE, 685, GroupLayout.PREFERRED_SIZE));
        pack();
        basic_panel.repaint();
    }

    public void showWinningMessage(String message) {
        JOptionPane.showMessageDialog(this, message);

    }

}
