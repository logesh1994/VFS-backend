package com.cognizant.outreach.vfs.beanutils;

import java.util.ArrayList;
import java.util.List;

import com.cognizant.outreach.vfs.dao.model.RoleLookupRepo;
import com.cognizant.outreach.vfs.domain.Role;

public final class RoleBeanUtils {

	public static RoleLookupRepo getRoleRepo(Role role) {
		RoleLookupRepo roleLookupRepo = null;
		if (role != null) {
			roleLookupRepo = new RoleLookupRepo();
			roleLookupRepo.setId(role.getRole_id());
			roleLookupRepo.setDescription(role.getRole());
		}
		return roleLookupRepo;
	}
	
	public static Role getRole(RoleLookupRepo roleLookupRepo) {
		Role role = null;
		if (roleLookupRepo != null) {
			role = new Role();
			role.setRole_id(roleLookupRepo.getId());
			role.setRole(roleLookupRepo.getDescription());
		}
		return role;
	}
	
	public static List<Role> getRoleList(List<RoleLookupRepo> roleLookupRepoList) {
		List<Role> roleList = new ArrayList<>();
		Role role = null;
		for (RoleLookupRepo roleLookupRepo: roleLookupRepoList) {
			role = new Role();
			role.setRole_id(roleLookupRepo.getId());
			role.setRole(roleLookupRepo.getDescription());
			roleList.add(role);
		}
		return roleList;
	}
}
