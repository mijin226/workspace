package com.koreait.app.biz.image;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// 인터페이스인 ImageService의 구현체(실현체)
@Service("imageService")
public class ImageServiceImpl implements ImageService{
	
	@Autowired
	private ImageDAO imageDAO;
	
	@Override
	public List<ImageDTO> selectAll(ImageDTO imageDTO) {
		return null;
	}
	@Override
	public ImageDTO selectOne(ImageDTO imageDTO) {
		return this.imageDAO.selectOne(imageDTO);
	}
	@Override
	public boolean insert(ImageDTO imageDTO) {
		return this.imageDAO.insert(imageDTO);
	}
	@Override
	public boolean update(ImageDTO imageDTO) {
		return this.imageDAO.update(imageDTO);
	}
	@Override
	public boolean delete(ImageDTO imageDTO) {
		return this.imageDAO.delete(imageDTO);
	}	
}

