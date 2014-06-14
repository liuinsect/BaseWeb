/***********************************************************************
 * Module:  Privilege.java
 * Author:  Administrator
 * Purpose: Defines the Class Privilege
 ***********************************************************************/

package com.liusoft.userprivilege;


/** @pdOid 074b3d96-3e8f-42b3-9c62-e60602dfa2d9 */
public class Privilege implements java.io.Serializable {
   /** @pdOid d22eaff6-291b-4a73-a4c4-501faf98c462 */
   private Long privilegeId;
   /** @pdOid bc0bfd47-05eb-4c55-ac17-007154d04f03 */
   private String privilege;
   
   /** 备注
    * 
    * @pdOid 392cdb3c-02e8-4b60-8c53-fad19acb06bc */
   public String descriptions;
   
   /**
    * Empty constructor which is required by Hibernate
    *
    */
   public Privilege() {
      // TODO Auto-generated constructor stub
   }
   
   /**
    * Get value of privilegeId
    *
    * @return privilegeId 
    */
   public Long getPrivilegeId()
   {
      return privilegeId;
   }
   
   /**
    * Set value of privilegeId
    *
    * @param newPrivilegeId 
    */
   public void setPrivilegeId(Long newPrivilegeId)
   {
      this.privilegeId = newPrivilegeId;
   }
   
   /**
    * Get value of privilege
    *
    * @return privilege 
    */
   public String getPrivilege()
   {
      return privilege;
   }
   
   /**
    * Set value of privilege
    *
    * @param newPrivilege 
    */
   public void setPrivilege(String newPrivilege)
   {
      this.privilege = newPrivilege;
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
   
      if (!(other instanceof Privilege))
         return false;
   
      Privilege cast = (Privilege) other;
   
      if (this.privilegeId == null ? cast.getPrivilegeId() != this.privilegeId : !this.privilegeId.equals( cast.getPrivilegeId()))
         return false;
   
      if (this.privilege == null ? cast.getPrivilege() != this.privilege : !this.privilege.equals( cast.getPrivilege()))
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
      if (this.privilege != null) 
         hashCode = 29 * hashCode + privilege.hashCode();
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
      ret.append( "userprivilege.Privilege: " );
      ret.append( "privilegeId='" + privilegeId + "'");
      ret.append( "privilege='" + privilege + "'");
      ret.append( "descriptions='" + descriptions + "'");
      return ret.toString();
   }

}