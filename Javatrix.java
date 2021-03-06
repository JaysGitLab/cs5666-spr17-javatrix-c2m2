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
     * Constructor 1D array.
     *
     * @param m number of rows
     * @param vals stored by columns
     * @throws IllegalArgumentException if length of 
     * val is not a multiple of m
     */
    public Javatrix(double[] vals, int m) throws IllegalArgumentException
    {
        int rows = m;
        int columns = (vals.length) / m;
        int reman = (vals.length) % m;

        if (reman != 0)
        {
            String ex = "Array length must me a multiple of m.";
            throw new IllegalArgumentException(ex);
        }
        matrix = new double[rows][columns];
        int count = 0;
        for (int j = 0; j < columns; j++)
        {
            for (int i = 0; i < rows; i++)
            {
                matrix[i][j] = vals[count];
                count++;
            }
        }
    }

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
        for (int i = 0; i < m; i++)
        {
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
     * Generate an m by n identitiy matrix.
     *
     * @param m number of rows
     * @param n number of columns
     * @return Javatrix with m by n identity matrix
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

    /**
     * Construct a matrix C = A - B.
     *
     * @param actualB another matrix
     * @return A - B
     */
    public Javatrix minus(Javatrix actualB)
    {
        m = actualB.getRowDimension();
        n = actualB.getColumnDimension();
        Javatrix actual = new Javatrix(m, n);
        double a;
        double b;
        double c;
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                a = this.get(i, j);
                b = actualB.get(i, j);
                c = a - b;
                actual.set(i, j, c);
            }
        }
        return actual;
    }

    /**
     * Return calling matrix A = A - B.
     *
     * @param actualB calling matrix
     * @return A - B
     */
    public Javatrix minusEquals(Javatrix actualB)
    {
        m = actualB.getRowDimension();
        n = actualB.getColumnDimension();
        double a;
        double b;
        double c;
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                a = this.get(i, j);
                b = actualB.get(i, j);
                c = a - b;
                this.set(i, j, c);
            }
        }
        return this;
    }
    
    /**
     * Construct a matrix C = A + B.
     *
     * @param actualB another matrix
     * @return A + B
     */
    public Javatrix plus(Javatrix actualB)
    {
        m = actualB.getRowDimension();
        n = actualB.getColumnDimension();
        Javatrix actual = new Javatrix(m, n);
        double a;
        double b;
        double c;
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                a = this.get(i, j);
                b = actualB.get(i, j);
                c = a + b;
                actual.set(i, j, c);
            }
        }
        return actual;
    }

    /**
     * Return calling matrix A = A + B.
     *
     * @param actualB calling matrix
     * @return A + B
     */
    public Javatrix plusEquals(Javatrix actualB)
    {
        m = actualB.getRowDimension();
        n = actualB.getColumnDimension();
        double a;
        double b;
        double c;
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                a = this.get(i, j);
                b = actualB.get(i, j);
                c = a + b;
                this.set(i, j, c);
            }
        }
        return this;
    }

    /**
     * Generate a matrix with random elements.
     *
     * @param m number of rows
     * @param n number of columns
     * @return a Javatrix object with matrix of random elements
     */
    public static Javatrix random(int m, int n)
    {
        Javatrix randomMatrix = new Javatrix(m, n);
        for (int i = 0; i < m; i++)
        {
            double rand;
            for (int j = 0; j < n; j++)
            {
                rand = java.lang.Math.random();
                randomMatrix.set(i, j, rand);
            }
        }
        return randomMatrix;
    }

    /** 
     * Construct a matrix C = A \ B. 
     * 
     * @return A \ B 
     */ 
    public Javatrix arrayLeftDivide(Javatrix actualB) 
    { 
        m = actualB.getRowDimension(); 
        n = actualB.getColumnDimension(); 
        Javatrix actual = new Javatrix(m, n); 
        double a; 
        double b; 
        double c; 
        for (int i = 0; i < m; i++) 
        { 
            for (int j = 0; j < n; j++) 
            { 
                a = this.get(i, j); 
                b = actualB.get(i, j); 
                c = b / a; 
                actual.set(i, j, c); 
            } 
        } 
        return actual; 
    }     

    /**
     * Construct a matrix C = A / B.
     *
     * @return A / B
     */
    public Javatrix arrayRightDivide(Javatrix actualB)
    {
        m = actualB.getRowDimension();
        n = actualB.getColumnDimension();
        Javatrix actual = new Javatrix(m, n);
        double a;
        double b;
        double c;
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                a = this.get(i, j);
                b = actualB.get(i, j);
                c = a / b;
                actual.set(i, j, c); 
            } 
        } 
        return actual; 
    }

    /**
     * Construct a matrix C = A * s.
     *
     * @param scalar multiplier
     * @return A * s
     */
    public Javatrix times(double scalar)
    {
        m = this.getRowDimension();
        n = this.getColumnDimension();
        Javatrix actual = new Javatrix(m, n);
        double a;
        double b;
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                a = this.get(i, j);
                b = a * scalar;
                actual.set(i, j, b);
            }
        }
        return actual;
    }

    /**
     * Get a submatrix.
     *
     * @param r - an array of row indices
     * @param c - an array of column indices
     * @return submatrix(r(:), c(:))
     * @throws ArrayIndexOutOfBoundsException if submatrix
     * has larger dimensions than this.matrix.
     */
    public Javatrix  getMatrix(int[] r, int[] c)
        throws ArrayIndexOutOfBoundsException
    {
        String ex = "Submatrix must have dimensions "
            + "less than or equal to matrix.";
        if (r.length != c.length || r.length > this.getRowDimension()
             || c.length > this.getColumnDimension())
        {
            throw new ArrayIndexOutOfBoundsException(ex);
        }
        m = r.length;
        n = c.length;
        int row;
        int col;
        Javatrix subMatrix = new Javatrix(m, n);
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (r[i] >= this.getRowDimension()
                    || c[i] >= this.getColumnDimension())
                {
                    throw new ArrayIndexOutOfBoundsException(ex);
                }
                row = r[i];
                col = c[i];
                subMatrix.set(i, j, this.get(row, col));
            }
        }
        return subMatrix;
    }        
   
    /**
     * One norm.
     *
     * @return sum maximum column sum
     */
    public double norm1()
    {
        m = this.getRowDimension();
        n = this.getColumnDimension();
        double sum = 0;
        double tmp = 0;
        for (int j = 0; j < n; j++)
        {
            for (int i = 0; i < m; i++)
            {
                tmp += this.get(i, j);
            }
            if (tmp > sum)
            {
                sum = tmp;
            }
            tmp = 0;
        }
        return sum;

    }

    /**
     * Infinity norm.
     *
     * @return sum maximum row sum
     */
    public double normInf()
    {
        m = this.getRowDimension();
        n = this.getColumnDimension();
        double sum = 0;
        double tmp = 0;
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                tmp += this.get(i, j);
            }
            if (tmp > sum)
            {
                sum = tmp;
            }
            tmp = 0;
        }
        return sum;
    }
    
    /**
     * Frobenius norm.
     * 
     * @return sqrt of sum of squares of all elements
     */
    public double normF()
    {    
        m = this.getRowDimension();
        n = this.getColumnDimension();
        double sum = 0;
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                sum += java.lang.Math.pow(this.get(i, j), 2);
            }
        }
        double normTest = java.lang.Math.sqrt(sum);
        return normTest;
    }

    /**
     * Unary minus.
     *
     * @return -A
     */
    public Javatrix uminus()
    {
        m = this.getRowDimension();
        n = this.getColumnDimension();
        double a;
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                a = this.get(i, j) * -1;
                this.set(i, j, a);
            }
        }
        return this;
    }

    /**
     * Make a deep copy of a matrix.
     * 
     * @return actual copy
     */
    public Javatrix copy()
    {
        m = this.getRowDimension();
        n = this.getColumnDimension();
        Javatrix actual = new Javatrix(this.getArrayCopy());
        return actual;
    }

    /**
     * Make a one-dimensional column packed copy of the internal array.
     *
     * @return copy column packed 1D array
     */
    public double[] getColumnPackedCopy()
    {
        m = this.getRowDimension();
        n = this.getColumnDimension();
        double[] copy = new double[m * n];
        int count = 0;
        for (int j = 0; j < n; j++)
        {
            for (int i = 0; i < m; i++)
            {
                copy[count] = this.getArray()[i][j];
                count++;
            }
        }
        return copy;
    }

    /**
     * Make a one-dimensional row packed copy of the internal array.
     *
     * @return copy row packed 1D array
     */
    public double[] getRowPackedCopy()
    {
        m = this.getRowDimension();
        n = this.getColumnDimension();
        double[] copy = new double[m * n];
        int count = 0;
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                copy[count] = this.getArray()[i][j];
                count++;
            }
        }
        return copy;
    }

    /**
     * Gets the trace of a square matrix.
     *
     * @throws IllegalArgumentException if rows and
     * columns are not the same.
     * @return the trace of the matrix.
     **/
    public double trace() throws IllegalArgumentException
    {
        m = this.m;
        n = this.n;
        double ace = 0;
        if (m != n)
        {
            String ex = "Rows and Columns must be same length.";
            throw new IllegalArgumentException(ex);
        }
        for (int i = 0; i < m; i++)
        {
            ace += this.get(i, i);
        }
        return ace;
    }

    /**
     * Return calling matrix A = A \ B.
     *
     * @return A \ B
     */
    public Javatrix arrayLeftDivideEquals(Javatrix actualB)
    {
        m = actualB.getRowDimension();
        n = actualB.getColumnDimension();
        double a;
        double b;
        double c;
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                a = this.get(i, j);
                b = actualB.get(i, j);
                c = b / a;
                this.set(i, j, c);
            }
        }
        return this;
    }

    /**
     * Return calling matrix A = A / B.
     *
     * @return A / B
     */
    public Javatrix arrayRightDivideEquals(Javatrix actualB)
    {
        m = actualB.getRowDimension();
        n = actualB.getColumnDimension();
        double a;
        double b;
        double c;
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                a = this.get(i, j);
                b = actualB.get(i, j);
                c = a / b;
                this.set(i, j, c);
            }
        }
        return this;
    }

    /**
     * Construct a matrix A = A * s.
     *
     * @param scalar multiplier value
     * @return A * s
     */
    public Javatrix timesEquals(double scalar)
    {
        m = this.getRowDimension();
        n = this.getColumnDimension();
        double a;
        double b;
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                a = this.get(i, j);
                b = a * scalar;
                this.set(i, j, b);
            }
        }
        return this;
    }
}

