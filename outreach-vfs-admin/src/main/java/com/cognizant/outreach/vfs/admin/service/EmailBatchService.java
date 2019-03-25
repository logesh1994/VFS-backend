package com.cognizant.outreach.vfs.admin.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.outreach.vfs.dao.model.EmployeeRepo;
import com.cognizant.outreach.vfs.dao.model.EventDetailRepo;
import com.cognizant.outreach.vfs.dao.model.EventRepo;
import com.cognizant.outreach.vfs.dao.model.StatusRepo;
import com.cognizant.outreach.vfs.dao.repo.EmployeeRepository;
import com.cognizant.outreach.vfs.dao.repo.EventDetailRepository;
import com.cognizant.outreach.vfs.dao.repo.StatusRepository;
import com.cognizant.outreach.vfs.service.EmailService;

@Service
public class EmailBatchService {

	@Autowired
	private EventDetailRepository detailRepository;
	
	@Autowired
	private StatusRepository statusRepository;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public void triggerEmailBatch(String eventId) {
		List<EventDetailRepo> repoList = detailRepository.findBasedOnFeedbackStatus(eventId, "Yet To Send Mail");
		EventRepo event = repoList.get(0).getEvent();
		String email_content_attended = "Thank you for your participation in the Outreach Event \""+ event.getEvntName() +"\" on \""+ event.getEvntDate() +"\"";
		String email_content_UR = "You have unregistered for the Outreach Event \""+ event.getEvntName() +"\" that occured on \""+ event.getEvntDate() +"\"";
		String email_content_RFA = "You have missed the Outreach Event \""+ event.getEvntName() +"\" that occured on \""+ event.getEvntDate() +"\"";
		new Thread(() -> {
			StatusRepo statusRepo = statusRepository.findByStatusDescription("Email Sent");
			for (EventDetailRepo repo: repoList) {
				String feedbackLink = "http://localhost:4200/feedback/"+repo.getEmployee().getEmployeeId()+"/"+repo.getId();
				switch(repo.getStatus1().getDescription()) {
				case "Attended":
					emailService.sendFeedbackMail(repo.getEmployee().getEmpEmail(), repo.getEmployee().getEmployeeFullname(), email_content_attended, feedbackLink);
					break;
				case "Unregistered":
					emailService.sendFeedbackMail(repo.getEmployee().getEmpEmail(), repo.getEmployee().getEmployeeFullname(), email_content_UR, feedbackLink);
					break;
				case "Failed To Attend":
					emailService.sendFeedbackMail(repo.getEmployee().getEmpEmail(), repo.getEmployee().getEmployeeFullname(), email_content_RFA, feedbackLink);
					break;
					default:
						System.out.println("Default case");
						break;
				}
				repo.setStatus2(statusRepo);
				detailRepository.save(repo);	
			}
			String email_dl = "";
			for (EmployeeRepo repo: employeeRepository.findListbyRole(Arrays.asList("Admin", "POC"))) {
				email_dl = email_dl + "," + repo.getEmpEmail();
			}
			emailService.sendEmaiAlert(email_dl, "Feedback Emails for the Outreach Event \""+ event.getEvntName() +
					"\" (Event Date - "+ event.getEvntDate() + ", Id - "+ event.getId() +")" + " has been sent Successfully", null);
		}).start();
		
	}
}
