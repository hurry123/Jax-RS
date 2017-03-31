package org.javabrains.hari.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.Type;

@Entity
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)

@org.hibernate.annotations.Entity(selectBeforeUpdate=true)
@Table(name = "USER_DETAILS1") //name here is different as it only specifies new name for the table but entity name remains same, unlike entity where it changes entity name
@NamedQuery(name="UserDetails.byId",query = "from UserDetails where userId = ?")
//@NamedNativeQuery(name="UserDetails.byName",query="select * from user_details1 where username= ?",resultClass=UserDetails.class)
public class UserDetails {
	
	@Id @GeneratedValue(strategy=GenerationType.TABLE)  //Generated value will generate value by looking at data type. Surrogate Key
	private int userId;
	private String userName;
	
	/*
	@ManyToOne
	@NotFound(action=NotFoundAction.IGNORE)
	private Vehicle vehicle1;*/
	
	/*@OneToOne
	@JoinColumn (name="VEHICLE_ID")
	private Vehicle vehicle;
	*/
	
	
	/*@OneToMany (mappedBy="user")
	@JoinTable (name="USER_VEHICLE", joinColumns = @JoinColumn(name="USER_ID"),//for user table
				inverseJoinColumns=@JoinColumn(name="VEHICLE_ID") //inverse for other table (Child)
				)*/
	//@ManyToMany -> working fine. only ManytoOne is having issue coz of GeneratedType ID's
	//@OneToMany(cascade=CascadeType.PERSIST)
//	private Collection<Vehicle> vehicle = new ArrayList<Vehicle>();
	
	/*@ElementCollection(fetch=FetchType.EAGER)
	@JoinTable(name = "USER_ADDRESS", joinColumns = @JoinColumn( name="USER_ID")) //overrides Hibernate provided name. -->not working 
	@GenericGenerator(name = "sequence-gen", strategy = "sequence")
	@CollectionId(columns = { @Column(name="ADDRESS_ID") }, generator = "sequence-gen", type = @Type(type="long"))
	private Collection<Address> listOfAddresses = new ArrayList<Address>();

	
	
	public Collection<Address> getListOfAddresses() {
		return listOfAddresses;
	}
	public void setListOfAddresses(Collection<Address> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
	}*/
	
	
	/*@Basic //to treat this field as default
	private String userName;
	@Embedded
	@AttributeOverrides({     
	@AttributeOverride (name="street",column=@Column (name="HOME_STREET_NAME")),
	@AttributeOverride (name="city",column=@Column (name="HOME_CITY_NAME")),
	@AttributeOverride (name="state",column=@Column (name="HOME_STATE_NAME")),
	@AttributeOverride (name="pincode",column=@Column (name="HOME_PINCODE_NAME")),
	})
	private Address homeAddress;
	private Address officeAddress;*/
	/*@Temporal(TemporalType.TIME)
	private Date joinedDate;
	@Transient
	private String Address;
	@Lob
	private String description;
	
	public Date getJoinedDate() {
		return joinedDate;
	}
	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	} */
	
	/*public Collection<Vehicle> getVehicle() {
		return vehicle;
	}
	public void setVehicle(Collection<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}*/
	/*	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}*/
	//@Column(name="USER_ID")
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	@Column(name="USER_NAME")
	public String getUserName() {
		return userName ; //+ " from getter"; //Hibernate picks up the value from the getter
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	/*public Address gethomeAddress() {
		return homeAddress;
	}
	public void setAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	
	public Address getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}*/

}
