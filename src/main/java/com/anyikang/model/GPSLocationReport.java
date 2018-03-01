package com.anyikang.model;



/**
 * 
 * @author LvXiaoxiong on 2017/05/03
 * GPS定位上报信息类
 *
 */
public class GPSLocationReport {

    private String id; //UUID
    private String imeiCode; //设备imei号
    private int dataLength; //数据长度
    private byte functionCode; //功能码
    private String serialNumber; //流水号
    private String responseControl; //回复控制
    private String deviceStatus;//设备状态
    private byte locationMode; //定位方式
    private float latitude; //纬度
    private float longitude; //经度
    private float height; //高度
    private float speed;  //速度
    private float direction; //方向
    private float precision; //精度
    private String positioningTime; //定位时间
    private String electricity; //电量
    private String reportTime;//上报时间
    private String crc8;//crc8码
    private String memoryTime;//存储时间
    public GPSLocationReport() {
        
    }
	public GPSLocationReport(String id, String imeiCode, int dataLength, byte functionCode, String serialNumber,
			String responseControl, String deviceStatus, byte locationMode, float latitude, float longitude,
			float height, float speed, float direction, float precision, String positioningTime, String electricity,
			String reportTime, String crc8, String memoryTime) {
		super();
		this.id = id;
		this.imeiCode = imeiCode;
		this.dataLength = dataLength;
		this.functionCode = functionCode;
		this.serialNumber = serialNumber;
		this.responseControl = responseControl;
		this.deviceStatus = deviceStatus;
		this.locationMode = locationMode;
		this.latitude = latitude;
		this.longitude = longitude;
		this.height = height;
		this.speed = speed;
		this.direction = direction;
		this.precision = precision;
		this.positioningTime = positioningTime;
		this.electricity = electricity;
		this.reportTime = reportTime;
		this.crc8 = crc8;
		this.memoryTime = memoryTime;
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
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getResponseControl() {
		return responseControl;
	}
	public void setResponseControl(String responseControl) {
		this.responseControl = responseControl;
	}
	public String getDeviceStatus() {
		return deviceStatus;
	}
	public void setDeviceStatus(String deviceStatus) {
		this.deviceStatus = deviceStatus;
	}
	public byte getLocationMode() {
		return locationMode;
	}
	public void setLocationMode(byte locationMode) {
		this.locationMode = locationMode;
	}
	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	public float getSpeed() {
		return speed;
	}
	public void setSpeed(float speed) {
		this.speed = speed;
	}
	public float getDirection() {
		return direction;
	}
	public void setDirection(float direction) {
		this.direction = direction;
	}
	public float getPrecision() {
		return precision;
	}
	public void setPrecision(float precision) {
		this.precision = precision;
	}
	public String getPositioningTime() {
		return positioningTime;
	}
	public void setPositioningTime(String positioningTime) {
		this.positioningTime = positioningTime;
	}
	public String getElectricity() {
		return electricity;
	}
	public void setElectricity(String electricity) {
		this.electricity = electricity;
	}
	public String getReportTime() {
		return reportTime;
	}
	public void setReportTime(String reportTime) {
		this.reportTime = reportTime;
	}
	public String getCrc8() {
		return crc8;
	}
	public void setCrc8(String crc8) {
		this.crc8 = crc8;
	}
	public String getMemoryTime() {
		return memoryTime;
	}
	public void setMemoryTime(String memoryTime) {
		this.memoryTime = memoryTime;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((crc8 == null) ? 0 : crc8.hashCode());
		result = prime * result + dataLength;
		result = prime * result + ((deviceStatus == null) ? 0 : deviceStatus.hashCode());
		result = prime * result + Float.floatToIntBits(direction);
		result = prime * result + ((electricity == null) ? 0 : electricity.hashCode());
		result = prime * result + functionCode;
		result = prime * result + Float.floatToIntBits(height);
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((imeiCode == null) ? 0 : imeiCode.hashCode());
		result = prime * result + Float.floatToIntBits(latitude);
		result = prime * result + locationMode;
		result = prime * result + Float.floatToIntBits(longitude);
		result = prime * result + ((memoryTime == null) ? 0 : memoryTime.hashCode());
		result = prime * result + ((positioningTime == null) ? 0 : positioningTime.hashCode());
		result = prime * result + Float.floatToIntBits(precision);
		result = prime * result + ((reportTime == null) ? 0 : reportTime.hashCode());
		result = prime * result + ((responseControl == null) ? 0 : responseControl.hashCode());
		result = prime * result + ((serialNumber == null) ? 0 : serialNumber.hashCode());
		result = prime * result + Float.floatToIntBits(speed);
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
		GPSLocationReport other = (GPSLocationReport) obj;
		if (crc8 == null) {
			if (other.crc8 != null)
				return false;
		} else if (!crc8.equals(other.crc8))
			return false;
		if (dataLength != other.dataLength)
			return false;
		if (deviceStatus == null) {
			if (other.deviceStatus != null)
				return false;
		} else if (!deviceStatus.equals(other.deviceStatus))
			return false;
		if (Float.floatToIntBits(direction) != Float.floatToIntBits(other.direction))
			return false;
		if (electricity == null) {
			if (other.electricity != null)
				return false;
		} else if (!electricity.equals(other.electricity))
			return false;
		if (functionCode != other.functionCode)
			return false;
		if (Float.floatToIntBits(height) != Float.floatToIntBits(other.height))
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
		if (Float.floatToIntBits(latitude) != Float.floatToIntBits(other.latitude))
			return false;
		if (locationMode != other.locationMode)
			return false;
		if (Float.floatToIntBits(longitude) != Float.floatToIntBits(other.longitude))
			return false;
		if (memoryTime == null) {
			if (other.memoryTime != null)
				return false;
		} else if (!memoryTime.equals(other.memoryTime))
			return false;
		if (positioningTime == null) {
			if (other.positioningTime != null)
				return false;
		} else if (!positioningTime.equals(other.positioningTime))
			return false;
		if (Float.floatToIntBits(precision) != Float.floatToIntBits(other.precision))
			return false;
		if (reportTime == null) {
			if (other.reportTime != null)
				return false;
		} else if (!reportTime.equals(other.reportTime))
			return false;
		if (responseControl == null) {
			if (other.responseControl != null)
				return false;
		} else if (!responseControl.equals(other.responseControl))
			return false;
		if (serialNumber == null) {
			if (other.serialNumber != null)
				return false;
		} else if (!serialNumber.equals(other.serialNumber))
			return false;
		if (Float.floatToIntBits(speed) != Float.floatToIntBits(other.speed))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "GPSLocationReport [id=" + id + ", imeiCode=" + imeiCode + ", dataLength=" + dataLength
				+ ", functionCode=" + functionCode + ", serialNumber=" + serialNumber + ", responseControl="
				+ responseControl + ", deviceStatus=" + deviceStatus + ", locationMode=" + locationMode + ", latitude="
				+ latitude + ", longitude=" + longitude + ", height=" + height + ", speed=" + speed + ", direction="
				+ direction + ", precision=" + precision + ", positioningTime=" + positioningTime + ", electricity="
				+ electricity + ", reportTime=" + reportTime + ", crc8=" + crc8 + ", memoryTime=" + memoryTime + "]";
	}
    
    
}