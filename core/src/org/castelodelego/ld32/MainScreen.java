package org.castelodelego.ld32;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

import com.badlogic.gdx.physics.box2d.*;

import org.castelodelego.ld32.gameplay.Entity;
import org.castelodelego.ld32.gameplay.EntityPlayer;

public class MainScreen implements Screen {

    float gravity = 10;

    Array<Entity> entityList;
    EntityPlayer player;

    OrthographicCamera gameCamera;
    float worldViewHeight = 480;
    float worldViewWidth = 800;

    World box2Dworld;

    public MainScreen()
    {
        super();

        gameCamera = new OrthographicCamera(worldViewWidth,worldViewHeight);
        entityList = new Array<Entity>();
        box2Dworld = new World(new Vector2(0, -98), true);

        init();
    }


    void init()
    {
        int startpos = -400;
        for (int i = 0; i < 60; i++) {
            Entity wall = new Entity();
            wall.init(new Vector2(startpos + 16 * i, i / 2), box2Dworld);
            entityList.add(wall);
        }

        player = new EntityPlayer();
        player.init(new Vector2(0, 100),box2Dworld);
        player.c = Color.RED;

    }



    void update(float delta)
    {
        box2Dworld.step(delta, 6, 2);

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
            player.moveLeft();
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            player.moveRight();
        if (Gdx.input.isKeyPressed(Input.Keys.UP))
            player.jump();
    }

    void handleInput()
    {

    }



    void drawEntities(float delta)
    {
        Globals.shaper.setProjectionMatrix(gameCamera.combined);

        Globals.shaper.begin();
        for (Entity aux:entityList)
        {
            aux.render(Globals.shaper);
        }
        player.render(Globals.shaper);
        Globals.shaper.end();
    }

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 1, 1, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		// TODO Auto-generated method stub

        drawEntities(delta);
        update(delta);

	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
	}

	@Override
	public void hide() {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
	}

}
