import org.junit.Test;
import org.junit.After;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertNotSame;

/**
 * JavatrixTest.java
 *
 * @author Kara Beason
 * @author Cydney Caldwell
 * @author Michelle Melton
 */

/**
 * Class to test Javatrix class.
 *
 * @author Kara Beason
 * @author Cydney Caldwell
 * @author Michelle Melton
 * @version Feb 2017
 */
public class JavatrixTest
{
    private double[][] matrix;
    private int m;
    private int n;

    /**
     * Test constructor that takes a 2D Array.
     */
    @Test
    public void matrix2DArray()
    {
        m = 5;
        n = 4;
        matrix = new double[m][n];
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                // Random number between 1 and 10.
                matrix[i][j] = java.lang.Math.random() * 10 + 1; 
            }
        }
        Javatrix actual = new Javatrix(matrix);
        assertArrayEquals(matrix, actual.matrix);
    }

    /**
     * Test constructor that takes a 2D Array
     * with invalid argument.
     */
    @Test(expected = IllegalArgumentException.class)
    public void matrix2DArrayThrowsException()
    {
        m = 2;
        n = 2;
        matrix = new double[m][];
        matrix[0] = new double[n];
        matrix[1] = new double[3];

        Javatrix actual = new Javatrix(matrix);
    }

    /**
     * Test constructor that takes a 2D Array with m and n dimemsions given.
     */
    @Test
    public void matrix2DArrayWithDimensions()
    {
        m = 3;
        n = 2;

        // Array that will be truncated by the constructor.
        matrix = new double[5][4]; 
        // The array for comparison to constructor array.
        double[][] expected = new double[m][n];

        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                matrix[i][j] = java.lang.Math.random() + 10 * 1;
                if (i < m && j < n)
                {
                    expected[i][j] = matrix[i][j];
                }
            }
        }

        Javatrix actual = new Javatrix(matrix, m, n);
        assertArrayEquals(expected, actual.matrix);
    }

    /**
     * Test constructor that takes a 2D array and 
     * constructs a larger m by n matrix.
     */
    @Test
    public void matrix2DArrayLargerDimensions()
    {
        m = 10;
        n = 8;

        matrix = new double[3][2];
        double[][] expected = new double[m][n];

        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (i < 3 && j < 2)
                {
                    matrix[i][j] = expected[i][j]
                            = java.lang.Math.random() + 10 * 1;
                }
            }
        }

        Javatrix actual = new Javatrix(matrix, m, n);
        assertArrayEquals(expected, actual.matrix);
    }
         
    /**
     * Test constructor of zeros for double array of zeros.
     */
    @Test
    public void matrixArrayOfZeros()
    {
        m = 5;
        n = 4;
        matrix = new double[m][n];
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                matrix[i][j] = 0;
            }
        }
        Javatrix actual = new Javatrix(m, n);
        assertArrayEquals("failure - double arrays not same", 
            matrix, actual.getArray());
    }

    /** 
     * Test constructor of zeros for not null.
     */
    @Test
    public void matrixArrayOfZerosNotNull()
    {
        m = 5;
        n = 4;
        Javatrix actual = new Javatrix(m, n);
        assertNotNull("should not be null", actual);
    }

    /**
     * Test constructor of constant for double array of constant.
     */
    @Test
    public void matrixArrayOfConstant()
    {
        m = 5;
        n = 4;
        double s = 2.2;
        matrix = new double[m][n];
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                matrix[i][j] = s;
            }
        }
        Javatrix actual = new Javatrix(m, n, s);
        assertArrayEquals("failure - double arrays not same",
            matrix, actual.getArray());
    }

    /**
     * Test constructor of constant for not null.
     */
    @Test
    public void matrixArrayOfConstantNotNull()
    {
        m = 5;
        n = 4;
        double s = 2.2;
        Javatrix actual = new Javatrix(m, n, s);
        assertNotNull("should not be null", actual);
    }

    /**
     * Test get function for in bounds value.
     */
    @Test
    public void getInBounds()
    {
        m = 5;
        n = 4;
        double s = 2.2;
        Javatrix actual = new Javatrix(m, n, s);
        assertEquals("failure - doubles are not equal", s, actual.get(1, 2), 0);
    }
    
    /**
     * Test get function for out of bounds exception.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void getOutOfBounds()
    {
        m = 5;
        n = 4;
        Javatrix actual = new Javatrix(m, n);
        double s = actual.get(6, 6);
    }

    /**
     * Test getArray function, should be the same.
     */
    @Test
    public void getArraySame()
    {
        m = 5;
        n = 4;
        Javatrix actual = new Javatrix(m, n);
        double[][] marix = null; 
        matrix = actual.getArray();
        assertSame("should be same", matrix, actual.getArray());
    }
    
    /**
     * Test getArray function, not the same.
     */
    @Test
    public void getArrayNotSame()
    {
        m = 5;
        n = 4;
        Javatrix actualA = new Javatrix(m, n);
        Javatrix actualB = new Javatrix(m, n);
        double[][] matrixA = null;
        double[][] matrixB = null;
        matrixA = actualA.getArray();
        matrixB = actualB.getArray();
        assertNotSame("should not be same", matrixA, matrixB);
    }

    /**
     * Test getColumnDimension function, valid.
     */
    @Test
    public void getColumnDimensionValid()
    {
        m = 5;
        n = 4;
        Javatrix actual = new Javatrix(m, n);
        int col = actual.getColumnDimension();
        assertEquals("failure - ints are not equal", n, col);
    }

    /**
     * Test getColumnDimension function, invalid.
     */
    @Test
    public void getColumnDimensionInvalid()
    {
        m = 5;
        n = 4;
        Javatrix actual = new Javatrix(m, n);
        int col = actual.getColumnDimension();
        assertNotSame("should not be same", m, col);
    }

    /**
     * Test getRowDimension function, valid.
     */
    @Test
    public void getRowDimensionValid()
    {
        m = 5;
        n = 4;
        Javatrix actual = new Javatrix(m, n);
        int row = actual.getRowDimension();
        assertEquals("failure - ints are not equal", m, row);
    }

    /** 
     * Test getRowDomension function, invalid.
     */
    @Test
    public void getRowDimensionInvalid()
    {
        m = 5;
        n = 4;
        Javatrix actual = new Javatrix(m, n);
        int row = actual.getRowDimension();
        assertNotSame("should not be same", n, row);
    }

    /**
     * Test getArrayCopy function,
     * returns copy of array, not original.
     */
    @Test
    public void getArrayCopyValid()
    {
        m = 5;
        n = 4;
        Javatrix actual = new Javatrix(m, n);
        double[][] matrixCopy = actual.getArrayCopy();
        assertNotSame("should not be same", actual.getArray(), matrixCopy);
    }

    /**
     * Tear down after unit tests.
     */
    @After
    public void tearDown()
    {
        matrix = null;
        m = 0;
        n = 0;
    }
}
