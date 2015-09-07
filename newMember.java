package Database;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class newMember implements ActionListener {

	JFrame frame = new JFrame();
	JButton saveMember = new JButton("gem medlem");
	JButton back = new JButton("tilbage");
	JLabel labFName = new JLabel("fornavn");
	JTextField textFName = new JTextField();
	JLabel labLName = new JLabel("efternavn");
	JTextField textLName = new JTextField();
	JLabel labAge = new JLabel("alder");
	JTextField textAge = new JTextField();
	
	//Connection to database via driver class
	Driver drive = new Driver();
	
	public newMember() {
		
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(8,1));
		frame.setLocationRelativeTo(null);
		frame.setTitle("opret medlem");
		
		frame.add(labFName);
		frame.add(textFName);
		
		frame.add(labLName);
		frame.add(textLName);
		
		frame.add(labAge);
		frame.add(textAge);
		
		frame.add(saveMember);
		saveMember.addActionListener(this);
		
		frame.add(back);
		back.addActionListener(this);
		
		frame.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		 if(e.getSource() == saveMember) {
		 if(textFName.getText() == "" || textLName.getText() == "" || textAge.getText() == "") {
				JOptionPane.showMessageDialog(null, "alle felter skal udfyldes", "Error", JOptionPane.ERROR_MESSAGE);
				
			} 
		 else {
			drive.writeToDatabase(textFName.getText(), textLName.getText(), Integer.parseInt(textAge.getText())); 
			JOptionPane.showMessageDialog(null, "bruger oprettet", "Succes", JOptionPane.INFORMATION_MESSAGE);
		 }
	}
		
		
		if(e.getSource() == back) {
	frame.dispose();
	DatabaseGUI data = new DatabaseGUI();
}
		
	}

	
	
}
