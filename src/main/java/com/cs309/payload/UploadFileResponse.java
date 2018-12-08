package com.cs309.payload;

public class UploadFileResponse {
	private String fileName;
	private String fileDownloadUri;
	private String fileType;
	private long size;

	public UploadFileResponse(String fileName, String fileDownloadUri, String fileType, long size) {
		this.fileName = fileName;
		this.fileDownloadUri = fileDownloadUri;
		this.fileType = fileType;
		this.size = size;
	}

	public void setFileName(String name) {
		fileName = name;
	}
	
	public String getFileName() {
		return this.fileName;
	}
	
	public void setFileDownloadUri (String var) {
		fileDownloadUri = var;
	}
	
	public String getFileDownloadUri() {
		return this.fileDownloadUri;
	}
	
	public void setFileType(String type) {
		fileType = type;
	}
	
	public String getFileType() {
		return this.fileType;
	}
	
	public void setSize(long fileSize) {
		size = fileSize;
	}
	
	public long getFileSize() {
		return this.size;
	}
}
