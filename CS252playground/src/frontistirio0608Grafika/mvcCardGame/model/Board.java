/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frontistirio0608Grafika.mvcCardGame.model;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author micha_000
 */
public class Board {
    Card lastCardPlayed;

    public ArrayList<Card> getGameCards() {
        return gameCards;
    }

    public void setGameCards(ArrayList<Card> gameCards) {
        this.gameCards = gameCards;
    }

    
    ArrayList<Card> gameCards = new ArrayList<Card>();

    public void initCards() {
        for (int i = 0; i <= 11; i++) {
            Card card = new Card();
            card.setValue(i % 4 + 1);
            card.setImage("resources/images/card" + (i % 4 + 1) + ".png");
            gameCards.add(card);
        }
        Collections.shuffle(gameCards);
    }
    public Card getLastCardPlayed() {
        return lastCardPlayed;
    }

    
    public boolean movePlayer(Player player, Card c){
        if(player.getPosition()+c.getValue()>9)
            return false;
        player.movePosition(c.getValue());
        return true;
    }
    
    public void setLastCardPlayed(Card lastCardPlayed) {
        this.lastCardPlayed = lastCardPlayed;
    }
    
        

        
}
