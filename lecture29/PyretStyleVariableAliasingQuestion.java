public class PyretStyleVariableAliasingQuestion {

  // 4. Suppose somewhere in your program you have:
  void FX(Office o1) {
    Office o = o1;
    o = new Office("CS", 640, "Walter");
  }

  String question() {
    Office dillonOffice = new Office("CS", 808, "Dillon");
    FX(dillonOffice);
    return dillonOffice.occupant;
  }

/** 4. What does question() return?

 * A: "Dillon"
 * B: "Walter"
 * C: Something else

 */

}
