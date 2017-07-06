package com.cinefilos_backend.negocio;

import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class BackendConfig {
	private static BackendConfig instance = new BackendConfig();
	private String backend_server;
	private String db_server;
	private String db_port;
	private String db_name;
	private String db_username;
	private String db_password;
	private String failsafe_username;
	private String failsafe_password;
	private String bkp_path;
	private String bkp_backup_cmd;
	private String bkp_restore_cmd;
	
	public BackendConfig() {
		
	}
	
	public static BackendConfig getInstance() { return instance; }
	
	public String getBackendServer() { return backend_server; }
	public String getDBServer() { return db_server; }
	public String getDBPort() { return db_port; }
	public String getDBName() { return db_name; }
	public String getDBUsername() { return db_username; }
	public String getDBPassword() { return db_password; }
	public String getFailsafeUsename() { return failsafe_username; }
	public String getFailsafePassword() { return failsafe_password; }
	public String getBackupPath() { return bkp_path; }
	public String getBackupCmd() { return bkp_backup_cmd; }
	public String getRestoreCmd() { return bkp_restore_cmd; }
	
	public static BackendConfig loadConfig(String filename) {
		Gson json = new Gson();
		JsonReader reader;
		try {
			reader = new JsonReader(new FileReader(filename));
		} catch (IOException e) {
			/*
			backend_server = "http://localhost:8080/";
			db_server = "10.11.254.125";
			db_port = "5432";
			db_name = "cinefilos_db";
			db_username = "mauricio";
			db_password = "senha";
			*/
			return null;
		}
		instance = json.fromJson(reader, BackendConfig.class);
		return instance;
	}
	
	public String toString() {
		return 	"\nDBServer: " + db_server +
				"\nDB Name: " + db_name +
				"\nDB Username: " + db_username +
				"\nDB Password: " + db_password +
				"\nFailsafe Username: " + failsafe_username +
				"\nFailsafe Password: " + failsafe_password +
				"\nBackup Path: " + bkp_path +
				"\nBackup Command: " + bkp_backup_cmd +
				"\nRestore Command: " + bkp_restore_cmd;
				
	}
	
}
