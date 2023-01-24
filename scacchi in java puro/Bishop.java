import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece{
    public Bishop(boolean color,String position){
        super("bishop",color? "BW":"BB",position,color);

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

        /*
         * value for control the moove of tower
         * var[0] is number for the square in table
         * var[1] is param for true or false 1 is true and the if can run, 0 is false and stop relative if
         */
        int up =1;
        int below =1;
        int left = 1;
        int right =1;

        boolean upRight =false;
        boolean belowLeft =false;
        boolean upLeft = false;
        boolean belowRight =false;

        for (int i = 0; i < 9; i++) {
            if (upRight && belowLeft && upLeft && belowRight) {
                break;
            }

            if (up > 9 || up < 0) {
                upRight = true;
                upLeft = true;
            }

            if (below > 9 || below < 0) {
                belowLeft = true;
                belowRight = true;
            }

            if (left > 9 || left < 0) {
                belowLeft = true ;
                upLeft = true;
            }

            if (right > 9 || right < 0) {
                upRight=true;
                belowRight = true;
            }


            if (!upRight && vertical + up < 9 && orizzontalInt + right < 9) {
                if (!table[vertical + up][orizzontalInt+right].pieceEsist()) {
                    possibility.add((vertical + up) + orizontalLocation[orizzontalInt+right]);
                }else if(table[vertical + up][orizzontalInt+right].getPiece().color != this.color){
                    if (table[vertical + up][orizzontalInt+right].getPiece().isKing()) {
                       
                    }
                    possibility.add((vertical + up) + orizontalLocation[orizzontalInt+right]);
                    upRight = !upRight;
                }else{
                    upRight = !upRight;
                }
            } 

            if (!belowRight && vertical - below > 0 && orizzontalInt + right < 9) {
                if (!table[vertical - below][orizzontalInt + right].pieceEsist()) {
                    possibility.add((vertical - below) + orizontalLocation[orizzontalInt + right]);
                }else if(table[vertical - below][orizzontalInt + right].getPiece().color != this.color){
                    if (table[vertical - below][orizzontalInt+right].getPiece().isKing()) {
                    //    table[vertical - below][orizzontalInt+right].getPiece().check();
                    }
                    possibility.add((vertical - below) + orizontalLocation[orizzontalInt + right]);
                    belowRight = !belowRight;
                }else{
                    belowRight = !belowRight;
                }

            } 

            if (!belowLeft && vertical - below > 0 && orizzontalInt + left < 9) {
                if (!table[vertical - below][orizzontalInt + left].pieceEsist()) {
                    possibility.add((vertical - below) + orizontalLocation[orizzontalInt + left]);
                }else if(table[vertical - below][orizzontalInt + left].getPiece().color != this.color){
                    if (table[vertical - below][orizzontalInt + left].getPiece().isKing()) {
                    //    table[vertical - below][orizzontalInt - left].getPiece().check();
                    }
                    possibility.add((vertical - below) + orizontalLocation[orizzontalInt + left]);
                    belowLeft = !belowLeft;
                }else{
                    belowLeft = !belowLeft;
                }

            } 

            if (!upLeft && vertical + up <9 && orizzontalInt + left<9) {
                if (!table[vertical + up][orizzontalInt + left].pieceEsist()) {
                    possibility.add((vertical + up) + orizontalLocation[orizzontalInt + left]);
                }else if(table[vertical + up][orizzontalInt + left].getPiece().color != this.color){
                    if (table[vertical + up][orizzontalInt + left].getPiece().isKing()) {
                     //   table[vertical + up][orizzontalInt - left].getPiece().check();
                    }
                    possibility.add((vertical + up) + orizontalLocation[orizzontalInt + left]);
                    upLeft = !upLeft;
                }else{
                    upLeft = !upLeft;
                }
            } 

            up++;
            below++;
            left++;
            right++;
        }



        return possibility;
    }
}
