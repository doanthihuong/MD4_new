package controller;

import model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.IProduceService;
import service.ProduceService;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    private final IProduceService produceService = new ProduceService();

    @GetMapping("")
    public String index(Model model){
        List<Product> productList = produceService.findAll();
        model.addAttribute("products",productList);
        return "/index";
    }
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("product",new Product());
        return "/create";

    }
    @PostMapping("/save")
    public String save(Product product){
        product.setId((int) (Math.random() * 10000));
        produceService.save(product);
        return "redirect:/product";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("product", produceService.findById(id));
        return "/update";
    }

    @PostMapping("/update")
    public String update(Product product) {
        produceService.update(product.getId(), product);
        return "redirect:/product";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("product", produceService.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirect){
        produceService.remove(product.getId());
        redirect.addFlashAttribute("success", "Removed product successfully!");
        return "redirect:/product";
    }
    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", produceService.findById(id));
        return "/view";
    }

}