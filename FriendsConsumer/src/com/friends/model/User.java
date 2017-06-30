package com.friends.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.annotations.Entity;

@Entity
@Table(name="User_TAB")
public class User {
		@Id
		@GeneratedValue(generator="user",strategy=GenerationType.SEQUENCE)
		@SequenceGenerator(name="user",sequenceName="user_seq")
		@Column(name="u_id")
		private int userId;
		@Column(name="u_name")
		private String userName;
		@Column(name="u_email")
		private String userEmail;
		@Column(name="u_mobile")
		private String userMobile;
		@Column(name="birthday")
		private String birthDay;
		@Column(name="pwd")
		private String pwd;
		@Column(name="token")
		private String token;
		public User() {
			super();
		}
		public User(int userId) {
			super();
			this.userId = userId;
		}
		public User(int userId, String userName) {
			super();
			this.userId = userId;
			this.userName = userName;
		}
		public User(int userId, String userName, String userEmail) {
			super();
			this.userId = userId;
			this.userName = userName;
			this.userEmail = userEmail;
		}
		public User(int userId, String userName, String userEmail, String userMobile) {
			super();
			this.userId = userId;
			this.userName = userName;
			this.userEmail = userEmail;
			this.userMobile = userMobile;
		}
		public User(int userId, String userName, String userEmail, String userMobile, String birthDay) {
			super();
			this.userId = userId;
			this.userName = userName;
			this.userEmail = userEmail;
			this.userMobile = userMobile;
			this.birthDay = birthDay;
		}
		public User(int userId, String userName, String userEmail, String userMobile, String birthDay, String pwd) {
			super();
			this.userId = userId;
			this.userName = userName;
			this.userEmail = userEmail;
			this.userMobile = userMobile;
			this.birthDay = birthDay;
			this.pwd = pwd;
		}
		public User(int userId, String userName, String userEmail, String userMobile, String birthDay, String pwd,
				String token) {
			super();
			this.userId = userId;
			this.userName = userName;
			this.userEmail = userEmail;
			this.userMobile = userMobile;
			this.birthDay = birthDay;
			this.pwd = pwd;
			this.token = token;
		}
		public int getUserId() {
			return userId;
		}
		public void setUserId(int userId) {
			this.userId = userId;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getUserEmail() {
			return userEmail;
		}
		public void setUserEmail(String userEmail) {
			this.userEmail = userEmail;
		}
		public String getUserMobile() {
			return userMobile;
		}
		public void setUserMobile(String userMobile) {
			this.userMobile = userMobile;
		}
		public String getBirthDay() {
			return birthDay;
		}
		public void setBirthDay(String birthDay) {
			this.birthDay = birthDay;
		}
		public String getPwd() {
			return pwd;
		}
		public void setPwd(String pwd) {
			this.pwd = pwd;
		}
		public String getToken() {
			return token;
		}
		public void setToken(String token) {
			this.token = token;
		}
		@Override
		public String toString() {
			return "User [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", userMobile="
					+ userMobile + ", birthDay=" + birthDay + ", pwd=" + pwd + ", token=" + token + "]";
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((birthDay == null) ? 0 : birthDay.hashCode());
			result = prime * result + ((pwd == null) ? 0 : pwd.hashCode());
			result = prime * result + ((token == null) ? 0 : token.hashCode());
			result = prime * result + ((userEmail == null) ? 0 : userEmail.hashCode());
			result = prime * result + userId;
			result = prime * result + ((userMobile == null) ? 0 : userMobile.hashCode());
			result = prime * result + ((userName == null) ? 0 : userName.hashCode());
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
			User other = (User) obj;
			if (birthDay == null) {
				if (other.birthDay != null)
					return false;
			} else if (!birthDay.equals(other.birthDay))
				return false;
			if (pwd == null) {
				if (other.pwd != null)
					return false;
			} else if (!pwd.equals(other.pwd))
				return false;
			if (token == null) {
				if (other.token != null)
					return false;
			} else if (!token.equals(other.token))
				return false;
			if (userEmail == null) {
				if (other.userEmail != null)
					return false;
			} else if (!userEmail.equals(other.userEmail))
				return false;
			if (userId != other.userId)
				return false;
			if (userMobile == null) {
				if (other.userMobile != null)
					return false;
			} else if (!userMobile.equals(other.userMobile))
				return false;
			if (userName == null) {
				if (other.userName != null)
					return false;
			} else if (!userName.equals(other.userName))
				return false;
			return true;
		}
	

}
