package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.AccessLayer;
import model.Applicant;

import view.AddApplicantPanel;

public class AddApplicantListener implements ActionListener{ 

	private MainController controller;
	
	
	public AddApplicantListener(MainController controller) {
		
		this.controller = controller;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		
		if(event.getSource() == controller.addApplicantView.addButton) {
			try{
				Applicant applicant = new Applicant(AddApplicantPanel.getInstance().dateSourcedCB.getDate(), AddApplicantPanel.getInstance().dateProcessedCB.getDate(),
							AddApplicantPanel.getInstance().firstName_TF.getText().trim(), AddApplicantPanel.getInstance().lastName_TF.getText().trim(),
							AddApplicantPanel.getInstance().primaryNum_TF.getText().trim(), AddApplicantPanel.getInstance().secNum_TF.getText().trim(),
							AddApplicantPanel.getInstance().school_TF.getText().trim(), AddApplicantPanel.getInstance().lastPos_TF.getText().trim(),
							AddApplicantPanel.getInstance().jobClassCB.getSelectedItem().toString(), AddApplicantPanel.getInstance().lastComp_TF.getText().trim(),
							AddApplicantPanel.getInstance().email_TF.getText().trim(), AddApplicantPanel.getInstance().source_TF.getText().trim(),
							AddApplicantPanel.getInstance().specifics_TF.getText().trim(), AddApplicantPanel.getInstance().posEndorsed_TF.getText().trim(),
							AddApplicantPanel.getInstance().statusCB.getSelectedItem().toString(), AddApplicantPanel.getInstance().schedDateCB.getDate(),
							AddApplicantPanel.getInstance().schedTime_TF.getText().trim(), AddApplicantPanel.getInstance().schedOutcomeCB.getSelectedItem().toString(),
							AddApplicantPanel.getInstance().reschedDateCB.getDate(), AddApplicantPanel.getInstance().reschedTime_TF.getText().trim(),
							AddApplicantPanel.getInstance().reschedOutcomeCB.getSelectedItem().toString(), AddApplicantPanel.getInstance().recruiter_TF.getText().trim(),
							AddApplicantPanel.getInstance().clientName_TF.getText().trim(), AddApplicantPanel.getInstance().clientResultCB.getSelectedItem().toString(),
							AddApplicantPanel.getInstance().remarks_TA.getText().trim(), AddApplicantPanel.getInstance().actualRevenue_TF.getText().trim(),
							AddApplicantPanel.getInstance().cvPath_TF.getText().trim());
				System.out.println(applicant.getDateSourced());
				if(!isValidTime(applicant.getSchedTime()) || !isValidTime(applicant.getReschedTime()))
					throw new Exception();
				else{
					if(!applicantAlreadyExist(applicant)){
						applicant.addToDatabase();
						AddApplicantPanel.getInstance().clearFields();
					}
				}
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "Error!", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		else if(event.getSource() == controller.addApplicantView.backButton) {
		}
	}
	
	private boolean applicantAlreadyExist(Applicant applicant) {
		ResultSet result = AccessLayer.getInstance().executeQuery("select email from applicant_info where `last_name`='"+applicant.insertBackSlash(applicant.getLastname())+"' AND `first_name`='"+applicant.insertBackSlash(applicant.getFirstname())+"';");
		try {
			while(result.next()){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	private boolean isValidTime(String time){
		String str1[] = time.split(":");
		String str2[] = str1[1].split(" ");
		
		System.out.print(""+str1[0]+", "+str1[1]+", "+str2[0]+", "+str2[1]+"");
		
		if((isNum(str1[0]) && str1[0].length()<=2 && str1[0].length()>0 && isNum(str2[0]) && str2[0].length()<=2 && str2[0].length()>0 && isValid(str2[1]) && str2[1].length()<=2 && str2[1].length()>0) || time.equals(""))
			return true;
		return false;
	}
	
	private boolean isNum(String num){
		try  
		  {  
		    int d = Integer.parseInt(num);  
		  }  
		  catch(NumberFormatException nfe)  
		  {  
		    return false;  
		  }  
		  return true;  
	}
	
	private boolean isValid(String str){
		if(str.equalsIgnoreCase("am") || str.equalsIgnoreCase("pm") || str.equalsIgnoreCase("nn") || str.equalsIgnoreCase("mn"))
			return true;
		return false;
	}
}