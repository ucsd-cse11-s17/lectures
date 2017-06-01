class Date {
  int day, month, year;
  Date(int day, int month, int year) {
    if(day < 1 || day > 31) {
      throw new IllegalArgumentException("Invalid day: " + day);
    }
    else if(month < 1 || month > 12) {
      throw new IllegalArgumentException("Invalid month: " + month);
    }
    this.day = day;
    this.month = month;
    this.year = year;
  }
}
class ExceptionsMain {
  public static void main(String[] args) {
    Date[] dates = new Date[4];
    try {
      dates[0] = new Date(15, 4, 2018);
      dates[1] = new Date(-1, 4, 2018);
      dates[2] = new Date(1, -4, 2018);
      dates[3] = new Date(1, 4, 2018);
    }
    catch(IllegalArgumentException e) {
      System.out.println(e); // What error prints here?
    }
  }
}
