/**
 * 
 */
package br.com.nebulastar.exceptions;

/**
 * @author rodrigo.pires
 *
 */
public class DAOException extends Exception {

	// ainda nao sei criar esse serial version uid, professor disse que ensinaria dps.!
	private static final long serialVersionUID = 7054379063290825137L;

	public DAOException(String msg, Exception ex) {
		super(msg, ex);
    }
}
