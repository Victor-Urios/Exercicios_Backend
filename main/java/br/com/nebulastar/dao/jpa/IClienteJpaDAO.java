/**
 * 
 */
package br.com.nebulastar.dao.jpa;

import br.com.nebulastar.dao.generic.jpa.IGenericJapDAO;
import br.com.nebulastar.domain.jpa.Persistente;

/**
 * Created by Nebula Stardust
 */
public interface IClienteJpaDAO<T extends Persistente> extends IGenericJapDAO<T, Long>{

}
