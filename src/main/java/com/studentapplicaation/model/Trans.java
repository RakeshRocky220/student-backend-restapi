package com.studentapplicaation.model;

import java.util.List;

public class Trans {
private List<String> list;

public List<String> getList() {
	return list;
}

public void setList(List<String> list) {
	this.list = list;
}

public Trans(List<String> list) {
	super();
	this.list = list;
}

public Trans() {
	super();
}

}
