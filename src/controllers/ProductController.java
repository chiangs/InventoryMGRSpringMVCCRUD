package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import data.Product;
import data.ProductDAO;
import services.ProductService;

@Controller
@SessionAttributes({ "inventory", "product" })
public class ProductController {

	@ModelAttribute("product")
	public Product pro(){
		return new Product();
	}
	@Autowired
	private ProductService productService;
	// private MockProductDAO mockDAO;
	private ProductDAO dao;

	public void setDao(ProductDAO dao) {
		this.dao = dao;
	}

	@RequestMapping(path = "GetInventory.do", method = RequestMethod.GET)
	public ModelAndView getInventory() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("viewInventory");
		mv.addObject("inventory", productService.getInventory());
		return mv;
	}

	@RequestMapping(path = "EditProduct.do", method = RequestMethod.GET)
	public ModelAndView viewEdit() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("inventory", productService.getInventory());
		mv.setViewName("editProduct");
		return mv;
	}

	@RequestMapping(path = "EditProductData.do", method = RequestMethod.POST)
	public ModelAndView editByID(Product prodToEdit) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("inventory", productService.editProduct(prodToEdit));
		mv.setViewName("viewInventory");
		return mv;
	}
	
	@RequestMapping(path = "AddProduct.do", method = RequestMethod.GET)
	public ModelAndView viewAdd() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("inventory", productService.getInventory());
		mv.setViewName("addProduct");
		return mv;
	}
	
	@RequestMapping(path = "AddProductData.do", method = RequestMethod.POST)
	public ModelAndView addByID(Product prodToAdd) {
		ModelAndView mv = new ModelAndView();
//		prodToAdd.setID(productService.getInventory().get(productService.getInventory().size()-1).getID()+1);
		productService.addProduct(prodToAdd);
		mv.addObject("inventory", productService.getInventory());
		mv.setViewName("viewInventory");
		return mv;
	}
}
	