package com.nephriteforksgames.tictactoe3d.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.nephriteforksgames.tictactoe3d.GdxGame;

public class DesktopLauncher {
	public static void main (String[] arg)
	{
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		System.out.println(config.samples) ;
		config.samples = 32;
		config.overrideDensity = -1;
		config.resizable = false;
		config.height = 600;
		config.width = 800;
		config.fullscreen = false;
		config.vSyncEnabled = true;
		
		new LwjglApplication(new GdxGame(), config);
	}
}