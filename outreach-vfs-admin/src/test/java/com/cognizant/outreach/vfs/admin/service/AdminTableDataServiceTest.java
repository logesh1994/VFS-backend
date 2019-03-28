package com.cognizant.outreach.vfs.admin.service;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.outreach.vfs.dao.repo.BusinessUnitRepository;
import com.cognizant.outreach.vfs.dao.repo.CategoryRepository;
import com.cognizant.outreach.vfs.dao.repo.EmployeeRepository;
import com.cognizant.outreach.vfs.dao.repo.EventBeneficiaryRepository;
import com.cognizant.outreach.vfs.dao.repo.EventCouncilRepository;
import com.cognizant.outreach.vfs.dao.repo.EventDetailRepository;
import com.cognizant.outreach.vfs.dao.repo.EventRepository;
import com.cognizant.outreach.vfs.dao.repo.FeedbackOptionRepository;
import com.cognizant.outreach.vfs.dao.repo.IiepCategoryRepository;
import com.cognizant.outreach.vfs.dao.repo.LocationRepository;
import com.cognizant.outreach.vfs.dao.repo.ProjectRepository;
import com.cognizant.outreach.vfs.dao.repo.RatingRepository;
import com.cognizant.outreach.vfs.dao.repo.RoleRepository;
import com.cognizant.outreach.vfs.dao.repo.StatusRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminTableDataServiceTest {

	@Autowired
	private AdminTablesDataService adminTablesDataService;
	
	@MockBean
    private BusinessUnitRepository businessUnitRepository;
    
    @Autowired
    private LocationRepository locationRepository;
    
    @Autowired
    private EventBeneficiaryRepository eventBenificiaryRepository;
    
    @Autowired
    private EventCouncilRepository eventCouncilRepository;
    
    @Autowired
    private FeedbackOptionRepository feedbackOptionRepository;
    
    @Autowired
    private IiepCategoryRepository iiepCategoryRepository;
    
    @Autowired
    private RoleRepository roleRepository;
    
    @Autowired
    private RatingRepository ratingRepository;
    
    @Autowired
    private StatusRepository statusRepository;
    
    @Autowired
    private ProjectRepository projectRepository;
    
    @Autowired
    private CategoryRepository categoryRepository;
    
    @Autowired
    private EventRepository eventRepository;
    
    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Autowired
    private EventDetailRepository detailRepository;
	
	@Before
	public void setUp() {
		
	}
}
