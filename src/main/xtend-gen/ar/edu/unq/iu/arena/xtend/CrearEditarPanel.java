package ar.edu.unq.iu.arena.xtend;

import ar.edu.unq.iu.appmodel.CrearEditarRepoModel;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.bindings.NotNullObservable;
import org.uqbar.arena.bindings.ObservableValue;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Control;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.xtend.ArenaXtendExtensions;
import org.uqbar.commons.model.CollectionBasedRepo;
import org.uqbar.commons.model.Entity;
import org.uqbar.lacar.ui.model.Action;
import org.uqbar.lacar.ui.model.ControlBuilder;
import org.uqbar.lacar.ui.model.TableBuilder;
import org.uqbar.lacar.ui.model.bindings.ViewObservable;

/**
 * panel generico para hacer un agregar / quitar / eliminar
 */
@SuppressWarnings("all")
public abstract class CrearEditarPanel<T extends Entity> extends Panel {
  public Table<T> tabla;
  
  public Panel acciones;
  
  public String titulo = "";
  
  public CrearEditarPanel(final Panel parent, final CollectionBasedRepo<T> repo) {
    super(parent, new CrearEditarRepoModel<T>(repo));
    this.crearLayout();
  }
  
  public CrearEditarRepoModel<T> getModelObject() {
    Object _modelObject = super.getModelObject();
    return ((CrearEditarRepoModel<T>) _modelObject);
  }
  
  public Class<T> itemType() {
    return this.getModelObject().getRepo().getEntityType();
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
    Class<T> _itemType = this.itemType();
    Table<T> _table = new Table<T>(parent, _itemType);
    final Procedure1<Table<T>> _function = new Procedure1<Table<T>>() {
      public void apply(final Table<T> it) {
        ViewObservable<Table<T>, TableBuilder<T>> _items = it.items();
        ArenaXtendExtensions.operator_spaceship(_items, "objetos");
        ObservableValue<Control, ControlBuilder> _value = it.<ControlBuilder>value();
        ArenaXtendExtensions.operator_spaceship(_value, "seleccionado");
        it.setNumberVisibleRows(5);
      }
    };
    Table<T> _doubleArrow = ObjectExtensions.<Table<T>>operator_doubleArrow(_table, _function);
    return this.tabla = _doubleArrow;
  }
  
  public Button crearAcciones(final Panel panel) {
    Button _xblockexpression = null;
    {
      Panel _panel = new Panel(panel);
      VerticalLayout _verticalLayout = new VerticalLayout();
      Panel _setLayout = _panel.setLayout(_verticalLayout);
      this.acciones = _setLayout;
      Button _button = new Button(this.acciones);
      final Procedure1<Button> _function = new Procedure1<Button>() {
        public void apply(final Button it) {
          it.setCaption("Crear");
          final Action _function = new Action() {
            public void execute() {
              CrearEditarPanel.this.crear();
            }
          };
          it.onClick(_function);
        }
      };
      ObjectExtensions.<Button>operator_doubleArrow(_button, _function);
      Button _button_1 = new Button(this.acciones);
      final Procedure1<Button> _function_1 = new Procedure1<Button>() {
        public void apply(final Button it) {
          it.setCaption("Editar");
          final Action _function = new Action() {
            public void execute() {
              CrearEditarPanel.this.editar(CrearEditarPanel.this.getModelObject().getSeleccionado());
            }
          };
          it.onClick(_function);
          NotNullObservable _notNullObservable = new NotNullObservable("seleccionado");
          it.<Object, ControlBuilder>bindEnabled(_notNullObservable);
        }
      };
      ObjectExtensions.<Button>operator_doubleArrow(_button_1, _function_1);
      Button _button_2 = new Button(this.acciones);
      final Procedure1<Button> _function_2 = new Procedure1<Button>() {
        public void apply(final Button it) {
          it.setCaption("Eliminar");
          final Action _function = new Action() {
            public void execute() {
              CrearEditarPanel.this.eliminar(CrearEditarPanel.this.getModelObject().getSeleccionado());
            }
          };
          it.onClick(_function);
          NotNullObservable _notNullObservable = new NotNullObservable("seleccionado");
          it.<Object, ControlBuilder>bindEnabled(_notNullObservable);
        }
      };
      _xblockexpression = ObjectExtensions.<Button>operator_doubleArrow(_button_2, _function_2);
    }
    return _xblockexpression;
  }
  
  public abstract void crear();
  
  public abstract void editar(final T modelo);
  
  public void eliminar(final T modelo) {
    this.getModelObject().getRepo().delete(modelo);
    CrearEditarRepoModel<T> _modelObject = this.getModelObject();
    _modelObject.setSeleccionado(null);
    this.getModelObject().actualizar();
  }
}
