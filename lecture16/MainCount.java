class MainCount {
  public static void main(String[] args) {
    int students = args[1];
    int staff = args[2];
    int ratio = students / staff;
    System.out.println(
      "There are " + ratio + " students/staff in " + args[0]
    );  
  }
}
