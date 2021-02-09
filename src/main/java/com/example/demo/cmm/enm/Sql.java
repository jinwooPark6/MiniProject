package com.example.demo.cmm.enm;

public enum Sql {
	CREATE_MANAGERS, CREATE_USERS, TABLE_COUNT,
	TRUNCATE, TOTAL_COUNT, DROP_TABLE;
	@Override
	public String toString() {
		String query = "";
		switch(this) {
		case CREATE_MANAGERS:
			query = "create table managers(\n" + 
					"   mgr_num int primary key auto_increment ,\n" + 
					"   name varchar(20),\n" + 
					"   email varchar(20),\n" + 
					"   password varchar(20),\n" + 
					"   profile_image varchar(100)\n" + 
					"   )"; break;
		
		case CREATE_USERS:
			query = "create table users(\n" + 
					"   userid varchar(20) primary key,\n" + 
					"   password varchar(20),\n" + 
					"   name varchar(20),\n" +  
					"   phone varchar(50),\n" +  
					"   email varchar(50),\n" +  
					"   birthday varchar(20),\n" + 
					"   gender varchar(20),\n" + 
					"   )"; break;
		
		case TRUNCATE:
			query = "truncate table \t"; break;
		case TOTAL_COUNT:
			query = "select count(*) count from \t"; break;
		case DROP_TABLE:
			query = "drop table if exists \t"; break;
		case TABLE_COUNT:
			query = "select count(*) from information_schema.tables " + 
					"where table_schema = \'mariadb\'"; break;
		}
		return query;
	}
}