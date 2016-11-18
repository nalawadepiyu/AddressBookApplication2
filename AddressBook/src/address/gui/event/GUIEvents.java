package address.gui.event;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import address.data.Address;
import address.data.AddressBook;
import address.data.AddressEntry;
import address.data.Name;

/*
 *@author :Priyanka Nalawade
 *This class contains methods for GUI events.
 **/

public class GUIEvents {
	static AddressBook ab =new AddressBook();
	static AddressEntry ae=new AddressEntry();
	static ArrayList<AddressEntry> addressEntryList=new ArrayList<AddressEntry>();
	static ArrayList<AddressEntry> addrsslist=new ArrayList<AddressEntry>();

	public static  void createAndShowGUI()
	{
		JFrame frame = new JFrame();
		JTable table = new JTable();

		// create a table model and set a Column Identifiers to this model
		final String[] columns = new String[] {
				"ID","First Name" ,"Last Name", "Street Name"," City Name","State Name","Zip","Phone Number","Email Id"
		};
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columns);

		// set the model to the table
		table.setModel(model);

		// Change A JTable Background Color, Font Size, Font Color, Row Height
		table.setBackground(Color.LIGHT_GRAY);
		table.setForeground(Color.black);
		Font font = new Font("",1,22);
		table.setFont(font);
		table.setRowHeight(30);

		JTextField searchTxt=new JTextField();
		searchTxt.setBounds(150, 450, 100, 25);

		// create JButtons
		JButton btndisplay=new JButton("Display");
		JButton btnAdd = new JButton("Add");
		JButton btnDelete = new JButton("Delete");
		JButton btnUpdate = new JButton("Update");
		JButton btnSearch=new JButton("Search");
		JButton exitButton = new JButton("Exit");


		btndisplay.setBounds(20, 250, 100, 25);
		btnAdd.setBounds(20, 300, 100, 25);
		btnUpdate.setBounds(20, 350, 100, 25);
		btnDelete.setBounds(20, 400, 100, 25);
		btnSearch.setBounds(20, 450, 100, 25);
		exitButton.setBounds(20, 500, 100, 25);

