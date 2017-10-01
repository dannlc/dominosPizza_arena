package ar.edu.unq.iu.arena.xtend;

import ar.edu.unq.iu.appmodel.ListadoDePedidos;
import ar.edu.unq.iu.arena.xtend.EditarPedidoWindow;
import ar.edu.unq.iu.arena.xtend.ListadoDePedidosCerrados;
import ar.edu.unq.iu.arena.xtend.MenuWindow;
import ar.edu.unq.iu.modelo.Pedido;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.apache.commons.collections15.Transformer;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.bindings.NotNullObservable;
import org.uqbar.arena.bindings.ObservableValue;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Control;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.widgets.tables.labelprovider.PropertyLabelProvider;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.arena.xtend.ArenaXtendExtensions;
import org.uqbar.lacar.ui.model.Action;
import org.uqbar.lacar.ui.model.ControlBuilder;
import org.uqbar.lacar.ui.model.TableBuilder;
import org.uqbar.lacar.ui.model.bindings.ViewObservable;

@SuppressWarnings("all")
public class ListadoDePedidosAbiertosWindow extends SimpleWindow<ListadoDePedidos> {
  public ListadoDePedidosAbiertosWindow(final WindowOwner parent) {
    super(parent, new ListadoDePedidos());
    this.getModelObject().getPedidosAbiertos();
  }
  
  public void createMainTemplate(final Panel mainPanel) {
    this.setTitle("DominosPizza");
    this.setTaskDescription("Pedidos abiertos");
    super.createMainTemplate(mainPanel);
  }
  
  protected void createFormPanel(final Panel mainPanel) {
    Panel _panel = new Panel(mainPanel);
    HorizontalLayout _horizontalLayout = new HorizontalLayout();
    final Panel horLayout = _panel.setLayout(_horizontalLayout);
    this.createResultsGrid(horLayout);
    this.createGridActions(horLayout);
  }
  
  public Button createGridActions(final Panel panel) {
    Button _xblockexpression = null;
    {
      Panel _panel = new Panel(panel);
      VerticalLayout _verticalLayout = new VerticalLayout();
      final Panel actionsPanel = _panel.setLayout(_verticalLayout);
      Button _button = new Button(actionsPanel);
      final Procedure1<Button> _function = new Procedure1<Button>() {
        public void apply(final Button it) {
          it.setCaption("Cancelar");
          final Action _function = new Action() {
            public void execute() {
              ListadoDePedidosAbiertosWindow.this.getModelObject().cancelarPedido();
            }
          };
          it.onClick(_function);
          NotNullObservable _notNullObservable = new NotNullObservable("pedidoSeleccionado");
          it.<Object, ControlBuilder>bindEnabled(_notNullObservable);
        }
      };
      ObjectExtensions.<Button>operator_doubleArrow(_button, _function);
      Button _button_1 = new Button(actionsPanel);
      final Procedure1<Button> _function_1 = new Procedure1<Button>() {
        public void apply(final Button it) {
          it.setCaption("Editar");
          final Action _function = new Action() {
            public void execute() {
              ListadoDePedidosAbiertosWindow.this.editarPedido();
            }
          };
          it.onClick(_function);
          NotNullObservable _notNullObservable = new NotNullObservable("pedidoSeleccionado");
          it.<Object, ControlBuilder>bindEnabled(_notNullObservable);
        }
      };
      ObjectExtensions.<Button>operator_doubleArrow(_button_1, _function_1);
      Panel _panel_1 = new Panel(actionsPanel);
      HorizontalLayout _horizontalLayout = new HorizontalLayout();
      final Panel horLayout = _panel_1.setLayout(_horizontalLayout);
      Button _button_2 = new Button(horLayout);
      final Procedure1<Button> _function_2 = new Procedure1<Button>() {
        public void apply(final Button it) {
          it.setCaption("<<");
          final Action _function = new Action() {
            public void execute() {
              ListadoDePedidosAbiertosWindow.this.getModelObject().pasarAEstadoAnterior();
            }
          };
          it.onClick(_function);
          NotNullObservable _notNullObservable = new NotNullObservable("pedidoSeleccionado");
          it.<Object, ControlBuilder>bindEnabled(_notNullObservable);
        }
      };
      ObjectExtensions.<Button>operator_doubleArrow(_button_2, _function_2);
      Button _button_3 = new Button(horLayout);
      final Procedure1<Button> _function_3 = new Procedure1<Button>() {
        public void apply(final Button it) {
          it.setCaption(">>");
          final Action _function = new Action() {
            public void execute() {
              ListadoDePedidosAbiertosWindow.this.getModelObject().pasarAEstadoSiguiente();
            }
          };
          it.onClick(_function);
          NotNullObservable _notNullObservable = new NotNullObservable("pedidoSeleccionado");
          it.<Object, ControlBuilder>bindEnabled(_notNullObservable);
        }
      };
      _xblockexpression = ObjectExtensions.<Button>operator_doubleArrow(_button_3, _function_3);
    }
    return _xblockexpression;
  }
  
