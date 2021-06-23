// Maze.java:  Version 4.1
// Written by Nathanael Berglund
//
// This program creates a maze and allows the user to attempt to solve it.
//------------------------------------------------------------------------
import java.applet.*;
import java.awt.*;
import java.text.*;
import java.awt.event.*;
import java.util.*;

/** A class for creating and displaying a maze on the screen, and
    allowing the user to try to solve it.
    @author Nathanael Berglund */
public class Maze extends Applet
{
  /** A pseudo-random number used to create a different maze every time */
  public Random rand;

  /** The background color of the maze */
  public Color background_color;

  ////////////////////////////////////////////////////////////////////////////
  // Maze creation.
  ////////////////////////////////////////////////////////////////////////////
  /** Indicates whether or not a maze has been created. */
  protected boolean maze_exists;
  /** Indicates if a maze is currently being created. */
  protected boolean maze_creating;

  ////////////////////////////////////////////////////////////////////////////
  // Maze Dimensions.
  ////////////////////////////////////////////////////////////////////////////
  /** How much to offset the maze in order to center it in the x-direction. */
  int offset_x;
  /** How much to offset the maze in order to center it in the y_direction. */
  int offset_y;
  /** The width of the maze in terms of the path width. */
  public int num_columns;
  /** The height of the maze in terms of the path height. */
  public int num_rows;
  /** The width of the paths */
  public int path_width;
  /** The height of the paths. */
  public int path_height;

  ////////////////////////////////////////////////////////////////////////////////////////
  // Maze State.
  ////////////////////////////////////////////////////////////////////////////////////////
  /** Indicates whether the user has solved the maze. */
  public boolean maze_solved;
  /** An array corresponding to the lattice points where paths meet.  Used to keep track of
      where the user has gone in the maze. */
  boolean[][] locations;
  /** Indicates, for each vertical path, what color to color the path and if it is free.
      (not blocked by a wall). */
  int[][] vert_path_colors;
  /** Indicates, for each horizontal path, what color to color the path and if it is free.
      (not blocked by a wall).*/
  int[][] horz_path_colors;
  
  ///////////////////////////////////////////////////////////////////////////////////
  // Visual display.
  ///////////////////////////////////////////////////////////////////////////////////
  /** Let's the user chosse the pen color. */
  public Choice color_chooser;
  /** Button the creates a new maze. */
  public Button reset_button;
  /** TextField that let's the user set the desired number of columns in the maze */
  public TextField num_columns_field;
  /** TextField that let's the user set the desired number of rows in the maze */
  public TextField num_rows_field;
  /** A Canvas which holds the maze and allows the user to draw on it. */
  public MazeCanvas maze_canvas;

  /**
   * Perform initialization for the maze, such as setting the
   * background color, initaializing arrays, etc.
   */
  public void init()
  {
  // Initialize some member variables.
  maze_exists = false;
  maze_creating = false;
  color_chooser = new Choice();
  reset_button  = new Button("Create New Maze");
  num_columns_field = new TextField(4);
  num_rows_field = new TextField(4);
  
    /* APPLET PARAMETERS:
       bgc_red
       bgc_green
       bgc_blue
       num_columns
       num_rows */

    // Get the red, green, and blue color parameters
    int red = 255, green = 255, blue = 255;
    String s = getParameter("bgc_red");
    if (null != s)
      red = Integer.parseInt(s);

    s = getParameter("bgc_green");
    if (null != s)
      green = Integer.parseInt(s);

    s = getParameter("bgc_blue");
    if (null != s)
      blue = Integer.parseInt(s);

    // Set the background color
    background_color = new Color(red, green, blue);
    setBackground(background_color);

    // Get the num_columns parameter.
    s = getParameter("num_columns");
    num_columns = (null == s) ? 50 : Integer.parseInt(getParameter("num_columns"));

    // Get the num_rows parameter.
    s = getParameter("num_rows");
    num_rows = (null == s) ? 50 : Integer.parseInt(getParameter("num_rows"));

    // Add the choices to the color chooser
    color_chooser.add("Eraser");
    color_chooser.add("Red");
    color_chooser.add("Yellow");
    color_chooser.add("Green");
    color_chooser.add("Cyan");
    color_chooser.add("Blue");
    color_chooser.add("Violet");
    color_chooser.add("Black");
    color_chooser.add("White");
    color_chooser.select(1); // Red is the default pen color.

    // Add the reset button
    add(reset_button);

    // Add a text label preceding the ColorChooser
    add(new Label("Pen Color:", Label.RIGHT)); 

    // Add the color chooser
    add(color_chooser);

    // Add a text label preceding the num_columns_field
    add(new Label("Desired Columns:", Label.RIGHT));

    // Add the num_columns_field
    add(num_columns_field);
    num_columns_field.setText(Integer.toString(num_columns));

    // Add a text label preceding the num_rows_field
    add(new Label("Desired Rows:", Label.RIGHT));

    // Add the num_rows_field
    add(num_rows_field);
    num_rows_field.setText(Integer.toString(num_rows));

    // Register the button event handler
    reset_button.addActionListener(new ActionListener(){
                                   public void actionPerformed(ActionEvent e) { reset(); } });

    // Create and add the canvas
    maze_canvas = new MazeCanvas(getSize().width, getSize().height - 33);
      // 33 is the amount of height the top components will take up.
    add(maze_canvas);

  } // end init()

