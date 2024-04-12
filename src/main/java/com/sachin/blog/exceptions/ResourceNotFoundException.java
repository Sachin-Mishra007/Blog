package com.sachin.blog.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    String resourceName;
    Integer resourceId;
    

    public ResourceNotFoundException(String resourceName, Integer resourceId) {
        super(resourceName + " Not Found with Id: " + resourceId);
        this.resourceName = resourceName;
        this.resourceId = resourceId;

    }

}
