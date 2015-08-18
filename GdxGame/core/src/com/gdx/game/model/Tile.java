package com.gdx.game.model;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

/**
 * Created by Vít Kožín on 28.7.2015.
 */
public class Tile
{
    public static final float SIZE = 1f;

    Vector2 position = new Vector2();
    final TileStyle style;
    final int tileStyleSubtype;

    public Tile(Vector2 position, TileStyle style)
    {
        this.position = position;
        this.style = style;
        tileStyleSubtype = generateSubType(style);
    }

    public Vector2 getPosition()
    {
        return position;
    }

    public TileStyle getStyle()
    {
        return style;
    }

    public int getTileStyleSubtype()
    {
        return tileStyleSubtype;
    }

    private int generateSubType(TileStyle style)
    {
        Random rand = new Random();
        switch (style)
        {
            case GRASS:
            {
                return rand.nextInt(TileStyle.GRASS_SUBTYPE_MAX - 1) + 1;
            }
            default:
            {
                return 1;
            }
        }

    }
}
