package com.cognizant.outreach.vfs.util;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

public final class UniqueID {
	/**
	 * 128 bit UUID
	 */
	public static synchronized String getUUID() {
		String uuid = UUID.randomUUID().toString();
		return StringUtils.replace(uuid, "-", "");
	}
}