  /** Create/Recreate the maze. */
  public void reset()
  {
    maze_solved = false;

    // Initialize the random number generator, based on the current time.
    rand = new Random(System.currentTimeMillis());

    System.out.println("New maze requested.");
    System.out.println("Requested Columns: " + num_columns_field.getText());
    System.out.println("Requested Rows   : " + num_rows_field.getText());

    maze_creating = true;
    maze_exists = false;

    // Get a pointer to the graphics.
    Graphics g = maze_canvas.getGraphics();
    // Clear screen.
    g.clearRect(0, 0, maze_canvas.getSize().width, maze_canvas.getSize().height);

    // Display the wait string.
    String str = new String("Creating maze, please wait...");
    FontMetrics fm = g.getFontMetrics();
    g.drawString( str,
             (maze_canvas.getSize().width  - fm.stringWidth(str)) / 2,
             (maze_canvas.getSize().height - fm.getHeight()     ) / 2 + fm.getAscent() );
    g.dispose();  // Free the pointer to graphics.

    try
    {
      num_columns = Integer.parseInt(num_columns_field.getText());
      num_rows = Integer.parseInt(num_rows_field.getText());
    }
    catch (Exception e)
    {
      System.out.println("Error: Invalid number or no number in rows or columns field.");
      num_columns = 50;
      num_rows = 50;
      num_columns_field.setText("50");
      num_rows_field.setText("50");
      System.out.println("Columns changed to: 50");
      System.out.println("Rows    changed to: 50");
    }

    // Check for bad values, num_columns and num_rows must be at least 1
    if (num_columns < 1)
    {
      System.out.println("Error: Invalid number in columns field.");
      num_columns = 1;
      num_columns_field.setText("1");
      System.out.println("Columns changed to: 1");
    }
    if (num_rows < 1)
    {
      System.out.println("Error: Invalid number in rows field.");
      num_rows = 1;
      num_rows_field.setText("1");
      System.out.println("Rows changed to: 1");
    }

    /* Set the values for the path_width, and path_height.  (Note that
       we take (num_columns + 2), and (num_rows + 2) because we want there to be
       1 path of blank space to either side of the maze) */

    path_width =  ( maze_canvas.getSize().width  / (num_columns + 2));
    path_height = ( maze_canvas.getSize().height / (num_rows    + 2));

    // Check for bad values, path_width and path_height must be at least 2
    if (path_width < 2)
    {
      path_width = 2;
        // recompute num_columns
      num_columns = (maze_canvas.getSize().width / 2) - 2;
      num_columns_field.setText(Integer.toString(num_columns));
      System.out.println("Error: Too many columns.");
      System.out.println("Columns changed to: " + num_columns);
    }
    if (path_height < 2)
    {
      path_height = 2;
        // recompute num_rows
      num_rows = (maze_canvas.getSize().height / 2) - 2;
      num_rows_field.setText(Integer.toString(num_rows));
      System.out.println("Error: Too many rows.");
      System.out.println("Rows changed to: " + num_rows);
    }

    // Initialize the arrays
    locations        = new boolean[num_columns][num_rows ];
    vert_path_colors = new int[num_columns][num_rows - 1];
    horz_path_colors = new int[num_columns - 1][num_rows];
    
    // Intialize the maze to have no paths.
    int i, j;
    for (i = 0; i < num_columns - 1; i++)
    {
      for (j = 0; j < num_rows - 1; j++)
      {
        vert_path_colors[i][j] = 0;
        horz_path_colors[i][j] = 0;
      }
      horz_path_colors[i][num_rows - 1] = 0;
    }
    for (j = 0; j < num_rows - 1; j++)
      vert_path_colors[num_columns - 1][j] = 0;

    // Add paths to the maze
    System.out.print("Calculating random maze... ");
    addPaths();
    System.out.println("done.");

    maze_creating = false;
    maze_exists = true;

    // Reset the locations for the begining of the game.
    int a, b;
    for (b = 0; b < num_rows; b++)
      for (a = 0; a < num_columns; a++)
        locations[a][b] = false;
    locations[0][0] = true;

    // Determine the offset values to center the maze.
    offset_x = (maze_canvas.getSize().width  - num_columns*path_width) / 2;
    offset_y = (maze_canvas.getSize().height - num_rows*path_height  ) / 2;

    // Print information about the maze.
    System.out.println("New maze created.");
    System.out.println("Stats: ");
    System.out.println("       Canvas dimensions : " + maze_canvas.getSize().width + " x " +
                       maze_canvas.getSize().height);
    System.out.println("       Maze dimensions   : " + num_columns*path_width + " x " +
                       num_rows*path_height);
    System.out.println("       Rows              : " + num_rows);
    System.out.println("       Columns           : " + num_columns);
    System.out.println("       Path width        : " + path_width);
    System.out.println("       Path height       : " + path_height);

    // Draw the maze.
    maze_canvas.repaint();

  } // end reset()


