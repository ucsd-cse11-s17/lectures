/*

  Point p1 = new Point(2, 3);
  Point p2 = new Point(5, 5);
  Point p3 = new Point(6, 1);

  boolean iar1 = this.p1.isAboveRight(this.p2); // true
  boolean iar2 = this.p1.isAboveRight(this.p3); // false
  boolean iar3 = this.p1.isAboveRight(this.p1); // false
*/
class Point {
  int x;
  int y;

  Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  // Write a method called add that takes another point
  // and returns a new point with the two x coordinates added and
  // the two y coordinates added as its x and y field
  Point add(Point pointAdded) {
    return new Point(this.x + pointAdded.x, this.y + pointAdded.y);
  }

  // isAboveRight takes another Point and returns true if it
  // is above and to the right of this Point
  boolean isAboveRight(Point other) {
    return this.x < other.x && this.y < other.y;
  }

  // Method header
  // Examples
  // Body

}

class SquareRegion {
  int sideLength;
  Point center;
  SquareRegion(int sideLength, Point center) {
    this.sideLength = sideLength;
    this.center = center;
  }

  // getBiggestCircle: returns a Circle Region that fits just inside
  // this square region
  CircleRegion getBiggestCircle() {
    return new CircleRegion(this.sideLength / 2, this.center);
  }
}

class CircleRegion {
  int radius;
  Point center;
  CircleRegion(int radius, Point center) {
    this.radius = radius;
    this.center = center;
  }
}




class ExamplesLec {
  Point s1Center = new Point(3, 3);
  SquareRegion s1 = new SquareRegion(2, this.s1Center);

  SquareRegion s1_anotherway = new SquareRegion(2, new Point(3, 3));

  CircleRegion gbc1 = this.s1.getBiggestCircle();
    // new CircleRegion(1, new Point(3, 3))


}













