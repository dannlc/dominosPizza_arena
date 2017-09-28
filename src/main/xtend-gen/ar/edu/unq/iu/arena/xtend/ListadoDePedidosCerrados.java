package ar.edu.unq.iu.arena.xtend;

import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.bindings.NotNullObservable;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.Action;
import org.uqbar.lacar.ui.model.ControlBuilder;

@SuppressWarnings("all")
public class ListadoDePedidosCerrados /* extends /* SimpleWindow<ListadoDePedidos> */  */{
  public ListadoDePedidosCerrados(final WindowOwner parent) {
    throw new Error("Unresolved compilation problems:"
      + "\nListadoDePedidos cannot be resolved."
      + "\npedidosCerrados cannot be resolved");
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
    throw new Error("Unresolved compilation problems:"
      + "\nThe constructor EditarPedidoWindow(WindowOwner, Pedido) refers to the missing type Pedido"
      + "\npedidoSeleccionado cannot be resolved");
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
    throw new Error("Unresolved compilation problems:"
      + "\nPedido cannot be resolved to a type."
      + "\nPedido cannot be resolved to a type."
      + "\nThe method describeResultsGrid(Table<Pedido>) from the type ListadoDePedidosCerrados refers to the missing type Pedido");
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
  
  public void describeResultsGrid(final /* Table<Pedido> */Object table) {
    throw new Error("Unresolved compilation problems:"
      + "\nPedido cannot be resolved to a type."
      + "\nPedido cannot be resolved to a type."
      + "\nPedido cannot be resolved to a type."
      + "\nPedido cannot be resolved to a type.");
  }
}
