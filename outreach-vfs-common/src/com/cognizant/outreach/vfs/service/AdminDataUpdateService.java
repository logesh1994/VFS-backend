package com.cognizant.outreach.vfs.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.outreach.vfs.domain.*;
import com.cognizant.outreach.vfs.util.JsonUtils;

@Service
public class AdminDataUpdateService {

	@Autowired
	private EntityHelperService entityHelperService;

	public boolean updateAdminData(String tableName, List<Map<String, String>> data, String action) throws Exception {
		System.out.println(data);
		switch (tableName) {
		case "Business Unit":
			BusinessUnit businessUnit = null;
			for (Object object : data) {
				businessUnit = new BusinessUnit();
				businessUnit = (BusinessUnit) JsonUtils.parseObjectData(BusinessUnit.class, object);
				if (businessUnit.getBusiness_unit_name() != null) {
					entityHelperService.addBusinessUnitRepo(businessUnit.getBusiness_unit_name(),
							businessUnit.getBusiness_unit_location(), businessUnit.getBusiness_unit_id(), action
							);
				} else {
					continue;
				}
			}
			return true;
		case "Location":
			Location location = null;
			for (Object object : data) {
				location = new Location();
				location = (Location) JsonUtils.parseObjectData(Location.class, object);
				if (location.getCity_name() != null) {
					entityHelperService.addLocationRepo(location.getCity_name(), location.getState_name(),
							location.getCountry_name(), location.getLocation_id(), action);
				} else {
					continue;
				}
			}
			return true;
		case "Event Beneficiary":
			EventBeneficiary eventBeneficiary = null;
			for (Object object : data) {
				eventBeneficiary = new EventBeneficiary();
				eventBeneficiary = (EventBeneficiary) JsonUtils.parseObjectData(EventBeneficiary.class, object);
				if (eventBeneficiary.getEvent_benificiary_name() != null) {
					entityHelperService.addEventBeneficiaryRepo(eventBeneficiary.getEvent_benificiary_name(), eventBeneficiary.getEvent_benificiary_id(), action);
				} else {
					continue;
				}
			}
			return true;
		case "Event Council":
			EventCouncil eventCouncil = null;
			for (Object object : data) {
				eventCouncil = new EventCouncil();
				eventCouncil = (EventCouncil) JsonUtils.parseObjectData(EventCouncil.class, object);
				if (eventCouncil.getEvent_council_name() != null) {
					entityHelperService.addEventCouncilRepo(eventCouncil.getEvent_council_name(),
							eventCouncil.getLocation_name(), eventCouncil.getEvent_council_id(), action);
				} else {
					continue;
				}
			}
			return true;
		case "Feedback Options":
			FeedbackOptions option = null;
			for (Object object : data) {
				option = new FeedbackOptions();
				option = (FeedbackOptions) JsonUtils.parseObjectData(FeedbackOptions.class, object);
				if (option.getOption_description() != null) {
					entityHelperService.addFeedbackOptionRepo(option.getOption_description(), option.getOption_id(), action);
				} else {
					continue;
				}
			}
			return true;
		case "IIEP Category":
			IiepCategory iiepCategory = null;
			for (Object object : data) {
				iiepCategory = new IiepCategory();
				iiepCategory = (IiepCategory) JsonUtils.parseObjectData(IiepCategory.class, object);
				if (iiepCategory.getIiep_category_name() != null) {
					entityHelperService.addIiepCategoryRepo(iiepCategory.getIiep_category_name(), iiepCategory.getIiep_category_id(), action);
				} else {
					continue;
				}
			}
			return true;
		case "Role":
			Role role = null;
			for (Object object : data) {
				role = new Role();
				role = (Role) JsonUtils.parseObjectData(Role.class, object);
				if (role.getRole() != null) {
					entityHelperService.addRoleRepo(role.getRole(), role.getRole_id(), action);
				} else {
					continue;
				}
			}
			return true;
		case "Rating":
			Rating rating = null;
			for (Object object : data) {
				rating = new Rating();
				rating = (Rating) JsonUtils.parseObjectData(Rating.class, object);
				if (rating.getDescription() != null) {
					entityHelperService.addRatingRepo(rating.getDescription(), rating.getRatingId(), action);
				} else {
					continue;
				}
			}
			return true;
		case "Status":
			Status status = null;
			for (Object object : data) {
				status = new Status();
				status = (Status) JsonUtils.parseObjectData(Status.class, object);
				if (status.getDescription() != null) {
					entityHelperService.addStatusRepo(status.getDescription(), status.getStatusId(), action);
				} else {
					continue;
				}
			}
			return true;
		case "Project":
			Project project = null;
			for (Object object : data) {
				project = new Project();
				project = (Project) JsonUtils.parseObjectData(Project.class, object);
				if (project.getProject_name() != null) {
					entityHelperService.addProjectRepo(project.getProject_name(), project.getProject_id(), action);
				} else {
					continue;
				}
			}
			return true;
		case "Category":
			Category category = null;
			for (Object object : data) {
				category = new Category();
				category = (Category) JsonUtils.parseObjectData(Category.class, object);
				if (category.getCategory_name() != null) {
					entityHelperService.addCategoryRepo(category.getCategory_name(), category.getCategory_id(), action);
				} else {
					continue;
				}
			}
			return true;
		case "Event":
			Event event = null;
			for (Object object : data) {
				event = new Event();
				event = (Event) JsonUtils.parseObjectData(Event.class, object);
				if (event.getEventId() != null) {
					entityHelperService.addEventRepo(event.getEventId(), event.getCreated_by_id(),
							event.getEvent_poc_id(), event.getEvent_date(), event.getEvent_description(),
							event.getEvent_name(), event.getLives_impacted(), event.getMonth(),
							event.getOverall_volunteer_hrs(), event.getTotal_travel_hrs(),
							event.getTotal_volunteer_hrs(), event.getTotal_volunteers(), event.getVenue_address(),
							event.getEvent_council_name(), event.getIiep_category(), event.getEvent_base_loaction(),
							event.getEvent_benificiary_name(), event.getProject_name(), event.getCategory_name(), action);
				} else {
					continue;
				}
			}
			return true;
		case "Employee":
			Employee employee = null;
			for (Object object : data) {
				employee = new Employee();
				employee = (Employee) JsonUtils.parseObjectData(Employee.class, object);
				if (employee.getEmployeeId() != 0) {
					entityHelperService.addEmployees(employee.getEmployeeId(), employee.getContact(),
							employee.getFirst_name(), employee.getLast_name(), employee.getVolunteer_hours(),
							employee.getBu_unit(), employee.getLocation(), employee.getRole(), employee.getStatusId(), action);
				} else {
					continue;
				}
			}
			return true;
		case "Event Details":
			EventDetails eventDetails = null;
			for (Object object : data) {
				eventDetails = new EventDetails();
				eventDetails = (EventDetails) JsonUtils.parseObjectData(EventDetails.class, object);
				if (eventDetails.getEvent_id() != null) {
					entityHelperService.addEventDetailRepo(eventDetails.getCreated_by(), eventDetails.getTravel_hrs(),
							eventDetails.getVolunteer_hrs(), eventDetails.getEmployee_id(), eventDetails.getEvent_id(),
							eventDetails.getParticipation_status(), eventDetails.getFeedback_status(), eventDetails.getEvent_details_id(), action);
				} else {
					continue;
				}
			}
			return true;
		case "Feedback":
			Feedback feedback = null;
			for (Object object : data) {
				feedback = new Feedback();
				feedback = (Feedback) JsonUtils.parseObjectData(Feedback.class, object);
				if (feedback.getEvent_detail_id() != 0) {
					entityHelperService.addFeedbackData(feedback.getImprove_feedback(), feedback.getLike_feedback(),
							feedback.getUpdate_id(), feedback.getEvent_detail_id(), feedback.getFeedback_option(),
							feedback.getRating(), feedback.getFeedback_id(), action);
				} else {
					continue;
				}
			}
			return true;
		default:
			System.out.println("Unknown Admin Table");
			break;
		}
		return true;
	}

}
