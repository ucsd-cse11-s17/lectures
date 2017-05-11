class Point {
  double x, y;
  Point(double x, double y) { this.x = x; this.y = y; }

  double distToOrigin() {
    return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
  }

  double distTo(Point other) {
    return Math.sqrt(
      Math.pow(this.x - other.x, 2) +
      Math.pow(this.y - other.y, 2));
  }

  double slope(Point other) {
    return (this.y - other.y) / (this.x - other.x);
  }

}

class PointMain {

  Point examplePoint = new Point(3, 4);
  
  public static void main(String[] args) {
    // p, p1, and p2 are _VARIABLES_, which are not parameters or fields

    // String s = "abcd";  s.length();
    // args.length;  <--- no parentheses, it's a field, not a method
    if(args.length == 3 && args[0].equals("distance")) {

      Point p = new Point(Double.parseDouble(args[1]), Double.parseDouble(args[2]));
      System.out.println(p.distToOrigin());

    }

    else if (args.length == 5 && args[0].equals("distance")) {

      Point p1 = new Point(Double.parseDouble(args[1]), Double.parseDouble(args[2]));
      Point p2 = new Point(Double.parseDouble(args[3]), Double.parseDouble(args[4]));
      System.out.println(p1.distTo(p2));
      
    }
    else if (args.length == 5 && args[0].equals("slope")) {

      Point p1 = new Point(Double.parseDouble(args[1]), Double.parseDouble(args[2]));
      Point p2 = new Point(Double.parseDouble(args[3]), Double.parseDouble(args[4]));
      System.out.println(p1.slope(p2));

    }
    else {

      System.out.println("Invalid command!");

    }

    /*
      Say we want to be able to do:

      java PointMain 0 1 2 3

      and get the distance between two points (0, 1) and (2, 3)

      or

      java PointMain 3 4

      and get the distance to the origin
    */
  }
}

