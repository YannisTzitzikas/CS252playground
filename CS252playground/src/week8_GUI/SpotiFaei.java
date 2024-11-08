/**
 * CS252: Object-Oriented Programming
 * Computer Science Department, University of Crete
 * <p>
 * A Demo program for the purposes of the GUI Tutorial in the context of CS252: Object-Oriented Programming.
 * @author Valantis Zervos (csd4878@csd.uoc.gr)
 * Last Edit: 11 Nov 2024
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

// Main class for the SpotiFaei application
public class SpotiFaei extends JFrame implements ActionListener {
    private static final String APP_NAME = "SpotiFaei"; // Hint: Use constants to avoid repetition and hard-coded values

    private final MusicPlayer musicPlayer;  // Instance of the MusicPlayer
    private boolean isSongPlaying;  // Flag to track if a song is playing

    private JLabel songPlayingTitleLabel;  // Label to display currently playing song title
    private JLabel songPlayingArtistLabel;  // Label to display currently playing artist

    // Control buttons for user interaction
    private JButton skipButton;
    private JButton prevButton;
    private JButton songsListToggleButton;

    // Constructor to initialize the GUI
    public SpotiFaei() {
        this.musicPlayer = new MusicPlayer();

        setTitle(APP_NAME);  // Set the window title
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Exit application on close
        setSize(400, 200);  // Set window size
        setLocationRelativeTo(null);  // Center the window
        setLayout(new BorderLayout());  // Set layout manager

        // Create header label
        JLabel header = new JLabel(APP_NAME);
        header.setHorizontalAlignment(SwingConstants.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 40));
        header.setForeground(Color.GREEN);
        add(header, BorderLayout.NORTH);  // Add header to the top

        JPanel nowPlayingPanel = createNowPlayingPanel();  // Create panel for now playing info
        add(nowPlayingPanel, BorderLayout.CENTER);  // Add to center

        JPanel controls = createControls();  // Create control buttons
        add(controls, BorderLayout.SOUTH);  // Add to the bottom

        setVisible(true);  // Make the window visible
    }

    // Update the display for currently playing song
    private void updateSongPlaying() {
        String songPlayingTitle = musicPlayer.getCurrentlyPlayingSongTitle();
        songPlayingTitleLabel.setText("Currently playing: " + songPlayingTitle);

        String songPlayingArtist = musicPlayer.getCurrentlyPlayingSongArtist();
        songPlayingArtistLabel.setText("by " + songPlayingArtist);

        revalidate();  // Refresh the layout
        repaint();  // Redraw the panel
    }

    // Create control buttons
    private JPanel createControls() {
        JPanel controls = new JPanel();
        controls.setLayout(new GridLayout(2, 2, 10, 10));  // Grid layout with spacing

        // Play/Pause button
        JButton playButton = new JButton("Play");
        playButton.addActionListener(_ -> {
            isSongPlaying = !isSongPlaying;  // Toggle the play state
            playButton.setText(isSongPlaying ? "Pause" : "Play");  // Update button text
        });

        // Skip button
        skipButton = new JButton("Skip");
        skipButton.addActionListener(this);  // Register action listener

        // Previous button
        prevButton = new JButton("Previous");
        prevButton.addActionListener(this);  // Register action listener

        // Songs list toggle button
        songsListToggleButton = new JButton("Song List");
        songsListToggleButton.addActionListener(this);  // Register action listener

        // Add buttons to the control panel
        controls.add(prevButton);
        controls.add(skipButton);
        controls.add(playButton);
        controls.add(songsListToggleButton);
        return controls;  // Return the control panel
    }

    // Create panel to display the currently playing song information
    private JPanel createNowPlayingPanel() {
        JPanel nowPlayingPanel = new JPanel();
        nowPlayingPanel.setLayout(new BoxLayout(nowPlayingPanel, BoxLayout.Y_AXIS));
        nowPlayingPanel.add(Box.createVerticalStrut(20));  // Add vertical space

        // Label for the song title
        songPlayingTitleLabel = new JLabel();
        songPlayingTitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        nowPlayingPanel.add(songPlayingTitleLabel);

        // Label for the artist name
        songPlayingArtistLabel = new JLabel();
        songPlayingArtistLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        songPlayingArtistLabel.setForeground(Color.GRAY);
        nowPlayingPanel.add(songPlayingArtistLabel);

        updateSongPlaying();  // Initialize with current song information
        return nowPlayingPanel;  // Return the now playing panel
    }

    // Handle button click events
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton buttonClicked = (JButton) e.getSource();  // Get the clicked button
        if (buttonClicked == skipButton) {
            musicPlayer.skipSong();  // Skip to the next song
        } else if (buttonClicked == prevButton) {
            musicPlayer.goBack();  // Go back to the previous song
        } else if (buttonClicked == songsListToggleButton) {
            musicPlayer.toggleSongsList(); // Toggle visibility of the song list
        }
        updateSongPlaying();  // Refresh the now playing information
    }
    
    public static void main(String[] args) {
        SpotiFaei sf = new SpotiFaei();
    }
}

/**
 * Class representing the music player
 * <p>
 * Offered methods:
 * - String[] getSongsList() // Get the list of songs as an array of strings
 * - String getCurrentlyPlayingSongTitle() // Get the title of the currently playing song
 * - String getCurrentlyPlayingSongArtist() // Get the artist of the currently playing song
 * <p>
 * - void toggleSongsList() // Toggle the Songs List Frame visibility
 * - void skipSong() // Skip to the next song in the playlist
 * - void goBack() // Go back to the previous song in the playlist
 */
