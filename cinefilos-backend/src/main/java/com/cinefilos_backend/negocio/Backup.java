package com.cinefilos_backend.negocio;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Backup {
	private static BackendConfig backendConfig = BackendConfig.getInstance();
	
	public Backup() {}
	
	public String fazerBackup() {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date();
		String output = "cinefilos-backup-" + dateFormat.format(date) + ".sql";
		
		String cmd = 	backendConfig.getBackupCmd() + " " +
						backendConfig.getDBName() + " -f " +
						backendConfig.getBackupPath() + 
						output +
						" -c --column-inserts";
		
		Process backup_p;
		
		try {
			backup_p = Runtime.getRuntime().exec(cmd);
			backup_p.waitFor();
		} catch (Exception e) {
			return "{\"message\": \"Falha ao executar backup.\" }";
		}

		return "{\"message\": \"Backup executado com sucesso [" +
			output + "].\" }";
	}
	
	
	public String listarBackup() {
		File folder = new File(backendConfig.getBackupPath());
		File[] files = folder.listFiles();
		List<String> files_str = new ArrayList<String>();
		String aux_str;
		DateFormat dateFormatIn = new SimpleDateFormat("yyyyMMddHHmmss");
		DateFormat dateFormatOut = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date;
		
		for(int i = 0; i < files.length; i++) {
			if(files[i].isFile() && files[i].getName().startsWith("cinefilos-backup")) {
				aux_str = files[i].getName().substring(17, 31);
				try {
					date = dateFormatIn.parse(aux_str);
				} catch(Exception e) {
					return "{ \"message\": \"Falha ao converter data.\" }";
				}

				files_str.add(	"{ \"data\": \"" + dateFormatOut.format(date) + 
								"\" , \"arquivo\": " + "\"" + files[i].getName() + 
								"\", \"restore_url\": \"" + backendConfig.getBackendServer() +
								"cinefilos_app/restaurarBackup/" + 
								files[i].getName() + "\"}");
			}
		}
		
		return "{ \"backups\": " +  files_str.toString() +  " }";

	}
	
	
	public String restaurarBackup(String input) {
		Process restore_p; 
		String cmd;
		
		input = backendConfig.getBackupPath() + input;
		cmd = backendConfig.getRestoreCmd() + 
				" -w -h " + backendConfig.getDBServer() +
				" -f " + input + " " +
				backendConfig.getDBName();
		
		try {
			restore_p = Runtime.getRuntime().exec(cmd);
			restore_p.waitFor();
			System.out.println(restore_p.getOutputStream());
		} catch (Exception e) {
			return "{\"message\": \"Falha ao restaurar da base de dados.\" }";
		}

		return "{\"message\": \"Backup restaurado com sucesso.\" }";
	}
}
