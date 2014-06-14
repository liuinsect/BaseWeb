/***********************************************************************
 * Module:  Roles.java
 * Author:  Administrator
 * Purpose: Defines the Class Roles
 ***********************************************************************/

package com.liusoft.userprivilege;

/** 未列完
 * 
 * @pdOid 03a53378-a9b4-4333-9a9a-51ffbfa285d0 */
public class Roles implements java.io.Serializable {
   /** 角色编号
    * 
    * @pdOid b81b9273-d0c2-4857-873a-a18b04f1c6d1 */
   public Long rolesId;
   /** 角色名
    * 
    * @pdOid 3b5bc2c2-8c46-4f3d-b26b-8d9e656e67e1 */
   public String rolesName;
   /** 备注
    * 
    * @pdOid ffc44b17-a0cb-409c-9d45-5d389f6654ed */
   public String descriptions;
   
   /**
    * Empty constructor which is required by Hibernate
    *
    */
   public Roles() {
      // TODO Auto-generated constructor stub
   }
   
   /**
    * Get value of rolesId
    *
    * @return rolesId 
    */
   public Long getRolesId()
   {
      return rolesId;
   }
   
   /**
    * Set value of rolesId
    *
    * @param newRolesId 
    */
   public void setRolesId(Long newRolesId)
   {
      this.rolesId = newRolesId;
   }
   
   /**
    * Get value of rolesName
    *
    * @return rolesName 
    */
   public String getRolesName()
   {
      return rolesName;
   }
   
   /**
    * Set value of rolesName
    *
    * @param newRolesName 
    */
   public void setRolesName(String newRolesName)
   {
      this.rolesName = newRolesName;
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
   
      if (!(other instanceof Roles))
         return false;
   
      Roles cast = (Roles) other;
   
      if (this.rolesId == null ? cast.getRolesId() != this.rolesId : !this.rolesId.equals( cast.getRolesId()))
         return false;
   
      if (this.rolesName == null ? cast.getRolesName() != this.rolesName : !this.rolesName.equals( cast.getRolesName()))
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
      if (this.rolesName != null) 
         hashCode = 29 * hashCode + rolesName.hashCode();
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
      ret.append( "userprivilege.Roles: " );
      ret.append( "rolesId='" + rolesId + "'");
      ret.append( "rolesName='" + rolesName + "'");
      ret.append( "descriptions='" + descriptions + "'");
      return ret.toString();
   }

}