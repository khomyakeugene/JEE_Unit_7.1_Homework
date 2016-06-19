package com.company.restaurant.application.data.chooser;

import com.company.restaurant.application.data.list.ItemTableList;
import com.company.restaurant.application.data.service.DataFinderAndChooserProto;

import java.util.List;

/**
 * Created by Yevhen on 28.05.2016.
 */
public abstract class ItemChooserProto<ObjectType, ItemType, ItemKeyFieldType>
        extends DataFinderAndChooserProto<ItemKeyFieldType>
        implements ItemChooser<ObjectType, ItemType> {

    private ItemTableList<ObjectType, ItemType> itemTableList;

    public void setItemTableList(ItemTableList<ObjectType, ItemType> itemTableList) {
        this.itemTableList = itemTableList;
    }

    protected abstract ItemType findItem(ObjectType object, ItemKeyFieldType itemKeyFieldValue);

    private ItemType chooseItemFromList(ObjectType object, List<ItemType> items) {
        ItemType result = null;

        ItemKeyFieldType itemKeyFieldValue = null;
        do {
            List<ItemType> list = itemTableList.displayObjectList(items);
            if (list != null && list.size() > 0) {
                itemKeyFieldValue = readKeyFieldValue();
                if (itemKeyFieldValue != null) {
                    result = findItem(object, itemKeyFieldValue);
                    if (result == null) {
                        objectDataHasNotBeenFoundMessage();
                    }
                }
            }
        } while (itemKeyFieldValue != null && result == null);

        return result;
    }

    @Override
    public List<ItemType> displayItemList(ObjectType object) {
        return itemTableList.displayItemList(object);
    }

    @Override
    public ItemType chooseItemFromList(ObjectType object) {
        return chooseItemFromList(object, itemTableList.prepareItemList(object));
    }
}
