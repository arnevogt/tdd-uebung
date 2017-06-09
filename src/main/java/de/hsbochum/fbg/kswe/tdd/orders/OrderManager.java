
package de.hsbochum.fbg.kswe.tdd.orders;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author <a href="mailto:m.rieke@52north.org">Matthes Rieke</a>
 */
public class OrderManager {

    private final ProductDeliveryService delivery;
    private final List<Order> queuedOrders;

    public OrderManager(ProductDeliveryService delivery) {
        this.delivery = delivery;
        this.queuedOrders = new LinkedList<>();
    }
    
    public void submitOrder(Order o){
        this.queuedOrders.add(o);
    }
    
    public List<Order> getQueuedOrders(){
        return this.queuedOrders;
    }
    
    public void processOrders(){
        queuedOrders.sort(new PriorityComparator());
        
        queuedOrders.forEach((o) -> {
            this.delivery.deliver(o.getProduct(), o.getCustomer());
        });
        
        this.queuedOrders.clear();
    }
    
 

    private class PriorityComparator implements Comparator<Order> {

        public PriorityComparator() {
        }

        @Override
        public int compare(Order o1, Order o2) {
            return (o1.getPriority() - o2.getPriority());
        }
    }  
}
