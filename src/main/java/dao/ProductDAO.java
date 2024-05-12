package dao;

import java.util.List;

import model.Product;


public interface ProductDAO{
	
	public void addProduct(Product Product);
	public List<Product> getAllProducts();
	public Product getProduct(int pId);
	public void deleteProduct(int pId);
}