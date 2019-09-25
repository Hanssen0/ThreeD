package ThreeD.Engine;
import ThreeD.Engine.Space;
import ThreeD.Linear.Vector;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
public class FileReader {
  File file_;
  public FileReader() {
  }
  public void Bind(String path) {
    file_ = new File(path); 
  }
  public void Load(Space space) {
    Scanner input;
    try {
      input = new Scanner(file_);
    }catch (Exception e) {
      return;
    }
    double data[] = new double[3];
    Vector tmp[];
    while (true) {
      String command = input.next();
      switch (command.charAt(0)) {
       case 'p':
        for (int i = 0; i < 3; ++i) data[i] = input.nextDouble();
        space.AddPoint(new Vector(data));
        break;
       case 'l':
        tmp = new Vector[2];
        for (int v = 0; v < 2; ++v) {
          for (int i = 0; i < 3; ++i) data[i] = input.nextDouble();
          tmp[v] = new Vector(data);
        }
        space.AddLine(tmp[0], tmp[1]);
        break;
       case 's':
        tmp = new Vector[3];
        for (int v = 0; v < 3; ++v) {
          for (int i = 0; i < 3; ++i) data[i] = input.nextDouble();
          tmp[v] = new Vector(data);
        }
        space.AddSurface(tmp[0], tmp[1], tmp[2]);
        break;
       case 'e':
        return;
      }
    }
  }
  public void Save(Space space) {
    PrintWriter output;
    try {
      output = new PrintWriter(file_);
    }catch (Exception e) {
      return;
    }
    for (Vector point: space.points_) {
      output.print("p");
      for (int i = 0; i < 3; ++i) output.printf(" %f", point.Get(i));
      output.print("\n");
    }
    for (Vector[] line: space.lines_) {
      output.print("l");
      for (int v = 0; v < 2; ++v) {
        for (int i = 0; i < 3; ++i) output.printf(" %f", line[v].Get(i));
      }
      output.print("\n");
    }
    for (Vector[] surface: space.surfaces_) {
      output.print("s");
      for (int v = 0; v < 3; ++v) {
        for (int i = 0; i < 3; ++i) output.printf(" %f", surface[v].Get(i));
      }
      output.print("\n");
    }
    output.printf("e");
    output.flush();
    output.close();
  }
}
