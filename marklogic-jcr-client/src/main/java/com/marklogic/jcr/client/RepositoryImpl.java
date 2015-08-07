package com.marklogic.jcr.client;

import javax.jcr.Credentials;
import javax.jcr.LoginException;
import javax.jcr.NoSuchWorkspaceException;
import javax.jcr.Repository;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.SimpleCredentials;
import javax.jcr.Value;

import com.marklogic.client.DatabaseClient;
import com.marklogic.client.DatabaseClientFactory;
import com.marklogic.client.DatabaseClientFactory.Authentication;

public class RepositoryImpl implements Repository {
	
	String hostname = "localhost";
	int port = 8003;
	Authentication auth = Authentication.DIGEST;
	
	DatabaseClient dc = null;
	
	SessionImpl session = null;
	
	public RepositoryImpl() {
	}
	
	public RepositoryImpl(String host,int port,Authentication auth) {
		this.hostname = host;
		this.port = port;
		this.auth = auth;
	}
	
	// JCR API implementation

	public String getDescriptor(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public String[] getDescriptorKeys() {
		// TODO Auto-generated method stub
		return null;
	}

	public Value getDescriptorValue(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public Value[] getDescriptorValues(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isSingleValueDescriptor(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isStandardDescriptor(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public Session login() throws LoginException, RepositoryException {
		// TODO Auto-generated method stub
		return null;
	}
	
	protected Session createSession(String user,String pass) {
	  dc = DatabaseClientFactory.newClient(hostname,port,user, pass,auth);
	  this.session = new SessionImpl(dc);
	  return this.session;
	}

	public Session login(Credentials creds) throws LoginException,
			RepositoryException {
	  if (creds instanceof SimpleCredentials) {
		SimpleCredentials sc = (SimpleCredentials)creds;
		String user = sc.getUserID();
		String pass = new String(sc.getPassword());
		
		// TODO create ML Connection instance
		// return session wrapper around this ML connection instance
		return createSession(user,pass);
	  }
	  throw new LoginException("Credential type not supported");
	}

	public Session login(String arg0) throws LoginException,
			NoSuchWorkspaceException, RepositoryException {
		// TODO Auto-generated method stub
		return null;
	}

	public Session login(Credentials arg0, String arg1) throws LoginException,
			NoSuchWorkspaceException, RepositoryException {
		// TODO Auto-generated method stub
		return null;
	}

}
