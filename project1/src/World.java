import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;


/**
 * This class should be used to contain all the different objects in your game world, and schedule their interactions.
 * 
 * You are free to make ANY modifications you see fit.
 * These classes are provided simply as a starting point. You are not strictly required to use them.
 */
public class World {
	private Map map;
	private Camera cam;
	private Player player;
	private float mouseX;
	private float mouseY;
	public World() throws SlickException{
		 map = new Map("assets/main.tmx");
		 player = new Player();
		 cam = new Camera(map, player);
	}
	
	// returns the square of val
	private float square(float val) {
		return val * val;
	}
	
	// returns the distance between (x1, y1) and (x2, y2)
	private float distance(float x1, float y1, float x2, float y2) {
		return (float) Math.sqrt(square(x2 - x1) + square(y2 - y1));
	}

	public void update(Input input, int delta) {
		// vector x and y is a vector from player to mouse
		float vectorX, vectorY;
		float dx, dy;
		double radian;
		if (input.isMouseButtonDown(Input.MOUSE_RIGHT_BUTTON)) {
			// read the mouse input coordinate 
			// and adjusted with the map coordinate after translation
			mouseX = input.getMouseX() + cam.getCamX();
			mouseY = input.getMouseY() + cam.getCamY();
		}
		// calculate vector from player to mouse
		vectorX = mouseX - player.getX();
		vectorY = mouseY - player.getY();
		
		// calculate the angle from player to mouse
		radian = Math.atan2(vectorY, vectorX);
		
		// calculate the distance traveled for x and y for each frame
		dx =(float) (Player.SPEED * delta * Math.cos(radian));
		dy =(float) (Player.SPEED * delta * Math.sin(radian));
		
		// calculate the distance from player to mouse
		float distanceToTarget = distance(player.getX(), player.getY(),
										  mouseX, mouseY);
		
		// move the player
		player.move(dx, dy, map, distanceToTarget);
		
		// move camera
		cam.moveCam(player, map);
	}
		
	
	public void render(Graphics g) {
		// translate the graphic to create a camera effect
		g.translate(-cam.getCamX(), -cam.getCamY());
		// draw all
		map.render(0,0);
		player.render();		
	}
}