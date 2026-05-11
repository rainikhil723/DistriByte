# Distributed Download Manager (DDM)

DDM is a command-line tool written in Java that accelerates large downloads by distributing the workload across multiple machines. It is designed for environments where some computers have high-speed intranet connections but limited internet bandwidth.

__It is strongly advised not to run this on just a single machine.__

### How It Works

Each participating machine runs two components: a __client__ that manages downloads for itself, and a __server__ that handles download requests from other peers. A central __tracker__ running on one designated machine coordinates the peers and splits the download among them.

---

### Multi-Machine Setup

1. Connect all computers through a shared network. A WiFi hotspot works fine.
2. Pick one machine to act as the tracker and run __server.java__ on it. The tracker listens on port __8002__.
3. Enter the tracker machine's IP address in __line 111 of server.java__ and __line 74 of downloader.java__ inside the APP folder.
4. Copy the codebase to every machine that will participate in the download.
5. Compile all files in the APP folder and run __MainApp__.
6. Enter the download link in the terminal.
7. If other peers are found, the download is distributed across them. Otherwise the current machine downloads it in full.
8. Close the app after each download session.

---

### Single-Machine Setup

1. Run __server.java__ on the machine to start the tracker.
2. Enter the machine's own IP address in __line 111 of server.java__ and __line 74 of downloader.java__ inside the APP folder.
3. Compile all files in the APP folder and run __MainApp__.
4. Enter the download link in the terminal.