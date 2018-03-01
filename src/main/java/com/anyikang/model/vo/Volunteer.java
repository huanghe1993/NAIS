package com.anyikang.model.vo;


/**
 * 志愿者实体类
 * @author lvXiaoxiong 2017/06/29
 *
 */
public class Volunteer {
	
	private String volunteerId;
	private int rescueTeamId;//队伍Id
	private String name;//姓名
	private String imageUrl;//头像
	private String sex;//性别
	private String password;//密码
	private String mobile;//手机号(手机号为志愿者登录账号)
	private String identityCard;//身份证号
	private String personnelForm;//人员构成
	
	public Volunteer(){
		
	}

	public Volunteer(String volunteerId, int rescueTeamId, String name, String imageUrl, String sex, String password,
			String mobile, String identityCard, String personnelForm) {
		super();
		this.volunteerId = volunteerId;
		this.rescueTeamId = rescueTeamId;
		this.name = name;
		this.imageUrl = imageUrl;
		this.sex = sex;
		this.password = password;
		this.mobile = mobile;
		this.identityCard = identityCard;
		this.personnelForm = personnelForm;
	}

	public String getVolunteerId() {
		return volunteerId;
	}

	public void setVolunteerId(String volunteerId) {
		this.volunteerId = volunteerId;
	}

	public int getRescueTeamId() {
		return rescueTeamId;
	}

	public void setRescueTeamId(int rescueTeamId) {
		this.rescueTeamId = rescueTeamId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getIdentityCard() {
		return identityCard;
	}

	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}

	public String getPersonnelForm() {
		return personnelForm;
	}

	public void setPersonnelForm(String personnelForm) {
		this.personnelForm = personnelForm;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((identityCard == null) ? 0 : identityCard.hashCode());
		result = prime * result + ((imageUrl == null) ? 0 : imageUrl.hashCode());
		result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((personnelForm == null) ? 0 : personnelForm.hashCode());
		result = prime * result + rescueTeamId;
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		result = prime * result + ((volunteerId == null) ? 0 : volunteerId.hashCode());
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
		Volunteer other = (Volunteer) obj;
		if (identityCard == null) {
			if (other.identityCard != null)
				return false;
		} else if (!identityCard.equals(other.identityCard))
			return false;
		if (imageUrl == null) {
			if (other.imageUrl != null)
				return false;
		} else if (!imageUrl.equals(other.imageUrl))
			return false;
		if (mobile == null) {
			if (other.mobile != null)
				return false;
		} else if (!mobile.equals(other.mobile))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (personnelForm == null) {
			if (other.personnelForm != null)
				return false;
		} else if (!personnelForm.equals(other.personnelForm))
			return false;
		if (rescueTeamId != other.rescueTeamId)
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		if (volunteerId == null) {
			if (other.volunteerId != null)
				return false;
		} else if (!volunteerId.equals(other.volunteerId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Volunteer [volunteerId=" + volunteerId + ", rescueTeamId=" + rescueTeamId + ", name=" + name
				+ ", imageUrl=" + imageUrl + ", sex=" + sex + ", password=" + password + ", mobile=" + mobile
				+ ", identityCard=" + identityCard + ", personnelForm=" + personnelForm + "]";
	}

	

}
