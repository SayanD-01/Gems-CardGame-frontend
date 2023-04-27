package com.psl.gems;

import java.io.*;
import java.util.*;

import com.psl.gems.Cards.Card;

public class FileWrite {

    public static void writeHTMLOutput(Game game) {

        try {
            //Write mode if the file exists then open the file and write in it 
            //or create the file with the given name
            FileWriter writer = new FileWriter("com/psl/gems/frontend/cardgame.html");
            writer.write("<!DOCTYPE html>\n");
            writer.write("<html lang=\"en\">\n");
            writer.write("<head>\n");
            writer.write("<title>Card Game</title>\n");
            writer.write("<link rel='stylesheet' href='style.css'>\n");
            writer.write("<script src='reavealCards.js'></script>\n");
            writer.write("</head>\n");
            writer.write("<body>\n");
            writer.write("<section>\n");
            for (Player p : game.getPlayers() ) {
                writer.write("<div class='player'>\n");
                writer.write("<h2>"+p.getName()+"</h2>\n");
                for (Card card : p.getPlayerCard()) {
                    writer.write("<div class='card'>\n");
                    writer.write("<div class='card-inner' id='" + card +  "'>\n");
                    writer.write("<div class='card-front'></div>\n");
                    writer.write("<div class='card-back'></div>\n");
                    writer.write("</div>\n");
                    writer.write("</div>\n");
                }

                writer.write("<button onclick='revealCards(this)'>Show the highest card</button>\n");
                writer.write("<div class='card'>\n");
                writer.write("<div class='card-inner' id='" + p.getHighestCard() +  "'>\n");
                writer.write("<div class='card-front'></div>\n");
                writer.write("<div class='card-back'></div>\n");
                writer.write("</div>\n");
                writer.write("</div>\n");
                writer.write("</div>\n");
            }
            writer.write("<button onclick='showWinner(\""+game.getWinner().getName()+"\","+game.getWinner().getScore()+")'>Declare Winner</button>\n");
            writer.write("<div id=\"winner\"></div>");
            writer.write("</section>\n");
            writer.write("</body>\n");
            writer.write("</html>");
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
}
