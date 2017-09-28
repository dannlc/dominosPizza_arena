package ar.edu.unq.iu.arena.xtend;

import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.aop.windows.TransactionalDialog;
import org.uqbar.arena.bindings.ObservableValue;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Control;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.arena.xtend.ArenaXtendExtensions;
import org.uqbar.lacar.ui.model.Action;
import org.uqbar.lacar.ui.model.ControlBuilder;

@SuppressWarnings("all")
public class EditarPedidoWindow /* extends /* TransactionalDialog<PedidoAppModel> */  */{
  public EditarPedidoWindow(final WindowOwner owner, final /* Pedido */Object model) {
    throw new Error("Unresolved compilation problems:"
      + "\nPedidoAppModel cannot be resolved.");
  }
  
  public String defaultTitle() {
    return "Editar Un Pedido";
  }
  
  protected void createFormPanel(final Panel mainPanel) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method panelDeEstado(Panel) from the type EditarPedidoWindow refers to the missing type EstadoPedido");
  }
  
  public /* Selector<EstadoPedido> */Object panelDeEstado(final Panel panel) {
    throw new Error("Unresolved compilation problems:"
      + "\nEstadoPedido cannot be resolved to a type.");
  }
  
  public Button panelDePlatos(final Panel panel) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method crearTablaPlato(Panel) from the type EditarPedidoWindow refers to the missing type Plato");
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
  
  public /* Column<Plato> */Object crearTablaPlato(final Panel panel) {
    throw new Error("Unresolved compilation problems:"
      + "\nPlato cannot be resolved to a type."
      + "\nPlato cannot be resolved to a type."
      + "\nPlato cannot be resolved to a type."
      + "\nPlato cannot be resolved to a type."
      + "\nPlato cannot be resolved to a type.");
  }
  
  public Button crearAccionesTabla(final Panel panel) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method eliminarPlato(Object) from the type EditarPedidoWindow refers to the missing type Object");
  }
  
  public void agregarPlato() {
    throw new Error("Unresolved compilation problems:"
      + "\nPlato cannot be resolved."
      + "\nTamanioGrande cannot be resolved."
      + "\nThe constructor AgregarEditarPlatoWindow(WindowOwner, Pedido, Plato) refers to the missing type Pedido"
      + "\npedido cannot be resolved"
      + "\nrepoPizza cannot be resolved"
      + "\nobjects cannot be resolved"
      + "\nget cannot be resolved");
  }
  
  public void editarPlato() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe constructor AgregarEditarPlatoWindow(WindowOwner, Pedido, Plato) refers to the missing type Pedido"
      + "\npedido cannot be resolved"
      + "\nplatoSeleccionado cannot be resolved");
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
  
  public Object eliminarPlato(final Object o) {
    throw new Error("Unresolved compilation problems:"
      + "\neliminarPlato cannot be resolved");
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
    throw new Error("Unresolved compilation problems:"
      + "\nThe method getRepoPedido() from the type EditarPedidoWindow refers to the missing type RepoPedido"
      + "\nThe method getRepoPedido() from the type EditarPedidoWindow refers to the missing type RepoPedido"
      + "\npedido cannot be resolved"
      + "\nisNew cannot be resolved"
      + "\ncreate cannot be resolved"
      + "\npedido cannot be resolved"
      + "\nupdate cannot be resolved"
      + "\npedido cannot be resolved");
  }
  
  public RepoPedido getRepoPedido() {
    throw new Error("Unresolved compilation problems:"
      + "\nPedido cannot be resolved to a type."
      + "\nRepoPedido cannot be resolved to a type.");
  }
}
