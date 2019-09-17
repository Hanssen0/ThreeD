package ThreeD.Engine;
import ThreeD.Linear.Vector;
import java.util.LinkedList;
public class Space {
  LinkedList< Vector > points_;
  LinkedList< Vector[] > lines_;
  LinkedList< Vector[] > surfaces_;
  public Space() { 
    points_ = new LinkedList< Vector >();
    lines_ = new LinkedList< Vector[] >();
    surfaces_ = new LinkedList< Vector[] >();
  }
  public void AddPoint(Vector position) {
    points_.addFirst(position);
  }
  public void AddLine(Vector point1, Vector point2) {
    lines_.addFirst(new Vector[]{point1, point2});
  }
  public void AddSurface(Vector point1, Vector point2, Vector point3) {
    surfaces_.addFirst(new Vector[]{point1, point2, point3});
  }
  public void Print() {
    for (Vector point: points_) {
      point.Print();
    }
    for (Vector[] line: lines_) {
      System.out.printf("[");
      line[0].Print();
      System.out.printf(", ");
      line[1].Print();
      System.out.printf("]");
    }
    for (Vector[] surface: surfaces_) {
      System.out.printf("[");
      surface[0].Print();
      System.out.printf(", ");
      surface[1].Print();
      System.out.printf(", ");
      surface[2].Print();
      System.out.printf("]");
    }
  }
};
