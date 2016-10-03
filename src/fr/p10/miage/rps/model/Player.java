package fr.p10.miage.rps.model;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by wilpiron on 03/10/2016.
 */
public class Player {
    private String name;
    private int score;
    private ArrayList<RPSEnum> moves;
    private int nbmoves;
    private int currentmove;

    public Player(String name, ArrayList<RPSEnum> moves){
        this.name = name;
        this.score = 0;
        this.moves = moves;
        this.nbmoves = this.moves.size();
        this.currentmove = -1;
    }

    public Player(String name){
        this.name = name;
        this.score = 0;
        for(int i = 0, temp; i < 20 ; i++ ){
            temp = (int)(Math.random()%3);
            if (temp == 0) this.moves.add(RPSEnum.ROCK);
            if (temp == 1) this.moves.add(RPSEnum.PAPER);
            if (temp == 2) this.moves.add(RPSEnum.SCISSORS);
        }
        this.nbmoves = 20;
        this.currentmove = -1;
    }

    public String getName() {
        return this.name;
    }

    public int getScore() {
        return this.score;
    }

    public int getNbmoves() {
        return this.nbmoves;
    }

    public RPSEnum getNextMove(){
        this.currentmove += 1;
        if (this.currentmove >= this.moves.size()){
            this.currentmove = 0;
        }
        return (this.moves.get(currentmove));
    }

    public void setScore(int score) {
        this.score = score;
    }
}
