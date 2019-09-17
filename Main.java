import ThreeD.Linear.Vector;
import ThreeD.Engine.Space;
import ThreeD.Engine.Renderer;
import ThreeD.Engine.Camera;
// z   y
// |  /
// | /
// |/
// +-----x
public class Main{
  public static void main(String args[]) {
    Space main_engine = new Space();
    main_engine.AddPoint(new Vector(new int[]{0, 0, 2}));
    main_engine.AddPoint(new Vector(new int[]{5, 0, 6}));
    main_engine.AddLine(new Vector(new int[]{0, 0, 2}),
                        new Vector(new int[]{5, 0, 6}));
    main_engine.AddSurface(new Vector(new int[]{0, 0, 0}),
                           new Vector(new int[]{6, 0, 4}),
                           new Vector(new int[]{5, 0, 1}));
    Renderer main_renderer = new Renderer(new Vector(new int[]{7, 7}));
    main_renderer.Fill(' ');
    Camera main_camera = new Camera();
    main_camera.Bind(main_renderer);
    main_camera.Render(main_engine);
    main_renderer.Display();
  }
}
