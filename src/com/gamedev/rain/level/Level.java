package com.gamedev.rain.level;

import com.gamedev.rain.graphics.Screen;

public class Level {

    protected int width, height;
    protected int[] tiles;

    public Level(int width, int height) {
        this.width = width;
        this.height = height;
        tiles = new int[width * height];
        generateLevel();
    }

    protected void generateLevel() {

    }

    public Level(String path) {
        loadLevel(path);
    }

    private void loadLevel(String path) {

    }

    public void update() {

    }

    public void render(int xScroll, int yScroll, Screen screen) {

    }

    private void time() {

    }

}
