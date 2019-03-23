package com.cognizant.outreach.vfs.api.response;
import java.util.Date;
import org.springframework.stereotype.Component;

/**
 * @Class Name: UtilsResponse.java
 */
@Component
public class UtilsResponse {

    public UtilsResponse() {
    }

    StatusResponse<Object> response;

    /**
     *
     * @param result
     * @param desciption
     * @return
     */
    public StatusResponse<Object> successResponse(String result, String desciption) {
        response = new StatusResponse<Object>();
        response.setResult(result);
        response.setStatusCode(APIStatus.OK.getCode());
        response.setDescription(desciption);
        return response;
    }

    public StatusResponse<Object> successResponse(Object result, String desciption) {
        response = new StatusResponse<Object>();
        response.setResult(result);
        response.setStatusCode(APIStatus.OK.getCode());
        response.setDescription(desciption);
        return response;
    }
    
    public StatusResponse<Object> successResponse(Object result, String desciption, Long totalRecords) {
        response = new StatusResponse<Object>();
        response.setResult(result);
        response.setStatusCode(APIStatus.OK.getCode());
        response.setDescription(desciption);
        response.setTotalRecords(totalRecords);
        response.setServerTime(new Date().getTime());
        return response;
    }
    /**
     *
     * @param errorCode
     * @param result
     * @param desciption
     * @return
     */
    public StatusResponse<Object> errorResponse(int errorCode, String result, String desciption) {
        response = new StatusResponse<Object>();
        response.setResult(result);
        response.setStatusCode(errorCode);
        response.setDescription(desciption);
        return response;
    }
    
    public StatusResponse<Object> errorResponse(String desciption) {
        response = new StatusResponse<Object>();
        response.setResult(APIStatus.INVALID_PARAMETER.getDescription());
        response.setStatusCode(APIStatus.INVALID_PARAMETER.getCode());
        response.setDescription(desciption);
        return response;
    }

}
