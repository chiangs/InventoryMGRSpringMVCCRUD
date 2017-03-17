package controllers;

import javax.swing.plaf.synth.SynthSeparatorUI;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
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
@SessionAttributes({ "inventory" })
public class ProductController {

	@ModelAttribute("product")
	public Product pro() {
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
	public ModelAndView viewEdit(Integer ID) {
		ModelAndView mv = new ModelAndView();
		if (ID != null) {
			Product p = productService.getProduct(ID);
			mv.addObject("product", p);
		}
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
	public ModelAndView addByID(@Valid Product product, Errors errors) {
		ModelAndView mv = new ModelAndView();
		if (errors.getErrorCount() != 0) {
			mv.setViewName("addProduct");
			return mv;
		} else {
			productService.addProduct(product);
			mv.addObject("inventory", productService.getInventory());
			mv.setViewName("viewInventory");
			return mv;
		}
	}

	@RequestMapping(path = "DeleteProduct.do", method = RequestMethod.GET)
	public ModelAndView viewDelete() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("inventory", productService.getInventory());
		mv.setViewName("deleteProduct");
		return mv;
	}

	@RequestMapping(path = "DeleteProductData.do", method = RequestMethod.POST)
	public ModelAndView viewDelete(@RequestParam("ID") String id) {
		ModelAndView mv = new ModelAndView();
		productService.deleteProduct(Integer.parseInt(id));
		mv.addObject("inventory", productService.getInventory());
		mv.setViewName("viewInventory");
		return mv;
	}

	@RequestMapping(path = "ViewProduct.do", method = RequestMethod.GET)
	public ModelAndView viewProduct(Integer ID) {
		ModelAndView mv = new ModelAndView();
		if (ID != null) {
			Product p = productService.getProduct(ID);
			mv.addObject("product", p);
		}
		mv.addObject("inventory", productService.getInventory());
		mv.setViewName("viewProduct");
		return mv;
	}

	@RequestMapping(path = "ViewProductData.do", method = RequestMethod.POST)
	public ModelAndView viewProduct(@RequestParam("ID") String id) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("product", productService.getProduct(Integer.parseInt(id)));
		mv.setViewName("viewProduct");
		return mv;
	}

}
