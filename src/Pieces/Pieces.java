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
public class Pieces {
    public static ArrayList<Pieces> ListOfPieces = new ArrayList<Pieces>();
    
    public Pieces(){
    }
    public String getPieceColour(){
        return "Error: Pieces Colour Unavaliable";
    }    
    public Pieces getPiece(int i){
        return Pieces.ListOfPieces.get(i);
    }
    
    public int getTotalNum(){
        return Pieces.ListOfPieces.size();
    }
    
    // Returns an ArrayList<String> which has the list of all occupued 
    // spaces on the board. The index list correlates to the pieces order in ListOfPieces
    // if RF = true, the list will be in modern chess' (file/rank) notation
    //  else will be in cartesian notation
    public ArrayList<String> getOccupiedSpaces(boolean RF){
        ArrayList<String> AllPiecesLocations = new ArrayList<>();
        Pieces.ListOfPieces.forEach((piece) -> {
            AllPiecesLocations.add(piece.getPieceLocation(RF));
        });
        return AllPiecesLocations;
    }
    
    public ArrayList<Pieces> getListOfPieces(){
        return Pieces.ListOfPieces;
    }

    public ArrayList<String> getPossibleMoves(){
        return null;
    }
    public String getPiecetype(){
        return "Error: Piece Type Unavaliable";
    }      
    
    public String getPieceLocation(boolean RF){
        return "Error: Pieces Colour Unavaliable";
    }    
    
    public ArrayList<Pieces> getPieces(){
        return Pieces.ListOfPieces;
    }
    
    public void addPieceToList(Pieces piece){
        Pieces.ListOfPieces.add(piece);
    }
        
    public String toString(boolean showMoves) {
        return "Error: to string not implemented";
    }
    
}
