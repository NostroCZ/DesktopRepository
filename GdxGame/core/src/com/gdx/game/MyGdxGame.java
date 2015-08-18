package com.gdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.gdx.game.screens.GameScreen;

public class MyGdxGame extends Game
{
	
	@Override
	public void create () {
		setScreen(new GameScreen());
	}
}
