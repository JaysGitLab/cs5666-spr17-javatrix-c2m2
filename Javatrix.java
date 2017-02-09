/**
 * Javatrix.java
 *
 * @author Kara Beason
 * @author Cydney Caldwell
 * @author Michelle Melton
 * @version Feb 2017
 */

/**
 * Provides fundamental operations of numerical linear algebra.
 *
 * @author Kara Beason
 * @author Cydney Caldwell
 * @author Michelle Melton
 * @version Feb 2017
 */
public class Javatrix extends java.lang.Object 
    implements java.lang.Cloneable, java.io.Serializable 
{
    // Make this private after getArray() is implemented.
    // Need to access for unit tests for constructors initially.
    double[][] matrix;
    private int m;
    private int n;

    /**
     * Construct an m-by-n matrix of zeros.
     *
     * @param m number of rows
     * @param n number of columns
     */
    public Javatrix(int m, int n)
    {
        matrix = new double[m][n];
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                matrix[i][j] = 0;
            }
        }
    }

    /**
     * Construct an m-by-n constant matrix.
     *
     * @param m number of rows
     * @param n number of columns
     * @param s fill the matrix with this scalar value
     */
    public Javatrix(int m, int n, double s)
    {
        matrix = new double[m][n];
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                matrix[i][j] = s;
            }
        }
    }

    /**
     * Get a single element.
     *
     * @param i row
     * @param j column
     * @return element at position (i, j)
     * @throws ArrayIndexOutOfBoundsException
     */
    public double get(int i, int j) throws ArrayIndexOutOfBoundsException
    {
        if (i >= m || j >= n)
        {
            throw new ArrayIndexOutOfBoundsException();
        }
        return matrix[i][j];
    }
}
