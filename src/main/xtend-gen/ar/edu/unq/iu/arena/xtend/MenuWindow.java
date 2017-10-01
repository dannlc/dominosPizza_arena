package ar.edu.unq.iu.arena.xtend;

import ar.edu.unq.iu.appmodel.MenuAppModel;
import ar.edu.unq.iu.arena.xtend.CrearEditarIngrediente;
import ar.edu.unq.iu.arena.xtend.CrearEditarPizza;
import ar.edu.unq.iu.repo.RepoIngrediente;
import ar.edu.unq.iu.repo.RepoPizza;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.Action;

@SuppressWarnings("all")
public class MenuWindow extends SimpleWindow<MenuAppModel> {
  public MenuWindow(final WindowOwner parent) {
    super(parent, new MenuAppModel());
  }
  
  public void createMainTemplate(final Panel mainPanel) {
    this.setTitle("DominosPizza - Menu");
    super.createMainTemplate(mainPanel);
  }
  
  protected void createFormPanel(final Panel mainPanel) {
    RepoPizza _repoPizza = this.getModelObject().getRepoPizza();
    new CrearEditarPizza(mainPanel, _repoPizza, this);
    RepoIngrediente _repoIngrediente = this.getModelObject().getRepoIngrediente();
    new CrearEditarIngrediente(mainPanel, _repoIngrediente, this);
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
