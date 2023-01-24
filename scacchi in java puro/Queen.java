import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece{
    public Queen(boolean color,String position){
        super("queen",color? "QW":"QB",position,color);

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
        int[] up ={1,1};
        int[] below ={1,1};
        int[] left = {1,1};
        int[] right ={1,1};


        boolean upRight =false;
        boolean belowLeft =false;
        boolean upLeft = false;
        boolean belowRight =false;

        for (int i = 0; i < 9; i++) {
            if (upRight && belowLeft && upLeft && belowRight && up[1] == 0 && below[1] == 0 && left[1] == 0 && right[1] == 0) {
                break;
            }

            //control scor

            if (up[0] > 9 || up[0] < 0) {
                up[1] = 0;
            }

            if (below[0] > 9 || below[0] < 0) {
                below[1] = 0;
            }

            if (left[0] > 9 || left[0] < 0) {
                left[1] = 0;
            }

            if (right[0] > 9 || right[0] < 0) {
                right[1] = 0;
            }

            if (!upRight && vertical + up[0] < 9 && orizzontalInt + right[0] < 9) {
                if (!table[vertical + up[0]][orizzontalInt+right[0]].pieceEsist()) {
                    possibility.add((vertical + up[0]) + orizontalLocation[orizzontalInt+right[0]]);
                }else if(table[vertical + up[0]][orizzontalInt+right[0]].getPiece().color != this.color){
                    if (table[vertical + up[0]][orizzontalInt+right[0]].getPiece().isKing()) {
                    //    table[vertical + up[0]][orizzontalInt+right[0]].getPiece().check();
                    }
                    possibility.add((vertical + up[0]) + orizontalLocation[orizzontalInt+right[0]]);
                    upRight = !upRight;
                }else{
                    upRight = !upRight;
                }
            } 

            if (!belowRight && vertical - below[0] > 0 && orizzontalInt + right[0] < 9) {
                if (!table[vertical - below[0]][orizzontalInt + right[0]].pieceEsist()) {
                    possibility.add((vertical - below[0]) + orizontalLocation[orizzontalInt + right[0]]);
                }else if(table[vertical - below[0]][orizzontalInt + right[0]].getPiece().color != this.color){
                    if (table[vertical - below[0]][orizzontalInt+right[0]].getPiece().isKing()) {
                    //    table[vertical - below[0]][orizzontalInt+right[0]].getPiece().check();
                    }
                    possibility.add((vertical - below[0]) + orizontalLocation[orizzontalInt + right[0]]);
                    belowRight = !belowRight;
                }else{
                    belowRight = !belowRight;
                }

            } 

            if (!belowLeft && vertical - below[0] > 0 && orizzontalInt - left[0] > 0) {
                if (!table[vertical - below[0]][orizzontalInt - left[0]].pieceEsist()) {
                    possibility.add((vertical - below[0]) + orizontalLocation[orizzontalInt - left[0]]);
                }else if(table[vertical - below[0]][orizzontalInt - left[0]].getPiece().color != this.color){
                    if (table[vertical - below[0]][orizzontalInt - left[0]].getPiece().isKing()) {
                    //    table[vertical - below[0]][orizzontalInt+left[0]].getPiece().check();
                    }
                    possibility.add((vertical - below[0]) + orizontalLocation[orizzontalInt - left[0]]);
                    belowLeft = !belowLeft;
                }else{
                    belowLeft = !belowLeft;
                }

            } 

            if (!upLeft && vertical + up[0] <9 && orizzontalInt - left[0] > 0) {
                if (!table[vertical + up[0]][orizzontalInt - left[0]].pieceEsist()) {
                    possibility.add((vertical + up[0]) + orizontalLocation[orizzontalInt  - left[0]]);
                }else if(table[vertical + up[0]][orizzontalInt  - left[0]].getPiece().color != this.color){
                    if (table[vertical + up[0]][orizzontalInt-left[0]].getPiece().isKing()) {
                    //    table[vertical + up[0]][orizzontalInt+left[0]].getPiece().check();
                    }
                    possibility.add((vertical + up[0]) + orizontalLocation[orizzontalInt  - left[0]]);
                    upLeft = !upLeft;
                }else{
                    upLeft = !upLeft;
                }
            } 

            if (up[1] == 1 && vertical + up[0] < 9 ) {
                if (!table[vertical + up[0]][orizzontalInt].pieceEsist()) {
                    possibility.add((vertical + up[0]) + orizontalLocation[orizzontalInt]);
                }else if(table[vertical + up[0]][orizzontalInt].getPiece().color != this.color){
                    if (table[vertical +up[0]][orizzontalInt].getPiece().isKing()){
                        //    table[vertical +up[0]][orizzontalInt].getPiece().check();
                    }
                    possibility.add((vertical + up[0]) + orizontalLocation[orizzontalInt]);
                    up[1] = 0;
                }else{
                    up[1] = 0;
                }
            } 

            if (below[1] == 1 && vertical - below[0] > 0 ) {
                if (!table[vertical - below[0]][orizzontalInt].pieceEsist()) {
                    possibility.add((vertical - below[0]) + orizontalLocation[orizzontalInt]);
                }else if(table[vertical - below[0]][orizzontalInt].getPiece().color != this.color){
                    if (table[vertical - below[0]][orizzontalInt].getPiece().isKing()){
                     //    table[vertical - below[0]][orizzontalInt].getPiece().check();
                    }
                    possibility.add((vertical - below[0]) + orizontalLocation[orizzontalInt]);
                    below[1] = 0;
                }else{
                    below[1] = 0;
                }
            } 

            if (right[1] == 1 && orizzontalInt + right[0] < 9 ) {
                if (!table[vertical][orizzontalInt + right[0]].pieceEsist()) {
                    possibility.add(vertical + orizontalLocation[orizzontalInt + right[0]]);
                }else if(table[vertical][orizzontalInt + right[0]].getPiece().color != this.color){
                    if (table[vertical][orizzontalInt + right[0]].getPiece().isKing() ){
                    //    table[vertical][orizzontalInt + right[0]].getPiece().check();
                    }
                    possibility.add(vertical + orizontalLocation[orizzontalInt + right[0]]);
                    right[1] = 0;
                }else{
                    right[1] = 0;
                }
            } 

            if (left[1] == 1 && orizzontalInt - left[0] > 0 ) {
                if (!table[vertical][orizzontalInt - left[0]].pieceEsist()) {
                    possibility.add(vertical + orizontalLocation[orizzontalInt - left[0]]);
                }else if(table[vertical][orizzontalInt - left[0]].getPiece().color != this.color){
                    if (table[vertical][orizzontalInt-left[0]].getPiece().isKing() ){
                     //    table[vertical][orizzontalInt+left[0]].getPiece().check();
                    }
                    possibility.add(vertical + orizontalLocation[orizzontalInt - left[0]]);
                    left[1] = 0;
                }else{
                    left[1] = 0;
                }
            } 

            up[0]++;
            below[0]++;
            left[0]++;
            right[0]++;
        }



        return possibility;
    }
}
