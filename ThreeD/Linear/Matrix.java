package ThreeD.Linear;
import ThreeD.Linear.Vector;
public class Matrix {
  private double matrix_[][];
  public Matrix() {}
  public Matrix(double matrix[][]) {
    matrix_ = matrix.clone();
  }
  public Vector Multiply(Vector vector) {
    assert vector.Dimension() == matrix_.length; // Required by the definition
    Vector result = new Vector(matrix_[0].length);
    for (int i = 0; i < matrix_[0].length; ++i) {
      double value = 0;
      for (int j = 0; j < matrix_.length; ++j) {
        value += matrix_[j][i] * vector.Get(j);
      }
      result.Set(i, value);
    }
    return result;
  }
  public void ToSurface(Vector x, Vector y) {
    Vector x_normal = x.clone();
    x_normal.DivideEqual(x.GetLength());
    Vector y_normal = y.clone();
    y_normal.DivideEqual(y.GetLength());
    matrix_ = new double[][]{new double[]{x_normal.Get(0), y_normal.Get(0)},
                             new double[]{x_normal.Get(1), y_normal.Get(1)},
                             new double[]{x_normal.Get(2), y_normal.Get(2)}};
  }
  public void Print() {
    for (int j = 0; j < matrix_[0].length; ++j) {
      for (int i = 0; i < matrix_.length; ++i) {
        System.out.printf("%f ", matrix_[i][j]);
      }
      System.out.printf("\n");
    }
  }
}
