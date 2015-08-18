package com.gdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector2;
import com.gdx.game.controller.BobController;
import com.gdx.game.model.World;
import com.gdx.game.view.WorldRenderer;

/**
 * Created by Vít Kožín on 29.7.2015.
 */
public class GameScreen implements Screen, InputProcessor
{
    private World world;
    private WorldRenderer renderer;
    private BobController controller;

    private int width, height;

    @Override
    public void show()
    {
        world = new World();
        renderer = new WorldRenderer(world);
//        controller = new BobController(world);
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void render(float delta)
    {
        Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//        controller.update(delta);
        renderer.render();
    }

    @Override
    public void resize(int width, int height)
    {
        renderer.setSize(width, height);
        this.width = width;
        this.height = height;
    }

    @Override
    public void pause()
    {
    }

    @Override
    public void resume()
    {}

    @Override
    public void hide()
    {
        Gdx.input.setInputProcessor(null);
    }

    @Override
    public void dispose()
    {
        Gdx.input.setInputProcessor(null);
    }

    // * InputProcessor methods ***************************//

    @Override
    public boolean keyDown(int keycode)
    {
        return true;
    }

    @Override
    public boolean keyUp(int keycode)
    {
        return true;
    }

    @Override
    public boolean keyTyped(char character)
    {
        return false;
    }

    @Override
    public boolean touchDown(int x, int y, int pointer, int button) {
        Vector2 position = new Vector2(world.getPlayer().getPosition());
        if (x < width / 2 && y > height / 2)
        {
            // left down
            if (position.y % 2 == 0)
            {
                position.x--;
            }
            position.y--;

        }
        if (x > width / 2 && y > height / 2)
        {
            // right down
            if (position.y % 2 == 1)
            {
                position.x++;
            }
            position.y--;

        }
        if (x < width / 2 && y < height / 2)
        {
            // left up
            if (position.y % 2 == 0)
            {
                position.x--;
            }
            position.y++;

        }
        if (x > width / 2 && y < height / 2)
        {
            // right up
            if (position.y % 2 == 1)
            {
                position.x++;
            }
            position.y++;

        }
        world.getPlayer().setPosition(position);
        return true;
    }

    @Override
    public boolean touchUp(int x, int y, int pointer, int button) {
//        if (x < width / 2 && y > height / 2) {
//            controller.leftReleased();
//        }
//        if (x > width / 2 && y > height / 2) {
//            controller.rightReleased();
//        }
//        if (y < height / 2)
//        {
//            controller.jumpReleased();
//        }
//        controller.leftReleased();
//        controller.rightReleased();
//        controller.jumpReleased();
        return true;
    }

    @Override
    public boolean touchDragged(int x, int y, int pointer)
    {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY)
    {
        return false;
    }

    @Override
    public boolean scrolled(int amount)
    {
        return false;
    }
}
