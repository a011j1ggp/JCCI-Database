package view;

import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import model.Date;
import java.awt.Rectangle;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;

public class AddApplicantPanel extends JPanel{
	
	public JTextField firstName_TF, lastName_TF, primaryNum_TF, secNum_TF, school_TF, lastPos_TF, lastComp_TF, email_TF, source_TF, specifics_TF, posEndorsed_TF,
						schedTime_TF, reschedTime_TF, recruiter_TF, clientName_TF, actualRevenue_TF, cvPath_TF;
	public Date dateSourcedCB, dateProcessedCB, schedDateCB, reschedDateCB  ;
	public JButton addButton, backButton;
	public JTextArea remarks_TA;
	
	private static AddApplicantPanel instance;
	private JLabel sourcedLbl, processedLbl, firstNameLbl, lastNameLbl, schoolLbl, lastPosLbl, emailLbl, sourceLbl, specificsLbl, posEndorsedLbl, statusLbl,
			schedTimeLbl, schedOutcomeLbl;
	
	@SuppressWarnings("rawtypes")
	public JComboBox statusCB, schedOutcomeCB, jobClassCB, reschedOutcomeCB, clientResultCB ;
	
	public static AddApplicantPanel getInstance(){
		if(instance == null)
			instance = new AddApplicantPanel();
		return instance;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public AddApplicantPanel() {
		setBounds(new Rectangle(0, 0, 900, 700));
		setLayout(null);
		
		sourcedLbl = new JLabel("Date Sourced");
		sourcedLbl.setBounds(10, 11, 70, 14);
		add(sourcedLbl);
		
		dateSourcedCB = new Date();
		dateSourcedCB.setBounds(10, 28, 186, 30);
		dateSourcedCB.day.setBounds(51, 5, 40, 20);
		dateSourcedCB.month.setBounds(0, 5, 41, 20);
		dateSourcedCB.year.setBorder(new LineBorder(Color.WHITE));
		dateSourcedCB.year.setBounds(101, 5, 70, 20);
		add(dateSourcedCB);
		
		processedLbl = new JLabel("Date Processed");
		processedLbl.setBounds(10, 69, 90, 14);
		add(processedLbl);
		
		dateProcessedCB = new Date();
		dateProcessedCB.setBounds(10, 87, 186, 30);
		dateProcessedCB.day.setBounds(51, 5, 40, 20);
		dateProcessedCB.month.setBounds(0, 5, 41, 20);
		dateProcessedCB.year.setBorder(new LineBorder(Color.WHITE));
		dateProcessedCB.year.setBounds(101, 5, 70, 20);
		add(dateProcessedCB);
		
		firstName_TF = new JTextField();
		firstName_TF.setMinimumSize(new Dimension(20, 20));
		firstName_TF.setColumns(10);
		firstName_TF.setBounds(279, 11, 166, 24);
		add(firstName_TF);
		
		firstNameLbl = new JLabel("First Name");
		firstNameLbl.setBounds(224, 16, 70, 14);
		add(firstNameLbl);
		
		lastName_TF = new JTextField();
		lastName_TF.setMinimumSize(new Dimension(20, 20));
		lastName_TF.setColumns(10);
		lastName_TF.setBounds(510, 11, 166, 24);
		add(lastName_TF);
		
		lastNameLbl = new JLabel("Last Name");
		lastNameLbl.setBounds(451, 16, 70, 14);
		add(lastNameLbl);
		
		primaryNum_TF = new JTextField();
		primaryNum_TF.setMinimumSize(new Dimension(20, 20));
		primaryNum_TF.setColumns(10);
		primaryNum_TF.setBounds(736, 11, 154, 24);
		add(primaryNum_TF);
		
		JLabel primNumLbl = new JLabel("Prim. #");
		primNumLbl.setBounds(693, 16, 41, 14);
		add(primNumLbl);
		
		secNum_TF = new JTextField();
		secNum_TF.setMinimumSize(new Dimension(20, 20));
		secNum_TF.setColumns(10);
		secNum_TF.setBounds(262, 46, 154, 24);
		add(secNum_TF);
		
		JLabel secNumLbl = new JLabel("Sec. #");
		secNumLbl.setBounds(224, 51, 41, 14);
		add(secNumLbl);
		
		school_TF = new JTextField();
		school_TF.setMinimumSize(new Dimension(20, 20));
		school_TF.setColumns(10);
		school_TF.setBounds(461, 46, 195, 24);
		add(school_TF);
		
		schoolLbl = new JLabel("School");
		schoolLbl.setBounds(426, 51, 41, 14);
		add(schoolLbl);
		
		lastPosLbl = new JLabel("C/L Pos");
		lastPosLbl.setBounds(665, 51, 41, 14);
		add(lastPosLbl);
		
		lastPos_TF = new JTextField();
		lastPos_TF.setMinimumSize(new Dimension(20, 20));
		lastPos_TF.setColumns(10);
		lastPos_TF.setBounds(703, 46, 187, 24);
		add(lastPos_TF);
		
		JLabel jobClassLbl = new JLabel("Job Classification");
		jobClassLbl.setBounds(10, 133, 82, 14);
		add(jobClassLbl);
		
		jobClassCB = new JComboBox();
		jobClassCB.setModel(new DefaultComboBoxModel(new String[] {"Agent", "Non-Agent", "Unclassified"}));
		jobClassCB.setBounds(102, 128, 94, 24);
		add(jobClassCB);
		
		lastComp_TF = new JTextField();
		lastComp_TF.setMinimumSize(new Dimension(20, 20));
		lastComp_TF.setColumns(10);
		lastComp_TF.setBounds(294, 93, 187, 24);
		add(lastComp_TF);
		
		JLabel lastCompLbl = new JLabel("C/L Company");
		lastCompLbl.setBounds(220, 98, 64, 14);
		add(lastCompLbl);
		
		email_TF = new JTextField();
		email_TF.setMinimumSize(new Dimension(20, 20));
		email_TF.setColumns(10);
		email_TF.setBounds(518, 93, 166, 24);
		add(email_TF);
		
		emailLbl = new JLabel("Email");
		emailLbl.setBounds(491, 98, 41, 14);
		add(emailLbl);
		
		source_TF = new JTextField();
		source_TF.setMinimumSize(new Dimension(20, 20));
		source_TF.setColumns(10);
		source_TF.setBounds(736, 93, 150, 24);
		add(source_TF);
		
		sourceLbl = new JLabel("Source");
		sourceLbl.setBounds(695, 98, 41, 14);
		add(sourceLbl);
		
		specifics_TF = new JTextField();
		specifics_TF.setMinimumSize(new Dimension(20, 20));
		specifics_TF.setColumns(10);
		specifics_TF.setBounds(304, 128, 154, 24);
		add(specifics_TF);
		
		specificsLbl = new JLabel("Source Specifics");
		specificsLbl.setBounds(224, 133, 82, 14);
		add(specificsLbl);
		
		posEndorsed_TF = new JTextField();
		posEndorsed_TF.setMinimumSize(new Dimension(20, 20));
		posEndorsed_TF.setColumns(10);
		posEndorsed_TF.setBounds(528, 128, 166, 24);
		add(posEndorsed_TF);
		
		posEndorsedLbl = new JLabel("Position End.");
		posEndorsedLbl.setBounds(462, 133, 70, 14);
		add(posEndorsedLbl);
		
		statusLbl = new JLabel("Status");
		statusLbl.setBounds(705, 133, 64, 14);
		add(statusLbl);
		
		statusCB = new JComboBox();
		statusCB.setModel(new DefaultComboBoxModel(new String[] {"Not Interested", "Already Tapped", "Can't Contact", "Declined", "Failed", "Scheduled", "Call Back - SMS Sent", "No Answer - SMS Sent"}));
		statusCB.setBounds(746, 128, 144, 24);
		add(statusCB);
		
		schedDateCB = new Date();
		schedDateCB.year.setBorder(new LineBorder(Color.WHITE));
		schedDateCB.setBounds(10, 185, 186, 30);
		schedDateCB.day.setBounds(51, 5, 40, 20);
		schedDateCB.month.setBounds(0, 5, 41, 20);
		schedDateCB.year.setBorder(new LineBorder(Color.WHITE));
		schedDateCB.year.setBounds(101, 5, 70, 20);
		add(schedDateCB);
		
		JLabel schedDateLbl = new JLabel("Sched. Date");
		schedDateLbl.setBounds(10, 168, 70, 14);
		add(schedDateLbl);
		
		schedTime_TF = new JTextField();
		schedTime_TF.setMinimumSize(new Dimension(20, 20));
		schedTime_TF.setColumns(10);
		schedTime_TF.setBounds(291, 163, 70, 24);
		add(schedTime_TF);
		
		schedTimeLbl = new JLabel("Sched. Time");
		schedTimeLbl.setBounds(224, 168, 82, 14);
		add(schedTimeLbl);
		
		schedOutcomeCB = new JComboBox();
		schedOutcomeCB.setModel(new DefaultComboBoxModel(new String[] {"No show - No answer", "No show - Call declined", "No show - Can't contact", "Endorsed", "Rescheduled", "Failed IDI", "Failed EP Interview", "Withdrew Application", "Failed VERSANT", "Declined Offer", "Active File"}));
		schedOutcomeCB.setBounds(455, 163, 144, 24);
		add(schedOutcomeCB);
		
		schedOutcomeLbl = new JLabel("Sched. Outcome");
		schedOutcomeLbl.setBounds(371, 168, 87, 14);
		add(schedOutcomeLbl);
		
		JLabel reschedDateLbl = new JLabel("Resched. date");
		reschedDateLbl.setBounds(10, 227, 70, 14);
		add(reschedDateLbl);
		
		reschedDateCB = new Date();
		reschedDateCB.year.setBorder(new LineBorder(Color.WHITE));
		reschedDateCB.setBounds(10, 244, 186, 30);
		reschedDateCB.day.setBounds(51, 5, 40, 20);
		reschedDateCB.month.setBounds(0, 5, 41, 20);
		reschedDateCB.year.setBorder(new LineBorder(Color.WHITE));
		reschedDateCB.year.setBounds(101, 5, 70, 20);
		add(reschedDateCB);
		
		JLabel reschedTimeLbl = new JLabel("Resched. Time");
		reschedTimeLbl.setBounds(609, 168, 82, 14);
		add(reschedTimeLbl);
		
		reschedTime_TF = new JTextField();
		reschedTime_TF.setMinimumSize(new Dimension(20, 20));
		reschedTime_TF.setColumns(10);
		reschedTime_TF.setBounds(686, 163, 70, 24);
		add(reschedTime_TF);
		
		JLabel reschedOutcomeLbl = new JLabel("Resched. Outcome");
		reschedOutcomeLbl.setBounds(224, 203, 94, 14);
		add(reschedOutcomeLbl);
		
		reschedOutcomeCB = new JComboBox();
		reschedOutcomeCB.setModel(new DefaultComboBoxModel(new String[] {"No show - No answer", "No show - Call declined", "No show - Can't contact", "Endorsed", "Rescheduled", "Failed IDI", "Failed EP Interview", "Withdrew Application", "Failed VERSANT", "Declined Offer", "Active File"}));
		reschedOutcomeCB.setBounds(323, 198, 144, 24);
		add(reschedOutcomeCB);
		
		recruiter_TF = new JTextField();
		recruiter_TF.setMinimumSize(new Dimension(20, 20));
		recruiter_TF.setColumns(10);
		recruiter_TF.setBounds(518, 198, 166, 24);
		add(recruiter_TF);
		
		JLabel recruiterLbl = new JLabel("Recruiter");
		recruiterLbl.setBounds(474, 203, 50, 14);
		add(recruiterLbl);
		
		clientName_TF = new JTextField();
		clientName_TF.setMinimumSize(new Dimension(20, 20));
		clientName_TF.setColumns(10);
		clientName_TF.setBounds(756, 198, 134, 24);
		add(clientName_TF);
		
		JLabel clientNameLbl = new JLabel("Client Name");
		clientNameLbl.setBounds(696, 203, 70, 14);
		add(clientNameLbl);
		
		clientResultCB = new JComboBox();
		clientResultCB.setModel(new DefaultComboBoxModel(new String[] {"Failed Client Interview", "SP", "Declined Offer", "Withdrawn"}));
		clientResultCB.setBounds(294, 239, 144, 24);
		add(clientResultCB);
		
		JLabel clientResultLbl = new JLabel("Client Result");
		clientResultLbl.setBounds(224, 244, 70, 14);
		add(clientResultLbl);
		
		JLabel remarksLbl = new JLabel("Remarks");
		remarksLbl.setBounds(10, 298, 46, 14);
		add(remarksLbl);
		
		remarks_TA = new JTextArea();
		remarks_TA.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		remarks_TA.setBounds(10, 319, 205, 89);
		add(remarks_TA);
		
		actualRevenue_TF = new JTextField();
		actualRevenue_TF.setMinimumSize(new Dimension(20, 20));
		actualRevenue_TF.setColumns(10);
		actualRevenue_TF.setBounds(553, 244, 166, 24);
		add(actualRevenue_TF);
		
		JLabel actualRevenueLbl = new JLabel("Actual Revenue");
		actualRevenueLbl.setBounds(474, 249, 82, 14);
		add(actualRevenueLbl);
		
		cvPath_TF = new JTextField();
		cvPath_TF.setMinimumSize(new Dimension(20, 20));
		cvPath_TF.setColumns(10);
		cvPath_TF.setBounds(262, 319, 166, 24);
		add(cvPath_TF);
		
		JLabel cvPathLbl = new JLabel("CV Path");
		cvPathLbl.setBounds(260, 298, 46, 14);
		add(cvPathLbl);
		
		JButton cvButton = new JButton("Import CV");
		cvButton.setBounds(262, 351, 89, 23);
		add(cvButton);
		
		addButton = new JButton("Add");
		addButton.setBounds(757, 618, 133, 30);
		add(addButton);
		
		backButton = new JButton("Back");
		backButton.setBounds(757, 659, 133, 30);
		add(backButton);
	}
	
	public void clearFields(){
		dateProcessedCB.reset();
		dateSourcedCB.reset();
		firstName_TF.setText("");
		lastName_TF.setText("");
		primaryNum_TF.setText("");
		secNum_TF.setText("");
		school_TF.setText("");
		lastPos_TF.setText("");
		jobClassCB.setSelectedIndex(0);
		lastComp_TF.setText("");
		email_TF.setText("");
		source_TF.setText("");
		specifics_TF.setText("");
		posEndorsed_TF.setText("");
		statusCB.setSelectedIndex(0);
		schedDateCB.reset();
		schedTime_TF.setText("");
		schedOutcomeCB.setSelectedIndex(0);
		reschedDateCB.reset();
		reschedTime_TF.setText("");
		reschedOutcomeCB.setSelectedIndex(0);
		recruiter_TF.setText("");
		clientName_TF.setText("");
		clientResultCB.setSelectedIndex(0);
		remarks_TA.setText("");
		actualRevenue_TF.setText("");
		cvPath_TF.setText("");
	}
}
