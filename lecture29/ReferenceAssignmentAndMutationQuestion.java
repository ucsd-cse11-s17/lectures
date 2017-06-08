public class ReferenceAssignmentAndMutationQuestion {

  // 2. Suppose somewhere in your program you have:
  void FX(Office o1, Office o2) {
    o2 = o1;
    o2.room = 63;
  }

  String question() {
    Office labOffice = new Office("CS", 130, "Tyler Smith");
    Office commonOffice = new Office("CS", 275, "everyone");
    FX(labOffice, commonOffice);
    return labOffice.room + ", " + commonOffice.room;
  }

/** 2. What does question() return?

* A: "63, 63"
* B: "63, 275"
* C: "130, 63"
* D: "130, 275"
* Something else

*/

}
