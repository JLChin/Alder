package com.jameschin.android.alder;

import java.util.Queue;

import android.widget.ImageView;

public class ImageManager implements Runnable {
	private Queue<ImageJob> jobQueue;
	
	static class ImageJob {
		ImageView imageView;
		// uri
	}

	@Override
	public void run() {
		
	}
}