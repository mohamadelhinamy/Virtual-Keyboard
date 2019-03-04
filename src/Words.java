

	import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;

	public class Words extends JFrame{
		


		JTextField yourInpuFieldt ;
		ArrayList<String> sentences; 
		int i;
		JLabel word = new JLabel();
		String[] linesArray;
		public JButton next = new JButton("next");
		    public Words() {
		    	BufferedReader in =null;
				try {
					in = new BufferedReader(new FileReader("sentences.txt"));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        String str;

		         sentences = new ArrayList<String>();
		        try {
					while((str = in.readLine()) != null){
					    sentences.add(str);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		         linesArray = sentences.toArray(new String[sentences.size()]);
		        for(int i=0;i<linesArray.length;i++) {
		     //  	System.out.println(linesArray[i]);
		        }

				this.setVisible(true);
	            this.setSize(1120, 200);
	            this.setLocation(120, 130);
                
                word.setSize(1020, 200);
word.setText(linesArray[0]);
word.setFont(word.getFont().deriveFont(18.0f));
word.setHorizontalAlignment(SwingConstants.CENTER);
word.setVerticalAlignment(SwingConstants.CENTER);
add(word);

next.setSize(100, 50);
next.setHorizontalAlignment(SwingConstants.RIGHT);
next.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
           nextActionPerformed(evt);
    }
});
add(next);
this.revalidate();
		    }
		    
		    public void nextActionPerformed(java.awt.event.ActionEvent evt) {
		      
		       if(i<linesArray.length) {
		    	   word.setText(linesArray[i]);
		       i+=1;}
		       else {
		    	   i=0;
	    	       word.setText(linesArray[i]);
	    	   }

		    } 
		    

		    

		    
		    public int lineLength(int x) {
				return linesArray[i].length();
		    	
		    }
		    public static void main(String[] args) {
		    	Words w =  new Words();
				for (int i = 0; i < 40; i++) {
					System.out.println(w.linesArray[i].length());
				}
			}


	}

