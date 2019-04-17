import org.newdawn.slick.tiled.TiledMap;
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
	// getter for map width in pixel
	public int getMapWidth() {
		return mapWidth;
	}
	// getter for map height in pixel
	public int getMapHeight() {
		return mapHeight;
	}
	// to render the map
	public void render(int  x, int y) {
		map.render(x, y);
	}
	// getter for tile width
	public int getTileWidth() {
		return tileWidth;
	}
	// getter for tile height
	public int getTileHeight() {
		return tileHeight;
	}
	// get tile id from coordinate (x, y)
	public int tileId(float x, float y) {
		return map.getTileId((int)(x / map.getTileWidth()), (int)(y / map.getTileHeight()), 0);
	}
	// determine weather a tile is solid or not from a given coordinate (x, y)
	public boolean isSolid(float x, float y) {
		String property = map.getTileProperty(tileId(x, y), "solid", "false");
		return Boolean.parseBoolean(property);
	}

}
