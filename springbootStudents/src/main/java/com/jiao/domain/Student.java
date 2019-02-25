package com.jiao.domain;

public class Student {
    private Integer id;

    private String name;

    private String sex;

    private Integer stuClass;
    
    private Class clas ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name ;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex ;
    }

	public Integer getStuClass() {
		return stuClass;
	}

	public void setStuClass(Integer stuClass) {
		this.stuClass = stuClass;
	}

	public Class getClas() {
		return clas;
	}

	public void setClas(Class clas) {
		this.clas = clas;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", sex=" + sex + ", stuClass=" + stuClass + ", clas=" + clas
				+ "]";
	}
    
}