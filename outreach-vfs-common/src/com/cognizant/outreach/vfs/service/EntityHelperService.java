package com.cognizant.outreach.vfs.service;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.outreach.vfs.dao.model.*;
import com.cognizant.outreach.vfs.dao.repo.*;
import com.cognizant.outreach.vfs.util.Constants;

@Service
public class EntityHelperService {

	@Autowired
	private LocationRepository locationRepository;

	@Autowired
	private BusinessUnitRepository businessUnitRepository;

	@Autowired
	private EventBeneficiaryRepository eventBeneficiaryRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private EventCouncilRepository councilRepository;

	@Autowired
	private FeedbackOptionRepository feedbackOptionRepository;

	@Autowired
	private IiepCategoryRepository iiepCategoryRepository;

	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private RatingRepository ratingRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private StatusRepository statusRepository;

	@Autowired
	private EventRepository eventRepository;

	@Autowired
	private EventDetailRepository detailRepository;

	@Autowired
	private FeedbackRepository feedbackRepository;

	private static final String EDIT_ACTION = "EDIT";
	private static final String DELETE_ACTION = "DELETE";
	private static final String ADD_ACTION = "ADD";

	public LocationRepo addLocationRepo(String cityName, String state, String country, Integer id, String action) {
		LocationRepo locationRepo = null;
		if (id != null) {
			locationRepo = locationRepository.findByLocationId(id);
		}
		switch (action) {
		case ADD_ACTION:
			locationRepo = locationRepository.findByLocationCityName(cityName);
			if (locationRepo == null && cityName != null) {
				locationRepo = new LocationRepo(cityName, state, country);
				locationRepository.save(locationRepo);
			}
			break;
		case EDIT_ACTION:
			locationRepo.setCity(cityName);
			locationRepo.setState(state);
			locationRepo.setCountry(country);
			locationRepository.save(locationRepo);
			break;
		case DELETE_ACTION:
			locationRepository.delete(locationRepo);
			break;
		default:
			System.out.println("Default Case for Repo Action");
			break;
		}
		return locationRepo;
	}

	public BusinessUnitRepo addBusinessUnitRepo(String buName, String location, Integer id, String action) {
		BusinessUnitRepo businessUnitRepo = null;
		if (id != null) {
			businessUnitRepo = businessUnitRepository.findByBusinessUintId(id);
		}
		LocationRepo locationRepo = addLocationRepo(location, null, null, null, ADD_ACTION);
		switch (action) {
		case ADD_ACTION:
			businessUnitRepo = businessUnitRepository.findByBusinessUnitName(buName);
			if (businessUnitRepo == null && buName != null) {
				businessUnitRepo = new BusinessUnitRepo(buName, locationRepo);
				businessUnitRepository.save(businessUnitRepo);
			}
			break;
		case EDIT_ACTION:
			businessUnitRepo.setBussUnitName(buName);
			businessUnitRepo.setLocation(locationRepo);
			businessUnitRepository.save(businessUnitRepo);
			break;
		case DELETE_ACTION:
			businessUnitRepository.delete(businessUnitRepo);
			break;
		default:
			System.out.println("Default Case for Repo Action");
			break;
		}
		return businessUnitRepo;
	}

	public EventBeneficiaryRepo addEventBeneficiaryRepo(String beneficiaryName, Integer id, String action) {
		EventBeneficiaryRepo repo = null;
		if (id != null) {
			repo = eventBeneficiaryRepository.findByEventBeneficiaryId(id);
		}
		switch (action) {
		case ADD_ACTION:
			repo = eventBeneficiaryRepository.findByEventBeneficiaryName(beneficiaryName);
			if (repo == null && beneficiaryName != null) {
				repo = new EventBeneficiaryRepo(beneficiaryName);
				eventBeneficiaryRepository.save(repo);
			}
			break;
		case EDIT_ACTION:
			repo.setDescription(beneficiaryName);
			eventBeneficiaryRepository.save(repo);
			break;
		case DELETE_ACTION:
			eventBeneficiaryRepository.delete(repo);
			break;
		default:
			System.out.println("Default Case for Repo Action");
			break;
		}
		return repo;
	}

