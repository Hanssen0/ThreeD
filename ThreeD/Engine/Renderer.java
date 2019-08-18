package ThreeD.Engine;
import ThreeD.Engine.Space;
import ThreeD.Linear.Vector2D;
import ThreeD.Linear.Vector3D;
public class Renderer {
  private char screen_[][];
  private int size_;
  public Renderer(int size) {
    size_ = size;
    screen_ = new char[size][size];
  };
  public void Fill(char value) {
    for (int i = 0; i < screen_.length; ++i) {
      for (int j = 0; j < screen_[0].length; ++j) {
        screen_[i][j] = value; 
      }
    }
  }
  public void RenderLine(Vector2D point_1, Vector2D point_2) {
    int delta_x = point_2.GetX() - point_1.GetX();
    int delta_y = point_2.GetY() - point_1.GetY();
    int delta_delta_x_y = Math.abs(delta_x) - Math.abs(delta_y);
    if ((delta_delta_x_y > 0 && delta_x < 0) ||
        (delta_delta_x_y < 0 && delta_y < 0)) {
      point_1.Swap(point_2);
      delta_x = -delta_x;
      delta_y = -delta_y;
    }
    point_1.Print();
    point_2.Print();
    System.out.print(delta_x + " " + delta_y + " " + delta_delta_x_y);
    int start, end;
    if (delta_delta_x_y > 0) {
      start = point_1.GetX();
      end = point_2.GetX();
    }else {
      start = point_1.GetY();
      end = point_2.GetY();
    }
    for (int now = 0; start + now - 1 != end; ++now) {
      int value;
      if (delta_delta_x_y > 0) {
        value = now * delta_y / delta_x + point_1.GetY();
        screen_[start + now][Math.round(value)] = '1';
      }else {
        value = now * delta_x / delta_y + point_1.GetX();
        screen_[Math.round(value)][start + now] = '1';
      }
    }
  }
  public void RenderPoint(Vector2D point) {
    screen_[point.GetX()][point.GetY()] = 'O';
  }
  public void Render(Space space) {
    for (Vector3D point: space.points_) {
      RenderPoint(new Vector2D(point.GetX(), point.GetZ()));
    }
  }
  public void Display() {
    for (int j = screen_[0].length - 1; j >= 0; --j) {
      for (int i = 0; i < screen_.length; ++i) {
        System.out.print(screen_[i][j]);
      }
      System.out.print("\n");
    }
  }
};
