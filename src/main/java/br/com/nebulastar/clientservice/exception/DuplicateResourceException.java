package br.com.nebulastar.clientservice.exception;
/**
 * 
 * @author Nebula Stardust
 */
public class DuplicateResourceException extends RuntimeException {
	
private static final long serialVersionUID = 4245223124977059997L;

public DuplicateResourceException(String message) {
        super(message);
    }
}
