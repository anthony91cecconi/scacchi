import java.util.List;

public class FakePiece extends Piece{

    private String name;

    public FakePiece(boolean color,String position,String name){
        super("bishop", name ,position,color);
        this.name = name;
    }

    @Override
    List<String> movementPossibility(Square[][] table) {
        // TODO Auto-generated method stub
        return null;
    }

    
}
