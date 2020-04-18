//package model;
///**
//* @author: Charlie Gorrill
//* Organization: NHCC OOP Class
//* Description: A Bot is a sumulation of a robot
//* that will be used on a map.  Robots can move and turn.
//* The intention is to explore OOP concepts through working
//* with Bots and Maps together
//* */
//public abstract class Bot extends Entity implements Movable{
//
//    /**
//     * SLOW_SPEED will be used to set the speed of a
//     * Bot to one space per call to the move method
//     * */
//    /**
//     * direction repesents the direction that
//     * the Bot is facing.  direction can hold
//     * 0-3 inclusive.
//     * */
//    private Directions direction;
//    /**
//     * moveSpeed indicates how many spaces a
//     * Bot will move when the move() method is called
//     * */
//    private int moveSpeed;
//
//
//    /**
//     * initialize all instance variables.
//     * The Bot has a Location, id, direction, and moveSpeed
//     * */
//    public Bot(Location l, int id, Directions dir){
//        super(l, id);
//        this.direction=dir;
//        moveSpeed=SLOW_SPEED;
//    }
//
//    /**
//     * move the Bot in the direction
//     * that the Bot is facing.  The Bot
//     * will move moveSpeed spaces on the
//     * map
//     * */
//    public boolean move(Map m){
//        boolean validUp=validMove(m, getLoc().getRow()-moveSpeed, getLoc().getCol());
//        boolean validDown=validMove(m, getLoc().getRow()+moveSpeed, getLoc().getCol());
//        boolean validRight=validMove(m, getLoc().getRow(), getLoc().getCol()+moveSpeed);
//        boolean validLeft=validMove(m, getLoc().getRow(), getLoc().getCol()-moveSpeed);
//        boolean botMoved=false;
//
//        if(direction==Directions.UP&&validUp){
//            getLoc().setRow(getLoc().getRow()-moveSpeed);
//            botMoved=true;
//        }
//        else if(direction==Directions.RIGHT&&validRight){
//            getLoc().setCol(getLoc().getCol()+moveSpeed);
//            botMoved=true;
//        }
//        else if(direction==Directions.DOWN&&validDown){
//            getLoc().setRow(getLoc().getRow()+moveSpeed);
//            botMoved=true;
//        }
//        else if(direction==Directions.LEFT&&validLeft){
//            getLoc().setCol(getLoc().getCol()-moveSpeed);
//            botMoved=true;
//        }
//        else{
//            System.out.println("Invalid move!");
//
//        }
//        return botMoved;
//    }
//
//
//    public boolean validMove(Map m, int row, int col){
//        boolean validRow=validRow(m, row);
//        boolean validCol=validCol(m, col);
//        boolean cellNotOccupied=false;
//        if(validCol&&validRow){
//            cellNotOccupied=m.getBotMap()[row][col]==null;
//        }
//        return validCol&&validRow&&cellNotOccupied&&movePathClear(m);
//    }
//
//    public boolean validCol(Map m,int col){
//        return col>=0&&col<Map.NUM_COLS;
//    }
//    public boolean validRow(Map m,int row){
//        return row>=0&&row<Map.NUM_ROWS;
//    }
//    public boolean movePathClear(Map m){
//        int distance=moveSpeed;
//
//        int count=1;
//        boolean pathClear=true;
//
//        if(distance>botDistanceFromEdge())
//            pathClear=false;
//
//        while(count<=distance&&pathClear){
//
//            if(direction==Directions.UP){
//                pathClear=m.getBotMap()[getLoc().getRow()-count][getLoc().getCol()] ==null;
//                count++;
//            }
//            else if(direction==Directions.DOWN){
//                pathClear=m.getBotMap()[getLoc().getRow()+count][getLoc().getCol()] ==null;
//                count++;
//            }
//            else if(direction==Directions.LEFT){
//                pathClear=m.getBotMap()[getLoc().getRow()][getLoc().getCol()-count] ==null;
//                count++;
//            }
//            else if(direction==Directions.RIGHT){
//                pathClear=m.getBotMap()[getLoc().getRow()][getLoc().getCol()+count] ==null;
//                count++;
//            }
//
//        }
//
//        return pathClear;
//    }
//
//    public int botDistanceFromEdge(){
//        int distance=0;
//
//        switch(getDirection()){
//            case UP:
//                distance=getLoc().getRow();
//                break;
//            case LEFT:
//                distance=getLoc().getCol();
//                break;
//            case RIGHT:
//                distance=Map.NUM_COLS-1-getLoc().getCol();
//                break;
//            case DOWN:
//                distance=Map.NUM_ROWS-1-getLoc().getRow();
//                break;
//        }
//        return distance;
//    }
//
//    /**
//     * Turn the Bot 90 degrees clockwise
//     * */
//    public void turn(){
//        if(direction.compareTo(Directions.LEFT)<0){
//            direction= Movable.getNextDirection(direction);
//        }
//        else{
//            direction=Directions.UP;
//        }
//    }
//
//    public void setMoveSpeed(int moveSpeed) {
//        this.moveSpeed = moveSpeed;
//    }
//
//    public int getMoveSpeed() {
//        return moveSpeed;
//    }
//
//    public Directions getDirection() {
//        return direction;
//    }
//
//    public void setDirection(Directions direction) {
//        this.direction = direction;
//    }
//
//    @Override
//    public String toString(){
//        return super.toString()+" Bot ["+
//                " Direction: "+direction+" Speed: "+moveSpeed+"]";
//    }
//}
package model;

