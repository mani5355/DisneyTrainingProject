package com.cg.list;
//List----ordered, double entry allowed, null entry allowed
//ArrayList-->(not synchronized-->need to check it), frequent insertion and deletion takes a lot of time,
//				useful when frequent retrieval operation is happening 
//LinkedList-->useful in frequent insertion and deletion takes a lot of time
//vector-->similar to array list, only it is synchronized
@FunctionalInterface
public interface IAdd {

	public void add(int i);
}
@FunctionalInterface
interface IView {
	 void view();
	
}
@FunctionalInterface
interface IDelete{
	void delete(int i);
}
@FunctionalInterface
interface IGetValue{
	void get(int i);
}

@FunctionalInterface
interface IGetIndex{
	void get(int i);
}

@FunctionalInterface
interface IViewEven{
	void viewEven();
}

