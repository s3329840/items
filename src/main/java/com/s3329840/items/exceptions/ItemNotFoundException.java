package com.s3329840.items.exceptions;

public class ItemNotFoundException extends RuntimeException {

    public ItemNotFoundException(int id) {
        super("Could not find item " + id);
    }
}
