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

	@RequestMapping(path = "GetProductData.do", params = "id", method = RequestMethod.GET)
	public ModelAndView getByID(@RequestParam("id") int id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("viewProduct");
		mv.addObject("product", productService.getProduct(id));
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
		System.out.println(prodToEdit);
		productService.editProduct(prodToEdit);
		ModelAndView mv = new ModelAndView();
//		mv.setViewName("editProduct");
//		mv.addObject("product", productService.editProduct(prodToEdit));
		mv.addObject("inventory", productService.getInventory());
		mv.setViewName("viewInventory");
		return mv;
	}

	@RequestMapping(path = "DeleteProduct.do", params = "id", method = RequestMethod.POST)
	public ModelAndView deleteByID(@RequestParam("id") int id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("deleteProduct");
		productService.deleteProduct(id);
		return mv;
	}

	@RequestMapping(path = "AddProduct.do", params = "product", method = RequestMethod.POST)
	public ModelAndView addProduct(Product newProd) {
		newProd.setID(productService.getInventory().get(productService.getInventory().size()-1).getID()+1);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addProduct");
		productService.addProduct(newProd);
		return mv;
	} // Unable to add product with ID of previously deleted

}
