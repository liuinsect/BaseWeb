/***********************************************************************
 * Module:  LoginUser.java
 * Author:  Administrator
 * Purpose: Defines the Class LoginUser
 ***********************************************************************/

package com.liusoft.userprivilege;

/** @pdOid 90ff7a01-1a5f-4f3b-a41b-4a09c5f8be59 */
public class LoginUser implements java.io.Serializable {
   /** 用户编号
    *
    * @pdOid 68bc5e4d-0827-45f9-8ef2-ca3975778bf3 */
   public Long userId;
   /** 密码
    *
    * @pdOid 26c7caf3-b0ed-46e4-a7e0-6211900df37a */
   public String password;
   /** 状态 在职、离休等
    *
    * @pdOid 1ea7c464-4672-474c-ac0a-a9b8da7a66ff */
   public String status;
   /** 登陆帐号
    *
    * @pdOid 4f8539c2-c2ca-49b3-b327-3e6b73d3a6db */
   public String account;
   /** 用户姓名
    *
    * @pdOid 7542ce39-acd8-4181-8725-ee3436397d82 */
   public String userName;
   /** 照片
    *
    * @pdOid c5bcdf84-f0c4-4828-ada6-31470397802b */
   public String picture;
   /** 联系电话
    *
    * @pdOid a83a6748-8c4d-4f80-ad1b-b51d4da3f095 */
   public String phone;
   /** 联系地址
    *
    * @pdOid 3e546b65-641e-459a-9d8e-08d208319de0 */
   public String address;
   /** 邮箱
    *
    * @pdOid 45ea1145-eb8a-4e9b-bebe-36588f57ef96 */
   public String email;
   /** 备注
    *
    * @pdOid 37010193-8beb-435d-9f82-c58ec3e6ca94 */
   public String descriptions;

   /** @pdRoleInfo migr=no name=Department assc=Relationship19 mult=0..1 side=A */
   public Department department;
   
   /**
    * Empty constructor which is required by Hibernate
    *
    */
   public LoginUser() {
      // TODO Auto-generated constructor stub
   }
   
   /**
    * @pdGenerated default parent getter
    */
   public Department getDepartment() {
      return department;
   }
   
   /**
    * @pdGenerated default parent setter
    * @param newDepartment
    */
   public void setDepartment(Department newDepartment) {
      this.department = newDepartment;
   }
   
   /**
    * Get value of userId
    *
    * @return userId 
    */
   public Long getUserId()
   {
      return userId;
   }
   
   /**
    * Set value of userId
    *
    * @param newUserId 
    */
   public void setUserId(Long newUserId)
   {
      this.userId = newUserId;
   }
   
   /**
    * Get value of password
    *
    * @return password 
    */
   public String getPassword()
   {
      return password;
   }
   
   /**
    * Set value of password
    *
    * @param newPassword 
    */
   public void setPassword(String newPassword)
   {
      this.password = newPassword;
   }
   
   /**
    * Get value of status
    *
    * @return status 
    */
   public String getStatus()
   {
      return status;
   }
   
   /**
    * Set value of status
    *
    * @param newStatus 
    */
   public void setStatus(String newStatus)
   {
      this.status = newStatus;
   }
   
   /**
    * Get value of account
    *
    * @return account 
    */
   public String getAccount()
   {
      return account;
   }
   
   /**
    * Set value of account
    *
    * @param newAccount 
    */
   public void setAccount(String newAccount)
   {
      this.account = newAccount;
   }
   
   /**
    * Get value of userName
    *
    * @return userName 
    */
   public String getUserName()
   {
      return userName;
   }
   
   /**
    * Set value of userName
    *
    * @param newUserName 
    */
   public void setUserName(String newUserName)
   {
      this.userName = newUserName;
   }
   
   /**
    * Get value of picture
    *
    * @return picture 
    */
   public String getPicture()
   {
      return picture;
   }
   
   /**
    * Set value of picture
    *
    * @param newPicture 
    */
   public void setPicture(String newPicture)
   {
      this.picture = newPicture;
   }
   
   /**
    * Get value of phone
    *
    * @return phone 
    */
   public String getPhone()
   {
      return phone;
   }
   
   /**
    * Set value of phone
    *
    * @param newPhone 
    */
   public void setPhone(String newPhone)
   {
      this.phone = newPhone;
   }
   