  /**
   * Add paths to a maze that has just been initialized and does not 
   * yet have any paths.
   */
  void addPaths()
  // Add paths to the maze
  {
    /*   The array "partition_array" will help us keep track of which locations are connected by
       a series of paths.  Define partition_array[n] to be a node, for appropriate values of n.
         Then:
       partition_array[n][0] = k, where k is used as a reference to the node: partition_array[k].
       partition_array[n][1] = j.  When this node references itself, j is defined to be the
       maximum number of pointers that one needs to follow to get from any node "equivalent" to
       this one to reach this one, and determine that this one points to itself.  We don't care
       what j is when this node doesn't reference itself.
         Two nodes will be defined as "equivalent" when one node can be reached from the other
       by following a series of references from one to the other.  Our goal is to create the
       array such that two points in the maze are connected by a series of paths exactly when
       the nodes corresponding to them in partition_array are "equivalent".
         We want to group the nodes into equivalence classes, so that in each class there is
       exactly one node that references itself, and we can get to that node from all of the
       other nodes in the equivalence class. */
    int[][] partition_array = new int[num_columns * num_rows][2];
    
    int a, b; // temporary variables
    for (a = 0; a < num_columns * num_rows; a++)
    {
      partition_array[a][0] = a; // Make each node reference itself intially.
      partition_array[a][1] = 1; // Only 1 pointer needs to be followed to reach a node from
                                 // itself.
    }
    
    // (num_columns * num_rows) - 1 is the number of paths that
    // need to be created so that all lattice points are
    // accessible.  It is also not possible to create any more
    // paths than this without creating a "loop" in the maze.
    boolean almostFinished = false; // Indicates that "most" of the maze is not finished.
    int pathTotal = (num_columns * num_rows) - 1; // Total paths the maze will have.
    int almostTotal = 15 * pathTotal / 16; // How many paths make "most" of the maze finished.
    int x1, y1, x2, y2; // Coordinates of points we're trying to connect.
    int paths = 0; // Number of paths cureently in the maze.

    while (paths < pathTotal)
    {
      // Add another path

      /* Pick any lattice point in the maze.  Then try to draw a path from it to a randomly
         selected adjacent point.  The only restriction is that you cannot connect two lattice
         points already connected by a series of paths, for this will result in a "loop". */
      if (paths < almostTotal)
      // If the maze is not yet close to complete,
      // choose paths randomly.
      {
        x1 = Math.abs(rand.nextInt() % num_columns);
        y1 = Math.abs(rand.nextInt() % num_rows);

        // Attempt to create a path from this point.
        a = 2 * Math.abs(rand.nextInt() % 2) - 1;
        b = 2 * Math.abs(rand.nextInt() % 2) - 1;
        x2 = x1 + (a + b) / 2;
        y2 = y1 + (a - b) / 2;

        if (addAPath(partition_array, x1, y1, x2, y2)) paths++;
      }
      else
      // At this point, we search for availible paths systematically rather than randomly.
      {
        x1 = 0;
        y1 = 0;
        int dx = 1; // x-direction of path.
        int dy = 0; // y-direction of path.
        int tx = 0; // temporary variable.
        int i;      // looping variable.

        for (x1 = 0; x1 < num_columns; x1++)
        {
          for (y1 = 0; y1 < num_rows; y1++)
          {
            x2 = x1 + dx;
            y2 = y1 + dy;

            for (i = 0; i < 4; i++)
            {
              if (addAPath(partition_array, x1, y1, x2, y2)) paths++;
              
              // Rotate clockwise
              tx = -dy;
              dy = dx;
              dx = tx;
            } // end for (for i = 0...
          } // end for (y1 = 0...
        } // end for (x1 = 0...
      } // end if (paths < almostTotal) else
    } // end while (paths < pathsTotal)
  } // end addPaths

