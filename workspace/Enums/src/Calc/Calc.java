package Calc;
enum Operation{
	ADD(1),
	SUBTRACT(2),
	MULTIPLY(3),
	DIVIDE(4);
	
	int ordinal;
	Operation(int ordinal){
		this.ordinal=ordinal;
	}
	public int getOrdinal() {
		return ordinal;
	}
	public void setOrdinal(int ordinal) {
		this.ordinal = ordinal;
	}
}
public class Calc {
	private int leftOp;
	private int rightOp;
	private Operation operator;
	
	public Calc(int leftOp,int rightOp,Operation operator) {
		this.leftOp=leftOp;
		this.rightOp=rightOp;
		this.operator=operator;
	}
	public int add() {
		return leftOp+rightOp;
	}
	public Operation getOperator() {
		return operator;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Operation operator;
		Calc calc = new Calc(4,5,Operation.ADD);
		switch(calc.getOperator()) {
			case ADD:{
				System.out.println(calc.add());
				break;
			}
			case SUBTRACT:{
				System.out.println();
				break;
			}
			case MULTIPLY:{
				break;
			}
			case DIVIDE:{
				break;
			}
			default:
		}
		
	}

}
