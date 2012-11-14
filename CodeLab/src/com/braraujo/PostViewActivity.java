package com.braraujo;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;

public class PostViewActivity extends Activity {

	public static final String PARAM_TITLE = "TITLE";
	public static final String PARAM_AUTHOR = "AUTHOR";

	@Override
	public void onCreate(Bundle savedInstance) {
		super.onCreate(savedInstance);

		if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
			finish();
			return;
		}
		setContentView(R.layout.post_view_activity_layout);

		String title = getIntent().getStringExtra(PARAM_TITLE);
		String author = getIntent().getStringExtra(PARAM_AUTHOR);

		PostViewFragment f = (PostViewFragment) getFragmentManager()
				.findFragmentById(R.id.post_view_fragment);
		f.setPost(title, author, author);

		System.out.println("Orientação portrait");

	}
}
