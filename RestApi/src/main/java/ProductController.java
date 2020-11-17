import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
     private ProductService service;

    @GetMapping("/list")
    public List<Product> listAllProducts()
    {



        return service.getAllProducts();
    }

    @PostMapping("/add")
    public Product addProduct(@RequestBody Product product)
    {

        service.addProduct(product);

        return product;

    }

    @DeleteMapping("/{id}")
    public void deleteNews(@PathVariable Long id)
    {

        service.deleteProduct(id);

    }










}
