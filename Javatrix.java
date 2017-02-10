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
    int m;
    int n;

    /**
     ** Construct a matric from a 2D array.
     **
     ** @param A - 2D array to be copied into matrix
     **/

     public Javatrix(double[][] A)
     {
         this.m = A[0].length;
         this.n = A[1].length;

         matrix = new double[m][n];

         for (int i = 0; i < m; i++)
         {
             for (int j = 0; j < n; j++)
             {
                 matrix[i][j] = A[i][j];

             }
         }
     }

}

