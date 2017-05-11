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
}
class UnionRegion implements Region {
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
  public Region add(Region other) {
    return new UnionRegion(this, other);
  }
}
// Represents all points in region1 that aren't in region2
class SubtractRegion implements Region {
  Region region1;
  Region region2;
  SubtractRegion(Region region1, Region region2) {
    this.region1 = region1;
    this.region2 = region2;
  }
  public boolean contains(Point toCheck) {
    return this.region1.contains(toCheck) &&
           !this.region2.contains(toCheck);
  }
}
class IntersectRegion implements Region {
  Region region1;
  Region region2;
  IntersectRegion(Region region1, Region region2) {
    this.region1 = region1;
    this.region2 = region2;
  }
  public boolean contains(Point toCheck) {
    return this.region1.contains(toCheck) &&
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
  public boolean contains(Point toCheck) {
    return this.center.xDistance(toCheck) <= (this.sideLength / 2) &&
           this.center.yDistance(toCheck) <= (this.sideLength / 2);
  }
  public Region add(Region other) {
    return new UnionRegion(this, other);
  }
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
  Region circ1 = new CircleRegion(new Point(10, 5), 4.0);
  Region sq = new SquareRegion(new Point(10, 1), 8.0);
  Region ir = new IntersectRegion(this.circ1, this.sq);
  Region ur = new UnionRegion(this.circ1, this.sq);

  Region circA = new CircleRegion(new Point(6, 5), 3);
  Region circB = new CircleRegion(new Point(12, 5), 3);
  Region circC = new CircleRegion(new Point(18, 5), 3);

  Region all3Circles =
    new UnionRegion(this.circA, new UnionRegion(this.circB, this.circC));

  Region all3Circles2 =
    this.circA.add(this.circB).add(this.circC);


  // Add "Region add(Region r)" to the Region interface
  // Put add method in CircleRegion


  // Exercise:
  // What region on the right is represented by toDraw?
  Region toDraw = all3Circles;
}
