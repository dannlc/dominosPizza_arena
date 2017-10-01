package ar.edu.unq.iu.arena.xtend;

import ar.edu.unq.iu.appmodel.PlatoAppModel;
import ar.edu.unq.iu.arena.xtend.PlatoIngredienteModel;
import ar.edu.unq.iu.modelo.Ingrediente;
import ar.edu.unq.iu.modelo.Pedido;
import ar.edu.unq.iu.modelo.Pizza;
import ar.edu.unq.iu.modelo.Plato;
import ar.edu.unq.iu.modelo.Tamanio;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.aop.windows.TransactionalDialog;
import org.uqbar.arena.bindings.ObservableItems;
import org.uqbar.arena.bindings.ObservableValue;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.CheckBox;
import org.uqbar.arena.widgets.Control;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.RadioSelector;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.arena.xtend.ArenaXtendExtensions;
import org.uqbar.lacar.ui.model.Action;
import org.uqbar.lacar.ui.model.ControlBuilder;
import org.uqbar.lacar.ui.model.ListBuilder;

@SuppressWarnings("all")
public class AgregarEditarPlatoWindow extends TransactionalDialog<PlatoAppModel> {
  public AgregarEditarPlatoWindow(final WindowOwner owner, final Pedido pedido, final Plato plato) {
    super(owner, new PlatoAppModel(pedido, plato));
    this.setTitle("Editar Plato");
  }
  
  protected void createFormPanel(final Panel mainPanel) {
    Panel _panel = new Panel(mainPanel);
    ColumnLayout _columnLayout = new ColumnLayout(2);
    final Panel form = _panel.setLayout(_columnLayout);
    Label _label = new Label(form);
    _label.setText("Pizza:");
    Selector<Pizza> _selector = new Selector<Pizza>(form);
    final Procedure1<Selector<Pizza>> _function = new Procedure1<Selector<Pizza>>() {
      public void apply(final Selector<Pizza> it) {
        it.allowNull(false);
        ObservableValue<Control, ControlBuilder> _value = it.<ControlBuilder>value();
        ArenaXtendExtensions.operator_spaceship(_value, "plato.pizza");
        ObservableItems<Selector<Pizza>, Pizza, ListBuilder<Pizza>> _items = it.items();
        ArenaXtendExtensions.operator_spaceship(_items, "repoPizza.objects");
      }
    };
    ObjectExtensions.<Selector<Pizza>>operator_doubleArrow(_selector, _function);
    Label _label_1 = new Label(form);
    _label_1.setText("Tamaño:");
    Selector<Tamanio> _selector_1 = new Selector<Tamanio>(form);
    final Procedure1<Selector<Tamanio>> _function_1 = new Procedure1<Selector<Tamanio>>() {
      public void apply(final Selector<Tamanio> it) {
        it.allowNull(false);
        ObservableValue<Control, ControlBuilder> _value = it.<ControlBuilder>value();
        ArenaXtendExtensions.operator_spaceship(_value, "plato.tamanio");
        ObservableItems<Selector<Tamanio>, Tamanio, ListBuilder<Tamanio>> _items = it.items();
        ArenaXtendExtensions.operator_spaceship(_items, "tamanios");
      }
    };
    ObjectExtensions.<Selector<Tamanio>>operator_doubleArrow(_selector_1, _function_1);
    Label _label_2 = new Label(form);
    _label_2.setText("Precio:");
    Label _label_3 = new Label(form);
    final Procedure1<Label> _function_2 = new Procedure1<Label>() {
      public void apply(final Label it) {
        ObservableValue<Control, ControlBuilder> _value = it.<ControlBuilder>value();
        ArenaXtendExtensions.operator_spaceship(_value, "plato.precio");
      }
    };
    ObjectExtensions.<Label>operator_doubleArrow(_label_3, _function_2);
    this.mostrarIngredientes(mainPanel);
  }
  
  public void mostrarIngredientes(final Panel panel) {
    Iterable<Ingrediente> _ingredientesPosibles = this.getModelObject().ingredientesPosibles();
    for (final Ingrediente ingrediente : _ingredientesPosibles) {
      {
        Plato _plato = this.getModelObject().getPlato();
        PlatoIngredienteModel _platoIngredienteModel = new PlatoIngredienteModel(_plato, ingrediente);
        Panel _panel = new Panel(panel, _platoIngredienteModel);
        HorizontalLayout _horizontalLayout = new HorizontalLayout();
        final Panel fila = _panel.setLayout(_horizontalLayout);
        CheckBox _checkBox = new CheckBox(fila);
        final Procedure1<CheckBox> _function = new Procedure1<CheckBox>() {
          public void apply(final CheckBox it) {
            ObservableValue<Control, ControlBuilder> _value = it.<ControlBuilder>value();
            ArenaXtendExtensions.operator_spaceship(_value, "contieneAgregado");
          }
        };
        ObjectExtensions.<CheckBox>operator_doubleArrow(_checkBox, _function);
        Label _label = new Label(fila);
        _label.setText(ingrediente.getNombre());
        RadioSelector<Object> _radioSelector = new RadioSelector<Object>(fila);
        final Procedure1<RadioSelector<Object>> _function_1 = new Procedure1<RadioSelector<Object>>() {
          public void apply(final RadioSelector<Object> it) {
            ObservableItems<Selector<Object>, Object, ListBuilder<Object>> _items = it.items();
            ArenaXtendExtensions.operator_spaceship(_items, "posiblesLados");
            ObservableValue<Control, ControlBuilder> _value = it.<ControlBuilder>value();
            ArenaXtendExtensions.operator_spaceship(_value, "agregado.lado");
          }
        };
        ObjectExtensions.<RadioSelector<Object>>operator_doubleArrow(_radioSelector, _function_1);
      }
    }
  }
  
  protected void addActions(final Panel actions) {
    Button _button = new Button(actions);
    final Procedure1<Button> _function = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Aceptar");
        final Action _function = new Action() {
          public void execute() {
            AgregarEditarPlatoWindow.this.accept();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button, _function);
    Button _button_1 = new Button(actions);
    final Procedure1<Button> _function_1 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Cancelar");
        final Action _function = new Action() {
          public void execute() {
            AgregarEditarPlatoWindow.this.cancel();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button_1, _function_1);
  }
  
  public void executeTask() {
    this.getModelObject().agregarPlato();
    super.executeTask();
  }
}
