package week06_elevengame.school;

import java.util.List;
import week06_elevengame.utils.GameInterface;

public class Game implements GameInterface{
    
    private String gameName = "Elevengame";
    private Board board = new Board();
    private Deck deck = new Deck();
    
    public Game(){

    }

    @Override
    public String getName() {
         return gameName;
    }

    @Override
    public int nCards() {
        return 1; 
    }

    @Override
    public int getDeckSize() {
        return 1;
    }

    @Override
    public String getCardDescriptionAt(int index) {
        return board.getCardName(index);
    }

    @Override
    public boolean anotherPlayIsPossible() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean playAndReplace(List<Integer> iSelectedCards) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public boolean isWon() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
