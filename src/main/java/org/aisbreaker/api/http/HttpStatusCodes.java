package org.aisbreaker.api.http;

import java.util.HashMap;
import java.util.Map;

/**
 * Code and textes from sepc:
 *   https://developer.mozilla.org/en-US/docs/Web/HTTP/Status#server_error_responses
 *   https://httpwg.org/specs/rfc9110.html#overview.of.status.codes
 */
public class HttpStatusCodes {
	public static final Map<Integer, String> statusTextes = new HashMap<>();

	static {
		statusTextes.put(100, "Continue");
		statusTextes.put(101, "Switching Protocols");

		statusTextes.put(200, "OK");
		statusTextes.put(201, "Created");
		statusTextes.put(202, "Accepted");
		statusTextes.put(203, "Non-Authoritative Information");
		statusTextes.put(204, "No Content");
		statusTextes.put(205, "Reset Content");
		statusTextes.put(206, "Partial Content");
		statusTextes.put(207, "Multi-Status (WebDAV)");
		statusTextes.put(208, "Already Reported (WebDAV)");
		statusTextes.put(226, "IM Used");

		statusTextes.put(300, "Multiple Choices");
		statusTextes.put(301, "Moved Permanently");
		statusTextes.put(302, "Found");
		statusTextes.put(303, "See Other");
		statusTextes.put(304, "Not Modified");
		statusTextes.put(305, "Use Proxy");
		statusTextes.put(306, "(Unused)");
		statusTextes.put(307, "Temporary Redirect");
		statusTextes.put(308, "Permanent Redirect (experimental)");

		statusTextes.put(400, "Bad Request");
		statusTextes.put(401, "Unauthorized");
		statusTextes.put(402, "Payment Required");
		statusTextes.put(403, "Forbidden");
		statusTextes.put(404, "Not Found");
		statusTextes.put(405, "Method Not Allowed");
		statusTextes.put(406, "Not Acceptable");
		statusTextes.put(407, "Proxy Authentication Required");
		statusTextes.put(408, "Request Timeout");
		statusTextes.put(409, "Conflict");
		statusTextes.put(410, "Gone");
		statusTextes.put(411, "Length Required");
		statusTextes.put(412, "Precondition Failed");
		statusTextes.put(413, "Request Entity Too Large");
		statusTextes.put(414, "Request-URI Too Long");
		statusTextes.put(415, "Unsupported Media Type");
		statusTextes.put(416, "Requested Range Not Satisfiable");
		statusTextes.put(417, "Expectation Failed");
		statusTextes.put(418, "I'm a teapot (RFC 2324)");
		statusTextes.put(420, "Enhance Your Calm"); // 'Enhance Your Calm (Twitter)'
		statusTextes.put(422, "Unprocessable Entity (WebDAV)");
		statusTextes.put(423, "Locked (WebDAV)");
		statusTextes.put(424, "Failed Dependency (WebDAV)");
		statusTextes.put(425, "Reserved for WebDAV");
		statusTextes.put(426, "Upgrade Required");
		statusTextes.put(428, "Precondition Required");
		statusTextes.put(429, "Too Many Requests");
		statusTextes.put(431, "Request Header Fields Too Large");
		statusTextes.put(444, "No Response"); // 'No Response (Nginx)'
		statusTextes.put(449, "Retry With (Microsoft)");
		statusTextes.put(450, "Blocked by Windows Parental Controls (Microsoft)");
		statusTextes.put(451, "Unavailable For Legal Reasons");
		statusTextes.put(499, "Client Closed Request"); // 'Client Closed Request (Nginx)'

		statusTextes.put(500, "Internal Server Error");
		statusTextes.put(501, "Not Implemented");
		statusTextes.put(502, "Bad Gateway");
		statusTextes.put(503, "Service Unavailable");
		statusTextes.put(504, "Gateway Timeout");
		statusTextes.put(505, "HTTP Version Not Supported");
		statusTextes.put(506, "Variant Also Negotiates (Experimental)");
		statusTextes.put(507, "Insufficient Storage (WebDAV)");
		statusTextes.put(508, "Loop Detected (WebDAV)");
		statusTextes.put(509, "Bandwidth Limit Exceeded"); // 'Bandwidth Limit Exceeded (Apache)'
		statusTextes.put(510, "Not Extended");
		statusTextes.put(511, "Network Authentication Required");
		statusTextes.put(598, "Network read timeout error");
		statusTextes.put(599, "Network connect timeout error");
	}

