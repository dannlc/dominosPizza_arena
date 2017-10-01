package ar.edu.unq.iu.arena.xtend;

import ar.edu.unq.iu.appmodel.ListadoDePedidos;
import ar.edu.unq.iu.arena.xtend.EditarPedidoWindow;
import ar.edu.unq.iu.modelo.Pedido;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.bindings.NotNullObservable;
import org.uqbar.arena.bindings.ObservableValue;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Control;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.arena.xtend.ArenaXtendExtensions;
import org.uqbar.lacar.ui.model.Action;
import org.uqbar.lacar.ui.model.ControlBuilder;
import org.uqbar.lacar.ui.model.TableBuilder;
import org.uqbar.lacar.ui.model.bindings.ViewObservable;

@SuppressWarnings("all")
public class ListadoDePedidosCerrados extends SimpleWindow<ListadoDePedidos> {
  public ListadoDePedidosCerrados(final WindowOwner parent) {
    super(parent, new ListadoDePedidos());
  }
  
  public void createMainTemplate(final Panel mainPanel) {
    this.setTitle("DominosPizza");
    this.setTaskDescription("Pedidos cerrados");
    super.createMainTemplate(mainPanel);
    this.createResultsGrid(mainPanel);
    this.createGridActions(mainPanel);
  }
  
  public Button createGridActions(final Panel panel) {
    Button _xblockexpression = null;
    {
      final NotNullObservable elementSelected = new NotNullObservable("pedidoSeleccionado");
      Panel _panel = new Panel(panel);
      HorizontalLayout _horizontalLayout = new HorizontalLayout();
      final Panel actionsPanel = _panel.setLayout(_horizontalLayout);
      Button _button = new Button(actionsPanel);
      final Procedure1<Button> _function = new Procedure1<Button>() {
        public void apply(final Button it) {
          it.setCaption("Ver");
          final Action _function = new Action() {
            public void execute() {
              ListadoDePedidosCerrados.this.verPedido();
            }
          };
          it.onClick(_function);
          it.<Object, ControlBuilder>bindEnabled(elementSelected);
        }
      };
      _xblockexpression = ObjectExtensions.<Button>operator_doubleArrow(_button, _function);
    }
    return _xblockexpression;
  }
  
  public void verPedido() {
    Pedido _pedidoSeleccionado = this.getModelObject().getPedidoSeleccionado();
    EditarPedidoWindow _editarPedidoWindow = new EditarPedidoWindow(this, _pedidoSeleccionado);
    this.openDialog(_editarPedidoWindow);
  }
  
  public void openDialog(final Dialog<?> dialog) {
    final Action _function = new Action() {
      public void execute() {
        ListadoDePedidosCerrados.this.getModelObject();
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
        ArenaXtendExtensions.operator_spaceship(_items, "pedidosCerrados");
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
        it.setCaption("Volver");
        final Action _function = new Action() {
          public void execute() {
            ListadoDePedidosCerrados.this.close();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button, _function);
  }
  
  protected void createFormPanel(final Panel mainPanel) {
    Panel _panel = new Panel(mainPanel);
    final Procedure1<Panel> _function = new Procedure1<Panel>() {
      public void apply(final Panel it) {
        ColumnLayout _columnLayout = new ColumnLayout(4);
        it.setLayout(_columnLayout);
      }
    };
    final Panel searchFormPanel = ObjectExtensions.<Panel>operator_doubleArrow(_panel, _function);
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
        it.setFixedSize(100);
        it.alignRight();
        it.bindContentsToProperty("estado");
      }
    };
    ObjectExtensions.<Column<Pedido>>operator_doubleArrow(_column_1, _function_1);
    Column<Pedido> _column_2 = new Column<Pedido>(table);
    final Procedure1<Column<Pedido>> _function_2 = new Procedure1<Column<Pedido>>() {
      public void apply(final Column<Pedido> it) {
        it.setTitle("Fecha");
        it.setFixedSize(100);
        it.bindContentsToProperty("fechaHora");
      }
    };
    ObjectExtensions.<Column<Pedido>>operator_doubleArrow(_column_2, _function_2);
    Column<Pedido> _column_3 = new Column<Pedido>(table);
    final Procedure1<Column<Pedido>> _function_3 = new Procedure1<Column<Pedido>>() {
      public void apply(final Column<Pedido> it) {
        it.setTitle("Tiempo de espera");
        it.setFixedSize(50);
        it.bindContentsToProperty("tiempoEspera");
      }
    };
    ObjectExtensions.<Column<Pedido>>operator_doubleArrow(_column_3, _function_3);
  }
}
