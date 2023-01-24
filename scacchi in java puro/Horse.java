import java.util.ArrayList;
import java.util.List;

public class Horse extends Piece{
    public Horse(boolean color,String position){
        super("horse",color? "HW":"HB",position,color);

    }


    @Override
    List<String> movementPossibility(Square[][] table) {
        List<String> possibility=new ArrayList<String>();

        String[] posistionArray = position.split(""); 
        int vertical = Integer.parseInt(posistionArray[0]);
        String orizzontal = posistionArray[1];
        int orInt = 0;

        for (int i = 0; i < orizontalLocation.length; i++) {
            if (orizontalLocation[i].equals(orizzontal)) {
                orInt = i;
                break;
            }
        }

        if ( (vertical+2)>0
        && (vertical+2)<9
        && (orInt+1)>0
        && (orInt+1)<9 ) 
        {
            Square squ = table[vertical + 2][orInt +1];
            if (squ.pieceEsist() && !(squ.getPiece().getColor() == this.color)) {
                if (squ.getPiece().isKing()) {
                //    squ.getPiece().check();
                }
                possibility.add((vertical +2) + orizontalLocation[orInt+1]);

            }else if(!(squ.pieceEsist())){
                possibility.add((vertical +2) + orizontalLocation[orInt+1]);
            }
            
        }
        
        if ( (vertical+1)>0
        && (vertical+1)<9
        && (orInt+2)>0
        && (orInt+2)<9) 
        {
            Square squ =table[vertical+1][orInt +2] ;
            if (squ.pieceEsist() && !(squ.getPiece().getColor() == this.color)) {
                if (squ.getPiece().isKing()) {
                //    squ.getPiece().check();
                }
                possibility.add((vertical +1) + orizontalLocation[orInt+2]);

            }else if(!(squ.pieceEsist())){
                possibility.add((vertical +1) + orizontalLocation[orInt+2]);
            }
        }
    
        if( (vertical-1)>0
        && (vertical-1)<9
        && (orInt+2)>0
        && (orInt+2)<9) 
        {
            Square squ = table[vertical-1][orInt +2];
            if (squ.pieceEsist() && !(squ.getPiece().getColor() == this.color)) {
                if (squ.getPiece().isKing()) {
                //    squ.getPiece().check();
                }
                possibility.add((vertical -1) + orizontalLocation[orInt+2]);

            }else if(!(squ.pieceEsist())){
                possibility.add((vertical -1) + orizontalLocation[(orInt+2)]);
            }
        }
    
        if( (vertical-2)>0
        && (vertical-2)<9
        && (orInt+1)>0
        && (orInt+1)<9)
        {
            Square squ = table[vertical-2][orInt +1];
            if (squ.pieceEsist() && !(squ.getPiece().getColor() == this.color)) {
                if (squ.getPiece().isKing()) {
                //    squ.getPiece().check();
                }
                possibility.add((vertical -2) + orizontalLocation[orInt+1]);

            }else if(!(squ.pieceEsist())){
                possibility.add((vertical -2) + orizontalLocation[orInt+1]);
            }
        }
    
        if( (vertical-2)>0
        && (vertical-2)<9
        && (orInt-1)>0
        && (orInt-1)<9) 
        {
            Square squ = table[vertical-2][orInt -1];
            if (squ.pieceEsist() && !(squ.getPiece().getColor() == this.color)) {
                if (squ.getPiece().isKing()) {
                //    squ.getPiece().check();
                }
                possibility.add((vertical -2) + orizontalLocation[orInt-1]);

            }else if(!(squ.pieceEsist())){
                possibility.add((vertical -2) + orizontalLocation[orInt-1]);
            }
        }
    
        if( (vertical-1)>0
        && (vertical-1)<9
        && (orInt-2)>0
        && (orInt-2)<9) 
        {
            Square squ = table[vertical-1][orInt -2];
            
            if (squ.pieceEsist() && !(squ.getPiece().getColor() == this.color)) {
                if (squ.getPiece().isKing()) {
                //    squ.getPiece().check();
                }
                possibility.add((vertical -1) + orizontalLocation[orInt-2]);

            }else if(!(squ.pieceEsist())){
                possibility.add((vertical -1) + orizontalLocation[orInt-2]);
            }
        }
        
        if( (vertical+1)>0
        && (vertical+1)<9
        && (orInt-2)>0
        && (orInt-2)<9) 
        {
            Square squ = table[vertical+1][orInt -2];
            if (squ.pieceEsist() && !(squ.getPiece().getColor() == this.color)) {
                if (squ.getPiece().isKing()) {
                //    squ.getPiece().check();
                }
                possibility.add((vertical +1) + orizontalLocation[orInt-2]);

            }else if(!(squ.pieceEsist())){
                possibility.add((vertical +1) + orizontalLocation[orInt-2]);
            }
        }
    
        if( (vertical+2)>0
        && (vertical+2)<9
        && (orInt-1)>0
        && (orInt-1)<9) 
        {
            Square squ = table[vertical+2][orInt -1];
            
            if (squ.pieceEsist() && !(squ.getPiece().getColor() == this.color)) {
                if (squ.getPiece().isKing()) {
                //    squ.getPiece().check();
                }
                possibility.add((vertical +2) + orizontalLocation[orInt-1]);

            }else if(!(squ.pieceEsist())){
                possibility.add((vertical +2) + orizontalLocation[orInt-1]);
            }
        }

        return possibility;
    }
}
