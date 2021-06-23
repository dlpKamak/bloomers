public class Maze implements Explorable {
    private BasicCell[][] theMap;
    // or use a 2D array of chars as an intermediate step
    private char[][] theCharMap;
    private int mouseRow, mouseCol;

    public Maze (String filename)
    {
        /* create the 2D array based on the information read from the
         * file */
    }

    public LineOfSight look (Direction dir)
    {
        LineOfSight view;

        view = new LineOfSight (____);

        /* base on the map and the current mouse location,
         * use addDoor and addTarget to build the current line of sight */

        view.addDoor (____, ____);  // if there is another opening ....

        view.addTarget (___); // if the cheese is in sight

        return view;
    }

    public void moveExplorer (Direction dir)
    {
        /* change mouse row & column */
    }

    public LineOfSight push (Direction dir)
    {
    }

    public double smell (Direction dir)
    {
        /* calculate the "strength" of the cheese smell from the
         * current position */
        return 0.0;
    }
}



