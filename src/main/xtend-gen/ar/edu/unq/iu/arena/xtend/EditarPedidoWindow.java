package ar.edu.unq.iu.arena.xtend;

import ar.edu.unq.iu.appmodel.PedidoAppModel;
import ar.edu.unq.iu.arena.xtend.AgregarEditarPlatoWindow;
import ar.edu.unq.iu.modelo.EstadoPedido;
import ar.edu.unq.iu.modelo.Pedido;
import ar.edu.unq.iu.modelo.Plato;
import ar.edu.unq.iu.repo.RepoPedido;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.aop.windows.TransactionalDialog;
import org.uqbar.arena.bindings.NotNullObservable;
import org.uqbar.arena.bindings.ObservableItems;
import org.uqbar.arena.bindings.ObservableValue;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Control;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.arena.xtend.ArenaXtendExtensions;
import org.uqbar.commons.applicationContext.ApplicationContext;
import org.uqbar.lacar.ui.model.Action;
import org.uqbar.lacar.ui.model.ControlBuilder;
import org.uqbar.lacar.ui.model.ListBuilder;
import org.uqbar.lacar.ui.model.TableBuilder;
import org.uqbar.lacar.ui.model.bindings.ViewObservable;

@SuppressWarnings("all")
public class EditarPedidoWindow extends TransactionalDialog<PedidoAppModel> {
  public EditarPedidoWindow(final WindowOwner owner, final Pedido model) {
    super(owner, new PedidoAppModel(model));
    this.setTitle(this.defaultTitle());
  }
  
  public String defaultTitle() {
    return "Editar Un Pedido";
  }
  
  protected void createFormPanel(final Panel mainPanel) {
    this.panelDeEstado(mainPanel);
    this.panelDePlatos(mainPanel);
    this.panelDeAclaraciones(mainPanel);
    this.panelDeInfo(mainPanel);
  }
  
  public Selector<EstadoPedido> panelDeEstado(final Panel panel) {
    Selector<EstadoPedido> _xblockexpression = null;
    {
      Panel _panel = new Panel(panel);
      ColumnLayout _columnLayout = new ColumnLayout(2);
      final Panel layout = _panel.setLayout(_columnLayout);
      Label _label = new Label(layout);
      _label.setText("Estado:");
      Selector<EstadoPedido> _selector = new Selector<EstadoPedido>(layout);
      final Procedure1<Selector<EstadoPedido>> _function = new Procedure1<Selector<EstadoPedido>>() {
        public void apply(final Selector<EstadoPedido> it) {
          it.allowNull(false);
          ObservableValue<Control, ControlBuilder> _value = it.<ControlBuilder>value();
          ArenaXtendExtensions.operator_spaceship(_value, "pedido.estado");
          ObservableItems<Selector<EstadoPedido>, EstadoPedido, ListBuilder<EstadoPedido>> _items = it.items();
          ArenaXtendExtensions.operator_spaceship(_items, "pedido.envio.posiblesEstados");
        }
      };
      _xblockexpression = ObjectExtensions.<Selector<EstadoPedido>>operator_doubleArrow(_selector, _function);
    }
    return _xblockexpression;
  }
  
  public Button panelDePlatos(final Panel panel) {
    Button _xblockexpression = null;
    {
      Label _label = new Label(panel);
      _label.setText("Platos:");
      Panel _panel = new Panel(panel);
      HorizontalLayout _horizontalLayout = new HorizontalLayout();
      final Panel p = _panel.setLayout(_horizontalLayout);
      this.crearTablaPlato(p);
      _xblockexpression = this.crearAccionesTabla(p);
    }
    return _xblockexpression;
  }
  
  public TextBox panelDeAclaraciones(final Panel panel) {
    TextBox _xblockexpression = null;
    {
      Label _label = new Label(panel);
      _label.setText("Aclaraciones:");
      TextBox _textBox = new TextBox(panel);
      final Procedure1<TextBox> _function = new Procedure1<TextBox>() {
        public void apply(final TextBox it) {
          ObservableValue<Control, ControlBuilder> _value = it.<ControlBuilder>value();
          ArenaXtendExtensions.operator_spaceship(_value, "pedido.aclaraciones");
          it.setWidth(400);
        }
      };
      _xblockexpression = ObjectExtensions.<TextBox>operator_doubleArrow(_textBox, _function);
    }
    return _xblockexpression;
  }
  
