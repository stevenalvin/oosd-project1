/**
 * This class should be used to restrict the game's view to a subset of the entire world.
 * 
 * You are free to make ANY modifications you see fit.
 * These classes are provided simply as a starting point. You are not strictly required to use them.
 */
public class Camera {
	private float camX, camY;
	private int maxCamX, maxCamY, minCamX, minCamY;
	public Camera(Map map, Player player) {
		camX = player.getX();
		camY = player.getY();
	}
	public void moveCam(Player player, Map map) {
		// calculate the max coordinate for camera position
		maxCamX = map.getMapWidth() - App.WINDOW_WIDTH;
		maxCamY = map.getMapHeight() - App.WINDOW_HEIGHT;
		
		// set the camera position, to make the sprite stays in the middle
		camX = player.getX() - App.WINDOW_WIDTH/2;
		camY = player.getY() - App.WINDOW_HEIGHT/2;
		
		// prevent camera from moving outside the map
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
	// getters and setters for camera position
	public float getCamX() {
		return camX;
	}
	public float getCamY() {
		return camY;
	}
}
