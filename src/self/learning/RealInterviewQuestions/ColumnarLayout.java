package self.learning.RealInterviewQuestions;

/*
Dropbox Phone Interview:
Problem Statement: Implement ColumnarLayout where views are placed in a column-wise fashion under the parent view.

* * * * * * * * * * * * * * *
*       *     *       *     *
*  4x4  *     *       *     *
*       *     *       *     *
* * * * * * * *  4x7  *     *
*   7x3       *       *     *
*             *       *     *
* * * * * * * * * * * * * * *
*   5x2   *   *  8x3        *
* * * * * *   *             *
* * * * * * * * * * * * * * *

Given: Size of parent view, Array of sizes of child views
Output: Array of points representing origin of child views with respect to parent view coordinates
Assume origin is at the top right corner of a view.

For example: parent view size: 15 x 10
child sizes are: { 4x4, 7x3, 5x2, 4x7, 8x3 }

Output should be: Points[] = { (0,0), (0,4), (0,7), (7,0), (7,7) }
 */

class Point {
    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Size {
    int width;
    int height;
    public Size(int width, int height) {
        this.width = width;
        this.height = height;
    }
}

public class ColumnarLayout {

    public void BuildAndRun()
    {
        Size parentViewSize = new Size(10, 15);
        Size[] childViewSizes = new Size[]
                {
                        new Size(4,4),
                        new Size(7,3),
                        new Size(5, 2),
                        new Size(4,7),
                        new Size(8,3),
        };

        Point[] points = layoutChildViews(parentViewSize, childViewSizes);

        for(Point p : points) {
            if(p != null) {
                System.out.println("(" + p.x + "," + p.y + ")");
            }
        }
    }
    public Point[] layoutChildViews(Size parentViewSize, Size[] childViewSizes) {

        Point[] points = new Point[childViewSizes.length];
        int currColWidth = 0;
        int availableSpace = parentViewSize.height;
        int occupiedWidth = 0;

        for(int i = 0; i < childViewSizes.length; i++)
        {
            if(availableSpace >= childViewSizes[i].height)
            {
                int x = occupiedWidth;
                int y = parentViewSize.height - availableSpace;
                points[i] = new Point(x,y);
                if(currColWidth < childViewSizes[i].width)
                {
                    currColWidth = childViewSizes[i].width;
                }
                availableSpace -= childViewSizes[i].height;
            }
            else if(parentViewSize.width - occupiedWidth >= childViewSizes[i].width) {
                availableSpace = parentViewSize.height;
                occupiedWidth += currColWidth;
                currColWidth = 0;
                i--;
            }
        }
        return points;
        }

    }


