package com.example.praroop.trypbuddycom.Models;

import org.json.JSONArray;
import org.json.JSONObject;

public class CombineDataSetNew
{
	JSONArray jsonArray;
	JSONObject jsonObject;
	String cateory;
	String coupon_title;
	String discount;
	String expires;
	String code;
	String url;
	String sucess;
	String coupon_today;
	String button_text;
	String page_text;
	String image;
	String status;

	public String getCreate_date() {
		return create_date;
	}

	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}

	public String getCateory() {
		return cateory;
	}

	public void setCateory(String cateory) {
		this.cateory = cateory;
	}

	public String getCoupon_title() {
		return coupon_title;
	}

	public void setCoupon_title(String coupon_title) {
		this.coupon_title = coupon_title;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getExpires() {
		return expires;
	}

	public String getExpired() {
		return Expired;
	}

	public void setExpired(String expired) {
		Expired = expired;
	}

	public void setExpires(String expires) {

		this.expires = expires;
	}
	String Expired;
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescp() {
		return descp;
	}

	public void setDescp(String descp) {
		this.descp = descp;
	}

	public String getSucess() {
		return sucess;
	}

	public void setSucess(String sucess) {
		this.sucess = sucess;
	}
String descp;
	public String getCoupon_today() {
		return coupon_today;
	}

	public void setCoupon_today(String coupon_today) {
		this.coupon_today = coupon_today;
	}

	public String getButton_text() {
		return button_text;
	}

	public void setButton_text(String button_text) {
		this.button_text = button_text;
	}

	public String getPage_text() {
		return page_text;
	}

	public void setPage_text(String page_text) {
		this.page_text = page_text;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	String create_date;
	public String getStatus() {
		return Status;
	}

	public JSONArray getJsonArray() {
		return jsonArray;
	}

	public void setJsonArray(JSONArray jsonArray) {
		this.jsonArray = jsonArray;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getEmail() {
		return Email;
	}

	public int getTODAY_LEAD() {
		return TODAY_LEAD;
	}

	public void setTODAY_LEAD(int TODAY_LEAD) {
		this.TODAY_LEAD = TODAY_LEAD;
	}

	public int getPENDING_LEAD() {
		return PENDING_LEAD;
	}

	public void setPENDING_LEAD(int PENDING_LEAD) {
		this.PENDING_LEAD = PENDING_LEAD;
	}

	public int getCOMPLETED_LEAD() {
		return COMPLETED_LEAD;
	}

	public void setCOMPLETED_LEAD(int COMPLETED_LEAD) {
		this.COMPLETED_LEAD = COMPLETED_LEAD;
	}

	public int getINACTIVE_LEAD() {
		return INACTIVE_LEAD;
	}

	public void setINACTIVE_LEAD(int INACTIVE_LEAD) {
		this.INACTIVE_LEAD = INACTIVE_LEAD;
	}

	public int getTOTAL_VISIT_LEAD() {
		return TOTAL_VISIT_LEAD;
	}

	public void setTOTAL_VISIT_LEAD(int TOTAL_VISIT_LEAD) {
		this.TOTAL_VISIT_LEAD = TOTAL_VISIT_LEAD;
	}

	public int getTODAY_VISIT_LEAD() {
		return TODAY_VISIT_LEAD;
	}

	public void setTODAY_VISIT_LEAD(int TODAY_VISIT_LEAD) {
		this.TODAY_VISIT_LEAD = TODAY_VISIT_LEAD;
	}

	public int getCALL_AGAIN_LEAD() {
		return CALL_AGAIN_LEAD;
	}

	public void setCALL_AGAIN_LEAD(int CALL_AGAIN_LEAD) {
		this.CALL_AGAIN_LEAD = CALL_AGAIN_LEAD;
	}

	public int getREJECTED_LEAD() {
		return REJECTED_LEAD;
	}

	public void setREJECTED_LEAD(int REJECTED_LEAD) {
		this.REJECTED_LEAD = REJECTED_LEAD;
	}

	public int getAyonlead() {

		return ayonlead;
	}

	public void setAyonlead(int ayonlead) {
		this.ayonlead = ayonlead;
	}
int TODAY_LEAD,PENDING_LEAD,COMPLETED_LEAD,INACTIVE_LEAD,TOTAL_VISIT_LEAD,TODAY_VISIT_LEAD,CALL_AGAIN_LEAD,REJECTED_LEAD;
	public void setEmail(String email) {
		Email = email;
	}

	String Email;
	String Password;
	String Status;
	int ayonlead;
	public String getID() {
		return ID;
	}

	public String getChangepassword() {
		return Changepassword;
	}

	public void setChangepassword(String changepassword) {
		Changepassword = changepassword;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUSERID() {
		return USERID;
	}

	public void setUSERID(String USERID) {
		this.USERID = USERID;
	}

	String USERID;

	public void setID(String ID) {
		this.ID = ID;

	}
	String id;
String Changepassword;
	public String getDonarType() {
		return DonarType;
	}

	public void setDonarType(String donarType) {
		DonarType = donarType;
	}

	public String getDonarName() {
		return DonarName;
	}

	public String getCustomerid() {
		return Customerid;
	}

	public void setCustomerid(String customerid) {
		Customerid = customerid;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public String getOtp() {
		return otp;
	}

	public String getUser_type() {
		return user_type;
	}

	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}

	public String getAdmin_level() {
		return admin_level;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public void setAdmin_level(String admin_level) {
		this.admin_level = admin_level;
	}
	String authority;

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCustomerm() {
		return customerm;
	}

	public void setCustomerm(String customerm) {
		this.customerm = customerm;
	}

	public String getVerify_code() {
		return verify_code;
	}

	public void setVerify_code(String verify_code) {
		this.verify_code = verify_code;
	}

	public String getLogin_status() {
		return login_status;
	}

	public void setLogin_status(String login_status) {
		this.login_status = login_status;
	}

	public void setOtp(String otp) {

		this.otp = otp;
	}
String user_type,admin_level,company,customerm,email,verify_code,mobile,login_status;
	public void setDonarName(String donarName) {
		DonarName = donarName;
	}
	String Customerid,usertype,otp;

	public String getProfession() {
		return profession;
	}

	public String getMobile() {
		return Mobile;
	}

	public String getLandline() {
		return Landline;
	}

	public void setLandline(String landline) {
		Landline = landline;
	}

	public void setMobile(String mobile) {
		Mobile = mobile;

	}

	public String getStatus1() {
		return status1;
	}

	public void setStatus1(String status1) {
		this.status1 = status1;
	}

	public String getRegister_on() {
		return register_on;
	}

	public String getMobile_privacy() {
		return mobile_privacy;
	}

	public void setMobile_privacy(String mobile_privacy) {
		this.mobile_privacy = mobile_privacy;
	}

	public String getEmail_privacy() {
		return email_privacy;
	}

	public void setEmail_privacy(String email_privacy) {
		this.email_privacy = email_privacy;
	}

	public void setRegister_on(String register_on) {
		this.register_on = register_on;

	}

	public String getAgreed() {
		return agreed;

	}

	public String getLandline_privacy() {
		return Landline_privacy;
	}

	public String getDeactive_account() {
		return deactive_account;
	}

	public void setDeactive_account(String deactive_account) {
		this.deactive_account = deactive_account;
	}

	public void setLandline_privacy(String landline_privacy) {
		Landline_privacy = landline_privacy;
	}

	public String getUpdated_on() {
		return updated_on;
	}

	public String getLangitute() {
		return Langitute;
	}

	public String getLatitude() {
		return Latitude;
	}

	public void setLatitude(String latitude) {
		Latitude = latitude;
	}

	public void setLangitute(String langitute) {
		Langitute = langitute;
	}

	public void setUpdated_on(String updated_on) {
		this.updated_on = updated_on;

	}
	String Langitute,Latitude;

	public void setAgreed(String agreed) {
		this.agreed = agreed;
	}

	public void setProfession(String profession) {

		this.profession = profession;
	}
String Specilization,DateofBirth,Gender,BloodGroup,location,Pincode,Mobile,Landline,
		agreed,register_on,status1,mobile_privacy,email_privacy,Landline_privacy,deactive_account,updated_on;

	public String getPincode() {
		return Pincode;
	}

	public void setPincode(String pincode) {
		Pincode = pincode;
	}

	public String getSpecilization() {
		return Specilization;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getBloodGroup() {

		return BloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		BloodGroup = bloodGroup;
	}

	public String getDateofBirth() {
		return DateofBirth;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public void setDateofBirth(String dateofBirth) {
		DateofBirth = dateofBirth;
	}

	public void setSpecilization(String specilization) {
		Specilization = specilization;
	}

	String ID,DonarType,DonarName,profession;

	public JSONObject getJsonObject() {
		return jsonObject;
	}

	public void setJsonObject(JSONObject jsonObject) {
		this.jsonObject = jsonObject;
	}
	/*String PartyId;
	String Password;

	public String getPartyId() {
		return PartyId;
	}

	public void setPartyId(String partyId) {
		PartyId = partyId;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getUserID() {
		return UserID;
	}

	public void setUserID(String userID) {
		UserID = userID;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	String UserID;
	String UserName;
	String type;
	public CombineDataSetNew() {
		super();
	}*/



}
