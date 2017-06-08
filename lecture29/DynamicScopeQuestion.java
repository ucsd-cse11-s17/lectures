public class DynamicScopeQuestion {

  // 5. Suppose somewhere in your program you have:
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

/** 5. What does question() return?

* A: 0
* B: 4
* C: Something else

*/

}
