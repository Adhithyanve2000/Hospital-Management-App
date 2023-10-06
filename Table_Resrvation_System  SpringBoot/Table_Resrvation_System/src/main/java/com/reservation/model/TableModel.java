package com.reservation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TableModel {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String tablerow;
	private String tablenumber;
	private String tablecapacity;
	private String tableusername;
	private String tablestatus;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTablerow() {
		return tablerow;
	}
	public void setTablerow(String tablerow) {
		this.tablerow = tablerow;
	}
	public String getTablenumber() {
		return tablenumber;
	}
	public void setTablenumber(String tablenumber) {
		this.tablenumber = tablenumber;
	}
	public String getTablecapacity() {
		return tablecapacity;
	}
	public void setTablecapacity(String tablecapacity) {
		this.tablecapacity = tablecapacity;
	}
	public String getTableusername() {
		return tableusername;
	}
	public void setTableusername(String tableusername) {
		this.tableusername = tableusername;
	}
	public String getTablestatus() {
		return tablestatus;
	}
	public void setTablestatus(String tablestatus) {
		this.tablestatus = tablestatus;
	}
	@Override
	public String toString() {
		return "TableModel [id=" + id + ", tablerow=" + tablerow + ", tablenumber=" + tablenumber + ", tablecapacity="
				+ tablecapacity + ", tableusername=" + tableusername + ", tablestatus=" + tablestatus + "]";
	}
	
}
