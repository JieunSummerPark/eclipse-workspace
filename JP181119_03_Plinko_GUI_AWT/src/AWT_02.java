import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.util.Random;

@SuppressWarnings("serial")
class Frame_02 extends Frame{
	
	Label lbl_01 = new Label();
	Label lbl_02 = new Label("a label with nothing");
	Label lbl_03 = new Label("today is gonna be a good day");
	
	
	public Frame_02() {
		setTitle("Hey Window");
		setBounds(100,100,800,450);
		
		Random ran = new Random();
		
		int r = ran.nextInt(256);
		int g = ran.nextInt(256);
		int b = ran.nextInt(256);
		
		setBackground(Color.black);
		setBackground(new Color(r,g,b));
		
		add("West", lbl_02);
		add("Center", lbl_03);
		
		setVisible(true);
	}
}


public class AWT_02 {
	public static void main(String[] args) {
		new Frame_02();	// 1회용 객체를 생성할 때. GUI에서는 1회용 객체를 주로 생성함.
						// MyFrame f1 = new MyFrame();
	}
}






/*
public class Plinko_AWT_01 {

	public static void main(String[] args) {
		
			

	}

}
*/