	public CategoryRepo addCategoryRepo(String category, Integer id, String action) {
		CategoryRepo categoryRepo = null;
		if (id != null) {
			categoryRepo = categoryRepository.findByCategoryId(id);
		}
		switch (action) {
		case ADD_ACTION:
			categoryRepo = categoryRepository.findByCategoryDescription(category);
			if (categoryRepo == null && category != null) {
				categoryRepo = new CategoryRepo(category);
				categoryRepository.save(categoryRepo);
			}
			break;
		case EDIT_ACTION:
			categoryRepo.setDescription(category);
			categoryRepository.save(categoryRepo);
			break;
		case DELETE_ACTION:
			categoryRepository.delete(categoryRepo);
			break;
		default:
			System.out.println("Default Case for Repo Action");
			break;
		}
		return categoryRepo;
	}

	public EmployeeRepo addEmployee(int employeeId, RoleLookupRepo role, float volunteerHours) {
		EmployeeRepo employeeRepo = employeeRepository.findByLoginId(employeeId);
		if (employeeRepo == null) {
			employeeRepo = new EmployeeRepo(employeeId, employeeId + Constants.COGNIZANT_MAIL, role);
		}
		employeeRepo.setEvntVolunteerHours(employeeRepo.getEvntVolunteerHours() + volunteerHours);
		employeeRepository.save(employeeRepo);
		return employeeRepo;
	}

	public EmployeeRepo addEmployees(int employeeId, String contact, String empFirstName, String empLastName,
			float evntVolunteerHours, String businessUnit, String location, String role, String status, String action) {
		EmployeeRepo employeeRepo = employeeRepository.findByLoginId(employeeId);
		LocationRepo locationRepo = addLocationRepo(location, null, null, 0, ADD_ACTION);
		BusinessUnitRepo businessUnitRepo = addBusinessUnitRepo(businessUnit, location, 0, ADD_ACTION);
		RoleLookupRepo roleRepo = addRoleRepo(role, 0, ADD_ACTION);
		StatusRepo statusrepo = addStatusRepo(status, 0, ADD_ACTION);
		switch (action) {
		case ADD_ACTION:
			if (employeeRepo == null) {
				employeeRepo = new EmployeeRepo(employeeId, contact, employeeId + Constants.COGNIZANT_MAIL,
						empFirstName, empLastName, evntVolunteerHours, businessUnitRepo, locationRepo, roleRepo,
						statusrepo);
				employeeRepository.save(employeeRepo);
			}
			break;
		case EDIT_ACTION:
			employeeRepo.setBusinessUnit(businessUnitRepo);
			employeeRepo.setContact(contact);
			employeeRepo.setEmpEmail(employeeId + Constants.COGNIZANT_MAIL);
			employeeRepo.setEmpFirstName(empFirstName);
			employeeRepo.setEmpLastName(empLastName);
			employeeRepo.setEvntVolunteerHours(evntVolunteerHours);
			employeeRepo.setLocation(locationRepo);
			employeeRepo.setRoleLookup(roleRepo);
			employeeRepo.setStatus(statusrepo);
			employeeRepository.save(employeeRepo);
			break;
		case DELETE_ACTION:
			employeeRepository.delete(employeeRepo);
			break;
		default:
			System.out.println("Default Case for Repo Action");
			break;
		}
		return employeeRepo;
	}

