package br.com.nebulastar.productservice.exception;
/**
 * 
 * @author Nebula Stardust
 */
public class ResourceNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 49824783487742609L;

	public ResourceNotFoundException(String message) {
        super(message);
    }
}
