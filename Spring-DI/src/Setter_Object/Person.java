package Setter_Object;
//调用
public class Person {

	private Animals name;

	public void setName(Animals name) {
		this.name = name;
	}

	@Override
	public String toString() {
		
		return "Person [name=" + name + "]";
	}
	
}
