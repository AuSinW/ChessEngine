/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pieces;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Rook  extends Pieces{
 public String colour, locRF, locCC;
    public String pieceType;
    public char file;
    public int rank;
    public Boolean hasMoved;
    char identifier;
    
    // intLoc
    public Rook(char file, int rank, String colour){
     this.pieceType = "Rook";
     this.identifier = 'R';
     this.colour = colour;
     this.file = Character.toLowerCase(file);
     this.rank = rank;
     this.locRF =  (file) + String.valueOf(rank);
     this.locCC = String.valueOf(file - 'a' + 1) + String.valueOf(rank); 
     this.hasMoved = false;
    }
    
 @Override
    public String getPieceColour(){
        return this.colour;
    }
    
 @Override
    public String getPieceLocation(boolean RF){
        if(RF){
            return this.locRF;
        }else{
            return this.locCC;
        }
    }
    
    
    int getRank(){
        return this.rank;
    }
    
    char getFile(){
        return this.file;
    }
    // This function updates all location related values
    // locRF, locCC, rank, and file.
    public void setPieceLocation(String newLocRF){
        this.locRF = newLocRF;
        this.file = (char) newLocRF.charAt(0);
        this.rank = (int) (newLocRF.charAt(1) - 48 );
        this.locCC = String.valueOf(this.file - 'a' + 1) + String.valueOf(this.rank); 
    }

    /**
     *
     * @return
     */
    @Override 
    public String getPiecetype(){
        return this.pieceType;
    }   

    void updateHadMoved(){
        this.hasMoved = true;
    }
    @Override 
    public ArrayList<String> getPossibleMoves(){
        ArrayList<String> possibleMoves = new ArrayList<>();
        
        // vertial possible moves
        for (int i =1; i <= 7; i++){
            if((this.rank + i) <= 8){
            possibleMoves.add(String.valueOf(this.identifier) + this.locRF.charAt(0) + String.valueOf((this.rank) + i));
            }else{
            possibleMoves.add(String.valueOf(this.identifier) + this.locRF.charAt(0) + String.valueOf(((this.rank) + i) % 8));    
            }
        }
        //for horizontal possible moves
        for (int i =1; i <= 7; i++){
            possibleMoves.add(String.valueOf(this.identifier) + (char)(((this.locRF.charAt(0) - 97 + i) % 8) + 97) + String.valueOf((this.rank)));    
        }
        return possibleMoves;
    }
    
    /**
     *
     * @param showMoves
     * @return
     */
    @Override    
    public String toString(boolean showMoves) {
        if (showMoves) {
            ArrayList<String> pm = this.getPossibleMoves();
            System.out.println("\nPossible Moves: " + pm + ". " + pm.size());
        }        
        return ("" + this.colour + " " + this.pieceType + " (" + this.identifier + "). Located on: " + this.locCC + "/" + this.locRF + ". Rank: " + this.rank + ". File: " + this.file);
    }
}
    

