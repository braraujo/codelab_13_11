package com.braraujo;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

public class PostViewFragment extends Fragment {

	private TextView titleTextView;
	private TextView authorTextView;
	@SuppressWarnings("unused")
	private WebView contentWebView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater
				.inflate(R.layout.post_view_fragment_layout, container);
		titleTextView = (TextView) v.findViewById(R.id.titleTextView);
		authorTextView = (TextView) v.findViewById(R.id.authorTextView);
		contentWebView = (WebView) v.findViewById(R.id.contentWebView);

		return v;
	}

	public void setPost(String title, String author, String contentUrl) {
		titleTextView.setText(title);
		authorTextView.setText(author);

	}
}