	public EventCouncilRepo addEventCouncilRepo(String eventCouncilName, String location, Integer id, String action) {
		EventCouncilRepo repo = null;
		LocationRepo locationRepo = addLocationRepo(location, null, null, null, ADD_ACTION);
		if (id != null) {
			repo = councilRepository.findByEventCouncilId(id);
		}
		switch (action) {
		case ADD_ACTION:
			repo = councilRepository.findByEventCouncilName(eventCouncilName);
			if (repo == null && eventCouncilName != null) {
				repo = new EventCouncilRepo(eventCouncilName, locationRepo);
				councilRepository.save(repo);
			}
			break;
		case EDIT_ACTION:
			repo.setCouncilName(eventCouncilName);
			repo.setLocation(locationRepo);
			councilRepository.save(repo);
			break;
		case DELETE_ACTION:
			councilRepository.delete(repo);
			break;
		default:
			System.out.println("Default Case for Repo Action");
			break;
		}
		return repo;
	}

	public FeedbackOptionRepo addFeedbackOptionRepo(String option, Integer id, String action) {
		FeedbackOptionRepo repo = null;
		if (id != null) {
			repo = feedbackOptionRepository.findByFeedbackOptionId(id);
		}
		switch (action) {
		case ADD_ACTION:
			repo = feedbackOptionRepository.findByFeedbackOption(option);
			if (repo == null && option != null) {
				repo = new FeedbackOptionRepo(option);
				feedbackOptionRepository.save(repo);
			}
			break;
		case EDIT_ACTION:
			repo.setDescription(option);
			feedbackOptionRepository.save(repo);
			break;
		case DELETE_ACTION:
			feedbackOptionRepository.delete(repo);
			break;
		default:
			System.out.println("Default Case for Repo Action");
			break;
		}
		return repo;
	}

	public IiepCategoryRepo addIiepCategoryRepo(String category, Integer id, String action) {
		IiepCategoryRepo repo = null;
		if (id != null) {
			repo = iiepCategoryRepository.findByIiepCategoryId(id);
		}
		switch (action) {
		case ADD_ACTION:
			repo = iiepCategoryRepository.findByIiepCategoryName(category);
			if (repo == null && category != null) {
				repo = new IiepCategoryRepo(category);
				iiepCategoryRepository.save(repo);
			}
			break;
		case EDIT_ACTION:
			repo.setDescription(category);
			iiepCategoryRepository.save(repo);
			break;
		case DELETE_ACTION:
			iiepCategoryRepository.delete(repo);
			break;
		default:
			System.out.println("Default Case for Repo Action");
			break;
		}
		return repo;
	}

	public ProjectRepo addProjectRepo(String projectName, Integer id, String action) {
		ProjectRepo repo = null;
		if (id != null) {
			repo = projectRepository.findByProjectId(id);
		}
		switch (action) {
		case ADD_ACTION:
			repo = projectRepository.findByProjectDescription(projectName);
			if (repo == null && projectName != null) {
				repo = new ProjectRepo(projectName);
				projectRepository.save(repo);
			}
			break;
		case EDIT_ACTION:
			repo.setDescription(projectName);
			projectRepository.save(repo);
			break;
		case DELETE_ACTION:
			projectRepository.delete(repo);
			break;
		default:
			System.out.println("Default Case for Repo Action");
			break;
		}
		return repo;
	}

	public RatingRepo addRatingRepo(String rating, Integer id, String action) {
		RatingRepo repo = null;
		if (id != null) {
			repo = ratingRepository.findByRatingId(id);
		}
		switch (action) {
		case ADD_ACTION:
			repo = ratingRepository.findByRatingDescription(rating);
			if (repo == null && rating != null) {
				repo = new RatingRepo(rating);
				ratingRepository.save(repo);
			}
			break;
		case EDIT_ACTION:
			repo.setDescription(rating);
			ratingRepository.save(repo);
			break;
		case DELETE_ACTION:
			ratingRepository.delete(repo);
			break;
		default:
			System.out.println("Default Case for Repo Action");
			break;
		}
		return repo;
	}

