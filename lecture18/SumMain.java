class SumMain {
  public static void main(String[] args) {

    double total = 0;  // VARIABLE declaration/definition
    for(String thisString: args) { // Element for loop
      total = total + Double.parseDouble(thisString); // variable ASSIGNMENT
    }

    System.out.println(total);

  }
}
