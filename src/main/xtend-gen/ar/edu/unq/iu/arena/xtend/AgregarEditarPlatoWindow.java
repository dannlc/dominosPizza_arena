package ar.edu.unq.iu.arena.xtend;

import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.aop.windows.TransactionalDialog;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.Action;

@SuppressWarnings("all")
public class AgregarEditarPlatoWindow /* extends /* TransactionalDialog<PlatoAppModel> */  */{
  public AgregarEditarPlatoWindow(final WindowOwner owner, final /* Pedido */Object pedido, final /* Plato */Object plato) {
    throw new Error("Unresolved compilation problems:"
      + "\nPlatoAppModel cannot be resolved.");
  }
  
  protected void createFormPanel(final Panel mainPanel) {
    throw new Error("Unresolved compilation problems:"
      + "\nPizza cannot be resolved to a type."
      + "\nTamanio cannot be resolved to a type.");
  }
  
  public void mostrarIngredientes(final Panel panel) {
    throw new Error("Unresolved compilation problems:"
      + "\nPizza cannot be resolved to a type."
      + "\nPizza cannot be resolved to a type."
      + "\nThe method getRepoIngrediente() from the type AgregarEditarPlatoWindow refers to the missing type RepoIngrediente"
      + "\ngetAllIngredientes cannot be resolved"
      + "\ngetNombre cannot be resolved"
      + "\nagregarIngrediente cannot be resolved"
      + "\ntieneIngrediente cannot be resolved");
  }
  
  public RepoIngrediente getRepoIngrediente() {
    throw new Error("Unresolved compilation problems:"
      + "\nIngrediente cannot be resolved to a type."
      + "\nRepoIngrediente cannot be resolved to a type.");
  }
  
  protected void addActions(final Panel actions) {
    Button _button = new Button(actions);
    final Procedure1<Button> _function = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Aceptar");
        final Action _function = new Action() {
          public void execute() {
            AgregarEditarPlatoWindow.this.accept();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button, _function);
    Button _button_1 = new Button(actions);
    final Procedure1<Button> _function_1 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Cancelar");
        final Action _function = new Action() {
          public void execute() {
            AgregarEditarPlatoWindow.this.cancel();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button_1, _function_1);
  }
  
  public void executeTask() {
    throw new Error("Unresolved compilation problems:"
      + "\npedido cannot be resolved"
      + "\nagregarPlato cannot be resolved"
      + "\nplato cannot be resolved");
  }
}
