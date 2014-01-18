package com.gamedev.rain.entity.projectile;

import com.gamedev.rain.graphics.Sprite;

public class WizardProjectile extends Projectile {


    public WizardProjectile(int xOrigin, int yOrigin, double angle) {
        super(xOrigin, yOrigin, angle);
        range = 200;
        speed = 4;
        damage = 20;
        rateOfFire = 15;
        sprite = Sprite.spawn_water;
        newX = speed * Math.cos(angle);
        newY = speed * Math.sin(angle);
    }




}
