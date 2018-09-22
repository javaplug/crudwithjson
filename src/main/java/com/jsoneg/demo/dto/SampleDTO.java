package com.jsoneg.demo.dto;

public class SampleDTO {

	private ExtraDTO extraDTO;
	private Integer creditPoints;
	private String target;
	private Integer samplevalue;

	public Integer getCreditPoints() {
		return creditPoints;
	}

	public void setCreditPoints(Integer creditPoints) {
		this.creditPoints = creditPoints;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public Integer getSamplevalue() {
		return samplevalue;
	}

	public void setSamplevalue(Integer samplevalue) {
		this.samplevalue = samplevalue;
	}

	public ExtraDTO getExtraDTO() {
		return extraDTO;
	}

	public void setExtraDTO(ExtraDTO extraDTO) {
		this.extraDTO = extraDTO;
	}

	@Override
	public String toString() {
		return "SampleDTO [creditPoints=" + creditPoints + ", target=" + target + ", samplevalue=" + samplevalue
				+ ", extraDTO=" + extraDTO + "]";
	}

}
