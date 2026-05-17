/**
 * 
 */
package br.com.nebulastar.dao.generic.jpa;

import java.io.Serializable;

import br.com.nebulastar.domain.jpa.Persistente;

/**
 * Created by Nebula Stardust
 */
public abstract class GenericJpaDB1DAO <T extends Persistente, E extends Serializable>
	extends GenericJpaDAO<T,E> {

	public GenericJpaDB1DAO(Class<T> persistenteClass) {
		super(persistenteClass, "Postgre1");
	}

}
