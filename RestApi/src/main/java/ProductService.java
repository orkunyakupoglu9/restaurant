import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;


    public List<Product> getAllProducts()
    {


        return repository.findAll();

    }

    public void addProduct(Product product)
    {

        repository.save(product);


    }


    public String deleteProduct(@PathVariable Long id)
    {
        repository.deleteById(id);

        return "ID "+id+" is deleted";
    }


}
