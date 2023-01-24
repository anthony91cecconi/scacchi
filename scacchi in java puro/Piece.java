import java.util.List;

public abstract class Piece {
    private String tipe;
    private String identify;
    protected String position;
    protected boolean color;
    protected String start;
    static final String[] orizontalLocation = {" ","A","B","C","D","E","F","G","H"};
    protected int movement;
    private boolean check;

    public Piece(String tipe,String identify,String position,boolean color){
        this.tipe = tipe;
        this.identify = identify;
        this.position = position;
        this.color = color;
        this.start = position;
        this.check = false;
        this.movement = 0;
    }

    public String getIdentify(){
        return identify;
    }

    public String getIposition(){
        return position;
    }

    public boolean getColor(){
        return color;
    }

    /*
     * name function move
     * @param (Scacchiera, List<String>, String)
     * 
     * inside function
     * 1. if the movement in string form is among the permitted ones, it proceeds with the movement. else is a error
     * 2. control square if this have a piece, remove piece and add new piece
     */
    public void move(Scacchiera scacchiera,List<String> list,String mov){;
        if( list.contains(mov) ){
            Square movControl = scacchiera.SearcSquare(mov);
            if (movControl.pieceEsist()) {
                movControl.getPiece().removePosition();
                scacchiera.deletePieceInList(movControl.getPiece());
            }

            System.out.println(this.position + " in " + mov );

            scacchiera.SearcSquare(mov).insertElement( scacchiera.SearcSquare(position).getPiece());
            scacchiera.SearcSquare(position).deletElement();
            this.position = mov;
            movementPossibility( scacchiera.returnTable());
            scacchiera.lastMove = mov;
        }else{
            System.out.println("fail... ");

        }

        
    }

    public List<String> checkPosibily(Square[][] table, List<String> heros ){
        List<String> movKingSave = List.copyOf(movementPossibility(table));
        movKingSave.addAll(movKingSave);

        return movKingSave;
    }

    public boolean isKing(){
        boolean result = this.tipe.equals("king")? true:false;

            if (result) {
                System.out.println("this king is in check " + this.position + " save him" ); 
                check();
            }

        return result;
    }


    public Square SearcSquare(String identify, Square[][] table){
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                if (table[i][j].getIdentify().equals(identify)) {
                    return table[i][j];
                }
            }
        }
        return null;
    }


    abstract List<String> movementPossibility(Square[][] table);

    // getter and setter

    public boolean getCheck(){
        return this.check;
    }

    private void check(String Last){
        this.lastMove = last;
        this.check = !this.check;
    }

    public void removePosition(){
        this.position = "";
    }

    public String getTipe() {
        return this.tipe;
    }

    public int getMovement() {
        return movement;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
}