  /** Takes a partition_array (as described in addPaths()), and the values of two points we
      want to connect via a path, and attempts to create a path between them.  Returns true if
      successful. */
  boolean addAPath(int[][] partition_array, int x1, int y1, int x2, int y2)
  {
    // Make sure we are in the valid range for the maze.
    if ((x2 >= 0) && (x2 < num_columns) && (y2 >= 0) && (y2 < num_rows))
    {
      // Get the nodes corresponding to the points at (x1, y1) and (x2, y2).
      int a = num_columns * y1 + x1;
      int b = num_columns * y2 + x2;
      
      // Starting at "a", follow references until we get one that references itself.
      a = findRepresentative(partition_array, a);
      // Starting at "b", follow references until we get one that references itself.
      b = findRepresentative(partition_array, b);
      
      if (a != b)
      // If is is not equal to b, then there is no sequence of paths between the points.
      {
      // Depending on which value takes longer to reach, set the reference at a to equal
      // b, or vice-versa.  If both values take an equal number of iterations to reach, we
      // must add 1, because upon reaching one, we will have 1 more reference to follow to
      // get to the other one.
      if (partition_array[a][1] < partition_array[b][1])
        partition_array[a][0] = b;
      else
      {
        partition_array[b][0] = a;
        if (partition_array[a][1] == partition_array[b][1])
          partition_array[a][1] += 1;
      }

      // Connect the two vertices with a path
      if (0 == (x2 - x1))
        vert_path_colors[x1][y1 + (y2 - y1 - 1) / 2] = 1;
      else
        horz_path_colors[x1 + (x2 - x1 - 1) / 2][y1] = 1;

      return true;
      } // end if (a != b)
    } // end if ((x2 >= 0) && ...
    return false;
  } // end addAPath(int x1, ...

  /** Recursive function that finds the node representative of a given partition.
      Also optimizes the partition array by setting all of the nodes it visits along
      the way to point to this last node. */
  private int findRepresentative(int[][] partition_array, int a)
  {
    // If "a" does not reference itself, recursively call
    // this function until it does, and to speed things up, set the pointer in "a" to point
    // to this last node.
    if (partition_array[a][0] != a)
      partition_array[a][0] = findRepresentative(partition_array, partition_array[a][0]);
    return partition_array[a][0];
  }

