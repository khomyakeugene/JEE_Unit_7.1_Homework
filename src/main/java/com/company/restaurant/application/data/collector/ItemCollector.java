package com.company.restaurant.application.data.collector;

/**
 * Created by Yevhen on 29.05.2016.
 */
public interface ItemCollector<T> {
    void addItemsToObject();

    T addItemsToObject(T object);

    void delItemsFromObject();

    T delItemsFromObject(T object);
}