/**
 * @author: Charlie Gorrill
 * Organization: NHCC OOP Class
 * Description: A model.Bot is a sumulation of a robot
 * that will be used on a map.  Robots can move and turn.
 * The intention is to explore OOP concepts through working
 * with Bots and Maps together
 * */
public abstract class Bot extends Entity implements Movable{

    /**
     * SLOW_SPEED will be used to set the speed of a
     * model.Bot to one space per call to the move method
     * */
    /**
     * direction repesents the direction that
     * the model.Bot is facing.  direction can hold
     * 0-3 inclusive.
     * */
    private Directions direction;
    /**
     * moveSpeed indicates how many spaces a
     * model.Bot will move when the move() method is called
     * */
    private int moveSpeed;


    /**
     * initialize all instance variables.
     * The model.Bot has a model.Location, id, direction, and moveSpeed
     * */
    public Bot(Location l, int id, Directions dir){
        super(l, id);
        this.direction=dir;
        moveSpeed=SLOW_SPEED;
    }

    /**
     * move the model.Bot in the direction
     * that the model.Bot is facing.  The model.Bot
     * will move moveSpeed spaces on the
     * map
     * */
    public boolean move(Map m){
        boolean botMoved=false;
        if(validBotMove(m)) {
            moveNumSpaces(moveSpeed);
            botMoved=true;
        } else {
            System.out.println("Invalid move!");
        }
        return botMoved;
    }

    public void moveNumSpaces(int spaces){
        if (direction == Directions.UP) {
            getLoc().setRow(getLoc().getRow() - spaces);
        } else if (direction == Directions.RIGHT) {
            getLoc().setCol(getLoc().getCol() + spaces);
        } else if (direction == Directions.DOWN) {
            getLoc().setRow(getLoc().getRow() + spaces);
        } else if (direction == Directions.LEFT) {
            getLoc().setCol(getLoc().getCol() - spaces);
        }
    }

    public boolean validBotMove(Map m){
        boolean valid;
        if(direction==Directions.UP){
            valid= validCell(m, getLoc().getRow()-moveSpeed, getLoc().getCol())&&movePathClear(m);
        }
        else if(direction==Directions.DOWN){
            valid= validCell(m, getLoc().getRow()+moveSpeed, getLoc().getCol())&&movePathClear(m);
        }
        else if(direction==Directions.RIGHT){
            valid= validCell(m, getLoc().getRow(), getLoc().getCol()+moveSpeed)&&movePathClear(m);
        }
        else{
            valid= validCell(m, getLoc().getRow(), getLoc().getCol()-moveSpeed)&&movePathClear(m);
        }
        return valid;
    }

