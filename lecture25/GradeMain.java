import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.io.IOException;

class GradeMain {
  static void computeStatistics(List<String> lines) {
    for(String line: lines) {
      String[] pieces = line.split(",");
      double sum = 0;
      for(int i = 1; i < pieces.length; i += 1) {
        sum += Double.parseDouble(pieces[i]);
      }
      System.out.println("Average for " + pieces[0] + " is: " + sum / (pieces.length - 1));
    }
  }

  public static void main(String[] args) {
    String filename = args[0];
    try {
      List<String> lines = Files.readAllLines(
          Paths.get(filename),
          Charset.forName("UTF-8"));

      computeStatistics(lines);
    }
    catch(IOException e) {
      System.out.println("Couldn't read the file: " + filename);
    }
  }
}