  /** Check to see if the user has solved the maze, and if so, display a window. */
  void checkForWin()
  {
    if (locations[num_columns - 1][num_rows - 1]) // The user has solved the maze.
    {
      maze_solved = true;

      System.out.println("Maze solved!");
      Dialog d = new Dialog(new Frame(), "Maze solved!");
      d.setSize(150, 40);
      
      // The size (in pixels) of the screen.
      Dimension screenDims = getToolkit().getScreenSize();
      // Center the window on the screen.
      d.setLocation((screenDims.width - 150) / 2, (screenDims.height - 40) / 2);
      // Add a windowListener that will close the window.
      d.addWindowListener(new WindowAdapter()
        { public void windowClosing(WindowEvent e) { ((Dialog)e.getSource()).dispose(); } });
      d.show(); // Display the Dialog.
    }
  }

  /** A class that allows the interaction between the user and the screen. */
  class MazeCanvas extends Canvas
  {
    /** Contructor, adds mouse listners. */
    public MazeCanvas(int x, int y)
    {
      super(); // Call the superclass's constructor.

      // Add some classes to listen to the mouse and tell the canvas when to draw input from
      // the user (whenever the mouse is pressed or dragged), and when to check for a win
      // (whenever the mouse is released).
      addMouseListener( new MouseAdapter() {
        public void mousePressed(MouseEvent e) {drawUserInput(e.getX(), e.getY());}
        public void mouseReleased(MouseEvent e) { if (false == maze_solved) checkForWin(); } });
      addMouseMotionListener( new MouseMotionAdapter() {
        public void mouseDragged(MouseEvent e) { drawUserInput(e.getX(), e.getY()); } });

      // Set the size of the maze.
      setSize(x, y);
    }
    
