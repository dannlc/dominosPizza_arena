package ar.edu.unq.iu.arena.xtend;

import ar.edu.unq.iu.arena.xtend.ContainsTransformer;
import ar.edu.unq.iu.modelo.Ingrediente;
import ar.edu.unq.iu.modelo.Pizza;
import ar.edu.unq.iu.repo.RepoIngrediente;
import ar.edu.unq.iu.repo.RepoPizza;
import java.util.List;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.aop.windows.TransactionalDialog;
import org.uqbar.arena.bindings.ObservableValue;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.CheckBox;
import org.uqbar.arena.widgets.Control;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.arena.xtend.ArenaXtendExtensions;
import org.uqbar.commons.applicationContext.ApplicationContext;
import org.uqbar.lacar.ui.model.Action;
import org.uqbar.lacar.ui.model.ControlBuilder;
import org.uqbar.lacar.ui.model.bindings.Binding;

@SuppressWarnings("all")
public class CrearEditarPizzaWindow extends TransactionalDialog<Pizza> {
  public CrearEditarPizzaWindow(final WindowOwner owner, final Pizza model) {
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
    List<Ingrediente> _allIngredientes = this.getRepoIngredientes().getAllIngredientes();
    for (final Ingrediente ingrediente : _allIngredientes) {
      {
        Panel _panel = new Panel(panel);
        HorizontalLayout _horizontalLayout = new HorizontalLayout();
        final Panel selector = _panel.setLayout(_horizontalLayout);
        CheckBox _checkBox = new CheckBox(selector);
        final Procedure1<CheckBox> _function = new Procedure1<CheckBox>() {
          public void apply(final CheckBox it) {
            Binding<Object, Control, ControlBuilder> _bindValueToProperty = it.<Object, ControlBuilder>bindValueToProperty("ingredientes");
            ContainsTransformer<Ingrediente> _containsTransformer = new ContainsTransformer<Ingrediente>(ingrediente);
            _bindValueToProperty.setTransformer(_containsTransformer);
          }
        };
        ObjectExtensions.<CheckBox>operator_doubleArrow(_checkBox, _function);
        Label _label = new Label(selector);
        _label.setText(ingrediente.getNombre());
      }
    }
  }
  
  public RepoIngrediente getRepoIngredientes() {
    Object _singleton = ApplicationContext.getInstance().<Object>getSingleton(Ingrediente.class);
    return ((RepoIngrediente) _singleton);
  }
  
  public RepoPizza getRepoPizza() {
    Object _singleton = ApplicationContext.getInstance().<Object>getSingleton(Pizza.class);
    return ((RepoPizza) _singleton);
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
    boolean _isNew = this.getModelObject().isNew();
    if (_isNew) {
      this.getRepoPizza().create(this.getModelObject());
    } else {
      this.getRepoPizza().update(this.getModelObject());
    }
    super.executeTask();
  }
}
