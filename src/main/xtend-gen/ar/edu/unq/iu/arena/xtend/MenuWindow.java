package ar.edu.unq.iu.arena.xtend;

import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.Action;

@SuppressWarnings("all")
public class MenuWindow /* extends /* SimpleWindow<MenuAppModel> */  */{
  public MenuWindow(final WindowOwner parent) {
    throw new Error("Unresolved compilation problems:"
      + "\nMenuAppModel cannot be resolved.");
  }
  
  public void createMainTemplate(final Panel mainPanel) {
    this.setTitle("DominosPizza - Menu");
    super.createMainTemplate(mainPanel);
  }
  
  protected void createFormPanel(final Panel mainPanel) {
    throw new Error("Unresolved compilation problems:"
      + "\nrepoPizza cannot be resolved"
      + "\nrepoIngrediente cannot be resolved");
  }
  
  protected void addActions(final Panel actionsPanel) {
    Button _button = new Button(actionsPanel);
    final Procedure1<Button> _function = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Salir");
        final Action _function = new Action() {
          public void execute() {
            MenuWindow.this.close();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button, _function);
  }
}
