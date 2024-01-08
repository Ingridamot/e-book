package lt.codeacademy.ebook.product;

import lt.codeacademy.ebook.HttpEndpoints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(HttpEndpoints.PRODUCTS_CREATE)
    public String sayHelloToCustomer(Model model) {
        model.addAttribute("product", Product.builder().build());
        return "product/product";
    }

    @PostMapping(HttpEndpoints.PRODUCTS_CREATE)
    public String createAProduct(Product product) {

        productService.saveProduct(product);
        System.out.println("currently in the database");
        productService.getAllProducts().forEach(System.out::println);
        return "welcome/welcome";  // tai nera URL path
    }

    @GetMapping(HttpEndpoints.PRODUCTS)
    public String getProducts(Model model) {
        final List<Product> allProducts = productService.getAllProducts();
        model.addAttribute("productList", allProducts);
        return "product/products";
    }
}