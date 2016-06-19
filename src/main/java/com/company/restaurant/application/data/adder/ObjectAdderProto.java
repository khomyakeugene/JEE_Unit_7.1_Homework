package com.company.restaurant.application.data.adder;

import com.company.restaurant.application.data.list.ObjectTableList;
import com.company.restaurant.application.data.service.DatabaseService;
import com.company.restaurant.application.data.service.Executor;
import com.company.util.Util;

import java.util.List;

/**
 * Created by Yevhen on 29.05.2016.
 */
public abstract class ObjectAdderProto<T> extends DatabaseService implements Executor {
    private static final String EXISTING_DATA = "Existing data:";

    private ObjectTableList<T> objectTableList;

    public void setObjectTableList(ObjectTableList<T> objectTableList) {
        this.objectTableList = objectTableList;
    }

    protected abstract T addObject();

    private List<T> addObjects() {
        List<T> result ;
        T object;

        do {
            existingDataMessage();
            result = objectTableList.displayObjectList(objectTableList.prepareObjectList());
            object = addObject();
        } while (object != null);

        return result;
    }

    protected String getExistingDataMessage() {
        return EXISTING_DATA;
    }

    private void existingDataMessage() {
        Util.printMessage(getExistingDataMessage());
    }


    @Override
    public void execute() {
        addObjects();
    }
}
