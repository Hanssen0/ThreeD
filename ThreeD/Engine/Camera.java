package ThreeD.Engine;
import ThreeD.Engine.Renderer;
import ThreeD.Engine.Space;
import ThreeD.Linear.Vector;
import ThreeD.Linear.Matrix;
public class Camera {
  private Vector position_;
  private Vector x_;
  private Vector y_;
  private Renderer renderer_;
  private Matrix rotate_matrix_;
  public Camera(Vector x, Vector y) {
    x_ = x;
    y_ = y;
    rotate_matrix_ = new Matrix();
    rotate_matrix_.ToSurface(x, y);
  }
  public void Bind(Renderer renderer) {
    renderer_ = renderer;
  }
  public void Render(Space space) {
    for (Vector[] surface: space.surfaces_) {
      renderer_.RenderSurface(rotate_matrix_.Multiply(surface[0]),
                              rotate_matrix_.Multiply(surface[1]),
                              rotate_matrix_.Multiply(surface[2]));
    }
    for (Vector[] line: space.lines_) {
      renderer_.RenderLine(rotate_matrix_.Multiply(line[0]),
                           rotate_matrix_.Multiply(line[1]));

    }
    for (Vector point: space.points_) {
      renderer_.RenderPoint(rotate_matrix_.Multiply(point));
    }
  }
}
