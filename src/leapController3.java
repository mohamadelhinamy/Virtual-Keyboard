import java.awt.Font;
import java.awt.GridLayout;
import java.util.*;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import com.leapmotion.leap.*;
import com.leapmotion.leap.Gesture.State;
import com.leapmotion.leap.Vector;



class leapListener3 extends Listener{
	
	String [] sentences = new String[90];
	DialogVirtualKeyboardReal dialog ;
	public int errors;
	public int id;
	String sentence;
	long elapsedTime;
	PrintWriter writer;
	Words w;
	int i = 0;
	ViewKeyboard vk;
	stopWatch sw ;
	JFrame j;
	JFrame error;
	public leapListener3() {
		elapsedTime=0;
		id= (int) (Math.random()*1000);
		errors=10;
		sentence="";
  		vk = new ViewKeyboard();
       vk.setVisible(true);
       vk.yourInpuFieldt.setFont(vk.yourInpuFieldt.getFont().deriveFont(18.0f));
       vk.yourInpuFieldt.setHorizontalAlignment(SwingConstants.CENTER);
       sw = new stopWatch();
       sw.start();
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
        w = new Words(); 
        w.word.setText(w.linesArray[i]);
   	   w.setVisible(true);
   	 j  = new JFrame();
	     JLabel l = new JLabel("Rest for 5 minutes");
	     l.setText("Rest for 5 minutes");
	     l.setFont(l.getFont().deriveFont(18.0f));
	     l.setHorizontalAlignment(SwingConstants.CENTER);
	     l.setVerticalAlignment(SwingConstants.CENTER);
	     j.add(l);
	     j.setSize(200, 200);
	     j.setVisible(false);
         j.setLocation(700, 400);

error = new JFrame();
JLabel errorlabel = new JLabel("sentence is wrong check your spelling and extra spaces.");
errorlabel.setFont(l.getFont().deriveFont(18.0f));
errorlabel.setHorizontalAlignment(SwingConstants.CENTER);
errorlabel.setVerticalAlignment(SwingConstants.CENTER);
error.add(errorlabel);
error.setSize(600, 200);
error.setVisible(false);
error.setLocation(500, 300);
	}

