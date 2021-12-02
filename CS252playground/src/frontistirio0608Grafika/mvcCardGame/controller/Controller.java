/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frontistirio0608Grafika.mvcCardGame.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

import frontistirio0608Grafika.mvcCardGame.model.*;
import frontistirio0608Grafika.mvcCardGame.view.*;


/**
 *
 * @author micha_000
 */
public class Controller {

    Board board;
    View view;
    Player player1;

    public void initialize() {
        player1 = new Player();
        board = new Board();
        board.initCards();
        for (int i = 0; i < 4; i++) {
            player1.addCards(board.getGameCards().remove(0));
        }
        view = new View();
        view.initComponents(player1.getCards());
        view.setVisible(true);
        setListeners();
        view.updateInfobox("Start Game, Play Any Card! Available Cards:" + board.getGameCards().size());
    }

    public void setListeners() {
        for (int i = 0; i < view.getPlayerCards().length; i++) {
            view.getPlayerCards()[i].addMouseListener(new CardListener());
        }
    }

    public void removeAndReplaceCard(int positionOfCard) {
        if (board.getGameCards().isEmpty()) {
            view.updateInfobox("Game Has Finished. Available Cards 0");
        } else {
            player1.getCards().remove(positionOfCard);
            player1.getCards().add(positionOfCard, board.getGameCards().remove(0));
            Card c = player1.getCards().get(positionOfCard);
            view.updateCard(c, positionOfCard);
            if (board.getGameCards().isEmpty()) {
                view.updateInfobox("Game Has Finished. Available Cards 0");
            } else {
                view.updateInfobox("Card Replaced: Available Cards:" + board.getGameCards().size());
            }
        }
    }

    public void checkIfItCanBePlayed(int positionOfCard) {
        Card cardToPlay = player1.getCards().get(positionOfCard);
        if (board.movePlayer(player1, cardToPlay)==true) {
            player1.setHasStarted(true);
            board.setLastCardPlayed(cardToPlay);
            view.setLastCard(board.getLastCardPlayed());
            view.updatePawn(player1.getPosition());
            boolean gameFinished = checkIfGameFinished();
            if (!gameFinished) {
                removeAndReplaceCard(positionOfCard);
            } else {
                view.updateInfobox("Game Has Finished! Player Reached the End!!");
                view.showWinningMessage("You are the winner!");
            }
        }
            
            else{
             board.setLastCardPlayed(cardToPlay);
            view.setLastCard(board.getLastCardPlayed());
             removeAndReplaceCard(positionOfCard);
                view.updateInfobox("Invalid Move!! You should select a card having a lower value");    
            }
   

    }

    public static void main(String[] args) {

        Controller c = new Controller();
        c.initialize();

    }

    public boolean checkIfGameFinished() {
        if (player1.isHasFinished() || board.getGameCards().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    
    
    private class CardListener implements MouseListener {
       
        @Override
        public void mouseClicked(MouseEvent e) {
            JButton but = ((JButton) e.getSource()); 
            System.out.println(but.getName());
            if (checkIfGameFinished() == true) {
                return;
            }
            int cardInPlayerPosition=Integer.parseInt(but.getName());
            if (SwingUtilities.isRightMouseButton(e)) {
                removeAndReplaceCard(cardInPlayerPosition);
            } else if (SwingUtilities.isLeftMouseButton(e)) {
                checkIfItCanBePlayed(cardInPlayerPosition);
            }

        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

}
