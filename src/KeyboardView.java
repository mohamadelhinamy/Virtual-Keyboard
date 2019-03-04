import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;


public class KeyboardView extends JFrame {

   // all key but BSP
   String qwerty = "QWERTYUIOPASDFGHJKL ZXCVBNM ";
   JTextField field;
   
  
  public  class MyButton extends JButton implements ActionListener {

	    // constructor
	    MyButton(String name) {
	       super(name);
	       addActionListener(this);
	    }
	    // button was hit
	    public void actionPerformed(ActionEvent e) {
	      field.getText().concat(getText());    // append to field my label
	    }
	  }

	 public  class BSPButton extends JButton implements ActionListener {

	     BSPButton() {
	       super("BSP");
	       addActionListener(this);
	     }
	     public void actionPerformed(ActionEvent e) {
	       String text = field.getText();
	       if(text.length() == 0) 
	          return;
	       field.setText(text.substring(text.length() - 1));
	     }
	   }
   KeyboardView() {
      super("Keyboard");
  //    .... set layout

      // create TextField
      field = new JTextField(80);

      // create buttons
//      for(int i = 0; i < qwerty.length(); i++) {
//          String label = "" + qwerty.charAt(i);
//          add(new MyButton(label));
//      }

      


   } 

   public static void main(String[] args) {
	   KeyboardView k = new KeyboardView();
	   k.setVisible(true);
	   k.setLayout(new GridLayout(3,1));
	    MyButton A,B,C,D,E,F,G,H,I,J,K,none,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z ;
	   Q = k.new MyButton( "Q" );
	   k.add(Q);
	   W = k.new MyButton( "W" );
	   k.add(W);
	   E = k.new MyButton( "E" );
	   k.add(E);
	   R = k.new MyButton( "R" );
	   k.add(R);
	   T = k.new MyButton( "T" );
	   k.add(T);
	   Y = k.new MyButton( "Y" );
	   k.add(Y);
	   U = k.new MyButton( "U" );
	   k.add(U);
	   I = k.new MyButton( "I" );
	   k.add(I);
	   O = k.new MyButton( "O" );
	   k.add(O);
	   P = k.new MyButton( "P" );
	   k.add(P);

	   //MyButton Caps = new MyButton ( "Caps ");
	   //add(Caps);
	   A = k.new MyButton( "A" );
	   k.add(A);
	   S = k.new MyButton( "S" );
	   k.add(S);
	   D = k.new MyButton( "D" );
	   k.add(D);
	   F = k.new MyButton( "F" );
	   k.add(F);
	   G = k.new MyButton( "G" );
	   k.add(G);
	   H = k.new MyButton( "H" );
	   k.add(H);
	   J = k.new MyButton( "J" );
	   k.add(J);
	   K = k.new MyButton( "K" );
	   k.add(K);
	   L = k.new MyButton( "L" );
	   k.add(L);


//	   Shift = new MyButton ( "Shift" );
//	   add(Shift);
	   Z = k.new MyButton( "Z" );
	   k.add(Z);
	   X = k.new MyButton( "X" );
	   k.add(X);
	   C = k.new MyButton( "C" );
	   k.add(C);
	   V = k.new MyButton( "V" );
	   k.add(V);
	   B = k.new MyButton( "B" );
	   k.add(B);
	   N = k.new MyButton( "N" );
	   k.add(N);
	   M = k.new MyButton( "M" );
	   k.add(M);
	      k.add(k.new BSPButton());


  
   }
}
  // end class TypingTutorTest