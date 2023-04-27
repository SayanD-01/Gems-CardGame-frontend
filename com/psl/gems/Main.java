package com.psl.gems;

// import java.util.*;

// import com.psl.gems.Cards.Card;
// import com.psl.gems.Cards.packOfCards;

//import com.psl.gems.Cards.packOfCards;

public class Main {
    
    public static void main(String[] args) {
        
        Game game =new Game();
        game.gameRegister(new Player("Ramesh"));
        game.gameRegister(new Player("Suresh"));
        // game.gameRegister(new Player("Mahesh"));
        // game.gameRegister(new Player("Avesh"));
        game.play();
        FileWrite.writeHTMLOutput(game);
        
    }
}
