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
    private double[] arrayOne;
    private int m;
    private int n;
    private Javatrix actual;


    /**
     * Test constructor of 1D array that will equate to a 2x3 matrix.
     */
    @Test
    public void matrixArray1D()
    {
        m = 2;
        n = 3;
        arrayOne = new double[]{1, 2, 3, 4, 5, 6};
        matrix = new double[m][n];
        matrix[0][0] = arrayOne[0];
        matrix[1][0] = arrayOne[1];
        matrix[0][1] = arrayOne[2];
        matrix[1][1] = arrayOne[3];
        matrix[0][2] = arrayOne[4];
        matrix[1][2] = arrayOne[5];
        actual = new Javatrix(arrayOne, m);
        assertArrayEquals(matrix, actual.getArray());
    }

    /**
     * Test constructor of 1D array that thoughs exception for too short.
     */
    @Test(expected = IllegalArgumentException.class)
    public void matrixArray1DException()
    {
        m = 2;
        arrayOne = new double[]{1, 2, 3, 4, 5};
        actual = new Javatrix(arrayOne, m);     
    }

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
        assertArrayEquals(matrix, actual.getArray());
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
        assertArrayEquals(expected, actual.getArray());
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
        actual = new Javatrix(m, n);
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
        actual = new Javatrix(m, n);
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
        actual = new Javatrix(m, n, s);
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
        actual = new Javatrix(m, n, s);
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
        actual = new Javatrix(m, n, s);
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
        actual = new Javatrix(m, n);
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
        actual = new Javatrix(m, n);
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
     * Test identity function.
     */
    @Test
    public void identityMatrix()
    {
        m = n = 4;
        matrix = new double[m][n];
        matrix[0][0] = 1;
        matrix[1][1] = 1;
        matrix[2][2] = 1;
        matrix[3][3] = 1;
        Javatrix actual = Javatrix.identity(m, n);
        assertArrayEquals(matrix, actual.getArray());
    }

    /**
     * Test getColumnDimension function, valid.
     */
    @Test
    public void getColumnDimensionValid()
    {
        m = 5;
        n = 4;
        actual = new Javatrix(m, n);
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
        actual = new Javatrix(m, n);
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
        actual = new Javatrix(m, n);
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
        actual = new Javatrix(m, n);
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
        actual = new Javatrix(m, n);
        double[][] matrixCopy = actual.getArrayCopy();
        assertNotSame("should not be same", actual.getArray(), matrixCopy);
    }

    /**
     * Test set function.
     */
    @Test
    public void setValid()
    {
        m = 5;
        n = 4;
        actual = new Javatrix(m, n);
        actual.set(1, 2, 2.2);
        assertEquals("failure - doubles are not equal", 
            2.2, actual.get(1, 2), 0);
    }

    /**
     * Test set function, exception thrown.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void setInvalid()
    {
        m = 5;
        n = 4;
        actual = new Javatrix(m, n);
        actual.set(6, 5, 2.2);
    }

    /**
     * Test constructWithCopy function.
     */
    @Test
    public void constructWithCopyValid()
    {
        m = 5;
        n = 4;
        matrix = new double[m][n];
        actual = Javatrix.constructWithCopy(matrix);
        assertArrayEquals("failure - double arrays are not same", 
            matrix, actual.getArray());
    }

    /**
     * Test constructWithCopy function, exception thrown.
     */
    @Test(expected = IllegalArgumentException.class)
    public void constructWithCopyException()
    {
        double[] a = {1.1, 2.2, 3.3};
        double[] b = {4.4, 5.5};
        matrix = new double[2][];
        matrix[0] = a;
        matrix[1] = b;
        actual = Javatrix.constructWithCopy(matrix);
    } 
    /**
     * Test random function.
     */
    @Test
    public void testRandom()
    {
        Javatrix random = Javatrix.random(5, 6);
        assertNotNull(random);
    }

    /**
     * Test plus function, valid values.
     */
    @Test
    public void plusValid()
    {
        m = 2;
        n = 3;
        double[] a = {1.1, 2.2, 3.3};
        double[] b = {4.4, 5.5, 6.6};
        matrix = new double[m][n];
        matrix[0] = a;
        matrix[1] = b;

        double[] c = {1.1, 1.2, 1.3};
        double[] d = {1.4, 1.5, 1.6};
        double[][] matrixB = new double[m][n];
        matrixB[0] = c;
        matrixB[1] = d;

        double[][] matrixC = new double[m][n];
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                matrixC[i][j] = matrix[i][j] + matrixB[i][j];
            }
        }

        actual = new Javatrix(matrix);
        Javatrix actualB = new Javatrix(matrixB);
        Javatrix actualC = actual.plus(actualB);
        assertArrayEquals("failure - double arrays are not same",
            matrixC, actualC.getArray());
    }

    /**
     * Test plus function, returns different object.
     */
    @Test
    public void plusNewObj()
    {
        m = 2;
        n = 3;
        double[] a = {1.1, 2.2, 3.3};
        double[] b = {4.4, 5.5, 6.6};
        matrix = new double[m][n];
        matrix[0] = a;
        matrix[1] = b;

        double[] c = {1.1, 1.2, 1.3};
        double[] d = {1.4, 1.5, 1.6};
        double[][] matrixB = new double[m][n];
        matrixB[0] = c;
        matrixB[1] = d;

        double[][] matrixC = new double[m][n];
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                matrixC[i][j] = matrix[i][j] + matrixB[i][j];
            }
        }

        actual = new Javatrix(matrix);
        Javatrix actualB = new Javatrix(matrixB);
        Javatrix actualC = actual.plus(actualB);
        assertNotSame("should not be same", actual, actualC);
    }

    /**
     * Test plusEquals function, valid values.
     */
    @Test
    public void plusEqualsValid()
    {
        m = 2;
        n = 3;
        double[] a = {1.1, 2.2, 3.3};
        double[] b = {4.4, 5.5, 6.6};
        matrix = new double[m][n];
        matrix[0] = a;
        matrix[1] = b;

        double[] c = {1.1, 1.2, 1.3};
        double[] d = {1.4, 1.5, 1.6};
        double[][] matrixB = new double[m][n];
        matrixB[0] = c;
        matrixB[1] = d;

        actual = new Javatrix(matrix);
        Javatrix actualB = new Javatrix(matrixB);

        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                matrix[i][j] = matrix[i][j] + matrixB[i][j];
            }
        }

        actual = actual.plusEquals(actualB);
        assertArrayEquals("failure - double arrays are not same",
            matrix, actual.getArray());
    }
    
    /**
     * Test plusEquals function, returns same object.
     */
    @Test
    public void plusEqualsSameObj()
    {
        m = 2;
        n = 3;
        double[] a = {1.1, 2.2, 3.3};
        double[] b = {4.4, 5.5, 6.6};
        matrix = new double[m][n];
        matrix[0] = a;
        matrix[1] = b;

        double[] c = {1.1, 1.2, 1.3};
        double[] d = {1.4, 1.5, 1.6};
        double[][] matrixB = new double[m][n];
        matrixB[0] = c;
        matrixB[1] = d;

        actual = new Javatrix(matrix);
        Javatrix actualB = new Javatrix(matrixB);
        Javatrix actualC = actual.plusEquals(actualB);
        assertSame("should be same object", actual, actualC);
    }

    /** 
     * Test leftDivide function, valid values.
     */
    @Test
    public void leftDivideValid()
    {
        m = 2;
        n = 3;
        double[] a = {1.1, 2.2, 3.3};
        double[] b = {1.1, 1.1, 2.2};
        matrix = new double[m][n];
        matrix[0] = a;
        matrix[1] = b;
       
        double[] c = {2.2, 4.4, 6.6};
        double[] d = {3.3, 1.1, 8.8};
        double[][] matrixB = new double[m][n];
        matrixB[0] = c;
        matrixB[1] = d;
        
        double[][] matrixC = new double[m][n];
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                matrixC[i][j] = matrixB[i][j] / matrix[i][j];
            }
        }
        
        actual = new Javatrix(matrix);
        Javatrix actualB = new Javatrix(matrixB);
        Javatrix actualC = actual.arrayLeftDivide(actualB);
        assertArrayEquals("failure - double arrays are not same",
            matrixC, actualC.getArray());
    }

    /**
     * Test leftDivide function, returns different object.
     */
    @Test
    public void leftDivideNewObj()
    {
        m = 2;
        n = 3;
        double[] a = {1.1, 2.2, 3.3};
        double[] b = {1.1, 1.1, 2.2};
        matrix = new double[m][n];
        matrix[0] = a;
        matrix[1] = b;
       
        double[] c = {2.2, 4.4, 6.6};
        double[] d = {3.3, 1.1, 8.8};
        double[][] matrixB = new double[m][n];
        matrixB[0] = c;
        matrixB[1] = d;
        
        double[][] matrixC = new double[m][n];
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                matrixC[i][j] = matrixB[i][j] / matrix[i][j];
            }
        }
       
        actual = new Javatrix(matrix);
        Javatrix actualB = new Javatrix(matrixB);
        Javatrix actualC = actual.arrayLeftDivide(actualB);
        assertNotSame("should not be same", actual, actualC);
    }
	
    /**
     * Test minus function, valid values.
     */
    @Test
    public void minusValid()
    {
        m = 2;
        n = 3;
        double[] a = {1.1, 2.2, 3.3};
        double[] b = {4.4, 5.5, 6.6};
        matrix = new double[m][n];
        matrix[0] = a;
        matrix[1] = b;
        
        double[] c = {1.1, 1.2, 1.3};
        double[] d = {1.4, 1.5, 1.6};
        double[][] matrixB = new double[m][n];
        matrixB[0] = c;
        matrixB[1] = d;
        
        double[][] matrixC = new double[m][n];
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                matrixC[i][j] = matrix[i][j] - matrixB[i][j];
            }
        }
        
        actual = new Javatrix(matrix);
        Javatrix actualB = new Javatrix(matrixB);
        Javatrix actualC = actual.minus(actualB);
        assertArrayEquals("failure - double arrays are not same",
            matrixC, actualC.getArray());
    }

    /**
     * Test minus function, returns different object.
     */
    @Test
    public void minusNewObj()
    {
        m = 2;
        n = 3;
        double[] a = {1.1, 2.2, 3.3};
        double[] b = {4.4, 5.5, 6.6};
        matrix = new double[m][n];
        matrix[0] = a;
        matrix[1] = b;
        
        double[] c = {1.1, 1.2, 1.3};
        double[] d = {1.4, 1.5, 1.6};
        double[][] matrixB = new double[m][n];
        matrixB[0] = c;
        matrixB[1] = d;
        
        double[][] matrixC = new double[m][n];
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                matrixC[i][j] = matrix[i][j] - matrixB[i][j];
            }
        }
        
        actual = new Javatrix(matrix);
        Javatrix actualB = new Javatrix(matrixB);
        Javatrix actualC = actual.minus(actualB);
        assertNotSame("should not be same", actual, actualC);
    }

    /**
     * Test minusEquals function, valid values.
     */
    @Test
    public void minusEqualsValid()
    {
        m = 2;
        n = 3;
        double[] a = {1.1, 2.2, 3.3};
        double[] b = {4.4, 5.5, 6.6};
        matrix = new double[m][n];
        matrix[0] = a;
        matrix[1] = b;

        double[] c = {1.1, 1.2, 1.3};
        double[] d = {1.4, 1.5, 1.6};
        double[][] matrixB = new double[m][n];
        matrixB[0] = c;
        matrixB[1] = d;

        actual = new Javatrix(matrix);
        Javatrix actualB = new Javatrix(matrixB);

        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                matrix[i][j] = matrix[i][j] - matrixB[i][j];
            }
        }

        actual = actual.minusEquals(actualB);
        assertArrayEquals("failure - double arrays are not same",
            matrix, actual.getArray());
    }
    
    /**
     * Test minusEquals function, returns same object.
     */
    @Test
    public void minusEqualsSameObj()
    {
        m = 2;
        n = 3;
        double[] a = {1.1, 2.2, 3.3};
        double[] b = {4.4, 5.5, 6.6};
        matrix = new double[m][n];
        matrix[0] = a;
        matrix[1] = b;

        double[] c = {1.1, 1.2, 1.3};
        double[] d = {1.4, 1.5, 1.6};
        double[][] matrixB = new double[m][n];
        matrixB[0] = c;
        matrixB[1] = d;

        actual = new Javatrix(matrix);
        Javatrix actualB = new Javatrix(matrixB);
        Javatrix actualC = actual.minusEquals(actualB);
        assertSame("should be same object", actual, actualC);
    }

    /**
     * Test rightDivide function, valid values.
     */
    @Test
    public void rightDivideValid()
    {
        m = 2;
        n = 3;
        double[] a = {2.2, 4.4, 6.6};
        double[] b = {3.3, 1.1, 8.8};
        matrix = new double[m][n];
        matrix[0] = a;
        matrix[1] = b;

        double[] c = {1.1, 2.2, 3.3};
        double[] d = {1.1, 1.1, 2.2};
        double[][] matrixB = new double[m][n];
        matrixB[0] = c;
        matrixB[1] = d;

        double[][] matrixC = new double[m][n];
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                matrixC[i][j] = matrix[i][j] / matrixB[i][j];
            }
        }

        actual = new Javatrix(matrix);
        Javatrix actualB = new Javatrix(matrixB);
        Javatrix actualC = actual.arrayRightDivide(actualB);
        assertArrayEquals("failure - double arrays are not same",
            matrixC, actualC.getArray());
    }

    /**
     * Test rightDivide function, returns different object.
     */
    @Test
    public void rightDivideNewObj()
    {
        m = 2;
        n = 3;
        double[] a = {2.2, 4.4, 6.6};
        double[] b = {3.3, 1.1, 8.8};
        matrix = new double[m][n];
        matrix[0] = a;
        matrix[1] = b;

        double[] c = {1.1, 2.2, 3.3};
        double[] d = {1.1, 1.1, 2.2};
        double[][] matrixB = new double[m][n];
        matrixB[0] = c;
        matrixB[1] = d;

        double[][] matrixC = new double[m][n];
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                matrixC[i][j] = matrix[i][j] / matrixB[i][j];
            }
        }

        actual = new Javatrix(matrix);
        Javatrix actualB = new Javatrix(matrixB);
        Javatrix actualC = actual.arrayRightDivide(actualB);
        assertNotSame("should not be same", actual, actualC);
    }

    /**
     * Test timesScalar function, valid values.
     */
    @Test
    public void timesScalar()
    {
        m = 2;
        n = 3;
        double scalar = 3.3;
        double[] a = {1, 2, 3};
        double[] b = {4, 5, 6};
        matrix = new double[m][n];
        matrix[0] = a;
        matrix[1] = b;

        double[][] matrixB = new double[m][n];
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                matrixB[i][j] = matrix[i][j] * scalar;
            }
        }

        actual = new Javatrix(matrix);
        Javatrix actualB = actual.times(scalar);
        assertArrayEquals("failure - double arrays are not same",
            matrixB, actualB.getArray());
    }

    /**
     * Test timesScalar function, returns different object.
     */
    @Test
    public void timesScalarNewObj()
    {
        m = 2;
        n = 3;
        double scalar = 3.3;
        double[] a = {1, 2, 3};
        double[] b = {4, 5, 6};
        matrix = new double[m][n];
        matrix[0] = a;
        matrix[1] = b;
        
        double[][] matrixB = new double[m][n];
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                matrixB[i][j] = matrix[i][j] * scalar;
            }
        }
        
        actual = new Javatrix(matrix);
        Javatrix actualB = actual.times(scalar);
        assertNotSame("should not be same", actual, actualB);
    }

    /** Test getMatrix(int[] r, int[] c) valid.
     */
    @Test
    public void getMatrixValidIndices()
    {
        m = 4;
        n = 5;
        matrix = new double[m][n];
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                matrix[i][j] = java.lang.Math.random();
            }
        }
        int[] r  = {0, 0, 1, 2};
        int[] c = {0, 1, 2, 2};
        actual = new Javatrix(matrix);
        actual = actual.getMatrix(r, c);
        double[][] subMatrix = new double[4][4];
        int row;
        int col;
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                row = r[i];
                col = c[i];
                subMatrix[i][j] = matrix[row][col];
            }
        }
        assertArrayEquals(subMatrix, actual.getArray());
    }

    /** Test getMatrix, exception thrown.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void getMatrixIndexOutOfBounds()
    {
        m = 4;
        n = 5;
        actual = new Javatrix(m, n);
        int[] r = {0, 0, 1, 1, 2, 2};
        int[] c = {0, 1, 2, 3, 4, 5};
        actual = actual.getMatrix(r, c);
    }

    /**
     * Test norm1 function, valid.
     */
    @Test
    public void norm1Valid()
    {
        m = 2;
        n = 3;
        matrix = new double[m][n];
        double[] a = {1.1, 2.2, 3.3};
        double[] b = {4.4, 5.5, 6.6};
        matrix[0] = a;
        matrix[1] = b;
        actual = new Javatrix(matrix);
        double sum = 0;
        double tmp = 0;
        for (int j = 0; j < n; j++)
        {
            for (int i = 0; i < m; i++)
            {
                tmp += matrix[i][j];
            }
            if (tmp > sum)
            {
                sum = tmp;
            }
            tmp = 0;
        }
        double maxColSum = actual.norm1();
        assertEquals("failure - max col sum is invalid", 
            sum, maxColSum, 0);
    }

    /**
     * Test normInf function, valid.
     */
    @Test
    public void normInfValid()
    {
        m = 2;
        n = 3;
        matrix = new double[m][n];
        double[] a = {1.1, 2.2, 3.3};
        double[] b = {4.4, 5.5, 6.6};
        matrix[0] = a;
        matrix[1] = b;
        actual = new Javatrix(matrix);
        double sum = 0;
        double tmp = 0;
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                tmp += matrix[i][j];
            }
            if (tmp > sum)
            {
                sum = tmp;
            }
            tmp = 0;
        }
        double maxRowSum = actual.normInf();
        assertEquals("failure - max row sum is invalid", 
            sum, maxRowSum, 0);
    }
     
    /**
     * Test normF function, valid.
     */
    @Test
    public void normFValid()
    {
        m = 5;
        n = 4;
        matrix = new double[m][n];
        double[][] matrixN = new double[m][n];
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                matrix[i][j] = java.lang.Math.random() * 10 + 1;
            }
        }
        actual = new Javatrix(matrix);
        double norm = actual.normF();
        double sum = 0;
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                sum += java.lang.Math.pow(matrix[i][j], 2);
            }
        }
        double normTest = java.lang.Math.sqrt(sum);
        assertEquals("failure - doubles should be equal", norm, normTest, 0);
    }

    /**
     * Test uminus function, returns valid.
     */
    @Test
    public void uminusValid()
    {
        m = 5;
        n = 4;
        matrix = new double[m][n];
        double[][] matrixN = new double[m][n];
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                matrix[i][j] = java.lang.Math.random() * 10 + 1;
                matrixN[i][j] = matrix[i][j] * -1;
            }
        }

        actual = new Javatrix(matrix);
        actual = actual.uminus();
        assertArrayEquals("failure - double array are not same",
            matrixN, actual.getArray());
    }
    
    /**
     * Test uminus function, returns same object.
     */
    @Test
    public void uminusSameObj()
    {
        m = 5;
        n = 4;
        matrix = new double[m][n];
        double[][] matrixN = new double[m][n];
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                matrix[i][j] = java.lang.Math.random() * 10 + 1;
                matrixN[i][j] = matrix[i][j] * -1;
            }
        }

        actual = new Javatrix(matrix);
        Javatrix actualB = actual.uminus();
        assertSame("should be same", actual, actualB);
    }
    
    /**
     * Test copy function, valid.
     */
    @Test
    public void copyValid()
    {
        m = 5;
        n = 4;
        actual = Javatrix.random(m, n);
        Javatrix copy = actual.copy();
        assertArrayEquals("failure - double arrays not same", 
            actual.getArray(), copy.getArray());
    }    

    /**
     * Test copy function, new object.
     */
    @Test
    public void copyNewObj()
    {
        m = 5;
        n = 4;
        actual = Javatrix.random(m, n);
        Javatrix copy = actual.copy();
        assertNotSame("should not be same", actual, copy);
    }

    /**
     * Test getColumnPackedCopy function, valid.
     */
    @Test
    public void getColumnPackedCopyValid()
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
        actual = new Javatrix(matrix);
        double[] colPacked = actual.getColumnPackedCopy();
        
        double[] colPackedB = new double[m * n];
        int count = 0;
        for (int j = 0; j < n; j++)
        {
            for (int i = 0; i < m; i++)
            {
                colPackedB[count] = matrix[i][j];
                count++;
            }
        }

        assertArrayEquals("failure - double arrays are not same", 
            colPacked, colPackedB, 0);
    }

    /**
     * Test getRowPackedCopy function, valid.
     */
    @Test
    public void getRowPackedCopyValid()
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
        actual = new Javatrix(matrix);
        double[] rowPacked = actual.getRowPackedCopy();

        double[] rowPackedB = new double[m * n];
        int count = 0;
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                rowPackedB[count] = matrix[i][j];
                count++;
            }
        }

        assertArrayEquals("failure - double arrays are not same",
            rowPacked, rowPackedB, 0);
    }

    /**
     * Test trace function, valid.
     */
    @Test
    public void traceValid()
    {
        m = 2;
        n = 2;
        double[] a = {1, 2};
        double[] b = {4, 5};
        matrix = new double[m][n];
        matrix[0] = a;
        matrix[1] = b;

        double tr = matrix[0][0] + matrix[1][1];

        actual = new Javatrix(matrix);
        double ace = actual.trace();
        assertEquals(tr, ace, 0);
    }

    /**
     * Test of trace that does not have correct dimensions.
     */
    @Test(expected = IllegalArgumentException.class)
    public void traceThrowsException()
    {
        m = 2;
        n = 3;
        matrix = new double[m][n];
        matrix[0] = new double[1];
        matrix[1] = new double[3];

        Javatrix actual = new Javatrix(matrix);
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
        actual = null;
    }
}