	public RoleLookupRepo addRoleRepo(String role, Integer id, String action) {
		RoleLookupRepo repo = null;
		if (id != null) {
			repo = roleRepository.findByRoleId(id);
		}
		switch (action) {
		case ADD_ACTION:
			repo = roleRepository.findByRoleDescription(role);
			if (repo == null && role != null) {
				repo = new RoleLookupRepo(role);
				roleRepository.save(repo);
			}
			break;
		case EDIT_ACTION:
			repo.setDescription(role);
			roleRepository.save(repo);
			break;
		case DELETE_ACTION:
			roleRepository.delete(repo);
			break;
		default:
			System.out.println("Default Case for Repo Action");
			break;
		}
		return repo;
	}

	public StatusRepo addStatusRepo(String status, Integer id, String action) {
		StatusRepo repo = null;
		if (id != null) {
			repo = statusRepository.findByStatusId(id);
		}
		switch (action) {
		case ADD_ACTION:
			repo = statusRepository.findByStatusDescription(status);
			if (repo == null && status != null) {
				repo = new StatusRepo(status);
				statusRepository.save(repo);
			}
			break;
		case EDIT_ACTION:
			repo.setDescription(status);
			statusRepository.save(repo);
			break;
		case DELETE_ACTION:
			statusRepository.delete(repo);
			break;
		default:
			System.out.println("Default Case for Repo Action");
			break;
		}
		return repo;
	}

	public EventRepo addEventRepo(String id, int createdById, String eventPoc_s, Date evntDate, String evntDescription,
			String evntName, int livesImpacted, String month, float overallVolunteerHrs, float totalTravelHrs,
			float totalVolunteerHrs, int totalVolunteers, String venueAddress, String eventCouncil, String iiepCategory,
			String location, String eventBeneficiary, String project, String category, String action) throws Exception {
		EventRepo eventRepo = eventRepository.findByEventId(id);
		LocationRepo locationRepo = addLocationRepo(location, null, null, null, ADD_ACTION);
		EventCouncilRepo councilRepo = addEventCouncilRepo(eventCouncil, location, null, ADD_ACTION);
		EventBeneficiaryRepo beneficiaryRepo = addEventBeneficiaryRepo(eventBeneficiary, null, ADD_ACTION);
		IiepCategoryRepo iiepCategoryRepo = addIiepCategoryRepo(iiepCategory, null, ADD_ACTION);
		ProjectRepo projectRepo = addProjectRepo(project, null, ADD_ACTION);
		CategoryRepo categoryRepo = addCategoryRepo(category, null, ADD_ACTION);
		
		if(eventPoc_s != null) {
			RoleLookupRepo role = roleRepository.findByRoleDescription("POC");
			for (String pocId: Arrays.asList(eventPoc_s.split(","))) {
				addEmployee(Integer.parseInt(pocId), role, 0);
			}
		}
		
		switch (action) {
		case ADD_ACTION:
			if (eventRepo == null && id != null) {
				eventRepo = new EventRepo(id, createdById, eventPoc_s, evntDate, evntDescription, evntName,
						livesImpacted, month, overallVolunteerHrs, totalTravelHrs, totalVolunteerHrs, totalVolunteers,
						venueAddress, councilRepo, iiepCategoryRepo, locationRepo, beneficiaryRepo, projectRepo,
						categoryRepo);
				eventRepository.save(eventRepo);
			}
			break;
		case EDIT_ACTION:
			eventRepo.setCategory(categoryRepo);
			eventRepo.setCreatedById(createdById);
			eventRepo.setEventBeneficiary(beneficiaryRepo);
			eventRepo.setEventCouncil(councilRepo);
			eventRepo.setEventPoc_s(eventPoc_s);
			eventRepo.setEvntDate(evntDate);
			eventRepo.setEvntDescription(evntDescription);
			eventRepo.setEvntName(evntName);
			eventRepo.setIiepCategory(iiepCategoryRepo);
			eventRepo.setLivesImpacted(livesImpacted);
			eventRepo.setLocation(locationRepo);
			eventRepo.setMonth(month);
			eventRepo.setOverallVolunteerHrs(overallVolunteerHrs);
			eventRepo.setProject(projectRepo);
			eventRepo.setTotalTravelHrs(totalTravelHrs);
			eventRepo.setTotalVolunteerHrs(totalVolunteerHrs);
			eventRepo.setTotalVolunteers(totalVolunteers);
			eventRepo.setVenueAddress(venueAddress);
			eventRepository.save(eventRepo);
			break;
		case DELETE_ACTION:
			eventRepository.delete(eventRepo);
			break;
		default:
			System.out.println("Default Case for Repo Action");
			break;
		}
		return eventRepo;
	}

