
import java.awt.Font;
import java.awt.GridLayout;
import java.util.*;

import javax.swing.JButton;

import java.io.IOException;
import com.leapmotion.leap.*;
import com.leapmotion.leap.Gesture.State;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;


class leapListener2 extends Listener{
	
	String [] sentences = new String[90];
	DialogVirtualKeyboardReal dialog ;
	public boolean barista=true;
	 Robot robot ;
	public leapListener2() throws AWTException {
		
		robot = new Robot();
	    robot.setAutoDelay(5);
	    robot.setAutoWaitForIdle(true);

  		ViewKeyboard vk = new ViewKeyboard();
       vk.setVisible(true);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	  
                dialog = new DialogVirtualKeyboardReal(new javax.swing.JFrame(), true);
                dialog.setLocation(120, 530);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
             
            }
         });
        Words w = new Words(); 
   	   w.setVisible(true);
   	   


	}
	public void writeValue(java.awt.event.ActionEvent evt){

        String text =  ((JButton)evt.getSource()).getText().toString();
        System.out.print(text);
      


    }
	

	public void onInit(Controller controller) {
		System.out.println("Initialized");
	}
	
	public void onConnect(Controller controller) {
		System.out.println("Connected to motion sensor");
		controller.enableGesture(Gesture.Type.TYPE_KEY_TAP);

	}
	
	public void  onDisconnect(Controller controller) {
		System.out.println("Motion Sensor Disconnected");
	}
	
	public void onExit(Controller controller) {
		System.out.println("Exited");
	}
	@SuppressWarnings("deprecation")
	public void onFrame(Controller controller) {
		Frame frame = controller.frame();
		Scanner sc = new Scanner(System.in);

		 for(Finger finger:frame.fingers()) 
		 	{
			 if(finger.isExtended()) 
			 {
				robot.mouseMove((int)finger.tipPosition().getX()+600,(int)finger.tipPosition().getZ()+800);
			}

	 		}	

		
		GestureList gestures = frame.gestures();
		    for(int i = 0;i < gestures.count();i++) {
		    	  Gesture gesture = gestures.get(i);
		    	  switch(gesture.type()) {
		    	  case TYPE_CIRCLE :
		    		  CircleGesture circle = new CircleGesture(gesture);
		    		  
		    		  String clockwiseness;
		    		  if(circle.pointable().direction().angleTo(circle.normal())<= Math.PI/4) {
		    			  clockwiseness="clockwise";
		    		  }else {
		    			  clockwiseness="counterclockwise";
		    		  }
		    		  
		    		  double sweptAngle = 0;
		    		  if(circle.state() != State.STATE_START) {
		    			  CircleGesture previous = new CircleGesture(controller.frame(1).gesture(circle.id())) ;
		    			  sweptAngle=(circle.progress()-previous.progress())*2*Math.PI;
		    		  }
		    		  

		    		  break;
		    		  
		    	  case TYPE_SWIPE:
		    		  SwipeGesture swipe = new SwipeGesture(gesture);

		    		  
		    		  break;
		    	
		    	  case TYPE_SCREEN_TAP:
		    		  ScreenTapGesture screenTap = new ScreenTapGesture(gesture);

		    		  break;
		    		  
		    	  case TYPE_KEY_TAP:
		    		  
		    		KeyTapGesture keyTap= new KeyTapGesture(gesture);
		    		robot.mousePress(InputEvent.BUTTON1_MASK);
		            robot.mouseRelease(InputEvent.BUTTON1_MASK);
		    		Pointable finger = keyTap.pointable();

		    		  
		    		  break;
		    		  default:robot.mouseRelease(InputEvent.BUTTON1_MASK);
		    			  System.out.println("Unknown Gesture!!");
		    			  break;
		    		  
		    	  }
		    	  
		    }
		
	}

}


public class leapController2 {

	public static void main(String[] args) throws AWTException {
       leapListener2 listener = new leapListener2();
       Controller controller = new Controller();
       
       controller.addListener(listener);
       
       System.out.println("Press Enter to Quit");
       
       try {
    	   System.in.read();
       }catch(IOException e) {
    	     e.printStackTrace();
       }
       controller.removeListener(listener);
       
	} 
	


}
