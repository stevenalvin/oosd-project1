import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;


public class Player {
	private Image image;
	public static final float SPEED = 0.25f;
	private float x;
	private float y;
	private static final float STOP_DISTANCE_FROM_TARGET = 0.25f;
	
	
	public Player() throws SlickException{
		image = new Image("assets/scout.png");
		
	}
	public float getX() {
		return x;
	}
	public float getY() {
		return y;
	}
	
	public void move(float dx, float dy, TiledMap map, float distanceToTarget) {
		
		x += dx;
		y += dy;
		// test this set of code later!!!
		// limiting the sprite movement to only within the map
		if (x < 0) {
			x = 0;
		}
		if (x > map.getWidth()* map.getTileWidth()) {
			x = map.getWidth();
		}
		if (y < 0) {
			y = 0;
		}
		if (y > map.getHeight()*map.getTileHeight()) {
			y = map.getHeight();
		}
		
		int tileId = map.getTileId((int)(x / map.getTileWidth()), (int)(y / map.getTileHeight()), 0);
		String property = map.getTileProperty(tileId, "solid", "false");
		if (Boolean.parseBoolean(property)) {
			x -= dx;
			y -= dy;
		}
		if (distanceToTarget < STOP_DISTANCE_FROM_TARGET) {
			x -= dx;
			y -= dy;
		}
	}
	public void render() {
		image.drawCentered(x,y);
	}

}
