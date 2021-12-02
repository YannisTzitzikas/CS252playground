/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontistirio0608Grafika.mvcCardGame.model;

import java.util.ArrayList;

/**
 *
 * @author micha
 */
public class Player {
    ArrayList<Card> cards=new ArrayList<Card>();
    int position=-1;
    boolean hasStarted=false,hasFinished=false;

    public int getPosition() {
        return position;
    }

    public void movePosition(int x) {
        
        this.position+=x;
        if (position==9)
            this.hasFinished=true;
    }
    
    
    
    public ArrayList<Card> getCards() {
        return cards;
    }

    public void addCards(Card card) {
        this.cards.add(card);
    }

    public boolean isHasStarted() {
        return hasStarted;
    }

    public void setHasStarted(boolean hasStarted) {
        this.hasStarted = hasStarted;
    }

    public boolean isHasFinished() {
        return hasFinished;
    }

    public void setHasFinished(boolean hasFinished) {
        this.hasFinished = hasFinished;
    }

    
}
