package ThreeD.Linear;
public class Vector3D implements Cloneable {
  private int position_[];
  public Vector3D() {
    position_ = new int[3];
  };
  public Vector3D(int x, int y, int z) {
    position_ = new int[3];
    SetPosition(x, y, z);
  };
  @Override
  public Vector3D clone() {
    return new Vector3D(position_[0],
                        position_[1],
                        position_[2]);
  }
  public void SetPosition(int x, int y, int z) {
    position_[0] = x;
    position_[1] = y;
    position_[2] = z;
  }
  public int GetX() {return position_[0];}
  public int GetY() {return position_[1];}
  public int GetZ() {return position_[2];}
  public void AddEqual(Vector3D vector) {
    position_[0] += vector.position_[0];
    position_[1] += vector.position_[1];
    position_[2] += vector.position_[2];
  }
  public Vector3D Add(Vector3D vector) {
    Vector3D result = clone();
    result.AddEqual(vector);
    return result;
  }
  public boolean IsEqual(Vector3D vector) {
    for (int i = 0; i < position_.length; ++i) {
      if (position_[i] != vector.position_[i]) return false;
    }
    return true;
  }
  public void Print() {
    System.out.print("(" + position_[0] + ", "
                         + position_[1] + ", "
                         + position_[2] + ")\n");
  }
}
