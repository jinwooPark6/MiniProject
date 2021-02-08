package com.example.demo.cmm.enm;

public enum Sql {
	CREATE_SHOWS, TABLE_COUNT, TRUNCATE, TOTAL_COUNT, DROP_TABLE;
	@Override
	public String toString() {
		String query = "";
		switch(this) {
		case CREATE_SHOWS:
			query = "create table shows(\n" + 
					"   show_num int primary key auto_increment ,\n" + 
					"   title varchar(30),\n" + 
					"   period varchar(30),\n" + 
					"   time varchar(20),\n" + 
					"   venue varchar(20),\n" + 
					"   admission varchar(20),\n" + 
					"   price varchar(50),\n" + 
					"   host varchar(20),\n" + 
					"   management varchar(20),\n" + 
					"   poster_image varchar(100)\n" + 
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