  public Label panelDeInfo(final Panel panel) {
    Label _xblockexpression = null;
    {
      Panel _panel = new Panel(panel);
      ColumnLayout _columnLayout = new ColumnLayout(2);
      final Panel form = _panel.setLayout(_columnLayout);
      Label _label = new Label(form);
      _label.setText("Cliente:");
      Label _label_1 = new Label(form);
      final Procedure1<Label> _function = new Procedure1<Label>() {
        public void apply(final Label it) {
          ObservableValue<Control, ControlBuilder> _value = it.<ControlBuilder>value();
          ArenaXtendExtensions.operator_spaceship(_value, "pedido.cliente.nombre");
          it.alignLeft();
        }
      };
      ObjectExtensions.<Label>operator_doubleArrow(_label_1, _function);
      Label _label_2 = new Label(form);
      _label_2.setText("Costo de envio:");
      Label _label_3 = new Label(form);
      final Procedure1<Label> _function_1 = new Procedure1<Label>() {
        public void apply(final Label it) {
          ObservableValue<Control, ControlBuilder> _value = it.<ControlBuilder>value();
          ArenaXtendExtensions.operator_spaceship(_value, "pedido.envio.costo");
          it.alignLeft();
        }
      };
      ObjectExtensions.<Label>operator_doubleArrow(_label_3, _function_1);
      Label _label_4 = new Label(form);
      _label_4.setText("Monto total:");
      Label _label_5 = new Label(form);
      final Procedure1<Label> _function_2 = new Procedure1<Label>() {
        public void apply(final Label it) {
          ObservableValue<Control, ControlBuilder> _value = it.<ControlBuilder>value();
          ArenaXtendExtensions.operator_spaceship(_value, "pedido.monto");
          it.alignLeft();
        }
      };
      ObjectExtensions.<Label>operator_doubleArrow(_label_5, _function_2);
      Label _label_6 = new Label(form);
      _label_6.setText("Fecha:");
      Label _label_7 = new Label(form);
      final Procedure1<Label> _function_3 = new Procedure1<Label>() {
        public void apply(final Label it) {
          ObservableValue<Control, ControlBuilder> _value = it.<ControlBuilder>value();
          ArenaXtendExtensions.operator_spaceship(_value, "pedido.fechaHora");
          it.alignLeft();
        }
      };
      _xblockexpression = ObjectExtensions.<Label>operator_doubleArrow(_label_7, _function_3);
    }
    return _xblockexpression;
  }
  
  public Column<Plato> crearTablaPlato(final Panel panel) {
    Column<Plato> _xblockexpression = null;
    {
      Table<Plato> _table = new Table<Plato>(panel, Plato.class);
      final Procedure1<Table<Plato>> _function = new Procedure1<Table<Plato>>() {
        public void apply(final Table<Plato> it) {
          ViewObservable<Table<Plato>, TableBuilder<Plato>> _items = it.items();
          ArenaXtendExtensions.operator_spaceship(_items, "pedido.platos");
          ObservableValue<Control, ControlBuilder> _value = it.<ControlBuilder>value();
          ArenaXtendExtensions.operator_spaceship(_value, "platoSeleccionado");
          it.setNumberVisibleRows(4);
        }
      };
      final Table<Plato> table = ObjectExtensions.<Table<Plato>>operator_doubleArrow(_table, _function);
      Column<Plato> _column = new Column<Plato>(table);
      final Procedure1<Column<Plato>> _function_1 = new Procedure1<Column<Plato>>() {
        public void apply(final Column<Plato> it) {
          it.setTitle("Nombre");
          it.setFixedSize(200);
          it.alignRight();
          it.bindContentsToProperty("pizza.nombre");
        }
      };
      ObjectExtensions.<Column<Plato>>operator_doubleArrow(_column, _function_1);
      Column<Plato> _column_1 = new Column<Plato>(table);
      final Procedure1<Column<Plato>> _function_2 = new Procedure1<Column<Plato>>() {
        public void apply(final Column<Plato> it) {
          it.setTitle("Tamanio");
          it.setFixedSize(200);
          it.bindContentsToProperty("tamanio.nombre");
        }
      };
      ObjectExtensions.<Column<Plato>>operator_doubleArrow(_column_1, _function_2);
      Column<Plato> _column_2 = new Column<Plato>(table);
      final Procedure1<Column<Plato>> _function_3 = new Procedure1<Column<Plato>>() {
        public void apply(final Column<Plato> it) {
          it.setTitle("Precio");
          it.setFixedSize(200);
          it.bindContentsToProperty("precio");
        }
      };
      _xblockexpression = ObjectExtensions.<Column<Plato>>operator_doubleArrow(_column_2, _function_3);
    }
    return _xblockexpression;
  }
  
