package ar.edu.unq.iu.arena.xtend;

import ar.edu.unq.iu.arena.xtend.CrearEditarIngredienteWindow;
import ar.edu.unq.iu.arena.xtend.CrearEditarPanel;
import ar.edu.unq.iu.modelo.Ingrediente;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.model.CollectionBasedRepo;
import org.uqbar.lacar.ui.model.Action;

@SuppressWarnings("all")
public class CrearEditarIngrediente extends CrearEditarPanel<Ingrediente> {
  private WindowOwner window;
  
  public CrearEditarIngrediente(final Panel parent, final CollectionBasedRepo repo, final WindowOwner win) {
    super(parent, repo);
    this.window = win;
    this.titulo = "Ingredientes:";
    this.modificaciones();
  }
  
  public Column<Ingrediente> modificaciones() {
    Column<Ingrediente> _xblockexpression = null;
    {
      Column<Ingrediente> _column = new Column<Ingrediente>(this.tabla);
      final Procedure1<Column<Ingrediente>> _function = new Procedure1<Column<Ingrediente>>() {
        public void apply(final Column<Ingrediente> it) {
          it.setTitle("Nombre");
          it.setFixedSize(200);
          it.bindContentsToProperty("nombre");
        }
      };
      ObjectExtensions.<Column<Ingrediente>>operator_doubleArrow(_column, _function);
      Column<Ingrediente> _column_1 = new Column<Ingrediente>(this.tabla);
      final Procedure1<Column<Ingrediente>> _function_1 = new Procedure1<Column<Ingrediente>>() {
        public void apply(final Column<Ingrediente> it) {
          it.setTitle("Precio");
          it.setFixedSize(200);
          it.bindContentsToProperty("precio");
        }
      };
      _xblockexpression = ObjectExtensions.<Column<Ingrediente>>operator_doubleArrow(_column_1, _function_1);
    }
    return _xblockexpression;
  }
  
  public void crear() {
    Ingrediente _ingrediente = new Ingrediente("", Double.valueOf(0.0));
    CrearEditarIngredienteWindow _crearEditarIngredienteWindow = new CrearEditarIngredienteWindow(this.window, _ingrediente);
    this.openDialog(_crearEditarIngredienteWindow);
  }
  
  public void editar(final Ingrediente modelo) {
    CrearEditarIngredienteWindow _crearEditarIngredienteWindow = new CrearEditarIngredienteWindow(this.window, modelo);
    this.openDialog(_crearEditarIngredienteWindow);
  }
  
  public void openDialog(final Dialog<?> dialog) {
    final Action _function = new Action() {
      public void execute() {
        CrearEditarIngrediente.this.getModelObject().actualizar();
      }
    };
    dialog.onAccept(_function);
    dialog.open();
  }
}
