import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class homepage {
	public static void main(String[] args) {
		JFrame frame = new JFrame ("MERC AIRLINE");
		JPanel panel = new JPanel();
		CardLayout pages = new CardLayout ();
		
		//FRAME DESIGN
		
	        frame.getContentPane().setLayout(new BorderLayout(0, 0));
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(1000, 725);
	        frame.setLocationRelativeTo(null);
			frame.setResizable(false);
			frame.getContentPane().add(panel);
			frame.getContentPane().add(panel); // panel will be added to the frame

	        panel.setBorder(new LineBorder(Color.black, 1, true));
	        panel.setLayout(pages);  
	        

					
			//PANEL FOR HOME PAGE
			
		JPanel home = new JPanel();
			home.setBackground(Color.WHITE);
			panel.add(home, "1"); // adding the home to the panel
			
			// Jlabel for the background picture in panel home
			
		JLabel image = new JLabel();
			image.setSize(1000, 700);
			image.setIcon(new ImageIcon("C:\\Users\\Alodi\\eclipse-workspace\\FinalAirline\\src\\MERC AIRLINES.png"));
			home.add(image); //the image label has been added to the home panel
			
		// Book now button connecting to the next page
			
		JButton book = new JButton("BOOK NOW");
			book.setBounds(854, 617, 98, 42);
			image.add(book);
			book.setBorder(new LineBorder(Color.black, 1, true));
			book.addActionListener(new ActionListener() {
		              public void actionPerformed(ActionEvent e) {
		                  pages.show(panel, "2");
		              }
		      });
		      
			// panel for the whole first page 
			
		JPanel fpage = new JPanel();
			panel.add(fpage, "2"); // first page is added to the main panel
			
			// records of the table
		
				final String options[][] = {
		    		  	{"A", "Manila - Batanes",  "P8,000.00", "P12,500.00", "P3,500.00"},
		    			{"B", "Batanes - Manila", "P9,800.00", "P12,950.00", "P3,900.00"},
		    			{"C", "Manila - Palawan",  "P9,100.00", "P10,500.00", "P3,200.00"},
		    			{"D", "Palawan - Manila",  "P9,850.00", "P10,975.00", "P3,575.00"},
		    			{"E", "Manila - South Korea",  "P27,450.00", "P37,390.00", "P12,055.00"},
		    			{"F", "South Korea - Manila",  "P30,890.00", "P39,650.00", "P13,100.00"},
		    			{"G", "Manila - Japan",  "P40,450.00", "P45,355.00", "P27,800.00"},
		    			{"H", "Japan - Manila",  "P43,855.00", "P49,780.00", "P29,400.00"},
		    			{"I", "Manila - Vietnam",  "P8,505.00", "P12,345.00", "P3,200.00"},
		    			{"J", "Vietnam - Manila",  "P14,300.00", "P16,320.00", "P4,600.00"}
					};
				final String titles[] = {"<html><center><i>Flight<br>Code</i></center></html>", "<html><i>Destination</i></html>", "<html><center><i>Private Class<br>(per person)</i></center></html>",
						"<html><center><i>Business Class<br>(per person)</i></center></html>","<html><center><i>Regular Class<br>(per person)</i></center></html>"};
				
			// Scrollpane
				
		JScrollPane scroll1 = new JScrollPane();
			scroll1.setBounds(10, 53, 638, 201);
			scroll1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scroll1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
			scroll1.setBorder(new LineBorder(new Color(240, 240,240), 1));
			
			// Table Design
			
		DefaultTableModel mtable = new DefaultTableModel(options, titles) {
			    public boolean isCellEditable(int row, int column) {
			    	return false;
			    }
		    };
			
		DefaultTableCellRenderer crender = new DefaultTableCellRenderer();
			crender.setHorizontalAlignment((int) 0.5);
			
		JTable ftable = new JTable(mtable);
			for (int i = 0; i < ftable.getColumnCount(); i++) {
				ftable.getColumnModel().getColumn(i).setCellRenderer(crender);
				ftable.getColumnModel().getColumn(i).setResizable(false);
			}
				ftable.getColumnModel().getColumn(1).setPreferredWidth(50);
				ftable.getColumnModel().getColumn(2).setPreferredWidth(200);
				ftable.getColumnModel().getColumn(3).setPreferredWidth(150);
				ftable.getColumnModel().getColumn(4).setPreferredWidth(150);
				ftable.getTableHeader().setReorderingAllowed(false);
		
				ftable.getTableHeader().setFont(new Font("Arial", Font.BOLD, ftable.getFont().getSize()));
				ftable.getTableHeader().setBackground(new Color(240, 240,240));
				ftable.getTableHeader().setForeground(Color.WHITE);
				fpage.setLayout(null);
				
				JLabel lblNewLabel_3 = new JLabel("FLIGHT DETAILS");
				lblNewLabel_3.setBounds(452, 22, 339, 20);
				lblNewLabel_3.setFont(new Font("Arial",Font.PLAIN,20));
				fpage.add(lblNewLabel_3);
				
				JButton btnNewButton_1 = new JButton("Clear");
				btnNewButton_1.setBounds(774, 630, 89, 23);
				fpage.add(btnNewButton_1);
				
				JButton btnNewButton = new JButton("Next");
				btnNewButton.setBounds(877, 630, 89, 23);
				fpage.add(btnNewButton);
				ftable.setFont(new Font("Arial", Font.PLAIN, 13));
				
				scroll1.setViewportView(ftable);
				fpage.add(scroll1);
			
			
				//new table for Baggage fee

			final String option2[][] = {
	  	      		{"Private Class", "1,250.00"},
	  	      		{"Business Class", "2,850.00"},
	  	      		{"Regular Class", "950.00"},
	  	      		
	  	      };

	  	    final String title2[] = {"<html><center><i>AIRLINE TYPE<br>Code</i></center></html>","<html><i>BAGGAGE FEE</i></html>"};
	  	    
	  	  JScrollPane scroll2 = new JScrollPane();
			scroll2.setBounds(658, 53, 324, 88);
			scroll2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
			scroll2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scroll2.setBorder(new LineBorder(new Color(112, 112, 112), 1));
			
			
//TABLE DESIGN
	  	    
	  	    DefaultTableModel mtable2 = new DefaultTableModel(option2, title2) {
		  	      public boolean isCellEditable(int row, int column) {
		  	      	return false;
		  	      }
		  	  };
		  	  JTable ftable2 = new JTable (mtable2);
		  	  
		  	 DefaultTableCellRenderer crender2 = new DefaultTableCellRenderer();
		  	crender2.setHorizontalAlignment((int) 0.3);
		  	  	for (int i = 0; i < ftable2.getColumnCount(); i++) {
		  	  	ftable2.getColumnModel().getColumn(i).setResizable(false);
		  	  	ftable2.getColumnModel().getColumn(i).setCellRenderer(crender2);
		  	  }
		  	  	//ftable2.getColumnModel().getColumn(1).setPreferredWidth(50);
		  	  	//ftable2.getColumnModel().getColumn(2).setPreferredWidth(200);
		  	  	//ftable2.getColumnModel().getColumn(3).setPreferredWidth(150);
		  	  	ftable2.getTableHeader().setReorderingAllowed(false);

		  	  	ftable2.getTableHeader().setFont(new Font("Arial", Font.BOLD, ftable2.getFont().getSize()));
		  	  	ftable2.getTableHeader().setBackground(new Color(112, 112, 112));
		  	  	ftable2.getTableHeader().setForeground(Color.WHITE);
		  	  	ftable2.setFont(new Font("Arial", Font.PLAIN, 13));
		  	  	ftable2.setAlignmentX(ftable2.CENTER_ALIGNMENT);
			
			scroll2.setViewportView(ftable2);
			fpage.add(scroll2);
			
			//Table for Tax
		
		final String record1[][] = {
  	      			{"Private Class", "1,250.00"},
  	      			{"Business Class", "2,850.00"},
  	      			{"Regular Class", "950.00"},
  	      		
  	      };
		
  	      final String title1[] = {"<html><center><i>AIRLINE TYPE<br>Code</i></center></html>",  "<html><i>TRAVEL INSURANCE</i></html>"
  	      	};

  	    JScrollPane scroll3 = new JScrollPane();
  	    scroll3.setBounds(658, 165, 324, 88);
  	    scroll3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
  	    scroll3.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
  	    scroll3.setBorder(new LineBorder(new Color(112, 112, 112), 1));
  	    
  	    
				
  	      DefaultTableModel mtable3 = new DefaultTableModel(record1, title1) {
  	          public boolean isCellEditable(int row, int column) {
  	          	return false;
  	          }
  	      };
  	      JTable ftable3 =new JTable (mtable3);
  	    DefaultTableCellRenderer crender3 = new DefaultTableCellRenderer();
  	    	crender3.setHorizontalAlignment((int) 0.3);
  	    		for (int i = 0; i < ftable3.getColumnCount(); i++) {
  	    			ftable3.getColumnModel().getColumn(i).setResizable(false);
  	    			ftable3.getColumnModel().getColumn(i).setCellRenderer(crender3);
  	  }
  	    		//ftable3.getColumnModel().getColumn(1).setPreferredWidth(150);
  	    	   // ftable3.getColumnModel().getColumn(2).setPreferredWidth(200);
  	    	    ftable3.getTableHeader().setReorderingAllowed(false);
  	    	    
  	    	    ftable3.getTableHeader().setFont(new Font("Arial", Font.BOLD, ftable3.getFont().getSize()));
  	    	    ftable3.getTableHeader().setBackground(new Color(112, 112, 112));
  	    	    ftable3.getTableHeader().setForeground(Color.WHITE);
  	    	    ftable3.setFont(new Font("Arial", Font.PLAIN, 13));
  	    	    ftable3.setAlignmentX(ftable3.CENTER_ALIGNMENT);

  	    		
  	    		scroll3.setViewportView(ftable3);
  	    		fpage.add(scroll3);
  	    		
//button for back
  	    JButton back = new JButton("Back");
  	    	back.setBounds(658, 629, 100, 25);
  	    	back.setBorder(new LineBorder(Color.black, 2, true));
  	    	back.setPreferredSize(new Dimension(100, 25));
  	    	back.addActionListener(new ActionListener() {
	  	    public void actionPerformed(ActionEvent e) {
	  	                pages.show(panel, "1");
	  	            }
	  	        });
	  	    
  	    	fpage.add(back);
	  	    
  	    	 pages.show(panel, "1");
  	    	JLabel label2 = new JLabel();
  	 	  	label2.setBounds(23, 419, 100, 32);
     		label2.setText("Flight Options");
     		label2.setFont(new Font("Arial",Font.PLAIN,15));
     		fpage.add(label2);
//Combobox for the options
	    String[] Options= {"A", "B", "C", "D","E", "F", "G", "H", "I", "J"};
	           JComboBox Combo= new JComboBox<Object>(Options);
	           Combo.setBounds(153, 426, 91, 20);
		  	 	fpage.add(Combo);
		  	 	
//label for the flight type
	    	 
	    	JLabel lblNewLabel = new JLabel("Flight Type");
	    	lblNewLabel.setBounds(23, 299, 117, 19);
	    	lblNewLabel.setFont(new Font("Arial",Font.PLAIN,15));
	    	fpage.add(lblNewLabel);
	  //choices for the flight type
	    	JRadioButton rdbtnNewRadioButton = new JRadioButton("International");
	    	rdbtnNewRadioButton.setBounds(156, 298, 109, 23);
	    	fpage.add(rdbtnNewRadioButton);
	    	
	    	JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Domestic");
	    	rdbtnNewRadioButton_1.setBounds(306, 298, 109, 23);
	    	fpage.add(rdbtnNewRadioButton_1);
	    	
	    //label for the airline type	
	    	JLabel lblNewLabel_1 = new JLabel("Airline Type");
	    	lblNewLabel_1.setBounds(23, 365, 91, 14);
	    	lblNewLabel_1.setFont(new Font("Arial",Font.PLAIN,15));
	    	fpage.add(lblNewLabel_1);
	    	//choices for the airline type
	    	JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Private");
	    	rdbtnNewRadioButton_2.setBounds(156, 362, 109, 23);
	    	fpage.add(rdbtnNewRadioButton_2);
	    	
	    	JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Business");
	    	rdbtnNewRadioButton_3.setBounds(306, 362, 109, 23);
	    	fpage.add(rdbtnNewRadioButton_3);
	    	
	    	JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("Regular Fare");
	    	rdbtnNewRadioButton_4.setBounds(452, 362, 109, 23);
	    	fpage.add(rdbtnNewRadioButton_4);
	    	
	    	// asking for insurance 
	    	JLabel lblNewLabel_2 = new JLabel("Do You Want to Avail Insurance?");
	    	lblNewLabel_2.setBounds(717, 278, 218, 111);
	    	lblNewLabel_2.setFont(new Font("Arial",Font.PLAIN,15));
	    	fpage.add(lblNewLabel_2);
	    	//answers
	    	JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("Yes");
	    	rdbtnNewRadioButton_5.setBounds(696, 380, 109, 23);
	    	fpage.add(rdbtnNewRadioButton_5);
	    	
	    	JRadioButton rdbtnNewRadioButton_6 = new JRadioButton("No");
	    	rdbtnNewRadioButton_6.setBounds(849, 380, 109, 23);
	    	fpage.add(rdbtnNewRadioButton_6);
	    	//background pic for the first page
	    	JLabel Ppage = new JLabel();
	    	  Ppage.setBounds(0, 0, 1157, 671);
	    	  Ppage.setIcon(new ImageIcon("C:\\Users\\Alodi\\Downloads\\Bg.png"));
	    	  Ppage.setBorder(new LineBorder(Color.black, 1, true));
	    	  
	    	  	fpage.add(Ppage);


		
//VISIBLE FRAME
		
		frame.setVisible(true);
		
}
}
