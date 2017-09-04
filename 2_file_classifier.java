private CascadeClassifier initializeOpenCVDetector(int raw_cascade) {
	try {
		// Copy the resource into a temp file so OpenCV can load it
		InputStream is = getResources().openRawResource(raw_cascade);
		File cascadeDir = getDir("cascade", Context.MODE_PRIVATE);
		File mCascadeFile = new File(cascadeDir, "cascade.xml");
		FileOutputStream os = new FileOutputStream(mCascadeFile);


		byte[] buffer = new byte[4096];
		int bytesRead;
		while ((bytesRead = is.read(buffer)) != -1) {
			os.write(buffer, 0, bytesRead);
		}
		is.close();
		os.close();

		// Load the cascade classifier
		return new CascadeClassifier(mCascadeFile.getAbsolutePath());
	} catch (Exception e) {
		Log.e("OpenCVActivity", "Error loading cascade", e);
		return null;
	}
}
