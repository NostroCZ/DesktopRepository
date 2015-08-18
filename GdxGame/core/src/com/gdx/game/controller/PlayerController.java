package com.gdx.game.controller;

import com.badlogic.gdx.math.Vector2;
import com.gdx.game.model.World;

/**
 * Created by Vít Kožín on 30.7.2015.
 */
public class PlayerController
{
    public enum Direction
    {
        LEFTTOP, RIGHTTOP, LEFTBOTTOM, RIGHTBOTTOM
    }


    private boolean moving = false;
    private Direction directionOfMovement = Direction.LEFTBOTTOM;
    private World world;

    public PlayerController(World world)
    {
        this.world = world;
    }

    public void touchDown(Direction direction)
    {
        setDirectionOfMovement(direction);
        setMoving(true);
    }

    public void touchUp()
    {
        //setMoving(false);
    }

    /** The main update method **/
    public void update(float delta)
    {
        if (isMoving())
        {
            Vector2 position = new Vector2(getWorld().getPlayer().getPosition());
            switch (getDirectionOfMovement())
            {
                case LEFTBOTTOM:
                {
                    if (position.y % 2 == 0)
                    {
                        position.x--;
                    }
                    position.y--;
                    break;
                }
                case RIGHTBOTTOM:
                {
                    if (position.y % 2 == 1)
                    {
                        position.x++;
                    }
                    position.y--;
                    break;
                }
                case LEFTTOP:
                {
                    if (position.y % 2 == 0)
                    {
                        position.x--;
                    }
                    position.y++;
                    break;
                }
                case RIGHTTOP:
                {
                    // right up
                    if (position.y % 2 == 1)
                    {
                        position.x++;
                    }
                    position.y++;
                    break;
                }
                default:
                    break;
            }
            getWorld().getPlayer().setPosition(position);
            setMoving(false);
        }
    }


    /**  GETTERS AND SETTERS **/
    public boolean isMoving()
    {
        return moving;
    }

    public void setMoving(boolean moving)
    {
        this.moving = moving;
    }

    public Direction getDirectionOfMovement()
    {
        return directionOfMovement;
    }

    public void setDirectionOfMovement(Direction directionOfMovement)
    {
        this.directionOfMovement = directionOfMovement;
    }

    public World getWorld()
    {
        return world;
    }
}
