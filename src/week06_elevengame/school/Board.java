package week06_elevengame.school;

public class Board {
    private Card[] cardsOnBoard = new Card[9];
    
    public Board(){
        
    }
    
    public String getCardName(int index){
        return cardsOnBoard[index].getName();
    }
}
