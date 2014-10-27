package com.rob.katkiller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;


public class Player extends Entity {

	public Rectangle rect;
	
	private Texture image;
	
	public Player(String url) {
		
		image = new Texture(Gdx.files.internal(url));
		
		rect = new Rectangle();
		rect.x = 0;
		rect.y = 32;
		rect.width = 22;
		rect.height = 40;
		
	}
	
	public void render(SpriteBatch batch) {
		
		batch.begin();
		batch.draw(image, rect.x, rect.y);
		batch.end();
		
		if(Gdx.input.isKeyPressed(Keys.RIGHT)) rect.x += 300 * Gdx.graphics.getDeltaTime();
		if(Gdx.input.isKeyPressed(Keys.LEFT)) rect.x -= 300 * Gdx.graphics.getDeltaTime();
	}
	
}