   /**
    * Get value of address
    *
    * @return address 
    */
   public String getAddress()
   {
      return address;
   }
   
   /**
    * Set value of address
    *
    * @param newAddress 
    */
   public void setAddress(String newAddress)
   {
      this.address = newAddress;
   }
   


   /**
    * Get value of email
    *
    * @return email 
    */
   public String getEmail()
   {
      return email;
   }
   
   /**
    * Set value of email
    *
    * @param newEmail 
    */
   public void setEmail(String newEmail)
   {
      this.email = newEmail;
   }
   
   /**
    * Get value of descriptions
    *
    * @return descriptions 
    */
   public String getDescriptions()
   {
      return descriptions;
   }
   
   /**
    * Set value of descriptions
    *
    * @param newDescriptions 
    */
   public void setDescriptions(String newDescriptions)
   {
      this.descriptions = newDescriptions;
   }
   


   /* (non-Javadoc)
    * @see java.lang.Object#equals(java.lang.Object)
    */
   public boolean equals(Object other) {
   
      if (other == null)
         return false;
      
      if (other == this)
         return true;   
   
      if (!(other instanceof LoginUser))
         return false;
   
      LoginUser cast = (LoginUser) other;
   
      if (this.userId == null ? cast.getUserId() != this.userId : !this.userId.equals( cast.getUserId()))
         return false;
   
      if (this.password == null ? cast.getPassword() != this.password : !this.password.equals( cast.getPassword()))
         return false;
   
      if (this.status == null ? cast.getStatus() != this.status : !this.status.equals( cast.getStatus()))
         return false;
   
      if (this.account == null ? cast.getAccount() != this.account : !this.account.equals( cast.getAccount()))
         return false;
   
      if (this.userName == null ? cast.getUserName() != this.userName : !this.userName.equals( cast.getUserName()))
         return false;
   
      if (this.picture == null ? cast.getPicture() != this.picture : !this.picture.equals( cast.getPicture()))
         return false;
   
      if (this.phone == null ? cast.getPhone() != this.phone : !this.phone.equals( cast.getPhone()))
         return false;
   
      if (this.address == null ? cast.getAddress() != this.address : !this.address.equals( cast.getAddress()))
         return false;
   

      if (this.email == null ? cast.getEmail() != this.email : !this.email.equals( cast.getEmail()))
         return false;
   
      if (this.descriptions == null ? cast.getDescriptions() != this.descriptions : !this.descriptions.equals( cast.getDescriptions()))
         return false;
   
      return true;
   }
   
   /* (non-Javadoc)
    * @see java.lang.Object#hashCode()
    */
   public int hashCode() {
      int hashCode = 0;
      if (this.password != null) 
         hashCode = 29 * hashCode + password.hashCode();
      if (this.status != null) 
         hashCode = 29 * hashCode + status.hashCode();
      if (this.account != null) 
         hashCode = 29 * hashCode + account.hashCode();
      if (this.userName != null) 
         hashCode = 29 * hashCode + userName.hashCode();
      if (this.picture != null)
         hashCode = 29 * hashCode + picture.hashCode();
      if (this.phone != null) 
         hashCode = 29 * hashCode + phone.hashCode();
      if (this.address != null) 
         hashCode = 29 * hashCode + address.hashCode();
      if (this.email != null)
         hashCode = 29 * hashCode + email.hashCode();
      if (this.descriptions != null) 
         hashCode = 29 * hashCode + descriptions.hashCode();
      return hashCode;
   }
   
   /* (non-Javadoc)
    * @see java.lang.Object#toString()
    */
   public String toString()
   {
      StringBuffer ret = new StringBuffer();
      ret.append( "userprivilege.LoginUser: " );
      ret.append( "userId='" + userId + "'");
      ret.append( "password='" + password + "'");
      ret.append( "status='" + status + "'");
      ret.append( "account='" + account + "'");
      ret.append( "userName='" + userName + "'");
      ret.append( "picture='" + picture + "'");
      ret.append( "phone='" + phone + "'");
      ret.append( "address='" + address + "'");
      ret.append( "email='" + email + "'");
      ret.append( "descriptions='" + descriptions + "'");
      return ret.toString();
   }

}