    public boolean validCell(Map m, int row, int col){
        boolean validRow=validRow(m, row);
        boolean validCol=validCol(m, col);
        boolean cellNotOccupied=false;
        if(validCol&&validRow){
            cellNotOccupied=m.getBotMap()[row][col]==null;
        }
        return validCol&&validRow&&cellNotOccupied;
    }

    public boolean validCol(Map m,int col){
        return col>=0&&col<Map.NUM_COLS;
    }
    public boolean validRow(Map m,int row){
        return row>=0&&row<Map.NUM_ROWS;
    }

    public boolean movePathClear(Map m){
        int distance=moveSpeed;

        int count=1;
        boolean pathClear=true;

        if(distance>botDistanceFromEdge())
            pathClear=false;

        while(count<=distance&&pathClear){

            if(direction==Directions.UP){
                pathClear=m.getBotMap()[getLoc().getRow()-count][getLoc().getCol()] ==null;
                count++;
            }
            else if(direction==Directions.DOWN){
                pathClear=m.getBotMap()[getLoc().getRow()+count][getLoc().getCol()] ==null;
                count++;
            }
            else if(direction==Directions.LEFT){
                pathClear=m.getBotMap()[getLoc().getRow()][getLoc().getCol()-count] ==null;
                count++;
            }
            else if(direction==Directions.RIGHT){
                pathClear=m.getBotMap()[getLoc().getRow()][getLoc().getCol()+count] ==null;
                count++;
            }

        }

        return pathClear;
    }

    /*
     * @return the distance to the nearest entity in this BOt's direction
     * if no bots are in the path return -1
     * */
    public int botDistanceToEntity(Map m){
        int distance=-1;
        int closest=botDistanceFromEdge();
        int row=getLoc().getRow();
        int col=getLoc().getCol();
        for(Entity e:m.getBots()) {
            System.out.println(e);
            int eRow=e.getLoc().getRow();
            int eCol=e.getLoc().getCol();
            if(this!=e) {
                if ((direction == Directions.UP || direction == Directions.DOWN) && (col == eCol)) {
                    distance = Math.abs(row - eRow);
                    System.out.println("distance: "+distance);
                } else if ((direction == Directions.LEFT || direction == Directions.RIGHT) && (row == eRow)) {
                    distance = Math.abs(col - eCol);
                    System.out.println("distance: "+distance);
                }
                if(distance<=closest){
                    closest=distance;
                }
            }
        }
        System.out.println("return closest:"+closest);
        return closest;
    }

    public int botDistanceFromEdge(){
        int distance=0;

        switch(getDirection()){
            case UP:
                distance=getLoc().getRow();
                break;
            case LEFT:
                distance=getLoc().getCol();
                break;
            case RIGHT:
                distance=Map.NUM_COLS-1-getLoc().getCol();
                break;
            case DOWN:
                distance=Map.NUM_ROWS-1-getLoc().getRow();
                break;
        }
        return distance;
    }

    /**
     * Turn the model.Bot 90 degrees clockwise
     * */
    public void turn(){
        if(direction.compareTo(Directions.LEFT)<0){
            direction= Movable.getNextDirection(direction);
        }
        else{
            direction=Directions.UP;
        }
    }

    public void setMoveSpeed(int moveSpeed) {
        this.moveSpeed = moveSpeed;
    }

    public int getMoveSpeed() {
        return moveSpeed;
    }

    public Directions getDirection() {
        return direction;
    }

    public void setDirection(Directions direction) {
        this.direction = direction;
    }

    @Override
    public String toString(){
        return super.toString()+" model.Bot ["+
                " Direction: "+direction+" Speed: "+moveSpeed+"]";
    }
}