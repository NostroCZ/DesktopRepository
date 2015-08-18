package com.gdx.game.model;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by Vít Kožín on 13.8.2015.
 */
public class WorldObject
{
    private final Vector2 size = new Vector2(117, 180);
    private final Vector2 position;

    public WorldObject(Vector2 position)
    {
        this.position = position;
    }

    public Vector2 getSize()
    {
        return size;
    }

    public Vector2 getPosition()
    {
        return position;
    }
}
