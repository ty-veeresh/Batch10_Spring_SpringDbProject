package comm.tyss.springdb.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "items")
public class ItemBean implements Serializable {
	
	@Id
	@Column
	private Integer iId;
	
	@Column
	private String iname;
	
	@Column
	private Integer icost;
	
	@Column
	private Integer aId;

	

}
