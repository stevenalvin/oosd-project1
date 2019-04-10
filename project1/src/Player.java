import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Player {
	private Image image;
	public static final float SPEED = 0.25f;
	private float x;
	private float y;
	
	
	public Player() throws SlickException{
		image = new Image("assets/scout.png");
		
	}
	public float getX() {
		return x;
	}
	public float getY() {
		return y;
	}
	public void move(float dx, float dy) {
		x += dx;
		y += dy;
	}
	public void render() {
		image.drawCentered(x,y);
	}

}