class MusicPlayer {

    // Class representing a single song
    class Song {
        private String name;  // Title of the song
        private String artist;  // Artist of the song

        // Constructor for the Song class
        public Song(String name, String artist) {
            setName(name);  // Set song title
            setArtist(artist);  // Set artist name
        }

        public String getName() {
            return name;  // Get song title
        }

        public void setName(String name) {
            this.name = name;  // Set song title
        }

        public String getArtist() {
            return artist;  // Get artist name
        }

        public void setArtist(String artist) {
            this.artist = artist;  // Set artist name
        }
    }

    // Class for displaying the list of songs
    class SongsList extends JFrame {
        private boolean isVisible;  // Flag to track visibility of the window

        // Constructor to initialize the songs list window
        public SongsList() {
            setTitle("Songs List");  // Set window title
            String[] songsList = getSongsList();  // Get the list of songs
            JList<String> songJList = new JList<>(songsList);  // Create a JList for songs
            add(new JScrollPane(songJList));  // Add scroll pane for JList

            // Add a window listener to handle the window closing event
            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                   toggleVisibility(); // Toggle visibility to "false" to hide the window
                }
            });

            pack();  // Adjust window size based on contents
            isVisible = false;  // Initially hidden
            setVisible(false);  // Make the window invisible
        }

        // Toggle visibility of the songs list window
        public void toggleVisibility() {
            isVisible = !isVisible;  // Change visibility state
            setVisible(isVisible);  // Update window visibility
        }
    }


    List<Song> songsList;  // List of songs in the player
    Song songPlaying;  // Currently playing song
    ListIterator<Song> iterator;  // Iterator for song list
    boolean lastActionWasNext;  // Flag to track the last action (skip or back)
    SongsList songsListGUI;

    // Constructor to initialize the music player
    public MusicPlayer() {
        songsList = new ArrayList<>();  // Initialize the song list
        songsList.add(new Song("The Final Countdown", "Europe"));  // Add songs
        songsList.add(new Song("My Way", "Frank Sinatra"));
        songsList.add(new Song("Billie Jean", "Michael Jackson"));

        iterator = songsList.listIterator();  // Create iterator for the song list
        lastActionWasNext = true;  // Start by moving forward
        skipSong();  // Start by playing the first song

        songsListGUI = new SongsList();
    }

    // Get the list of songs as an array of strings
    public String[] getSongsList() {
        String[] songInfoArray = new String[songsList.size()];  // Array to hold song info

        for (int index = 0; index < songsList.size(); index++) {
            Song song = songsList.get(index);  // Get the song
            songInfoArray[index] = song.getName() + " by " + song.getArtist();  // Format string
        }

        return songInfoArray;  // Return the array of song info
    }

    // Get the title of the currently playing song
    public String getCurrentlyPlayingSongTitle() {
        return songPlaying.getName();  // Return the song title
    }

    // Get the artist of the currently playing song
    public String getCurrentlyPlayingSongArtist() {
        return songPlaying.getArtist();  // Return the artist name
    }

    // Toggle the Songs List Frame visibility
    public void toggleSongsList() {
        songsListGUI.toggleVisibility();
    }

    // Skip to the next song in the playlist
    public void skipSong() {
        if (!lastActionWasNext && iterator.hasNext()) {
            iterator.next();  // Skip over the current song if last action was back
        }

        if (!iterator.hasNext()) {
            iterator = songsList.listIterator();  // Restart iterator if at the end
        }
        songPlaying = iterator.next();  // Move to the next song
        lastActionWasNext = true;  // Update the last action flag
    }

    // Go back to the previous song in the playlist
    public void goBack() {
        if (lastActionWasNext && iterator.hasPrevious()) {
            iterator.previous();  // Skip over the current song if last action was next
        }

        if (!iterator.hasPrevious()) {
            iterator = songsList.listIterator(songsList.size());  // Restart at the end if at the beginning
        }
        songPlaying = iterator.previous();  // Move to the previous song
        lastActionWasNext = false;  // Update the last action flag
    }
}
