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
  public double GetLength() {
    double result = 0;
    for (int i = 0; i < position_.length; ++i) {
      result += Math.pow(position_[i], 2);
    }
    return Math.sqrt(result);
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
  public void DivideEqual(double number) {
    for (int i = 0; i < position_.length; ++i) {
      position_[i] /= number;
    }
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
