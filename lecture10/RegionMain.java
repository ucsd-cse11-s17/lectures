import javalib.worldimages.*;
import javalib.funworld.*;
import java.awt.Color;

class RegionWorld extends World {
  static final int WIDTH = 500, HEIGHT = 500, HALF = 250;
  Region r;
  public RegionWorld(Region r) {
    this.r = r;
  }
  public WorldScene makeScene() {
    WorldScene theScene = this.getEmptyScene()
      .placeImageXY(new RectangleImage(1, HEIGHT, OutlineMode.SOLID, Color.BLACK), HALF, HALF)
      .placeImageXY(new RectangleImage(WIDTH, 1, OutlineMode.SOLID, Color.BLACK), HALF, HALF);
    for(int i = 0; i < WIDTH; i += 1) {
      for(int j = 0; j < HEIGHT; j += 1) {
        if(this.r.contains(new Point(i / 10, j / 10))) {
          theScene = theScene.placeImageXY(new CircleImage(1, OutlineMode.SOLID, Color.GRAY), i + HALF, HALF - j);
        }
      }
    }
    return theScene;
  }
}

public class RegionMain {
  public static void main(String[] args) {
    new RegionWorld(new ExamplesRegion().toDraw).bigBang(RegionWorld.WIDTH, RegionWorld.HEIGHT);
  }
}
