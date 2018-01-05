package com.qbt.scp.upload.service;

public interface ImageService {

	/**
	 * 销售二维码合成
	 * @param templetImageUrl
	 * @param QRCodeUrl
	 * @param localFilePath
	 * @param saleName
	 * @param saleManCode
	 */
	void composeImage(String fileName, String finalFileName, String saleName, String saleManCode);

}
