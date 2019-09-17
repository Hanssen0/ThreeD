package ThreeD.Engine;
import ThreeD.Engine.Renderer;
import ThreeD.Engine.Space;
import ThreeD.Linear.Vector;
import ThreeD.Linear.Matrix;
public class Camera {
  private Vector position_;
  private Vector facing_;
  private Renderer renderer_;
  private Matrix rotate_matrix_;
  public Camera() {
    rotate_matrix_ = new Matrix();
    rotate_matrix_.ToSurface(new Vector(new int[]{1, 0, 0}), new Vector(new int[]{0, 0, 1}));
  }
  public void Bind(Renderer renderer) {
    renderer_ = renderer;
  }
  public void Render(Space space) {
    for (Vector[] surface: space.surfaces_) {
      renderer_.RenderSurface(new Vector(new int[]{surface[0].Get(0), surface[0].Get(2)}),
                              new Vector(new int[]{surface[1].Get(0), surface[1].Get(2)}),
                              new Vector(new int[]{surface[2].Get(0), surface[2].Get(2)}));
    }
    for (Vector[] line: space.lines_) {
      renderer_.RenderLine(new Vector(new int[]{line[0].Get(0), line[0].Get(2)}),
                           new Vector(new int[]{line[1].Get(0), line[1].Get(2)}));
    }
    for (Vector point: space.points_) {
      renderer_.RenderPoint(new Vector(new int[]{point.Get(0), point.Get(2)}));
    }
    rotate_matrix_.Print();
  }
}
