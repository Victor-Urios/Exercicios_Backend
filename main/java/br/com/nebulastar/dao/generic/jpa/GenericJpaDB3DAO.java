/**
 * 
 */
package br.com.nebulastar.dao.generic.jpa;

import java.io.Serializable;

import br.com.nebulastar.domain.jpa.Persistente;

/**
 * Created by Nebula Stardust
 */
public abstract class GenericJpaDB3DAO <T extends Persistente, E extends Serializable>
	extends GenericJpaDAO<T,E> {

	public GenericJpaDB3DAO(Class<T> persistenteClass) {
		super(persistenteClass, "Mysql1");
	}

}
