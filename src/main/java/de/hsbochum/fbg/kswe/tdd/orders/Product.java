
package de.hsbochum.fbg.kswe.tdd.orders;

import java.io.File;

/**
 *
 * @author <a href="mailto:m.rieke@52north.org">Matthes Rieke</a>
 */
public class Product {
    
    private final String name;
    private final File productFile;

    public Product(String nmae, File productFile) {
        this.name = nmae;
        this.productFile = productFile;
    }

    public String getName() {
        return name;
    }

    public File getProductFile() {
        return productFile;
    }

}