    /**
     * Repaints the applet by drawing the maze and any paths the user has drawn.
     * @param g a reference to the Graphics object on which to draw
     */
    public void paint(Graphics g)
    {
      if (maze_exists)
      // Draw the maze.
      {
        int i, j; // looping variables.
        g.setColor(Color.black); // Maze is to drawn in black.
      
        // Draw the walls of the maze
        // Vertical walls.
        for (i = 0; i < num_columns - 1; i++)
          for (j = 0; j < num_rows; j++)
            if (0 == horz_path_colors[i][j])
          // A vertical wall exists where there is no horizontal path.
            {
              g.drawLine(offset_x + path_width  * (i + 1),
                         offset_y + path_height * j,
                         offset_x + path_width  * (i + 1),
                         offset_y + path_height * (j + 1));
            }
        // Horizontal walls.
        for (i = 0; i < num_columns; i++)
          for (j = 0; j < num_rows - 1; j++)
            if (0 == vert_path_colors[i][j])
            // A horizontal wall exists where there is no vertical path.
            {
              g.drawLine(offset_x + path_width  * i,
                         offset_y + path_height * (j + 1),
                         offset_x + path_width  * (i + 1),
                         offset_y + path_height * (j + 1));
            }

        // Draw the walls around the entrance and exit of the maze.
        g.drawLine(offset_x - path_width, offset_y ,
                   offset_x + num_columns * path_width, offset_y);
        g.drawLine(offset_x + num_columns * path_width, offset_y,
                   offset_x + num_columns * path_width, offset_y + (num_rows - 1) * path_height);
        g.drawLine(offset_x - path_width, offset_y + path_height,
                   offset_x, offset_y + path_height);
        g.drawLine(offset_x, offset_y + path_height,
                   offset_x, offset_y + num_rows * path_height);
        g.drawLine(offset_x + num_columns * path_width, offset_y + (num_rows - 1) * path_height,
               offset_x + (num_columns + 1) * path_width, offset_y + (num_rows - 1) * path_height);
        g.drawLine(offset_x, offset_y + num_rows * path_height,
                   offset_x + (num_columns + 1) * path_width, offset_y + num_rows * path_height);

        // Draw the paths the user has taken
        // Vertical paths.
        for (i = 0; i < num_columns; i++)
        {
          for (j = 0; j < num_rows - 1; j++)
          {
            if (vert_path_colors[i][j] > 1)
            // The color of the path must be non-transparent if we are to draw it.
            {
              switch (vert_path_colors[i][j])
              {
                case 2: g.setColor(Color.red); break;
                case 3: g.setColor(Color.yellow); break;
                case 4: g.setColor(Color.green); break;
                case 5: g.setColor(Color.cyan); break;
                case 6: g.setColor(Color.blue); break;
                case 7: g.setColor(Color.magenta); break;
                case 8: g.setColor(Color.black); break;
                case 9: g.setColor(Color.white); break;            
                default: break;
              }
              // Draw the path.
              g.drawLine(offset_x + path_width  / 2 + path_width  * i,
                         offset_y + path_height / 2 + path_height * j,
                         offset_x + path_width  / 2 + path_width  * i,
                         offset_y + path_height / 2 + path_height * (j + 1));
            }
          }
        }
      
        // Horizontal paths.
        for (i = 0; i < num_columns - 1; i++)
          for (j = 0; j < num_rows; j++)
          {
            if (horz_path_colors[i][j] > 1)
            // The color of the path must be non-transparent if we are to draw it.
            {
              switch (horz_path_colors[i][j])
              {
                case 2: g.setColor(Color.red); break;
                case 3: g.setColor(Color.yellow); break;
                case 4: g.setColor(Color.green); break;
                case 5: g.setColor(Color.cyan); break;
                case 6: g.setColor(Color.blue); break;
                case 7: g.setColor(Color.magenta); break;
                case 8: g.setColor(Color.black); break;
                case 9: g.setColor(Color.white); break;
                default: break;
              }
              // Draw the path.
              g.drawLine(offset_x + path_width  / 2 + path_width  * i,
                         offset_y + path_height / 2 + path_height * j,
                         offset_x + path_width  / 2 + path_width  * (i + 1),
                         offset_y + path_height / 2 + path_height * j);
            }
          }

        // Determine what color pen or the eraser is selected.
        switch (color_chooser.getSelectedIndex())
        {
          case 0: g.setColor(background_color); break;
          case 1: g.setColor(Color.red); break;
          case 2: g.setColor(Color.yellow); break;
          case 3: g.setColor(Color.green); break;
          case 4: g.setColor(Color.cyan); break;
          case 5: g.setColor(Color.blue); break;
          case 6: g.setColor(Color.magenta); break;
          case 7: g.setColor(Color.black); break;
          case 8: g.setColor(Color.white); break;
          default: break;
        }

        // Draw the begining and ending paths (always there)
        g.drawLine(    offset_x + (num_columns - 1) * path_width  + path_width  / 2,
                       offset_y + (num_rows    - 1) * path_height + path_height / 2,
                   2 * offset_x +  num_columns      * path_width,
                       offset_y + (num_rows    - 1) * path_height + path_height / 2);
        g.drawLine(0,                         offset_y + path_height / 2,
                   offset_x + path_width / 2, offset_y + path_height / 2);

      }
      else if (maze_creating) // !maze_exists
      {
        // Clear the screen.
        g.clearRect(0, 0, getSize().width, getSize().height);
        // Display the wait string.
        String str = new String("Creating maze, please wait...");
        FontMetrics fm = g.getFontMetrics();
        g.drawString( str, (getSize().width  - fm.stringWidth(str)) / 2,
                           (getSize().height - fm.getHeight()     ) / 2 + fm.getAscent() );
      } // end if(maze_exists)
    } // end paint()


