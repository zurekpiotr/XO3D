package com.nephriteforksgames.tictactoe3d.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.nephriteforksgames.tictactoe3d.GdxGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		//System.setProperty("user.name" , "zurek");
		//System.out.println( System.getProperty("user.name"). );
		//System.out.println( System.getProperties() );
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		System.out.println(config.samples) ;
		config.samples = 32;
		config.overrideDensity = -1;
		config.resizable = false;
		config.height = 600;
		config.width = 800;
		config.fullscreen = false;
		config.vSyncEnabled = true;
		//System.out.println("vSyncEnabled = " + config.vSyncEnabled ) ;
		
		new LwjglApplication(new GdxGame(), config);
	}
}