package com.gamedev.rain.graphics;

public class Sprite {

    public final int SIZE;
    private int x, y;
    public int[] pixels;
    private SpriteSheet sheet;

    // Main sprites
    public static Sprite grass = new Sprite(16, 0, 5, SpriteSheet.tiles);
    public static Sprite voidSprite = new Sprite(16, 0x000000);

    // Spawn level sprites
    public static Sprite spawn_grass = new Sprite(16, 0, 0, SpriteSheet.spawnLevelTiles);
    public static Sprite spawn_hedge = new Sprite(16, 1, 0, SpriteSheet.spawnLevelTiles);
    public static Sprite spawn_water = new Sprite(16, 2, 0, SpriteSheet.spawnLevelTiles);
    public static Sprite spawn_wall_1 = new Sprite(16, 0, 1, SpriteSheet.spawnLevelTiles);
    public static Sprite spawn_wall_2 = new Sprite(16, 0, 2, SpriteSheet.spawnLevelTiles);
    public static Sprite spawn_floor = new Sprite(16, 1, 1, SpriteSheet.spawnLevelTiles);

    // Knight sprites
    public static Sprite[] playerUp = {
            new Sprite(32, 1, 7, SpriteSheet.tiles),
            new Sprite(32, 0, 7, SpriteSheet.tiles),
            new Sprite(32, 2, 7, SpriteSheet.tiles)
    };
    public static Sprite[] playerSide = {
            new Sprite(32, 1, 6, SpriteSheet.tiles),
            new Sprite(32, 0, 6, SpriteSheet.tiles),
            new Sprite(32, 2, 6, SpriteSheet.tiles)
    };
    public static Sprite[] playerDown = {
            new Sprite(32, 1, 5, SpriteSheet.tiles),
            new Sprite(32, 0, 5, SpriteSheet.tiles),
            new Sprite(32, 2, 5, SpriteSheet.tiles)
    };

    public Sprite(int size, int colour) {
        SIZE = size;
        pixels = new int[SIZE * SIZE];
        setColour(colour);
    }

    private void setColour(int colour) {
        for (int i = 0; i < SIZE * SIZE; i++) {
            pixels[i] = colour;
        }
    }

    public Sprite(int size, int x, int y, SpriteSheet sheet) {
        SIZE = size;
        pixels = new int[SIZE * SIZE];
        this.x = x * SIZE;
        this.y = y * SIZE;
        this.sheet = sheet;
        loadImage();
    }

    private void loadImage() {
        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {
                pixels[x + y * SIZE] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE];
            }
        }
    }

}
