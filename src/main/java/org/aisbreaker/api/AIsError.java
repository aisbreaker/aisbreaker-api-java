package org.aisbreaker.api;

import org.aisbreaker.api.http.HttpStatusCodes;

public class AIsError extends RuntimeException {
  String message;
  int statusCode;
  String statusText;

  public AIsError(String message, int statusCode) {
    this(message, statusCode, null);
  }

  public AIsError(String message, Exception e) {
    this(message, HttpStatusCodes.ERROR_503_Service_Unavailable, ""+e);
  }

  public AIsError(String message, int statusCode, String statusText) {
    // clean up status
    if (statusText == null && statusCode != 0) {
      statusText = HttpStatusCodes.getStatusText(statusCode);
    }

    // setup this object with error message
    if (message != null && statusCode != 0) {
      this.message = message;
    } else {
      String code = (statusCode != 0) ? String.valueOf(statusCode) : "";
      String text = (statusText != null) ? statusText : "";
      String status = (code + " " + text).trim();
      String reason = (status != null && !status.isEmpty()) ? "status code " + status : "an unknown error";
      this.message = "Failed with " + reason + ": " + message;
    }

    // save status (after constructor call)
    this.statusCode = statusCode;
    this.statusText = statusText;
  }
  
}
