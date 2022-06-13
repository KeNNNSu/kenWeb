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
 * [Report GroupBy Debit] 2020-04-24 16:36
 * </pre>
 * 
 * @author TiramiAsu (Email)
 */
@Entity
@Table(name = "report_groupby_debit")
public class ReportGroupByDebit implements Serializable {

	private static final long serialVersionUID = -3848921308844955769L;

	public final static String _JSON_NAME = "reportGroupByDebit";
	public final static String _ID = "id";
	public final static String _DEBIT = "debit";
	public final static String _SUBTOTAL = "subtotal";

	@Id
	@Column(name = "id")
	private Long id;

	@Column(name = "code")
	private String code;

	@Column(name = "debit")
	private String debit;

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

	public String getDebit() {
		return debit;
	}

	public void setDebit(String debit) {
		this.debit = debit;
	}

	public Integer getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Integer subtotal) {
		this.subtotal = subtotal;
	}

	@Override
	public String toString() {
		return "ReportGroupByDebit [id=" + id +
				", code=" + code +
				", debit=" + debit +
				", subtotal=" + subtotal +
				"]";
	}
}
