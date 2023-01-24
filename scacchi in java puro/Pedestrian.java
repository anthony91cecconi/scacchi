import java.util.ArrayList;
import java.util.List;

public class Pedestrian extends Piece{


    public Pedestrian(boolean color,String position){
        super("pedestrian",color? "PW":"PB",position,color);
    }


    @Override
    List<String> movementPossibility(Square[][] table) {
        List<String> possibility=new ArrayList<String>();

        String[] posistionArray = position.split(""); 
        int vertical = Integer.parseInt(posistionArray[0]);
        String orizzontal = posistionArray[1];
        int orizzontalInt = 0;

        for (int i = 0; i < orizontalLocation.length; i++) {
            if (orizontalLocation[i].equals(orizzontal)) {
                orizzontalInt = i;
                break;
            }
        }

        if (vertical-1 > 0 && color &&table[(vertical - 1)][orizzontalInt].getPiece()==null) {
            possibility.add((vertical - 1) + orizzontal);
        }else if(vertical+1 < 9 && table[(vertical + 1)][orizzontalInt].getPiece()==null){
            possibility.add((vertical + 1) + orizzontal);
        }  
        
        if(position.equals(start)){
            //color true = white / false = black
            if (color && table[(vertical - 2)][orizzontalInt].getPiece()==null) {
                possibility.add((vertical - 2) + orizzontal);
            }else if(color == false && table[(vertical + 2)][orizzontalInt].getPiece()==null){
                possibility.add((vertical + 2) + orizzontal);
            }
        }


        //eat mode
        if (this.color) {

            if (vertical-1>0&&(orizzontalInt+1)<9 && table[vertical - 1][orizzontalInt + 1].pieceEsist() && table[vertical - 1][orizzontalInt + 1].getPiece().getColor() != this.color) {
                if (table[vertical - 1][orizzontalInt+1].getPiece().isKing()) {
                //    table[vertical - 1][orizzontalInt+1].getPiece().check();
                }
                possibility.add((vertical - 1) + orizontalLocation[orizzontalInt +1]);
            }
            
            if(vertical-1 >0&&(orizzontalInt-1)<0 && table[vertical - 1][orizzontalInt - 1].pieceEsist() && table[vertical - 1][orizzontalInt - 1].getPiece().getColor() != this.color){
                if (table[vertical - 1][orizzontalInt-1].getPiece().isKing()) {
                //    table[vertical - 1][orizzontalInt-1].getPiece().check();
                }
                possibility.add((vertical - 1) + orizontalLocation[orizzontalInt -1]);
            }
        }else{
            if(vertical+1 < 9&&orizzontalInt+1 < 9 && table[vertical + 1][orizzontalInt + 1].pieceEsist() && table[vertical + 1][orizzontalInt + 1].getPiece().getColor() != this.color){
                if (table[vertical + 1][orizzontalInt+1].getPiece().isKing()) {
                //    table[vertical + 1][orizzontalInt+1].getPiece().check();
                }
                possibility.add((vertical + 1) + orizontalLocation[orizzontalInt +1]);
            }
            
            if(vertical+1 < 9&&(orizzontalInt-1)<0 && table[vertical + 1][orizzontalInt - 1].pieceEsist() && table[vertical + 1][orizzontalInt - 1].getPiece().getColor() != this.color){
                if (table[vertical + 1][orizzontalInt-1].getPiece().isKing()) {
                //    table[vertical + 1][orizzontalInt-1].getPiece().check();
                }
                possibility.add((vertical + 1) + orizontalLocation[orizzontalInt -1]);
            }
        }


        
           

       
        

        return possibility;
    }
}
