package org.aisbreaker.api;

import java.util.concurrent.CompletableFuture;

import org.aisbreaker.api.model.Request;
import org.aisbreaker.api.model.ResponseFinal;

public interface AIsService {
  /**
   * Let the service do its work. Blocking.
   */
  public ResponseFinal process(Request request) throws AIsError;

  /**
   * Let the service do its work. Non-Blocking.
   */
  public CompletableFuture<ResponseFinal> processNonBlocking(Request request) throws AIsError;
}
