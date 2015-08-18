package com.gdx.game.model;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Vít Kožín on 28.7.2015.
 */
public class Player
{
//    public enum State {IDLE, WALKING, JUMPING, DYING}
//
//    public static final float SPEED = 2f; // units per second
//    static final float JUMP_VELOCITY = 1f;
//    public static final float SIZE = 0.5f; // half a unit
//
    Vector2 position = new Vector2();
//    Vector2 acceleration = new Vector2();
//    Vector2 velocity = new Vector2();
    Vector2 size = new Vector2(38, 48);
//    State state = State.IDLE;
//    float stateTime = 0;
//    boolean facingLeft = true;
//
    public Player(Vector2 position)
    {
        this.position = position;
//        this.bounds = SIZE;
//        this.bounds.width = SIZE;
    }

    public Vector2 getSize()
    {
        return size;
    }

    //
//    public void update(float delta)
//    {
//        stateTime += delta;
//        position.add(velocity.cpy().scl(delta));
//    }
//
//    public Rectangle getBounds()
//    {
//        return bounds;
//    }
//
    public Vector2 getPosition()
    {
        return position;
    }

    public void setPosition(Vector2 position)
    {
        this.position = position;
    }
//
//    public void setFacingLeft(boolean facingLeft)
//    {
//        this.facingLeft = facingLeft;
//    }
//
//    public void setState(State state)
//    {
//        this.state = state;
//    }
//
//    public Vector2 getVelocity()
//    {
//        return velocity;
//    }
//
//    public Vector2 getAcceleration()
//    {
//        return acceleration;
//    }
//
//    public boolean isFacingLeft()
//    {
//        return facingLeft;
//    }
//
//    public State getState()
//    {
//        return state;
//    }
//
//    public float getStateTime()
//    {
//        return stateTime;
//    }
}
