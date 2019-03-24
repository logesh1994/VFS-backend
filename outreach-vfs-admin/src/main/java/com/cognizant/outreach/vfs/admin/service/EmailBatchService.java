package com.cognizant.outreach.vfs.admin.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.outreach.vfs.dao.model.EventDetailRepo;
import com.cognizant.outreach.vfs.dao.model.EventRepo;
import com.cognizant.outreach.vfs.dao.repo.EventDetailRepository;
import com.cognizant.outreach.vfs.service.EmailService;

@Service
public class EmailBatchService {

	@Autowired
	private EventDetailRepository detailRepository;
	
	@Autowired
	private EmailService emailService;
	
	public void triggerEmailBatch(String eventId) {
		List<EventDetailRepo> repoList = new ArrayList();
		repoList = detailRepository.findBasedOnFeedbackStatus(eventId, "Yet To Send Mail");
		EventRepo event = repoList.get(0).getEvent();
		String email_content_attended = "Thank you for your participation in the Outreach Event \""+ event.getEvntName() +"\" on \""+ event.getEvntDate() +"\"";
		String email_content_UR = "You have unregistered for the Outreach Event \""+ event.getEvntName() +"\" that occured on \""+ event.getEvntDate() +"\"";
		String email_content_RFA = "You have missed the Outreach Event \""+ event.getEvntName() +"\" that occured on \""+ event.getEvntDate() +"\"";
		new Thread(() -> {
			for (EventDetailRepo repo: detailRepository.findBasedOnFeedbackStatus(eventId, "Yet To Send Mail")) {
				switch(repo.getStatus1().getDescription()) {
				case "Attended":
					emailService.sendFeedbackMail(repo.getEmployee().getEmpEmail(), repo.getEmployee().getEmployeeFullname(), email_content_attended);
					break;
				case "Unregistered":
					emailService.sendFeedbackMail(repo.getEmployee().getEmpEmail(), repo.getEmployee().getEmployeeFullname(), email_content_UR);
					break;
				case "Failed To Attend":
					emailService.sendFeedbackMail(repo.getEmployee().getEmpEmail(), repo.getEmployee().getEmployeeFullname(), email_content_RFA);
					break;
					default:
						System.out.println("Default case");
						break;
				}}
		}).start();
		
	}
}
