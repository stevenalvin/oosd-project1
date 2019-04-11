import org.newdawn.slick.Graphics;
import org.newdawn.slick.tiled.TiledMap;

/**
 * This class should be used to restrict the game's view to a subset of the entire world.
 * 
 * You are free to make ANY modifications you see fit.
 * These classes are provided simply as a starting point. You are not strictly required to use them.
 */
public class Camera {
	private float camX, camY;
	private int midX, midY;
	private int maxCamX, maxCamY, minCamX, minCamY;
	public Camera(Map map, Player player) {
		midX = App.WINDOW_WIDTH / 2;
		midY = App.WINDOW_HEIGHT / 2;
		camX = player.getX();
		camY = player.getY();
	}
	public void moveCam(Player player, Map map) {
		maxCamX = map.getMapWidth() - App.WINDOW_WIDTH;
		maxCamY = map.getMapHeight() - App.WINDOW_HEIGHT;
		
		camX = player.getX() - App.WINDOW_WIDTH/2;
		camY = player.getY() - App.WINDOW_HEIGHT/2;
		System.out.println(player.getX());
		if (camX > maxCamX) {
			camX = maxCamX;
		}
		if (camY > maxCamY) {
			camY = maxCamY;
		}
		if (camX < minCamX) {
			camX = minCamX;
		}
		if (camY < minCamY) {
			camY = minCamY;
		}
	}
	public float getCamX() {
		return camX;
	}
	public float getCamY() {
		return camY;
	}
	public float getLeft() {
		return 0;
	}
	public float getTop() {
		// You probably want to change this.
		return 0;
	}
	public float getRight() {
		// You probably want to change this.
		return 0;
	}
	public float getBottom() {
		// You probably want to change this.
		return 0;
	}
}
