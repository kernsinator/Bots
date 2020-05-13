package model;

import java.util.ArrayList;

public class KillerBot extends FlexibleBot{
    private int tolerance;

    public KillerBot(Location loc, int id, Directions dir, int moveSpeed, int tolerance) {
        super(loc, id, dir, moveSpeed);
        this.tolerance = tolerance;
    }

    @Override
    public boolean move(Map m) {
        boolean moved=super.move(m);//call on move() from Bot
        int spacesToMove=getMoveSpeed();
        int turnCount=0;
        int distance=distanceToEntityOrEdge(m);
        //do flex move
        if(!moved){
            while(spacesToMove>0&&turnCount<4) {
                if(!movePathClear(m)&&botDistanceToEntity(m)<getMoveSpeed()){
                    turn();
                    turnCount++;
                }//turned
                else{
                    if(spacesToMove>=distance){
                        moveNumSpaces(distance);
                        spacesToMove-=distance;
                    }
                    else{
                        moveNumSpaces(spacesToMove);
                        spacesToMove-=spacesToMove;
                    }
                    turnCount=0;
                }//moved
                distance=distanceToEntityOrEdge(m);
            }//end while
            moved=turnCount<4;
        }

        return moved;
    }

    public Bot killBot(Bot closestBot, Map m) {
        Bot killed = closestBot;
        m.removeBotFromMap(killed);
        m.removeBotFromList(killed);

        return killed;
    }

    public int getIndexOfClosestBot(ArrayList<Bot> bots){
        int min=tolerance+1;
        int indexOfMin=0;

        for(int i=0; i<bots.size(); i++){
            int distance=distance(bots.get(i));
            if(distance<min){
                min=distance;
                indexOfMin=i;
            }
        }

        return indexOfMin;
    }

    public int distance(Bot b){
        int distance=0;
        int y1=b.getLoc().getRow(), y2=getLoc().getRow();
        int x1=b.getLoc().getCol(), x2=getLoc().getCol();

        distance=(int)(Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2)));

        return distance;
    }

    public ArrayList<Bot> getBotsInRange(Map map){
        ArrayList<Bot> bots=new ArrayList<>();
        ArrayList<Entity> ents=map.getBots();

        //find all bots within tolerance
        for(Entity e: ents){
            int distance=distance((Bot)e);
            if(distance<=tolerance&&e instanceof Bot){
                bots.add((Bot)e);
            }
        }

        return bots;
    }

//
//    public ArrayList<Bot> getBotsInRange(Map map){
//        ArrayList<Bot> bots=new ArrayList<>();
//
//        for(int i=getLoc().getRow()-tolerance; i<=getLoc().getRow()+tolerance; i++){
//            for(int j=getLoc().getCol()-tolerance; j<=getLoc().getCol()+tolerance; j++){
//                if(validCol(map, j)&&validRow(map,i)){
//                    if(map.getBotMap()[i][j]!=null&&map.getBotMap()[i][j] instanceof Bot){
//                        bots.add((Bot)map.getBotMap()[i][j]);
//                    }//get botsx
//                }//cell validity check
//            }//inner loop
//        }//outer loop
//
//        return bots;
//    }//end method
}
