import javax.swing.JFrame;
import javax.swing.JTextField;

import java.awt.GridLayout;

import javax.swing.JButton;

public class ViewKeyboard extends JFrame{
	


	JTextField yourInpuFieldt ;

	    public ViewKeyboard() {
			this.setVisible(true);
            this.setSize(1120, 200);
            this.setLocation(120, 330);
	    	yourInpuFieldt = new JTextField(16);
	    	yourInpuFieldt.setSize(1120, 200);
	    	yourInpuFieldt.setEditable(true);
	    	add(yourInpuFieldt);
	    }
	    public JTextField getTextField() {
	    	 return yourInpuFieldt;
	    }

	    
	    public static void main(String[] args) {
			ViewKeyboard v = new ViewKeyboard();
	
		}


}
