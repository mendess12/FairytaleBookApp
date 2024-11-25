package com.yusufmendes.masalkitabim.view.detail

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.yusufmendes.masalkitabim.R
import com.yusufmendes.masalkitabim.databinding.FragmentDetailBinding
import com.yusufmendes.masalkitabim.util.downloadFromUrl
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment(R.layout.fragment_detail) {

    private lateinit var binding: FragmentDetailBinding
    private val args: DetailFragmentArgs by navArgs()
    lateinit var mAdView: AdView
    private var mediaPlayer: MediaPlayer? = null
    private var isPlaying = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailBinding.bind(view)

        adMob()

        binding.apply {
            detailScreenToolBar.toolBarNameTv.text = args.fairytale.name.toString()
            detailScreenFairytaleTv.text = args.fairytale.fairytale.toString()
            detailScreenIv.downloadFromUrl(args.fairytale.imageUrl.toString())
            detailScreenToolBar.toolBarBackIv.setOnClickListener {
                findNavController().popBackStack()
            }
            detailScreenToolBar.toolBarPlaySound.setOnClickListener {
                setupMediaPlayer(
                    args.fairytale.sound.toString(),
                    binding.detailScreenToolBar.toolBarPlaySound
                )
            }
        }
    }

    private fun adMob() {
        MobileAds.initialize(requireContext())
        mAdView = binding.adView2
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)
    }

    private fun setupMediaPlayer(url: String, playPauseButton: ImageView) {
        try {
            mediaPlayer = MediaPlayer().apply {
                setDataSource(url)
                prepareAsync()
                setOnPreparedListener {
                    playMediaPlayer(playPauseButton)
                }
            }
            playPauseButton.setOnClickListener {
                if (isPlaying) {
                    pauseMediaPlayer(playPauseButton)
                } else {
                    playMediaPlayer(playPauseButton)
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun playMediaPlayer(playPauseButton: ImageView) {
        mediaPlayer?.let {
            it.start()
            isPlaying = true
            playPauseButton.setImageResource(R.drawable.baseline_pause_24)
        }
    }

    private fun pauseMediaPlayer(playPauseButton: ImageView) {
        mediaPlayer?.let {
            it.pause()
            isPlaying = false
            playPauseButton.setImageResource(R.drawable.play_icon)
        }
    }

    override fun onPause() {
        super.onPause()
        mediaPlayer?.release()
        mediaPlayer = null
    }
}