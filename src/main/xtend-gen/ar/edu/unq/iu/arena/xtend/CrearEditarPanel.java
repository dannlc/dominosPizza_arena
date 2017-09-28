package ar.edu.unq.iu.arena.xtend;

import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.commons.model.CollectionBasedRepo;
import org.uqbar.commons.model.Entity;

/**
 * panel generico para hacer un agregar / quitar / eliminar
 */
@SuppressWarnings("all")
public abstract class CrearEditarPanel<T extends Entity> extends Panel {
  public Table<T> tabla;
  
  public Panel acciones;
  
  public String titulo = "";
  
  public CrearEditarPanel(final Panel parent, final CollectionBasedRepo<T> repo) {
    throw new Error("Unresolved compilation problems:"
      + "\nCrearEditarRepoModel cannot be resolved.");
  }
  
  public /* CrearEditarRepoModel<T> */Object getModelObject() {
    throw new Error("Unresolved compilation problems:"
      + "\nCrearEditarRepoModel cannot be resolved to a type.");
  }
  
  public Object itemType() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method getModelObject() from the type CrearEditarPanel refers to the missing type CrearEditarRepoModel"
      + "\nrepo cannot be resolved"
      + "\nentityType cannot be resolved");
  }
  
  public Button crearLayout() {
    Button _xblockexpression = null;
    {
      Label _label = new Label(this);
      final Procedure1<Label> _function = new Procedure1<Label>() {
        public void apply(final Label it) {
          it.setText(CrearEditarPanel.this.titulo);
          it.alignLeft();
          it.setFontSize(12);
        }
      };
      ObjectExtensions.<Label>operator_doubleArrow(_label, _function);
      Panel _panel = new Panel(this);
      final Procedure1<Panel> _function_1 = new Procedure1<Panel>() {
        public void apply(final Panel it) {
          HorizontalLayout _horizontalLayout = new HorizontalLayout();
          it.setLayout(_horizontalLayout);
        }
      };
      final Panel sub = ObjectExtensions.<Panel>operator_doubleArrow(_panel, _function_1);
      this.crearTabla(sub);
      _xblockexpression = this.crearAcciones(sub);
    }
    return _xblockexpression;
  }
  
  public Table<T> crearTabla(final Panel parent) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method itemType() from the type CrearEditarPanel refers to the missing type Object");
  }
  
  public Button crearAcciones(final Panel panel) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method getModelObject() from the type CrearEditarPanel refers to the missing type CrearEditarRepoModel"
      + "\nThe method eliminar(T) from the type CrearEditarPanel refers to the missing type Object"
      + "\nThe method getModelObject() from the type CrearEditarPanel refers to the missing type CrearEditarRepoModel"
      + "\nseleccionado cannot be resolved"
      + "\nseleccionado cannot be resolved");
  }
  
  public abstract void crear();
  
  public abstract void editar(final T modelo);
  
  public Object eliminar(final T modelo) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method getModelObject() from the type CrearEditarPanel refers to the missing type CrearEditarRepoModel"
      + "\nThe method getModelObject() from the type CrearEditarPanel refers to the missing type CrearEditarRepoModel"
      + "\nThe method getModelObject() from the type CrearEditarPanel refers to the missing type CrearEditarRepoModel"
      + "\nrepo cannot be resolved"
      + "\ndelete cannot be resolved"
      + "\nseleccionado cannot be resolved"
      + "\nactualizar cannot be resolved");
  }
}
