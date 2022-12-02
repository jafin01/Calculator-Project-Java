import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Calculator implements ActionListener {		//ActionListener interface implementation to class Calculator.
	
	boolean isOperatorClicked=false;					//to find whether operator is clicked or not.
	boolean onceOperatorClicked=false;					//to find whether operator is clicked multiple times.
	boolean equalsCondition=false;						//to give function when equals is clicked directly after entering the value.
	boolean equalsWithOperatorCondition=false;			//to give function when equals is clicked after clicking an operator
	double result=0;									//to get the result
	String oldValueStr;									//to store the old value string
	double oldValue=0;									//to store the old value double
	String newValueStr;									//to store the new value string
	double newValue=0;									//to store the new value double
	String op;											//to store the last used operator to do multiple calculation using multiple operators				
	int flag=0;											/*to identify the operator click and to avoid multiple calculation during multiple 
														  clicks in same operator*/
	
	//global declaration of frame, label and buttons.
	
	JFrame jf;
	JLabel displayLabel;
	JLabel operatorLabel;
	JButton acClear;
	JButton seven;
	JButton eight;
	JButton nine;
	JButton back;
	JButton four;
	JButton five;
	JButton six;
	JButton clear;
	JButton one;
	JButton two;
	JButton three;
	JButton singleZero;
	JButton doubleZero;
	JButton tripleZero;
	JButton dotButton;
	JButton multi;
	JButton div;
	JButton plus;
	JButton minus;
	JButton equals;
	
	public Calculator() {														//definition of constructor calculation(object created in main function)
																				//defines the design if the calculator,
		jf=new JFrame("Calculator");											//including layout, size, location, background, foreground,
		jf.setLayout(null);														//font and alignment of frame, labels and buttons.
		jf.setSize(600,570);	
		jf.setLocation(200, 70);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		displayLabel=new JLabel();												//shows user entered values and the results in R.H.S
		displayLabel.setBackground(Color.DARK_GRAY);
		displayLabel.setForeground(Color.WHITE);
		displayLabel.setOpaque(true);
		displayLabel.setFont(new Font("serif",Font.BOLD , 45));
		displayLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		displayLabel.setBounds(80, 50, 490, 70);
		jf.add(displayLabel);
		
		operatorLabel=new JLabel();												//shows operators clicked in L.H.S
		operatorLabel.setBackground(Color.DARK_GRAY);
		operatorLabel.setForeground(Color.CYAN);
		operatorLabel.setOpaque(true);
		operatorLabel.setFont(new Font("serif", Font.BOLD, 20));
		operatorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		operatorLabel.setBounds(20, 50, 80, 70);
		jf.add(operatorLabel);
		
		acClear=new JButton("AC");												//clears every values and sets 0 in the displayLabel. 
		acClear.setBounds(20, 160, 65, 65);										//helps to start over new calculations from beginning.
		acClear.setFont(new Font("tahoma",Font.BOLD, 23));
		acClear.setBackground(Color.BLACK);
		acClear.setForeground(Color.RED);
		acClear.addActionListener(this);
		jf.add(acClear);
		
		seven=new JButton("7");
		seven.setBounds(115, 160, 65, 65);
		seven.setFont(new Font("tahoma",Font.BOLD, 32));
		seven.setBackground(Color.DARK_GRAY);
		seven.setForeground(Color.WHITE);
		seven.addActionListener(this);
		jf.add(seven);
		
		eight=new JButton("8");
		eight.setBounds(210, 160, 65, 65);
		eight.setFont(new Font("tahoma", Font.BOLD, 32));
		eight.setBackground(Color.DARK_GRAY);
		eight.setForeground(Color.WHITE);
		eight.addActionListener(this);
		jf.add(eight);
		
		nine=new JButton("9");
		nine.setBounds(305, 160, 65, 65);
		nine.setFont(new Font("tahoma", Font.BOLD, 32));
		nine.setBackground(Color.DARK_GRAY);
		nine.setForeground(Color.WHITE);
		nine.addActionListener(this);
		jf.add(nine);
		
		back=new JButton("<<");													//to go one string back if clicked incorrect button.
		back.setBounds(20, 255, 65, 65);
		back.setFont(new Font("tahoma", Font.BOLD, 18));
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.addActionListener(this);
		jf.add(back);
		
		four=new JButton("4");
		four.setBounds(115, 255, 65, 65);
		four.setFont(new Font("tahoma", Font.BOLD, 32));
		four.setBackground(Color.DARK_GRAY);
		four.setForeground(Color.WHITE);
		four.addActionListener(this);
		jf.add(four);
		
		five=new JButton("5");
		five.setBounds(210, 255, 65, 65);
		five.setFont(new Font("tahoma", Font.BOLD, 32));
		five.setBackground(Color.DARK_GRAY);
		five.setForeground(Color.WHITE);
		five.addActionListener(this);
		jf.add(five);
		
		six=new JButton("6");
		six.setBounds(305, 255, 65, 65);
		six.setFont(new Font("tahoma", Font.BOLD, 32));
		six.setBackground(Color.DARK_GRAY);
		six.setForeground(Color.WHITE);
		six.addActionListener(this);
		jf.add(six);
		
		clear=new JButton("C");													//clears last set of values after an operation is clicked.
		clear.setBounds(20, 350, 65, 65);
		clear.setFont(new Font("tahoma", Font.BOLD, 32));
		clear.setBackground(Color.RED);
		clear.setForeground(Color.WHITE);
		clear.addActionListener(this);
		jf.add(clear);
		
		one=new JButton("1");
		one.setBounds(115, 350, 65, 65);
		one.setFont(new Font("tahoma", Font.BOLD, 32));
		one.setBackground(Color.DARK_GRAY);
		one.setForeground(Color.WHITE);
		one.addActionListener(this);
		jf.add(one);
		
		two=new JButton("2");
		two.setBounds(210, 350, 65, 65);
		two.setFont(new Font("tahoma", Font.BOLD, 32));
		two.setBackground(Color.DARK_GRAY);
		two.setForeground(Color.WHITE);
		two.addActionListener(this);
		jf.add(two);
		
		three=new JButton("3");
		three.setBounds(305, 350, 65, 65);
		three.setFont(new Font("tahoma", Font.BOLD, 32));
		three.setBackground(Color.DARK_GRAY);
		three.setForeground(Color.WHITE);
		three.addActionListener(this);
		jf.add(three);
		
		singleZero=new JButton("0");
		singleZero.setBounds(20, 445, 65, 65);
		singleZero.setFont(new Font("serif",Font.BOLD, 32));
		singleZero.setBackground(Color.DARK_GRAY);
		singleZero.setForeground(Color.WHITE);
		singleZero.addActionListener(this);
		jf.add(singleZero);
		
		doubleZero=new JButton("00");
		doubleZero.setBounds(115, 445, 65, 65);
		doubleZero.setFont(new Font("serif", Font.BOLD, 30));
		doubleZero.setBackground(Color.DARK_GRAY);
		doubleZero.setForeground(Color.WHITE);
		doubleZero.addActionListener(this);
		jf.add(doubleZero);
		
		tripleZero=new JButton("000");
		tripleZero.setBounds(210, 445, 65, 65);
		tripleZero.setFont(new Font("serif", Font.BOLD, 20));
		tripleZero.setBackground(Color.DARK_GRAY);
		tripleZero.setForeground(Color.WHITE);
		tripleZero.addActionListener(this);
		jf.add(tripleZero);
		
		dotButton=new JButton(".");												//to calculate decimal numbers.
		dotButton.setBounds(305, 445, 65, 65);
		dotButton.setFont(new Font("serif",Font.BOLD, 35));
		dotButton.setBackground(Color.DARK_GRAY);
		dotButton.setForeground(Color.WHITE);
		dotButton.addActionListener(this);
		jf.add(dotButton);
		
		
		
		
		multi=new JButton("x");													//for multiplication.
		multi.setBounds(410, 255, 65, 65);
		multi.setFont(new Font(null, Font.BOLD, 40));
		multi.setBackground(Color.BLACK);
		multi.setForeground(Color.WHITE);
		multi.addActionListener(this);
		jf.add(multi);
		
		div=new JButton("/");													//for division.
		div.setBounds(500, 255, 65, 65);
		div.setFont(new Font(null, Font.BOLD, 40));
		div.setBackground(Color.BLACK);
		div.setForeground(Color.WHITE);
		div.addActionListener(this);
		jf.add(div);
		
		minus=new JButton("-");													//for subtraction.
		minus.setBounds(500, 350, 65, 65);
		minus.setFont(new Font(null, Font.BOLD, 40));
		minus.setBackground(Color.BLACK);
		minus.setForeground(Color.WHITE);
		minus.addActionListener(this);
		jf.add(minus);
		
		plus=new JButton("+");													//for addition.
		plus.setBounds(410, 350, 65, 160);
		plus.setFont(new Font(null, Font.BOLD, 40));
		plus.setBackground(Color.BLACK);
		plus.setForeground(Color.WHITE);
		plus.addActionListener(this);
		jf.add(plus);
		
		equals=new JButton("=");												//to get result.
		equals.setBounds(500, 445, 65, 65);
		equals.setFont(new Font(null, Font.BOLD, 40));
		equals.setBackground(Color.BLACK);
		equals.setForeground(Color.WHITE);
		equals.addActionListener(this);
		jf.add(equals);
		
	}
	
	public static void main(String ar[]) {									//main function
		new Calculator();													//creates an object of calculator.
	}	

	@Override
	public void actionPerformed(ActionEvent e) {							//function that executes according to the action performed by the user.
	
		
		if(e.getSource()==singleZero) {										
			
			if(isOperatorClicked) {	
				
				if(displayLabel.getText()=="") {
					
					displayLabel.setText("0");
					onceOperatorClicked=true;
					flag=0;
					
				}else if(displayLabel.getText()=="0"){
					
					displayLabel.setText("0");
					onceOperatorClicked=true;
					flag=0;
					
				}else {
					
					displayLabel.setText("0");
					onceOperatorClicked=true;
					flag=0;
				}
				
			}else {
			
				if(displayLabel.getText()=="") {
					displayLabel.setText("0");
				
				}else if(displayLabel.getText()=="0"){
					displayLabel.setText("0");
				
				}else {
					displayLabel.setText(displayLabel.getText()+"0");
				}
			}
			
		}else if(e.getSource()==doubleZero) {
			
			if(isOperatorClicked) {
				
				if(displayLabel.getText()=="0") {
					
					displayLabel.setText("0");
					onceOperatorClicked=true;
					flag=0;
					
				}else if(displayLabel.getText()==""){
					
					displayLabel.setText("0");
					onceOperatorClicked=true;
					flag=0;
				
				}else {
					
					displayLabel.setText("0");
					onceOperatorClicked=true;
					flag=0;
				}
				
			}else {
				
				if(displayLabel.getText()=="0") {
					displayLabel.setText("0");
					
				}else if(displayLabel.getText()==""){
					displayLabel.setText("0");
				
				}else {
					displayLabel.setText(displayLabel.getText()+"00");
				}
			}
			
		}else if(e.getSource()==tripleZero) {
			
			if(isOperatorClicked) {
				
				if(displayLabel.getText()=="") {
					
					displayLabel.setText("0");
					onceOperatorClicked=true;
					flag=0;
					
				}else if(displayLabel.getText()=="0") {
					
					displayLabel.setText("0");
					onceOperatorClicked=true;
					flag=0;
					
				}else {
					
					displayLabel.setText("0");
					onceOperatorClicked=true;
					flag=0;
				}
			}else {
				
				if(displayLabel.getText()=="") {
					displayLabel.setText("0");
				
				}else if(displayLabel.getText()=="0") {
					displayLabel.setText("0");
				
				}else {
					displayLabel.setText(displayLabel.getText()+"000");
				}
			}
			
		}else if(e.getSource()==dotButton){
			
			if(isOperatorClicked) {
				
				displayLabel.setText("0.");	
				isOperatorClicked=false;
				onceOperatorClicked=true;
				flag=0;
				
			}else {
				
				if(displayLabel.getText()=="") {
					displayLabel.setText("0.");
					
				}else {
					displayLabel.setText(displayLabel.getText()+".");
				}
			}
			
		}else if(e.getSource()==one) {
			
			if(isOperatorClicked) {
				
				if(displayLabel.getText()=="0") {
					
					displayLabel.setText("1");
					isOperatorClicked=false;
					onceOperatorClicked=true;
					flag=0;
					
				}else {
					
					displayLabel.setText("1");
					isOperatorClicked=false;
					onceOperatorClicked=true;
					flag=0;
				}
				
			}else {
				
				if(displayLabel.getText()=="0") {
					displayLabel.setText("1");
					
				}else {
					displayLabel.setText(displayLabel.getText()+"1");
				}
			}
			
		}else if(e.getSource()==two) {
			
			if(isOperatorClicked) {
				
				if(displayLabel.getText()=="0") {
					
					displayLabel.setText("2");
					isOperatorClicked=false;
					onceOperatorClicked=true;
					flag=0;
					
				}else {
					
					displayLabel.setText("2");
					isOperatorClicked=false;
					onceOperatorClicked=true;
					flag=0;
				}
				
			}else{
				
				if(displayLabel.getText()=="0") {
					displayLabel.setText("2");
					
				}else {
					displayLabel.setText(displayLabel.getText()+"2");
				}
			}
			
		}else if(e.getSource()==three) {
			
			if(isOperatorClicked) {
				
				if(displayLabel.getText()=="0") {
					
					displayLabel.setText("3");
					isOperatorClicked=false;
					onceOperatorClicked=true;
					flag=0;
				
				}else {
					
					displayLabel.setText("3");
					isOperatorClicked=false;
					onceOperatorClicked=true;
					flag=0;
				}
					
			}else {
				
				if(displayLabel.getText()=="0") {
					displayLabel.setText("3");
				
				}else {
					displayLabel.setText(displayLabel.getText()+"3");
				}
			}
			
		}else if(e.getSource()==four) {
			
			if(isOperatorClicked) {
				
				if(displayLabel.getText()=="0") {
					
					displayLabel.setText("4");
					isOperatorClicked=false;
					onceOperatorClicked=true;
					flag=0;
				
				}else {
					
					displayLabel.setText("4");
					isOperatorClicked=false;
					onceOperatorClicked=true;
					flag=0;
				}
				
			}else {
				
				if(displayLabel.getText()=="0") {
					displayLabel.setText("4");
				
				}else {
					displayLabel.setText(displayLabel.getText()+"4");
				}
			}
			
		}else if(e.getSource()==five) {
			
			if(isOperatorClicked) {
				
				if(displayLabel.getText()=="0") {
					
					displayLabel.setText("5");
					isOperatorClicked=false;
					onceOperatorClicked=true;
					flag=0;
				
				}else {
					
					displayLabel.setText("5");
					isOperatorClicked=false;
					onceOperatorClicked=true;
					flag=0;
				}
				
			}else {
				
				if(displayLabel.getText()=="0") {
					displayLabel.setText("5");
				
				}else {
					displayLabel.setText(displayLabel.getText()+"5");
				}
			}
			
		}else if(e.getSource()==six) {
			
			if(isOperatorClicked) {
				
				if(displayLabel.getText()=="0") {
					
					displayLabel.setText("6");
					isOperatorClicked=false;
					onceOperatorClicked=true;
					flag=0;
				
				}else {
					
					displayLabel.setText("6");
					isOperatorClicked=false;
					onceOperatorClicked=true;
					flag=0;
				}
				
			}else {
				
				if(displayLabel.getText()=="0") {
					displayLabel.setText("6");
				
				}else {
					displayLabel.setText(displayLabel.getText()+"6");
				}
			}
			
		}else if(e.getSource()==seven) {
			
			if(isOperatorClicked) {
				
				if(displayLabel.getText()=="0") {
					
					displayLabel.setText("7");
					isOperatorClicked=false;
					onceOperatorClicked=true;
					flag=0;
				
				}else {
					
					displayLabel.setText("7");
					isOperatorClicked=false;
					onceOperatorClicked=true;
					flag=0;
				}
				
			}else {
				
				if(displayLabel.getText()=="0") {
					displayLabel.setText("7");
				
				}else {
					displayLabel.setText(displayLabel.getText()+"7");
				}
			}
			
		}else if(e.getSource()==eight) {
			
			if(isOperatorClicked) {
				
				if(displayLabel.getText()=="0") {
					
					displayLabel.setText("8");
					isOperatorClicked=false;
					onceOperatorClicked=true;
					flag=0;
				
				}else {
					
					displayLabel.setText("8");
					isOperatorClicked=false;
					onceOperatorClicked=true;
					flag=0;
				}
				
			}else {
				
				if(displayLabel.getText()=="0") {
					displayLabel.setText("8");
				
				}else {
					displayLabel.setText(displayLabel.getText()+"8");
				}
			}
			
		}else if(e.getSource()==nine) {
			
			if(isOperatorClicked) {
				
				if(displayLabel.getText()=="0") {
					
					displayLabel.setText("9");
					isOperatorClicked=false;
					onceOperatorClicked=true;
					flag=0;
				
				}else {
					
					displayLabel.setText("9");
					isOperatorClicked=false;
					onceOperatorClicked=true;
					flag=0;
				}
				
			}else {
				
				if(displayLabel.getText()=="0") {
					displayLabel.setText("9");
				
				}else {
					displayLabel.setText(displayLabel.getText()+"9");
				}
			}
			
		}else if(e.getSource()==acClear) {
			
			operatorLabel.setText("ON");
			oldValue=0;
			newValue=0;
			result=0;
			flag=0;
			isOperatorClicked=false;
			onceOperatorClicked=false;
			equalsCondition=false;
			equalsWithOperatorCondition=false;
			displayLabel.setText("0");
			
		}else if(e.getSource()==back) {
			
			operatorLabel.setText("<<");
			
			if(displayLabel.getText().length()>0) {
				displayLabel.setText(displayLabel.getText().substring(0, displayLabel.getText().length()-1));
				
			}else if(displayLabel.getText().length()==0){
				displayLabel.setText("0");
			}
			
		}else if(e.getSource()==plus) {
			
			isOperatorClicked=true;
			operatorLabel.setText("+");
			
			if(onceOperatorClicked==false) {
				
				oldValueStr=displayLabel.getText();
				oldValue=Double.parseDouble(oldValueStr);
				op="+";
				equalsCondition=false;
				equalsWithOperatorCondition=false;
				
			}else {
				
				if(flag==1) {
					op="+";
					
				}else {
					newValueStr=displayLabel.getText();
					newValue=Double.parseDouble(newValueStr);
					operations();
					op="+";
					flag=1;
				}
			}
			
		}else if(e.getSource()==minus) {
			
			isOperatorClicked=true;
			operatorLabel.setText("-");
			
			if(onceOperatorClicked==false) {
				
				oldValueStr=displayLabel.getText();
				oldValue=Double.parseDouble(oldValueStr);
				op="-";
				equalsCondition=false;
				equalsWithOperatorCondition=false;
				
			}else {
				
				if(flag==1) {
					op="-";
					
				}else {
					
					newValueStr=displayLabel.getText();
					newValue=Double.parseDouble(newValueStr);
					operations();
					op="-";
					flag=1;
				}
			}
			
		}else if(e.getSource()==multi) {
			
			isOperatorClicked=true;
			operatorLabel.setText("X");
			
			if(onceOperatorClicked==false) {
				
				oldValueStr=displayLabel.getText();
				oldValue=Double.parseDouble(oldValueStr);
				op="x";
				equalsCondition=false;
				equalsWithOperatorCondition=false;
				
			}else {
				
				if(flag==1) {
					op="x";
					
				}else {
					
					newValueStr=displayLabel.getText();
					newValue=Double.parseDouble(newValueStr);
					operations();
					op="x";
					flag=1;
				}
			}
			
		}else if(e.getSource()==div) {
			
			isOperatorClicked=true;
			operatorLabel.setText("/");
			
			if(onceOperatorClicked==false) {
				
				oldValueStr=displayLabel.getText();
				oldValue=Double.parseDouble(oldValueStr);
				op="/";
				equalsCondition=false;
				equalsWithOperatorCondition=false;
				
			}else {
				
				if(flag==1) {
					op="/";
					
				}else {
					
					newValueStr=displayLabel.getText();
					newValue=Double.parseDouble(newValueStr);
					operations();
					op="/";
					flag=1;
				}
			}
			
		}else if(e.getSource()==equals) {
			
			operatorLabel.setText("=");
			
			if(equalsWithOperatorCondition==false) {
				
				if(flag==1) {
					
					displayLabel.setText(result+"");
					flag=0;
					equalsWithOperatorCondition=true;
					onceOperatorClicked=false;
					
				}else {
					
					newValueStr=displayLabel.getText();
					newValue=Double.parseDouble(newValueStr);
					operations();
					onceOperatorClicked=false;
					equalsCondition=true;
					equalsWithOperatorCondition=true;
				}
				
			}else {
				
				if(equalsCondition) {
					equalcondition();
					
				}else {
					equalWithOperatorCondition();
				}
			}
			
		}else if(e.getSource()==clear) {
				
			operatorLabel.setText("C");
			
			if(isOperatorClicked) {
				
				displayLabel.setText("0");
				isOperatorClicked=false;
				onceOperatorClicked=true;
				
			}else {
				
				displayLabel.setText("0");
			}
		}
	}
	
	public void operations() {
		
		if(op=="+") {
			
			result=oldValue+newValue;
			oldValue=result;
			displayLabel.setText(result+"");
			
		}else if(op=="-") {
			
			result=oldValue-newValue;
			oldValue=result;
			displayLabel.setText(result+"");
			
		}else if(op=="x") {
			
			result=oldValue*newValue;
			oldValue=result;
			displayLabel.setText(result+"");
			
		}else if(op=="/") {
			
			result=oldValue/newValue;
			oldValue=result;
			displayLabel.setText(result+"");
		}
	}
	
	public void equalcondition() {
		
		if(op=="+") {
			
			result=result+newValue;
			displayLabel.setText(result+"");
			onceOperatorClicked=false;
			
		}else if(op=="-") {
			
			result=result-newValue;
			displayLabel.setText(result+"");
			onceOperatorClicked=false;
			
		}else if(op=="x") {
			
			result=result*newValue;
			displayLabel.setText(result+"");
			onceOperatorClicked=false;
			
		}else if(op=="/") {
			
			result=result/newValue;
			displayLabel.setText(result+"");
			onceOperatorClicked=false;
		}
	}
	
	
	public void equalWithOperatorCondition() {
		
		if(op=="+") {
			
			result=result+oldValue;
			displayLabel.setText(result+"");
			onceOperatorClicked=false;
			
		}else if(op=="-") {
			
			result=result-oldValue;
			displayLabel.setText(result+"");
			onceOperatorClicked=false;
			
		}else if(op=="x") {
			
			result=result*oldValue;
			displayLabel.setText(result+"");
			onceOperatorClicked=false;
			
		}else if(op=="/") {
			
			result=result/oldValue;
			displayLabel.setText(result+"");
			onceOperatorClicked=false;
		}
		
	}
	
}

























