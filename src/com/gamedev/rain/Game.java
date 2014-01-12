package com.gamedev.rain;

import com.gamedev.rain.graphics.Screen;
import com.gamedev.rain.input.Keyboard;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class Game extends Canvas implements Runnable {

    public static int width = 300;
    public static int height = width * 9 / 16;
    public static int scale = 3;
    private static final String TITLE = "Rain Game";

    private Screen screen;

    private Thread thread;
    private boolean running = false;
    private JFrame frame;
    private Keyboard keyboard;

    private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

    private int y = 0, x = 0;

    public Game() {
        Dimension size = new Dimension(width * scale, height * scale);
        setPreferredSize(size);
        frame = new JFrame();
        screen = new Screen(width, height);

        keyboard = new Keyboard();
        addKeyListener(keyboard);
    }

    public void update() {
        keyboard.update();
        if (keyboard.up) y--;
        if (keyboard.down) y++;
        if (keyboard.left) x--;
        if (keyboard.right) x++;
    }

    public void render() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }

        screen.clear();
        screen.render(x, y);

        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = screen.pixels[i];
        }

        Graphics g = bs.getDrawGraphics();

        {
            g.setColor(Color.black);
            g.fillRect(0, 0, getWidth(), getHeight());
            //TODO здесь будет вся графика
        }

        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);

        g.dispose();
        bs.show();
    }

    public synchronized void start() {
        running = true;
        thread = new Thread(this, "Display");
        thread.start();
    }

    public synchronized void stop() {
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        final double nanoSeconds = 1000000000.0 / 60.0;
        double deltaTime = 0;

        int frames = 0, updates = 0;
        requestFocus();
        while (running) {
            long currentTime = System.nanoTime();
            deltaTime += (currentTime - lastTime) / nanoSeconds;
            lastTime = currentTime;

            while (deltaTime >= 1) {
                update();
                updates++;
                deltaTime--;
            }

            render();   // Этот
            frames++;   // и этот метод внести в цикл сверху, чтобы поставить fps ограничение

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                frame.setTitle(TITLE + " | fps: " + frames + " ups: " + updates);
                updates = 0;
                frames = 0;
            }
        }
        stop();
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.frame.setResizable(false);
        game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.frame.setVisible(true);
        game.frame.setTitle(TITLE);
        game.frame.add(game);
        game.frame.pack();
        game.frame.setLocationRelativeTo(null);

        game.start();
    }
}
