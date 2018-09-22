package com.jsoneg.demo.dto;

public class ExtraDTO {

	private String orgname;
	private DeepDTO deepDTO;
	public String getOrgname() {
		return orgname;
	}
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}
	public DeepDTO getDeepDTO() {
		return deepDTO;
	}
	public void setDeepDTO(DeepDTO deepDTO) {
		this.deepDTO = deepDTO;
	}
	@Override
	public String toString() {
		return "ExtraDTO [orgname=" + orgname + ", deepDTO=" + deepDTO + "]";
	}
	
	
	
}
