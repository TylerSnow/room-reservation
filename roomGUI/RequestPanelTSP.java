package roomGUI;

import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;

public class RequestPanelTSP extends JPanel {
	private final MainFrame2 frame;
	private JPanel mainPanel;
	private String timeSlotStart;
	private String timeSlotEnd;
	private String day;
	private String priority;
	private JTextField txtChooseATimeslot;
	private JTextField txtChooseEndTimeslot;
	private JTextField txtChooseADay;
	private JTextField txtPriority;
	private PriorityIncrementer priInc;
	/**
	 * Create the panel.
	 */
	public RequestPanelTSP(MainFrame2 f) {
		frame=f;
		mainPanel = new JPanel();
		add(mainPanel);
		
		priInc= new PriorityIncrementer();
		
		String[] timeSlots = {"00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00",
				"09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00",
				"20:00", "21:00", "22:00", "23:00"};
		
		String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
		String[] priorities= {"1","2","3","4","5"};
		
		GridBagLayout gbl_mainPanel = new GridBagLayout();
		gbl_mainPanel.columnWidths = new int[]{0, 0, 0};
		gbl_mainPanel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_mainPanel.columnWeights = new double[]{1.0, 1.0, 0.0};
		gbl_mainPanel.rowWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0};
		mainPanel.setLayout(gbl_mainPanel);
		
		JLabel txtChooseATimeslot = new JLabel("Choose a start time.");
		GridBagConstraints gbc_txtChooseATimeslot = new GridBagConstraints();
		gbc_txtChooseATimeslot.insets = new Insets(0, 0, 5, 5);
		gbc_txtChooseATimeslot.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtChooseATimeslot.gridx = 1;
		gbc_txtChooseATimeslot.gridy = 0;
		mainPanel.add(txtChooseATimeslot, gbc_txtChooseATimeslot);
		
		JScrollPane sTimePane = new JScrollPane();
		GridBagConstraints gbc_sTimePane = new GridBagConstraints();
		gbc_sTimePane.fill = GridBagConstraints.BOTH;
		gbc_sTimePane.insets = new Insets(0, 0, 5, 5);
		gbc_sTimePane.gridx = 1;
		gbc_sTimePane.gridy = 1;
		mainPanel.add(sTimePane, gbc_sTimePane);
		
		JList timeList = new JList(timeSlots);
		sTimePane.setViewportView(timeList);
		timeList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				timeSlotStart=timeSlots[timeList.getSelectedIndex()];
			}
		});
	
		timeList.setVisibleRowCount(5);
		//Can possibly be modified to have multiple selections at once.
		timeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JLabel txtChooseEndTimeslot = new JLabel("Choose an end time.");
		GridBagConstraints gbc_txtChooseEndTimeslot = new GridBagConstraints();
		gbc_txtChooseEndTimeslot.insets = new Insets(0, 0, 5, 0);
		gbc_txtChooseEndTimeslot.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtChooseEndTimeslot.gridx = 2;
		gbc_txtChooseEndTimeslot.gridy = 0;
		mainPanel.add(txtChooseEndTimeslot, gbc_txtChooseEndTimeslot);
		
		JScrollPane sEndTimePane = new JScrollPane();
		GridBagConstraints gbc_sEndTimePane = new GridBagConstraints();
		gbc_sEndTimePane.fill = GridBagConstraints.BOTH;
		gbc_sEndTimePane.insets = new Insets(0, 0, 5, 0);
		gbc_sEndTimePane.gridx = 2;
		gbc_sEndTimePane.gridy = 1;
		mainPanel.add(sEndTimePane, gbc_sEndTimePane);
		
				
				JList timeEndList = new JList(timeSlots);
				sEndTimePane.setViewportView(timeEndList);
				timeEndList.addListSelectionListener(new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent e) {
						timeSlotEnd=timeSlots[timeEndList.getSelectedIndex()];
					}
				});
	
		timeEndList.setVisibleRowCount(5);
		//Can possibly be modified to have multiple selections at once.
		timeEndList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JLabel txtChooseADay = new JLabel("Choose a Day");
		GridBagConstraints gbc_txtChooseADay = new GridBagConstraints();
		gbc_txtChooseADay.insets = new Insets(0, 0, 5, 5);
		gbc_txtChooseADay.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtChooseADay.gridx = 1;
		gbc_txtChooseADay.gridy = 2;
		mainPanel.add(txtChooseADay, gbc_txtChooseADay);
		
		JScrollPane sDayPane = new JScrollPane();
		GridBagConstraints gbc_sDayPane = new GridBagConstraints();
		gbc_sDayPane.fill = GridBagConstraints.BOTH;
		gbc_sDayPane.insets = new Insets(0, 0, 5, 5);
		gbc_sDayPane.gridx = 1;
		gbc_sDayPane.gridy = 3;
		mainPanel.add(sDayPane, gbc_sDayPane);
		
				JList dayList = new JList(days);
				sDayPane.setViewportView(dayList);
				dayList.addListSelectionListener(new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent e) {
						day=days[dayList.getSelectedIndex()];
					}
				});
	
		dayList.setVisibleRowCount(3);
		dayList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					frame.reqShow();
			}
		});
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.anchor = GridBagConstraints.EAST;
		gbc_btnBack.insets = new Insets(0, 0, 0, 5);
		gbc_btnBack.gridx = 0;
		gbc_btnBack.gridy = 4;
		mainPanel.add(btnBack, gbc_btnBack);
		
		JButton btnNextRequest = new JButton("Next Request");
		btnNextRequest.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (priInc.getInc()>=0) {
					priInc.removePri();
					frame.reqShow();
					
				}
				else {
					System.out.println("Cannot make more requests.");
				}
			}
		});
		GridBagConstraints gbc_btnNextRequest = new GridBagConstraints();
		gbc_btnNextRequest.anchor = GridBagConstraints.EAST;
		gbc_btnNextRequest.insets = new Insets(0, 0, 0, 5);
		gbc_btnNextRequest.gridx = 1;
		gbc_btnNextRequest.gridy = 4;
		mainPanel.add(btnNextRequest, gbc_btnNextRequest);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Request req=new Request(new Applicant(test.school.Applicant.getID(),test.school.Applicant.getID()),
				//		newBooking(timeSlotStart,timeSlotEnd,test.school.Group.getName()),Integer.parseInt(priority),
				//		readInFile,day);
				//Return to HomePanel
				frame.displayHome();
				frame.hideApp();
			}
		});
		GridBagConstraints gbc_btnSubmit = new GridBagConstraints();
		gbc_btnSubmit.gridx = 2;
		gbc_btnSubmit.gridy = 4;
		mainPanel.add(btnSubmit, gbc_btnSubmit);
		
	}

}
