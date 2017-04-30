CREATE TABLE PBDM_table_connexion (
	uname VARCHAR2(25),
	pw VARCHAR2(25),
	droits VARCHAR2(10) CHECK( 
		droits IN ('admin','user') 
							) 
								);
/