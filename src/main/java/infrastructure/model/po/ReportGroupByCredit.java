/*
 * 
 * 
 * 
 * 
 * 
 * &copy;TiramiAsu
 * 
 */
package infrastructure.model.po;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <pre>
 * [Report GroupBy Credit] 2020-04-29 16:22
 * </pre>
 * 
 * @author TiramiAsu (Email)
 */

@Entity
@Table(name = "report_groupby_credit")
public class ReportGroupByCredit implements Serializable {

	private static final long serialVersionUID = -2541225147491421458L;

	public final static String _JSON_NAME = "reportGroupByCredit";
	public final static String _ID = "id";
	public final static String _DEBIT = "credit";
	public final static String _SUBTOTAL = "subtotal";

	@Id
	@Column(name = "id")
	private Long id;

	@Column(name = "code")
	private String code;

	@Column(name = "credit")
	private String credit;

	@Column(name = "subtotal")
	private Integer subtotal;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCredit() {
		return credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}

	public Integer getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Integer subtotal) {
		this.subtotal = subtotal;
	}

	@Override
	public String toString() {
		return "ReportGroupByCredit [id=" + id +
				", code=" + code +
				", credit=" + credit +
				", subtotal=" + subtotal +
				"]";
	}
}

