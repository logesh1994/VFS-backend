package com.cognizant.outreach.vfs.beanutils;

import java.util.ArrayList;
import java.util.List;

import com.cognizant.outreach.vfs.dao.model.ProjectRepo;
import com.cognizant.outreach.vfs.domain.Project;

public final class ProjectBeanUtils {
	
	public static List<Project> getProjectList(List<ProjectRepo> projectRepoList) {
		List<Project> projectList = new ArrayList<>();
		Project project = null;
		for (ProjectRepo projectRepo: projectRepoList) {
			project = new Project();
			project.setProject_id(projectRepo.getId());
			project.setProject_name(projectRepo.getDescription());
			projectList.add(project);
		}
		return projectList;
	}
}