   /** Draw the paths the user is drawing as he/she is drawing them.
       @param x the x-coordinate of the location clicked
       @param y the y-coordinate of the location clicked */
    public void drawUserInput(int x, int y)
    {
      // Determine what color pen or the eraser is selected.
      int pencolor = color_chooser.getSelectedIndex() + 1;

      int xlp = (int)((x - offset_x)/path_width);
      int ylp = (int)((y - offset_y)/path_height);
      int xof = (x - offset_x) % path_width - path_width / 2;
      int yof = (y - offset_y) % path_height - path_height / 2;
      int xpath = xlp;
      int ypath = ylp;
      boolean path_vertical = false;
      
      boolean path_up    = ((xlp >= 0) &&
			    (xlp < num_columns) &&
			    (ylp >  0) &&
			    (ylp < num_rows) &&
			    (vert_path_colors[xlp][ylp-1] != 0) &&
			    (locations[xlp][ylp] || locations[xlp][ylp-1]));
      boolean path_down  = ((xlp >= 0) &&
			    (xlp < num_columns) &&
			    (ylp >= 0) &&
			    (ylp < num_rows - 1) &&
			    (vert_path_colors[xlp][ylp] != 0) &&
			    (locations[xlp][ylp] || locations[xlp][ylp+1]));
      boolean path_right = ((xlp >= 0) &&
			    (xlp < num_columns - 1) &&
			    (ylp >= 0) &&
			    (ylp < num_rows) &&
			    (horz_path_colors[xlp][ylp] != 0) &&
			    (locations[xlp][ylp] || locations[xlp+1][ylp]));
      boolean path_left  = ((xlp > 0) &&
			    (xlp < num_columns) &&
			    (ylp >= 0) &&
			    (ylp < num_rows) &&
			    (horz_path_colors[xlp-1][ylp] != 0) &&
			    (locations[xlp][ylp] || locations[xlp-1][ylp]));

      int[] tryorder = new int[4];
      if (Math.abs(xof) < Math.abs(yof))
      {
	    tryorder[0] = (yof >= 0) ? 3 : 1;
	    tryorder[1] = (xof >= 0) ? 2 : 4;
	    tryorder[2] = 6 - tryorder[1];
	    tryorder[3] = 4 - tryorder[0];
      }
      else
      {
	    tryorder[0] = (xof >= 0) ? 2 : 4;
	    tryorder[1] = (yof >= 0) ? 3 : 1;
	    tryorder[2] = 4 - tryorder[1];
	    tryorder[3] = 6 - tryorder[0];
      }

      boolean foundpath = false;
      int i = 0;
      while (!foundpath && i < 4)
      {
	switch (tryorder[i])
	{
	case 1:
	  if (path_up)
	  {
	    xpath = xlp;
	    ypath = ylp - 1;
	    foundpath = true;
	    path_vertical = true;
	  }
	  break;
	case 2:
	  if (path_right)
	  {
	    xpath = xlp;
	    ypath = ylp;
	    foundpath = true;
	    path_vertical = false;
	  }
	  break;
	case 3:
	  if (path_left)
	  {
	    xpath = xlp - 1;
	    ypath = ylp;
	    foundpath = true;
	    path_vertical = false;
	  }
	  break;
	case 4:
	  if (path_down)
	  {
	    xpath = xlp;
	    ypath = ylp;
	    foundpath = true;
	    path_vertical = true;
	  }
	  break;
	}
	i++;
      }

      if (foundpath)
      {
	if (path_vertical)
	{
          vert_path_colors[xpath][ypath] = pencolor;
          locations[xpath][ypath] = true;
          locations[xpath][ypath + 1] = true;
	}
	else
	{
	  horz_path_colors[xpath][ypath] = pencolor;
	  locations[xpath][ypath] = true;
	  locations[xpath + 1][ypath] = true;
	}

	// Get a pointer to the graphics.
	Graphics g = getGraphics();
      
	switch (pencolor)
        {
	  case 1: g.setColor(background_color); break;
	  case 2: g.setColor(Color.red); break;
	  case 3: g.setColor(Color.yellow); break;
	  case 4: g.setColor(Color.green); break;
	  case 5: g.setColor(Color.cyan); break;
	  case 6: g.setColor(Color.blue); break;
	  case 7: g.setColor(Color.magenta); break;
	  case 8: g.setColor(Color.black); break;
	  case 9: g.setColor(Color.white); break;
	  default: break;
	}

	if (path_vertical)
	{
	  g.drawLine(offset_x +      path_width   / 2 + path_width  * xpath,
		     offset_y +      path_height  / 2 + path_height * ypath,
		     offset_x +      path_width   / 2 + path_width  * xpath,
		     offset_y + (3 * path_height) / 2 + path_height * ypath);
	}
	else
	{
	  g.drawLine(offset_x +      path_width   / 2 + path_width  * xpath,
		     offset_y +      path_height  / 2 + path_height * ypath,
		     offset_x + (3 * path_width)  / 2 + path_width  * xpath,
		     offset_y +      path_height  / 2 + path_height * ypath);
	}
	g.dispose();
      } // end if (foundpath)
    } // end DrawUserInput()
  } // end class MazeCanvas
} // end class Maze


