package ThreeD.Engine;
import ThreeD.Engine.Space;
import ThreeD.Linear.Vector2D;
import ThreeD.Linear.Vector3D;
public class Renderer {
  private char screen_[][];
  private int size_;
  private Vector2D offset_;
  private void SetScreen(Vector2D position, char value) {
    screen_[position.GetX() + offset_.GetX()]
           [position.GetY() + offset_.GetY()] = value;
  }
  public Renderer(int size) {
    size_ = size;
    screen_ = new char[size][size];
    offset_ = new Vector2D(0, 0);
  };
  public void Fill(char value) {
    for (int i = 0; i < screen_.length; ++i) {
      for (int j = 0; j < screen_[0].length; ++j) {
        screen_[i][j] = value; 
      }
    }
  }
  public void RenderSurface(Vector2D point_1, Vector2D point_2,
                            Vector2D point_3) {
    int min_x = Math.min(point_1.GetX(),
                         Math.min(point_2.GetX(), point_3.GetX()));
    int min_y = Math.min(point_1.GetY(),
                         Math.min(point_2.GetY(), point_3.GetY()));
    int max_x = Math.max(point_1.GetX(),
                         Math.max(point_2.GetX(), point_3.GetX()));
    int max_y = Math.max(point_1.GetY(),
                         Math.max(point_2.GetY(), point_3.GetY()));
    char real_screen[][] = screen_;
    Vector2D real_offset = offset_;
    screen_ = new char[max_x - min_x + 1][max_y - min_y + 1];
    offset_ = new Vector2D(-min_x, -min_y);
    Fill(' ');
    RenderLine(point_1, point_2);
    RenderLine(point_1, point_3);
    RenderLine(point_2, point_3);
    for (int i = 0; i < screen_.length; ++i) {
      int up = 0, down = 0;
      for (int j = 0; j < screen_[0].length; ++j) {
        if (screen_[i][j] != ' ') {
          down = j;
          break;
        }
      }
      for (int j = screen_[0].length - 1; j >= 0; --j) {
        if (screen_[i][j] != ' ') {
          up = j;
          break;
        }
      }
      while (down <= up) {
        screen_[i][down] = '#';
        ++down;
      }
    }
    char surface[][] = screen_;
    screen_ = real_screen;
    for (int i = 0; i < surface.length; ++i) {
      for (int j = 0; j < surface[0].length; ++j) {
        if (surface[i][j] != ' ') {
          SetScreen(new Vector2D(i, j), surface[i][j]);
        }
      }
    }
    offset_ = real_offset;
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
        value = Math.round((float)(now * delta_y) / delta_x) + point_1.GetY();
        SetScreen(new Vector2D(start + now, value), '1');
      }else {
        value = Math.round((float)(now * delta_x) / delta_y) + point_1.GetX();
        SetScreen(new Vector2D(value, start + now), '1');
      }
    }
  }
  public void RenderPoint(Vector2D point) {
    SetScreen(point, 'O');
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
