class ExamplesLec {
  boolean fourIsLessThanFive = 4 < 5;
  boolean fourIsGreaterThanFive = 4 > 5;
  boolean fieldContainingTrue = true;

  boolean fourIsFour = 4 == 4;
  boolean fourIsNotFour = 4 == 5;

  // >, <, >=, <=, == are comparison operators returning booleans

  boolean and1 = true && true;
  boolean and2 = true && false;
  boolean and3 = false && true;
  boolean and4 = false && false;

  boolean or1 = true || true;
  boolean or2 = true || false;
  boolean or3 = false || true;
  boolean or4 = false || false;

  // Write a method that takes a number and returns
  // true if it's in the region on the right
  boolean numberLine1(int number) {
    return number >= 2;
  }

  boolean example1 = this.numberLine1(2);
  boolean example2 = this.numberLine1(5);
  boolean example3 = this.numberLine1(-1);

  boolean numberLine2(int number) {
    return ((number > 5) && (number < 7))
              || (number < 2);
  }

  boolean nl2a = this.numberLine2(6);

  // Write a method absolute value that takes a number
  // and returns the negation if it's less than 0,
  // or that number otherwise
  int absolute(int number) {
    if(number < 0) {
      return -1 * number; // then branch
    }
    else {
      return number; // else branch
    }
  }


  int abs1 = this.absolute(-2); // should produce 2
  int abs2 = this.absolute(4); // should produce 4


  // weeklyPay: takes a number of hours worked and a
  // hourly rate, and returns the pay, with overtime
  // (over 40 hours) counting at double the rate
  // Assume: hours and rate are both positive
  int weeklyPay(int hours, int rate) {
    if(hours > 40) {
      return (40 * rate) + ((hours - 40) * (rate * 2));
    }
    else {
      return (hours * rate);
    }
  }

  int wp1 = this.weeklyPay(45, 10); // 500
  int wp2 = this.weeklyPay(35, 10); // 350
  int wp3 = this.weeklyPay(-9, 10); 

  


}

