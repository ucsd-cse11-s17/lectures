public class ComposeObjectsQuestion {

  // 3. Suppose somewhere in your program you have:
  void FX (Office o1) {
    Building bill = new Building(o1);
    bill.office.room = 999;
  }

  int question() {
    Office peterOffice = new Office("CS", 37, "Peter Gibbons");
    Building cs = new Building(peterOffice);
    FX(peterOffice);
    return cs.office.room;
  }

/** 3. What does question() return?

* A: 37
* B: 999
* C: Something else

*/

}
