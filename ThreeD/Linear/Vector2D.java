package ThreeD.Linear;
public class Vector2D {
  private int position_[];
  public Vector2D() {
    position_ = new int[2];
  };
  public Vector2D(int x, int y) {
    position_ = new int[2];
    SetPosition(x, y);
  };
  @Override
  public Vector2D clone() {
    return new Vector2D(position_[0],
                        position_[1]);
  }
  public void SetPosition(int x, int y) {
    position_[0] = x;
    position_[1] = y;
  }
  public int GetX() {return position_[0];}
  public int GetY() {return position_[1];}
  public void AddEqual(Vector2D vector) {
    position_[0] += vector.position_[0];
    position_[1] += vector.position_[1];
  }
  public Vector2D Add(Vector2D vector) {
    Vector2D result = clone();
    result.AddEqual(vector);
    return result;
  }
  public boolean IsEqual(Vector2D vector) {
    for (int i = 0; i < position_.length; ++i) {
      if (position_[i] != vector.position_[i]) return false;
    }
    return true;
  }
  public void Swap(Vector2D vector) {
    int position[] = position_;
    position_ = vector.position_;
    vector.position_ = position;
  }
  public void Print() {
    System.out.print("(" + position_[0] + ", "
                         + position_[1] + ")\n");
  }
}