  public Button crearAccionesTabla(final Panel panel) {
    Button _xblockexpression = null;
    {
      Panel _panel = new Panel(panel);
      VerticalLayout _verticalLayout = new VerticalLayout();
      final Panel actionsPanel = _panel.setLayout(_verticalLayout);
      Button _button = new Button(actionsPanel);
      final Procedure1<Button> _function = new Procedure1<Button>() {
        public void apply(final Button it) {
          it.setCaption("Agregar");
          final Action _function = new Action() {
            public void execute() {
              EditarPedidoWindow.this.agregarPlato();
            }
          };
          it.onClick(_function);
        }
      };
      ObjectExtensions.<Button>operator_doubleArrow(_button, _function);
      Button _button_1 = new Button(actionsPanel);
      final Procedure1<Button> _function_1 = new Procedure1<Button>() {
        public void apply(final Button it) {
          it.setCaption("Editar");
          final Action _function = new Action() {
            public void execute() {
              EditarPedidoWindow.this.editarPlato();
            }
          };
          it.onClick(_function);
          NotNullObservable _notNullObservable = new NotNullObservable("platoSeleccionado");
          it.<Object, ControlBuilder>bindEnabled(_notNullObservable);
        }
      };
      ObjectExtensions.<Button>operator_doubleArrow(_button_1, _function_1);
      Button _button_2 = new Button(actionsPanel);
      final Procedure1<Button> _function_2 = new Procedure1<Button>() {
        public void apply(final Button it) {
          it.setCaption("Eliminar");
          final Action _function = new Action() {
            public void execute() {
              EditarPedidoWindow.this.eliminarPlato(EditarPedidoWindow.this);
            }
          };
          it.onClick(_function);
          NotNullObservable _notNullObservable = new NotNullObservable("platoSeleccionado");
          it.<Object, ControlBuilder>bindEnabled(_notNullObservable);
        }
      };
      _xblockexpression = ObjectExtensions.<Button>operator_doubleArrow(_button_2, _function_2);
    }
    return _xblockexpression;
  }
  
  public void agregarPlato() {
    Pedido _pedido = this.getModelObject().getPedido();
    Plato _nuevoPlato = this.getModelObject().getNuevoPlato();
    AgregarEditarPlatoWindow _agregarEditarPlatoWindow = new AgregarEditarPlatoWindow(this, _pedido, _nuevoPlato);
    this.openDialog(_agregarEditarPlatoWindow);
  }
  
  public void editarPlato() {
    Pedido _pedido = this.getModelObject().getPedido();
    Plato _platoSeleccionado = this.getModelObject().getPlatoSeleccionado();
    AgregarEditarPlatoWindow _agregarEditarPlatoWindow = new AgregarEditarPlatoWindow(this, _pedido, _platoSeleccionado);
    this.openDialog(_agregarEditarPlatoWindow);
  }
  
  public void openDialog(final Dialog<?> dialog) {
    final Action _function = new Action() {
      public void execute() {
        EditarPedidoWindow.this.getModelObject();
      }
    };
    dialog.onAccept(_function);
    dialog.open();
  }
  
  public boolean eliminarPlato(final Object o) {
    return this.getModelObject().eliminarPlato();
  }
  
  protected void addActions(final Panel actions) {
    Button _button = new Button(actions);
    final Procedure1<Button> _function = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Aceptar");
        final Action _function = new Action() {
          public void execute() {
            EditarPedidoWindow.this.accept();
          }
        };
        it.onClick(_function);
        it.setAsDefault();
        it.disableOnError();
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button, _function);
    Button _button_1 = new Button(actions);
    final Procedure1<Button> _function_1 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Cancelar");
        final Action _function = new Action() {
          public void execute() {
            EditarPedidoWindow.this.cancel();
          }
        };
        it.onClick(_function);
        it.setAsDefault();
        it.disableOnError();
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button_1, _function_1);
  }
  
  public void executeTask() {
    boolean _isNew = this.getModelObject().getPedido().isNew();
    if (_isNew) {
      this.getRepoPedido().create(this.getModelObject().getPedido());
    } else {
      this.getRepoPedido().update(this.getModelObject().getPedido());
    }
    super.executeTask();
  }
  
  public RepoPedido getRepoPedido() {
    Object _singleton = ApplicationContext.getInstance().<Object>getSingleton(Pedido.class);
    return ((RepoPedido) _singleton);
  }
}
