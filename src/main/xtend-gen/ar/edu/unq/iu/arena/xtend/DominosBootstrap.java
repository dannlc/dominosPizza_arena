package ar.edu.unq.iu.arena.xtend;

import ar.edu.unq.iu.modelo.Agregado;
import ar.edu.unq.iu.modelo.Cancelado;
import ar.edu.unq.iu.modelo.Cliente;
import ar.edu.unq.iu.modelo.Delivery;
import ar.edu.unq.iu.modelo.EnViaje;
import ar.edu.unq.iu.modelo.Entregado;
import ar.edu.unq.iu.modelo.Ingrediente;
import ar.edu.unq.iu.modelo.LadoIzquierdo;
import ar.edu.unq.iu.modelo.Menu;
import ar.edu.unq.iu.modelo.Pedido;
import ar.edu.unq.iu.modelo.Pizza;
import ar.edu.unq.iu.modelo.Plato;
import ar.edu.unq.iu.modelo.Retirar;
import ar.edu.unq.iu.modelo.TamanioFamiliar;
import ar.edu.unq.iu.modelo.TamanioPorcion;
import ar.edu.unq.iu.repo.RepoCliente;
import ar.edu.unq.iu.repo.RepoIngrediente;
import ar.edu.unq.iu.repo.RepoPedido;
import ar.edu.unq.iu.repo.RepoPizza;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.bootstrap.CollectionBasedBootstrap;
import org.uqbar.commons.applicationContext.ApplicationContext;

@SuppressWarnings("all")
public class DominosBootstrap extends CollectionBasedBootstrap {
  public DominosBootstrap() {
    ApplicationContext _instance = ApplicationContext.getInstance();
    RepoPedido _repoPedido = new RepoPedido();
    _instance.<RepoPedido>configureSingleton(Pedido.class, _repoPedido);
    ApplicationContext _instance_1 = ApplicationContext.getInstance();
    RepoCliente _repoCliente = new RepoCliente();
    _instance_1.<RepoCliente>configureSingleton(Cliente.class, _repoCliente);
    ApplicationContext _instance_2 = ApplicationContext.getInstance();
    RepoIngrediente _repoIngrediente = new RepoIngrediente();
    _instance_2.<RepoIngrediente>configureSingleton(Ingrediente.class, _repoIngrediente);
    ApplicationContext _instance_3 = ApplicationContext.getInstance();
    RepoPizza _repoPizza = new RepoPizza();
    _instance_3.<RepoPizza>configureSingleton(Pizza.class, _repoPizza);
  }
  
