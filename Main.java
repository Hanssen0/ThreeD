import ThreeD.Linear.Vector;
import ThreeD.Engine.Space;
import ThreeD.Engine.Renderer;
import ThreeD.Engine.Camera;
import ThreeD.Engine.FileReader;
import java.util.Scanner;
// z   y
// |  /
// | /
// |/
// +-----x
public class Main{
  public static void main(String args[]) {
    Space main_engine = new Space();
    FileReader main_file = new FileReader();
    main_file.Bind("save");
    main_file.Load(main_engine);
    Renderer main_renderer = new Renderer(40, 40);
    Scanner input = new Scanner(System.in);
    for (int i = 0; i <= 200; i += 1) {
      main_renderer.Fill(' ');
      Camera main_camera = new Camera(new Vector(new double[]{1, 0, 0}),
                                      new Vector(new double[]{0, (double)i / 100,
                                                              Math.sqrt(4 - Math.pow((double)i / 100, 2))}));
      main_camera.Bind(main_renderer);
      main_camera.Render(main_engine);
      System.out.print("-----------------------------------------------------");
      main_renderer.Display();
      System.out.print("-----------------------------------------------------");
      input.nextLine();
    }
    main_file.Bind("save");
    main_file.Save(main_engine);
  }
}
