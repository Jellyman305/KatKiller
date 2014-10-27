package com.rob.katkiller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class WoodBlock {	
	
	public Texture image;
	
	public Rectangle wood;

	public WoodBlock(int x, int y, String url) {	
		
		wood = new Rectangle();
		wood.x = x;
		wood.y = y;
		wood.width = 32;
		wood.height = 32;
		
		image = new Texture(Gdx.files.internal(url));
		
	}
	
	public void render(SpriteBatch batch) {
		
		batch.begin();
		batch.draw(image, wood.x, wood.y);
		batch.end();
		
	}
	
	

}
