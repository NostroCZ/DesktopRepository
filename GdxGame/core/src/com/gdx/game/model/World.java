package com.gdx.game.model;




import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vít Kožín on 28.7.2015.
 */
public class World
{

    private Player player;
    private Level level;



    public Level getLevel()
    {
        return level;
    }

    public Player getPlayer()
    {
        return player;
    }

    public World()
    {
        createWorld();
    }

    private void createWorld()
    {
        player = new Player(new Vector2(3,3));
        level = new Level();
    }

    public List<Tile> getDrawableBlocks(int width, int height)
    {
        List<Tile> tiles = new ArrayList<Tile>();
        Tile tile;
        for (int col = 0; col < level.getWidth(); col++)
        {
            for (int row = 0; row < level.getHeight(); row++)
            {
                tile = level.getTiles()[col][row];
                if (tile != null)
                {
                    tiles.add(tile);
                }
            }
        }
        return tiles;
    }

    public List<WorldObject> getDrawableTopObjects(int width, int height)
    {
        List<WorldObject> objects = new ArrayList<WorldObject>();
        WorldObject worldObject;
        Vector2 playerPosition = getPlayer().getPosition();
        int cameraXLeft = (int)(playerPosition.x - ( width / 2)) - 3;
        int cameraXRight = (int)(playerPosition.x + ( width / 2)) + 3;
        int cameraYTop = (int)(playerPosition.y + ( height / 2));
        cameraXLeft = cameraXLeft < 0 ? 0 :cameraXLeft;
        cameraXRight = cameraXRight > getLevel().getWidth()? getLevel().getWidth() : cameraXRight;
        cameraYTop = cameraYTop > getLevel().getHeight() ? getLevel().getHeight() : cameraYTop;
        for (int col = cameraXLeft; col < cameraXRight; col++)
        {
            for (int row = (int)playerPosition.y; row < cameraYTop; row++)
            {
                worldObject = level.getWorldObjects()[col][row];
                if (worldObject != null)
                {
                    objects.add(worldObject);
                }
            }
        }
        return objects;
    }

    public List<WorldObject> getDrawableBottomObjects(int width, int height)
    {
        List<WorldObject> objects = new ArrayList<WorldObject>();
        WorldObject worldObject;
        Vector2 playerPosition = getPlayer().getPosition();
        int cameraYBottom = (int)(playerPosition.y - ( height / 2)) - 8;
        int cameraXLeft = (int)(playerPosition.x - ( width / 2)) - 3;
        int cameraXRight = (int)(playerPosition.x + ( width / 2)) + 3;
        cameraYBottom = cameraYBottom < 0 ? 0 :cameraYBottom;
        cameraXLeft = cameraXLeft < 0 ? 0 :cameraXLeft;
        cameraXRight = cameraXRight > getLevel().getWidth()? getLevel().getWidth() : cameraXRight;
        for (int col = cameraXLeft; col < cameraXRight; col++)
        {
            for (int row = cameraYBottom ; row <= (int)playerPosition.y; row++)
            {
                worldObject = level.getWorldObjects()[col][row];
                if (worldObject != null)
                {
                    objects.add(worldObject);
                }
            }
        }
        return objects;
    }
}
