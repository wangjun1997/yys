package cn.wangjun.yys.entity;

public class Liuyan {
	private Integer id;
	private String content;
	private String name;
	private String date;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Liuyan [id=" + id + ", content=" + content + ", name=" + name + ", date=" + date + "]";
	}
	
	
}
