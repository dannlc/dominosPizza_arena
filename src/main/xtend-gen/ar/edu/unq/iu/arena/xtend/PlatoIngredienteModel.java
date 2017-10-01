package ar.edu.unq.iu.arena.xtend;

import ar.edu.unq.iu.modelo.Agregado;
import ar.edu.unq.iu.modelo.Ingrediente;
import ar.edu.unq.iu.modelo.Lado;
import ar.edu.unq.iu.modelo.LadoAmbos;
import ar.edu.unq.iu.modelo.LadoDerecho;
import ar.edu.unq.iu.modelo.LadoIzquierdo;
import ar.edu.unq.iu.modelo.Plato;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.model.annotations.TransactionalAndObservable;

@TransactionalAndObservable
@Accessors
@SuppressWarnings("all")
public class PlatoIngredienteModel implements Serializable {
  private Plato plato;
  
  private Ingrediente ingrediente;
  
  private Agregado agregado;
  
  public PlatoIngredienteModel(final Plato plato, final Ingrediente ingrediente) {
    this.plato = plato;
    this.ingrediente = ingrediente;
    boolean _contieneAgregadoDe = plato.contieneAgregadoDe(ingrediente);
    if (_contieneAgregadoDe) {
      this.agregado = plato.agregadoDe(ingrediente);
    } else {
      LadoAmbos _ladoAmbos = new LadoAmbos();
      Agregado _agregado = new Agregado(ingrediente, _ladoAmbos);
      this.agregado = _agregado;
    }
  }
  
  public Boolean getContieneAgregado() {
    return Boolean.valueOf(this.plato.contieneAgregadoDe(this.ingrediente));
  }
  
  public void setContieneAgregado(final Boolean agregar) {
    if ((agregar).booleanValue()) {
      this.plato.agregarAgregado(this.agregado);
    } else {
      this.plato.quitarAgregado(this.agregado);
    }
  }
  
  public List<? extends Lado> getPosiblesLados() {
    LadoIzquierdo _ladoIzquierdo = new LadoIzquierdo();
    LadoAmbos _ladoAmbos = new LadoAmbos();
    LadoDerecho _ladoDerecho = new LadoDerecho();
    return Collections.<Lado>unmodifiableList(CollectionLiterals.<Lado>newArrayList(_ladoIzquierdo, _ladoAmbos, _ladoDerecho));
  }
  
  @Pure
  public Plato getPlato() {
    return this.plato;
  }
  
  public void setPlato(final Plato plato) {
    this.plato = plato;
  }
  
  @Pure
  public Ingrediente getIngrediente() {
    return this.ingrediente;
  }
  
  public void setIngrediente(final Ingrediente ingrediente) {
    this.ingrediente = ingrediente;
  }
  
  @Pure
  public Agregado getAgregado() {
    return this.agregado;
  }
  
  public void setAgregado(final Agregado agregado) {
    this.agregado = agregado;
  }
}
