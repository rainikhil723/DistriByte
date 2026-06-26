
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import INTF.*;

class MainApp {
    public static void main(String args[]) throws Exception {
        Server s = new Server();
        
        JFrame frame = new JFrame("Distributed Download Manager");
        frame.setSize(500, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel label = new JLabel("Enter Download Link:");
        label.setBounds(20, 20, 450, 30);
        frame.add(label);

        JTextField linkField = new JTextField();
        linkField.setBounds(20, 60, 320, 30);
        frame.add(linkField);

        JButton downloadBtn = new JButton("Download");
        downloadBtn.setBounds(350, 60, 110, 30);
        frame.add(downloadBtn);

        JLabel statusLabel = new JLabel("Status: Waiting for input...");
        statusLabel.setBounds(20, 110, 450, 30);
        frame.add(statusLabel);

        downloadBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String link = linkField.getText();
                if(link != null && !link.isEmpty()) {
                    statusLabel.setText("Status: Distributing and Downloading...");
                    downloadBtn.setEnabled(false);
                    
                    new Thread(() -> {
                        ClientA cl = new ClientA(link);
                        try {
                            cl.t.join();
                            statusLabel.setText("Status: Download Complete!");
                        } catch(Exception ex) {
                            statusLabel.setText("Status: Error occurred.");
                        }
                    }).start();
                }
            }
        });

        frame.setVisible(true);
        s.t.join();
    }
}
// import java.util.*;
// import java.lang.*;
// import java.net.*;
// import java.io.*;

// // Dependencies downloader.java and server.java


// /*

// 	Developement stage
// */

// class MainApp {

// 	public static void main(String args[]) throws Exception {
	
// 		/*Starting Peer Server for all other clients*/
// 		Server s = new Server();

// 		/*Now asking users for download links*/
// 		System.out.println("Enter the download link");
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// 		String link = br.readLine();
// 		ClientA cl = new ClientA(link);
// 		s.t.join();
// 		cl.t.join();
// 	}
// }