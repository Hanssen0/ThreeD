package ThreeD.Linear;
public class Vector {
  private double position_[];
  public Vector(int size) {
    position_ = new double[size];
  };
  public Vector(double position[]) {
    position_ = position.clone();
  };
  @Override
  public Vector clone() {
    return new Vector(position_);
  }
  public int Dimension() {return position_.length;}
  public void Set(int pos, double value) {
    assert position_.length > pos;
    position_[pos] = value;
  }
  public double Get(int pos) {
    assert position_.length > pos;
    return position_[pos];
  }
  public void AddEqual(Vector vector) {
    assert vector.position_.length == position_.length;
    for (int i = 0; i < position_.length; ++i) {
      position_[i] += vector.position_[i];
    }
  }
  public Vector Add(Vector vector) {
    Vector result = clone();
    result.AddEqual(vector);
    return result;
  }
  public boolean IsEqual(Vector vector) {
    assert vector.position_.length == position_.length;
    for (int i = 0; i < position_.length; ++i) {
      if (position_[i] != vector.position_[i]) return false;
    }
    return true;
  }
  public void Swap(Vector vector) {
    double position[] = position_;
    position_ = vector.position_;
    vector.position_ = position;
  }
  public void Print() {
    System.out.print("(");
    for (int i = 0; i < position_.length; ++i) {
      if (i != 0) System.out.print(", ");
      System.out.print(position_[i]);
    }
    System.out.print(")");
  }
}
