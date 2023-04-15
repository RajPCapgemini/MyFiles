package com.enums.bean;

enum Traffic{
	RED(1),
	YELLOW(2),
	GREEN(3);
	
	int ordinal;
	Traffic(int ordinal){
		this.ordinal=ordinal;
	}
	public void setOrdinal(int ordinal) {
		this.ordinal=ordinal;
	}
	public int getOrdinal() {
		return ordinal;
	}
}
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(Traffic tr:Traffic.values()) {
			System.out.println(tr+" :"+tr.ordinal);
		}
	}

}