  public void run() {
    Object _singleton = ApplicationContext.getInstance().<Object>getSingleton(Pedido.class);
    final RepoPedido repoPedido = ((RepoPedido) _singleton);
    Object _singleton_1 = ApplicationContext.getInstance().<Object>getSingleton(Ingrediente.class);
    final RepoIngrediente repoIngrediente = ((RepoIngrediente) _singleton_1);
    Object _singleton_2 = ApplicationContext.getInstance().<Object>getSingleton(Cliente.class);
    final RepoCliente repoCliente = ((RepoCliente) _singleton_2);
    Object _singleton_3 = ApplicationContext.getInstance().<Object>getSingleton(Pizza.class);
    final RepoPizza repoPizza = ((RepoPizza) _singleton_3);
    final Ingrediente panceta = repoIngrediente.create("Panceta", 5.0);
    final Ingrediente morrones = repoIngrediente.create("Morrones", 3.5);
    final Ingrediente jamon = repoIngrediente.create("Jamon", 3.5);
    final Ingrediente queso = repoIngrediente.create("Queso", 1.0);
    Pizza _pizza = new Pizza("Jamon y Morrones", 50.0);
    final Procedure1<Pizza> _function = new Procedure1<Pizza>() {
      public void apply(final Pizza it) {
        it.agregarIngrediente(jamon);
        it.agregarIngrediente(morrones);
        it.agregarIngrediente(queso);
      }
    };
    final Pizza jym = ObjectExtensions.<Pizza>operator_doubleArrow(_pizza, _function);
    Pizza _pizza_1 = new Pizza("Panceta", 60.0);
    final Procedure1<Pizza> _function_1 = new Procedure1<Pizza>() {
      public void apply(final Pizza it) {
        it.agregarIngrediente(panceta);
        it.agregarIngrediente(queso);
      }
    };
    final Pizza pizzaPanceta = ObjectExtensions.<Pizza>operator_doubleArrow(_pizza_1, _function_1);
    final Procedure1<RepoPizza> _function_2 = new Procedure1<RepoPizza>() {
      public void apply(final RepoPizza it) {
        it.create(jym);
        it.create(pizzaPanceta);
      }
    };
    ObjectExtensions.<RepoPizza>operator_doubleArrow(repoPizza, _function_2);
    TamanioPorcion _tamanioPorcion = new TamanioPorcion();
    Plato _plato = new Plato(jym, _tamanioPorcion);
    final Procedure1<Plato> _function_3 = new Procedure1<Plato>() {
      public void apply(final Plato it) {
        LadoIzquierdo _ladoIzquierdo = new LadoIzquierdo();
        Agregado _agregado = new Agregado(panceta, _ladoIzquierdo);
        it.agregarAgregado(_agregado);
      }
    };
    final Plato plato1 = ObjectExtensions.<Plato>operator_doubleArrow(_plato, _function_3);
    TamanioFamiliar _tamanioFamiliar = new TamanioFamiliar();
    final Plato plato2 = new Plato(pizzaPanceta, _tamanioFamiliar);
    final Cliente micaela = repoCliente.create("Micaela", "Mica", "password01", "mail01", "direccion01");
    final Cliente luciana = repoCliente.create("Luciana", "Luli", "password02", "mail02", "direccion02");
    final Cliente daniel = repoCliente.create("Daniel", "Dani", "password03", "mail03", "direccion03");
    final Cliente brian = repoCliente.create("Brian", "Bri", "password04", "mail04", "direccion04");
    final Cliente extra = repoCliente.create("Extra", "e", "password05", "mail05", "direccion05");
    String _direccion = micaela.getDireccion();
    Delivery _delivery = new Delivery(_direccion);
    Pedido _pedido = new Pedido(micaela, _delivery);
    final Procedure1<Pedido> _function_4 = new Procedure1<Pedido>() {
      public void apply(final Pedido it) {
        it.getPlatos().add(plato1);
        it.getPlatos().add(plato2);
      }
    };
    final Pedido pedidoM = ObjectExtensions.<Pedido>operator_doubleArrow(_pedido, _function_4);
    String _direccion_1 = luciana.getDireccion();
    Delivery _delivery_1 = new Delivery(_direccion_1);
    Pedido _pedido_1 = new Pedido(luciana, _delivery_1);
    final Procedure1<Pedido> _function_5 = new Procedure1<Pedido>() {
      public void apply(final Pedido it) {
        EnViaje _enViaje = new EnViaje();
        it.setEstado(_enViaje);
        it.getPlatos().add(plato2);
      }
    };
    final Pedido pedidoL = ObjectExtensions.<Pedido>operator_doubleArrow(_pedido_1, _function_5);
    Retirar _retirar = new Retirar();
    Pedido _pedido_2 = new Pedido(daniel, _retirar);
    final Procedure1<Pedido> _function_6 = new Procedure1<Pedido>() {
      public void apply(final Pedido it) {
        Cancelado _cancelado = new Cancelado();
        it.setEstado(_cancelado);
        it.getPlatos().add(plato1);
      }
    };
    final Pedido pedidoD = ObjectExtensions.<Pedido>operator_doubleArrow(_pedido_2, _function_6);
    String _direccion_2 = brian.getDireccion();
    Delivery _delivery_2 = new Delivery(_direccion_2);
    Pedido _pedido_3 = new Pedido(brian, _delivery_2);
    final Procedure1<Pedido> _function_7 = new Procedure1<Pedido>() {
      public void apply(final Pedido it) {
        Entregado _entregado = new Entregado();
        it.setEstado(_entregado);
        it.getPlatos().add(plato1);
      }
    };
    final Pedido pedidoB = ObjectExtensions.<Pedido>operator_doubleArrow(_pedido_3, _function_7);
    Retirar _retirar_1 = new Retirar();
    Pedido _pedido_4 = new Pedido(extra, _retirar_1);
    final Procedure1<Pedido> _function_8 = new Procedure1<Pedido>() {
      public void apply(final Pedido it) {
        it.getPlatos().add(plato1);
      }
    };
    final Pedido pedidoE = ObjectExtensions.<Pedido>operator_doubleArrow(_pedido_4, _function_8);
    final Procedure1<RepoPedido> _function_9 = new Procedure1<RepoPedido>() {
      public void apply(final RepoPedido it) {
        it.create(pedidoM);
        it.create(pedidoL);
        it.create(pedidoD);
        it.create(pedidoB);
        it.create(pedidoE);
      }
    };
    ObjectExtensions.<RepoPedido>operator_doubleArrow(repoPedido, _function_9);
    Menu _menu = new Menu();
    final Procedure1<Menu> _function_10 = new Procedure1<Menu>() {
      public void apply(final Menu it) {
        it.agregarIngredienteExtra(panceta);
        it.agregarIngredienteExtra(morrones);
        it.agregarIngredienteExtra(jamon);
        it.agregarPizza(jym);
        it.agregarPizza(pizzaPanceta);
      }
    };
    final Menu menu = ObjectExtensions.<Menu>operator_doubleArrow(_menu, _function_10);
  }
}
