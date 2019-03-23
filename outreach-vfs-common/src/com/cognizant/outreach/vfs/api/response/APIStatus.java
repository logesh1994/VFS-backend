package com.cognizant.outreach.vfs.api.response;

public enum APIStatus {

    ERR_INVALID_DATA(100, "Input data is not valid."),
    ERR_EMP_NOT_EXIST(110, "Employee does not exist"),
    ERR_EMP_NOT_VALID(111, "Employee name or password is not correct"),
    EMP_ALREADY_EXIST(112, "Employee ID already exist"),
    INVALID_PARAMETER(201, "Invalid request parameter"),
    TOKEN_EXPIRIED(202, "Token expiried"),
    REQUIRED_LOGIN(203, "Required login"),
    INVALID_TOKEN(204, "Invalid token"),
    PASS_INVALID(205, "Password less than 6 digits"),
    FEEDBACK_ALREADY_EXISTS(206, "Feedback already submitted"),
    // Common status
    OK(200, "Success"),
    //Client Errors
	BAD(400, "Bad Request"),
	UNAUTH(401, "Unauthorized Request"),
	NOTFOUND(404, "Request not found"),
	//Server Errors
	NOTIMPL(501, "Request Not Implemented"),
	BADGTW(502, "Bad Gateway"),
	SVCUNAVAIL(503, "Service Unavailable"),
	GTWTIMOT(504, "Gateway Timeout"),
	
	//FileUpload
	FILEUPLOAD_ERROR(371, "Error while uploading file"),
	FILEUPLOAD_NOFILENAME(372, "No File Name"),
	FILEUPLOAD_ERROR_BIGSIZE(373, "File size is bigger than 5 MB")
	
	;

    private final int code;
    private final String description;

    private APIStatus(int s, String v) {
        code = s;
        description = v;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

}
