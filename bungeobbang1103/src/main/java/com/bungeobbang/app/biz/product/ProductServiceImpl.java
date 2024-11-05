package com.bungeobbang.app.biz.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
//productService 구현체
@Service("productService")
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDAO productDAO;

	@Override
	public ArrayList<ProductDTO> selectAll(ProductDTO productDTO) {
		return (ArrayList<ProductDTO>) this.productDAO.selectAll(productDTO);
	}

	@Override
	public ProductDTO selectOne(ProductDTO productDTO) {
		
		return this.productDAO.selectOne(productDTO);
	}

	@Override
	public boolean insert(ProductDTO productDTO) {
		return this.productDAO.insert(productDTO);
	}

	@Override
	public boolean update(ProductDTO productDTO) {
		return false;
	}

	@Override
	public boolean delete(ProductDTO productDTO) {
		return false;
	}
	
}
