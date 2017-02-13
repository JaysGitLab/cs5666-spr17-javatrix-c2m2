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
     * Get column dimension.
     *
     * @return n number of columns
     */
    public int getColumnDimension()
    {
        return n;
    }

    /**
     * Get row dimension.
     *
     * @return m number of rows
     */
    public int getRowDimension()
    {
        return m;
    }

    /**
     * Copy the internal two-dimensional array.
     *
     * @return matrixCopy copy of internal array
     */
    public double[][] getArrayCopy()
    {
        double[][] matrixCopy = new double[m][n];
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                matrixCopy[i][j] = matrix[i][j];
            }
        }
        return matrixCopy;
    }

    /**
     * Set a single element.
     *
     * @param i row index
     * @param j column index
     * @param s value to set to
     * @throws ArrayIndexOutOfBoundsException (i, j) out of bounds
     */
    public void set(int i, int j, double s) 
        throws ArrayIndexOutOfBoundsException
    {
        if (i >= m || j >= n)
        {
            throw new ArrayIndexOutOfBoundsException("Index out of bounds");
        }
        matrix[i][j] = s;
    }

    /**
     * Construct a matrix from a copy of a 2-D array.
     *
     * @param arr Two-dimensional array of doubles
     * @return actual Matrix 
     * @throws IllegalArgumentException if rows have different length
     */
    public static Javatrix constructWithCopy(double[][] arr) 
        throws IllegalArgumentException
    {
        int cols = arr[0].length;
        for (int i = 1; i < arr.length; i++)
        {
            if (arr[i].length != cols)
            {
                throw new IllegalArgumentException(
                    "All rows must have same length");
            }
        }

        Javatrix actual = new Javatrix(arr);
        return actual;
    }
}

