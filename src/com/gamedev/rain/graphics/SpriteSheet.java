package com.gamedev.rain.graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SpriteSheet {

    private String path;
    public final int SIZE;
    public int[] pixels;

    public static SpriteSheet tiles = new SpriteSheet("/textures/sheets/spritesheet.png", 256);
    public static SpriteSheet spawnLevelTiles = new SpriteSheet("/textures/sheets/spawnLevelTiles.png", 48);

    public SpriteSheet(String path, int size) {
        this.path = path;
        SIZE = size;
        pixels = new int[SIZE * SIZE];
        loadImage();
    }

    private void loadImage() {
        try {
            BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
            int width = image.getWidth();
            int height = image.getHeight();
            image.getRGB(0, 0, width, height, pixels, 0, width);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