	public void onInit(Controller controller) {
		try {
			writer = new PrintWriter(String.valueOf(id)+".txt", "UTF-8");
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Initialized");
	}
	
	public void onConnect(Controller controller) {
		System.out.println("Connected to motion sensor");
		
	}
	
	public void  onDisconnect(Controller controller) {
		System.out.println("Motion Sensor Disconnected");
	}
	
	public void onExit(Controller controller) {
		writer.close();
		System.out.println("Exited");
	}
	public void onFrame(Controller controller) {
		Frame frame = controller.frame();
		Scanner sc = new Scanner(System.in);
		 for(Finger finger:frame.fingers()) {
		if(finger.tipPosition().getZ()>=-117 && finger.tipPosition().getZ()<=-106)	{	    		  
  		  if(finger.tipPosition().getY()>=115 && finger.tipPosition().getY()<=130) {
          	    if(finger.tipPosition().getX()>=-105 && finger.tipPosition().getX()<=-95  ) {
            		  dialog.panelVirtualKeyboard.getjBR2B2().doClick();
          	    	  System.out.print("q");
          	    	  sentence+="q";
         			 try {
         				TimeUnit.MILLISECONDS.sleep(150);
         			} catch (InterruptedException e) {
         				// TODO Auto-generated catch block
         				e.printStackTrace();
         			}
          	    }else if(finger.tipPosition().getX()>=-81 && finger.tipPosition().getX()<=-71) {
            		  dialog.panelVirtualKeyboard.jBR2B3.doClick();
          	    	System.out.print("w");
          	    	sentence+="w";
       			 try {
     				TimeUnit.MILLISECONDS.sleep(150);
     			} catch (InterruptedException e) {
     				// TODO Auto-generated catch block
     				e.printStackTrace();
     			}
          	    }else if(finger.tipPosition().getX()>=-56 && finger.tipPosition().getX()<=-46) {
              		  dialog.panelVirtualKeyboard.jBR2B4.doClick();
              		  System.out.print("e");
              		sentence+="e";
       			 try {
     				TimeUnit.MILLISECONDS.sleep(150);
     			} catch (InterruptedException e) {
     				// TODO Auto-generated catch block
     				e.printStackTrace();
     			}
          	    }else if(finger.tipPosition().getX()>=-31 && finger.tipPosition().getX()<=-21) {
              		  dialog.panelVirtualKeyboard.jBR2B5.doClick();
          	    	      System.out.print("r");
          	    	    sentence+="r";
          				 try {
          					TimeUnit.MILLISECONDS.sleep(150);
          				} catch (InterruptedException e) {
          					// TODO Auto-generated catch block
          					e.printStackTrace();
          				}
          	    }else if(finger.tipPosition().getX()>=-7 && finger.tipPosition().getX()<=2) {
              		  dialog.panelVirtualKeyboard.jBR2B6.doClick();
          	         	System.out.print("t");
          	         	sentence+="t";
          				 try {
          					TimeUnit.MILLISECONDS.sleep(150);
          				} catch (InterruptedException e) {
          					// TODO Auto-generated catch block
          					e.printStackTrace();
          				}
          	    }else if(finger.tipPosition().getX()>=16 && finger.tipPosition().getX()<=26) {
              		  dialog.panelVirtualKeyboard.jBR2B7.doClick();
          	    	System.out.print("y");
          	    	sentence+="y";
       			 try {
     				TimeUnit.MILLISECONDS.sleep(150);
     			} catch (InterruptedException e) {
     				// TODO Auto-generated catch block
     				e.printStackTrace();
     			}
          	    }else if(finger.tipPosition().getX()>=41 && finger.tipPosition().getX()<=53) {
              		  dialog.panelVirtualKeyboard.jBR2B8.doClick();

          	    	System.out.print("u");
          	    	sentence+="u";
       			 try {
     				TimeUnit.MILLISECONDS.sleep(150);
     			} catch (InterruptedException e) {
     				// TODO Auto-generated catch block
     				e.printStackTrace();
     			}
          	    }else if(finger.tipPosition().getX()>=60 && finger.tipPosition().getX()<=73) {
              		  dialog.panelVirtualKeyboard.jBR2B9.doClick();

          	    	System.out.print("i");
          	    	sentence+="i";
       			 try {
     				TimeUnit.MILLISECONDS.sleep(150);
     			} catch (InterruptedException e) {
     				// TODO Auto-generated catch block
     				e.printStackTrace();
     			}
          	    }else if(finger.tipPosition().getX()>=90 && finger.tipPosition().getX()<=100) {
              		  dialog.panelVirtualKeyboard.jBR2B10.doClick();

          	    	System.out.print("o");
          	    	sentence+="o";
       			 try {
     				TimeUnit.MILLISECONDS.sleep(150);
     			} catch (InterruptedException e) {
     				// TODO Auto-generated catch block
     				e.printStackTrace();
     			}
          	    }else if(finger.tipPosition().getX()>=111 && finger.tipPosition().getX()<=125) {
              		  dialog.panelVirtualKeyboard.jBR2B11.doClick();

          	    	System.out.print("p");
          	    	sentence+="p";
       			 try {
     				TimeUnit.MILLISECONDS.sleep(150);
     			} catch (InterruptedException e) {
     				// TODO Auto-generated catch block
     				e.printStackTrace();
     			}
          	    }
        else {
          	    	
          	    }
          	    
            }
  		  }else if(finger.tipPosition().getZ()>=-106 && finger.tipPosition().getZ()<=-100) {
		 if(finger.tipPosition().getY()>=98 && finger.tipPosition().getY()<=113) {
          	  if(finger.tipPosition().getX()>=-105 && finger.tipPosition().getX()<=-91  ) {
            		  dialog.panelVirtualKeyboard.jBR3B2.doClick();

      	    	  System.out.print("a");
      	    	sentence+="a";
   			 try {
 				TimeUnit.MILLISECONDS.sleep(150);
 			} catch (InterruptedException e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			}
      	    }else if(finger.tipPosition().getX()>=-80 && finger.tipPosition().getX()<=-64) {
          		  dialog.panelVirtualKeyboard.jBR3B3.doClick();

      	    	System.out.print("s");
      	    	sentence+="s";
   			 try {
 				TimeUnit.MILLISECONDS.sleep(150);
 			} catch (InterruptedException e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			}
      	    }else if(finger.tipPosition().getX()>=-45 && finger.tipPosition().getX()<=-35) {
        		  dialog.panelVirtualKeyboard.jBR3B4.doClick();

      	    	System.out.print("d");
      	    	sentence+="d";
   			 try {
 				TimeUnit.MILLISECONDS.sleep(150);
 			} catch (InterruptedException e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			}
      	    }else if(finger.tipPosition().getX()>=-25 && finger.tipPosition().getX()<=-15) {
        		  dialog.panelVirtualKeyboard.jBR3B5.doClick();

      	    	System.out.print("f");
      	    	sentence+="f";
   			 try {
 				TimeUnit.MILLISECONDS.sleep(150);
 			} catch (InterruptedException e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			}
      	    }else if(finger.tipPosition().getX()>=-5 && finger.tipPosition().getX()<=5) {
        		  dialog.panelVirtualKeyboard.jBR3B6.doClick();

      	    	System.out.print("g");
      	    	sentence+="g";
   			 try {
 				TimeUnit.MILLISECONDS.sleep(150);
 			} catch (InterruptedException e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			}
      	    }else if(finger.tipPosition().getX()>=21 && finger.tipPosition().getX()<=31) {
        		  dialog.panelVirtualKeyboard.jBR3B7.doClick();

      	    	System.out.print("h");
      	    	sentence+="h";
   			 try {
 				TimeUnit.MILLISECONDS.sleep(150);
 			} catch (InterruptedException e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			}
      	    }else if(finger.tipPosition().getX()>=40 && finger.tipPosition().getX()<=54) {
        		  dialog.panelVirtualKeyboard.jBR3B8.doClick();

      	    	System.out.print("j");
      	    	sentence+="j";
   			 try {
 				TimeUnit.MILLISECONDS.sleep(150);
 			} catch (InterruptedException e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			}
      	    }else if(finger.tipPosition().getX()>=70 && finger.tipPosition().getX()<=80) {
        		  dialog.panelVirtualKeyboard.jBR3B9.doClick();

      	    	System.out.print("k");
      	    	sentence+="k";
   			 try {
 				TimeUnit.MILLISECONDS.sleep(150);
 			} catch (InterruptedException e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			}
      	    }else if(finger.tipPosition().getX()>=93 && finger.tipPosition().getX()<107) {
        		  dialog.panelVirtualKeyboard.jBR3B10.doClick();

      	    	System.out.print("l");
      	    	sentence+="l";
   			 try {
 				TimeUnit.MILLISECONDS.sleep(150);
 			} catch (InterruptedException e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			}
      	    }
else {
      	    	
      	    }
            }
		 }else if(finger.tipPosition().getZ()>=-92 && finger.tipPosition().getZ()<=-87) {
            	 if(finger.tipPosition().getY()>=73 && finger.tipPosition().getY()<=83) {
            
          	  if(finger.tipPosition().getX()>=-90 && finger.tipPosition().getX()<=-77  ) {
          		  dialog.panelVirtualKeyboard.jBR4B3.doClick();

      	    	  System.out.print("z");
      	    	sentence+="z";
   			 try {
 				TimeUnit.MILLISECONDS.sleep(150);
 			} catch (InterruptedException e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			}
      	    }else if(finger.tipPosition().getX()>=-61 && finger.tipPosition().getX()<=-51) {
        		  dialog.panelVirtualKeyboard.jBR4B4.doClick();

      	    	System.out.print("x");
      	    	sentence+="x";
   			 try {
 				TimeUnit.MILLISECONDS.sleep(150);
 			} catch (InterruptedException e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			}
      	    }else if(finger.tipPosition().getX()>=-35 && finger.tipPosition().getX()<=-25) {
        		  dialog.panelVirtualKeyboard.jBR4B5.doClick();

      	    	System.out.print("c");
      	    	sentence+="c";
   			 try {
 				TimeUnit.MILLISECONDS.sleep(150);
 			} catch (InterruptedException e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			}
      	    }else if(finger.tipPosition().getX()>=-10 && finger.tipPosition().getX()<=0) {
        		  dialog.panelVirtualKeyboard.jBR4B6.doClick();

      	    	System.out.print("v");
      	    	sentence+="v";
   			 try {
 				TimeUnit.MILLISECONDS.sleep(150);
 			} catch (InterruptedException e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			}
      	    }else if(finger.tipPosition().getX()>=6 && finger.tipPosition().getX()<=16) {
        		  dialog.panelVirtualKeyboard.jBR4B7.doClick();

      	    	System.out.print("b");
      	    	sentence+="b";
   			 try {
 				TimeUnit.MILLISECONDS.sleep(150);
 			} catch (InterruptedException e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			}
      	    }else if(finger.tipPosition().getX()>=35 && finger.tipPosition().getX()<45) {
        		  dialog.panelVirtualKeyboard.jBR4B8.doClick();

      	    	System.out.print("n");
      	    	sentence+="n";
   			 try {
 				TimeUnit.MILLISECONDS.sleep(150);
 			} catch (InterruptedException e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			}
      	    }else if(finger.tipPosition().getX()>=58 && finger.tipPosition().getX()<70) {
        		  dialog.panelVirtualKeyboard.jBR4B9.doClick();

      	    	System.out.print("m");
      	    	sentence+="m";
   			 try {
 				TimeUnit.MILLISECONDS.sleep(150);
 			} catch (InterruptedException e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			}
      	    }else {
      	    	
      	    }
            }
            	 }else if(finger.tipPosition().getZ()>=-71 && finger.tipPosition().getZ()<=-65) {
            	 if(finger.tipPosition().getY()>=59 && finger.tipPosition().getY()<=70 ) {
          	  if(finger.tipPosition().getX()>=-40 && finger.tipPosition().getX()<=77 ) {
      		  dialog.panelVirtualKeyboard.jBSpace.doClick();

          	  System.out.print(" ");
          	sentence+=" ";
			 try {
				TimeUnit.MILLISECONDS.sleep(150);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
          		  }
            }
} 
            	 else if(finger.tipPosition().getZ()>-126 && finger.tipPosition().getZ()<-121) {
            		 if(finger.tipPosition().getY()>139 && finger.tipPosition().getY()<155) {
            			 if(finger.tipPosition().getX()>55 && finger.tipPosition().getX()<75) {
            		  		  dialog.panelVirtualKeyboard.jBBackspace.doClick();
                      		  if(sentence.length()>0 && sentence != null) {
                      		  sentence=sentence.substring(0, sentence.length() - 1);
                              errors++;
                 			 try {
                 				TimeUnit.MILLISECONDS.sleep(150);
                 			} catch (InterruptedException e) {
                 				// TODO Auto-generated catch block
                 				e.printStackTrace();
                 			}
                              }
            			 }		else	 if(finger.tipPosition().getX()>7 && finger.tipPosition().getX()<15) {
		  		  dialog.panelVirtualKeyboard.jBEnter.doClick();
			
		  		  if(i<40) {
		  			
		  			  if(i==9||i==19 || i==29) {
		  				 sw.stop();
		  			     writer.println("sentence no."+i+","+"no of characters"+w.lineLength(i)+" no. of errors:"+errors+" ,time taken"+sw.getElapsedTime());
		  			     
		  			    
		  			     j.setVisible(true);
		  			     
		  				  try {
							TimeUnit.MILLISECONDS.sleep(300000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		  				  w.word.setText(w.linesArray[i+1]);
				  			errors=0;
				  			     sentence="";
				  			     i+=1;
	  				  j.setVisible(false);

		  			     sw.start();
		  			  }else {
		  		  sw.stop();
     writer.println("sentence no."+i+","+"no of characters"+w.lineLength(i)+" no. of errors:"+errors+" ,time taken"+sw.getElapsedTime());
     errors=0;
     i+=1;
     w.word.setText(w.linesArray[i]);
     sentence="";
     
     sw.start();
	 try {
		TimeUnit.MILLISECONDS.sleep(150);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     }
		  			  }
		  		  else {
		  			
		  		  }

				}
            }
        }
				 
        vk.yourInpuFieldt.setText(sentence);

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
		    		  
		    		  Pointable finger = screenTap.pointable();

		    		  break;
		    		  
		    	  case TYPE_KEY_TAP:
		    		  
		    		  KeyTapGesture keyTap= new KeyTapGesture(gesture);

		    		  
		    		  
		    		  break;
		    		  default:
		    			  System.out.println("Unknown Gesture!!");
		    			  break;
		    		  
		    	  }

		    }
		
	}
}


public class leapController3 {

	public static void main(String[] args) {
       leapListener3 listener = new leapListener3();
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

