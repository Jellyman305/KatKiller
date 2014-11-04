package com.rob.katkiller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;


public class Block {
	
	boolean rightCol = false;
	boolean leftCol = false;
	boolean topCol = false;
	boolean bottomCol = false;
	
	public Texture image;
	
	public Rectangle rect;
	
	public Block(int x, int y, int w, int h, String url) {
		
		rect = new Rectangle();
		rect.x = x;
		rect.y = y;
		rect.width = w;
		rect.height = h;
		
		image = new Texture(Gdx.files.internal(url));
		
	}
	
	public void render(SpriteBatch batch, Player player, OrthographicCamera cam) {
		update(player, cam);
		batch.begin();
		batch.draw(image, rect.x, rect.y);
		batch.end();
		
		
	}
	
	
	public void update(Player player, OrthographicCamera camera) {
		
		System.out.println("update is running");
		System.out.println(bottomCol);
		
		if(bottomCol = false) {
			player.rect.y -= 300 * Gdx.graphics.getDeltaTime();
			
			System.out.println(bottomCol);
			
		}
			
			if(player.rect.x > rect.x - 16 && player.rect.x < rect.x + 16 && player.rect.y < rect.y + 32 && player.rect.y > rect.y + 10) {
				bottomCol = true;
				System.out.println(bottomCol);
				player.rect.y += 300 * Gdx.graphics.getDeltaTime();
				bottomCol = false;
				System.out.println(bottomCol);

			
		}
			
		
		/*if(player.rect.x + 22 > rect.x && player.rect.x < rect.x + 32 && player.rect.y < rect.y+32) {
			
			rightCol = true;
			
		}
		
		if(player.rect.y < rect.y + 32 && player.rect.x < rect.x + 32 && player.rect.x > rect.x && player.rect.y > rect.y) {
			bottomCol = true;
			player.rect.y += 300 * Gdx.graphics.getDeltaTime();
			bottomCol = false;
		}		
				
		if(rightCol) {
			player.rect.x -= 300 * Gdx.graphics.getDeltaTime();
			camera.position.set(player.rect.x, player.rect.y+100, 0);
			rightCol = false;
			
		}*/
		
	}
	

}
