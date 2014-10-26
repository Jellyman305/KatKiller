package com.rob.katkiller;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class KatKiller extends ApplicationAdapter {
	
		public Texture katImage;
		
		public Rectangle kat;
		
		
		public OrthographicCamera camera;
		
		public SpriteBatch batch;
		
		@Override
		public void create() {
			
			katImage = new Texture(Gdx.files.internal("kat.png"));
			
			kat = new Rectangle();
			kat.x = 800 / 2 - 22 / 2;
			kat.y = 20;
			kat.width = 22;
			kat.height = 40;
			
			camera = new OrthographicCamera();
			camera.setToOrtho(false, 800, 400);
			
			batch = new SpriteBatch();
			
		}
		
		@Override
		public void render() {
			
			Gdx.gl.glClearColor(1, 1, 1, 1);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			
			camera.update();
			batch.setProjectionMatrix(camera.combined);
			batch.begin();
			batch.draw(katImage, kat.x, kat.y);
			batch.end();
			
			if(Gdx.input.isKeyPressed(Keys.RIGHT)) kat.x += 200 * Gdx.graphics.getDeltaTime();
			
		}
		
	}

