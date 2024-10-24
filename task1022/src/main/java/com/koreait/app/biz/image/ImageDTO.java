package com.koreait.app.biz.image;

import org.springframework.web.multipart.MultipartFile;

public class ImageDTO {
	private int imageID;			//이미지 고유번호
	private String imagePath;		//이미지명
	private int boardID;			//게시물 고유번호
	MultipartFile file;
	
	public int getImageID() {
		return imageID;
	}
	public void setImageID(int imageID) {
		this.imageID = imageID;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public int getBoardID() {
		return boardID;
	}
	public void setBoardID(int boardID) {
		this.boardID = boardID;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	@Override
	public String toString() {
		return "ImageDTO [imageID=" + imageID + ", imagePath=" + imagePath + ", boardID=" + boardID + ", file=" + file
				+ "]";
	}

	
	
}