package com.example.controller;

import java.sql.Array;


public  class User {
	private long id;
	private String countryCode;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String email;
	private Long creationDate;
	private Long modificationDate;
	private String dob;
	private String fbId;
	//private String fbUserName;
	private String googleId;
	//private String googleUserName;
	private String profileUrl;
	private String gender;
	private int roleId;
	private boolean isFollowedByMe;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Long creationDate) {
		this.creationDate = creationDate;
	}
	public Long getModificationDate() {
		return modificationDate;
	}
	public void setModificationDate(Long modificationDate) {
		this.modificationDate = modificationDate;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getFbId() {
		return fbId;
	}
	public void setFbId(String fbId) {
		this.fbId = fbId;
	}
	public String getGoogleId() {
		return googleId;
	}
	public void setGoogleId(String googleId) {
		this.googleId = googleId;
	}
	public String getProfileUrl() {
		return profileUrl;
	}
	public void setProfileUrl(String profileUrl) {
		this.profileUrl = profileUrl;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public boolean isFollowedByMe() {
		return isFollowedByMe;
	}
	public void setFollowedByMe(boolean isFollowedByMe) {
		this.isFollowedByMe = isFollowedByMe;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	public long getRank() {
		return rank;
	}
	public void setRank(long rank) {
		this.rank = rank;
	}
	public boolean isCityTopper() {
		return cityTopper;
	}
	public void setCityTopper(boolean cityTopper) {
		this.cityTopper = cityTopper;
	}
	public long getWeeklyCount() {
		return weeklyCount;
	}
	public void setWeeklyCount(long weeklyCount) {
		this.weeklyCount = weeklyCount;
	}
	public Boolean getVerified() {
		return verified;
	}
	public void setVerified(Boolean verified) {
		this.verified = verified;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public Long getPoints() {
		return points;
	}
	public void setPoints(Long points) {
		this.points = points;
	}
	private String stateName;
	private String cityName;
	private String latitude;
	private String longitude;
	private long count;
	private long rank;
	private boolean cityTopper;
	private long weeklyCount;
	private Boolean verified;
	private String bio;
	private Long points;
	public User() {
		
	};
	
}
