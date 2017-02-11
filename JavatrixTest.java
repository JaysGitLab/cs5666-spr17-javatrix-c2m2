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
        m = 5;
        n = 4;
        matrix = new double[m][n];
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
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
            matrix, actual.matrix);
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
