package com.example.academate.fragments

import android.app.DownloadManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.academate.Let1Os
import com.example.academate.R


class MaterialOOPFragment : Fragment() {

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_material_o_o_p, container, false)

        val download: ImageView = view.findViewById(R.id.down)
        download.setOnClickListener{
            val url = "https://firebasestorage.googleapis.com/v0/b/acadmate-f1d72.appspot.com/o/" +
                    "Operating%20System%2Flect1.pdf?alt=media&token=adbbed7b-252b-44b7-ad38-84303df66b51" // Replace with your PDF file URL
            downloadPDFFile(url)
        }

        val lect1: ImageView = view.findViewById(R.id.l1)
        lect1.setOnClickListener {
            val intent = Intent(requireContext(), Let1Os::class.java)
            startActivity(intent)
        }
        return view
    }

    private fun downloadPDFFile(url: String) {
        val downloadManager = requireContext().getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager

        val request = DownloadManager.Request(Uri.parse(url))
            .setTitle("OS PDF Download") // Set the title of the download notification
            .setDescription("Downloading") // Set the description of the download notification
            .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
            .setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "OSLecture.pdf") // Set the destination directory and filename
        downloadManager.enqueue(request)
    }
}