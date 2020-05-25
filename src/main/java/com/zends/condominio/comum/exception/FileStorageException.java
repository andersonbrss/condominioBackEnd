package com.zends.condominio.comum.exception;

public class FileStorageException extends RuntimeException {
   
	private static final long serialVersionUID = -6660916862753191168L;
	
	public FileStorageException(String message) {
        super(message);
    }

    public FileStorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
