package com.example.demo.exception;

public class FieldErrorDTO {
	private String field;
	 
    private String message;
 
    public FieldErrorDTO(String field, String message) {
        this.field = field;
        this.message = message;
    }
    
    public String getMessage() {
        return message;
      }

      public String getField() {
    	    return field;
      }
}
