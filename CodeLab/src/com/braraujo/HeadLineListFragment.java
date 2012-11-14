package com.braraujo;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class HeadLineListFragment extends ListFragment {

	private String[] entries;

	private int selected;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		populateEntries();

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_1, entries);
		setListAdapter(adapter);
		if (savedInstanceState != null) {
			selected = savedInstanceState.getInt("selected");
		}
	}

	@Override
	public void onResume() {
		super.onResume();
		PostViewFragment f = (PostViewFragment) getFragmentManager()
				.findFragmentById(R.id.post_view_fragment);

		if (f != null && f.isInLayout()) {
			String post = entries[selected];
			f.setPost(post, "Breno Araújo", null);
		}

	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		if (outState != null) {
			outState.putInt("selected", selected);
		}
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		String post = entries[position];
		selected = position;
		PostViewFragment f = (PostViewFragment) getFragmentManager()
				.findFragmentById(R.id.post_view_fragment);

		if (f == null || !f.isInLayout()) {
			Intent i = new Intent(getActivity(), PostViewActivity.class);
			i.putExtra(PostViewActivity.PARAM_TITLE, post);
			i.putExtra(PostViewActivity.PARAM_AUTHOR, "Breno Araújo");
			startActivity(i);
		} else {
			f.setPost(post, "Breno Araújo", null);
		}
	}

	public void populateEntries() {
		entries = new String[10];
		for (int i = 0; i < entries.length; i++) {
			entries[i] = "Post " + (i + 1);
		}
	}
}
