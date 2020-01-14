package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import core.Student;
import lucene.LuceneTester;


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
		System.err.println("Value send to lucene--"+entryBean.getKeyword()+"\n");

		LuceneTester.searchResult(entryBean.getKeyword());
		//LuceneTester.testlucene("hello this is a test");
		return "failed";
	}
	
}
