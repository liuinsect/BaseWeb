/***********************************************************************
 * Module:  Department.java
 * Author:  Administrator
 * Purpose: Defines the Class Department
 ***********************************************************************/

package com.liusoft.userprivilege;

import java.util.*;

/** @pdOid f7a6cc9d-9aaf-44cb-82a4-1510db0d9d22 */
public class Department implements java.io.Serializable {
   /** 部门编号
    * 
    * @pdOid 3c56aed3-2b09-4c97-b650-4d5f2a807b5d */
   public Long departmentId;
   /** 部门名
    * 
    * @pdOid 040b6108-af1d-41a6-990e-22519f380bb8 */
   public String departmentName;
   /** @pdOid 74c59ae3-868b-4c4b-92a1-13a4b8bcd683 */
   public String departmentLeader;
   /** 联系电话
    * 
    * @pdOid 1b9df4d6-925b-4b80-8b95-d1f87806aa64 */
   public String phone;
   /** 备注
    * 
    * @pdOid 47ba62d3-f5cb-49d3-934c-656daa886984 */
   public String descriptions;
   
   /** @pdRoleInfo migr=no name=Department assc=Relationship18 coll=java.util.Set impl=java.util.HashSet mult=0..* */
   public Set<Department> children;
   /** @pdRoleInfo migr=no name=Department assc=Relationship18 mult=0..1 side=A */
   public Department parent;
   
   /**
    * Empty constructor which is required by Hibernate
    *
    */
   public Department() {
      // TODO Auto-generated constructor stub
   }
   
   /**
    * @pdGenerated default getter
    */
   public Set<Department> getChildren() {
      if (children == null)
         children = new HashSet<Department>();
      return children;
   }
   
   /**
    * @pdGenerated default iterator getter
    */
   public Iterator getIteratorChildren() {
      if (children == null)
         children = new HashSet<Department>();
      return children.iterator();
   }
   
   /** 
    * @pdGenerated default setter
    * @param newChildren
    */
   public void setChildren(Set<Department> newChildren) {
      //removeAllChildren();
      this.children = newChildren;   
   }
   
   /** 
    * @pdGenerated default add
    * @param newDepartment
    */
   public void addChildren(Department newDepartment) {
      if (newDepartment == null)
         return;
      if (this.children == null)
         this.children = new HashSet<Department>();
      if (!this.children.contains(newDepartment))
      {
         this.children.add(newDepartment);
         newDepartment.setParent(this);
      }
   }
   
   /** 
    * @pdGenerated default remove
    * @param oldDepartment
    */
   public void removeChildren(Department oldDepartment) {
      if (oldDepartment == null)
         return;
      if (this.children != null)
         if (this.children.contains(oldDepartment))
         {
            this.children.remove(oldDepartment);
            oldDepartment.setParent((Department)null);
         }
   }
   
   /**
    * @pdGenerated default removeAll
    */
   public void removeAllChildren() {
      if (children != null)
      {
         Department oldDepartment;
         for (Iterator iter = getIteratorChildren(); iter.hasNext();)
         {
            oldDepartment = (Department)iter.next();
            iter.remove();
            oldDepartment.setParent((Department)null);
         }
      }
   }
   /**
    * @pdGenerated default parent getter
    */
   public Department getParent() {
      return parent;
   }
   
   /**
    * @pdGenerated default parent setter
    * @param newDepartment
    */
   public void setParent(Department newDepartment) {
      if (this.parent == null || !this.parent.equals(newDepartment))
      {
         if (this.parent != null)
         {
            Department oldDepartment = this.parent;
            this.parent = null;
            //oldDepartment.removeChildren(this);
         }
         if (newDepartment != null)
         {
            this.parent = newDepartment;
            //this.parent.addChildren(this);
         }
      }
   }
   
   /**
    * Get value of departmentId
    *
    * @return departmentId 
    */
   public Long getDepartmentId()
   {
      return departmentId;
   }
   
   /**
    * Set value of departmentId
    *
    * @param newDepartmentId 
    */
   public void setDepartmentId(Long newDepartmentId)
   {
      this.departmentId = newDepartmentId;
   }
   
   /**
    * Get value of departmentName
    *
    * @return departmentName 
    */
   public String getDepartmentName()
   {
      return departmentName;
   }
   
   /**
    * Set value of departmentName
    *
    * @param newDepartmentName 
    */
   public void setDepartmentName(String newDepartmentName)
   {
      this.departmentName = newDepartmentName;
   }
   
   /**
    * Get value of departmentLeader
    *
    * @return departmentLeader 
    */
   public String getDepartmentLeader()
   {
      return departmentLeader;
   }
   
   /**
    * Set value of departmentLeader
    *
    * @param newDepartmentLeader 
    */
   public void setDepartmentLeader(String newDepartmentLeader)
   {
      this.departmentLeader = newDepartmentLeader;
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
   
      if (!(other instanceof Department))
         return false;
   
      Department cast = (Department) other;
   
      if (this.departmentId == null ? cast.getDepartmentId() != this.departmentId : !this.departmentId.equals( cast.getDepartmentId()))
         return false;
   
      if (this.departmentName == null ? cast.getDepartmentName() != this.departmentName : !this.departmentName.equals( cast.getDepartmentName()))
         return false;
   
      if (this.departmentLeader == null ? cast.getDepartmentLeader() != this.departmentLeader : !this.departmentLeader.equals( cast.getDepartmentLeader()))
         return false;
   
      if (this.phone == null ? cast.getPhone() != this.phone : !this.phone.equals( cast.getPhone()))
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
      if (this.departmentName != null) 
         hashCode = 29 * hashCode + departmentName.hashCode();
      if (this.departmentLeader != null) 
         hashCode = 29 * hashCode + departmentLeader.hashCode();
      if (this.phone != null) 
         hashCode = 29 * hashCode + phone.hashCode();
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
      ret.append( "userprivilege.Department: " );
      ret.append( "departmentId='" + departmentId + "'");
      ret.append( "departmentName='" + departmentName + "'");
      ret.append( "departmentLeader='" + departmentLeader + "'");
      ret.append( "phone='" + phone + "'");
      ret.append( "descriptions='" + descriptions + "'");
      return ret.toString();
   }

}