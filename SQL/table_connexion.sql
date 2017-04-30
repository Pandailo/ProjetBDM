DROP TABLE PBDM_table_connexion;
CREATE TABLE PBDM_table_connexion (
	uname VARCHAR2(25),
	pw VARCHAR2(50),
	droits VARCHAR2(10) CHECK( 
		droits IN ('admin','user') 
							) 
								);