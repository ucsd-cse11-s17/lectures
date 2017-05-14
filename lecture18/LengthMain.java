class LengthMain {
  // Write a main method that calculates the sum of the lengths of
  // the strings provided as command-line arguments
  public static void main(String[] args) {
    int totalLength = 0;
    for(String s: args) {
      totalLength = totalLength + s.length();
    }
    System.out.println(totalLength);
  }
}
/*
A   int totalLength = 0;
    for(String s: args) {
      totalLength = totalLength + Integer.parseInt(s);
    }
    System.out.println(totalLength);

B   int totalLength = 0;
    for(String s: args) {
      totalLength = totalLength + Integer.parseInt(s).length();
    }
    System.out.println(totalLength);

C   int totalLength = 0;
    for(String s: args) {
      totalLength = totalLength + s.length; // length on String NOT a field
    }
    System.out.println(totalLength);

*/
