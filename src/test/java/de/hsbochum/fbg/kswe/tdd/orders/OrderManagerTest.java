package de.hsbochum.fbg.kswe.tdd.orders;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author <a href="mailto:m.rieke@52north.org">Matthes Rieke</a>
 */
public class OrderManagerTest {

    @Test
    public void testOrderManager() {
        SubService service = new SubService();
        OrderManager om = new OrderManager(service);
        Product p = new Product("Kernseife", new File("path/to/productfile"));
        Customer c = new Customer("Max", "Mustermann");
        Order o = new Order(c, 2, p);
        
        Product p2 = new Product("Waffeln", new File("path/to/productfile"));
        Order o2 = new Order(c, 1, p2);
        
        om.submitOrder(o);
        om.submitOrder(o2);
        List<Order> queuedOrders = om.getQueuedOrders();
        
        Assert.assertThat(queuedOrders.size(), CoreMatchers.is(2));
        
        om.processOrders();
        
        Assert.assertThat(queuedOrders.size(), CoreMatchers.is(0));
        
        
        List<Product> deliveredProducts = service.getDeliveredProducts();
        Assert.assertThat(o2.getProduct(), CoreMatchers.equalTo(deliveredProducts.get(0)));
        Assert.assertThat(o.getProduct(), CoreMatchers.equalTo(deliveredProducts.get(1)));
    }
    
    private static class SubService extends ProductDeliveryService{
        private final List<Product> deliveredProducts = new ArrayList<>();

        @Override
        public void deliver(Product p, Customer c) {
            Logger.getLogger(SubService.class.getName()).log(Level.INFO, "delivered product {0}", p.getName());
            super.deliver(p, c); //To change body of generated methods, choose Tools | Templates.
            this.deliveredProducts.add(p);
        }
        
        
        public List<Product> getDeliveredProducts(){
            return deliveredProducts;
        }
    }
}
