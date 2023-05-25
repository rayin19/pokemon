package com.rayin19.v2.pokemon.model;

public class Actor {

    private TileMap map;
    private int x;
    private int y;

    public Actor(TileMap map, int x, int y) {
        this.map = map;
        this.x = x;
        this.y = y;
        map.getTile(x,y).setActor(this);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    //For moving player
    public boolean movePlayer(int dx, int dy){
        if (
                x + dx >= map.getWidth()
                || x + dx < 0
                || y + dy >= map.getHeight()
                || y + dy < 0
        ){
            return false;
        }


        if (map.getTile(x+dx,y+dy).getActor() != null){
            return false;
        }
        map.getTile(x,y).setActor(null);
        x += dx;
        y += dy;
        map.getTile(x,y).setActor(this);

        return true;
    }

}
