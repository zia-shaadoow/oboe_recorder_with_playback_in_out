package com.sheraz.oboerecorder

import android.Manifest
import android.content.pm.PackageManager
import android.media.AudioManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.sample.audio_device.AudioDeviceListEntry
import com.sample.audio_device.AudioDeviceSpinner
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
     lateinit var recordingDeviceSpinner: AudioDeviceSpinner
     lateinit var playbackDeviceSpinner: AudioDeviceSpinner
     val AUDIO_RECORD_REQUEST = 12446
     val PERMISSIONS = arrayOf(
        Manifest.permission.RECORD_AUDIO,
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.WRITE_EXTERNAL_STORAGE
    )

    private var mFilePath = ""

    override fun onCreate(savedInstanceState: Bundle?) {

        Log.d(TAG, "onCreate: ")

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recordingDeviceSpinner = findViewById(R.id.recording_devices_spinner)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            recordingDeviceSpinner.setDirectionType(AudioManager.GET_DEVICES_INPUTS)
            recordingDeviceSpinner.setOnItemSelectedListener(object : OnItemSelectedListener {
                override fun onItemSelected(
                    adapterView: AdapterView<*>?,
                    view: View,
                    i: Int,
                    l: Long
                ) {
                    AudioEngine.setRecordingDeviceId(getRecordingDeviceId())
                }

                override fun onNothingSelected(adapterView: AdapterView<*>?) {
                    // Do nothing
                }
            })
        }

        playbackDeviceSpinner = findViewById(R.id.playback_devices_spinner)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            playbackDeviceSpinner.setDirectionType(AudioManager.GET_DEVICES_OUTPUTS)
            playbackDeviceSpinner.setOnItemSelectedListener(object : OnItemSelectedListener {
                override fun onItemSelected(
                    adapterView: AdapterView<*>?,
                    view: View,
                    i: Int,
                    l: Long
                ) {
                    AudioEngine.setPlaybackDeviceId(getPlaybackDeviceId())
                }

                override fun onNothingSelected(adapterView: AdapterView<*>?) {
                    // Do nothing
                }
            })
        }

        AudioEngine.create()
        initUI()
        checkRecordAudioPermission()

    }

    override fun onResume() {

        Log.d(TAG, "onResume: ")
        super.onResume()
    }

    override fun onDestroy() {

        Log.d(TAG, "onDestroy: ")
        super.onDestroy()
        AudioEngine.delete()

    }

    private fun initUI() {

        Log.d(TAG, "initUI: ")

        btnStartRecording.setOnClickListener {

            if (!checkRecordAudioPermission()) {
                return@setOnClickListener
            }

            Log.d(TAG, "btnStartRecording.onClick: ")
            AudioEngine.startRecording()
        }

        btnStopRecording.setOnClickListener {

            if (!checkRecordAudioPermission()) {
                return@setOnClickListener
            }

            Log.d(TAG, "btnStopRecording.onClick: ")
            AudioEngine.stopRecording()
        }

        btnStartPlayingFromRecording.setOnClickListener {

            if (!checkRecordAudioPermission()) {
                return@setOnClickListener
            }

            Log.d(TAG, "btnStartPlaying.onClick: ")
            AudioEngine.startPlayingRecordedStream()
        }

        btnStopPlayingFromRecording.setOnClickListener {

            if (!checkRecordAudioPermission()) {
                return@setOnClickListener
            }

            Log.d(TAG, "btnStopPlaying.onClick: ")
            AudioEngine.stopPlayingRecordedStream()
        }

        btnWriteToFile.setOnClickListener {

            if (!checkRecordAudioPermission()) {
                return@setOnClickListener
            }

            Log.d(TAG, "btnWriteToFile.onClick: ")
            mFilePath = Utils.getAudioRecordingFilePath(this)
            AudioEngine.writeFile(mFilePath)
        }

        btnStartPlayFromFile.setOnClickListener {

            if (!checkRecordAudioPermission()) {
                return@setOnClickListener
            }

            if (mFilePath.isEmpty()) return@setOnClickListener

            Log.d(TAG, "btnStartPlayFromFile.onClick: ")
            AudioEngine.startPlayingFromFile(mFilePath)
        }

        btnStopPlayFromFile.setOnClickListener {

            if (!checkRecordAudioPermission()) {
                return@setOnClickListener
            }

            if (mFilePath.isEmpty()) return@setOnClickListener

            Log.d(TAG, "btnStopPlayFromFile.onClick: ")
            AudioEngine.stopPlayingFromFile()
        }

        btnReset.setOnClickListener {

            if (!checkRecordAudioPermission()) {
                return@setOnClickListener
            }

            Log.v(TAG, "btnReset.onClick: Deleting AudioEngine instance")
            AudioEngine.delete()
            Log.v(TAG, "btnReset.onClick: Creating new AudioEngine instance")
            if (AudioEngine.create()) {
                Log.i(TAG, "btnReset.OnClick: New AudioEngine instance has been created")
            } else {
                Log.e(TAG, "btnReset.OnClick: Something went wrong, please check logcat for errors")
            }
        }

    }

    private fun checkRecordAudioPermission(): Boolean {

        Log.d(TAG, "checkRecordAudioPermission: ")

        val isRecordingAllowed = isRecordPermissionGranted()
        Log.i(TAG, "checkRecordAudioPermission: $isRecordingAllowed")

        if (!isRecordingAllowed) {

            requestRecordPermission()
            disableControls()

        } else {

            enableControls()

        }

        return isRecordingAllowed
    }

    private fun isRecordPermissionGranted(): Boolean {

        val permissionStatus = (ActivityCompat
            .checkSelfPermission(
                this,
                Manifest.permission.RECORD_AUDIO
            ) == PackageManager.PERMISSION_GRANTED) &&
                (ActivityCompat
                    .checkSelfPermission(
                        this,
                        Manifest.permission.READ_EXTERNAL_STORAGE
                    ) == PackageManager.PERMISSION_GRANTED) &&
                (ActivityCompat
                    .checkSelfPermission(
                        this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                    ) == PackageManager.PERMISSION_GRANTED)

        Log.d(TAG, "isRecordPermissionGranted: $permissionStatus")

        return permissionStatus
    }

    private fun requestRecordPermission() {

        Log.d(TAG, "requestRecordPermission: ")
        ActivityCompat.requestPermissions(this, PERMISSIONS, AUDIO_RECORD_REQUEST)

    }

    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<String>,
        grantResults: IntArray
    ) {

        Log.d(TAG, "onRequestPermissionsResult: requestCode = $requestCode, ")
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (AUDIO_RECORD_REQUEST != requestCode) {
            return
        }

        // handle the case when user clicks on "Don't ask again"
        // inside permission dialog
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            if (!shouldShowRequestPermissionRationale(PERMISSIONS[0]) ||
                !shouldShowRequestPermissionRationale(PERMISSIONS[1]) ||
                !shouldShowRequestPermissionRationale(PERMISSIONS[2])) {

                Log.w(TAG, "onRequestPermissionsResult: Some Permission(s) not granted, show error dialog.")
                Utils.showPermissionsErrorDialog(this)
                return

            }

        }

        if (!isRecordPermissionGranted()) {

            Log.w(TAG, "onRequestPermissionsResult: Some Permission(s) not granted, disable controls")
            disableControls()

        } else {

            Log.i(TAG, "onRequestPermissionsResult: ALL Permissions granted, continue with enableControls")
            enableControls()

        }
    }

    private fun enableControls() {

        Log.d(TAG, "enableControls: ")

        tvStatus.text = ""
        btnStartPlayingFromRecording.isEnabled = true
        btnStartRecording.isEnabled = true
        btnStopPlayingFromRecording.isEnabled = true
        btnStopRecording.isEnabled = true
        btnWriteToFile.isEnabled = true
        btnStartPlayFromFile.isEnabled = true
        btnStopPlayFromFile.isEnabled = true
        btnReset.isEnabled = true

    }

    private fun disableControls() {

        Log.d(TAG, "disableControls: ")

        tvStatus.text = getString(R.string.need_record_audio_permission)
        btnStartPlayingFromRecording.isEnabled = false
        btnStartRecording.isEnabled = false
        btnStopPlayingFromRecording.isEnabled = false
        btnStopRecording.isEnabled = false
        btnWriteToFile.isEnabled = false
        btnStartPlayFromFile.isEnabled = false
        btnStopPlayFromFile.isEnabled = false
        btnReset.isEnabled = false

    }


    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }

    private fun getRecordingDeviceId(): Int {
        return (recordingDeviceSpinner.selectedItem as AudioDeviceListEntry).getId()
    }

    private fun getPlaybackDeviceId(): Int {
        return (playbackDeviceSpinner.selectedItem as AudioDeviceListEntry).getId()
    }

}
