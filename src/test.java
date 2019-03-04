import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class test {
	static PrintWriter writer;
public static void main(String[] args) {
	
	try {
		writer = new PrintWriter("the-file-name.txt", "UTF-8");
	} catch (FileNotFoundException | UnsupportedEncodingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	writer.println("The first line");
	writer.println("The second line");
	writer.close();
}
}
