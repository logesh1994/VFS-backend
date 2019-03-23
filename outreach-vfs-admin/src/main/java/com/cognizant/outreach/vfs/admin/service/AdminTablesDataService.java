package com.cognizant.outreach.vfs.admin.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.outreach.vfs.beanutils.BusinessUnitBeanUtils;
import com.cognizant.outreach.vfs.beanutils.CategoryBeanUtils;
import com.cognizant.outreach.vfs.beanutils.EmployeeBeanUtils;
import com.cognizant.outreach.vfs.beanutils.EventBeanUtils;
import com.cognizant.outreach.vfs.beanutils.EventBeneficiaryBeanUtils;
import com.cognizant.outreach.vfs.beanutils.EventCouncilBeanUtils;
import com.cognizant.outreach.vfs.beanutils.FeedbackOptionsBeanUtils;
import com.cognizant.outreach.vfs.beanutils.IiepCategoryBeanUtils;
import com.cognizant.outreach.vfs.beanutils.LocationBeanUtils;
import com.cognizant.outreach.vfs.beanutils.ProjectBeanUtils;
import com.cognizant.outreach.vfs.beanutils.RatingBeanUtils;
import com.cognizant.outreach.vfs.beanutils.RoleBeanUtils;
import com.cognizant.outreach.vfs.beanutils.StatusBeanUtils;
import com.cognizant.outreach.vfs.config.AppConfig;
import com.cognizant.outreach.vfs.dao.model.BusinessUnitRepo;
import com.cognizant.outreach.vfs.dao.model.CategoryRepo;
import com.cognizant.outreach.vfs.dao.model.EmployeeRepo;
import com.cognizant.outreach.vfs.dao.model.EventBeneficiaryRepo;
import com.cognizant.outreach.vfs.dao.model.EventCouncilRepo;
import com.cognizant.outreach.vfs.dao.model.EventRepo;
import com.cognizant.outreach.vfs.dao.model.FeedbackOptionRepo;
import com.cognizant.outreach.vfs.dao.model.IiepCategoryRepo;
import com.cognizant.outreach.vfs.dao.model.LocationRepo;
import com.cognizant.outreach.vfs.dao.model.ProjectRepo;
import com.cognizant.outreach.vfs.dao.model.RatingRepo;
import com.cognizant.outreach.vfs.dao.model.RoleLookupRepo;
import com.cognizant.outreach.vfs.dao.model.StatusRepo;
import com.cognizant.outreach.vfs.dao.repo.BusinessUnitRepository;
import com.cognizant.outreach.vfs.dao.repo.CategoryRepository;
import com.cognizant.outreach.vfs.dao.repo.EmployeeRepository;
import com.cognizant.outreach.vfs.dao.repo.EventBeneficiaryRepository;
import com.cognizant.outreach.vfs.dao.repo.EventCouncilRepository;
import com.cognizant.outreach.vfs.dao.repo.EventRepository;
import com.cognizant.outreach.vfs.dao.repo.FeedbackOptionRepository;
import com.cognizant.outreach.vfs.dao.repo.IiepCategoryRepository;
import com.cognizant.outreach.vfs.dao.repo.LocationRepository;
import com.cognizant.outreach.vfs.dao.repo.ProjectRepository;
import com.cognizant.outreach.vfs.dao.repo.RatingRepository;
import com.cognizant.outreach.vfs.dao.repo.RoleRepository;
import com.cognizant.outreach.vfs.dao.repo.StatusRepository;
import com.cognizant.outreach.vfs.domain.AdminTableData;
import com.cognizant.outreach.vfs.domain.BusinessUnit;
import com.cognizant.outreach.vfs.domain.Category;
import com.cognizant.outreach.vfs.domain.Employee;
import com.cognizant.outreach.vfs.domain.Event;
import com.cognizant.outreach.vfs.domain.EventBeneficiary;
import com.cognizant.outreach.vfs.domain.EventCouncil;
import com.cognizant.outreach.vfs.domain.FeedbackOptions;
import com.cognizant.outreach.vfs.domain.IiepCategory;
import com.cognizant.outreach.vfs.domain.Location;
import com.cognizant.outreach.vfs.domain.Project;
import com.cognizant.outreach.vfs.domain.Rating;
import com.cognizant.outreach.vfs.domain.Role;
import com.cognizant.outreach.vfs.domain.Status;
import com.cognizant.outreach.vfs.util.AdminTableUtils;


@Service
public class AdminTablesDataService {

