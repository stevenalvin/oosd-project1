import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class Player {
	private Image image;
	public static final float SPEED = 0.25f;
	private float x;
	private float y;
	private static final float STOP_DISTANCE_FROM_TARGET = 0.25f;
	
	
	public Player() throws SlickException{
		image = new Image("assets/scout.png");
		
	}
	// getter for position x of sprite
	public float getX() {
		return x;
	}
	// getter for position y of sprite
	public float getY() {
		return y;
	}
	// getter for position x of sprite
	public float setX(float x) {
		return x;
	}
	// getter for position y of sprite
	public float setY(float y) {
		return y;
	}
	
	public void move(float dx, float dy, Map map, float distanceToTarget) {
		
		x += dx;
		y += dy;
		
		// test this set of code later!!!
		// limiting the sprite movement to only within the map
		if (x < 0) {
			x = 0;
		}
		if (x > map.getMapWidth()) {
			x = map.getMapWidth();
		}
		if (y < 0) {
			y = 0;
		}
		if (y > map.getMapHeight()) {
			y = map.getMapHeight();
		}
		
		// not allowing sprite to move through solid tile
		if (map.isSolid(x, y)) {
			x -= dx;
			y -= dy;
		}
		// make sprite stop 0.25px from target
		if (distanceToTarget < STOP_DISTANCE_FROM_TARGET) {
			x -= dx;
			y -= dy;
		}
	}
	public void render() {
		image.drawCentered(x,y);
	}

}