		/* This method will exit the frame on Exit button click */
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
			}
		});

		/* This method will search in the table by start of last name on Search button click */
		btnSearch.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String text=searchTxt.getText();
				try {
					ab.list();
					addrsslist=ab.find(text);
					displayDataTable(addrsslist);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}


			}
		});

		// create JScrollPane
		JScrollPane pane = new JScrollPane(table);

		pane.setBounds(0, 0, 880, 200);

		frame.setLayout(null);

		frame.add(pane);


		// add JButtons to the jframe
		frame.add(btndisplay);
		frame.add(btnAdd);
		frame.add(btnDelete);
		frame.add(btnUpdate);
		frame.add(btnSearch);
		frame.add(exitButton);
		frame.add(searchTxt);

		frame.setSize(900,600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);


		btndisplay.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try {

					addressEntryList=ab.list();

					model.setRowCount(0);
					for(AddressEntry ae:addressEntryList)
					{
						Object[] obj=new Object[10];
						obj[0]=ae.id;
						obj[1]=ae.name.firstName;
						obj[2]=ae.name.lastName;
						obj[3]=ae.adr.streetName;
						obj[4]=ae.adr.stateName;
						obj[5]=ae.adr.cityName;
						obj[6]=ae.adr.zipcode;
						obj[7]=ae.phoneNumber;
						obj[8]=ae.emailId;
						model.addRow(obj);

					}

				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		btnAdd.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//createFrame();

				JFrame frame = new JFrame("New Record");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				try
				{
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				JPanel panel = new JPanel();
				panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
				panel.setOpaque(true);

				JPanel inputpanel = new JPanel();
				inputpanel.setLayout(new FlowLayout());

				JTextField id = new JTextField(20);
				JTextField firstnametxt = new JTextField(20);
				JTextField lastnametxt=new JTextField(20);
				JTextField streetnametxt=new JTextField(20);
				JTextField citynametxt=new JTextField(20);
				JTextField statenametxt=new JTextField(20);
				JTextField ziptxt=new JTextField(20);
				JTextField phonetxt=new JTextField(20);
				JTextField emailtxt=new JTextField(20);

				JLabel idlbl=new JLabel(" Id           ");
				JLabel firstnamelbl =new JLabel("First Name");
				JLabel lastnamelbl=new JLabel("Last Name");
				JLabel streetnamelbl=new JLabel("Street     ");
				JLabel citynamelbl=new JLabel("City Name");
				JLabel statenamelbl=new JLabel("State Name");
				JLabel ziplbl=new JLabel("zip Code    ");
				JLabel phonelbl=new JLabel("Phone No  ");
				JLabel emaillbl=new JLabel("Email ID  ");

				JButton submitbutton = new JButton("Submit");

				submitbutton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						Name name=new Name();


						ae.setId(Integer.parseInt(id.getText()));
						name.setFirstName(firstnametxt.getText());
						name.setLastName(lastnametxt.getText());

						Address adr=new Address();
						adr.setStreetName(streetnametxt.getText());
						adr.setStateName(statenametxt.getText());
						adr.setCityName(citynametxt.getText());

						adr.setZip(Integer.parseInt(ziptxt.getText()));
						ae.setPhoneNumber(phonetxt.getText());
						ae.setEmail(emailtxt.getText());
						ae.setNameObj(name);
						ae.setAddrObj(adr);

						try {
							addressEntryList=ab.addNewRecords(ae);

							model.setRowCount(0);
							for(AddressEntry ae:addressEntryList)
							{
								Object[] obj=new Object[10];
								obj[0]=ae.id;
								obj[1]=ae.name.firstName;
								obj[2]=ae.name.lastName;
								obj[3]=ae.adr.streetName;
								obj[4]=ae.adr.stateName;
								obj[5]=ae.adr.cityName;
								obj[6]=ae.adr.zipcode;
								obj[7]=ae.phoneNumber;
								obj[8]=ae.emailId;
								model.addRow(obj);

							}
							//displayDataTable(addressEntryList);


						} catch (ClassNotFoundException | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}


						frame.dispose();
					}

				});


				GridBagConstraints left = new GridBagConstraints();
				left.anchor = GridBagConstraints.EAST;
				GridBagConstraints right = new GridBagConstraints();
				right.weightx = 2.0;
				right.fill = GridBagConstraints.HORIZONTAL;
				right.gridwidth = GridBagConstraints.REMAINDER;
				inputpanel.add(idlbl,left);
				inputpanel.add(id,right);
				inputpanel.add(firstnamelbl,left);
				inputpanel.add(firstnametxt,right);
				inputpanel.add(lastnamelbl,left);
				inputpanel.add(lastnametxt,right);
				inputpanel.add(streetnamelbl,left);
				inputpanel.add(streetnametxt,right);
				inputpanel.add(citynamelbl,left);
				inputpanel.add(citynametxt,right);
				inputpanel.add(statenamelbl,left);
				inputpanel.add(statenametxt,right);
				inputpanel.add(ziplbl,left);
				inputpanel.add(ziptxt,right);
				inputpanel.add(phonelbl,left);
				inputpanel.add(phonetxt,right);
				inputpanel.add(emaillbl,left);
				inputpanel.add(emailtxt,right);

				inputpanel.add(submitbutton);
				panel.add(inputpanel);


				frame.getContentPane().add(BorderLayout.CENTER, panel);
				frame.setSize(240, 300);
				frame.setLocationByPlatform(true);
				frame.setVisible(true);
				frame.setResizable(false);

			}
		});


		/* This method will delete the record on Delete button click */
		btnDelete.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {

				// i = the index of the selected row
				int i = table.getSelectedRow();
				int id = (int) table.getValueAt(i, 0);
				if(i >= 0){
					// remove a row from jtable
					model.removeRow(i);
					try {
						ab.removeRecord(id);
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else{
					System.out.println("Delete Error");
				}
			}
		});

		/* This method will update the record on Update button click */



		btnUpdate.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {

				EventQueue.invokeLater(new Runnable()
				{
					@Override
					public void run()
					{
						JFrame frame = new JFrame("Update Record");
						frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						try
						{
							UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
						} catch (Exception e) {
							e.printStackTrace();
						}
						JPanel panel = new JPanel();
						panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
						panel.setOpaque(true);

						JPanel inputpanel = new JPanel();
						inputpanel.setLayout(new FlowLayout());

						JTextField idtxt = new JTextField(20);
						JTextField firstnametxt = new JTextField(20);
						JTextField lastnametxt=new JTextField(20);
						JTextField streetnametxt=new JTextField(20);
						JTextField citynametxt=new JTextField(20);
						JTextField statenametxt=new JTextField(20);
						JTextField ziptxt=new JTextField(20);
						JTextField phonetxt=new JTextField(20);
						JTextField emailtxt=new JTextField(20);

						idtxt.disable();
						JLabel idlbl=new JLabel(" Id           ");
						JLabel firstnamelbl =new JLabel("First Name");
						JLabel lastnamelbl=new JLabel("Last Name");
						JLabel streetnamelbl=new JLabel("Street     ");
						JLabel citynamelbl=new JLabel("City Name");
						JLabel statenamelbl=new JLabel("State Name");
						JLabel ziplbl=new JLabel("zip Code    ");
						JLabel phonelbl=new JLabel("Phone No  ");
						JLabel emaillbl=new JLabel("Email ID  ");

						JButton updaterecordbutton = new JButton("Update Record");

						// i = the index of the selected row
						int i = table.getSelectedRow();
						if(i>=0){
						idtxt.setText(model.getValueAt(i, 0).toString());
						firstnametxt.setText(model.getValueAt(i, 1).toString());
						lastnametxt.setText(model.getValueAt(i, 2).toString());
						streetnametxt.setText(model.getValueAt(i, 3).toString());
						citynametxt.setText(model.getValueAt(i, 4).toString());
						statenametxt.setText(model.getValueAt(i, 5).toString());
						ziptxt.setText(model.getValueAt(i, 6).toString());
						phonetxt.setText(model.getValueAt(i, 7).toString());
						emailtxt.setText(model.getValueAt(i, 8).toString());

						}
						updaterecordbutton.addActionListener(new ActionListener()
						{
							public void actionPerformed(ActionEvent e)
							{

								int i = table.getSelectedRow();

								if(i >= 0)
								{


									model.setValueAt(idtxt.getText(), i, 0);
									model.setValueAt(firstnametxt.getText(), i, 1);
									model.setValueAt(lastnametxt.getText(), i, 2);
									model.setValueAt(streetnametxt.getText(), i, 3);
									model.setValueAt(citynametxt.getText(), i, 4);
									model.setValueAt(statenametxt.getText(), i, 5);
									model.setValueAt(ziptxt.getText(), i, 6);
									model.setValueAt(phonetxt.getText(), i, 7);
									model.setValueAt(emailtxt.getText(), i, 8);

									ae.setId(Integer.parseInt(idtxt.getText()));
									Name name=new Name();
									name.setFirstName(firstnametxt.getText());
									name.setLastName(lastnametxt.getText());

									Address adr=new Address();
									adr.setStreetName(streetnametxt.getText());
									adr.setStateName(statenametxt.getText());
									adr.setCityName(citynametxt.getText());

									adr.setZip(Integer.parseInt(ziptxt.getText()));
									ae.setPhoneNumber(phonetxt.getText());
									ae.setEmail(emailtxt.getText());
									ae.setNameObj(name);
									ae.setAddrObj(adr);


									try {
										ab.upateRecords(ae);
									} catch (ClassNotFoundException | SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}

									frame.dispose();

								}
								else{
									System.out.println("Update Error");
								}
							}



						});

						GridBagConstraints left = new GridBagConstraints();
						left.anchor = GridBagConstraints.EAST;
						GridBagConstraints right = new GridBagConstraints();
						right.weightx = 2.0;
						right.fill = GridBagConstraints.HORIZONTAL;
						right.gridwidth = GridBagConstraints.REMAINDER;
						inputpanel.add(idlbl,left);
						inputpanel.add(idtxt,right);
						inputpanel.add(firstnamelbl,left);
						inputpanel.add(firstnametxt,right);
						inputpanel.add(lastnamelbl,left);
						inputpanel.add(lastnametxt,right);
						inputpanel.add(streetnamelbl,left);
						inputpanel.add(streetnametxt,right);
						inputpanel.add(citynamelbl,left);
						inputpanel.add(citynametxt,right);
						inputpanel.add(statenamelbl,left);
						inputpanel.add(statenametxt,right);
						inputpanel.add(ziplbl,left);
						inputpanel.add(ziptxt,right);
						inputpanel.add(phonelbl,left);
						inputpanel.add(phonetxt,right);
						inputpanel.add(emaillbl,left);
						inputpanel.add(emailtxt,right);

						inputpanel.add(updaterecordbutton);
						panel.add(inputpanel);

						frame.getContentPane().add(BorderLayout.CENTER, panel);
						frame.setSize(240, 300);
						frame.setLocationByPlatform(true);
						frame.setVisible(true);
						frame.setResizable(false);

					}});

		}});
	}


	/* This method will create a new frame for adding new record in arraylist as well as database */
