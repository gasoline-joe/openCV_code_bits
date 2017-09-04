private MatOfRect detectInImage(CascadeClassifier detector, Bitmap image) {
	MatOfRect items = new MatOfRect();
	Mat mat = new Mat();
	Utils.bitmapToMat(image, mat);
	detector.detectMultiScale(mat, items, 1.1, 3, 0, new Size(25, 25), new Size());
    return items;
}
