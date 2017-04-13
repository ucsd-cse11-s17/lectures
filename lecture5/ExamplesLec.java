class Point {
  int x; // uninitialized field definitions, or field defs. without values
  int y;

  // constructor
  Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  // quadrant takes no parameters, and returns a String of
  // which quadrant the point is in
  String quadrant() {
    if(this.x > 0 && this.y > 0) { return "1"; }
    else if(this.x < 0 && this.y > 0) { return "2"; }
    else if(this.x < 0 && this.y < 0) { return "3"; }
    else if(this.x > 0 && this.y < 0) { return "4"; }
    else {
      return "On axis";
    }
  }


}

class ExamplesLec {

  Point fourFivePoint = new Point(4, 5);
  Point negOneThreePoint = new Point(-1, -3);
  Point fourFivePointAgain = this.fourFivePoint;

  String quadA = this.fourFivePoint.quadrant(); // "1"
  String quadB = this.negOneThreePoint.quadrant(); // "3"

}

// What happens when we ./run:
//   new ExamplesLec();
//     Then print it out





































/*

  int greaterThanAt(Line other, int x) {
    return ((this.x * this.slope) + this.yIntercept) >
           ((other.x * other.slope) + other.yIntercept);
  }

  int greaterThanAt(Line other, int x) {
    return ((x * this.slope) + this.yIntercept) >
           ((x * other.slope) + other.yIntercept);
  }

  int greaterThanAt(Line other, int x) {
    return ((x * this.slope) + this.yIntercept) >
           ((x * this.other.slope) + this.other.yIntercept);
  }

*/



