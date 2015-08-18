package com.gdx.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.gdx.game.model.Tile;
import com.gdx.game.model.Player;
import com.gdx.game.model.World;
import com.gdx.game.model.WorldObject;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by V�t Ko��n on 29.7.2015.
 */
public class WorldRenderer
{
    private static float UNITS_ON_SCREEN_X = 10f;
    private static float UNITS_ON_SCREEN_Y = 7f;

    private World world;
    private OrthographicCamera cam;

    // TEXTURES
    private List<TextureRegion> grassTextures;

    private TextureRegion playerTexture;
    private TextureRegion treeTexture;



    private SpriteBatch batch;
    private int width;
    private int height;
    private final float pixelsPerUnitX = 64;
    private final float pixelsPerUnitY = 32;

    public void setSize(int width, int height)
    {
        cam.viewportWidth = width;
        cam.viewportHeight = height;
        Vector2 playerPosition = calculateRenderPosition(world.getPlayer().getPosition());
        cam.position.set(playerPosition.x, playerPosition.y + 10, 0);
    }

    public WorldRenderer(World world)
    {
        this.world  = world;

        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        UNITS_ON_SCREEN_X =  w / pixelsPerUnitX;
        UNITS_ON_SCREEN_Y = (h / pixelsPerUnitY ) * 2;
        cam = new OrthographicCamera();
        cam.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        batch = new SpriteBatch();
        loadTextures();
    }

    private void loadTextures()
    {
        grassTextures = new ArrayList<TextureRegion>();
        TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("images/textures/textures.atlas"));
        for (int i=1; i<=16; i++)
        {
            grassTextures.add(atlas.findRegion("tile-grass" + i));
        }
        playerTexture = atlas.findRegion("hero0");
        treeTexture = atlas.findRegion("object-tree1");
    }


    public void render()
    {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Vector2 playerPosition = calculateRenderPosition(world.getPlayer().getPosition());
        cam.position.set(playerPosition.x, playerPosition.y + 10, 0);
        cam.update();
        batch.setProjectionMatrix(cam.combined);

        batch.begin();
            drawTiles();
            drawTopObjects();
            drawPlayer();
            drawBottomObjects();
        batch.end();

    }

    private void drawPlayer()
    {
        Player player = world.getPlayer();
        Vector2 renderPosition = calculateRenderPosition(player.getPosition());
        batch.draw(playerTexture, renderPosition.x, renderPosition.y, player.getSize().x, player.getSize().y);
    }

    private void drawTiles()
    {
        for (Tile tile : world.getDrawableBlocks((int) UNITS_ON_SCREEN_X, (int) UNITS_ON_SCREEN_Y))
        {
            Vector2 renderPosition = calculateRenderPosition(tile.getPosition());
            batch.draw(grassTextures.get(tile.getTileStyleSubtype()), renderPosition.x, renderPosition.y, Tile.SIZE * pixelsPerUnitX, Tile.SIZE * pixelsPerUnitY);
        }
    }

    private void drawTopObjects()
    {
        for (WorldObject worldObject : world.getDrawableTopObjects((int) UNITS_ON_SCREEN_X, (int) UNITS_ON_SCREEN_Y))
        {
            Vector2 renderPosition = calculateRenderPosition(worldObject.getPosition());
            batch.draw(treeTexture, renderPosition.x, renderPosition.y, worldObject.getSize().x, worldObject.getSize().y);
        }
    }

    private void drawBottomObjects()
    {
        for (WorldObject worldObject : world.getDrawableBottomObjects((int) UNITS_ON_SCREEN_X, (int) UNITS_ON_SCREEN_Y))
        {
            Vector2 renderPosition = calculateRenderPosition(worldObject.getPosition());
            batch.draw(treeTexture, renderPosition.x, renderPosition.y, worldObject.getSize().x, worldObject.getSize().y);
        }
    }

    private Vector2 calculateRenderPosition(Vector2 coordinates)
    {
        float x = coordinates.x * pixelsPerUnitX;
        float y = coordinates.y * ( pixelsPerUnitY / 2);
        if (coordinates.y % 2 == 1)
        {
            x += (pixelsPerUnitX / 2);
        }
        return new Vector2(x, y);
    }

}
