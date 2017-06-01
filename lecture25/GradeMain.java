import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.io.IOException;

class GradeMain {
  static void computeStatistics(List<String> lines) {
    
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