/*
	public static void createFrame()
	{
		EventQueue.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{

			}});


	}
*/

	/* This method will display data in jtable from arraylist */
	public static void displayDataTable(ArrayList<AddressEntry> addressEntryList)
	{
		JFrame frame = new JFrame("AddressEntry");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		final String[] columnNames = new String[] {
				"ID","First Name" ,"Last Name", "Street Name"," City Name","State Name","Zip","Phone Number","Email Id"
		};

		JTable table = new JTable();
		DefaultTableModel model = new DefaultTableModel();
		table.setModel(model);

		model.setColumnIdentifiers(columnNames);
		model.setRowCount(0);
		for(AddressEntry ae:addressEntryList)
		{
			Object[] obj=new Object[10];
			obj[0]=ae.id;
			obj[1]=ae.name.firstName;
			obj[2]=ae.name.lastName;
			obj[3]=ae.adr.streetName;
			obj[4]=ae.adr.stateName;
			obj[5]=ae.adr.cityName;
			obj[6]=ae.adr.zipcode;
			obj[7]=ae.phoneNumber;
			obj[8]=ae.emailId;
			model.addRow(obj);
		}

		table.setPreferredScrollableViewportSize(new Dimension(300, 200));
		table.setFillsViewportHeight(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane scroll=new JScrollPane(table);
		frame.add(scroll);
		JOptionPane.showMessageDialog(null, new JScrollPane(table));

	}


}













