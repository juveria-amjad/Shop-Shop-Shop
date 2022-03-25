package shoppingProject.producer;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
//import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ListIterator;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import shoppingProject.Items;

public class ProducerGUI implements ActionListener{
	Clothing cloth = new Clothing();
	JPanel mainPanel = new JPanel();
	JFrame frame = new JFrame("Administrator");
	JPanel tool = new JPanel();
	JToolBar toolbar = new JToolBar();
	JButton addB, deleteB, editB,readB;
	DefaultTableModel tablemodel = new DefaultTableModel();
	JTable table = new JTable(tablemodel);
	JScrollPane scroll;
	ProducerGUI(){
		//frame.setLayout(null);
		//ImageIcon addIcon = new ImageIcon("add.png");
		addB = new JButton("Add");
		//int offset = addB.getInsets().left;
		//addB.setIcon(resizeIcon(addIcon, addB.getWidth()-offset, addB.getHeight()- offset));
		addB.setPreferredSize(new Dimension(100,30));
		readB = new JButton("Read");
		readB.setPreferredSize(new Dimension(100,30));
		deleteB = new JButton("Delete");
		deleteB.setPreferredSize(new Dimension(100,30));
		editB =  new JButton("Edit");
		editB.setPreferredSize(new Dimension(100,30));
		
		readB.addActionListener(this);
		
		tool.add(addB);
		tool.add(readB);
		tool.add(deleteB);
		tool.add(editB);
		toolbar.add(tool);
		toolbar.addSeparator();
		mainPanel.add(toolbar, BorderLayout.NORTH);
		tablemodel.addColumn(new String[][]{ {"ID", "Name", "Price", "Category", "Size", "Quantity"}});
		scroll = new JScrollPane(table);
		mainPanel.add(scroll);
		
		
		frame.add(mainPanel);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.pack();
		frame.setVisible(true);
		//frame.setLayout(null);
		frame.setSize(500,500);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e) {
		String action= ((JButton)e.getSource()).getActionCommand();
		if(action.equals("Add")) {
			
		}
		if(action.equals("Read")) {
			cloth.read();
			ListIterator<Items> itr = cloth.item.listIterator();
			Items temp;
			while(itr.hasNext()) {
				temp = itr.next();
				tablemodel.addRow(new Object[][]{ {temp.getId(), temp.getName(), temp.getPrice(), temp.getCategory(), temp.getSize(),temp.getQuantity()}});
			}
			
			table.setModel(tablemodel);
			
		}
		if(action.equals("Edit")) {
			
		}
		if(action.equals("Delete")) {
			
		}
	}
	
	/*private static Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
	    Image img = icon.getImage();  
	    Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight,  java.awt.Image.SCALE_SMOOTH);  
	    return new ImageIcon(resizedImage);
	}*/
	
	public static void main(String []args) {
		SwingUtilities.invokeLater(()-> new ProducerGUI());
	}

}
