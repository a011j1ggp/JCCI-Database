package model;

public class Applicant {
	
	private String date_processed, date_sourced, first_name, last_name, primary_mobile, secondary_mobile, school, last_position, job_classification, 
			last_company, email, source, specifics, pos_endorsed, status, sched_date, sched_time, sched_outcome, resched_date, resched_time, resched_outcome,
			recruiter, endorsed_client, client_result, remarks, actual_revenue, cv_path;
	
	private String tableName = "applicant_info(`date_sourced`,`date_processed`,`first_name`,`last_name`,`primary_mobile`,`secondary_mobile`,`school`," +
			"`last_position`,`job_classification`,`last_company`,`email`,`source`,`source_specifics`,`position_endorsed`,`status`,`sched_date`,`sched_time`," +
			"`sched_outcome`,`resched_date`,`resched_time`,`resched_outcome`,`recruiter`,`endorsed_client`,`client_result`,`remarks`,`actual_revenue`,`cv_path`)";
	
	public Applicant(String date_sourced, String date_processed, String first_name, String last_name, String primary_mobile, String secondary_mobile, 
						String school, String last_position, String job_classification, String last_company, String email, String source, String specifics,
						String pos_endorsed, String status, String sched_date, String sched_time, String sched_outcome, String resched_date, String resched_time, 
						String resched_outcome, String recruiter, String endorsed_client, String client_result, String remarks, String actual_revenue, String cv_path){
	
		this.date_sourced = date_sourced;
		this.date_processed = date_processed;
		this.first_name = first_name;
		this.last_name = last_name;
		this.primary_mobile = primary_mobile;
		this.secondary_mobile = secondary_mobile;
		this.school = school;
		this.last_position = last_position;
		this.job_classification = job_classification;
		this.last_company = last_company;
		this.email = email;
		this.source = source;
		this.specifics = specifics;
		this.pos_endorsed = pos_endorsed;
		this.status = status;
		this.sched_date = sched_date;
		this.sched_time = sched_time;
		this.sched_outcome = sched_outcome;
		this.resched_date = resched_date;
		this.resched_time = resched_time;
		this.resched_outcome = resched_outcome;
		this.recruiter = recruiter;
		this.endorsed_client = endorsed_client;
		this.client_result = client_result;
		this.remarks = remarks;
		this.actual_revenue = actual_revenue;
		this.cv_path = cv_path;
	}
	
	public String insertBackSlash(String str) {
		String res = "";
		for(int i = 0; i < str.length();i++)
			if(str.charAt(i)=='\'' || str.charAt(i) == '\\')
				res+="\\"+str.charAt(i);
			else
				res+=str.charAt(i);
		return res;
	}
	
	public void addToDatabase(){
		String values = "'"+date_sourced+"', '"+date_processed+"', '"+insertBackSlash(first_name)+"', '"+insertBackSlash(last_name)+"'," +
				"'"+primary_mobile+"','"+secondary_mobile+"','"+insertBackSlash(school)+"','"+insertBackSlash(last_position)+"', '"+job_classification+"'," +
				"'"+insertBackSlash(last_company)+"', '"+insertBackSlash(email)+"','"+insertBackSlash(source)+"','"+insertBackSlash(specifics)+"'," +
				"'"+insertBackSlash(pos_endorsed)+"','"+status+"','"+sched_date+"', '"+insertBackSlash(sched_time)+"', '"+insertBackSlash(sched_outcome)+"'," +
				"'"+resched_date+"', '"+insertBackSlash(resched_time)+"', '"+insertBackSlash(resched_outcome)+"', '"+insertBackSlash(recruiter)+"'," +
				"'"+insertBackSlash(endorsed_client)+"', '"+insertBackSlash(client_result)+"', '"+insertBackSlash(remarks)+"', '"+insertBackSlash(actual_revenue)+"'," +
				"'"+insertBackSlash(cv_path)+"'";
		AccessLayer.getInstance().addApplicantToDatabase(tableName, values);
	}
	
	public String getDateProcessed(){
		return date_processed;
	}
	
	public String getDateSourced(){
		return date_sourced;
	}
	
	public String getFirstname(){
		return first_name;
	}
	
	public String getLastname(){
		return last_name;	
	}
	
	public String getPrimaryNumber(){
		return primary_mobile;
	}
	
	public String getSecondaryNumber(){
		return secondary_mobile;
	}
	
	public String getSchool(){
		return school;
	}
	
	public String getLastPosition(){
		return last_position;
	}
	
	public String getJobClassification(){
		return job_classification;
	}
	
	public String getLastCompany(){
		return last_company;
	}
	
	public String getEmail(){
		return email;
	}
	
	public String getSource(){
		return source;
	}
	
	public String getSpecifics(){
		return specifics;
	}
	
	public String getPositionEndorsed(){
		return pos_endorsed;
	}
	
	public String getStatus(){
		return status;
	}
	
	public String getSchedDate(){
		return sched_date;
	}
	
	public String getSchedTime(){
		return sched_time;
	}
	
	public String getSchedOutcome(){
		return sched_outcome;
	}
	
	public String getReschedDate(){
		return resched_date;
	}
	
	public String getReschedTime(){
		return resched_time;
	}
	
	public String getReschedOutcome(){
		return resched_outcome;
	}
	
	public String getRecruiter(){
		return recruiter;
	}
	
	public String getEndorsedClient(){
		return endorsed_client;
	}
	
	public String getClientResult(){
		return client_result;
	}
	
	public String getRemarks(){
		return remarks;
	}
	
	public String getActualRevenue(){
		return actual_revenue;
	}
	
	public String getCVPath(){
		return cv_path;
	}
}