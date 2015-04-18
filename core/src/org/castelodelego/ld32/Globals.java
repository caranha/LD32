package org.castelodelego.ld32;

import java.util.Random;

import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;


/**
 * Contains all the statically accessible global variables.
 * 
 * @author caranha
 *
 */
public class Globals {
		
	public static Preferences scoreloader;
	
	public static AssetManager manager;
	public static AnimationManager animman;
	public static SpriteBatch batch;
    public static ShapeRenderer shaper;
	public static Random dice;
		
	public static BitmapFont debugtext;
	
	
	static void init()
	{
		debugtext = new BitmapFont();
		
		batch = new SpriteBatch();
		animman = new AnimationManager();
		manager = new AssetManager();
		shaper = new ShapeRenderer();
        shaper.setAutoShapeType(true);


        dice = new Random();
	}		
}
