class Point {
  private double x, y;
  Point(double x, double y) { this.x = x; this.y = y; }
  double distance(Point other) {
    return Math.sqrt(
      Math.pow(this.x - other.x, 2) +
      Math.pow(this.y - other.y, 2));
  }
  double xDistance(Point other) { return Math.abs(other.x - this.x); }
  double yDistance(Point other) { return Math.abs(other.y - this.y); }
}
interface Region {
  boolean contains(Point p);
  Region add(Region other);
  Region overlap(Region other);
}
abstract class ARegion implements Region {
  public Region add(Region other) {
    return new UnionRegion(this, other);
  }
  public Region overlap(Region other) {
    return new IntersectRegion(this, other);
  }
}
abstract class ComboRegion extends ARegion {
  Region region1, region2;
  ComboRegion(Region region1, Region region2) {
    this.region1 = region1;
    this.region2 = region2;
  }
}
abstract class ShapeRegion extends ARegion {
  Point center;
  ShapeRegion(Point center) {
    this.center = center;
  }
}
class UnionRegion extends ComboRegion {
  UnionRegion(Region region1, Region region2) {
    super(region1, region2);
  }
  public boolean contains(Point toCheck) {
    return this.region1.contains(toCheck) ||
           this.region2.contains(toCheck);
  }
}
class IntersectRegion extends ComboRegion {
  IntersectRegion(Region region1, Region region2) {
    super(region1, region2);
  }
  public boolean contains(Point toCheck) {
    return this.region1.contains(toCheck) &&
           this.region2.contains(toCheck);
  }
}
class SquareRegion extends ShapeRegion {
  double sideLength;
  SquareRegion(Point center, double sideLength) {
    super(center);
    this.sideLength = sideLength;
  }
  public boolean contains(Point toCheck) {
    return this.center.xDistance(toCheck) <= (this.sideLength / 2) &&
           this.center.yDistance(toCheck) <= (this.sideLength / 2);
  }
}
class CircleRegion extends ShapeRegion {
  double radius;
  CircleRegion(Point center, double radius) {
    super(center);
    this.radius = radius;
  }
  public boolean contains(Point toCheck) {
    return this.center.distance(toCheck) <= this.radius;
  }
}
class ExamplesARegion {
  Region circ1 = new CircleRegion(new Point(10, 5), 4.0);
  Region sq = new SquareRegion(new Point(10, 1), 8.0);
  Region ir = this.circ1.add(this.sq);
  // To _find_ add method for this.circ1.add:
  //  - First look in CircleRegion
  //  - Not found! So look in ARegion, because CircleRegion extends it
}
