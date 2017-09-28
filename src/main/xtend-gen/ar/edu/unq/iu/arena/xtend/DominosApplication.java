package ar.edu.unq.iu.arena.xtend;

import ar.edu.unq.iu.arena.xtend.DominosBootstrap;
import ar.edu.unq.iu.arena.xtend.ListadoDePedidosAbiertosWindow;
import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;

@SuppressWarnings("all")
public class DominosApplication extends Application {
  public DominosApplication(final DominosBootstrap b) {
    super(b);
  }
  
  public static void main(final String[] args) {
    DominosBootstrap _dominosBootstrap = new DominosBootstrap();
    new DominosApplication(_dominosBootstrap).start();
  }
  
  protected Window<?> createMainWindow() {
    return new ListadoDePedidosAbiertosWindow(this);
  }
}
