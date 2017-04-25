class Point {
  private double x, y;
  Point(double x, double y) { this.x = x; this.y = y; }
  double distance(Point other) {
    return Math.sqrt(
      Math.pow(this.x - other.x, 2) +
      Math.pow(this.y - other.y, 2));
  }
  double xDistance(Point other) {
    return Math.abs(other.x - this.x);
  }
  double yDistance(Point other) {
    return Math.abs(other.y - this.y);
  }
}

interface Region {
  boolean contains(Point p);
}

class UnionRegion                     {
  Region region1;
  Region region2;
  UnionRegion(Region region1, Region region2) {
    this.region1 = region1;
    this.region2 = region2;
  }
  public boolean contains(Point toCheck) {
    return this.region1.contains(toCheck) ||
           this.region2.contains(toCheck);
  }
  /*
  public boolean contains(Point toCheck) {
    return 
           true;
  }
  */
}

class SquareRegion implements Region {
  Point center;
  double sideLength;
  SquareRegion(Point center, double sideLength) {
    this.center = center;
    this.sideLength = sideLength;
  }
  public boolean contains(Point toCheck) {
    return this.center.xDistance(toCheck) <= (this.sideLength / 2) &&
           this.center.yDistance(toCheck) <= (this.sideLength / 2);
  }
  /*
  public boolean contains(Point toCheck) {
    return false;
  }
  */
}

class CircleRegion implements Region {
  Point center;
  double radius;
  CircleRegion(Point center, double radius) {
    this.center = center;
    this.radius = radius;
  }
  public boolean contains(Point toCheck) {
    return this.center.distance(toCheck) <= this.radius;
  }
}

class ExamplesRegion {
  Region circ = new CircleRegion(new Point(10, 5), 4.0);
  Region square = new SquareRegion(new Point(5, 6), 8);
  UnionRegion ur = new UnionRegion(this.square, this.circ);
  boolean b1 = this.ur.contains(new Point(13, 5));
}
