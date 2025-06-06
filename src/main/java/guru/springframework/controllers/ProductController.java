package guru.springframework.controllers;

import guru.springframework.domain.Product;
import guru.springframework.services.ProductService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import java.util.HashMap;
import java.util.Map;

// @Controller
public class ProductController {

    private ProductService productService;

    // @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    // @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String list(/* Model model */ Map<String, Object> model) {
        model.put("products", productService.listAllProducts());
        System.out.println("Returning products:");
        return "products";
    }

    // @RequestMapping("product/{id}")
    public String showProduct(/* @PathVariable */ Integer id, /* Model model */ Map<String, Object> model) {
        model.put("product", productService.getProductById(id));
        return "productshow";
    }

    // @RequestMapping("product/edit/{id}")
    public String edit(/* @PathVariable */ Integer id, /* Model model */ Map<String, Object> model) {
        model.put("product", productService.getProductById(id));
        return "productform";
    }

    // @RequestMapping("product/new")
    public String newProduct(/* Model model */ Map<String, Object> model) {
        model.put("product", new Product());
        return "productform";
    }

    // @RequestMapping(value = "product", method = RequestMethod.POST)
    public String saveProduct(Product product) {
        productService.saveProduct(product);
        return "redirect:/product/" + product.getId();
    }

  


}
