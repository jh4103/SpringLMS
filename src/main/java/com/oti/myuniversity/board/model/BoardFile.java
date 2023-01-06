package com.oti.myuniversity.board.model;

public class BoardFile {
	private int boardFileId;
	private String boardFileName;
	private long boardFileSize;
	private byte[] boardFileData;
	private String boardFileContentType;
	
	public int getBoardFileId() {
		return boardFileId;
	}
	public void setBoardFileId(int boardFileId) {
		this.boardFileId = boardFileId;
	}
	public String getBoardFileName() {
		return boardFileName;
	}
	public void setBoardFileName(String boardFileName) {
		this.boardFileName = boardFileName;
	}
	public long getBoardFileSize() {
		return boardFileSize;
	}
	public void setBoardFileSize(long boardFileSize) {
		this.boardFileSize = boardFileSize;
	}
	public byte[] getBoardFileData() {
		return boardFileData;
	}
	public void setBoardFileData(byte[] boardFileData) {
		this.boardFileData = boardFileData;
	}
	public String getBoardFileContentType() {
		return boardFileContentType;
	}
	public void setBoardFileContentType(String boardFileContentType) {
		this.boardFileContentType = boardFileContentType;
	}
	
	
	@Override
	public String toString() {
		return "BoardFile [boardFileId=" + boardFileId + ", boardFileName=" + boardFileName + ", boardFileSize="
				+ boardFileSize + ", boardFileContentType=" + boardFileContentType + ", boardId="  + "]";
	}
	
}
