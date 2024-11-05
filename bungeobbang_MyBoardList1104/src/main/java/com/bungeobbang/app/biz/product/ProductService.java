package com.bungeobbang.app.biz.product;

import java.util.ArrayList;

public interface ProductService{
	ArrayList<ProductDTO> selectAll(ProductDTO productDTO);
	ProductDTO selectOne(ProductDTO productDTO);
	boolean insert(ProductDTO productDTO);
	boolean update(ProductDTO productDTO);
	boolean delete(ProductDTO productDTO);
}