  public void editarPedido() {
    Pedido _pedidoSeleccionado = this.getModelObject().getPedidoSeleccionado();
    EditarPedidoWindow _editarPedidoWindow = new EditarPedidoWindow(this, _pedidoSeleccionado);
    this.openDialog(_editarPedidoWindow);
  }
  
  public void openDialog(final Dialog<?> dialog) {
    final Action _function = new Action() {
      public void execute() {
        ListadoDePedidosAbiertosWindow.this.getModelObject().actualizar();
      }
    };
    dialog.onAccept(_function);
    dialog.open();
  }
  
  public void createResultsGrid(final Panel panel) {
    Table<Pedido> _table = new Table<Pedido>(panel, Pedido.class);
    final Procedure1<Table<Pedido>> _function = new Procedure1<Table<Pedido>>() {
      public void apply(final Table<Pedido> it) {
        ViewObservable<Table<Pedido>, TableBuilder<Pedido>> _items = it.items();
        ArenaXtendExtensions.operator_spaceship(_items, "pedidosAbiertos");
        ObservableValue<Control, ControlBuilder> _value = it.<ControlBuilder>value();
        ArenaXtendExtensions.operator_spaceship(_value, "pedidoSeleccionado");
        it.setNumberVisibleRows(5);
      }
    };
    final Table<Pedido> table = ObjectExtensions.<Table<Pedido>>operator_doubleArrow(_table, _function);
    this.describeResultsGrid(table);
  }
  
  protected void addActions(final Panel actionsPanel) {
    Button _button = new Button(actionsPanel);
    final Procedure1<Button> _function = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Menu");
        final Action _function = new Action() {
          public void execute() {
            ListadoDePedidosAbiertosWindow.this.abrirMenu();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button, _function);
    Button _button_1 = new Button(actionsPanel);
    final Procedure1<Button> _function_1 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Pedidos Cerrados");
        final Action _function = new Action() {
          public void execute() {
            ListadoDePedidosAbiertosWindow.this.pedidosCerrados();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button_1, _function_1);
    Button _button_2 = new Button(actionsPanel);
    final Procedure1<Button> _function_2 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Salir");
        final Action _function = new Action() {
          public void execute() {
            ListadoDePedidosAbiertosWindow.this.close();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button_2, _function_2);
  }
  
  public void pedidosCerrados() {
    ListadoDePedidosCerrados _listadoDePedidosCerrados = new ListadoDePedidosCerrados(this);
    this.openWindow(_listadoDePedidosCerrados);
  }
  
  public void openWindow(final Window<?> window) {
    window.open();
  }
  
  public void abrirMenu() {
    MenuWindow _menuWindow = new MenuWindow(this);
    this.openWindow(_menuWindow);
  }
  
  public void describeResultsGrid(final Table<Pedido> table) {
    Column<Pedido> _column = new Column<Pedido>(table);
    final Procedure1<Column<Pedido>> _function = new Procedure1<Column<Pedido>>() {
      public void apply(final Column<Pedido> it) {
        it.setTitle("Pedido");
        it.setFixedSize(50);
        it.bindContentsToProperty("id");
      }
    };
    ObjectExtensions.<Column<Pedido>>operator_doubleArrow(_column, _function);
    Column<Pedido> _column_1 = new Column<Pedido>(table);
    final Procedure1<Column<Pedido>> _function_1 = new Procedure1<Column<Pedido>>() {
      public void apply(final Column<Pedido> it) {
        it.setTitle("Estado");
        it.setFixedSize(120);
        it.alignRight();
        it.bindContentsToProperty("estado");
      }
    };
    ObjectExtensions.<Column<Pedido>>operator_doubleArrow(_column_1, _function_1);
    Column<Pedido> _column_2 = new Column<Pedido>(table);
    final Procedure1<Column<Pedido>> _function_2 = new Procedure1<Column<Pedido>>() {
      public void apply(final Column<Pedido> it) {
        it.setTitle("Monto");
        it.setFixedSize(50);
        it.bindContentsToProperty("monto");
      }
    };
    ObjectExtensions.<Column<Pedido>>operator_doubleArrow(_column_2, _function_2);
    Column<Pedido> _column_3 = new Column<Pedido>(table);
    final Procedure1<Column<Pedido>> _function_3 = new Procedure1<Column<Pedido>>() {
      public void apply(final Column<Pedido> it) {
        it.setTitle("Hora");
        it.setFixedSize(120);
        PropertyLabelProvider<Pedido> _bindContentsToProperty = it.bindContentsToProperty("fechaHora");
        final Transformer<LocalDateTime, String> _function = new Transformer<LocalDateTime, String>() {
          public String transform(final LocalDateTime fecha) {
            return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm").format(fecha);
          }
        };
        _bindContentsToProperty.setTransformer(_function);
      }
    };
    ObjectExtensions.<Column<Pedido>>operator_doubleArrow(_column_3, _function_3);
  }
}
