import org.newdawn.slick.tiled.TiledMap;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class Map {
	private TiledMap map;
	private int mapWidth, mapHeight;
	private int tileWidth, tileHeight;
	public Map(String map) throws SlickException{
		this.map = new TiledMap(map);
		mapWidth = this.map.getTileWidth() * this.map.getWidth();
		mapHeight = this.map.getTileHeight() * this.map.getHeight();
		tileWidth = this.map.getTileWidth();
		tileHeight = this.map.getTileHeight();
	}
	public int getMapWidth() {
		return mapWidth;
	}
	public int getMapHeight() {
		return mapHeight;
	}
	public void render(int  x, int y) {
		map.render(x, y);
	}
	public int getTileWidth() {
		return tileWidth;
	}
	public int getTileHeight() {
		return tileHeight;
	}
	// get tile id from coordinate (x, y)
	public int tileId(float x, float y) {
		return map.getTileId((int)(x / map.getTileWidth()), (int)(y / map.getTileHeight()), 0);
	}
	// determine weather a tile is solid or not from a give coordinate (x, y)
	public boolean isSolid(float x, float y) {
		String property = map.getTileProperty(tileId(x, y), "solid", "false");
		return Boolean.parseBoolean(property);
	}

}
