/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;
import Pieces.Bishop;
import Pieces.King;
import Pieces.Knight;
import Pieces.Pawn;
import Pieces.Rook;
import Pieces.Pieces;
import Pieces.Queen;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Chess {
    
    
    void printPossibleMoves(Pieces allPieces){
       System.out.println("All spaces taken: " + allPieces.getOccupiedSpaces(true) +"\n");
       for (int i = 0; i < allPieces.getTotalNum(); i++) {
            Pieces piece = allPieces.getPiece(i); // Access the piece from the list
            ArrayList<String> piecesPM = piece.getPossibleMoves();
            System.out.println((i+1) + ": " + piece.getPieceColour() + " " + piece.getPiecetype() + 
                    " on " + piece.getPieceLocation(true) + " has " + piecesPM.size() + " possible moves:");
            System.out.println("        " + piecesPM);
        }       
    }
    
    void testPawnImplementation(Chess ChessGame){
       Pieces pieces = new Pieces();
       System.out.println("---- PAWN TEST CASES ---");
       Pawn Pawn_1 = new Pawn('f', 2, "White");
       Pawn Pawn_2 = new Pawn('g', 3, "Black");
       Pawn Pawn_3 = new Pawn('c', 7, "Black");
       Pawn Pawn_4 = new Pawn('d', 6, "White"); 
       Pawn Pawn_5 = new Pawn('e', 2, "White");
       Pawn Pawn_6 = new Pawn('c', 5, "white");
       
        
       pieces.addPieceToList(Pawn_1);
       pieces.addPieceToList(Pawn_2);
       pieces.addPieceToList(Pawn_3); 
       pieces.addPieceToList(Pawn_4);       
       pieces.addPieceToList(Pawn_5);
       pieces.addPieceToList(Pawn_6);
       ChessGame.printPossibleMoves(pieces);
    }
    
    void testKnightImplementation(Chess ChessGame){
       Pieces pieces = new Pieces();
       System.out.println("---- KNIGHT TEST CASES ---");
       Knight Knight_1 = new Knight('d', 5, "White");
       Knight Knight_2 = new Knight('f', 6, "Black");

       
        
       pieces.addPieceToList(Knight_1);
       pieces.addPieceToList(Knight_2);
 
       ChessGame.printPossibleMoves(pieces);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Chess ChessGame = new Chess();

//       Pawn Pawn_1 = new Pawn('f', 2, "White");
//       Rook Rook_1 = new Rook('a', 1, "White");
//       Rook Rook_2 = new Rook('g', 7, "Black");
//       Knight Knight_1 = new Knight('d', 4, "Black");
//       Knight Knight_2 = new Knight('a', 8, "Black");
//       Knight Knight_3 = new Knight('h', 7, "Whtie");
//       Bishop Bishop_1 = new Bishop('c', 1, "White");
//       Bishop Bishop_2 = new Bishop('a', 8, "White");
//       Bishop Bishop_3 = new Bishop('e', 4, "Black"); 
//       King King_1 = new King('e', 1, "White");
//       King King_2 = new King('h', 8, "Black");
//       King King_3 = new King('f', 6, "Black"); 
//       Queen Queen_1 = new Queen('d', 5, "Black");
//       Queen Queen_2 = new Queen('a', 4, "White");
//       Queen Queen_3 = new Queen('g', 2, "Black");       
      
        ChessGame.testKnightImplementation(ChessGame);

    }
    
}
