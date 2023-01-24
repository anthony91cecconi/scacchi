import java.util.ArrayList;
import java.util.List;

public class Tower extends Piece {

    public Tower(boolean color,String position){
        super("tower",color? "TW":"TB",position,color);

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

        for (int i = 0; i < 9; i++) {
            if (up[1] == 0 && below[1] == 0 && left[1] == 0 && right[1] == 0) {
                break;
            }

            if (up[1] == 1 && vertical + up[0] < 9 ) {
                if (!table[vertical + up[0]][orizzontalInt].pieceEsist()) {
                    possibility.add((vertical + up[0]) + orizontalLocation[orizzontalInt]);
                }else if(table[vertical + up[0]][orizzontalInt].getPiece().color != this.color){
                    if (table[vertical + up[0]][orizzontalInt].getPiece().isKing()) {
                    //    table[vertical + up[0]][orizzontalInt].getPiece().check();
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
                    if (table[vertical - below[0]][orizzontalInt].getPiece().isKing()) {
                       // table[vertical - below[0]][orizzontalInt].getPiece().check();
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
                    if (table[vertical][orizzontalInt+right[0]].getPiece().isKing()) {
                     //   table[vertical][orizzontalInt+right[0]].getPiece().check();
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
                    if (table[vertical][orizzontalInt-left[0]].getPiece().isKing()) {
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
