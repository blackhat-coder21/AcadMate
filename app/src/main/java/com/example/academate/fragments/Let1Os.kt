package com.example.academate

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import com.github.barteksc.pdfviewer.PDFView
import java.io.BufferedInputStream
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class Let1Os : AppCompatActivity() {

    lateinit var pdfView: PDFView
    var pdfUrl = "https://firebasestorage.googleapis.com/v0/b/acadmate-f1d72.appspot.com/o/" +
            "Operating%20System%2Flect1.pdf?alt=media&token=adbbed7b-252b-44b7-ad38-84303df66b51"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lect1_os)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        supportActionBar?.hide()

        pdfView = findViewById(R.id.idPDFView)
        RetrievePDFFromURL(pdfView).execute(pdfUrl)
    }

    class RetrievePDFFromURL(pdfView: PDFView) :
        AsyncTask<String, Void, InputStream>() {
        val mypdfView: PDFView = pdfView
        override fun doInBackground(vararg params: String?): InputStream? {
            var inputStream: InputStream? = null
            try {
                val url = URL(params.get(0))
                val urlConnection: HttpURLConnection = url.openConnection() as HttpsURLConnection
                if (urlConnection.responseCode == 200) {
                    inputStream = BufferedInputStream(urlConnection.inputStream)
                }
            }
            catch (e: Exception) {
                e.printStackTrace()
                return null;
            }
            return inputStream;
        }
        override fun onPostExecute(result: InputStream?) {
            mypdfView.fromStream(result).load()
        }
    }
}