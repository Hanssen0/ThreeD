package ThreeD.Engine;
import ThreeD.Engine.Space;
import ThreeD.Linear.Vector;
import java.io.PrintWriter;
public class Renderer {
  private char screen_[][];
  private Vector offset_;
  private char point_brush_;
  private char line_brush_;
  private char surface_brush_;
  private void SetScreen(Vector position, char value) {
    assert position.Dimension() >= 2; // Screen is two-dimensional
    Vector real_pos = position.Add(offset_);
    screen_[(int)Math.round(real_pos.Get(0))]
           [(int)Math.round(real_pos.Get(1))] = value;
  }
  public Renderer(int width, int height) {
    screen_ = new char[width][height];
    offset_ = new Vector(new double[]{0, 0}); // origin
    point_brush_ = 'O';
    line_brush_ = '1';
    surface_brush_ = '#';
  };
  public void Fill(char value) {
    for (int i = 0; i < screen_.length; ++i) {
      for (int j = 0; j < screen_[0].length; ++j) {
        screen_[i][j] = value; 
      }
    }
  }
  public void SetPointBrush(char brush) {point_brush_ = brush;}
  public void SetLineBrush(char brush) {line_brush_ = brush;}
  public void SetSurfaceBrush(char brush) {surface_brush_ = brush;}
  public void RenderPoint(Vector point) {
    SetScreen(point, point_brush_);
  }
  public void RenderLine(Vector point_1, Vector point_2) {
    double delta_x = point_2.Get(0) - point_1.Get(0);
    double delta_y = point_2.Get(1) - point_1.Get(1);
    double delta_delta_x_y = Math.abs(delta_x) - Math.abs(delta_y);
    if ((delta_delta_x_y > 0 && delta_x < 0) ||
        (delta_delta_x_y <= 0 && delta_y < 0)) {
      point_1.Swap(point_2);
      delta_x = -delta_x;
      delta_y = -delta_y;
    }
    double start, end;
    if (delta_delta_x_y > 0) {
      start = point_1.Get(0);
      end = point_2.Get(0);
    }else {
      start = point_1.Get(1);
      end = point_2.Get(1);
    }
    for (int now = 0; start + now <= end; ++now) {
      double value;
      if (delta_delta_x_y > 0) {
        value = delta_y * now / delta_x + point_1.Get(1);
        SetScreen(new Vector(new double[]{start + now, value}), line_brush_);
      }else {
        value = delta_x * now / delta_y + point_1.Get(0);
        SetScreen(new Vector(new double[]{value, start + now}), line_brush_);
      }
    }
  }
  public void RenderSurface(Vector point_1, Vector point_2,
                            Vector point_3) {
    double min_x = Math.min(point_1.Get(0),
                            Math.min(point_2.Get(0), point_3.Get(0)));
    double min_y = Math.min(point_1.Get(1),
                            Math.min(point_2.Get(1), point_3.Get(1)));
    double max_x = Math.max(point_1.Get(0),
                            Math.max(point_2.Get(0), point_3.Get(0)));
    double max_y = Math.max(point_1.Get(1),
                            Math.max(point_2.Get(1), point_3.Get(1)));
    char real_screen[][] = screen_;
    Vector real_offset = offset_;
    screen_ = new char[(int)(max_x - min_x) + 1][(int)(max_y - min_y) + 1];
    offset_ = new Vector(new double[]{-min_x, -min_y});
    Fill(' ');
    RenderLine(point_1, point_2);
    RenderLine(point_1, point_3);
    RenderLine(point_2, point_3);
    for (int i = 0; i < screen_.length; ++i) {
      int up = 0;
      int down = 0;
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
        screen_[i][down] = surface_brush_;
        ++down;
      }
    }
    char surface[][] = screen_;
    screen_ = real_screen;
    for (int i = 0; i < surface.length; ++i) {
      for (int j = 0; j < surface[0].length; ++j) {
        if (surface[i][j] != ' ') {
          SetScreen(new Vector(new double[]{i, j}), surface_brush_);
        }
      }
    }
    offset_ = real_offset;
  }
  public void Display() {
    PrintWriter console = new PrintWriter(System.out);
    for (int j = screen_[0].length - 1; j >= 0; --j) {
      for (int i = 0; i < screen_.length; ++i) {
        console.print(screen_[i][j]);
        console.print(screen_[i][j]);
      }
      console.print("\n");
    }
    console.flush();
  }
};
