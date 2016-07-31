package za.co.dropzone.entities;

import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
@TransactionManagement(TransactionManagementType.BEAN)
public class Profile {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String shortDescription;
	private String longDescription;
	private String npoNumber;
	private String pboNumber;
	private String companyNumber;
	private String trustNumber;
	private String vatNumber;
	private int entityId;

	@Transient
	private String resultMessage;	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	public String getNpoNumber() {
		return npoNumber;
	}

	public void setNpoNumber(String npoNumber) {
		this.npoNumber = npoNumber;
	}

	public String getPboNumber() {
		return pboNumber;
	}

	public void setPboNumber(String pboNumber) {
		this.pboNumber = pboNumber;
	}

	public String getCompanyNumber() {
		return companyNumber;
	}

	public void setCompanyNumber(String companyNumber) {
		this.companyNumber = companyNumber;
	}

	public String getTrustNumber() {
		return trustNumber;
	}

	public void setTrustNumber(String trustNumber) {
		this.trustNumber = trustNumber;
	}

	public String getVatNumber() {
		return vatNumber;
	}

	public void setVatNumber(String vatNumber) {
		this.vatNumber = vatNumber;
	}

	public int getEntityId() {
		return entityId;
	}

	public void setEntityId(int entityId) {
		this.entityId = entityId;
	}

	public String getResultMessage() {
		return resultMessage;
	}

	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}
}
