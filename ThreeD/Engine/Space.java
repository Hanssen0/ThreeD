package ThreeD.Engine;
import ThreeD.Linear.Vector3D;
import java.util.LinkedList;
class Line {
  private Vector3D nodes_[];
  public Line(Vector3D node_a, Vector3D node_b) {
    nodes_ = new Vector3D[]{node_a, node_b};
  }
};
class Surface {
  private Vector3D nodes_[];
  public Surface(Vector3D node_a, Vector3D node_b, Vector3D node_c) {
    nodes_ = new Vector3D[]{node_a, node_b, node_c};
  }
};
public class Space {
  LinkedList< Vector3D > points_;
  LinkedList< Line > lines_;
  LinkedList< Surface > surfaces_;
  public Space() { 
    points_ = new LinkedList< Vector3D >();
  }
  public void AddPoint(Vector3D position) {
    points_.addFirst(position);
  }
  public void Print() {
    for (Vector3D point: points_) {
      point.Print();
    }
  }
};
