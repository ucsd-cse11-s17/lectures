// When possible, use _methods_ on objects of other classes,
// _not_ the fields.

// This means we will prefer implementation D

// B:

// Uses _fields_ on points (x and y)
boolean contains(Point toCheck) {
  return Math.abs(toCheck.x - this.center.x) <= (this.sideLength / 2) &&
         Math.abs(toCheck.y - this.center.y) <= (this.sideLength / 2);
}

// D:

// Uses _methods_ on points (xDistance/yDistance)
boolean contains(Point toCheck) {
  return this.center.xDistance(toCheck) <= (this.sideLength / 2) &&
         this.center.yDistance(toCheck) <= (this.sideLength / 2);
}

