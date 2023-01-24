
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Scacchiera {
    private Square[][] table = new Square[9][9];
    public String[] orizontalLocation = {" ","A","B","C","D","E","F","G","H"};
    private List<Piece> piecesWhite;
    private List<Piece> piecesBlack;
    private King kingWhite;
    private King kingBlack;
    private boolean winner;
    private Player player1;
    private Player player2;
    private boolean colorTurn; 
    private Scacchiera scacchiera;
    public String lastMove;

    

    public Scacchiera(){
        this.winner = false;
        for (int i = 0; i < 9; i++) {
            int swiccer = i % 2;

            for (int j = 0; j < 9; j++) {
                boolean color;

                if (i == 0 || j == 0) {
                    color = true;
                    String name = i == 0? " "+orizontalLocation[j]: " " + i;
                    FakePiece f = new FakePiece(color,i+orizontalLocation[j],name);
                    Square squ = new Square(color,i+orizontalLocation[j]);
                    squ.insertElement(f);
                    table[i][j] = squ;
                } else {
                    color = j % 2 == 0? true : false;
                    color = swiccer == 1? !color: color;
                    Square squ = new Square(color,i+orizontalLocation[j]);
                    table[i][j] = squ;
                }
            }  
        }
    
    }

    /*
    * function name -> controlPointer
    * @param ()
    * 
    * inside the function 
    * 1. call listPiece white and black and use for add pointer to Square
    */
    public void controlPointer(){
        piecesWhite.forEach(el -> {
           List<String> pM = el.movementPossibility(table);
           pM.forEach(mov -> SearcSquare(mov).addPointer(true));
        });
        piecesBlack.forEach(el -> {
            List<String> pM = el.movementPossibility(table);
            pM.forEach(mov -> SearcSquare(mov).addPointer(false));
         });
    }

    
    /*
     * the method getTable get's all square and concatenates 
     * and divides them by line thus creating the game board
     */
    public void printTable(){
        String[][] line = new String[9][3];

        for (int i = 0; i < table.length; i++) {
            line[i][0] = "";
            line[i][1] = "";
            line[i][2] = "";
            for (int j = 0; j < table[i].length; j++) {
                String[] base = table[i][j].getColorSquare();
                line[i][0] += base[0];
                line[i][1] += base[1];
                line[i][2] += base[2];
            }
            
        }
        
        //stamp table
        for (int i = 0; i < line.length; i++) {
            System.out.println(line[i][0]);
            System.out.println(line[i][1]);
            System.out.println(line[i][2]);
        }


    }

    /*
     * start game: generate al piece and start
     */
    public void newGame(){
        this.piecesWhite = new ArrayList<Piece>();
        this.piecesBlack = new ArrayList<Piece>();
        //pedestrian
        for (int i = 0; i <= 15; i++) {

            //true = white, false = black
            boolean color = i <= 7 ? true:false;
            String position = i <= 7? 7 + orizontalLocation[i+1]: 2 + orizontalLocation[i-7];
            Pedestrian p = new Pedestrian(color,position);

            //add to array for more controll piece
            if(i <= 7){
                piecesWhite.add(p);
            }else{
                piecesBlack.add(p);
            }
            SearcSquare(position).insertElement(p);
        }

        //tower
        Tower tW = new Tower(true, 8+"A");
        SearcSquare(tW.getIposition()).insertElement(tW);
        piecesWhite.add(tW);
        Tower tW2 = new Tower(true, 8+"H");
        SearcSquare(tW2.getIposition()).insertElement(tW2);
        piecesWhite.add(tW2);
        Tower tB = new Tower(false, 1+"A");
        SearcSquare(tB.getIposition()).insertElement(tB);
        piecesBlack.add(tB);
        Tower tB2 = new Tower(false, 1+"H");
        SearcSquare(tB2.getIposition()).insertElement(tB2);
        piecesBlack.add(tB2);

        //horse
        Horse hW = new Horse(true, 8+"B");
        SearcSquare(hW.getIposition()).insertElement(hW);
        piecesWhite.add(hW);
        Horse hW2 = new Horse(true, 8+"G");
        SearcSquare(hW2.getIposition()).insertElement(hW2);
        piecesWhite.add(hW2);
        Horse hB = new Horse(false, 1+"B");
        SearcSquare(hB.getIposition()).insertElement(hB);
        piecesBlack.add(hB);
        Horse hB2 = new Horse(false, 1+"G");
        SearcSquare(hB2.getIposition()).insertElement(hB2);
        piecesBlack.add(hB2);

        //Bishop
        Bishop BW = new Bishop(true, 8+"C");
        SearcSquare(BW.getIposition()).insertElement(BW);
        piecesWhite.add(BW);
        Bishop BW2 = new Bishop(true, 8+"F");
        SearcSquare(BW2.getIposition()).insertElement(BW2);
        piecesWhite.add(BW2);
        Bishop BB = new Bishop(false, 1+"C");
        SearcSquare(BB.getIposition()).insertElement(BB);
        piecesBlack.add(BB);
        Bishop BB2 = new Bishop(false, 1+"F");
        SearcSquare(BB2.getIposition()).insertElement(BB2);
        piecesBlack.add(BB2);

        //queen
        Queen qW = new Queen(true, 8+"D");
        SearcSquare(qW.getIposition()).insertElement(qW);
        piecesWhite.add(qW);
        Queen qB = new Queen(false, 1+"D");
        SearcSquare(qB.getIposition()).insertElement(qB);
        piecesBlack.add(qB);

        //king
        King kW = new King(true, 8+"E",tW,tW2);
        SearcSquare(kW.getIposition()).insertElement(kW);
        this.kingWhite = kW;
        piecesWhite.add(kW);
        King kB = new King(false, 1+"E",tB,tB2);
        SearcSquare(kB.getIposition()).insertElement(kB);
        this.kingBlack = kB;
        piecesBlack.add(kB);

        colorTurn = true;
        controlPointer();

        printTable();

        game();
    }
    

    //list of piece can move  :TODO----implement controll
    public List<String> getListPicesAvaible(Boolean playerColor){
        List<String> text = new ArrayList<String>();

        if (playerColor) {
            for (int i = 0; i < piecesWhite.size(); i++) {
                if(piecesWhite.get(i).movementPossibility(table)!=null&&piecesWhite.get(i).movementPossibility(table).size() > 0){
                    text.add(piecesWhite.get(i).getIposition());
                }  
            }
        } else {
            for (int i = 0; i < piecesBlack.size(); i++) {
                if(piecesBlack.get(i).movementPossibility(table)!=null&&piecesBlack.get(i).movementPossibility(table).size() > 0){
                    text.add(piecesBlack.get(i).getIposition());
                }
            }
        }
        return text; 
  
    }

    public boolean finish(){
        if (this.kingBlack.getCheck()) {
            if (kingBlack.checkPosibily(table).size() == 0 ) {
                this.winner = true;
            }
        }

        if (this.kingWhite.getCheck()) {
            if (kingWhite.checkPosibily(table).size() == 0 ) {
                this.winner = true;
            }
        }
        
        
        if(this.winner){
            System.out.println("scacco matto");
        }
        
        return this.winner;
    }

    public Square SearcSquare(String identify){
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                if (table[i][j].getIdentify().equals(identify)) {
                    return table[i][j];
                }
            }
        }
        return null;
    }

    /*
     * allows you to select the type of players
     */
    public void generateGamer(Scanner scan){
        System.out.println("menù \n1. P VS P \n2. P VS B \n3. B VS B ");
        int key = 0;
        boolean play1;
        boolean play2;
        while(true){
           
           if (scan.hasNextInt()) {
                key= scan.nextInt();
                if (key >= 1 && key <= 3) {
                    scan.nextLine();
                    break;                
                }else{
                    System.out.print("incorrect value try again");
                }

            }else {
                System.out.print("incorrect value try again");
            }
            
        }
        
        
        switch (key) {
            case 1:
            play1 = true;
            play2 = true;
                break;
            case 2:
            play1 = true;
            play2 = false;
                break;
            case 3:
            play1 = false;
            play2 = false;
                break;
        
            default:
            play1 = false;
            play2 = false;
                break;
        }
           

           
        if (play1) {
            this.player1 = new Player(true, this.scacchiera ,scan);
            if (play2) {
                this.player2 = new Player(false, this.scacchiera ,scan);
            } else{
                this.player2 = new Bot(false, scacchiera );
            } 
        } else {
            this.player1 = new Bot(true, scacchiera );
            this.player2 = new Bot(false, scacchiera );
        }
    }


    /*
     * the game controll
     */
    public void game(){
       Scanner scan = new Scanner(System.in);
       
       if (player1 == null) {
            generateGamer(scan);
        }
        
        if (colorTurn) {
            if(kingWhite.getCheck()){
                player1.moveCheck(kingWhite.checkPosibily(table),kingWhite.position); 
                kingWhite.setCheck(false);
            }else{
               player1.move(); 
            }
            
        }else{
            if(kingBlack.getCheck()){
                player1.moveCheck(kingBlack.checkPosibily(table),kingBlack.position); 
                kingWhite.setCheck(false);
            }else{
               player2.move(); 
            }
        }

        if (finish()) {
            scan.close();
            System.out.println();
        }else{
            colorTurn = !colorTurn;
            game();
        }
    }


    //getet and setter

    public void setScacchiera(Scacchiera scacchiera){
        this.scacchiera = scacchiera;
    }
    public Square[][] returnTable(){
        return table;
    }
    public void deletePieceInList(Piece p){
        System.out.println(p.getIdentify() + " it was eaten");
        if (p.getColor()) {
            this.piecesWhite.remove(p);
        } else {
            this.piecesBlack.remove(p);
        }
    }
}
