public class Square {

    private String[] colorSquare;
    private String identify;
    private boolean color;
    private Piece p;
    private int pointerWhite;
    private int pointerBlack;


    public Square(boolean color,String identify){
        setColorsquare(color);
        this.identify = identify;
        this.color = color;
        this.pointerWhite = 0;
        this.pointerBlack = 0;
    }
    
    public String[] getColorSquare(){
        return this.colorSquare;
    }

    /*
     *  set color square in 2 case, black and whithe layout stile.
     */
    public void setColorsquare(boolean color){
        this.colorSquare = new String[4];

        if (color) {
            //white square
            colorSquare[0] = "#----#";
            colorSquare[1] = "|    |";
            colorSquare[2] = "#----#";
        } else {
            // black square
            colorSquare[0] = "//////";
            colorSquare[1] = "//////";
            colorSquare[2] = "//////";
        }

    }

    public String getIdentify(){
        return this.identify;
    }

    /*
     * name function -> removePointer
     * @param (boolean)- true is color white, false is color black
     * 
     * 1 restart pointer of a square for new calculation
     */
    public void reatrtPointer(boolean color){
        if (color) {
            this.pointerWhite--;
        }else{
            this.pointerBlack--;
        }
    }

    /*
     * name function -> addPointer
     * @param (boolean) true = white , false = black
     *
     * inside the function
     * 1 add 1 more point to pointer
     */
    public void addPointer(boolean color){
        if (color) {
            this.pointerWhite++;
        } else {
            this.pointerBlack++;
        }
    }

    public int getPointerEnemy(boolean color) {
        if (color) {
            return this.pointerBlack;
        }else{
            return this.pointerWhite;
        }
    }
    
    public int getPointerAlly(boolean color) {
        if (!color) {
            return this.pointerBlack;
        }else{
            return this.pointerWhite;
        }
    }

    public void insertElement(Piece newP){
        
        this.p = newP;

        if (color) {
            //white square
            colorSquare[1] = "| "+ this.p.getIdentify() +" |";
        } else {
            // black square
            colorSquare[1] = "//"+ this.p.getIdentify() +"//";
        }
    }
    public void deletElement(){
        p = null ;

        if (color) {
            //white square
            colorSquare[1] = "|    |";
        } else {
            // black square
            colorSquare[1] = "//////";
        }
    }

    public Piece getPiece(){
        return p;
    }

    public boolean pieceEsist(){
        
        return this.p == null? false:true;
    }

}

