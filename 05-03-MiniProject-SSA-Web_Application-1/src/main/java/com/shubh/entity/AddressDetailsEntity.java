package com.shubh.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@ToString
@Table(name="person_address_dtls")
public class AddressDetailsEntity {

	@Id
	@GenericGenerator(name="gen",strategy="increment")
	@GeneratedValue(generator="gen")
	@Column(name="address_id")
    private int addressId;
    @Column(name="address_1")
	private String address1;
    @Column(name="address_2")
	private String address2;
    @Column(name="state")
	private String state;
    @Column(name="city")
	private String city;
    @Column(name="pincode")
    private int pincode;
    @OneToOne(targetEntity=PersonDetailsEntity.class,cascade=CascadeType.ALL)
	@JoinColumn(name="pid",referencedColumnName="person_id")
	private PersonDetailsEntity personAddress;
    

}
