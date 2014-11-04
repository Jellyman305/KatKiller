package com.rob.katkiller;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class KatKiller extends ApplicationAdapter {		
		
		public OrthographicCamera camera;
		
		public SpriteBatch batch;
		
		public Player player;
		public WoodBlock woodBlock;
		public GrassBlock g1, g2, g3;
		
		public static final double GRAVITY = -0.3;
		
		TiledMap tiledMap;
		TiledMapRenderer tiledMapRenderer;
		
		@Override
		public void create() {
			
			// = new TmxMapLoader().load("Tiles/map.tmx");
			//tiledMapRenderer = new OrthogonalTiledMapRenderer (tiledMap);
			
			player = new Player("kat.png");
			woodBlock = new WoodBlock(0, 0, 32, 32, "wood.png");
			g1 = new GrassBlock(32, 32, 32, 32, "grass.png");
			g2 = new GrassBlock(64, 0, 32, 32, "grass.png");
			g3 = new GrassBlock(64 + 32, 32, 32, 32, "grass.png");
			camera = new OrthographicCamera();
			camera.setToOrtho(false, 1920, 1070);
						
			batch = new SpriteBatch();
			
				
			
		}
		
		@Override
		public void render() {
			
			Gdx.gl.glClearColor(1, 1, 1, 1);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			
			camera.position.set(player.rect.x, player.rect.y+100, 0);
			
			/*if(player.rect.x + 22 > g3.rect.x && player.rect.x < g3.rect.x + 32) {
				
				player.rect.x -= 300 * Gdx.graphics.getDeltaTime();
				camera.position.set(player.rect.x, player.rect.y+100, 0);
				
			}*/
			camera.update();
			
			
			
			//tiledMapRenderer.setView(camera);
			//tiledMapRenderer.render();
			
			batch.setProjectionMatrix(camera.combined);
			
			player.render(batch);
			woodBlock.render(batch, player, camera);
			g1.render(batch, player, camera);
			g2.render(batch, player, camera);
			g3.render(batch, player, camera);
			
			
		}	
		
		public void update() {
			
		}
		
	}

