package com.psl.gems;
import java.util.*;
import com.psl.gems.Cards.*;

public class Game {

    private List<Player> players;
    private Player winner;
    private packOfCards pack;

    public Game(){
        pack=new packOfCards();
        players=new ArrayList<Player>();
    }
    
    public Game(List<Player> players) {
        this.players = players;
        pack=new packOfCards();
        
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public packOfCards getPack() {
        return pack;
    }

    public void setPack(packOfCards pack) {
        this.pack = pack;
    }

    public void gameRegister(Player player) {
        players.add(player);
    }

    public void play() {

        System.out.println("Shuffling the cards...");
        pack.shuffleCards();
        System.out.println("Each player will get 3 card...... ");
        for(int i = 0; i < 3; i++){

        System.out.println("Cards given "+(i+1)+" times....");
            for(Player p : players){
                p.addCard(pack.getTopCard());
            }
        }
        
        for(Player p : players){
            System.out.println(p);
        }
        winner=determinWinner();
        System.out.println("The winner is........");
        System.out.println("Player: "+ winner );

    }

    public Player determinWinner(){
       for(Player p : players){
            calculateScore(p);
       }
       
       return players.stream()
            .max(Comparator.comparing(Player::getScore))
            .orElse(null);
    }

    public void calculateScore(Player p){
        p.setScore(0);
        for(Card card : p.getPlayerCard()){
            int s=card.getRank()*4+card.getSuit().getOdr();
            if(s>p.getScore()){
                p.setScore(s);
                p.setHighestCard(card);
            }
        }
        
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }
    
}
