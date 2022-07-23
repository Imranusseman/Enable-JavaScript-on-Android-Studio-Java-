
//Copy the necessário codes


//enable JavaScript
webview1.getSettings().setJavaScriptEnabled(true);
webview1.loadUrl("file:///android_asset/index.html");
//viewport
webview1.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
webview1.getSettings().setUseWideViewPort(true);
//enable JavaScript
webview1.getSettings().setLoadWithOverviewMode(true);
webview1.getSettings().setUseWideViewPort(true);
//download to sdcard
webview1.setDownloadListener(new DownloadListener() {
	public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
		DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
		String cookies = CookieManager.getInstance().getCookie(url);
		request.addRequestHeader("cookie", cookies);
		request.addRequestHeader("User-Agent", userAgent);
		request.setDescription("Downloading file...");
		request.setTitle(URLUtil.guessFileName(url, contentDisposition, mimetype));
		request.allowScanningByMediaScanner(); request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
		java.io.File aatv = new java.io.File(Environment.getExternalStorageDirectory().getPath() + "/the-path");
		if(!aatv.exists()){if (!aatv.mkdirs()){ Log.e("TravellerLog ::","Problem creating Image folder");}} request.setDestinationInExternalPublicDir("/the-path", URLUtil.guessFileName(url, contentDisposition, mimetype));
		DownloadManager manager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
		manager.enqueue(request);
		showMessage("Downloading File....");
		//Notif if success
		BroadcastReceiver onComplete = new BroadcastReceiver() {
			public void onReceive(Context ctxt, Intent intent) {
				showMessage("Download Complete!");
				unregisterReceiver(this);
			}};
		registerReceiver(onComplete, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
	}
});
startActivity(new android.content.Intent(android.app.DownloadManager.ACTION_VIEW_DOWNLOADS));
//zoom
webview1.getSettings().setDisplayZoomControls(true);
webview1.getSettings().setBuiltInZoomControls(true);
//mobile-and-desktop view
webview1.getSettings().setLoadWithOverviewMode(true); webview1.getSettings().setUseWideViewPort(true); final WebSettings webSettings = webview1.getSettings(); final String newUserAgent; newUserAgent = "Mozilla/5.0 (Android) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36"; webSettings.setUserAgentString(newUserAgent);
webview1.getSettings().setLoadWithOverviewMode(true); webview1.getSettings().setUseWideViewPort(true); final WebSettings webSettings = webview1.getSettings(); final String newUserAgent; newUserAgent = "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36"; webSettings.setUserAgentString(newUserAgent);
