package com.cognizant.outreach.vfs;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.outreach.vfs.dao.model.BusinessUnitRepo;
import com.cognizant.outreach.vfs.dao.model.CategoryRepo;
import com.cognizant.outreach.vfs.dao.model.EmployeeRepo;
import com.cognizant.outreach.vfs.dao.model.EventBeneficiaryRepo;
import com.cognizant.outreach.vfs.dao.model.EventCouncilRepo;
import com.cognizant.outreach.vfs.dao.model.EventDetailRepo;
import com.cognizant.outreach.vfs.dao.model.EventRepo;
import com.cognizant.outreach.vfs.dao.model.FeedbackOptionRepo;
import com.cognizant.outreach.vfs.dao.model.FeedbackRepo;
import com.cognizant.outreach.vfs.dao.model.IiepCategoryRepo;
import com.cognizant.outreach.vfs.dao.model.LocationRepo;
import com.cognizant.outreach.vfs.dao.model.ProjectRepo;
import com.cognizant.outreach.vfs.dao.model.RatingRepo;
import com.cognizant.outreach.vfs.dao.model.RoleLookupRepo;
import com.cognizant.outreach.vfs.dao.model.StatusRepo;
import com.cognizant.outreach.vfs.domain.Category;
import com.cognizant.outreach.vfs.domain.Role;
import com.cognizant.outreach.vfs.util.Constants;

@RunWith(SpringRunner.class)
@DataJpaTest
@TestPropertySource(locations= "classpath:application-test.properties")
public class BaseRepoTest {

	@Autowired
	private TestEntityManager entityManager;
	
	public LocationRepo createLocationRepo(String cityName, String country, String state) {
		LocationRepo locationRepo = new LocationRepo(cityName, country, state);
		entityManager.persistAndFlush(locationRepo);
		return locationRepo;
	}
	
	public BusinessUnitRepo createBuRepo(String buName, String cityName) {
		BusinessUnitRepo repo = new BusinessUnitRepo(buName, createLocationRepo(cityName, null, null));
		entityManager.persistAndFlush(repo);
		return repo;
	}
	
	public CategoryRepo createCategoryRepo(String category) {
		CategoryRepo repo = new CategoryRepo(category);
		entityManager.persistAndFlush(repo);
		return repo;
	}
	
	public EmployeeRepo createEmployeeRepo(Integer id) {
		BusinessUnitRepo bu = createBuRepo("Test BU", "Test City");
		RoleLookupRepo role = createRoleRepo("Admin");
		StatusRepo status = createStatusRepo("Active");
		EmployeeRepo repo = new EmployeeRepo(500000, "8056245629", 500000 + Constants.COGNIZANT_MAIL, "First Name", "Last Name", 10, bu , bu.getLocation(), role, status);
		if (id != null) {
			repo.setEmployeeId(id);
		}
		entityManager.persistAndFlush(repo);
		return repo;
	}
	
	public RoleLookupRepo createRoleRepo(String role) {
		RoleLookupRepo roleRepo = new RoleLookupRepo(role);
		entityManager.persistAndFlush(roleRepo);
		return roleRepo;
	}
	
	public StatusRepo createStatusRepo(String status) {
		StatusRepo repo = new StatusRepo(status);
		entityManager.persistAndFlush(repo);
		return repo;
	}
	
	public EventBeneficiaryRepo createBenificiaryRepo(String beneficiary) {
		EventBeneficiaryRepo repo = new EventBeneficiaryRepo(beneficiary);
		entityManager.persistAndFlush(repo);
		return repo;
	}
	
	public EventCouncilRepo createEventCouncilRepo() {
		LocationRepo location = createLocationRepo("Test City 1", null, null);
		EventCouncilRepo repo = new EventCouncilRepo("Test Council", location);
		entityManager.persistAndFlush(repo);
		return repo;
	}
	
	public FeedbackOptionRepo createFeedbackOptionRepo(String option) {
		FeedbackOptionRepo optionRepo = new FeedbackOptionRepo(option);
		entityManager.persistAndFlush(optionRepo);
		return optionRepo;
	}
	
	public IiepCategoryRepo createIiepCategoryRepo(String iiep) {
		IiepCategoryRepo repo = new IiepCategoryRepo(iiep);
		entityManager.persistAndFlush(repo);
		return repo;
	}
	
	public ProjectRepo createProjectRepo(String project) {
		ProjectRepo repo = new ProjectRepo(project);
		entityManager.persistAndFlush(repo);
		return repo;
	}
	
	public RatingRepo createRatingRepo(String rating) {
		RatingRepo repo = new RatingRepo(rating);
		entityManager.persistAndFlush(repo);
		return repo;
	}
	
	public EventRepo createEventRepo() {
		EventCouncilRepo council = createEventCouncilRepo();
		EventRepo repo = new EventRepo("EVENT001",500000, "512642,512642", new Date(), "Test Description", "Test Event Name", 100, "JAN", 200, 50, 150, 10, "Test Venu",
				council , createIiepCategoryRepo("Test IIEP"), council.getLocation(), createBenificiaryRepo("Test Beneficiary"), createProjectRepo("Test Project"), createCategoryRepo("Test Categpry"));
		entityManager.persistAndFlush(repo);
		return repo;
	}
	
	public EventDetailRepo createEventDetailRepo(String status1, String status2) {
		EventRepo event = createEventRepo();
		EmployeeRepo employee = createEmployeeRepo(500001);
		StatusRepo status_1 = new StatusRepo("Registered");
		StatusRepo status_2 = new StatusRepo("Yet To Send Mail");
		if (status1 != null) status_1 = new StatusRepo(status1);
		if (status2 != null) status_2 = new StatusRepo(status2);
		EventDetailRepo repo = new EventDetailRepo(500000, 10, 10, employee, event, status_1, status_2);
		entityManager.persistAndFlush(repo);
		return repo;
	}
	
	public FeedbackRepo createFeedbackRepo() {
		EventDetailRepo detail = createEventDetailRepo(null, null);
		FeedbackRepo repo = new FeedbackRepo("Test improve", "Test like", detail.getEmployee(), detail, createFeedbackOptionRepo("Test Option"), createRatingRepo("GOOD"));
		entityManager.persistAndFlush(repo);
		return repo;
	}
	
	@Test
	public void testFunction() {}
	
}
