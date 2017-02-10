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
    int m;
    int n;

    /**
     ** Construct a matric from a 2D array.
     **
     ** @param A - 2D array to be copied into matrix
     **/

     public Javatrix(double[][] A)
     {
         this.m = A.length;
         this.n = A[0].length;

         matrix = new double[m][n];

         for (int i = 0; i < m; i++)
         {
             for (int j = 0; j < n; j++)
             {
                 matrix[i][j] = A[i][j];

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

}

