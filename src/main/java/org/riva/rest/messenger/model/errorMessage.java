package org.riva.rest.messenger.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class errorMessage {
	
	private String errormsg;
	private int errCode;
	private String documentation;
	
	public errorMessage() {
		// TODO Auto-generated constructor stub
	}	
	
	public errorMessage(String errormsg, int errCode, String documentation) {
		super();
		this.errormsg = errormsg;
		this.errCode = errCode;
		this.documentation = documentation;
	}




	public String getErrormsg() {
		return errormsg;
	}
	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}
	public int getErrCode() {
		return errCode;
	}
	public void setErrCode(int errCode) {
		this.errCode = errCode;
	}
	public String getDocumentation() {
		return documentation;
	}
	public void setDocumentation(String documentation) {
		this.documentation = documentation;
	}
	
	

}
