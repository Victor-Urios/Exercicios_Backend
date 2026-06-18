package br.com.nebulastar.clientservice.exception;

/**
 * 
 * @author Nebula Stardust
 */
public class ResourceNotFoundException extends RuntimeException {
    private static final long serialVersionUID = -4020441417853279140L;

	public ResourceNotFoundException(String message) {
        super(message);
    }
}
