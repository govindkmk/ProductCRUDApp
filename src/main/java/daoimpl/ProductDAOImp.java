package daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import dao.ProductDAO;
import model.Product;

@Component
public class ProductDAOImp implements ProductDAO{

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Transactional
	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		
		this.hibernateTemplate.saveOrUpdate(product);
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		
		List<Product> products = this.hibernateTemplate.loadAll(Product.class);
		return products;
	}
	@Override
	public Product getProduct(int pId) {
		// TODO Auto-generated method stub
	
		return this.hibernateTemplate.get(Product.class, pId);
	}

	@Transactional
	public void deleteProduct(int pId) {
		// TODO Auto-generated method stub
		
		Product product = this.hibernateTemplate.load(Product.class, pId);
		this.hibernateTemplate.delete(product);
	}

}
