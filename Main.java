import ThreeD.Linear.Vector2D;
import ThreeD.Linear.Vector3D;
import ThreeD.Engine.Space;
import ThreeD.Engine.Renderer;
public class Main{
  public static void main(String args[]) {
    Space main_engine = new Space();
    main_engine.AddPoint(new Vector3D(0, 0, 0));
    main_engine.AddPoint(new Vector3D(6, 0, 4));
    Renderer main_renderer = new Renderer(10);
    main_renderer.Fill(' ');
    main_renderer.RenderLine(new Vector2D(0, 0), new Vector2D(6, 4));
    main_renderer.Render(main_engine);
    main_renderer.Display();
  }
}
