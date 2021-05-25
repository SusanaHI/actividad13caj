package net.codejava.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.codejava.services.ProductService;
import net.codejava.Usuario;
import net.codejava.entity.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {

    @Autowired
    private ProductService service;

    @RequestMapping("/")
    public String viewHomePage(HttpSession session, Model model) {

        if (session.getAttribute("mySessionAttribute") != null) {
            List<Product> listProducts = service.listAll();
            model.addAttribute("listProducts", listProducts);
            return "index";
        } else {
            model.addAttribute("usuario", new Usuario());
            return "login";
        }
        //model.addAttribute("listProducts", listProducts);
    }

    @RequestMapping("/login")
    public String login(HttpSession session) {
        session.setAttribute("mySessionAttribute", "sasas");

        // model.addAttribute("listProducts", listProducts);
        return "redirect:/";
    }

    @RequestMapping("/new")
    public String showNewProductPage(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);

        return "new_product";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") Product product) {
        if(product.edad>=15){
            if(product.peso>0){
                if(product.estatura>0.99 && product.estatura<2.6){
                    service.save(product);
                }
            }
        }else{
            System.out.println("\n TOMA EN CUENTA LAS SIGUIENTES CONSIDERACIONES:");
            System.out.println("La edad no puede ser menor a 15.");
            System.out.println("El peso debe ser positivo y mayor a 0.");
            System.out.println("La estatura debe expresarse en metros, debe ser mayor a 0.99 y menor a 2.6.");
        }

        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_product");
        Product product = service.get(id);
        mav.addObject("product", product);

        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/";
    }
}
