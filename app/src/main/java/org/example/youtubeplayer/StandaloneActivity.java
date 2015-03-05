package org.example.youtubeplayer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.google.android.youtube.player.YouTubeStandalonePlayer;

public class StandaloneActivity extends Activity implements View.OnClickListener {

	public static final String GOOGLE_API_KEY = "AIzaSyAHK03CNtqZVxVmw9e9BkASIAcFsEPS6Vo";
	public static final String YOUTUBE_VIDEO_ID = "LFiqxR7s76Y";
	public static final String YOUTUBE_PLAYLIST_ID = "PLXtTjtWmQhg1sBPGWFRlD5saOD6sqAH8C";
	
	private Button btnPlay;
	private Button btnPlayPlaylist;
	
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.standalone);
		
		btnPlay = (Button) findViewById(R.id.btnStart);
		btnPlayPlaylist = (Button) findViewById(R.id.btnPlayList);
		
		btnPlay.setOnClickListener(this);
		btnPlayPlaylist.setOnClickListener(this);
	}

	public void onClick(View v){
		Intent intent = null;
		if(v == btnPlay){
			// Play Single Video
			intent  = YouTubeStandalonePlayer.createVideoIntent(this, GOOGLE_API_KEY, YOUTUBE_VIDEO_ID);
		} 
		else if (v == btnPlayPlaylist){
			// Play the playlist
			intent  = YouTubeStandalonePlayer.createPlaylistIntent(this, GOOGLE_API_KEY, YOUTUBE_PLAYLIST_ID);
		}
		
		if(intent != null){
			startActivityForResult(intent, 0);
		}
	}
}
