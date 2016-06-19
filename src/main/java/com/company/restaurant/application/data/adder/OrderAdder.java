package com.company.restaurant.application.data.adder;

import com.company.restaurant.application.data.chooser.ObjectChooser;
import com.company.restaurant.application.data.collector.ItemCollector;
import com.company.restaurant.controllers.OrderController;
import com.company.restaurant.model.Employee;
import com.company.restaurant.model.OrderView;
import com.company.restaurant.model.Table;
import com.company.util.Util;

/**
 * Created by Yevhen on 29.05.2016.
 */
public class OrderAdder extends ObjectAdderProto<OrderView>  {
    private static final String ENTER_ORDER_NUMBER_MESSAGE = "Please, enter order number";

    private OrderController orderController;
    private ObjectChooser<Employee> employeeChooser;
    private ObjectChooser<Table> tableChooser;
    private ItemCollector<OrderView> orderCourseCollector;

    public void setOrderController(OrderController orderController) {
        this.orderController = orderController;
    }

    public void setEmployeeChooser(ObjectChooser<Employee> employeeChooser) {
        this.employeeChooser = employeeChooser;
    }

    public void setTableChooser(ObjectChooser<Table> tableChooser) {
        this.tableChooser = tableChooser;
    }

    public void setOrderCourseCollector(ItemCollector<OrderView> orderCourseCollector) {
        this.orderCourseCollector = orderCourseCollector;
    }

    private OrderView addOrder() {
        OrderView result = null;

        String orderNumber = Util.readInputString(ENTER_ORDER_NUMBER_MESSAGE);
        if (orderNumber != null && !orderNumber.isEmpty()) {
            Employee employee = employeeChooser.chooseObjectFromList();
            if (employee != null) {
                Table table = tableChooser.chooseObjectFromList();
                if (table != null) {
                    OrderView orderView = new OrderView();
                    orderView.setOrderNumber(orderNumber.trim());
                    orderView.setEmployeeId(employee.getEmployeeId());
                    orderView.setTableId(table.getTableId());

                    result = orderController.addOrder(orderView);
                    dataHasBeenSuccessfullyAddedMessage();
                }
            }
        }

        return result;
    }


    @Override
    protected OrderView addObject() {
        OrderView result = addOrder();
        orderCourseCollector.addItemsToObject(result);

        return result;
    }
}
