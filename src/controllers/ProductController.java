package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;

import services.ProductService;

@Controller
@SessionAttributes({"id"})
public class ProductController {
	
	@Autowired
	private ProductService productService;

}
