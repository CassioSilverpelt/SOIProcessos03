package controller;

import java.io.*;

import javax.swing.JOptionPane;

public class DistroController {
	public DistroController() {
		super();
	}
	
	private String os() {
		String os = System.getProperty("os.name");
		return os;
	}
	
	public void exibeDistro(){
		String os = os();
		if (os.contains("Linux")) {
			System.out.println(os + "\n");
			System.out.println(System.getProperty("os.version") + "\n");
			try {
				Process proc = Runtime.getRuntime().exec("cat /etc/os-release");
				InputStream flow = proc.getInputStream();
				InputStreamReader reader = new InputStreamReader(flow);
				BufferedReader buffer = new BufferedReader(reader);
				String linha = buffer.readLine();
				
				while (linha != null) {
					System.out.println(linha);
					linha = buffer.readLine();
				}
				
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		} else {
			JOptionPane.showMessageDialog(null, "Sistema Operacional inválido.");
		}
	}
	
}
