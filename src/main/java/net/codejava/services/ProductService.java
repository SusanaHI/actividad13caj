package net.codejava.services;

import net.codejava.repositories.ProductRepository;
import net.codejava.entity.Product;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Component("Operacion")
public class ProductService {

    public double IMCC, IMCI;
    
	@Autowired
	private ProductRepository repo;
	
	public List<Product> listAll() {
		return repo.findAll();
	}
	
	public void save(Product product) {
		repo.save(product);
	}
	
	public Product get(long id) {
		return repo.findById(id).get();
	}
	
	public void delete(long id) {
		repo.deleteById(id);
	}
        
        public double IMC(double peso, double estatura){
            IMCC=peso/(Math.pow(estatura,2));
            return IMCC;
        }
        
        public String IMCR(){
            if(IMCC<18.5){
                return "Delgadez extrema";
            }else if(IMCC>=18.5&&IMCC<=24.9){
                return "Peso Normal";
            }else if(IMCC>=25&&IMCC<=29.9){
                return "Sobrepeso";
            }else if(IMCC>=30&&IMCC<=34.9){
                return "Obesidad";
            }else{
                return "Obesidad Extrema";
            }
        }
}