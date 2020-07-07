#ifndef OBOE_RECORDER_RECORDINGCALLBACK_H
#define OBOE_RECORDER_RECORDINGCALLBACK_H


#include <oboe/Definitions.h>
#include <oboe/AudioStream.h>
#include "SoundRecording.h"
#include "logging_macros.h"

#ifndef MODULE_NAME
#define MODULE_NAME  "RecordingCallback"
#endif


class RecordingCallback : public oboe::AudioStreamCallback {

private:
    const char* TAG = "RecordingCallback:: %s";
    SoundRecording* mSoundRecording = nullptr;

public:
    RecordingCallback() = default;

    explicit RecordingCallback(SoundRecording* recording) {
        mSoundRecording = recording;
    }

    oboe::DataCallbackResult
    onAudioReady(oboe::AudioStream *audioStream, void *audioData, int32_t numFrames);

    oboe::DataCallbackResult
    processRecordingFrames(oboe::AudioStream *audioStream, int16_t *audioData, int32_t numFrames);
};

#endif //OBOE_RECORDER_RECORDINGCALLBACK_H
