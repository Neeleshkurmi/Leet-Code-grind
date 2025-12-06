package awt;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyGUI {
    public MyGUI(){
        Frame frame = new Frame();
        frame.setVisible(true);
        frame.setSize(500, 500);
    }

    public static void main(String[] args) {
        MyGUI m = new MyGUI();
    }
}

class MyFrame extends Frame{
    public MyFrame(){
        this.setVisible(true);
        this.setSize(500,500);
        this.setTitle("My First Frame");
        Color color = new Color(38, 38, 175);
        this.setBackground(color);
        Button button = new Button("Dabao");
    }

    public static void main(String[] args) {
        MyFrame fm = new MyFrame();
    }
}
class Login extends Frame{
    Label l1,l2,l3;
    TextField t1,t2;
    Button btn;
    public Login(){
        Font font = new Font("Serif",Font.ITALIC,25);

        l1 = new Label("Lgin Form");
        l1.setBounds(140,50,150,40);
        l1.setFont(font);
        l1.setForeground(Color.BLUE);
        this.add(l1);

        l2 = new Label("Enter user name");
        l2.setFont(font);
        l2.setBounds(30,100,150,40);
        this.add(l2);

        t1 = new TextField();
        t1.setBounds(190,100,200,40);
        this.add(t1);



        this.setSize(500,500);

        this.setTitle("Login");
        this.setBackground(Color.CYAN);
        this.setLayout(null);
        this.setVisible(true);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        new Login();
    }
}
