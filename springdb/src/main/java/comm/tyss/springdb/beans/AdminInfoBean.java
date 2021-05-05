package comm.tyss.springdb.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "admin")
public class AdminInfoBean implements Serializable {
	
	@Id
	@Column(name = "id")
	private Integer id;
	
	@Column
	private String aname;

}
