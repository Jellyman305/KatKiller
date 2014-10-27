package com.rob.katkiller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class GrassBlock {	
	
	public Texture image;
	
	public Rectangle rect;

	public GrassBlock(int x, int y, String url) {	
		
		rect = new Rectangle();
		rect.x = x;
		rect.y = y;
		rect.width = 32;
		rect.height = 32;
		
		image = new Texture(Gdx.files.internal(url));
		
	}
	
	public void render(SpriteBatch batch) {
		
		batch.begin();
		batch.draw(image, rect.x, rect.y);
		batch.end();
		
	}
	
	

}
