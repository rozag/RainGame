package com.gamedev.rain.level;

import com.gamedev.rain.graphics.Screen;
import com.gamedev.rain.level.tile.Tile;

public abstract class Level {

    protected Tile[] tiles;
    protected int width, height;
    protected int[] tilesInt;

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

    public void update() {
    }

    public void render(int xScroll, int yScroll, Screen screen) {
        screen.setOffset(xScroll, yScroll);
        int x0 = xScroll >> 4; // (x >> 4) <=> (x / 16)
        int x1 = (xScroll + screen.width + 16) >> 4;
        int y0 = yScroll >> 4;
        int y1 = (yScroll + screen.height + 16) >> 4;

        for (int y = y0; y < y1; y++) {
            for (int x = x0; x < x1; x++) {
                if (x + y * 16 < 0 || x + y * 16 >= 256) {
                    Tile.voidTile.render(x, y, screen);
                    continue;
                }
                    tiles[x + y * 16].render(x, y,screen);
            }
        }
    }

    public Tile getTile(int x, int y) {
        if (x <= 0 || y <= 0 || x >= width || y >= height)
            return Tile.voidTile;
        else if (x + y * width > 0 && (tilesInt[x + y * width] == 0 || tilesInt[x + y * width] == 3))
            return Tile.grass;
        else if (x + y * width > 0 && tilesInt[x + y * width] == 1)
            return Tile.flower;
        else if (x + y * width > 0 && tilesInt[x + y * width] == 2)
            return Tile.stone;
        else
            return Tile.voidTile;
    }

    private void time() {
    }

}
