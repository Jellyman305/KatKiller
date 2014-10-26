package com.rob.katkiller.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.rob.katkiller.KatKiller;

public class DesktopLauncher {
	public static void main (String[] args) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Kat Killer";
		config.width = 800;
		config.height = 480;
		new LwjglApplication(new KatKiller(), config);
	}
}
