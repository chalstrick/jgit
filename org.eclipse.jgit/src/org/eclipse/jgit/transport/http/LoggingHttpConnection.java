package org.eclipse.jgit.transport.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ProtocolException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import javax.net.ssl.TrustManager;

import org.slf4j.Logger;

/**
 * @since 4.2
 */
public class LoggingHttpConnection implements HttpConnection {
	private Logger LOG;

	HttpConnection wrappedConnection;

	public int getResponseCode() throws IOException {
		return wrappedConnection.getResponseCode();
	}

	public URL getURL() {
		return wrappedConnection.getURL();
	}

	public String getResponseMessage() throws IOException {
		return wrappedConnection.getResponseMessage();
	}

	public Map<String, List<String>> getHeaderFields() {
		return wrappedConnection.getHeaderFields();
	}

	public void setRequestProperty(String key, String value) {
		if (LOG.isDebugEnabled()) LOG.debug("conn({}).{}={}", wrappedConnection, key, value);
		wrappedConnection.setRequestProperty(key, value);
	}

	public void setRequestMethod(String method) throws ProtocolException {
		if (LOG.isDebugEnabled()) LOG.debug("conn({}).method={}", wrappedConnection, method);
		wrappedConnection.setRequestMethod(method);
	}

	public void setUseCaches(boolean usecaches) {
		wrappedConnection.setUseCaches(usecaches);
	}

	public void setConnectTimeout(int timeout) {
		wrappedConnection.setConnectTimeout(timeout);
	}

	public void setReadTimeout(int timeout) {
		wrappedConnection.setReadTimeout(timeout);
	}

	public String getContentType() {
		return wrappedConnection.getContentType();
	}

	public InputStream getInputStream() throws IOException {
		return wrappedConnection.getInputStream();
	}

	public String getHeaderField(String name) {
		return wrappedConnection.getHeaderField(name);
	}

	public int getContentLength() {
		return wrappedConnection.getContentLength();
	}

	public void setInstanceFollowRedirects(boolean followRedirects) {
		wrappedConnection.setInstanceFollowRedirects(followRedirects);
	}

	public void setDoOutput(boolean dooutput) {
		wrappedConnection.setDoOutput(dooutput);
	}

	public void setFixedLengthStreamingMode(int contentLength) {
		wrappedConnection.setFixedLengthStreamingMode(contentLength);
	}

	public OutputStream getOutputStream() throws IOException {
		return wrappedConnection.getOutputStream();
	}

	public void setChunkedStreamingMode(int chunklen) {
		wrappedConnection.setChunkedStreamingMode(chunklen);
	}

	public String getRequestMethod() {
		return wrappedConnection.getRequestMethod();
	}

	public boolean usingProxy() {
		return wrappedConnection.usingProxy();
	}

	public void connect() throws IOException {
		if (LOG.isDebugEnabled()) LOG.debug("conn({}).connect()", wrappedConnection);
		wrappedConnection.connect();
	}

	public void configure(KeyManager[] km, TrustManager[] tm,
			SecureRandom random)
					throws NoSuchAlgorithmException, KeyManagementException {
		wrappedConnection.configure(km, tm, random);
	}

	public void setHostnameVerifier(HostnameVerifier hostnameverifier)
			throws NoSuchAlgorithmException, KeyManagementException {
		wrappedConnection.setHostnameVerifier(hostnameverifier);
	}

	/**
	 * @param conn
	 * @param l
	 *
	 */
	public LoggingHttpConnection(HttpConnection conn, Logger l) {
		wrappedConnection=conn;
		LOG = l;
	}

}
