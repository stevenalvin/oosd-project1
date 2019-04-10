import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.Image;
import org.newdawn.slick.tiled.TiledMap;
import org.newdawn.slick.SlickException;


/**
 * This class should be used to contain all the different objects in your game world, and schedule their interactions.
 * 
 * You are free to make ANY modifications you see fit.
 * These classes are provided simply as a starting point. You are not strictly required to use them.
 */
public class World {
	TiledMap map;
	Player player;
	float mouseX;
	float mouseY;
	public World() throws SlickException{
		 map = new TiledMap("assets/main.tmx");
		 player = new Player();
	}
	public void update(Input input, int delta) {
		// vector x and y is a vector from player to mouse
		float vectorX = 0, vectorY = 0;
		float dx = 0, dy = 0;
		double radian = 0;
		if (input.isMouseButtonDown(Input.MOUSE_RIGHT_BUTTON)) {
			mouseX = input.getMouseX();
			mouseY = input.getMouseY();
			vectorX = mouseX - player.getX();
			vectorY = mouseY - player.getY();
			radian = Math.atan2(vectorY, vectorX);

			dx += Player.SPEED * delta * Math.cos(radian);

			dy += Player.SPEED * delta * Math.sin(radian);
		
			player.move(dx, dy);
		}
			
		
	}
	
	public void render(Graphics g) {
		map.render(0,0);
		player.render();
	}
}