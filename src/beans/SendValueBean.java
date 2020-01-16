package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class SendValueBean {

	@ManagedProperty(value = "#{entryBean}")
	private EntryBean entryBean;

	public SendValueBean() {
		System.out.println("into sendValueBean");
	}

	public EntryBean getEntryBean() {
		return entryBean;
	}

	public void setEntryBean(EntryBean entryBean) {
		this.entryBean = entryBean;
	}

	public String direct() {
		System.err.println("Keyword send to business class-- [= " + entryBean.getKeyword() + "\n");
		System.err.println("Price 1 send to business class-- [= " + entryBean.getPrice1() + "\n");
		System.err.println("Price 2 send to business class-- [= " + entryBean.getPrice2() + "\n");
		System.err.println("Excursion send to business class-- [= " + entryBean.getExcursion() + "\n");
		System.err.println("Type stay send to business class-- [= " + entryBean.gettypeStay() + "\n");

		// LuceneTester.searchResult(entryBean.getKeyword());
		// LuceneTester.testlucene("hello this is a test");
		return "success";
	}

}
