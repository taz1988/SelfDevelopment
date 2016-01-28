package com.practice.collection.service;

public enum CollectionImplementationType {

    ARRAY_LIST(CollectionInterfaceType.LIST),
    LINKED_LIST(CollectionInterfaceType.LIST),
    HASH_MAP(CollectionInterfaceType.MAP),
    TREE_MAP(CollectionInterfaceType.MAP),
    LINKED_HASH_MAP(CollectionInterfaceType.MAP);

    private CollectionInterfaceType type;

    CollectionImplementationType(CollectionInterfaceType type) {
        this.type = type;
    }

    public CollectionInterfaceType getType() {
        return type;
    }
}
