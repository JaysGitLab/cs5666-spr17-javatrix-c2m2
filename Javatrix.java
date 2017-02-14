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
    private double[][] matrix;
    private int m;
    private int n;

    /**
     * Construct a matrix from a 2D array.
     *
     * @param arr - 2D array to be copied into matrix
     * @throws IllegalArgumentException if rows are
     * not the same length.
     **/
    public Javatrix(double[][] arr) throws IllegalArgumentException
    {
        this.m = arr.length;
        this.n = arr[0].length;
        matrix = new double[m][n];
        for (int i = 0; i < m; i++)
        {
            if (arr[i].length != n)
            {
                String ex = "All rows must be the same length.";
                throw new IllegalArgumentException(ex);
            }
            for (int j = 0; j < n; j++)
            {
                matrix[i][j] = arr[i][j];
            }
        }
    }

    /**
     * Construct an x by y matrix from a 2D array.
     * 
     * @param arr - 2D array to be copied into matrix
     * @param x - number of rows
     * @param y - number of columns
     */
    public Javatrix(double[][] arr, int x, int y)
    {
        this.m = x;
        this.n = y;
        matrix = new double[m][n];
        for (int i = 0; i < arr.length; i++)
        {
            for (int j = 0; j < arr[0].length; j++)
            {
                // If index not out of range for arr.
                if (i < m && j < n)
                {
                    matrix[i][j] = arr[i][j]; 
                }
            }
        }
    }

    /**
     * Construct an m-by-n matrix of zeros.
     *
     * @param m number of rows
     * @param n number of columns
     */
    public Javatrix(int m, int n)
    {
        this.m = m;
        this.n = n;
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
        this.m = m;
        this.n = n;
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
     * @throws ArrayIndexOutOfBoundsException if out of bounds of array
     */
    public double get(int i, int j) throws ArrayIndexOutOfBoundsException
    {
        if (i >= m || j >= n)
        {
            throw new ArrayIndexOutOfBoundsException();
        }
        return matrix[i][j];
    }

    /**
     * Access the internal two-dimensional array.
     *
     * @return double[][] pointer to 2D array of matrix elements
     */
    public double[][] getArray()
    {
        return matrix;
    }

    /**
     * Generate an m by n identitiy matrix.
     *
     * @param m number of rows
     * @param n number of columns
     * @return Javatrix with m by n identity matric
     */
    public static Javatrix identity(int m, int n)
    {
        Javatrix identityMatrix = new Javatrix(m, n);
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (i == j)
                {
                    identityMatrix.matrix[i][j] = 1;
                }
            }
        }
        return identityMatrix;
    }
}

