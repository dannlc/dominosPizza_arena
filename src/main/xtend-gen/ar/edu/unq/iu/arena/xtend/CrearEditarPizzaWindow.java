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
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.arena.xtend.ArenaXtendExtensions;
import org.uqbar.lacar.ui.model.Action;
import org.uqbar.lacar.ui.model.ControlBuilder;

@SuppressWarnings("all")
public class CrearEditarPizzaWindow /* extends /* TransactionalDialog<Pizza> */  */{
  public CrearEditarPizzaWindow(final WindowOwner owner, final /* Pizza */Object model) {
    super(owner, model);
    this.setTitle("Editar Pizza");
  }
  
  protected void createFormPanel(final Panel mainPanel) {
    Panel _panel = new Panel(mainPanel);
    ColumnLayout _columnLayout = new ColumnLayout(1);
    final Panel form = _panel.setLayout(_columnLayout);
    Label _label = new Label(form);
    _label.setText("Nombre:");
    TextBox _textBox = new TextBox(form);
    final Procedure1<TextBox> _function = new Procedure1<TextBox>() {
      public void apply(final TextBox it) {
        ObservableValue<Control, ControlBuilder> _value = it.<ControlBuilder>value();
        ArenaXtendExtensions.operator_spaceship(_value, "nombre");
        it.setWidth(200);
      }
    };
    ObjectExtensions.<TextBox>operator_doubleArrow(_textBox, _function);
    Label _label_1 = new Label(form);
    _label_1.setText("Precio:");
    TextBox _textBox_1 = new TextBox(form);
    final Procedure1<TextBox> _function_1 = new Procedure1<TextBox>() {
      public void apply(final TextBox it) {
        ObservableValue<Control, ControlBuilder> _value = it.<ControlBuilder>value();
        ArenaXtendExtensions.operator_spaceship(_value, "precio");
        it.setWidth(200);
      }
    };
    ObjectExtensions.<TextBox>operator_doubleArrow(_textBox_1, _function_1);
    this.mostrarIngredientes(mainPanel);
  }
  
  public void mostrarIngredientes(final Panel panel) {
    throw new Error("Unresolved compilation problems:"
      + "\nIngrediente cannot be resolved to a type."
      + "\nThe method getRepoIngredientes() from the type CrearEditarPizzaWindow refers to the missing type RepoIngrediente"
      + "\ngetAllIngredientes cannot be resolved"
      + "\ngetNombre cannot be resolved");
  }
  
  public RepoIngrediente getRepoIngredientes() {
    throw new Error("Unresolved compilation problems:"
      + "\nIngrediente cannot be resolved to a type."
      + "\nRepoIngrediente cannot be resolved to a type.");
  }
  
  public /* RepoPizza */Object getRepoPizza() {
    throw new Error("Unresolved compilation problems:"
      + "\nRepoPizza cannot be resolved to a type."
      + "\nThe method or field Pizza is undefined");
  }
  
  protected void addActions(final Panel actions) {
    Button _button = new Button(actions);
    final Procedure1<Button> _function = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Aceptar");
        final Action _function = new Action() {
          public void execute() {
            CrearEditarPizzaWindow.this.accept();
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
            CrearEditarPizzaWindow.this.cancel();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button_1, _function_1);
  }
  
  public void executeTask() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method getRepoPizza() from the type CrearEditarPizzaWindow refers to the missing type RepoPizza"
      + "\nThe method getRepoPizza() from the type CrearEditarPizzaWindow refers to the missing type RepoPizza"
      + "\nisNew cannot be resolved"
      + "\ncreate cannot be resolved"
      + "\nupdate cannot be resolved");
  }
}
