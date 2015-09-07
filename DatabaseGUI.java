package Database;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import GUI.Brugere;

public class DatabaseGUI implements ActionListener {

	//Fields
	JFrame frame = new JFrame("Medlemmer");
	JTable table = new JTable();
	DefaultTableModel model = new DefaultTableModel();
	JButton newMember = new JButton("Tilføj Medlem");
	JButton deleteMember = new JButton("Slet Medlem");
	JPanel panel = new JPanel();
	JScrollPane scroll = new JScrollPane(table);
	
	ArrayList<Brugere> bruger = new ArrayList<Brugere>();
	
	public DatabaseGUI() {
		
		frame.setSize(500,500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		
		panel.add(newMember);
		newMember.addActionListener(this);
		
		panel.add(deleteMember);
		deleteMember.addActionListener(this);
		
		//add medlemmer fra database til arraylist
		Driver drive = new Driver();
		bruger = drive.hentBrugere();
		updateJTable();
		
		frame.add(scroll, BorderLayout.CENTER);
		frame.add(panel, BorderLayout.SOUTH);
		
		//Last
		frame.pack();
		frame.setVisible(true);
	}
	
	public void updateJTable(){
		//set coloumn names
		model.setColumnIdentifiers(new String[] {"id", "fornavn", "efternavn", "alder"});
		
		//set hvor mange rækker der skal være i JTable
		model.setRowCount(bruger.size());
	
		//row count
		int row = 0;

		//loop through the arraylist to fill the table
		for(Brugere b : bruger) {

			// add each cell in the table
			model.setValueAt(b.getId(), row, 0);
			model.setValueAt(b.getFornavn(), row, 1);
			model.setValueAt(b.getEfternavn(), row, 2);
			model.setValueAt(b.getAlder(), row, 3);
			
			//næste række
			row++;
		}
		table.setModel(model);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == newMember) {
			
			newMember tilføj = new newMember();
		}
	
		if(e.getSource() == deleteMember) {
		deleteMember del = new deleteMember();
	}
	}
//END OF CLASS
}
