package org.bedoing.blog.po;

/**
 * 
 * @author ken
 *
 */
public class Subject extends BasePO {

	private int subjectId;
	private int articleId;
	private int difficulty;
	private int timeLimit;
	private int memoryLimit;
	private String otherLimit;
	
	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	public int getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}
	public int getTimeLimit() {
		return timeLimit;
	}
	public void setTimeLimit(int timeLimit) {
		this.timeLimit = timeLimit;
	}
	public int getMemoryLimit() {
		return memoryLimit;
	}
	public void setMemoryLimit(int memoryLimit) {
		this.memoryLimit = memoryLimit;
	}
	public String getOtherLimit() {
		return otherLimit;
	}
	public void setOtherLimit(String otherLimit) {
		this.otherLimit = otherLimit;
	}

	
}
