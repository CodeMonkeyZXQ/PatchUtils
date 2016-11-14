LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE     := ApkPatch
LOCAL_SRC_FILES  := cm_frame_patch_PatchUtils.c

LOCAL_LDLIBS     := -lz -llog

include $(BUILD_SHARED_LIBRARY)