	public static String getStatusText(int statusCode) {
		return statusTextes.get(statusCode);
	}

	//
	// all used status codes
	//

	public static final int STATUS_200_OK = 200;
	public static final int STATUS_201_Created = 201;
	public static final int STATUS_202_Accepted = 202;
	public static final int STATUS_204_No_Content = 204;
	public static final int STATUS_206_Partial_Content = 206;
	public static final int STATUS_207_Multi_Status = 207;
	public static final int STATUS_208_Already_Reported = 208;
	public static final int STATUS_226_IM_Used = 226;

	public static final int STATUS_300_Multiple_Choices = 300;
	public static final int STATUS_301_Moved_Permanently = 301;
	public static final int STATUS_302_Found = 302;
	public static final int STATUS_303_See_Other = 303;
	public static final int STATUS_304_Not_Modified = 304;
	public static final int STATUS_307_Temporary_Redirect = 307;
	public static final int STATUS_308_Permanent_Redirect = 308;

	public static final int ERROR_400_Bad_Request = 400;
	public static final int ERROR_401_Unauthorized = 401;
	public static final int ERROR_403_Forbidden = 403;
	public static final int ERROR_404_Not_Found = 404;
	public static final int ERROR_405_Method_Not_Allowed = 405;
	public static final int ERROR_406_Not_Acceptable = 406;
	public static final int ERROR_409_Conflict = 409;
	public static final int ERROR_410_Gone = 410;
	public static final int ERROR_411_Length_Required = 411;
	public static final int ERROR_412_Precondition_Failed = 412;
	public static final int ERROR_413_Request_Entity_Too_Large = 413;
	public static final int ERROR_414_Request_URI_Too_Long = 414;
	public static final int ERROR_415_Unsupported_Media_Type = 415;
	public static final int ERROR_416_Requested_Range_Not_Satisfiable = 416;
	public static final int ERROR_417_Expectation_Failed = 417;
	public static final int ERROR_422_Unprocessable_Entity = 422;
	public static final int ERROR_429_Too_Many_Requests = 429;
	public static final int ERROR_431_Request_Header_Fields_Too_Large = 431;
	public static final int ERROR_444_No_Response = 444;
	public static final int ERROR_449_Retry_With = 449;
	public static final int ERROR_451_Unavailable_For_Legal_Reasons = 451;
	public static final int ERROR_499_Client_Closed_Request = 499;

	public static final int ERROR_500_Internal_Server_Error = 500;
	public static final int ERROR_501_Not_Implemented = 501;
	public static final int ERROR_502_Bad_Gateway = 502;
	public static final int ERROR_503_Service_Unavailable = 503;
	public static final int ERROR_504_Gateway_Timeout = 504;
	public static final int ERROR_505_HTTP_Version_Not_Supported = 505;
	public static final int ERROR_507_Insufficient_Storage = 507;
	public static final int ERROR_508_Loop_Detected = 508;
	public static final int ERROR_509_Bandwidth_Limit_Exceeded = 509;
	public static final int ERROR_510_Not_Extended = 510;
	public static final int ERROR_511_Network_Authentication_Required = 511;
	public static final int ERROR_598_Network_Read_Timeout_Error = 598;
	public static final int ERROR_599_Network_Connect_Timeout_Error = 599;
}
