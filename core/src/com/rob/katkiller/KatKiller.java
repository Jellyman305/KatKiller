package com.rob.katkiller;

import java.util.Iterator;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

public class KatKiller extends ApplicationAdapter {
	
	SpriteBatch batch;
	
	//Textures
	Texture blood;
	Texture katImage;
	Texture floorImage;
	
	//Camera
	OrthographicCamera camera;
	
	//Shapes
	Rectangle kat;
	Rectangle floor;
	
	//Arrays
	Array<Rectangle> bloodDrops;
	long lastDropTime;
	
	@Override
	public void create () {
		
		batch = new SpriteBatch();
		
		//Textures
		blood = new Texture(Gdx.files.internal("blood.png"));
		katImage = new Texture(Gdx.files.internal("kat.png"));
		floorImage = new Texture(Gdx.files.internal("floor.png"));
		
		//Camera
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);
		
		//Shapes
		kat = new Rectangle();
		kat.x = 800 / 2 - 22 / 2;
		kat.y = 100;
		kat.width = 22;
		kat.height = 40;
		
		floor = new Rectangle();
		floor.x = 0;
		floor.y = 0;
		floor.width = 800;
		floor.height = 20;
		
		//Start to spawn the blood
		bloodDrops = new Array<Rectangle>();
		spawnBloodDrop();
		
	}
	
	public void spawnBloodDrop() {
		
		Rectangle blooddrop = new Rectangle();
		
		blooddrop.x = MathUtils.random(0, 800-16);
		blooddrop.y = 480;
		
		blooddrop.width = 16;
		blooddrop.height = 16;
		
		bloodDrops.add(blooddrop);
		lastDropTime = TimeUtils.nanoTime();
	}

	@Override
	public void render () {
		
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		camera.update();
		//Batch
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		
		batch.draw(katImage, kat.x, kat.y);
		
		for(Rectangle blooddrop: bloodDrops) {
			batch.draw(blood, blooddrop.x, blooddrop.y);
		}
		
		batch.draw(floorImage, floor.x, floor.y);
		
		batch.end();
		
		if(Gdx.input.isTouched()) {
			
			Vector3 touchPos = new Vector3();
			touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			camera.unproject(touchPos);
			kat.x = touchPos.x - 22 / 2;
			
		}
		
		kat.y -= 1;
		
		if(kat.x < 0) kat.x = 0;
		if(kat.x > 800 - 22) kat.x = 800 - 22;
		
		if(kat.overlaps(floor)) {
			kat.y += 1;
		}
		
		
		if(TimeUtils.nanoTime() - lastDropTime > 1000000000) spawnBloodDrop();
		Iterator<Rectangle> iter = bloodDrops.iterator();
		while(iter.hasNext()) {
			Rectangle blooddrop = iter.next();
			blooddrop.y -= 200 * Gdx.graphics.getDeltaTime();
			if(blooddrop.y + 16 < 0) iter.remove();
			if(blooddrop.overlaps(kat)) {
				iter.remove();
			}
		}
		
		if(Gdx.input.isKeyPressed(Keys.LEFT)) kat.x -= 200 * Gdx.graphics.getDeltaTime();
		if(Gdx.input.isKeyPressed(Keys.RIGHT)) kat.x += 200 * Gdx.graphics.getDeltaTime();
	}
}
