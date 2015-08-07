package com.marklogic.jcr.commons;

import javax.jcr.Repository;

import com.marklogic.jcr.client.RepositoryImpl;

public class JcrUtils {
  public static Repository getRepository() {
	return new RepositoryImpl();
  }
  
  
}
