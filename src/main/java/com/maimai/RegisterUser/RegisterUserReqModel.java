package com.maimai.RegisterUser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RegisterUserReqModel {

	 private String userId; //ユーザーID
	    private String password; //パスワード
	    private String userName; //ユーザー名
	    private Date birthday; //誕生日
	    private int age; //年齢
	    private boolean marriage; //結婚ステータス
	    private String role; //ロール
		/**
		 * @return the userId
		 */
		public String getUserId() {
			return userId;
		}
		/**
		 * @param userId the userId to set
		 */
		public void setUserId(String userId) {
			this.userId = userId;
		}
		/**
		 * @return the password
		 */
		public String getPassword() {
			return password;
		}
		/**
		 * @param password the password to set
		 */
		public void setPassword(String password) {
			this.password = password;
		}
		/**
		 * @return the userName
		 */
		public String getUserName() {
			return userName;
		}
		/**
		 * @param userName the userName to set
		 */
		public void setUserName(String userName) {
			this.userName = userName;
		}
		/**
		 * @return the birthday
		 */
		public Date getBirthday() {
			return birthday;
		}
		/**
		 * @param birthday the birthday to set
		 */
		public void setBirthday(Date birthday) {
			this.birthday = birthday;
		}
		/**
		 * @return the age
		 */
		public int getAge() {
			return age;
		}
		/**
		 * @param age the age to set
		 */
		public void setAge(int age) {
			this.age = age;
		}
		/**
		 * @return the marriage
		 */
		public boolean isMarriage() {
			return marriage;
		}
		/**
		 * @param marriage the marriage to set
		 */
		public void setMarriage(boolean marriage) {
			this.marriage = marriage;
		}
		/**
		 * @return the role
		 */
		public String getRole() {
			return role;
		}
		/**
		 * @param role the role to set
		 */
		public void setRole(String role) {
			this.role = role;
		}
		public static List<RegisterUserReqModel> getListUser (List<String> listStr)
		{
			List<RegisterUserReqModel> listUser = new ArrayList<RegisterUserReqModel>();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			for (String str : listStr) {
				RegisterUserReqModel user = new RegisterUserReqModel();
				String[] item = str.split(",");
				user.setUserId(item[0]);
				user.setPassword(item[1]);
				user.setUserName(item[2]);
				Date date;
				try {
					date = formatter.parse(item[3]);
					user.setBirthday(date);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				user.setAge(Integer.parseInt(item[4]));
				user.setMarriage(Boolean.parseBoolean(item[5]));
				user.setRole(item[6]);
				listUser.add(user);
			}
			return listUser;
		}
	    
}
