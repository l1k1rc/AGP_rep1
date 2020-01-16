package beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import core.Site;
import core.Hotel;
import core.MockCore;

@ManagedBean
@RequestScoped
public class SiteResultBean {
	@ManagedProperty(value = "#{siteBean}")
	private SiteBean siteBean;
	private List<Site> sites ;
	private String islandName;
	
	
	public SiteResultBean() {
		// On ne peut pas appeler le bean dans le constructeur -> error 500
		//this.islandName=siteBean.getIle();
	}
	
	public SiteBean getSiteBean() {
		return siteBean;
	}
	public void setSiteBean(SiteBean siteBean) {
		this.siteBean = siteBean;
	}

	public String getIslandName() {
		return islandName;
	}
	public void setIslandName(String islandName) {
		this.islandName = islandName;
	}
	
	// attention type string 
	public List<Site> getSites() {
		sites = MockCore.getSiteFound(siteBean.getIle(), siteBean.getPrice1(), siteBean.getPrice2(), siteBean.getType());
		return sites;
	}

}
