class Array2DMain {

  // boolean contains(Point p)

  // Create a grid, with "X" for each point contained in a given
  // region, or " " if not contained
  // Idea: configure the character used
  static String[][] regionGrid(Region r, int rows, int cols) {
    String[][] grid = new String[rows][cols];
    for(int row = 0; row < rows; row += 1) {
      for(int col = 0; col < cols; col += 1) {
        if(r.contains(new Point(col, row))) {
          grid[row][col] = "X ";
        }
        else {
          grid[row][col] = "  ";
        }
      }
    }
    return grid;
  }

  public static void main(String[] args) {
    Region c = new IntersectRegion(
      new CircleRegion(new Point(10, 10), 8),
      new SquareRegion(new Point(2, 10), 6));

    System.out.println(gridToString(regionGrid(c, 20, 20)));

    String[][] ttt = {
      {"X", "O", " "},
      {"X", "X", " "},
      {"O", "X", "O"}
    };



    // Where should O move to stop X from winning?
    // A: ttt[1][2]
    // B: ttt[2][1]
    // C: ttt[1][2]
    // D: ttt[0][1]
    // E: None of the above


    // What is an appropriate type to fill in below?

    String[] s = ttt[0];

    // A: String
    // B: String[]
    // C: String[][]

  }

  static String gridToString(String[][] grid) {
    String result = "";

    for(String[] row: grid) {
      for(String s: row) {
        result = result + s;
      }
      result = result + "\n";
    }

    return result;
  }

}