    @Autowired
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
    
    
    public List<AdminTableData> getAllAdminTableData() {
    	List<AdminTableData> adminTableDataList = new ArrayList<>();

    	adminTableDataList.add(new AdminTableData("Business Unit",
    			AdminTableUtils.ADMIN_TABLE_COLUMN_MAP.get("Business Unit"), 
    			getAllBusinessUnitData()));
    	adminTableDataList.add(new AdminTableData("Location",
    			AdminTableUtils.ADMIN_TABLE_COLUMN_MAP.get("Location"), 
    			getAllLocationData()));
    	adminTableDataList.add(new AdminTableData("Event Beneficiary",
    			AdminTableUtils.ADMIN_TABLE_COLUMN_MAP.get("Event Beneficiary"), 
    			getAllEventBeneficiaryData()));
    	adminTableDataList.add(new AdminTableData("Event Council",
    			AdminTableUtils.ADMIN_TABLE_COLUMN_MAP.get("Event Council"), 
    			getAllEventCouncilData()));
    	adminTableDataList.add(new AdminTableData("Feedback Options",
    			AdminTableUtils.ADMIN_TABLE_COLUMN_MAP.get("Feedback Options"), 
    			getAllFeedbackOptionsData()));
    	adminTableDataList.add(new AdminTableData("IIEP Category",
    			AdminTableUtils.ADMIN_TABLE_COLUMN_MAP.get("IIEP Category"), 
    			getAllIiepCategoryData()));
    	adminTableDataList.add(new AdminTableData("Role",
    			AdminTableUtils.ADMIN_TABLE_COLUMN_MAP.get("Role"), 
    			getAllRolesData()));
    	adminTableDataList.add(new AdminTableData("Rating",
    			AdminTableUtils.ADMIN_TABLE_COLUMN_MAP.get("Rating"), 
    			getAllRatingData()));
    	adminTableDataList.add(new AdminTableData("Status",
    			AdminTableUtils.ADMIN_TABLE_COLUMN_MAP.get("Status"), 
    			getAllStatusData()));
    	adminTableDataList.add(new AdminTableData("Project",
    			AdminTableUtils.ADMIN_TABLE_COLUMN_MAP.get("Project"), 
    			getAllProjectData()));
    	adminTableDataList.add(new AdminTableData("Category",
    			AdminTableUtils.ADMIN_TABLE_COLUMN_MAP.get("Category"), 
    			getAllCategoryData()));
    	adminTableDataList.add(new AdminTableData("Event",
    			AdminTableUtils.ADMIN_TABLE_COLUMN_MAP.get("Event"), 
    			getAllEventData()));
    	adminTableDataList.add(new AdminTableData("Employee",
    			AdminTableUtils.ADMIN_TABLE_COLUMN_MAP.get("Employee"), 
    			getAllEmployeeData()));

    	return adminTableDataList;
    }
    
    public List<BusinessUnit> getAllBusinessUnitData() {
    	List<BusinessUnitRepo> businessUnitRepoList = new ArrayList<>();
    	CollectionUtils.addAll(businessUnitRepoList, businessUnitRepository.findAll());
    	return BusinessUnitBeanUtils.getBusinessUnitList(businessUnitRepoList);
    }
    
    public List<Location> getAllLocationData() {
    	List<LocationRepo> locationRepoList = new ArrayList<>();
    	CollectionUtils.addAll(locationRepoList, locationRepository.findAll());
    	return LocationBeanUtils.getLocationsList(locationRepoList);
    }
    
    public List<EventBeneficiary> getAllEventBeneficiaryData() {
    	List<EventBeneficiaryRepo> eventBeneficiaryRepoList = new ArrayList<>();
    	CollectionUtils.addAll(eventBeneficiaryRepoList, eventBenificiaryRepository.findAll());
    	return EventBeneficiaryBeanUtils.getEventBeneficiaryList(eventBeneficiaryRepoList);
    }
    
    public List<EventCouncil> getAllEventCouncilData() {
    	List<EventCouncilRepo> eventCouncilRepoList = new ArrayList<>();
    	CollectionUtils.addAll(eventCouncilRepoList, eventCouncilRepository.findAll());
    	return EventCouncilBeanUtils.getEventCouncilList(eventCouncilRepoList);
    }
    
    public List<FeedbackOptions> getAllFeedbackOptionsData() {
    	List<FeedbackOptionRepo> feedbackOptionRepoList = new ArrayList<>();
    	CollectionUtils.addAll(feedbackOptionRepoList, feedbackOptionRepository.findAll());
    	return FeedbackOptionsBeanUtils.getFeedbackOptionsList(feedbackOptionRepoList);
    }
    
    public List<IiepCategory> getAllIiepCategoryData() {
    	List<IiepCategoryRepo> iiepCategoryRepoList = new ArrayList<>();
    	CollectionUtils.addAll(iiepCategoryRepoList, iiepCategoryRepository.findAll());
    	return IiepCategoryBeanUtils.getIiepCategoryList(iiepCategoryRepoList);
    }
    
    public List<Role> getAllRolesData() {
    	List<RoleLookupRepo> roleLookupRepoList = new ArrayList<>();
    	CollectionUtils.addAll(roleLookupRepoList, roleRepository.findAll());
    	return RoleBeanUtils.getRoleList(roleLookupRepoList);
    }
    
    public List<Rating> getAllRatingData() {
    	List<RatingRepo> ratingRepoList = new ArrayList<>();
    	CollectionUtils.addAll(ratingRepoList, ratingRepository.findAll());
    	return RatingBeanUtils.getRatingList(ratingRepoList);
    }
    
    public List<Status> getAllStatusData() {
    	List<StatusRepo> statusRepoList = new ArrayList<>();
    	CollectionUtils.addAll(statusRepoList, statusRepository.findAll());
    	return StatusBeanUtils.getStatusList(statusRepoList);
    }
    
    public List<Project> getAllProjectData() {
    	List<ProjectRepo> projectRepoList = new ArrayList<>();
    	CollectionUtils.addAll(projectRepoList, projectRepository.findAll());
    	return ProjectBeanUtils.getProjectList(projectRepoList);
    }
    
    public List<Category> getAllCategoryData() {
    	List<CategoryRepo> categoryRepoList = new ArrayList<>();
    	CollectionUtils.addAll(categoryRepoList, categoryRepository.findAll());
    	return CategoryBeanUtils.getCategoryList(categoryRepoList);
    }
    
    public List<Event> getAllEventData() {
    	List<EventRepo> eventRepoList = new ArrayList<>();
    	CollectionUtils.addAll(eventRepoList, eventRepository.findAll());
    	return EventBeanUtils.getEventList(eventRepoList);
    }
    
    public List<Employee> getAllEmployeeData() {
    	List<EmployeeRepo> employeeRepoList = new ArrayList<>();
    	CollectionUtils.addAll(employeeRepoList, employeeRepository.findAll());
    	return EmployeeBeanUtils.getEmployeeList(employeeRepoList);
    }

}