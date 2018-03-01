package com.anyikang.model;

/**
 * 
 * @author LvXiaoxiong on 2017/05/02
 *
 */
public class Heartbeat {
    
	private String id;
	private String imeiCode;
	private int dataLength;
	private byte functionCode;
	private String time;
	private String crc8;
	public Heartbeat(String id, String imeiCode, int dataLength, byte functionCode, String time, String crc8) {
		super();
		this.id = id;
		this.imeiCode = imeiCode;
		this.dataLength = dataLength;
		this.functionCode = functionCode;
		this.time = time;
		this.crc8 = crc8;
	}
	public Heartbeat() {
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getImeiCode() {
		return imeiCode;
	}
	public void setImeiCode(String imeiCode) {
		this.imeiCode = imeiCode;
	}
	public int getDataLength() {
		return dataLength;
	}
	public void setDataLength(int dataLength) {
		this.dataLength = dataLength;
	}
	public byte getFunctionCode() {
		return functionCode;
	}
	public void setFunctionCode(byte functionCode) {
		this.functionCode = functionCode;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getCrc8() {
		return crc8;
	}
	public void setCrc8(String crc8) {
		this.crc8 = crc8;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + functionCode;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((imeiCode == null) ? 0 : imeiCode.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Heartbeat other = (Heartbeat) obj;
		if (functionCode != other.functionCode)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (imeiCode == null) {
			if (other.imeiCode != null)
				return false;
		} else if (!imeiCode.equals(other.imeiCode))
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Heartbeat [id=" + id + ", imeiCode=" + imeiCode + ", dataLength=" + dataLength + ", functionCode="
				+ functionCode + ", time=" + time + ", crc8=" + crc8 + "]";
	}
	
	
	
	
	
}    