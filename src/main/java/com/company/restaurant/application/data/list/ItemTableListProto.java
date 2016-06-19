package com.company.restaurant.application.data.list;

import java.util.List;

/**
 * Created by Yevhen on 28.05.2016.
 */
public abstract class ItemTableListProto<ObjectType, ItemType> extends ObjectTableListProto<ItemType>
        implements ItemTableList<ObjectType, ItemType> {
    @Override
    public List<ItemType> displayItemList(ObjectType object) {
        return displayObjectList(prepareItemList(object));
    }

    @Override
    public List<ItemType> prepareObjectList() {
        return null;
    }
}
