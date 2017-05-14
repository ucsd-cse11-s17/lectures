class CalcMain {
  public static void main(String[] args) {

    /*
        java CalcMain sum 3 4 5
        12

        java CalcMain product 3 4 5
        60
    */

    if(args[0].equals("sum")) {
      double total = 0;
      // Counted for loop
      for(int index = 1; index < args.length; index = index + 1) {
        total = total + Double.parseDouble(args[index]);
      }
      System.out.println(total);
    }
    else if(args[0].equals("product")) {

    }

  }
}
