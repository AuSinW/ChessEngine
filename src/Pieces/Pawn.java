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
public class Pawn extends Pieces{
    public String colour, locRF, locCC;
    public String pieceType;
    public char file;
    public int rank;
    public Boolean hasMoved;
    char identifier;
    
    // intLoc
    public Pawn(char file, int rank, String colour){
     super();
     this.pieceType = "Pawn";
     this.identifier = ' ';
     this.colour = colour;
     this.file = Character.toLowerCase(file);
     this.rank = rank;
     this.locRF =  (file) + String.valueOf(rank);
     this.locCC = String.valueOf(file - 'a' + 1) + String.valueOf(rank); 
     
     this.hasMoved = !(( colour.equals("Black") && rank == 7 ) 
             || ( colour.equals("White") && 2 == rank )); 
             
     
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
        this.updateHadMoved();
    }
    
    @Override
    public String getPiecetype(){
        return this.pieceType;
    }   

    void updateHadMoved(){
        this.hasMoved = true;
    }
    @Override 
    public  ArrayList<String> getPossibleMoves(){
        ArrayList<String> possibleMoves = new ArrayList<>();
        ArrayList<Pieces> AllPieces = super.getListOfPieces();
        ArrayList<String> AllPiecesLocations = super.getOccupiedSpaces(true);
        // White Pawns move "up" the board while black pawn move "down" the board.
        if("White".equals(this.colour)){
            if(!AllPiecesLocations.contains((char)this.file + String.valueOf(this.rank + 1))){
                possibleMoves.add(String.valueOf(this.locRF.charAt(0)) + String.valueOf(this.rank + 1)); // Is piece blocking path?
                if (!this.hasMoved && !AllPiecesLocations.contains((char)this.file + String.valueOf(this.rank + 2))){ // Can move two squares?
                    possibleMoves.add(String.valueOf(this.locRF.charAt(0)) + String.valueOf(this.rank + 2));
                }
            }
            // captrue NE
            if(AllPiecesLocations.contains((char)(this.file + 1) + String.valueOf(this.rank + 1) )&&
                    AllPieces.get(AllPiecesLocations.indexOf((char)(this.file + 1) + String.valueOf(this.rank + 1))).getPieceColour().equals("Black")){ // determine if we can capture NE
                possibleMoves.add(String.valueOf((this.locRF.charAt(0)) + "x" + (char)(this.file+ 1)) + String.valueOf(this.rank + 1));
            }
            if(AllPiecesLocations.contains((char)(this.file - 1) + String.valueOf(this.rank + 1)) &&
                    AllPieces.get(AllPiecesLocations.indexOf((char)(this.file - 1) + String.valueOf(this.rank + 1))).getPieceColour().equals("Black") ){ // captrue NW
                possibleMoves.add(String.valueOf((this.locRF.charAt(0)) + "x" + (char)(this.file - 1)) + String.valueOf(this.rank + 1)); // determine if we can capture NW
            }            
        }else{ 
            if(!AllPiecesLocations.contains((char)this.file + String.valueOf(this.rank - 1))){
                possibleMoves.add(String.valueOf(this.locRF.charAt(0)) + String.valueOf(this.rank - 1)); // Is piece blocking path?
                if (!this.hasMoved && !AllPiecesLocations.contains((char)this.file + String.valueOf(this.rank - 2))){ // Can move two squares?
                    possibleMoves.add(String.valueOf(this.locRF.charAt(0)) + String.valueOf(this.rank - 2));
                }
            }
            // captrue SE
            if(AllPiecesLocations.contains((char)(this.file + 1) + String.valueOf(this.rank - 1) )&&
                    AllPieces.get(AllPiecesLocations.indexOf((char)(this.file + 1) + String.valueOf(this.rank - 1))).getPieceColour().equals("White")){ // determine if we can capture SE
                possibleMoves.add(String.valueOf((this.locRF.charAt(0)) + "x" + (char)(this.file + 1)) + String.valueOf(this.rank - 1));
            }
            if(AllPiecesLocations.contains((char)(this.file - 1) + String.valueOf(this.rank - 1)) &&
                    AllPieces.get(AllPiecesLocations.indexOf((char)(this.file - 1) + String.valueOf(this.rank - 1))).getPieceColour().equals("White") ){ // captrue SW
                possibleMoves.add(String.valueOf((this.locRF.charAt(0)) + "x" + (char)(this.file - 1)) + String.valueOf(this.rank - 1)); // determine if we can capture SW
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
        return ("" + this.colour + " " + this.pieceType + ". Located on: " + this.locCC + "/" + this.locRF + ". Rank: " + this.rank + ". File: " + this.file);
        
    }
}
    
