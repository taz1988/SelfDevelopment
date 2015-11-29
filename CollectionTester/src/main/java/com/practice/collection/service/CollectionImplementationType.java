package com.practice.collection.service;

public enum CollectionImplementationType {

    ARRAY_LIST(CollectionInterfaceType.LIST);

    private CollectionInterfaceType type;

    CollectionImplementationType(CollectionInterfaceType type) {
        this.type = type;
    }

    public CollectionInterfaceType getType() {
        return type;
    }
}
