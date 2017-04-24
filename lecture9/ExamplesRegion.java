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
  boolean contains(Point toCheck);
}

class ComboRegion implements Region { // for representing the region covered by two others
  Region region1;
  Region region2;
  // Fill in the usual constructor
  boolean contains(Point toCheck) {
    return this.region1.contains(toCheck) ||
           this.region2.contains(toCheck);
  }
}
class SquareRegion implements Region {
  Point center;
  double sideLength;
  SquareRegion(Point center, double sideLength) {
    this.center = center;
    this.sideLength = sideLength;
  }


  boolean contains(Point toCheck) {
    return this.center.xDistance(toCheck) <= (this.sideLength / 2) &&
           this.center.yDistance(toCheck) <= (this.sideLength / 2);
  }
}
class CircleRegion implements Region {
  Point center;
  double radius;
  CircleRegion(Point center, double radius) {
    this.center = center;
    this.radius = radius;
  }
  boolean contains(Point toCheck) {
    return this.center.distance(toCheck) <= this.radius;
  }
}

class ExamplesRegion {
  CircleRegion c1 = new CircleRegion(new Point(5, 5), 10);
  SquareRegion s1 = new SquareRegion(new Point(6, 6), 12);
  boolean sc1 = c1.contains(new Point(8, 8));
}
