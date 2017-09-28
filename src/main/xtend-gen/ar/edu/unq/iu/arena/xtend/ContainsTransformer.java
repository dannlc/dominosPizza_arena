package ar.edu.unq.iu.arena.xtend;

import java.util.List;
import org.uqbar.arena.bindings.ValueTransformer;
import org.uqbar.common.transaction.Collection.TransacionalList;

@SuppressWarnings("all")
public class ContainsTransformer<T extends Object> implements ValueTransformer<TransacionalList<T>, Boolean> {
  private TransacionalList<T> list;
  
  private T model;
  
  public ContainsTransformer(final T model) {
    this.model = model;
  }
  
  public TransacionalList<T> viewToModel(final Boolean onList) {
    TransacionalList<T> _xblockexpression = null;
    {
      if ((onList).booleanValue()) {
        this.list.add(this.model);
      } else {
        this.list.remove(this.model);
      }
      _xblockexpression = this.list;
    }
    return _xblockexpression;
  }
  
  public Boolean modelToView(final TransacionalList<T> list) {
    boolean _xblockexpression = false;
    {
      this.list = list;
      _xblockexpression = list.contains(this.model);
    }
    return Boolean.valueOf(_xblockexpression);
  }
  
  public Class getModelType() {
    return List.class;
  }
  
  public Class<Boolean> getViewType() {
    return Boolean.class;
  }
}
