package tests;

import controllers.GUIControl;
import model.*;
import view.GUIPanel;
import view.MapPanel;
import view.ViewFrame;

import java.util.ArrayList;

public class TestGUI {
    public static void main(String[] args) {
        ArrayList<Entity> bots=new ArrayList<>();
        bots.add(new FlexibleBot(new Location(0,0), 25, Movable.Directions.DOWN, Bot.FAST_SPEED));
        bots.add(new FlexibleBot(new Location(5,5), 32, Movable.Directions.DOWN, Bot.SLOW_SPEED));
        bots.add(new FlexibleBot(new Location(4,2), 45, Movable.Directions.DOWN, Bot.SLOW_SPEED));
        bots.add(new KillerBot(new Location(1,3), 40, Movable.Directions.DOWN, Bot.SLOW_SPEED, Bot.SLOW_SPEED));
        bots.add(new WallMaker(new Location(7,2), 50, Movable.Directions.DOWN, Bot.SLOW_SPEED));



        Map map=new Map(bots);
        MapPanel p = new MapPanel(bots, map);
        GUIPanel gui=new GUIPanel();
        ViewFrame view= new ViewFrame(p, gui);
        GUIControl control=new GUIControl(view, bots, map);
    }



}
