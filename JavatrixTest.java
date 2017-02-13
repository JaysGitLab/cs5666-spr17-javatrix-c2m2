import org.junit.Test;
import org.junit.After;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;

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
        matrix = new double[5][4];
        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                // Random number between 1 and 10.
                matrix[i][j] = java.lang.Math.random() * 10 + 1; 
            }
        }
        
        Javatrix actual = new Javatrix(matrix);
        assertArrayEquals(matrix, actual.matrix);

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
            matrix, actual.matrix);
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
