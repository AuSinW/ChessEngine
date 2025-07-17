/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pieces;

/**
 *
 * @author User
 */
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Knight extends Pieces {
 public String colour, locRF, locCC;
    public String pieceType;
    public char file;
    public int rank;
    char identifier;
    
    // intLoc
    public Knight(char file, int rank, String colour){
     this.pieceType = "Knight";
     this.identifier = 'N';
     this.colour = colour;
     this.file = Character.toLowerCase(file);
     this.rank = rank;
     this.locRF =  (file) + String.valueOf(rank);
     this.locCC = String.valueOf(file - 'a' + 1) + String.valueOf(rank); 
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
    
    @Override
    public String getPiecetype(){
        return this.pieceType;
    }  
    @Override 
    public ArrayList<String> getPossibleMoves(){
        ArrayList<String> possibleMoves = new ArrayList<>();
        ArrayList<Pieces> AllPieces = super.getListOfPieces();
        ArrayList<String> AllPiecesLocations = super.getOccupiedSpaces(true);        
        // Going Clockwise Starting at "1pm"
        if (!(AllPiecesLocations.contains((char)(this.file + 1) + String.valueOf(this.rank + 2)))){ //are squares blank?
            if( ( this.rank <= 6 && ((int)(this.file - 96) <= 7) )){     
               possibleMoves.add(String.valueOf(this.identifier) + (char)(this.file + 1) + String.valueOf(this.rank + 2)); 
            }
            if(this.rank <= 7 && ((int)(this.file - 96) <= 6)){
               possibleMoves.add(String.valueOf(this.identifier) + (char)(this.file + 2) + String.valueOf(this.rank + 1)); 
            }
            if(this.rank >= 2 && ((int)(this.file - 96) <= 6)){
               possibleMoves.add(String.valueOf(this.identifier) + (char)(this.file + 2) + String.valueOf(this.rank - 1)); 
            }
            if(this.rank >= 3 && ((int)(this.file - 96) <= 7)){
               possibleMoves.add(String.valueOf(this.identifier) + (char)(this.file + 1) + String.valueOf(this.rank - 2)); 
            }      
            if(this.rank >= 3 && (int)(this.file - 96) >= 2){
               possibleMoves.add(String.valueOf(this.identifier) + (char)(this.file - 1) + String.valueOf(this.rank - 2)); 
            }  
            if(this.rank >= 2 && (int)(this.file - 96) >= 3){
               possibleMoves.add(String.valueOf(this.identifier) + (char)(this.file - 2) + String.valueOf(this.rank - 1)); 
            } 
            if(this.rank <= 7 && (int)(this.file - 96) >= 3){
               possibleMoves.add(String.valueOf(this.identifier) + (char)(this.file - 2) + String.valueOf(this.rank + 1)); 
            }
            if(this.rank <= 6 && (int)(this.file - 96) >= 2){
               possibleMoves.add(String.valueOf(this.identifier) + (char)(this.file - 1) + String.valueOf(this.rank + 2)); 
            }
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
