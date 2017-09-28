package ar.edu.unq.iu.arena.xtend;

import ar.edu.unq.iu.arena.xtend.ListadoDePedidosCerrados;
import ar.edu.unq.iu.arena.xtend.MenuWindow;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.Action;

@SuppressWarnings("all")
public class ListadoDePedidosAbiertosWindow /* extends /* SimpleWindow<ListadoDePedidos> */  */{
  public ListadoDePedidosAbiertosWindow(final WindowOwner parent) {
    throw new Error("Unresolved compilation problems:"
      + "\nListadoDePedidos cannot be resolved."
      + "\npedidosAbiertos cannot be resolved");
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
    throw new Error("Unresolved compilation problems:"
      + "\nCambioDeEstadoException cannot be resolved to a type."
      + "\nCambioDeEstadoException cannot be resolved to a type."
      + "\nThe method estadoAnterior(Pedido) from the type ListadoDePedidosAbiertosWindow refers to the missing type Object"
      + "\nThe method estadoSiguiente(Pedido) from the type ListadoDePedidosAbiertosWindow refers to the missing type Object"
      + "\ncancelarPedido cannot be resolved"
      + "\npedidoSeleccionado cannot be resolved"
      + "\npedidoSeleccionado cannot be resolved");
  }
  
  public Object estadoSiguiente(final /* Pedido */Object p) {
    throw new Error("Unresolved compilation problems:"
      + "\npasarAlSiguienteEstado cannot be resolved");
  }
  
  public Object estadoAnterior(final /* Pedido */Object p) {
    throw new Error("Unresolved compilation problems:"
      + "\npasarAlEstadoAnterior cannot be resolved");
  }
  
  public void editarPedido() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe constructor EditarPedidoWindow(WindowOwner, Pedido) refers to the missing type Pedido"
      + "\npedidoSeleccionado cannot be resolved");
  }
  
  public void openDialog(final Dialog<?> dialog) {
    throw new Error("Unresolved compilation problems:"
      + "\nactualizar cannot be resolved");
  }
  
  public void createResultsGrid(final Panel panel) {
    throw new Error("Unresolved compilation problems:"
      + "\nPedido cannot be resolved to a type."
      + "\nPedido cannot be resolved to a type."
      + "\nThe method describeResultsGrid(Table<Pedido>) from the type ListadoDePedidosAbiertosWindow refers to the missing type Pedido");
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
  
  public void describeResultsGrid(final /* Table<Pedido> */Object table) {
    throw new Error("Unresolved compilation problems:"
      + "\nPedido cannot be resolved to a type."
      + "\nPedido cannot be resolved to a type."
      + "\nPedido cannot be resolved to a type."
      + "\nPedido cannot be resolved to a type.");
  }
}
