import tester.*;

class ExamplesArrays {

  // Return the _index_ where str appears in the array,
  // or -1 if it's not found
  int find(String[] strs, String str) {
    for(int i = 0; i < strs.length; i += 1) {
      if(strs[i].equals(str)) {
        return i;
      }
    }
    return -1;
  }

  String[] args = {"one", "two", "three"};
  int find1 = this.find(args, "two"); // 1
  int find2 = this.find(args, "four"); // -1

  double sumEveryOther(double[] numbers) {
    double total = 0;
    for(int i = 0; i < numbers.length; i += 2) {
      total = total + numbers[i];
    }
    return total;
  }

  // Take in an array of doubles, and return their sum
  double sumC(double[] numbers) {
    double total = 0;
    // for-each loop, element-wise for loop, "enhanced" for loop
    for(double num: numbers) {
      total = total + num;
    }
    return total;
  }

  double sumD(double[] numbers) {
    double total = 0;
    for(int i = 0; i < numbers.length; i += 1) {
      total = total + numbers[i];
    }
    return total;
  }


  double[] someNumbers = {1.2, 3.3, 4.4};
  double sumC1 = this.sumC(this.someNumbers);
  double sumD1 = this.sumD(this.someNumbers);

  double[] moreNumbers = {1.2, 3.3, 4.4, 5.4, 6.6};
  double sumEO1 = this.sumEveryOther(this.moreNumbers); // 12.2

}
/*

A:
  double sum(double[] numbers) {
    double total;
    for(double num: numbers) {
      total = total + num;
    }
    return total;
  }

B:
  double sum(double[] numbers) {
    double total = 0;
    for(int i = 0; i < numbers.length; i += 1) {
      total = total + i;
    }
    return total;
  }
*/
