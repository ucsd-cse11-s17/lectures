import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.io.IOException;

class Search {

  // We've seen lots of methods like this before; this just uses List<String>
  // instead of String[], so .size() instead of length, and .get(i) instead of
  // [i].
  static int find(List<String> strs, String toFind) {
    for(int i = 0; i < strs.size(); i += 1) {
      if(strs.get(i).equals(toFind)) { return i; }
    }
    return -1;
  }

  // This is the same as from lecture last week, just abstracted into a method
  static List<String> readFileByName(String filename) {
    try {
      List<String> lines = Files.readAllLines(
          Paths.get(filename),
          Charset.forName("UTF-8"));
      for(int i = 0; i < lines.size(); i += 1) {
        lines.set(i, lines.get(i).toLowerCase());
      }
      return lines;
    }
    catch(IOException e) {
      System.out.println("Couldn't read the file: " + filename);
      return null;
    }
  }

  // currentTimeMillis() returns a (big) number since the "epoch", which is
  // January 1, 1970

  // See https://en.wikipedia.org/wiki/Epoch_(reference_date)#Computing
  // History is fun!  And weird.

  // A "long" is like an int, but can hold even bigger numbers:
  // int is -2^31 <-> 2^31
  // long is -2^63 <-> 2^63

  // Methods like this are common ways to do a very simple time estimate for
  // how long a (part of a) program takes
  static void timeFind(List<String> words, String toFind) {
    long start = System.currentTimeMillis(); 
    int result = betterFind(words, toFind, 0, words.size() - 1);
    long end = System.currentTimeMillis();
    System.out.println("It took " + (end - start) + " milliseconds to find "
        + toFind + " on line " + result);
  }

  // Usage:
  //  java Search path/to/words search-term
  //
  // Where path/to/words is the path to some file that has a different word on
  // each line in sorted order, and search-term is the word to search for in
  // that file
  public static void main(String[] args) {
    List<String> words = readFileByName(args[0]);

    timeFind(words, args[1]);
  }








  static int betterFind(List<String> strs, String toFind, int start, int end) {
    if(start > end) { return -1; }
    int middle = start + ((end - start) / 2);
    if(strs.get(middle).equals(toFind)) { return middle; }
    if(strs.get(middle).compareTo(toFind) < 0) {
      return betterFind(strs, toFind, middle + 1, end);
    }
    else {
      return betterFind(strs, toFind, start, middle -1);
    }
  }

}
