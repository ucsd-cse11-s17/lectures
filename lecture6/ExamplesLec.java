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
}

class Line {
  int slope;
  int yIntercept;

  Line(int slope, int yIntercept) {
    this.slope = slope;
    this.yIntercept = yIntercept;
  }

  // Write a method calcY that calculates the y value for a given x
  int calcY(int x) {
    return this.slope * x + this.yIntercept;               // C
    return this.yIntercept + this.slope * x;               // D
  }


}

class ExamplesLec {

  Point p1 = new Point(1, 9);
  Point p2 = new Point(2, 3);

  Point added1 = this.p1.add(p2); // 3, 12
  Point added2 = this.p1.add(p1); // 2, 18
  
  Line line1 = new Line(1, 5);
  Line line2 = new Line(3, -5);

  int calcY1 = this.line1.calcY(5); // 10
  int calcY2 = this.line2.calcY(3); // 4

}

