class VariableAliasingQuestion {

  // 1. Suppose somewhere in your program you have:
  void FX(Office forOffice, String toOccupant) {
    forOffice = new Office(forOffice.building, forOffice.room, toOccupant);
  }

  String question() {
    Office carmenOffice = new Office("CS", 176, "Carmen");
    FX(carmenOffice, "Fred");
    return carmenOffice.occupant;
  }

//

/** 1. What does question() return?

* A: "Carmen"
* B: "Fred"
* C: Something else

*/

}