	public EventDetailRepo addEventDetailRepo(int createdById, float travelHrs, float volunteerHrs, int employee_id,
			String event_id, String participation_status, String feedback_status, Integer id, String action) {
		EventDetailRepo eventDetailRepo = null;
		EmployeeRepo employeeRepo = addEmployee(employee_id, null, volunteerHrs);
		// Assuming Event Summary has been saved
		EventRepo eventRepo = eventRepository.findByEventId(event_id);
		StatusRepo participation_stat = addStatusRepo(participation_status, 0, ADD_ACTION);
		StatusRepo feedback_stat = addStatusRepo(feedback_status, 0, ADD_ACTION);
		if (id != null) {
			eventDetailRepo = detailRepository.findByEventDetailId(id);
		}
		switch (action) {
		case ADD_ACTION:
			feedback_stat = statusRepository.findByStatusDescription("Yet To Send Mail");
			eventDetailRepo = new EventDetailRepo(createdById, travelHrs, volunteerHrs, employeeRepo, eventRepo,
					participation_stat, feedback_stat);
			detailRepository.save(eventDetailRepo);
			break;
		case EDIT_ACTION:
			eventDetailRepo.setCreatedById(createdById);
			eventDetailRepo.setEmployee(employeeRepo);
			eventDetailRepo.setEvent(eventRepo);
			eventDetailRepo.setStatus1(participation_stat);
			eventDetailRepo.setStatus2(feedback_stat);
			eventDetailRepo.setTravelHrs(travelHrs);
			eventDetailRepo.setVolunteerHrs(volunteerHrs);
			detailRepository.save(eventDetailRepo);
			break;
		case DELETE_ACTION:
			detailRepository.delete(eventDetailRepo);
			break;
		default:
			System.out.println("Default Case for Repo Action");
			break;
		}
		return eventDetailRepo;
	}

	public FeedbackRepo addFeedbackData(String improveFeedback, String likeFeedback, int employee_id,
			int eventDetail_id, String feedbackOption, String rating, Integer id, String action) {
		FeedbackRepo repo = null;
		FeedbackOptionRepo option = null;
		RatingRepo ratingRepo = null;
		EmployeeRepo employeeRepo = addEmployee(employee_id,  null, 0);
		EventDetailRepo eventDetail = detailRepository.findByEventDetailId(eventDetail_id);
		if (feedbackOption != null) {
			option = addFeedbackOptionRepo(feedbackOption, null, ADD_ACTION);
		}
		if (rating != null) {
			ratingRepo = addRatingRepo(rating, null, ADD_ACTION);
		}
		if (id != null) {
			repo = feedbackRepository.findByFeedbackId(id);
		}
		switch (action) {
		case ADD_ACTION:
			repo = new FeedbackRepo(improveFeedback, likeFeedback, employeeRepo, eventDetail, option, ratingRepo);
			feedbackRepository.save(repo);
			break;
		case EDIT_ACTION:
			// repo.setAdminFeedback(adminFeedback);
			repo.setEmployee(employeeRepo);
			repo.setEventDetail(eventDetail);
			repo.setFeedbackOption(option);
			repo.setImproveFeedback(improveFeedback);
			repo.setLikeFeedback(likeFeedback);
			repo.setRatingBean(ratingRepo);
			feedbackRepository.save(repo);
			break;
		case DELETE_ACTION:
			feedbackRepository.delete(repo);
			break;
		default:
			System.out.println("Default Case for Repo Action");
			break;
		}
		return repo;
	}
}
