
package guru.springframework.repositories;

import guru.springframework.domain.Product;
import com.reljicd.others.CreateNode;
import com.reljicd.others.Operator;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

public class ProductRepository {
    private CreateNode c = new CreateNode<>();

    // Simulate a symbolic read operation (findById)
    public Product findById(Integer id) {
        ArrayList<Product> products = TableManager.getTable("Product");
        ArrayList<Long> primaryKeys = new ArrayList<>();
        Map<Long, Product> tuples = new HashMap<>();
        
        for (Product product : products) {
            if (product.getId() == id) {
                Map<String, Map<Long, Object>> mp = new HashMap<>();
                Product copyProduct = product.createDeepCopy(mp, false);
                primaryKeys.add(id);
                tuples.put(id, copyProduct);
                // Simulate symbolic read node creation
                c.createReadNode("Product", "getId", Operator.EQUAL, id, primaryKeys, tuples);
                return copyProduct;
            }
        }
        return null; // Product not found
    }

    // Simulate a symbolic read operation for all products (findAll)
    public List<Product> findAll() {
        ArrayList<Product> products = TableManager.getTable("Product");
        ArrayList<Long> primaryKeys = new ArrayList<>();
        Map<Long, Product> tuples = new HashMap<>();
        List<Product> copyProducts = new ArrayList<>();

        for (Product product : products) {
            Map<String, Map<Long, Object>> mp = new HashMap<>();
            Product copyProduct = product.createDeepCopy(mp, false);
            copyProducts.add(copyProduct);
            primaryKeys.add(product.getId());
            tuples.put(product.getId(), copyProduct);
        }
        // Simulate symbolic read node creation for the entire list of products
        c.createReadNode("Product", "", Operator.EQUAL, null, primaryKeys, tuples);
        return copyProducts;
    }

    // Simulate a symbolic read operation for a single product (findOne)
    public Product findOne(Long id) {
        ArrayList<Product> products = TableManager.getTable("Product");
        ArrayList<Long> primaryKeys = new ArrayList<>();
        Map<Long, Product> tuples = new HashMap<>();
        
        for (Product product : products) {
            if (product.getId() == id) {
                Map<String, Map<Long, Object>> mp = new HashMap<>();
                Product copyProduct = product.createDeepCopy(mp, false);
                primaryKeys.add(id);
                tuples.put(id, copyProduct);
                // Simulate symbolic read node creation
                c.createReadNode("Product", "getId", Operator.EQUAL, id, primaryKeys, tuples);
                return copyProduct;
            }
        }
        return null; // Product not found
    }

    // Simulate a symbolic write operation (save)
    public void save(Set<Product> productSet) {
        TableManager.getTable("Product");
        for (Product product : productSet) {
            // Create symbolic write node to simulate saving the product
            c.createWriteNode(product.getId(), "Product", new Product(product));
            // Set the product as the original one (for tracking changes)
            product.setOriginalProduct();
        }
    }

    // Simulate symbolic flushing (if necessary for your symbolic execution framework)
    public void flush() {
        // No symbolic actions required here, but you can define logic as needed
    }
}

