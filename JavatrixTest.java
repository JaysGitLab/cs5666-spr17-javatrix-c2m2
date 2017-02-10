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
