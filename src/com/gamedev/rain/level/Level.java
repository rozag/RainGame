package com.gamedev.rain.level;

import com.gamedev.rain.entity.Entity;
import com.gamedev.rain.graphics.Screen;
import com.gamedev.rain.level.tile.Tile;

import java.util.ArrayList;
import java.util.List;

public abstract class Level {

    public static Level spawn = new SpawnLevel("/textures/levels/spawnLevel.png");

    public int width, height;
    protected int[] tiles;
    protected int[] tilesInt;
    protected List<Entity> entities = new ArrayList<Entity>();

    public Level(int width, int height) {
        this.width = width;
        this.height = height;
        tilesInt = new int[width * height];
        generateLevel();
    }

    protected void generateLevel() {
    }

    public Level(String path) {
        loadLevel(path);
        generateLevel();
    }

    protected void loadLevel(String path) {
    }

    public void add(Entity e) {
        entities.add(e);
    }

    public void update() {
        for (int i = 0; i < entities.size(); i++) {
            entities.get(i).update();
        }
    }

    public void render(int xScroll, int yScroll, Screen screen) {
        screen.setOffset(xScroll, yScroll);
        int x0 = xScroll >> 4; // (x >> 4) <=> (x / 16)
        int x1 = (xScroll + screen.width + 16) >> 4;
        int y0 = yScroll >> 4;
        int y1 = (yScroll + screen.height + 16) >> 4;

        for (int y = y0; y < y1; y++) {
            for (int x = x0; x < x1; x++) {
                getTile(x, y).render(x, y, screen);
            }
        }

        for (int i = 0; i < entities.size(); i++) {
            entities.get(i).render(screen);
        }
    }

    public Tile getTile(int x, int y) {
        return Tile.voidTile;
    }

    private void time() {
    }

}
