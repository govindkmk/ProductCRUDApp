package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import dao.ProductDAO;
import model.Product;

@Controller
public class MainController {
	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping("/")
	public String home(Model model) {

		List<Product> products = productDAO.getAllProducts();
		model.addAttribute("products", products);
		return "index";
	}

	@RequestMapping("/add-Product")
	public String addProduct(Model model) {
		model.addAttribute("title", "Add Product");
		return "addProduct";
	}
	
	@RequestMapping(value = "/handle-product", method = RequestMethod.POST)
	public RedirectView createProduct(@ModelAttribute Product product, HttpServletRequest request) {
		System.out.println(product);
		productDAO.addProduct(product);
		
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/");
		return redirectView;
		
	}
	
	@RequestMapping("/delete/{productId}")
	public RedirectView deleteProduct(@PathVariable("productId") int productId, HttpServletRequest request) {
		this.productDAO.deleteProduct(productId);
		
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/");
		return redirectView;
	}
	
	@RequestMapping("/update/{productId}")
	public String updateProduct(@PathVariable("productId") int productId, Model model) {
		Product product = productDAO.getProduct(productId);
		model.addAttribute("product", product);
		model.addAttribute("title", "Update Product");
		return "updateProduct";
	}
}
