/**
 * 
 */
package br.com.nebulastar.exceptions;

/**
 * Created by Nebula Stardust
 */
public class DAOException extends Exception {

	private static final long serialVersionUID = 7054379063290825137L;

	public DAOException(String msg, Exception ex) {
		super(msg, ex);
    }
}
