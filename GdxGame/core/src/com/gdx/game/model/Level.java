package com.gdx.game.model;

import com.badlogic.gdx.math.Vector2;

import java.util.Random;

/**
 * Created by Vít Kožín on 8.8.2015.
 */
public class Level
{
    private int width;
    private int height;
    private Tile[][] tiles;
    private WorldObject[][] worldObjects;

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }

    public Tile[][] getTiles()
    {
        return tiles;
    }

    public WorldObject[][] getWorldObjects()
    {
        return worldObjects;
    }

    public Level()
    {
        loadDemoLevel();
    }

    private void loadDemoLevel()
    {
        width = 20;
        height = 80;
        tiles = new Tile[width][height];
        for (int col = 0; col < width; col++)
        {
            for (int row = 0; row < height; row++)
            {
                tiles[col][row] = new Tile(new Vector2(col, row), TileStyle.GRASS);
            }
        }
        worldObjects = new WorldObject[width][height];
        for (int col = 0; col < width; col++)
        {
            for (int row = 0; row < height; row++)
            {
                worldObjects[col][row] = null;
            }
        }

        int maxObjectCount = 50;
        int objectCount = 0;
        Random rand = new Random();
        while (objectCount < maxObjectCount)
        {
            int x = rand.nextInt(width);
            int y = rand.nextInt(height);
            if (worldObjects[x][y] == null)
            {
                worldObjects[x][y] = new WorldObject(new Vector2(x,y));
                objectCount++;
            }
        }


    }
}
