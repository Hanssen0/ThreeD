package ThreeD.Linear;
import ThreeD.Linear.Vector;
public class Matrix {
  private float matrix_[][];
  public Matrix() {}
  public Matrix(float matrix[][]) {
    matrix_ = matrix.clone();
  }
  public Vector Multiply(Vector vector) {
    assert vector.Dimension() == matrix_.length; // Required by the definition
    Vector result = new Vector(matrix_[0].length);
    for (int i = 0; i < matrix_[0].length; ++i) {
      float value = 0;
      for (int j = 0; j < matrix_.length; ++j) {
        value += matrix_[j][i] * vector.Get(j);
      }
      result.Set(i, (int)value);
    }
    return result;
  }
  public void ToSurface(Vector x, Vector y) {
    float square_x = (float)(Math.pow(x.Get(0), 2) + 
                             Math.pow(x.Get(1), 2) +
                             Math.pow(x.Get(2), 2));
    float square_y = (float)(Math.pow(y.Get(0), 2) + 
                             Math.pow(y.Get(1), 2) +
                             Math.pow(y.Get(2), 2));
    matrix_ = new float[][]{new float[]{x.Get(0) / square_x, y.Get(0) / square_y},
                          new float[]{x.Get(1) / square_x, y.Get(1) / square_y},
                          new float[]{x.Get(2) / square_x, y.Get(2) / square_y}};
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
