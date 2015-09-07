package Database;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class deleteMember implements ActionListener {

	JFrame frame = new JFrame("Slet medlem");
	JButton deleteMember = new JButton("Slet Bruger");
	JButton back = new JButton("Tilbage");
	JLabel labId = new JLabel("ID på brugeren der ønskes slettet: ");
	JTextField textId = new JTextField();
	Driver drive = new Driver();

	public deleteMember() {
		
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(8,1));
		frame.setLocationRelativeTo(null);
		
		frame.add(labId);
		frame.add(textId);
		frame.add(deleteMember);
		deleteMember.addActionListener(this);
		frame.add(back);
		back.addActionListener(this);
		
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == deleteMember) {
			int x = Integer.parseInt(textId.getText());
			drive.deleteFromDatabase(x);
			frame.dispose();
			DatabaseGUI data = new DatabaseGUI();
		}
		
		if(e.getSource() == back) {
			frame.dispose();
			DatabaseGUI data = new DatabaseGUI();
		}
	}
}
