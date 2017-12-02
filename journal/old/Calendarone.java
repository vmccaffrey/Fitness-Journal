package calendar;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JDateChooser;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Calendarone extends JPanel {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	static JLabel lblMonth, lblYear, lblPushups, lblSitups, lblRunning, lblNewLabel, lblNewLabel_2, lblNewLabel_3;
	static JButton btnPrev, btnNext, btnResults;
	static JTable tblCalendar;
	static JComboBox cmbYear;
//	static JFrame frmMain;
//	static Container pane;
	static DefaultTableModel mtblCalendar; //Table model
	static JScrollPane stblCalendar; //The scrollpane
	static JPanel pnlCalendar, pnlGetData, panel, panel_1, panel_2;
	static JDateChooser dateChooser;
	static int realYear, realMonth, realDay, currentYear, currentMonth;
	private JLabel lblNewLabel_1;
	/**
	 * Create the panel.
	 */
	public Calendarone() {

		try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}
		catch (ClassNotFoundException e) {}
		catch (InstantiationException e) {}
		catch (IllegalAccessException e) {}
		catch (UnsupportedLookAndFeelException e) {}

		//Prepare frame
//		frmMain = new JFrame ("Fitness Journal"); //Create frame
//		frmMain.setSize(660, 660); //Set size to 400x400 pixels
//		pane = frmMain.getContentPane(); //Get content pane
//		pane.setLayout(null); //Apply null layout
		setLayout(null); //Apply null layout
//		frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Close when X is clicked

		//Create controls
		lblMonth = new JLabel ("January");
		lblYear = new JLabel ("Year:");
		cmbYear = new JComboBox();
		btnPrev = new JButton ("<<");
		btnNext = new JButton (">>");
		mtblCalendar = new DefaultTableModel(){/**
			 *
			 */
			private static final long serialVersionUID = 1L;

		public boolean isCellEditable(int rowIndex, int mColIndex){return false;}};
		tblCalendar = new JTable(mtblCalendar);
		stblCalendar = new JScrollPane(tblCalendar);
		pnlCalendar = new JPanel(null);


		//Set border
		pnlCalendar.setBorder(BorderFactory.createTitledBorder(" "));

		//Register action listeners
		btnPrev.addActionListener(new btnPrev_Action());
		btnNext.addActionListener(new btnNext_Action());
		cmbYear.addActionListener(new cmbYear_Action());

		//Add controls to pane
//		pane.add(pnlCalendar);
		add(pnlCalendar);
		pnlCalendar.add(lblMonth);
		pnlCalendar.add(lblYear);
		pnlCalendar.add(cmbYear);
		pnlCalendar.add(btnPrev);
		pnlCalendar.add(btnNext);
		pnlCalendar.add(stblCalendar);

		//Set bounds
		pnlCalendar.setBounds(69, 11, 441, 301);
		lblMonth.setBounds(70, 25, 100, 25);
		lblYear.setBounds(323, 27, 32, 20);
		cmbYear.setBounds(359, 27, 80, 20);
		btnPrev.setBounds(10, 25, 50, 25);
		btnNext.setBounds(260, 25, 50, 25);
		stblCalendar.setBounds(10, 61, 345, 225);
		btnResults.setBounds(260, 25, 50, 25);

		//Make frame visible
//		frmMain.setResizable(false);
//		frmMain.setVisible(true);

		//Get real month/year
		GregorianCalendar cal = new GregorianCalendar(); //Create calendar
		realDay = cal.get(GregorianCalendar.DAY_OF_MONTH); //Get day
		realMonth = cal.get(GregorianCalendar.MONTH); //Get month
		realYear = cal.get(GregorianCalendar.YEAR); //Get year
		currentMonth = realMonth; //Match month and year
		currentYear = realYear;

		//Add headers
		String[] headers = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"}; //All headers
		for (int i=0; i<7; i++){
			mtblCalendar.addColumn(headers[i]);
		}

		tblCalendar.getParent().setBackground(tblCalendar.getBackground()); //Set background

		//No resize/reorder
		tblCalendar.getTableHeader().setResizingAllowed(false);
		tblCalendar.getTableHeader().setReorderingAllowed(false);

		//Single cell selection
		tblCalendar.setColumnSelectionAllowed(true);
		tblCalendar.setRowSelectionAllowed(true);
		tblCalendar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		//Set row/column count
		tblCalendar.setRowHeight(38);

		JPanel pnlGetData = new JPanel();
		pnlGetData.setBounds(51, 353, 459, 38);
		add(pnlGetData);

		JLabel lblNewLabel = new JLabel("Pick Date:");
		pnlGetData.add(lblNewLabel);

		JDateChooser dateChooser = new JDateChooser();
		pnlGetData.add(dateChooser);

		JButton btnResults = new JButton("See log");
		pnlGetData.add(btnResults);

		JPanel panel = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		panel.setBounds(178, 402, 151, 29);
		add(panel);

		lblNewLabel_1 = new JLabel("Pushups:");
		panel.add(lblNewLabel_1);

		JLabel lblPushups = new JLabel("");
		panel.add(lblPushups);
		lblPushups.setHorizontalAlignment(SwingConstants.TRAILING);

		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel_1.setBounds(188, 442, 151, 24);
		add(panel_1);

		JLabel lblNewLabel_2 = new JLabel("Situps:");
		panel_1.add(lblNewLabel_2);

		JLabel lblSitups = new JLabel("");
		panel_1.add(lblSitups);

		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_2.setBounds(178, 479, 151, 29);
		add(panel_2);

		JLabel lblNewLabel_3 = new JLabel("Running:");
		panel_2.add(lblNewLabel_3);

		JLabel lblRunning = new JLabel("");
		panel_2.add(lblRunning);
		mtblCalendar.setColumnCount(7);
		mtblCalendar.setRowCount(6);

		//Populate table
		for (int i=realYear-100; i<=realYear+100; i++){
			cmbYear.addItem(String.valueOf(i));
		}

		//Refresh calendar
		refreshCalendar (realMonth, realYear); //Refresh calendar
	}

	public static void refreshCalendar(int month, int year){
		//Variables
		String[] months =  {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		int nod, som; //Number Of Days, Start Of Month

		//Allow/disallow buttons
		btnPrev.setEnabled(true);
		btnNext.setEnabled(true);
		btnResults.setEnabled(true);
		if (month == 0 && year <= realYear-10){btnPrev.setEnabled(false);} //Too early
		if (month == 11 && year >= realYear+100){btnNext.setEnabled(false);} //Too late
		lblMonth.setText(months[month]); //Refresh the month label (at the top)
		lblMonth.setBounds(160-lblMonth.getPreferredSize().width/2, 25, 180, 25); //Re-align label with calendar
		cmbYear.setSelectedItem(String.valueOf(year)); //Select the correct year in the combo box

		//Clear table
		for (int i=0; i<6; i++){
			for (int j=0; j<7; j++){
				mtblCalendar.setValueAt(null, i, j);
			}
		}

		//Get first day of month and number of days
		GregorianCalendar cal = new GregorianCalendar(year, month, 1);
		nod = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
		som = cal.get(GregorianCalendar.DAY_OF_WEEK);

		//Draw calendar
		for (int i=1; i<=nod; i++){
			int row = new Integer((i+som-2)/7);
			int column  =  (i+som-2)%7;
			mtblCalendar.setValueAt(i, row, column);
		}

		//Apply renderers
		tblCalendar.setDefaultRenderer(tblCalendar.getColumnClass(0), new tblCalendarRenderer());
	}

	static class tblCalendarRenderer extends DefaultTableCellRenderer{
		/**
		 *
		 */
		private static final long serialVersionUID = 1L;

		public Component getTableCellRendererComponent (JTable table, Object value, boolean selected, boolean focused, int row, int column){
			super.getTableCellRendererComponent(table, value, selected, focused, row, column);
			if (column == 0 || column == 6){ //Week-end
				setBackground(new Color(255, 220, 220));
			}
			else{ //Week
				setBackground(new Color(255, 255, 255));
			}
			if (value != null){
				if (Integer.parseInt(value.toString()) == realDay && currentMonth == realMonth && currentYear == realYear){ //Today
					setBackground(new Color(220, 220, 255));
				}
			}
			setBorder(null);
			setForeground(Color.black);
			return this;
		}
	}

	static class btnPrev_Action implements ActionListener{
		public void actionPerformed (ActionEvent e){
			if (currentMonth == 0){ //Back one year
				currentMonth = 11;
				currentYear -= 1;
			}
			else{ //Back one month
				currentMonth -= 1;
			}
			refreshCalendar(currentMonth, currentYear);
		}
	}
	static class btnNext_Action implements ActionListener{
		public void actionPerformed (ActionEvent e){
			if (currentMonth == 11){ //Forward one year
				currentMonth = 0;
				currentYear += 1;
			}
			else{ //Forward one month
				currentMonth += 1;
			}
			refreshCalendar(currentMonth, currentYear);
		}
	}
	static class cmbYear_Action implements ActionListener{
		public void actionPerformed (ActionEvent e){
			if (cmbYear.getSelectedItem() != null){
				String b = cmbYear.getSelectedItem().toString();
				currentYear = Integer.parseInt(b);
				refreshCalendar(currentMonth, currentYear);
			}
		}
	}
	private Connection connect() {
		// db parameters
		String url = "jdbc:sqlite:C:\\Users\\Qen Yoogle\\Downloads\\Fitness-Journal-master\\Fitness-Journal-master\\journal\\lib\\sql";
	    //create a connection to the database
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	static class bntResults_Action implements ActionListener{
		public void actionPerformed (ActionEvent e){
			SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");
			String datepicked = dFormat.format(dateChooser.getDate());
            String getNumbers="SELECT Pushups, Situps, Running " + "FROM DailyTracker WHERE Date = datepicked";

			try(Connection conn = this.connect();
                PreparedStatement pstmt=conn.prepareStatement(getNumbers)){

                ResultSet rs = pstmt.executeQuery();

                // loop through the result set
                while(rs.next()) {
                    lblPushups.setText(""+rs.getString("Pushups"));
                    lblSitups.setText(""+rs.getString("Situps"));
                    lblRunning.setText(""+rs.getString("Running"));
                }
             }﻿ catch (SQLException e) {
            	 System.out.println(e.getMessage());
             }
		}
	}
}
