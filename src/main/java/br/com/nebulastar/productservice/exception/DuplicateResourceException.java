package br.com.nebulastar.productservice.exception;
/**
 * 
 * @author Nebula Stardust
 */
public class DuplicateResourceException extends RuntimeException {
    private static final long serialVersionUID = 5570469613982278893L;

	public DuplicateResourceException(String message) {
        super(message);
    }
}
