package ar.edu.unq.iu.arena.xtend;

import ar.edu.unq.iu.arena.xtend.CrearEditarPanel;
import ar.edu.unq.iu.arena.xtend.CrearEditarPizzaWindow;
import ar.edu.unq.iu.modelo.Pizza;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.model.CollectionBasedRepo;
import org.uqbar.lacar.ui.model.Action;

@SuppressWarnings("all")
public class CrearEditarPizza extends CrearEditarPanel<Pizza> {
  private WindowOwner window;
  
  public CrearEditarPizza(final Panel parent, final CollectionBasedRepo repo, final WindowOwner win) {
    super(parent, repo);
    this.window = win;
    this.titulo = "Pizzas:";
    this.modificaciones();
  }
  
  public Column<Pizza> modificaciones() {
    Column<Pizza> _xblockexpression = null;
    {
      Column<Pizza> _column = new Column<Pizza>(this.tabla);
      final Procedure1<Column<Pizza>> _function = new Procedure1<Column<Pizza>>() {
        public void apply(final Column<Pizza> it) {
          it.setTitle("Nombre");
          it.setFixedSize(200);
          it.bindContentsToProperty("nombre");
        }
      };
      ObjectExtensions.<Column<Pizza>>operator_doubleArrow(_column, _function);
      Column<Pizza> _column_1 = new Column<Pizza>(this.tabla);
      final Procedure1<Column<Pizza>> _function_1 = new Procedure1<Column<Pizza>>() {
        public void apply(final Column<Pizza> it) {
          it.setTitle("Precio");
          it.setFixedSize(200);
          it.bindContentsToProperty("precio");
        }
      };
      _xblockexpression = ObjectExtensions.<Column<Pizza>>operator_doubleArrow(_column_1, _function_1);
    }
    return _xblockexpression;
  }
  
  public void crear() {
    Pizza _pizza = new Pizza("", 0.0);
    CrearEditarPizzaWindow _crearEditarPizzaWindow = new CrearEditarPizzaWindow(this.window, _pizza);
    this.openDialog(_crearEditarPizzaWindow);
  }
  
  public void editar(final Pizza modelo) {
    CrearEditarPizzaWindow _crearEditarPizzaWindow = new CrearEditarPizzaWindow(this.window, modelo);
    this.openDialog(_crearEditarPizzaWindow);
  }
  
  public void openDialog(final Dialog<?> dialog) {
    final Action _function = new Action() {
      public void execute() {
        CrearEditarPizza.this.getModelObject().actualizar();
      }
    };
    dialog.onAccept(_function);
    dialog.open();
  }
}
