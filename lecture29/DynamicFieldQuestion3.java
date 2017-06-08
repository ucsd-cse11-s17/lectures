public class DynamicFieldQuestion3 {

  int x = 0;

  int f() {
    int x = 17;
    return g();
  }

  int g() {
    int y = 4;
    return x / y;
  }

  int question() {
    return f();
  }

//

/** What does question() return?

* A: 0
* B: 4
* C: Something else

*/

}
