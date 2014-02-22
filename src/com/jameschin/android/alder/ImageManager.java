package com.jameschin.android.alder;

import java.util.Queue;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.widget.ImageView;

public class ImageManager implements Runnable {
	// STATE VARIABLES
	private Queue<ImageJob> jobQueue;
	
	// SYSTEM
	private Handler handler;
	
	static class ImageJob {
		ImageView imageView;
		// uri
	}
	
	/**
	 * 
	 * http://developer.android.com/training/displaying-bitmaps/load-bitmap.html
	 * @param options
	 * @param reqWidth
	 * @param reqHeight
	 * @return
	 */
	public static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
		// Raw height and width of image
		final int height = options.outHeight;
		final int width = options.outWidth;
		int inSampleSize = 1;

		if (height > reqHeight || width > reqWidth) {
			final int halfHeight = height / 2;
			final int halfWidth = width / 2;

			// Calculate the largest inSampleSize value that is a power of 2 and keeps both height and width larger than the requested height and width.
			while ((halfHeight / inSampleSize) > reqHeight && (halfWidth / inSampleSize) > reqWidth) {
				inSampleSize *= 2;
			}
		}

		return inSampleSize;
	}

	/**
	 * Load a thumbnail for a bitmap of arbitrarily large size.
	 * http://developer.android.com/training/displaying-bitmaps/load-bitmap.html
	 * @param res application Resources, can pass in getResources() from Activity.
	 * @param resId resource ID for the image.
	 * @param reqWidth thumbnail width in pixels.
	 * @param reqHeight thumbnail height in pixels.
	 * @return the thumbnail Bitmap.
	 */
	public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId, int reqWidth, int reqHeight) {
		// First decode with inJustDecodeBounds=true to check dimensions
		final BitmapFactory.Options options = new BitmapFactory.Options();
		options.inJustDecodeBounds = true;
		BitmapFactory.decodeResource(res, resId, options);

		// Calculate inSampleSize
		options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

		// Decode bitmap with inSampleSize set
		options.inJustDecodeBounds = false;
		return BitmapFactory.decodeResource(res, resId, options);
	}

	@Override
	public void run() {
		
	}
}