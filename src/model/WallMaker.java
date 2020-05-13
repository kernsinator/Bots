/*
 * Tyler Kerns
 */

package model;

import java.util.ArrayList;

public class WallMaker extends FlexibleBot {
    public WallMaker(Location loc, int id, Movable.Directions dir, int moveSpeed) {
        super(loc, id, dir, moveSpeed);
    }

    @Override
    public boolean move(Map m) {
        Location temp = this.getLoc();
        int col = this.getLoc().getCol();
        int row = this.getLoc().getRow();
        boolean moved = super.move(m);//call on move() from Bot
        int spacesToMove = getMoveSpeed();
        int turnCount = 0;
        int distance = distanceToEntityOrEdge(m);
        //do flex move
        if (!moved) {
            while (spacesToMove > 0 && turnCount < 4) {
                if (distance == 0) {
                    turn();
                    turnCount++;
                }//turned
                else {
                    if (spacesToMove >= distance) {
                        moveNumSpaces(distance);
                        spacesToMove -= distance;
                    } else {
                        moveNumSpaces(spacesToMove);
                        spacesToMove -= spacesToMove;
                    }
                    turnCount = 0;
                }//moved
                distance = distanceToEntityOrEdge(m);
            }//end while
            moved = turnCount < 4;
        }

        Wall w = new Wall(new Location(row, col), 99, false, false, true);
        ArrayList<Entity> bots = m.getBots();
        bots.add(w);
        m.setBots(bots);
        return moved;
    }
}
