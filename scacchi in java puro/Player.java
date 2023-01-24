import java.util.List;
import java.util.Scanner;

public class Player {

    protected int turn;
    protected boolean color;
    protected Scacchiera scacchiera;
    private Scanner scan;

    public Player(boolean col,Scacchiera sca,Scanner scan){
        this.color = col;
        this.scacchiera = sca;
        this.scan = scan;
        turn = 1;
    }

    public void move(){

        scacchiera.printTable();


        List<String> movePossibility = scacchiera.getListPicesAvaible(this.color);
        //stamp list for piece can move
        System.out.println(" which piece you want to move?\n pieces available:");
                
        movePossibility.forEach(el -> System.out.println(scacchiera.SearcSquare(el).getPiece().getTipe() + " in position " + el));
        System.out.println("\n please select the position to start now");
        Piece piece = scacchiera.SearcSquare(controlInList()).getPiece();


        List<String> pieceMuve = piece.movementPossibility(scacchiera.returnTable());

        System.out.println(piece.movementPossibility(scacchiera.returnTable()).toString());

        System.out.println("select now ");
        piece.move(scacchiera,pieceMuve,controlmove(pieceMuve));
        turn++;
    }

    public void moveCheck(List<String> posibility, String position){
        scacchiera.printTable();

        Piece piece = scacchiera.SearcSquare(position).getPiece();
        System.out.println(posibility.toString());

        System.out.println("select now ");
        piece.move(scacchiera,posibility,controlmove(posibility));
        turn++;
    }


    /*
     * check if the move is legal
     */
    public String controlInList(){

        String select = this.scan.next().toUpperCase();
    
        if( scacchiera.getListPicesAvaible(this.color).contains(select)){
            return select;
        }else{
            System.out.println("you cant this move, please try again");
            return controlInList();
        }  
        
    }

    public String controlmove(List<String> muvement){
        String select = this.scan.next().toUpperCase();
    
        if( muvement.contains(select)){
            return select;
        }else{
            return controlmove(muvement);
        }  

    }

}